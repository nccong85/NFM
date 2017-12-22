/*-----------------------------------------------------------------------------
  common-plugin.js
 -----------------------------------------------------------------------------*/

/******************************************************************************
 * プラグイン名 : dialog
 * 機能概要     : ダイアログを表示します。
 *                ダイアログの幅を指定する場合はdata-widthを設定してください。
 *                  例) <div class="modal hide" data-width="1000px">
 * 引数         : なし
 * オプション   : keaboard : true:Escキーでダイアログを閉じる false:閉じない
 * メソッド     : close : ダイアログを閉じる
 ******************************************************************************/
(function($) {

    // ダイアログのz-index
    var _dialogZIndex = 1050;

    // ダイアログの位置および幅調整
    function _adjustDialog(dialog, width) {

        if($(window).width() > 767) {
            dialog.css({
                "width": width
            });
            var top = 0;
            if (dialog.height() > $(window).height()) {
                top = (dialog.height() - $(window).height()) / 2 + $.globalProperties.plugin.dialog.topAdjustValue;
            }
            dialog.css({
                "margin-top": function() { return $(window).scrollTop() - (dialog.height() / 2) + top;},
                "margin-left": function() { return -($(this).width() / 2);}
            });
        } else {
            dialog.css({
                "width": "auto",
                "margin-top": 0,
                "margin-left": 0
            });
        }
    }

    // プラグイン定義
    $.fn.dialog = function(options) {

        var dialog = this;

        if (typeof options == 'string') {

            // メソッド

            // 調整
            if (options == "close") {
                dialog.modal("hide");
            } else {
                return this;
            }

        } else {

            // オプションのデフォルト値を設定する
            options = jQuery.extend( {
                keyboard: $.globalProperties.plugin.dialog.keyboard
            }, options);

            // Escキーで閉じる機能を使用する場合はtabindexを設定する
            if (options.keyboard) {
                dialog.attr("tabindex", "-1");
            }
            // ダイアログのz-indexを設定する(開くたびにインクリメントする)
            dialog.css("z-index", _dialogZIndex++);
            // ダイアログの幅を取得
            var width = dialog.data("width");
            if (isEmpty(width)) {
                width = "540px"; // Bootstrapのデフォルトの幅
            }
            // Bootstrapの設定でボディ部の高さが最大400pxなのを変更する
            //$(".modal-body", dialog).css("max-height", 1000);
            // スクロールバーの位置を退避する
            var scrollTop = $(window).scrollTop();
            var oldFocus = jQuery().modal.Constructor.prototype.enforceFocus;
            jQuery().modal.Constructor.prototype.enforceFocus = function(){};
            // モーダルを開く
            dialog.modal({backdrop: "static", keyboard: options.keyboard});
            if ((dialog.attr("id") != "info-msg-box")
                && (dialog.attr("id") != "error-msg-box")
                && (dialog.attr("id") != "confirm-msg-box")
                && (dialog.attr("id") != "custom-msg-box")) {
                dialog.draggable({handle: ".modal-header, .modal-footer"});
            }
            // enforceFocus 機能を復元する
            jQuery().modal.Constructor.prototype.enforceFocus = oldFocus;
            // 複数子画面を立ち上げたとき、一番手前の子画面以外は操作させない
            $(".modal-backdrop:last").css("z-index", _dialogZIndex - 2);
            // 変更されたスクロールバーの位置を戻す
            $(window).scrollTop(scrollTop);
            // ダイアログの位置・幅を調整する
            //_adjustDialog(dialog, width, scrollTop);
            // 固定テーブルのヘッダ幅調整
            $("div.table-fixed-list", dialog).fixedTable("adjust");

            // Windowの幅が変更された場合、ダイアログの位置・幅を調整する
            $(window).resize(function(event) {
                _adjustDialog(dialog, width);
            });
        }

        return this;
    };
})(jQuery);

/******************************************************************************
 * プラグイン名 : infoMsgBox
 * 機能概要     : 情報メッセージボックスを表示します。
 * 引数         : message        : メッセージ
 *                callbackOk     : OKボタン押下時のコールバック関数
 * オプション   : なし
 ******************************************************************************/
(function($) {

    // 情報メッセージボックス
    var _infoMsgBox = $("<div class='modal' id='info-msg-box' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
                    + "<div class='modal-dialog'>"
        			+ "<div class='modal-content'>"
        			+ "<div class='modal-header'>"
                    + $.globalProperties.plugin.infoMsgBox.title
                    + "</div>"
                    + "<div class='modal-body'><p class='message text-info'></p></div>"
                    + "<div class='modal-footer'>"
                    + "<button type='button' class='btn btn-default ok'>OK</button>"
                    + "</div>"
        			+ "</div>"
        			+ "</div>"
                    + "</div>");

    // プラグイン定義
    $.infoMsgBox = function(message, callbackOk) {
        $(".message", _infoMsgBox)
            .html(message);
        $(".ok", _infoMsgBox)
            .unbind("click")
            .click(function() {
                _infoMsgBox.dialog("close");
                if (isNotEmpty(callbackOk)) { callbackOk(); }
            });
        _infoMsgBox.dialog();
    }
})(jQuery);

/******************************************************************************
 * プラグイン名 : errorMsgBox
 * 機能概要     : エラーメッセージボックスを表示します。
 * 引数         : message        : メッセージ
 *                callbackOk     : OKボタン押下時のコールバック関数
 * オプション   : なし
 ******************************************************************************/
(function($) {

    // エラーメッセージボックス
    var _errorMsgBox = $("<div class='modal' id='error-msg-box' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
                    + "<div class='modal-dialog'>"
        			+ "<div class='modal-content'>"
        			+ "<div class='modal-header'>"
                    + $.globalProperties.plugin.errorMsgBox.title
        			+ "</div>"
                    + "<div class='modal-body'><p class='message text-error'></p></div>"
                    + "<div class='modal-footer'>"
                    + "<button type='button' class='btn btn-default ok'>OK</button>"
                    + "</div>"
        			+ "</div>"
        			+ "</div>"
                    + "</div>");

    // プラグイン定義
    $.errorMsgBox = function(message, callbackOk) {
        $(".message", _errorMsgBox)
            .html(message);
        $(".ok", _errorMsgBox)
            .unbind("click")
            .click(function() {
                _errorMsgBox.dialog("close");
                if (isNotEmpty(callbackOk)) { callbackOk(); }
            });
        _errorMsgBox.dialog();
    }
})(jQuery);

/******************************************************************************
 * プラグイン名 : confirmMsgBox
 * 機能概要     : 確認メッセージボックスを表示します。
 * 引数         : message        : メッセージ
 *                callbackOk     : OKボタン押下時のコールバック関数
 *                callbackCancel : キャンセルボタン押下時のコールバック関数
 * オプション   : なし
 ******************************************************************************/
(function($) {

    // 確認メッセージボックス
    var _confirmMsgBox = $("<div class='modal' id='confirm-msg-box'　tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
                    + "<div class='modal-dialog'>"
        			+ "<div class='modal-content'>"
        			+ "<div class='modal-header'>"
                    + $.globalProperties.plugin.confirmMsgBox.title
                    + "</div>"
                    + "<div class='modal-body'><p class='message'></p></div>"
                    + "<div class='modal-footer'>"
                    + "<a href='javascript:void(0);' class='btn ok btn-default'>OK</a>"
                    + "<a href='javascript:void(0);' class='btn cancel btn-default'>キャンセル</a>"
                    + "</div>"
        			+ "</div>"
        			+ "</div>"
                    + "</div>");

    // プラグイン定義
    $.confirmMsgBox = function(message, callbackOk, callbackCancel) {
        $(".message", _confirmMsgBox)
            .html(message);
        $(".ok", _confirmMsgBox)
            .unbind("click")
            .click(function() {
                _confirmMsgBox.dialog("close");
                if (isNotEmpty(callbackOk)) { callbackOk(); }
            });
        $(".cancel", _confirmMsgBox)
            .unbind("click")
            .click(function() {
                _confirmMsgBox.dialog("close");
                if (isNotEmpty(callbackCancel)) { callbackCancel(); }
            });
        _confirmMsgBox.dialog();
    }
})(jQuery);

/******************************************************************************
 * プラグイン名 : customMsgBox
 * 機能概要     : カスタムメッセージボックスを表示します。
 * 引数         : type    : タイプ("info","error","confirm")
 *                message : メッセージ
 *                buttons : ボタン名称とコールバック関数の連想配列
 *                           例) { "OK": function() { ... }, 
 *                                 "キャンセル": function() { ... } }
 * オプション   : なし
 ******************************************************************************/
(function($) {

    // カスタムメッセージボックス
    var _customMsgBox = $("<div class='modal' id='custom-msg-box'>"
                    + "<div class='modal-header'><h4></h4></div>"
                    + "<div class='modal-body'><p class='message'></p></div>"
                    + "<div class='modal-footer'>"
                    + "</div>"
                    + "</div>");

    // プラグイン定義
    $.customMsgBox = function(type, message, buttons) {

        $(".modal-body p", _customMsgBox).removeClass("text-info").removeClass("text-error");

        if (type == "info") {
            $(".modal-header h4", _customMsgBox).html($.globalProperties.plugin.infoMsgBox.title);
            $(".modal-body p", _customMsgBox).addClass("text-info");
        } else if (type == "error") {
            $(".modal-header h4", _customMsgBox).html($.globalProperties.plugin.errorMsgBox.title);
            $(".modal-body p", _customMsgBox).addClass("text-error");
        } else if (type == "confirm") {
            $(".modal-header h4", _customMsgBox).html($.globalProperties.plugin.confirmMsgBox.title);
        } else {
            return false;
        }

        $(".message", _customMsgBox).html(message);
        $(".modal-footer a", _customMsgBox).remove();
        
        for (var name in buttons) {
            var callback = buttons[name];
            var button = $("<a href='javascript:void(0);' class='btn'></a>");
            
            button.html(name);
            button.data("callback", callback);
            button.click(function() {
                _customMsgBox.dialog("close");
                var callback = $(this).data("callback");
                if (isNotEmpty(callback)) { callback(); }
            });
            
            $(".modal-footer", _customMsgBox).append(button);
        }

        _customMsgBox.dialog();
    }
})(jQuery);

/******************************************************************************
 * プラグイン名 : dateTextbox
 * 機能概要     : 日付入力のテキストボックスを設定します。
 *                テキストボックスにフォーカスがあたると入力値を"yyyyMMdd"形式に
 *                整形します。フォーカスが外れると"yyyy/MM/dd"形式に整形します。
 *                日付のフォーマットはglobalPropertiesで変更可能です。
 *                Datepicker for Bootstrapの機能を利用したDatePickerを追加します。
 * 引数         : なし
 * オプション   : datepicker : true:DatePickerを使用する false:使用しない
 ******************************************************************************/
(function($) {

    // 日付フォーマット
    var _dateFormat = $.globalProperties.screen.dateTextbox.dateFormat;
    // テキストボックスフォーカス時の日付フォーマット
    var _focusDateFormat = $.globalProperties.screen.dateTextbox.focusDateFormat;
    // Datepicker起動アイコン
    var _datepickerIcon = $.globalProperties.screen.dateTextbox.datepickerIcon;

    // プラグイン定義
    $.fn.dateTextbox = function(options) {

        // オプションのデフォルト値を設定する
        options = jQuery.extend( {
            datepicker: $.globalProperties.screen.dateTextbox.datepicker
        }, options);

        this.each(function() {

            if (!$(this).hasClass("applied-date-textbox")) {

                // 最大文字数を設定し、テキストボックスの設定を行う
                $(this).attr("maxlength", _dateFormat.length);
                $(this).addClass("input-small");

                // 現在の入力値のフォーマットを変換する
                $(this).val(convertDateFormat($(this).val(), _focusDateFormat, _dateFormat));

                if (!$(this).attr("readonly") && !$(this).attr("disabled")) {
                    // フォーカス時に日付フォーマットを変換する
                    $(this).focus(function() {
                        $(this).val(convertDateFormat($(this).val(), _dateFormat, _focusDateFormat));
                    });
                    // フォーカスが外れたときに日付フォーマットを変換する
                    $(this).blur(function() {
                        $(this).val(convertDateFormat($(this).val(), _focusDateFormat, _dateFormat));
                    });
                    // ダブルクリックでシステム日付を設定する
                    $(this).dblclick(function() {
                        if (isEmpty($(this).val())) {
                            $(this).val(getSystemDate(_focusDateFormat));
                        }
                    });
                }

                // Datepickerの設定
                if (options.datepicker == true && !$(this).attr("readonly") && !$(this).attr("disabled") ) {
                    // テキストボックスの後ろにアイコンを追加する
                    var icon = $(_datepickerIcon);
                    $(this).after(icon);
                    // アイコンがクリックされたときにdatepickerを表示する
                    var dateTextbox = $(this);
                    icon.click(function() {
                        dateTextbox.datepicker({
                            onClose: function(dateText, inst) { dateTextbox.datepicker("destroy"); }
                        }).datepicker("show");
                    });
                }

                $(this).addClass("applied-date-textbox");
            }
        });

        return this;
    };
})(jQuery);

/******************************************************************************
 * プラグイン名 : numberTextbox
 * 機能概要     : 数値入力のテキストボックスを設定します。
 *                テキストボックスにフォーカルがあたると入力値のカンマを除去します。
 *                フォーカスが外れるとカンマを付与します。
 *                小数点以下の桁数を揃えたい場合はテキストボックスにdata-decimal
 *                属性を追加して小数点以下の桁数を指定してください。
 *                  例) <input type="text" class="number" data-decimal="2" />
 * 引数         : なし
 * オプション   : なし
 ******************************************************************************/
(function($) {

    // プラグイン定義
    $.fn.numberTextbox = function() {

        this.each(function() {

            var numberFormat = "###,###,###,###,###,###,###";
            var decimal = $(this).data("decimal") - 0;

            // 小数点以下の桁数が指定された場合はフォーマットを変更する
            if (decimal > 0) {
                numberFormat += "." + padLeft("", decimal, "0");
            }

            if (!$(this).hasClass("applied-number-textbox")) {

                // 現在の入力値のフォーマットを変換する
                if (isNotEmpty($(this).val())) {
                    $(this).val(formatNumber($(this).val(), numberFormat));
                }

                if (!$(this).attr("readonly") && !$(this).attr("disabled")) {
                    // フォーカス時にフォーマットを変換する
                    $(this).focus(function() {
                        if (isNotEmpty($(this).val())) {
                            $(this).val(parseNumber($(this).val()));
                        }
                    });
                    // フォーカスが外れたときにフォーマットを変換する
                    $(this).blur(function() {
                        if (isNotEmpty($(this).val())) {
                            $(this).val(formatNumber($(this).val(), numberFormat));
                        }
                    });
                }

                $(this).addClass("applied-number-textbox");
            }
        });

        return this;
    };
})(jQuery);

/******************************************************************************
 * プラグイン名 : fixedTable
 * 機能概要     : テーブルのボディ部の高さを固定します。
 *                また、ヘッダとボディを分割して横スクロールを同期します。
 *                ボディ部の高さはdata-heightで設定してください。
 *                  例) <div class="table-fixed-list" data-height="250px">
 *                        <table class="table-list"> ... </table>
 *                      </div>
 * 引数         : なし
 * オプション   : なし
 * メソッド     : adjust : ヘッダの幅を調整する
 ******************************************************************************/
(function($) {

    // ヘッダの幅をスクロールバー分だけ短くする調整値
    var _adjustHeaderWidth = 17;

    // プラグイン定義
    $.fn.fixedTable = function(options) {

        // 初期化処理
        this.each(function() {

            if (typeof options == 'string') {

                // メソッド

                // 調整
                if (options == "adjust") {
                    var headerDiv = $("table.table-fixed-list-header", $(this)).parent();
                    var bodyDiv = $("table.table-fixed-list-body", $(this)).parent();
                    headerDiv.width(bodyDiv.width() - _adjustHeaderWidth);
                } else {
                    return this;
                }

            } else {

                if (!$(this).hasClass("applied-fixed-table")) {

                    var height = $(this).data("height");

                    // thead,tbody,colgroupを抽出
                    var table = $(this).children("table.table-list");
                    var header = $("thead", table);
                    var body = $("tbody", table);
                    var colgroup = $("colgroup", table);

                    // ヘッダのみのテーブルを生成
                    var headerTable = $("<table>");
                    headerTable.addClass("table-list table-fixed-list-header table table-bordered table-condensed")
                        .append(colgroup.clone())
                        .append(header);
                    // ボディのみのテーブルを作成
                    var bodyTable = $("<table>");
                    bodyTable.addClass("table-list table-fixed-list-body table table-bordered table-condensed table-striped")
                        .append(colgroup.clone())
                        .append(body);

                    // 現在の一覧テーブルのdivにヘッダのdivを追加する
                    var headerDiv = $("<div>")
                        .css("overflow-x", "hidden")
                        .css("clear", "both")
                        .append(headerTable);
                    // 縦スクロールバーの分だけ幅を短くする
                    headerDiv.width($(this).width() - _adjustHeaderWidth);
                    table.before(headerDiv);
                    // 現在の一覧テーブルのdivにボディのdivを追加する
                    var bodyDiv = $("<div>")
                        .addClass("bottom-space")
                        .css("overflow-x", "auto")
                        .css("overflow-y", "scroll")
                        .css("width", "100%")
                        .css("height", height)
                        .append(bodyTable);
                    table.before(bodyDiv);

                    // ヘッダとボディの横スクロールバーを同期させる
                    bodyDiv.syncScrollX(headerDiv);

                    // 元のテーブルを削除
                    table.remove();

                    // Windowの幅が変更された場合、ヘッダの幅を調整する
                    $(window).resize(function(event) {
                        headerDiv.width(bodyDiv.width() - _adjustHeaderWidth);
                    });

                    $(this).addClass("applied-fixed-table");
                }
            }

        });

        return this;
    }
})(jQuery);

/******************************************************************************
 * プラグイン名 : stripeTable
 * 機能概要     : テーブルをストライプにするための設定を行います。IE対応です。
 * 引数         : なし
 * オプション   : なし
 ******************************************************************************/
(function($) {

    $.fn.stripeTable = function() {
        $("table.table-striped tbody tr:nth-child(odd) td", this).addClass("odd");
    };
})(jQuery);

/******************************************************************************
 * プラグイン名 : clearInputValue
 * 機能概要     : 入力値をクリアします。
 *                指定されたオブジェクトおよびオブジェクトの子孫要素の入力値を
 *                クリアします。
 * 引数         : なし
 * オプション   : なし
 ******************************************************************************/
(function($) {

    // 入力値のクリア
    function _clear(obj) {

        if (obj.length == 0) {
            return;
        }

        obj.each(function() {

            if ($(this).is(":text,:password,:file,:hidden,textarea")) {

                $(this).val("");

                if ($(this).is(":file")) {
                    // IEの場合、ファイルのvalueをクリアすることができない
                    // IEでファイルのクリアを行いたい場合はファイルのinputタグをspanタグで囲むこと
                    //   例) <span><input type="file" name="xxx"></span>
                    $(this).parent("span").each(function() {
                        var tmp = $(this).html();
                        $(this).html(tmp);
                    });
                }

            } else if ($(this).is(":checkbox,:radio")) {

                $(this).attr("checked", false);

            } else if ($(this).is("select")) {

                if (!$(this).is("select[multiple]")) {
                    $(this).children("option:first").attr("selected", true);
                } else {
                    $(this).children("option").attr("selected", false);
                }

            } else {
                _clear($(":input", $(this)));
            }
        });
    }

    // プラグイン定義
    $.fn.clearInputValue = function() {

        _clear(this);

        return this;
    };
})(jQuery);

/******************************************************************************
 * プラグイン名 : toggleCheckbox
 * 機能概要     : チェックボックスをONにした場合、対象のチェックボックスを全て
 *                ONにします。OFFにした場合は全てOFFにします。
 * 引数         : checkboxes : 変更対象のチェックボックスのjQueryオブジェクト
 * オプション   : なし
 ******************************************************************************/
(function($) {

    $.fn.toggleCheckbox = function(checkboxes) {

        // 切り替え対象チェックボックスの確認
        if (isEmpty(checkboxes)) {
            return false;
        }

        this.each(function() {
            $(this).click(function() {
                checkboxes.attr("checked", $(this).is(":checked"));
            });
        });

        return this;
    };
})(jQuery);

/******************************************************************************
 * プラグイン名 : syncScrollX
 * 機能概要     : 2つの横スクロールバーのスクロール位置を同期します。
 * 引数         : sync : 同期対象のdivのjQueryオブジェクト
 * オプション   : なし
 ******************************************************************************/
(function($) {

    $.fn.syncScrollX = function(sync) {

        // 同期対象の確認
        if (isEmpty(sync)) {
            return null;
        }

        var scroll = this;

        // scrollイベントに対する処理
        this.scroll(function() {

            // スクロール位置を取得する
            var scrollLeft = scroll.scrollLeft();

            // スクロールバーのスクロール位置を同期する
            sync.each(function() {

                $(this).scrollLeft(scrollLeft);
            });
        });

        // ウィンドウのリサイズイベント時にスクロールバーの位置を初期化する
        $(window).resize(function(event) {
            scroll.scrollLeft(0);
        });

        return this;
    };
})(jQuery);

/******************************************************************************
 * プラグイン名 : clickByEnterKey
 * 機能概要     : 指定された範囲内の入力部品でEnterキーが押下された場合、特定の
 *                ボタンをクリックします。
 *                クリックされるボタンのクラスに"click-by-enter"を設定してください。
 * 引数         : なし
 * オプション   : なし
 ******************************************************************************/
(function($) {

    $.fn.clickByEnterKey = function() {

        this.each(function() {
            
            var button = $(this).find(".click-by-enter");
            $(this).find(":input").each(function() {
                if (!($(this).hasClass("click-by-enter")) && !($(this)[0].nodeName == "button")) {
                    $(this).keyup(function(event) {
                        if (event.keyCode == 13) {
                            button.click();
                        }
                    });
                }
            });
        });

        return this;
    };
})(jQuery);

/******************************************************************************
 * プラグイン名 : globalProperties
 * 機能概要     : GlobalPropertiesの値を設定します。
 *                引数の設定値に設定した値のみが上書きされます。
 * 引数         : prop : 設定値
 * オプション   : なし
 ******************************************************************************/
(function($) {

    $.fn.globalProperties = function(prop) {
        $.extend(true, $.globalProperties, prop);
    };
})(jQuery);
