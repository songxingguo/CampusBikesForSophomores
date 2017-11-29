/**
 * Created by moon on 2015/5/5.
 */
define(['angularAMD', 'ui-router'], function (angularAMD){

    angular.module('index.router', ['ui.router', require('angular-breadcrumb')])
    .config(function ($stateProvider, $urlRouterProvider) {
       
        /////////////////////////////
        // Redirects and Otherwise //
        /////////////////////////////

        // Use $urlRouterProvider to configure any redirects (when) and invalid urls (otherwise).
        $urlRouterProvider
            // If the url is ever invalid, e.g. '/asdf', then redirect to '/' aka the home state
            .otherwise('/');

        //////////////////////////
        // State Configurations //
        //////////////////////////

        $stateProvider
        .state('index', angularAMD.route({
            url: '/',
            templateUrl: __uri('index.tpl'),
            css:require('index.less'),
            controllerUrl: 'app/index/index.controller',
            ncyBreadcrumb: {
                label: '首页'
            }
        }))

    });

    return 'index.router';
});