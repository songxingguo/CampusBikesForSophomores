/**
 * Created by tjc on 2017/07/02.
 */
define(['angularAMD', 'ui-router'], function (angularAMD){

    angular.module('login.router', ['ui.router'])
            .config(function ($stateProvider, $urlRouterProvider) {

            /////////////////////////////
            // Redirects and Otherwise //
            /////////////////////////////

            $urlRouterProvider
                .otherwise('/login');

            //////////////////////////
            // State Configurations //
            //////////////////////////

            $stateProvider
                .state('login', angularAMD.route({
                    url: '/login',
                    templateUrl: __uri('login.tpl'),
                    css:require(['login.less']),
                    controllerUrl: 'contest-app/login/login.controller'
                }));
        });

    return 'login.router';
});
