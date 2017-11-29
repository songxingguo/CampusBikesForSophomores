/**
 * Created by moon on 2015/4/22.
 */
define(['angularAMD'],function(){

    var popup = require('popup-message');

    angular.module("errorHandlerInterceptor",[])
        .factory('errorHandlerInterceptor', function($rootScope,$q) {
            return {
                  request: function(config){
                      config.headers = config.headers || {};
//                      var temp=config.url.split('/');
//                      var str=temp[3];
//                      if(config.url.indexOf(".tpl")>=0){
//                          window.localStorage["isLoading"]=true;
//
//                      }
//
//                      if(temp[3]!=window.localStorage["curModule"] && config.url.indexOf(".tpl")<0 && window.localStorage["isLoading"]=='true'){
//                          window.localStorage["curModule"]=temp[3];
//                          window.localStorage["isLoading"]=true;
//                          $('#mainCenter').prepend("<div class='loadingAear' style='position: absolute;z-index: 1000;background: #ffffff;height: 650px;width:83%;color: #666;font-size: 22px;padding: 100px 0 0 300px;'><img src='img/loading.gif'/>&nbsp;&nbsp;&nbsp;正在努力加载中，请稍等... </div>");
//                      }

                  		//请求头部
                      if(window.localStorage["contest-Authorization"]&&window.localStorage["curRoleType"]
                      		&&window.localStorage["curUserId"]){
                      	//如果是登录则不添加
                      	if(config.url=='/contest-app/login/login.tpl'||config.url=='/ContestPlatform/api/loginForOP'){
                            window.localStorage["contest-Authorization"]=null;//将返回的验证码存储到本地
                    		window.localStorage["curRoleType"]=null;
                    		window.localStorage["curUserId"]=null;
                            return  config;
                        }

                         config.headers.Authorization = window.localStorage["contest-Authorization"];
                         config.headers.curRoleType = window.localStorage["curRoleType"];
                         config.headers.curUserId = window.localStorage["curUserId"];
                      }else{
                            if(config.url=='/contest-app/login/login.tpl'||config.url=='/ContestPlatform/api/loginForOP'){
                            	window.localStorage["contest-Authorization"]=null;//将返回的验证码存储到本地
                    			window.localStorage["curRoleType"]=null;
                    			window.localStorage["curUserId"]=null;
                                return  config;
                            }else{
                            	alert('本地存储异常！');
                                return;
                            }
                      }
                      return config;
                  },

                response : function(response) {

//                        setTimeout(function(){
//                            $(".loadingAear").remove();
//                        },800);

                    if (response.data.errMsg) {
                        showMsg('error', '网络请求失败,请刷新再试或者从新登陆!');
                        return $q.reject(response);
                    } else {
                    	if(response.data.token){
                    		window.localStorage["contest-Authorization"]=response.data.token;//将返回的验证码存储到本地
                    		window.localStorage["curRoleType"]=response.data.roleType;//roleType
                    		window.localStorage["curUserId"]=response.data.userId;
                    	}
                        return response;
                    }
                },

                responseError : function(rejection) {
                    popup.showMsg('error', "网络请求失败,请稍后再试!");
                    return $q.reject(rejection);
                }
            }
        })
        .config(function($httpProvider) {
            $httpProvider.interceptors.push('errorHandlerInterceptor');

            $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
            $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

            // Override $http service's default transformRequest
            $httpProvider.defaults.transformRequest = [function(data) {
                /**
                 * The workhorse; converts an object to x-www-form-urlencoded serialization.
                 * @param {Object} obj
                 * @return {String}
                 */
                var param = function(obj) {
                    var query = '';
                    var name, value, fullSubName, subName, subValue, innerObj, i;

                    for (name in obj) {
                        value = obj[name];

                        if (value instanceof Array) {
                            for (i = 0; i < value.length; ++i) {
                                subValue = value[i];
                                fullSubName = name + '[' + i + ']';
                                innerObj = {};
                                innerObj[fullSubName] = subValue;
                                query += param(innerObj) + '&';
                            }
                        } else if (value instanceof Object) {
                            for (subName in value) {
                                subValue = value[subName];
                                fullSubName = name + '[' + subName + ']';
                                innerObj = {};
                                innerObj[fullSubName] = subValue;
                                query += param(innerObj) + '&';
                            }
                        } else if (value !== undefined && value !== null) {
                            query += encodeURIComponent(name) + '='
                                + encodeURIComponent(value) + '&';
                        }
                    }

                    return query.length ? query.substr(0, query.length - 1) : query;
                };

                return angular.isObject(data) && String(data) !== '[object File]'
                    ? param(data)
                    : data;
            }];
        });

    return "errorHandlerInterceptor";
});
