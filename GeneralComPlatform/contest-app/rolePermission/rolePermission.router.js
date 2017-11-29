/**
 * Created by tjc on 20167/07/6.
 * 角色权限管理
 */

define(['angularAMD', 'ui-router'], function (angularAMD){

    angular.module('rolePermission.router', [require('ui-router'), require('angular-breadcrumb')])
        .config(function ($stateProvider, $urlRouterProvider) {

            //////////////////////////
            // State Configurations //
            //////////////////////////

            $stateProvider
                .state('center.rolePermission', angularAMD.route({
                    url: '/rolePermission',
                    templateUrl: __uri('rolePermissionList.tpl'),
                    css:require(['rolePermission.less']),
                    controllerUrl: 'contest-app/rolePermission/rolePermission.controller',
                    ncyBreadcrumb: {
                        label: '角色权限管理'
                    }
                }))

                .state('center.rolePermissionAdd', angularAMD.route({
                    url: '/rolePermissionAdd',
                    templateUrl: __uri('rolePermissionAdd.tpl'),
                    css:require(['rolePermission.less']),
                    controllerUrl: 'contest-app/rolePermission/rolePermissionAdd.controller',
                    ncyBreadcrumb: {
                        label: '角色权限管理-新增'
                    }
                }))

                .state('center.rolePermissionDetail', angularAMD.route({
                    url: '/rolePermissionDetail/:id',
                    templateUrl: __uri('rolePermissionDetail.tpl'),
                    css:require(['rolePermission.less']),
                    controllerUrl: 'contest-app/rolePermission/rolePermissionDetail.controller',
                    ncyBreadcrumb: {
                        label: '角色权限管理—查看'
                    }
                }))

                .state('center.rolePermissionUpdate', angularAMD.route({
                    url: '/rolePermissionUpdate/:id',
                    templateUrl: __uri('rolePermissionUpdate.tpl'),
                    css:require(['rolePermission.less']),
                    controllerUrl: 'contest-app/rolePermission/rolePermissionAdd.controller',
                    ncyBreadcrumb: {
                        label: '角色权限管理—修改'
                    }
                }));
        });

    return 'rolePermission.router';
});