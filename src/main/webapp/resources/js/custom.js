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

/*=============================================================
    Authour URI: www.binarycart.com
    License: Commons Attribution 3.0

    http://creativecommons.org/licenses/by/3.0/

    100% To use For Personal And Commercial Use.
    IN EXCHANGE JUST GIVE US CREDITS AND TELL YOUR FRIENDS ABOUT US
   
    ========================================================  */
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
 * プラグイン名 : requiredMark
 * 機能概要     : 必須マークを設定します。
 * オプション   : なし
 ******************************************************************************/
jQuery.fn.requiredMark = function() {

    this.each(function() {

        if (!$(this).hasClass("applied-required-mark")) {

            $(this).append("<strong class='tooltip-top' title='必須項目です。' style='font-size:10px;color:red'>＊</strong>");
            $(this).addClass("applied-required-mark");
        }
    });

    return this;
};

(function ($) {
    "use strict";
    var mainApp = {

        main_fun: function () {
            /*====================================
            METIS MENU 
            ======================================*/
            $('#main-menu').metisMenu();
			$("body").find(".required").requiredMark();
			$("body").find(".tooltip-top").tooltip();
		    $("body").find(".tooltip-bottom").tooltip({placement: "bottom"});
		    $("body").find(".tooltip-left").tooltip({placement: "left"});
		    $("body").find(".tooltip-right").tooltip({placement: "right"});
		    
		    // 数値テキストボックスの設定
            $("body").find("input.number").numberTextbox();
            
            $("body").find("input.datepicker").datepicker({
            	language: "ja",
            	orientation: "bottom right",
		        autoclose: true,
		        todayHighlight: true,
		        toggleActive: true
            });
        
			$('.input-daterange').datepicker({
		        language: "ja",
		        orientation: "bottom right",
		        autoclose: true,
		        todayHighlight: true,
		        toggleActive: true
		    });
            /*====================================
              LOAD APPROPRIATE MENU BAR
           ======================================*/
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });
        },

        initialization: function () {
            mainApp.main_fun();
        }
    }
    // Initializing ///
    $(document).ready(function () {
        mainApp.main_fun();
    });

}(jQuery));
