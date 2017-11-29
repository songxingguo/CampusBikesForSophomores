/**
 * Created by tjc on 2017/07/02.
 */
define(['angularAMD'], function (angularAMD){
   
    var api="/cp/api/getMenu";
    var module="/api/login/moduleAll";
    var loginINfo="/api/loginInfo";
    var noticeApi='/api/noticeAlert/noticeNum';
    var updatePasswordApi='/api/user/password';
    var updateBaseInformationApi='/api/user/baseInfo';
    var judgePasswordApi = '/api/user/password/judgement';

    angularAMD.service('center', function($http) {

        /**
         * 得到左边导航
         * @returns {*}
         */
        this.getNavList=function(){
            return $http.get(api).then(function (response) {
                return response.data;
            });
        };

        this.getmodule=function(){
            var org=window.localStorage["curUserId"];
            var temp={"org":org};
            return $http.get(module,{"params":temp}).then(function (response) {
                return response.data;
            });
        };
        
        /**
         * 得到登录信息
         */
        this.getLoginInfo=function(){
        	var temp={};
            return $http.get(loginINfo,{"params":temp}).then(function (response) {
                return response.data;
            });
        };
        
		this.getNav1=function(){
            var temp={};
//          return $http.get(api, {"params": temp}).then(function (response) {
//              return list;
//          });
			return list;
        };

        /**
         * 得到通知
         */
        this.getNotice=function(){
            var temp={};
            return $http.get(noticeApi, {"params": temp}).then(function (response) {
                return response.data.count;
            });
        };

        /**
         * 修改登录人密码
         * */
        this.updatePassword=function (oldPassword,password) {
            console.info(oldPassword,password);
            return $http.put(updatePasswordApi, {oldPassword:oldPassword,password: password}).then(function (response) {
                return response.data;
            })
        };

        /**
         * 修改登录用户的基本信息
         * */
        this.updateBaseInformation=function (object) {
            return $http.put(updateBaseInformationApi, object).then(function (response) {
                return response.data;
            })
        };

        /**
         * 判断密码
         * */
        this.judgePassword=function () {
            return $http.get(judgePasswordApi).then(function (response) {
                return response.data;
            })
        };
        
        var list=[{id:'1',module_name:'我的中心',url:'center.myCenter',icon:'img/myCenter.png',children:[]},
                    {id:'2',module_name:'基础数据管理',url:'',icon:'img/basicData.png',children:[
                        {id:'21',module_name:'角色权限管理',url:'center.rolePermission'},
                        {id:'22',module_name:'用户管理',url:'center.userManagement'},
                        {id:'24',module_name:'系统参数',url:'center.systemParameter'},
                        {id:'26',module_name:'码表管理',url:'center.codeTable'},
                        {id:'28',module_name:'模块管理',url:'center.moduleManagement'}
                    ]},
                    {id:'3',module_name:'统计分析',url:'',icon:'img/statisticalAnalysis.png',children:[
                        {id:'31',module_name:'用户统计',url:'center.userStatistics'},
                        {id:'32',module_name:'车辆信息统计',url:'center.vehicleInformationStatistics'},
                        {id:'33',module_name:'车辆里程统计',url:'center.vehicleMileageStatistics'},
                        {id:'34',module_name:'车辆上线率统计',url:'center.vehicleOnLineRateStatistics'},
                        {id:'35',module_name:'操作日志统计',url:'center.operationLogStatistics'},
                        {id:'36',module_name:'车辆超速统计',url:'center.vehicleSpeedstatistics'}
                    ]},
                    {id:'4',module_name:'运营商管理',url:'',icon:'img/operator.png',children:[
                        {id:'41',module_name:'运营商管理',url:'center.carrierOperato'},
                        {id:'42',module_name:'运营商信息查询',url:'center.carrierMessage'}
                    ]},
                    {id:'5',module_name:'门户管理',url:'',icon:'img/portalManagement.png',children:[
                        {id:'51',module_name:'通知发布管理',url:'center.noticeReleaseManage'},
                        {id:'52',module_name:'通知提醒',url:'center.noticeAlert'}
                    ]},
                    
                    {id:'6',module_name:'车辆管理',url:'',icon:'img/carManager.png',children:[
                        {id:'61',module_name:'车辆追踪',url:'center.vehicleTracking'},
                        {id:'62',module_name:'车辆运行轨迹',url:'center.vehicleMoveTrack'},
                        {id:'63',module_name:'车辆参数配置',url:'center.vehicleParameter'},
                        {id:'64',module_name:'车辆信息登记',url:'center.vehicleInfoRegistration'},
                        {id:'65',module_name:'保险及路桥',url:'center.insuranceAndRoad'},
                        {id:'66',module_name:'车辆保养',url:'center.carRefrash'},
                        {id:'67',module_name:'车辆电量展示',url:'center.powerDisplay'},
                        {id:'68',module_name:'违章记录',url:'center.illegalRecord'},
                        {id:'69',module_name:'越界记录',url:'center.outRangeRecord'}
                    ]},
                    
                    {id:'7',module_name:'咨询服务',url:'center.consultationService',icon:'img/consultingService.png',children:[
                    ]},
                    
                    {id:'8',module_name:'客户关系',url:'',icon:'img/relationship.png',children:[
                        {id:'81',module_name:'往来单位',url:'center.rolePermission'},
                        {id:'82',module_name:'合同管理',url:'center.contractManage'},
                        {id:'83',module_name:'租赁用户管理',url:'center.leaseUser'}
                    ]}];
    });

});
