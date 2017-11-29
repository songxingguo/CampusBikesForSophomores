/**
 * Created by tjc on 20167/07/02.
 * 模块管理
 */
define(['angularAMD', 'ui-router'], function (angularAMD){

    angular.module('moduleManagement.router', ['ui.router'])
        .config(function ($stateProvider, $urlRouterProvider) {

            //////////////////////////
            // State Configurations //
            //////////////////////////

            $stateProvider
                .state('center.moduleManagement', angularAMD.route({
                    url: '/moduleManagement',
                    templateUrl: __uri('moduleManagementList.tpl'),
                    css:require(['moduleManagement.less']),
                    controllerUrl: 'contest-app/moduleManagement/moduleManagement.controller',
                    ncyBreadcrumb: {
                        label: '模块管理'
                    }
                }))

                .state('center.moduleManagementAdd', angularAMD.route({
                    url: '/moduleManagementAdd/:parentCode',
                    templateUrl: __uri('moduleManagementAdd.tpl'),
                    css:require(['moduleManagement.less']),
                    controllerUrl: 'contest-app/moduleManagement/moduleManagementAdd.controller',
                    ncyBreadcrumb: {
                        label: '模块管理-增加'
                    }
                }))

                .state('center.moduleManagementDetail', angularAMD.route({
                    url: '/moduleManagementDetail/:id',
                    templateUrl: __uri('moduleManagementDetail.tpl'),
                    css:require(['moduleManagement.less']),
                    controllerUrl: 'contest-app/moduleManagement/moduleManagementDetail.controller',
                    ncyBreadcrumb: {
                        label: '模块管理-查看'
                    }
                }))

                .state('center.moduleManagementUpdate', angularAMD.route({
                    url: '/moduleManagementUpdate/:id',
                    templateUrl: __uri('moduleManagementUpdate.tpl'),
                    css:require(['moduleManagement.less']),
                    controllerUrl: 'contest-app/moduleManagement/moduleManagementDetail.controller',
                    ncyBreadcrumb: {
                        label: '模块管理-修改'
                    }
                }));
        });

    return 'moduleManagement.router';
});