/**
 * Created by moon on 2015/4/22.
 * RAP拦截请求, 请修改require-config.js中的rap地址为自己的项目地址
 */
define(['jquery', 'angularAMD', 'rap'],function($){

    angular.module("rapInterceptor", [])

            .factory("rapInterceptor" ,['$injector', function($injector){

                var mode = RAP.getMode();
                var host = RAP.getHost();
                var projectId = RAP.getProjectId();
                var whiteList = RAP.getWhiteList();

                /**
                 * convert url from absolute to relative
                 * 转换绝对路径为相对路径,用于匹配文档定义的path
                 * 注意路径匹配会忽略主机名(host)
                 */
                function convertUrlToRelative(url) {
                    if (url instanceof RegExp) {
                        return url;
                    }
                    if (!url) {
                        throw Error('Illegal url:' + url);
                    }
                    if (url.indexOf('http://') > -1) {
                        url = url.substring(url.indexOf('/', 7) + 1);
                    } else if (url.indexOf('https://') > -1) {
                        url = url.substring(url.indexOf('/', 8) + 1);
                    }
                    if (url.charAt(0) != '/') {
                        url = '/' + url;
                    }
                    return url;
                }

                //构建RAP请求URL
                function bulidMockUrl(url){
                    return "http://"+host+"/mockjsdata/"+ projectId + convertUrlToRelative(url);
                }

                //
                function isInWhiteList(whiteList, url) {
                    if (url && url.indexOf('?') !== -1) {
                        url = url.substring(0, url.indexOf('?'))
                    }
                    var i;
                    var o;

                    url = convertUrlToRelative(url);

                    if (!url || typeof url !== 'string') {
                        console.warn("Illegal url:", url);
                        return false;
                    }

                    for (i = 0; i < whiteList.length; i++) {
                        o = convertUrlToRelative(whiteList[i]);
                        if (typeof o === 'string' && (url.indexOf(o) >= 0 || o.indexOf(url) >= 0)) {
                            return true;
                        } else if (typeof o === 'object' && o instanceof RegExp && o.test(url)) {
                            return true;
                        }
                    }

                    return false;
                }

                //数据结构效验
                /**************************************************/
                var LOST = "LOST";
                var EMPTY_ARRAY = "EMPTY_ARRAY";
                var TYPE_NOT_EQUAL = "TYPE_NOT_EQUAL";

                function validatorResultLog(item, isReverse) {

                    var eventName;
                    if (item.type === LOST) {
                        eventName = isReverse ? '未在接口文档中未定义。' : '缺失';
                    } else if (item.type === EMPTY_ARRAY) {
                        eventName = '数组为空，无法判断其内部的结构。';
                        return; // 暂时忽略此种情况
                    } else if (item.type === TYPE_NOT_EQUAL) {
                        eventName = '数据类型与接口文档中的定义不符';
                    }

                    return '参数 ' + item.namespace + "." + item.property + ' ' + eventName;

                }

                function checkerHandler(realData, mockData, url) {
                    var validator = new StructureValidator(realData, mockData);
                    var result = validator.getResult();
                    var realDataResult = result.left;
                    var rapDataResult = result.right;
                    var i;
                    var log = [];


                    if (realDataResult.length === 0 && rapDataResult.length === 0) {
                        log.push(url + ' -> ' + '接口结构校验完毕，未发现问题。');
                        console.info(log.join('\n'));
                    } else {
                        log.push(url + ' -> ' + '在校验接口时发现错误:');

                        for (i = 0; i < realDataResult.length; i++) {
                            log.push(validatorResultLog(realDataResult[i]));
                        }
                        for (i = 0; i < rapDataResult.length; i++) {
                            log.push(validatorResultLog(rapDataResult[i], true));
                        }
                        console.error(log.join('\n'));
                        console.log('真实数据:');
                        console.dir(realData);
                    }

                }

                /**************************************************/

                return {
                    //拦截请求转发到RAP服务器
                    request: function(config) {
                        var url = config.url;
                        if(RAP.router(url)){
                            config.url = bulidMockUrl(url);
                        }
                        return config;
                    },

                    //效验真实数据结构与文档定义是否一致
                    response: function(response){
                        var url = response.config.url;
                        var http = $injector.get('$http');
                        //请求路径非RAP路径切在白名单中
                        if(mode == 0 && url.indexOf("mockjs") === -1 && isInWhiteList(whiteList, url)){
                            response.config.url = bulidMockUrl(url);
                            (function(realData){
                                http(response.config).success(function(mockdata){
                                    checkerHandler(realData, mockdata, url);
                                });
                            })(angular.copy(response.data));
                        }
                        return response;
                    }
                };
            }])
            .config(function($httpProvider) {
                $httpProvider.interceptors.push('rapInterceptor');
            });


    return "rapInterceptor";
});