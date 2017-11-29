/**
 * Created by tjc on 2017/07/02.
 */
define(['angularAMD'], function (angularAMD){

    var api = "/cp/api/login/loginForStudent";//运营商登录
    var apiOP = "/cp/api/login/loginForOP";//系统管理员登录
    var apiJD = "/cp/api/login/loginForJD";

    angularAMD.service('login', function($http) {

        /**
         * 登录验证
         * @param user：用户名
         * @param password：密码
         */
        this.loginJudge=function(user,password){
        	//alert(user);
            return $http.post(api, {userno: user, password : password}).then(function (response) {
                return response.data;
            });
        };
        
        /**\
         * 操作员登录
         */
        this.loginJudgeOP=function(user,password){
            return $http.post(apiOP, {userno: user, password : password}).then(function (response) {
                return response.data;
            });
        };
        
        /**
         * 评委登录
         */
        this.loginJudgeJD=function(user,password){
            return $http.post(apiJD, {userno: user, password : password}).then(function (response) {
                return response.data;
            });
        };
    });

});
