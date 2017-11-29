/**
 * Created by tjc on 2017/07/07.
 */
 define(['angularAMD','gotop'], function(angularAMD){

    var app = angular.module("app", [
        require('interceptor/errorHandler.interceptor'),
      	//require('mock/mock.interceptor'),
    	require('ui-router'),
        require('angular-sanitize'), require('angular-loading-bar'),
        //登录--
        require('login/login.router'),
        //框架
        require('center/center.router'),
        //角色权限
        require('rolePermission/rolePermission.router'),
        //用户管理
        require('userManagement/userManagement.router'),
        //模块管理
        require('moduleManagement/moduleManagement.router'),
        //码表管理
        require('codeTable/codeTable.router')
        ]);

    app.config(['$locationProvider',function ($locationProvider){
        //SEO fragment
        $locationProvider.hashPrefix('!');
    }]);

    app.run(function($rootScope, $state) {
        $rootScope.$state = $state;
    });

    angular.element(document).ready(function() {
        angularAMD.bootstrap(app);
    });
});
