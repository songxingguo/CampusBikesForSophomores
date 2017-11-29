/**
 * Created by tjc on 2017/07/06.
 * 码表管理
 */
define(['angularAMD', 'ui-router'], function (angularAMD) {

    angular.module('codeTable.router', ['ui.router'])
        .config(function ($stateProvider, $urlRouterProvider) {

            //////////////////////////
            // State Configurations //
            //////////////////////////

            $stateProvider
                .state('center.codeTable', angularAMD.route({
                    url: '/codeTable',
                    templateUrl: __uri('codeTableList.tpl'),
                    css: require(['codeTable.less']),
                    controllerUrl: 'contest-app/codeTable/codeTable.controller',
                    ncyBreadcrumb: {
                        label: '码表管理'
                    }
                }))

                .state('center.codeTableAdd', angularAMD.route({
                    url: '/codeTableAdd/:parentCode',
                    templateUrl: __uri('codeTableAdd.tpl'),
                    css: require(['codeTable.less']),
                    controllerUrl: 'contest-app/codeTable/codeTableAdd.controller',
                    ncyBreadcrumb: {
                        label: '码表管理-新增'
                    }
                }))

                .state('center.codeTableDetail', angularAMD.route({
                    url: '/codeTableDetail/:codes',
                    templateUrl: __uri('codeTableDetail.tpl'),
                    css: require(['codeTable.less']),
                    controllerUrl: 'contest-app/codeTable/codeTableDetail.controller',
                    ncyBreadcrumb: {
                        label: '码表管理-查看'
                    }
                }))

                .state('center.codeTableUpdate', angularAMD.route({
                    url: '/codeTableUpdate/:codes',
                    templateUrl: __uri('codeTableUpdate.tpl'),
                    css: require(['codeTable.less']),
                    controllerUrl: 'contest-app/codeTable/codeTableUpdate.controller',
                    ncyBreadcrumb: {
                        label: '码表管理-修改'
                    }
                }));
        });

    return 'codeTable.router';
});