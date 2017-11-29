/**
 * Created by yuanding on 2016/10/10.
 * 公共的后台取数据方法
 * 码表数据
 */
define(['angularAMD'], function (angularAMD){
	var common='/NewCar/api/';
	var roleApi=common+'roles';
	var deptApi= common+"staffManagement/getDeptsList";
    var apiCodeType=common+'codeTable/codeTab/:codeType';
    var api=common+'codeTable/codeTables/:codeType';
    var motorCycleApi =common+ "motorcycleTypes";
    var loginInfoApi = common + "userManagement/loginInfo";

    angularAMD.service('common', function($http) {

        /**
         * 得到码表数据
         * @param conds
         * @returns {*}
         */
       this.getParamList=function(codeType){

           console.info("codeType:service::"+codeType);
           return $http.get(api.replace(":codeType",codeType)).then(function (response) {
               return response.data;
           });
       };

        this.getUnitTypeList=function(codeType){
            return $http.get(apiCodeType.replace(":codeType",codeType)).then(function (response) {
                return response.data;
            });
        };

        /**
         * 得到登录人的信息
         */
        this.getLoginPersonInfo=function(){
            var conds={};
            return $http.get(loginApi, {"params": conds}).then(function (response) {
                return response.data;
            });
        }
        
        /**
         * 根据当前登录人获取角色
         */
        this.getRoleForOrgId=function(conds){
        	var orgId=window.localStorage["curOrgId"];//当前登录人组织结构id
        	
             return $http.get(roleApi, {"params": conds}).then(function (response) {
                 return response.data;
            });
        }
        
        /**
         * 根据当前登录人的组织结构得到所属部门
         */
        this.getOrgSelect=function() {
            return $http.get(deptApi).then(function (response) {
                return response.data;
            });
        }

        /**
         * 得到车型列表
         */
        this.getMotorcycleTypeList=function(){
            return $http.get(motorCycleApi).then(function (response) {
                return response.data;
            });
        };

        /**
         * 获取当前登录人的登录信息
         * */
        this.getLoginInfo = function () {
            return $http.get(loginInfoApi).then(function (response) {
                return response.data;
            });
        }
    });

});
