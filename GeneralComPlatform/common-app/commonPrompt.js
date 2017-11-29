/**
 * Created by yuanding on 2016/11/19
 * 公共提示语
 */
define(['angularAMD'], function (angularAMD){
    angularAMD.service('prompt', function($http) {

       /**
        * 得到成功时的数据
        */
       this.getScuInfo=function(type){
       		return type+'成功！';
       };
       
       /**
        * 得到失败时的数据
        */
       this.getScuInfo=function(type){
       		return type+'失败！';
       };
       
       /**
        * 得到警告时数据
        */
       this.getSelectWaring=function(){
       		return '请至少选择一项';
       }
    });

});
