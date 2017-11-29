/**
 *  Created by songxingguo on 2017/7/2.
 *  登录
 */

define(['angularAMD', 'jquery', 'shiv', 'respond', 'login/login.service', 'bootstrap'],
    function (angularAMD) {

    //延迟加载的module需要调用
    angularAMD.processQueue();

    //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
    return ['$scope','login','$state', function(s,login,$state) {

        /**
         * 获取学校信息
         */
        s.schoolList = [];
        s.condition = {};
        s.searchSchools = function () {
           login.getSchools(s.condition).then(function (data) {
                s.schoolList = data;
           });
        };

        /**
         * 确认选择
         */
        s.ensureSchool = function (school) {
            s.registerObject.schoolId = school.id;
            s.registerObject.schoolName = school.name;
        };

        /**
         *  注册
         */
        s.registerObject = {};
        s.registerUser = function () {
            login.register(s.registerObject).then(function (data) {
                if (data.state = 'true') {
                    alert("不错喔");
                } else {

                }
            });
        };

    }];

});