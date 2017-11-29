/**
 *  Created by songxingguo on 2017/7/6.
 *  个人信息
 */

define(['angularAMD', 'jquery', 'bootstrap', 'shiv', 'respond', 'personalInfo/personalInfo.service'],
    function (angularAMD) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','$state', function(s,server,$state){

            //个人信息列表
            s.personalList = [{'name': '个人资料', 'url': 'personalProfile'},
                {'name': '账户充值', 'url': 'recharge'},
                {'name': '修改密码', 'url': 'personalProfile'},
                {'name': '我的订单', 'url': 'personalProfile'},
                {'name': '消息通知', 'url': 'personalProfile'}];

            /**
             * 切换个人信息内容
             */
            s.switchPersonalInfoContent = function (index,id) {
                $('#' + id + ' img').attr('src','../../images/'+ id + '-white.png');
                $('#' + id).attr('background-color',' #54be74');
            };
        }];
    });