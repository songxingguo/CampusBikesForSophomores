/**
 * Created by tjc on 2017/07/02.
 * 模块管理
 */
define(['angularAMD'], function (angularAMD){
    var common='/cp/api/';
    var api=common+"modules";
    var countApi=common+"modules/count";
    var addApi=common+'addModule'; //新增
    var detailApi = common+'searchModule';
    var deleteApi = common+'deleteModules';
    var updateApi = common+'updateModule';
    var getNavList = common+ 'getMenu';
/*
    var moduleApi='necop/api/module';

    var moveUpApi = common + 'moveUp';
    var moveDownApi = common + 'moveDown';
    var enterNextLevelApi = common+'goNextCatalog';
    var numOfChildApi = common + 'numOfchilds';
    var searchApi = common+'findModules';
    var searchModuleCountApi = common+'searchModuleCount';*/

    angularAMD.service('moduleManagement', function($http) {

        /**
         * 得到模块管理的列表
         * @param condition：条件
         * @returns {*}
         */
        this.getModuleManagementList=function(condition){
            return $http.get(api, {"params": condition}).then(function (response) {
                console.info(response.data);
                return response.data;
            });
        };

        /**
         * 得到列表数据条数
         * @param condition
         * @returns {*}
         */
        this.getModuleManagementListCount=function(condition){
            return $http.get(countApi, {"params": condition}).then(function (response) {
                console.info(response.data.totalItems);
                return response.data.totalItems;
            });
        };

		/**
		 * 得到符合搜索条件的条数
		 */
        this.getSearchModuleCount=function(condition){
        	return $http.get(searchModuleCountApi, {"params": condition}).then(function (response) {
                return response.data.total;
            });
        };
        /**
         * 根据选择的id进行删除
         * @param ids
         */
        this.deleteByIds=function(ids){
            return $http.post(deleteApi,{ids: ids}).then(function(response){
                return response.data;
            });
        };

        /**
         * 新增模块
         * @param object：新增的内容
         */
        this.addModuleManagement=function(object){
        	console.info(object);
            return $http.post(addApi, object).then(function (response) {
                return response.data;
            });
        };

        /**
         * 修改模块
         */
        this.updateModuleObject=function(object){
            return $http.put(updateApi, object).then(function (response) {
                return response.data;
            });
        };

        /**
         * 根据id得到一条数据
         * @param id
         * @returns {*}
         */
        this.getModuleObjectById=function(id){
        	var conds={id:id};
            return $http.get(detailApi,{"params":conds}).then(function(response){
                return response.data;
            });
        };
        
        /**
         * 上移
         * */
        this.moveUp=function (object) {
            console.info(object);
            return $http.put(moveUpApi,{showOrder:object.showOrder,moduleId:object.id,parentCode:object.parentCode}).then(function (response) {
                return response.data;
            })
        };

        /**
         * 下移
         * */
        this.moveDown=function (object) {
            return $http.put(moveDownApi,{showOrder:object.showOrder,moduleId:object.id,parentCode:object.parentCode}).then(function (response) {
                return response.data;
            })
        }

        /**
         * 进入下一级
         */
        this.enterNextLevel=function (condition) {
        	condition.curPage=condition.currentPage;
        	condition.limit=condition.itemsPerPage;
            return $http.get(api,{"params": condition}).then(function(response){
                return response.data;
            });
        };
        
        /*this.enterFormer=function (condition) {
        	condition.curPage=condition.currentPage;
        	condition.limit=condition.itemsPerPage;
            return $http.get(enterNextLevelApi,{"params": condition}).then(function(response){
                return response.data;
            });
        };

        /**
         * 进入下一级后，得到符合条件模块的条数
         * */
        this.getCountOfChildren=function(condition){
        	console.info(condition);
            return $http.get(numOfChildApi, {"params": condition}).then(function (response) {
                return response.data;
            })
        };

        this.getNavList=function(){
            return $http.get(getNavList).then(function (response) {
                return response.data;
            });
        };

        /**
         * 搜索
         */
        this.searchObject=function(condition) {
            //console.info(moduleName);
            //var moduleName = {moduleName:moduleName}
            condition.curPage=condition.currentPage;
        	condition.limit=condition.itemsPerPage;
        	condition.moduleName=condition.moduleName;
        	condition.level=condition.level;
        	console.info(condition);
            return $http.get(searchApi, {"params":condition}).then(function(response){
                return response.data;
            });
        };
    });

});