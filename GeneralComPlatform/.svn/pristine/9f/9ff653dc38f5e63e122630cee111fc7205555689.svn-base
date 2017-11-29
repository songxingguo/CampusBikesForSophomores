define(['jquery', 'particles', 'angularAMD', 'crypto/md5', '/service/auth.service'], function($, particles, angularAMD, md5){

    //登录获取token
    var loginApi = '/logincomm/api/v1/pwd/token';
    //证书登录
    var certLoginApi = '${domain}:444/logincomm/api/v1/cert/token';
    //sso 登录,为其他站点代领token
    var ssoApi = '/logincomm/api/v1/domains/shared/entries';
    //临时密码
    var temporary = '/org/sign!repass.action';

    var getUrlQueryString = require('/service/url.service').getUrlQueryString;

    var app = angular.module('login', [require('angular-hotkeys'),
        require('angular-placeholder'),
        require('interceptor/rap.interceptor'),
        require('interceptor/errorHandler.interceptor')])
    .config(['$locationProvider', function ($locationProvider) {
        //SEO fragment
        $locationProvider.hashPrefix('!');

    }])
    .controller('loginCtrl', ['$scope', '$http', '$q', 'hotkeys', 'auth', function(s, $http, $q, hotkeys, auth){

        s.error = {};

        function checkInput(){
            if(!s.account || !s.password){
                s.error.type = 'warning';
                s.error.msg = '请输入用户名和密码';
                return false;
            }else{
                s.error.msg = null;
                return true;
            }
        }

        // 0成功
        // 402用户名密码错误
        // 403 用户被禁用
        // 404 证书不正确
        // 405 只能使用证书登录
        // 500 系统错误
        function resPorcess(res){
            var _backUrl = getUrlQueryString(window.location.href).back;
            var backUrl = decodeURIComponent(_backUrl);

            switch (res){
                case 0:
                    //验证是否本域的跳转
                    if(backUrl && (backUrl.indexOf('${domain}') == 5 || backUrl.indexOf('${domain}') == 6)){

                        //如果回跳url为管理页面,判断登录用户为管理员直接回跳
                        //否则调回首页
                        //如果回跳url为用户中心页面,判断登录用户角色为用户直接回跳
                        //否则调回首页
                        var urlRegExp = /(user|admin)-app/i;

                        if(backUrl.search(urlRegExp) !== -1) {
                            var role = backUrl.match(urlRegExp)[1];

                            auth.isAdmin().then(function(isAdmin){
                                if((isAdmin && role == 'admin') || (!isAdmin && role == 'user'))
                                    window.location = backUrl;
                                else
                                    window.location = '${domain}';
                            })
                        }
                        //其他(非user-app | admin-app)页面,直接跳转
                        else {
                            window.location = backUrl;
                        }

                    }else{
                        window.location = '${domain}';
                    }
                    break;
                //临时密码,需要修改
                case 1:
                    window.location = temporary + '?remark=' + _backUrl;
                    break;
                case 402:case 403:case 404:case 405:case 500:
                s.error.type = 'error';
                case 402:
                    s.error.msg = '用户名或密码错误!';
                    break;
                case 403:
                    s.error.msg = '用户被禁用!';
                    break;
                case 404:
                    s.error.msg = '证书不正确!';
                    break;
                case 405:
                    s.error.msg = '只能使用证书登录!';
                    break;
                case 500:
                    s.error.msg = '登录失败,请稍后再试!';
                    break;
            }
        }

        //sso 单点登录
        function sso(loginResult){
            $http.get(ssoApi).success(function(urls){

                var ssoLogins = [];

                angular.forEach(urls, function(url){
                    ssoLogins.push($http.jsonp(url, {params :{callback:'JSON_CALLBACK'}}));
                });

                //单点登录完成(不论成功还是失败), 处理当前的登录请求结果
                $q.all(ssoLogins)['finally'](function(){
                    resPorcess(loginResult);
                });

                //获取登录urls失败
            }).error(function(){
                resPorcess(loginResult);
            })
        }

        //清除警告信息
        s.$watch('account + password', function(){
            if(s.error.type = 'warning')
             s.error.msg = null;
        })

        //登录
        s.loginSubmit = function(){
            if(!checkInput())
                return;

            var data = {
                account: s.account,
                password: md5(s.password).toString(),
                md5Password: true
            }

            if(s.rememberMe){
                data.cookieExpireInSeconds = 60 * 60 * 24 * 7; //7 days
            }

            $http.post(loginApi, data).success(function(data){

                //登录成功
                if(data.res === 0 || data.res === 1){
                    sso(data.res);
                //登录失败
                }else{
                    resPorcess(data.res);
                }

            }).error(function(){
                s.error.type = 'error';
                s.error.msg = '登录失败,请稍后再试!';
            });
        }

        //绑定热键,回车提交登录
        hotkeys.bindTo(s).add({
            combo: 'return',
            description: '登录',
            allowIn: ['INPUT'],
            callback: function(event, hotkey) {
                event.preventDefault();
                s.loginSubmit();
            }
        });

        //登录
        s.certLoginSubmit = function(){

            var params = {};
            if(s.rememberMe){
                params.cookieExpireInSeconds = 60 * 60 * 24 * 7; //7 days
            }

            //超时设置1分钟
            $http.jsonp(certLoginApi+'?callback=JSON_CALLBACK', {params:params, timeout: 60*1000}).success(function(data){

                //登录成功
                if(data.res === 0 || data.res === 1){
                    sso(data.res);
                    //登录失败
                }else{
                    resPorcess(data.res);
                }

            }).error(function(){
                s.error.type = 'error';
                s.error.msg = '登录失败,请稍后再试!';
            });
        }

    }]);

    angularAMD.bootstrap(app);

});
