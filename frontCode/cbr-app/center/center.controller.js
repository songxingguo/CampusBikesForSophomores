/**
 *  Created by songxingguo on 2017/7/2.
 *  登录
 */

define(['angularAMD', 'jquery', 'bootstrap', 'shiv', 'respond', 'center/center.service'],
    function (angularAMD) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','login','$state', function(s,server,$state){
            /**
             * 登录与注册进行切换
             * @author songxingguo
             * 2017-7-6
             */
            s.isShowLogin = true; //默认显示登录
            s.switchLogin = function () {
                s.isShowLogin = !s.isShowLogin;
            };
        }];

    });