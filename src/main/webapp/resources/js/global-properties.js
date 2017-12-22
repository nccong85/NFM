/*-----------------------------------------------------------------------------
  global-properties.js
 -----------------------------------------------------------------------------*/
(function($) {

    $.globalProperties = {

        /*-- 共通 --*/
        common: {
            // コンテキストパス
            contextPath: "/ngit",
            // システムエラー画面
            systemError: function(textStatus) {
                location.href = _globalProperties.common.contextPath + "/html/ZP/ZPZZ/ZPZZOL00/error.html";
            }
        },

        /*-- メッセージボックス --*/
        msgBox: {
            infoMsgBox: $.infoMsgBox,
            errorMsgBox: $.errorMsgBox,
            confirmMsgBox: $.confirmMsgBox
        },

        /*-- 画面 --*/
        screen: {
            // -- doSubmit --
            doSubmit: {
                // サブミット時のページブロック要否(オプションデフォルト値)
                isBlockPage: true
            },
            // -- blockPage --
            blockPage: {
                // メッセージ(オプションデフォルト値)
                message: "処理中...",
                // メッセージの前に表示するアイコン
                icon: "<i class='ic-process'></i>&nbsp;&nbsp;",
                // メッセージのスタイル
                messageCss: {
                    width: "100px",
                    top: "45%",
                    left: "45%",
                    right: "10px",
                    border: "none",
                    padding: "10px",
                    cursor: "wait",
                    color: "#ffffff",
                    backgroundColor: "#000000",
                    "-webkit-border-radius":"6px",
                    "-moz-border-radius": "6px",
                    "border-radius": "6px",
                    opacity: 0.6,
                    filter: "alpha(opacity=60)",
                    cursor: "wait"
                },
                // オーバーレイのスタイル
                overlayCss: {
                    backgroundColor: "#000000",
                    opacity: 0.0,
                    filter: "alpha(opacity=0)",
                    cursor: "wait"
                }
            },
            // -- openChildWindow --
            openChildWindow: {
                // 幅(オプションデフォルト値)
                width: "",
                // 高さ(オプションデフォルト値)
                height: "",
                // 左位置(オプションデフォルト値)
                left: "",
                // 上位置(オプションデフォルト値)
                top: "",
                // メニューバー有無(オプションデフォルト値)
                menubar: "no",
                // ツールバー有無(オプションデフォルト値)
                toolbar: "no",
                // アドレスバー有無(オプションデフォルト値)
                location: "no",
                // ステータスバー有無(オプションデフォルト値)
                status: "no",
                // リサイズ可否(オプションデフォルト値)
                resizable: "no",
                // スクロールバー有無(オプションデフォルト値)
                scrollbars: "no"
            },
            // -- openModalChildWindow --
            openModalChildWindow: {
                // 幅(オプションデフォルト値)
                width: "",
                // 高さ(オプションデフォルト値)
                height: "",
                // 左位置(オプションデフォルト値)
                left: "",
                // 上位置(オプションデフォルト値)
                top: "",
                // センター表示(オプションデフォルト値)
                center: "no",
                // ステータスバー有無(オプションデフォルト値)
                status: "no",
                // スクロールバー有無(オプションデフォルト値)
                scrollbars: "no",
                // リサイズ可否(オプションデフォルト値)
                resizable: "no",
                // ヘルプボタン有無(オプションデフォルト値)
                help: "no",
                // 最小化ボタン有無(オプションデフォルト値)
                minimize: "no",
                // 最大化ボタン有無(オプションデフォルト値)
                maximize: "no"
            },
            // -- dateTextbox --
            dateTextbox: {
                // 日付フォーマット
                dateFormat: "yyyy/MM/dd",
                // テキストボックスフォーカス時の日付フォーマット
                focusDateFormat: "yyyyMMdd",
                // Datepickerアイコン
                datepickerIcon: "<i class='ic-calendar'></i>",
                // Datepicker使用(オプションデフォルト値)
                datepicker: true
            }
        },

        /*-- Ajax --*/
        ajax: {
            // Ajax通信のタイムアウト値
            ajaxTimeout: 300000,
            // Ajax通信タイムアウト時のエラーメッセージ
            ajaxTimeoutMessage: "タイムアウトが発生しました。\nしばらくしてからやり直してください。"
        },

        /*-- プラグイン --*/
        plugin: {
            // -- dialog --
            dialog: {
                // Escキーの有効化(オプションデフォルト値)
                keyboard: false,
                // ダイアログトップの調整値
                topAdjustValue: 60
            },
            // -- infoMsgBox --
            infoMsgBox: {
                // タイトル
                title: "情報"
            },
            // -- errorMsgBox --
            errorMsgBox: {
                // タイトル
                title: "エラー"
            },
            // -- confirmMsgBox --
            confirmMsgBox: {
                // タイトル
                title: "確認"            }
        }
    }

})(jQuery);
