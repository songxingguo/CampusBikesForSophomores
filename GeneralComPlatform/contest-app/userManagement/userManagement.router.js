/**
 * Created by tjc on 2017/07/06.
 * 用户管理
 */
define (['angularAMD','ui-router'],function(angularAMD){

    angular.module('userManagement.router',['ui.router'])
        .config(function ($stateProvider, $urlRouterProvider) {

            //////////////////////////
            // State Configurations //
            //////////////////////////

            $stateProvider
                .state('center.userManagement', angularAMD.route({
                    url: '/userManagement',
                    templateUrl: __uri('userManagementList.tpl'),
                    css:require(['userManagement.less']),
                    controllerUrl: 'contest-app/userManagement/userManagement.controller',
                    ncyBreadcrumb: {
                        label: '用户管理'
                    }
                }))

                .state('center.userManagementAdd', angularAMD.route({
                    url: '/userManagementAdd',
                    templateUrl: __uri('userManagementAdd.tpl'),
                    css:require(['userManagement.less']),
                    controllerUrl: 'contest-app/userManagement/userManagementAdd.controller',
                    ncyBreadcrumb: {
                        label: '用户管理-新增'
                    }
                }))

                .state('center.userManagementDetail', angularAMD.route({
                    url: '/userManagementDetail/:id',
                    templateUrl: __uri('userManagementDetail.tpl'),
                    css:require(['userManagement.less']),
                    controllerUrl: 'contest-app/userManagement/userManagementDetail.controller',
                    ncyBreadcrumb: {
                        label: '用户管理-查看'
                    }
                }))

                .state('center.userManagementUpdate', angularAMD.route({
                    url: '/userManagementUpdate/:id',
                    templateUrl: __uri('userManagementUpdate.tpl'),
                    css:require(['userManagement.less']),
                    controllerUrl: 'contest-app/userManagement/userManagementDetail.controller',
                    ncyBreadcrumb: {
                        label: '用户管理-修改'
                    }
                }));
        });

        return 'userManagement.router';
});