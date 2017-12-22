/*-----------------------------------------------------------------------------
  JavaScriptファイルを読み込むための処理です。
  モックを作成するとき、全てのHTMLファイルにJavaScriptファイルを記述するのを
  避けるための仕組みです。
 -----------------------------------------------------------------------------*/
(function(){

    // JavaScriptファイルのリスト
    var jsList = [
    	"SpringMVC/resources/js/jquery.min.js",
    	"SpringMVC/resources/js/bootstrap.min.js",
    	"SpringMVC/resources/js/jquery.metisMenu.js",
    	"SpringMVC/resources/js/bootstrap-datepicker.js",
    	"SpringMVC/resources/js/bootstrap-datepicker.ja.min.js",
    	"SpringMVC/resources/js/jquery.contextMenu.js",
    	"SpringMVC/resources/js/jquery.ui.position.min.js",
        "SpringMVC/resources/js/global-properties.js",
        "SpringMVC/resources/js/common.js",
        "SpringMVC/resources/js/common-plugin.js",
        "SpringMVC/resources/js/custom.js"
    ];

    for(var i = 0; i < jsList.length; i++){
        document.write('<script type="text/javascript" src="' + jsList[i] + '"><\/script>');
    }

})();
