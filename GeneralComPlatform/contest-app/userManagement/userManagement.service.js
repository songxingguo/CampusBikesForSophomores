/**
 * Created by tjc on 2017/07/07.
 */
define(['angularAMD'], function (angularAMD){
	var common='/cp/api/userManage/';
	
    var api=common + "users";
    var countApi=common + "users/count";
    var deleteApi =common + "userDel";
    var addApi=common + "userAdd";
    var detailApi=common+"detail/:userId";
    var updateApi=common + "userUpdate";
    var searchApi =common + 'searchObject/:id';
    var roleApi = common + 'role';

    angularAMD.service('userManagement', function($http) {

        /**
         * 得到用户的列表
         * @param condition：条件
         * @returns {*}
         */
        this.getUserManagementList=function(condition){
            console.info(condition);
            return $http.get(api, {"params": condition}).then(function (response) {
                return response.data;
            });
        };

        /**
         * 得到列表数据
         * @param condition
         * @returns {*}
         */
        this.getUserManagementListCount=function(condition){
            return $http.get(countApi, {"params": condition}).then(function (response) {
                return response.data;
            });
        };

        /**
         * 根据选择的id进行删除
         * @param ids
         */
        this.deleteByIds=function(ids){
            return $http.post(deleteApi,{userIds: ids}).then(function(response){
                return response.data;
            });
        };

     
        /**
         * 新增一个用户
         * @param object：新增的内容
         */
        this.addUsers=function(object){
            return $http.post(addApi, object).then(function (response) {
                return response.data;
            });
        };
        
        /**
         * 修改用户*/
        this.updateUserObject=function(object){
        	console.info(object);
        	return $http.put(updateApi, object).then(function (response) {
        		return response.data;
        	});
        };

        /**
         * 根据id得到一条数据
         * @param id
         * @returns {*}
         */
        this.getUsersById=function(id){
        	alert(id);
            return $http.get(detailApi.replace(':userId', id)).then(function(response){
                return response.data;
            });
        };

        /**
         * 搜索
         */
        this.searchObject = function (userObject) {
            return $http.get(searchApi.replace(':id', 1)).then(function (response) {
                return response.data;
            });
        };

        /**
         * 得到角色
         * */
        this.getRole=function () {
            return $http.get(roleApi).then(function (response) {
                return response.data;
            });
        };
    });

});
