define(['angularAMD', 'jquery-dotdotdot'], function(angularAMD){

    angularAMD.directive("dotdotdot", function() {
        return {
            restrict: 'EA',
            replace: true,
            link: function(scope, element, attrs, controller){
                var text = scope.$eval(attrs.dotdotdot);
                element.attr('title', text);
                element.html(text);
                var options = {wrap	: 'letter'};
                if(attrs.height)
                    options.height = attrs.height * 1;
                element.dotdotdot(options);
            }
        };
    });

});