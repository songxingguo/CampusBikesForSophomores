/**
 * Created by tjc on 2016/10/6.
 * 角色权限
 */
define(['angularAMD'], function (angularAMD){
	var common='/cp/api/';
    var api=common+"roles";
    var countApi=common+"roles/count";
    var deleteApi = common+'roles';
    var moduleApi=common+'necop/api/module';
    var addApi=common+'role';
    var detailApi =common+ 'role/:id';
    var updateApi = common + 'updateRole';

    angularAMD.service('rolePermission', function($http) {

        /**
         * 得到角色权限得列表
         * @param condition：条件
         * @returns {*}
         */
        this.getRolePermissionList=function(condition){

            return $http.get(api, {"params": condition}).then(function (response) {
                return response.data;
            });
        };

        /**
         * 得到列表数据
         * @param condition
         * @returns {*}
         */
        this.getRolePermissionListCount=function(condition){
            return $http.get(countApi, {"params": condition}).then(function (response) {
            	console.info(response);
                return response.data.totalItems;
            });
        };

        /**
         * 根据选择的id进行删除
         * @param ids
         */
        this.deleteByIds=function(roleIds){
        	console.info(roleIds);
            return $http.post(deleteApi,{ids:roleIds}).then(function(response){
                return response.data;
            });
        };

        /**
         * 得到模块
         * @param condition：条件
         * @returns {*}
         */
        this.getModule=function(condition){
            return $http.post(moduleApi,condition ).then(function (response) {
                return response.data.module;
            });
        };

        /**
         * 新增一个角色权限
         * @param object：新增的内容
         */
        this.addPermissions=function(object){
            return $http.post(addApi, object).then(function (response) {
                return response.data;
            });
        };

        /**
         * 修改角色权限
         */
        this.updateRolePermission=function(object) {

             object.roleId = object.id;
            return $http.put(updateApi, object).then(function(response){
                return response.data;
            });
        };

        /**
         * 根据id得到一条数据
         * @param id
         * @returns {*}
         */
        this.getPermissionsById=function(id){
            return $http.get(detailApi.replace(':id', id)).then(function(response){
                return response.data;
            });
        };

        //转化为后台相同名字
        function initCondition(condition){
            var temp={};
            temp.roleId=condition.id;
            temp.roleName=condition.name;
            temp.roleRemark =condition.remark;
            temp.moduleIds =condition.moduleIds;
            temp.moduleCodes =condition.moduleCodes;
            temp.type=condition.type;

            return temp;
        }
    });

});
