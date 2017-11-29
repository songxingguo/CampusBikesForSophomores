/**
 * Created by tjc on 2017/07/02.
 */
define(['angularAMD', 'gotop', 'ui-pagination', 'angular', 'angular-messages',
        'contest-app/moduleManagement/moduleManagement.service',
        'ng-verify', 'datePicker', '/filter/displayDate.filter', 'popup-message',
        'ui-autocomplete', 'contest-app/center/center.service', 'common-app/common.service',
        'easyscroll','modules/easyscroll/mousewheel','angular-animate','common-app/common','common-app/common','jquery.nicescroll'],
    function (angularAMD,gotop) {

    //延迟加载的module需要调用
    angularAMD.processQueue();


        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
    return ['$scope','center','moduleManagement','$state', function(s,center,mm,$state) {

        /**
         * 加载导航栏
         */
       /* s.navList = [{"menu_name":"模块管理","path":"center.moduleManagement"},
                     {"menu_name":"运营商管理","path":"center.operatorManagement"}];*/
        (s.loadNav = function () {
            mm.getNavList().then(function (data) {
                s.navList = data;
                if (s.navList.length == 0) {
                    showMsg("warning", getPrompt(15));
                }
            });
        })();

        /**
         * 返回顶部
         */
        gotop();

        /**
         * 设置框架高度
         */
        (s.loadFrame = function () {
            $('#mainCenter').css('minHeight', ($(window).height()) + 'px');
            $('.left_content').css('minHeight', ($(window).height()) + 'px');
            $('.left_content').css('backgroundPosition', "0px" + " " + ($(window).height() - 156) + 'px');
            $('.divScroll').css('height', (($(window).height()) - 150 - 50) + 'px');
            $('.mainBody').css('minHeight', ($(window).height()) + 'px');
            // $('#mainContent').css('minHeight', ($(window).height() - 65) + 'px');
            $('#passwordBounced').hide();
            $('#baseInfoBounced').hide();
        })();

        /**
         * 展示子节点
         * @param id
         */
        s.before = '';
        s.flag = true;
        s.showChildNode = function (id, childrenLength) {
            $("#" + id).slideToggle("normal", function () {

                if (childrenLength <= 3) {
                    $('#' + id + " .div_scroll").css('height', (40 * childrenLength) + 'px');
                }

                $('.div_scroll').scroll_absolute({arrows: false});

                $('#' + id + 'Nav').parent().removeAttr("style");
                $('#' + s.before + 'Nav').parent().removeAttr("style");
                if (s.before == id) {
                    if ($(this).is(':hidden')) {
                        s.before = '';
                        $("#" + id + 'Nav').removeAttr("style");
                    } else {
                        s.before = id;
                    }
                } else {
                    $("#" + s.before).slideToggle("normal");
                    $("#" + s.before + 'Nav').removeAttr("style");
                    $('#' + id + 'Nav').css({
                        "background": "url('img/hoverBack.png')",
                        "color": "#ffffff",
                        "background-repeat": "no-repeat"
                    });
                    $('#' + id + 'Nav').parent().css({"background": "#6cb7f1"});
                    s.before = id;
                }
            });
        };

        /**
         * 得到登录信息
         */
        s.loginInfo = {};
        (s.getInfo = function () {
            center.getLoginInfo().then(function (data) {
                s.loginInfo = data;
                if (s.loginInfo.organizationName == null) {
                    s.loginInfo.organizationName = '平台管理';
                }
            });
        })();

        /**
         *得到通知数量
         */
        s.judge;
        s.noticeNum = 0;
        (s.getNoticesNum = function () {
            center.getNotice().then(function (data) {
                s.noticeNum = data;
                /**
                 * 显示小圆圈
                 */
                s.judge= (s.noticeNum>0);
            });
        })();

        s.time = '';
        (s.getTime = function () {
            var d = new Date()
            var vYear = d.getFullYear()
            var vMon = d.getMonth() + 1
            var vDay = d.getDate()
            var h = d.getHours();
            var m = d.getMinutes();
            var se = d.getSeconds();

            s.week = "星期" + "日一二三四五六".split("")[new Date().getDay()];

            s.time = vYear + '年' + vMon + '月' + vDay + '日';
            s.minute = h + "：" + m;

            //setInterval(function(){
            //    s.$apply(s.getTime());
            //},60000);
        })();
        /**
         * 显示修改密码弹框
         * */
        s.showPasswordBounced = function () {
            $.blockUI({
                message: $("#openPwdUI"),
                css: blockCsso,
                overlayCSS: overlayCSS
            });
        };

        s.hidePasswordBounced = function () {
            $.unblockUI();
            s.oldPassword = '';
            s.againPassword = '';
            s.password = '';
        };

        /**
         * 显示修改基本资料弹框
         * */
        s.showBaseInfoBounced = function () {
            $.blockUI({
                message: $("#openSingleUI"),
                css: blockCsso,
                overlayCSS: overlayCSS
            });
        };
        var blockCsso = {
            width: 'auto',
            top: '10%',
            left: '15%',
            border: 'none',
            backgroundColor: '#FFF',
            'border-radius': '10px 10px 0 0',
            cursor: 'default'
        };
        var overlayCSS = {cursor: 'default', backgroundColor: '#d0d1d2'};
        s.hideBaseInfoBounced = function () {
            $.unblockUI();
            s.getInfo();
        };

        /**
         * 修改密码
         * */
        s.showCancel = true;
        s.password = "";
        s.updateUserPasswordCreatedByTY = function () {
        	window.localStorage["isLoading"]=false;
            center.updatePassword(s.oldPassword, s.password).then(function (data) {
                if (data.status == 'true') {
                    s.isUpPawClicked = false;
                    showToast(getPrompt(1, "修改"));
                    s.hidePasswordBounced();
                }
                else if (data.status == 'false') {
                    showToast(getPrompt(2, "修改"));
                    s.isUpPawClicked = false;
                    s.hidePasswordBounced();
                }
                else
                    showMsg("error", "初始密码不正确!");

            });
            s.showCancel = true;
        };

        /**
         * 修改基本信息
         * */
        s.updateBaseInfo = function () {
        	window.localStorage["isLoading"]=false;
            center.updateBaseInformation(s.loginInfo).then(function (data) {
                if (data.status == "true") {
                    s.isInfoClicked = false;
                    showToast(getPrompt(1, '修改'));
                    s.hideBaseInfoBounced();
                } else if (data.status == "false") {
                    s.isInfoClicked = false;
                    showToast(getPrompt(2, '修改'));
                    s.hideBaseInfoBounced();
                }
                else {
                    showToast(getPrompt(10, '修改'))
                }

            });
        }

        s.showView = false;
        s.$on('$viewContentLoaded', function () {
            s.showView = true;
        });

        s.$on('$routeChangeStart', function (evt, next, current) {

        });

        /**
         * 显示下拉框
         */
        s.isShow = false;
        s.showInfo = function (type) {
            if (type == 1) {
                $("#showInfo").hide();
                $("#showAllInfo").slideDown('normal');
                s.isShow = true;
                $("body").bind('click',s.onBodyDown); //绑定点击事件
            } else {
                $("#showAllInfo").slideUp('normal');
                $("#showInfo").show();
                s.isShow = false;
            }
        };

        /**
         * 点击空白区域隐藏
         */
        var gldwListId={infoId:"showAllInfo",iId:"showInfo"};
        s.onBodyDown = function(event){
            if (!($(event.target).parents("#"+gldwListId.iId).length>0 || event.target.id == gldwListId.infoId ||
                 event.target.id == gldwListId.iId ||  event.target.id == gldwListId.iId|| $(event.target).parents("#"+gldwListId.infoId).length>0)) {
                s.isShow=false;
                $("#showAllInfo").slideUp('normal');
                $("#showInfo").show();
                $("body").unbind('click',s.onBodyDown);
                s.$apply();
            }
        };

        /**
         * 验证初始密码
         * */
        (s.loadPassword=function(){
            center.judgePassword().then(function(data){
                if (data.status == 'true') {
                    s.showPasswordBounced();
                    s.showCancel = false;
                }
            });
        })();
    }];
});

/**
 *密码一致性验证
 */
var updateUserPassword = angular.module('updateUserPassword', []);
updateUserPassword.directive('pwCheck', function () {
    return {
        require: "ngModel",
        link: function(scope, elem, attrs, ctrl) {
            console.log(attrs);
            var otherInput = elem.inheritedData("$formController")[attrs.pwCheck];

            ctrl.$parsers.push(function(value) {
                if(value === otherInput.$viewValue) {
                    ctrl.$setValidity("pwmatch", true);
                    return value;
                }
                ctrl.$setValidity("pwmatch", false);
            });

            otherInput.$parsers.push(function(value) {
                ctrl.$setValidity("pwmatch", value === ctrl.$viewValue);
                return value;
            });
        }
    };
});
