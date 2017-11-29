/*
* 对内容的关键字进行高亮显示
* */
define(["angularAMD"], function(angularAMD){

    angularAMD.filter('highlight', function($sce) {
        return function (text, keyword) {
            if (keyword) text = text.replace(new RegExp('(' + keyword + ')', 'gi'),
                '<span class="highlighted">$1</span>')

            return $sce.trustAsHtml(text)
        };
    });

});