/**
 *  Created by songxingguo on 2017/7/2.
 *  启动 AngularJS，以及调路由
 */

define(['angularAMD','angularUiRouter','angular','ngLoad'], function (angularAMD) {

   // var app = angular.module('app',[
   //     require('angularUiRouter'),
   //     //登录
   //     require('login/login.router')
   //  ]);
   //
   //  app.config(['$locationProvider',function ($locationProvider){
   //     //SEO fragment
   //     $locationProvider.hashPrefix('!');
   //  }]);
   //
   //  app.run(function($rootScope, $state) {
   //     $rootScope.$state = $state;
   //  });
   //
   //  // /*手工启动angular*/
   // angular.element(document).ready(function() {
   //      angularAMD.bootstrap(app);
   //  });

    var app = angular.module('app',['ui.router']);

    app.run(function($rootScope,$state,$stateParams){
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    });

    app.config(function ($stateProvider, $urlRouterProvider) {

        /////////////////////////////
        // Redirects and Otherwise //
        /////////////////////////////

        $urlRouterProvider
            .otherwise('/center');

        /**
         * 局部替换
         **/
        //将登录加入到center
        $urlRouterProvider.when('/center','/center/login');

        //将个人在资料加入到个人信息中
        $urlRouterProvider.when('/personalInfo','/personalInfo/personalProfile');

        //////////////////////////
        // State Configurations //
        //////////////////////////

        $stateProvider
            // 登录/注册
            .state('center', angularAMD.route({
                url: '/center',
                templateUrl: '../cbr-app/center/center.html',
                css: '../cbr-app/center/center.css',
                controllerUrl: '../cbr-app/center/center.controller'
            }))
            .state('center.login', angularAMD.route({
                url: '/login',
                templateUrl: '../cbr-app/login/login.html',
                css: '../cbr-app/login/login.css',
                controllerUrl: '../cbr-app/login/login.controller'
            }))
            //个人信息
            .state('personalInfo', angularAMD.route({
                url: '/personalInfo',
                templateUrl: '../cbr-app/personalInfo/personalInfo.html',
                css: '../cbr-app/personalInfo/personalInfo.css',
                controllerUrl: '../cbr-app/personalInfo/personalInfo.controller'
            }))
            //个人资料
            .state('personalInfo.personalProfile', angularAMD.route({
                url: '/personalProfile',
                templateUrl: '../cbr-app/personalProfile/personalProfile.html',
                css: '../cbr-app/personalProfile/personalProfile.css',
                controllerUrl: '../cbr-app/personalProfile/personalProfile.controller'
            }))
            //账户充值
            .state('personalInfo.recharge', angularAMD.route({
                url: '/recharge',
                templateUrl: '../cbr-app/recharge/recharge.html',
                css: '../cbr-app/recharge/recharge.css',
                controllerUrl: '../cbr-app/recharge/recharge.controller'
            }));
    });

    return angularAMD.bootstrap(app);
});


