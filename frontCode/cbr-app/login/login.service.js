/**
 * Created by songxinguo on 2017/7/5.
 */
define(['angularAMD'], function (angularAMD){
    var common = "http://localhost:9080/cp/api/" ;
    var registerApi = common + "register";//注册
    var schoolApi = common + "schoolsWithName";

    angularAMD.service('login', function($http) {
        /**
         * 注册
         */
        this.register = function (object) {
            return $http.post(registerApi,{'params': object}).then(function (response) {
                return response.data;
            });
        };

        /**
         * 获取学校信息
         */
        this.getSchools = function (condition) {
            return $http.get(schoolApi, {'params': condition}).then(function (response) {
               return response.data;
            });
        };
    });

});
