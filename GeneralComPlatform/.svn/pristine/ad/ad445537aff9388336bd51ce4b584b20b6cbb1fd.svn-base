/**
 * Created by tjc on 2017/07/02.
 */
define(['angularAMD', 'ui-router'], function (angularAMD){

    angular.module('center.router', [require('ui-router'), require('angular-breadcrumb')])
        .config(function ($stateProvider, $urlRouterProvider) {

            //$urlRouterProvider.otherwise('/rolePermission');
            $urlRouterProvider.when('/center','/center/myCenter');

            //////////////////////////
            // State Configurations //
            //////////////////////////

            $stateProvider
                .state('center', angularAMD.route({
                    url: '/center',
                    templateUrl: __uri('center.tpl'),
                    css:require(['center.less']),
                    controllerUrl: 'contest-app/center/center.controller',
                    ncyBreadcrumb: {
                        label: '我的中心'
                    }
                }));
        });

    return 'center.router';
});
