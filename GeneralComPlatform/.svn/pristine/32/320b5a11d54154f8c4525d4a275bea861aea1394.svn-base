/*
* 菜单指令, 目前console(后台管理)类型的模板在使用
* 最多支持3级菜单
* */
define(['angularAMD', 'jquery-metisMenu', 'css!sidebar.less'], function(angularAMD){
    angularAMD.directive('sidebar', function($rootScope, $timeout) {
        var parentNodes,node,timer = 0;
        return {
            restrict: 'EA',
            template: '<div ng-transclude></div>',
            replace:true,
            transclude: true,
            link:function(scope, element, attrs, controller){
                //init menu
                element.find('.sidebar').metisMenu({activeClass: 'selected'});
                //注册路由change事件,根据路由状态展开菜单节点
                $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
                    $timeout(function(){
                        //找出需要展开的父节点
                        parentNodes = $('.sidebar .active').parents('li').find('>a');
                        for(var i=parentNodes.length-1; i>=0; i--){
                            node = $(parentNodes[i]);
                            $timeout((function(node){
                                return function(){
                                    //判断节点是否已经展开
                                    if(node && !node.attr('aria-expanded')){
                                        node.click();
                                    }
                                }
                            })(node),timer)
                            //因为菜单展开的动画执行时间为350,设置一个较大的时间间隔展开多级菜单,避免展开失败
                            timer = timer + 450;
                        }
                    })
                });
            }
        };
    });
});