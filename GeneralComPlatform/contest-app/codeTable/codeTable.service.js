/**
 * Created by wangshen on 2016/10/11.
 * 码表管理
 */
define(['angularAMD'], function (angularAMD) {
	var common='/NewCar/api/codeTable/';
	
    var api =common+ "codeTables";
    var countApi =common+ "codeTables/count";
    var deleteApi =common+ 'codeTableDel';
    var addApi = common+'codeTable';
    var updateApi = common+'codeTable';
    var detailApi = common+'codeTable/:paramCode';
    var searchApi = common+'codeTablesSearch';

    angularAMD.service('codeTable', function ($http) {

        /**
         * 得到码表列表
         * @param condition：条件
         * @returns {*}
         */
        this.getCodeTableList = function (condition) {
        	var temp={};
        	temp.curPage=condition.currentPage;
        	temp.limit=condition.itemsPerPage;
        	temp.paramName=condition.paramName;
        	temp.paramText=condition.paramText;
        	temp.parentCode=condition.parentCode;
            return $http.get(api, {"params": temp}).then(function (response) {
                return response.data;
            });
        };

        /**
         * 搜索码表
         * @Param condtition
         * @returns {*}
         * */
        this.searchCodeTables = function (condition) {
            return $http.get(searchApi, {"params":condition}).then(function (response) {
                return response.data;
            });
        };


        /**
         * 得到列表数据
         * @param condition
         * @returns {*}
         */
        this.getCodeTableListCount = function (condition) {
        	var temp={};
        	temp.curPage=condition.currentPage;
        	temp.limit=condition.itemsPerPage;
        	temp.paramName=condition.paramName;
        	temp.paramText=condition.paramText;
        	temp.parentCode=condition.parentCode;
            return $http.get(countApi, {"params": temp}).then(function (response) {
            	console.info(response.data);
                return response.data;
            });
        };

        /**
         * 根据选择的codes进行删除
         * @param codes
         */
        this.deleteByCodes = function (codes) {
            console.info(codes);
            return $http.post(deleteApi, {paramCodes:codes}).then(function (response) {
                return response.data;
            });
        };

        /**
         * 新增一个码表
         * @param object：新增的内容
         */
        this.addCodes = function (object) {
            console.info(object);
            return $http.post(addApi,object).then(function (response) {
                return response.data;
            });
        };

        /**
         * 修改码表内容
         * @param object：修改的内容
         */
        this.updateCodes = function (object) {
        	console.info(object);
            return $http.put(updateApi, object).then(function (response) {
                return response.data;
            });
        };

        /**
         * 根据param_code得到一条数据
         * @param param_code
         * @returns {*}
         */
        this.getCodesByCodes = function (codes) {
            return $http.get(detailApi.replace(':paramCode', codes)).then(function (response) {
                return response.data;
            });
        };

        /**
         * 根据param_code进入下一级
         * @param param_code
         * @returns {*}
         */
        this.nextLevelByCodes = function (codes) {
        	var temp={};
        	temp.curPage=1;
        	temp.limit=10;
        	temp.parentCode=codes;
        	console.info(temp);
            return $http.get(api, {"params": temp}).then(function (response) {
                return response.data.table;
            });
        };
    });

});
