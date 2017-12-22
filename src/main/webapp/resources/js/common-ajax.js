/*-----------------------------------------------------------------------------
  common-ajax.js
 -----------------------------------------------------------------------------*/

/******************************************************************************
 * 関数名   : ajax
 * 機能概要 : ajaxによる非同期通信を行います。
 * 引数     : url         : URL
 *            data        : リクエストパラメータ(Mapまたはクエリー文字列)
 *            callback    : 正常終了時のコールバック関数
 *            isBlockPage : true: 通信中はページをブロックする false: しない
 * 戻り値   : なし
 ******************************************************************************/
function ajax(url, data, callback, isBlockPage) {

    // 非同期通信の実行
    _ajax(url, data, callback, isBlockPage)
}

/******************************************************************************
 * 関数名   : ajaxForForm
 * 機能概要 : ajaxによる非同期通信を行います。
 * 引数     : form           : フォームのIDまたはフォームのjQueryオブジェクト
 *            callback       : 正常終了時のコールバック関数
 *            isBlockPage    : true: 通信中はページをブロックする false: しない
 *            options.action : アクション
 *            options.op     : オペレーション識別子
 *            options.params : 追加パラメータ(Map)
 * 戻り値   : なし
 ******************************************************************************/
function ajaxForForm(form, callback, isBlockPage, options) {

    // オプションのデフォルト値を設定する
    options = $.extend({
        action: "",
        op: "",
        params: null
    }, options);

    // フォームの設定
    var formObj = _setForm(form, options.action, options.op, options.params);

    // 非同期通信の実行
    _ajax(formObj.attr("action"), formObj.serialize(), callback, isBlockPage)
}

/******************************************************************************
 * 関数名   : _ajax
 * 機能概要 : ajaxによる非同期通信を行います。
 * 引数     : url         : URL
 *            data        : リクエストパラメータ(Mapまたはクエリー文字列)
 *            callback    : 正常終了時のコールバック関数
 *            isBlockPage : true: 通信中はページをブロックする false: しない
 * 戻り値   : なし
 ******************************************************************************/
function _ajax(url, data, callback, isBlockPage) {

    // isBlockPageが指定されなかった場合の対処
    if (isBlockPage != true && isBlockPage != false) {
        isBlockPage = true;
    }

    // ページのブロック
    if (isBlockPage) {
        blockPage();
    }

    // 非同期通信の実行
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType: "json",
        timeout: $.globalProperties.ajax.ajaxTimeout,
        success: function(json, textStatus, XMLHttpRequest) {
            if (json.status == "0") {
                if (isNotEmpty(callback)) {
                    callback(json);
                }
            } else if (json.status == "1") {
                $.globalProperties.msgBox.error(json.errorMessage);
            } else {
                $.globalProperties.common.systemError(textStatus);
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            if (textStatus == "timeout") {
                // タイムアウトの場合
                $.globalProperties.msgBox.error($.globalProperties.ajax.ajaxTimeoutMessage);
            } else {
                $.globalProperties.common.systemError(textStatus);
            }
        },
        complete: function(XMLHttpRequest, textStatus) {
            // ページのブロック解除
            if (isBlockPage) {
                unblockPage();
            }
        }
    });
}

/******************************************************************************
 * 関数名   : loadPage
 * 機能概要 : ページを読み込みます。
 * 引数     : obj         : 読み込んだページを追加するjQueryオブジェクト
 *            url         : URL
 *            data        : リクエストパラメータ(Mapまたはクエリー文字列)
 *            callback    : 正常終了時のコールバック関数
 *            isBlockPage : true: 通信中はページをブロックする false: しない
 * 戻り値   : なし
 ******************************************************************************/
function loadPage(obj, url, data, callback, isBlockPage) {

    // ページの読み込み
    _loadPage(obj, url, data, callback, isBlockPage);
};

/******************************************************************************
 * 関数名   : loadPageForForm
 * 機能概要 : ページを読み込みます。
 * 引数     : obj            : 読み込んだページを追加するjQueryオブジェクト
 *            form           : フォームのIDまたはフォームのjQueryオブジェクト
 *            callback       : 正常終了時のコールバック関数
 *            isBlockPage    : true: 通信中はページをブロックする false: しない
 *            options.action : アクション
 *            options.op     : オペレーション識別子
 *            options.params : 追加パラメータ(Map)
 * 戻り値   : なし
 ******************************************************************************/
function loadPageForForm(obj, form, callback, isBlockPage, options) {

    // オプションのデフォルト値を設定する
    options = $.extend({
        action: "",
        op: "",
        params: null
    }, options);

    // フォームの設定
    var formObj = _setForm(form, options.action, options.op, options.params);

    // ページの読み込み
    _loadPage(obj, formObj.attr("action"), formObj.serialize(), callback, isBlockPage);
};

/******************************************************************************
 * 関数名   : _loadPage
 * 機能概要 : ページを読み込みます。
 * 引数     : obj         : 読み込んだページを追加するjQueryオブジェクト
 *            url         : URL
 *            data        : リクエストパラメータ(Mapまたはクエリー文字列)
 *            callback    : 正常終了時のコールバック関数
 *            isBlockPage : true: 通信中はページをブロックする false: しない
 * 戻り値   : なし
 ******************************************************************************/
function _loadPage(obj, url, data, callback, isBlockPage) {

    // isBlockPageが指定されなかった場合の対処
    if (isBlockPage != true && isBlockPage != false) {
        isBlockPage = true;
    }

    // ページのブロック
    if (isBlockPage) {
        blockPage();
    }

    // 非同期通信の実行
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType: "html",
        timeout: $.globalProperties.ajax.ajaxTimeout,
        success: function(html, textStatus, XMLHttpRequest) {
            var json = parseJSON(html);
            if (isNotEmpty(json)){
                // レスポンスがJSON形式だった場合はエラーメッセージを表示する
                if (json.status == "1") {
                    obj.html("");
                    $.globalProperties.msgBox.error(json.errorMessage);
                } else {
                    $.globalProperties.common.systemError(textStatus);
                }
            } else {
                // レスポンスがJSON形式でなかった場
                obj.html(html);
                if (isNotEmpty(callback)) {
                    callback();
                }
            }
        },
        error: function(XMLHttpRequest, textStatus, errorThrown) {
            if (textStatus == "timeout") {
                // タイムアウトの場合
                $.globalProperties.msgBox.error($.globalProperties.ajax.ajaxTimeoutMessage);
            } else {
                $.globalProperties.common.systemError(textStatus);
            }
        },
        complete: function(XMLHttpRequest, textStatus) {
            // ページのブロック解除
            if (isBlockPage) {
                unblockPage();
            }
        }
    });
}

/******************************************************************************
 * 関数名   : parseJSON
 * 機能概要 : JSON形式の文字列をオブジェクトに変換します。
 * 引数     : json : JSON形式の文字列
 * 戻り値   : オブジェクト。変換できなかった場合はnull。
 ******************************************************************************/
function parseJSON(json) {

    var obj = null;

    try {
        json = json.replace(/\r/g, "");
        json = json.replace(/\n/g, "");
        obj = $.parseJSON(json);
    } catch(e) {
    }

    return obj;
}

/******************************************************************************
 * 関数名   : addQueryString
 * 機能概要 : クエリー文字列にパラメータを追加します。
 * 引数     : name  : パラメータ名
 *            value : 値
 *            query : クエリー文字列
 * 戻り値   : クエリー文字列
 ******************************************************************************/
function addQueryString(name, value, query) {
    if(value != void 0) {
        if(query != void 0 && query.length > 0) {
            query += "&" + encodeURIComponent(name) + "=" + encodeURIComponent(value);
        } else {
            query = encodeURIComponent(name) + "=" + encodeURIComponent(value);
        }
    }
    return query;
};

/******************************************************************************
 * 関数名   : uploadFile
 * 機能概要 : 非同期でファイルアップロード処理を行います。
 * 引数     : obj      : アップロードするファイルのjQueryオブジェクト
 *            url      : URL
 *            data     : リクエストパラメータ(Map)
 *            callback : 読み込み完了時のコールバック関数
 *            isBlock  : true: 通信中はページをブロックする false: しない
 * 戻値     : なし
 ******************************************************************************/
function uploadFile(obj, url, data, callback, isBlock) {

    // isBlockPageが指定されなかった場合の対処
    if (isBlock != true && isBlock != false) {
        isBlock = true;
    }

    // ページのブロック
    if (isBlock) {
        blockPage();
    }

    // ファイルアップロードの実行
    obj.upload(url, data, function(responseText) {

        var json = parseJSON(responseText);
        if (isNotEmpty(json)){
            if (json.status == "0") {
                callback(json);
            } else if (json.status == "1") {
                $.globalProperties.msgBox.error(json.errorMessage);
            } else {
               $.globalProperties.common.systemError(responseText);
            }
        } else {
            $.globalProperties.common.systemError(responseText);
        }

        // ページのブロック解除
        if (isBlock) {
            unblockPage();
        }

    }, "text");
}
