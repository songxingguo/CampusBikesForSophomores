/**
 * Created by moon on 2015/4/22.
 * 处理api路径
 */
define(['angularAMD'],function(){

    var match = /^v\d\/(advertisements|questions|answers|comments|question|answer|common|units|users|user|goods|catalogs|processing|ehcache)/;

    function isApi(url){
        return match.test(url);
    }

    function bulidUrl(url){
        return  '/office/api/' + url;
    }

    angular.module("onlineInterceptor",[])
        .factory('onlineInterceptor', function() {
            return {
                request: function(config) {
                    var url = config.url;
                    if(isApi(url)){
                        config.url = bulidUrl(url);
                    }
                    return config;
                }
            }
        })
        .config(function($httpProvider) {
            $httpProvider.interceptors.push('onlineInterceptor');
        });

    return "onlineInterceptor";
});
