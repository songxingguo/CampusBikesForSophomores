/*
* 验证服务
* 提供 登录,登出,获取用户信息等功能
* */
define(['angularAMD'], function(angularAMD){

    var popup = require('popup-message');

    angularAMD.service('auth', function($http, $q){

        var logout = '/logincomm/api/v1/token';

        //sso 退出
        var ssoApi = '/logincomm/api/v1/domains/shared/exits';

        this.login = function(){
            location = '${login_base}index.html'+'?back='+location;
        }

        var self = this;
        this.logout = function(){
            $http['delete'](logout).success(function(){

                //sso
                var ssoLogins = [];
                $http.get(ssoApi).success(function(urls){

                    angular.forEach(urls, function(url){
                        ssoLogins.push($http.jsonp(url, {params :{callback:'JSON_CALLBACK'}}));
                    });

                    //sso done
                    $q.all(ssoLogins)['finally'](function(){
                        self.login();
                    });

                }).error(function(){
                    self.login();
                })

            }).error(function(){
                popup.error('服务器或网络错误,请稍后再试!');
            })
        }

        /**
         * 获取当前登录用户
         * @param needStats 是否需要统计数据
         * @returns {*}
         */
        this.getCurrentUser = function(){
            //TODO return user
            return $q.reject('TODO return user');
        }

        /**
         * 判断用户是否登录
         */
        this.isLogin = function(){
            return this.getCurrentUser().then(function(){
                return false;
            }, function(){
                return false;
            });
        }

        /**
         * 判断 userId代表的用户是不是当前登录用户
         * @param userId 用户id
         */
        this.isSelf = function(userId){
            return this.getCurrentUser().then(function(user){
                //TODO 判断并返回结果
                return false;
            }, function(){
                return false;
            });
        }

        /**
         * 判断 orgId代表的组织是不是当前登录用户的组织
         * @param orgId 组织id
         */
        this.isOwnOrg = function(orgId){
            return this.getCurrentUser().then(function(user){
                //TODO 判断并返回结果
                return false;
            }, function(){
                return false;
            });
        }

        /**
         * 判断 当前登录用户是不是管理员
         */
        this.isAdmin = function(){
            return this.getCurrentUser().then(function(user){
                //TODO 判断并返回结果
                return false;
            }, function(){
                return false;
            });
        }
    });

});
