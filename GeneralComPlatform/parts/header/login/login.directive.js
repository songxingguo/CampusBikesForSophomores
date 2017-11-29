define(['angularAMD',
    'bootstrap/js/bootstrap',
    '/service/auth.service'], function(angularAMD){

    var urlBuilder = require('/service/url.service').urlBuilder;

    angularAMD.directive("login", function(auth, $compile, $timeout) {
        return {
            restrict: 'EA',
            template: __inline('login.tpl'),
            scope: true,
            replace: true,
            link: function(scope, element){

                scope.login = function(){
                    auth.login();
                }

                scope.logout = function(){
                    auth.logout();
                }

                //跳转到个人中心
                scope.goToCenter = function(){
                    auth.isAdmin().then(function(isAdmin){
                       if(isAdmin)
                           location = urlBuilder.adminApp();
                       else
                           location = urlBuilder.userApp();
                    });
                }

                auth.getCurrentUser().then(function(user){
                    scope.logined = true;
                    scope.user = user;

                    var userAvatarEle = angular.element(__inline('user-avatar.tpl'));
                    element.replaceWith($compile(userAvatarEle)(scope));

                    //设置用户名tooltip
                    $timeout(function(){
                        $('#user-avatar').tooltip({container: 'body'});
                    })
                });

            }
        };
    });

});