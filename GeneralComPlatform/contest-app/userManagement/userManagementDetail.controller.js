/**
 * Created by tjc on 2017/07/06.
 * 用户查看
 */
define(['angularAMD','gotop','ui-pagination','angular','angular-messages','directive/remoteValidationDate',
        'ng-verify','datePicker','/filter/displayDate.filter','common-app/common.service',
        'popup-message','angular-messages','ui-autocomplete','contest-app/userManagement/userManagement.service'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','userManagement','$state','$stateParams','common', function(s,userManagement,$state,sp,common){

            /**
             * 返回顶部
             */
            gotop();

            s.id = sp.id;//传过来的参数

            /**
             * 得到角色
             * */
            s.roleList=[];
            (s.getRole=function () {
                userManagement.getRole().then(function(data){
                    s.roleList=data;
                    console.info(s.roleList);
                });
            })();

            /**
             * 得到一条数据
             */
            s.userObject={};
            s.orgCode="";
            s.state="";
            (s.loadBegin=function(){
                userManagement.getUsersById(s.id).then(function(data){
                   /* s.userObject=data;
                    s.userName = data.name;
                    s.userCode = data.code;
                    //s.orgCode=s.userObject.organization;
                    if (s.userObject.state == 0)
                        s.state = "禁用";
                    else
                        s.state = "启用";

                    s.initCheckBox(data.roleId);
                    // s.select();*/
                   s.userObject=data;
                });
            })();

            /**
             * 返回上一页
             */
            s.backBeforPage=function() {
                window.history.go(-1);
            };

            /**
             * 初始化所属角色
             * */
            // (s.initRoleName = function () {
            //     var roleIdArray = s.userObject.roleId.split(',');
            //     for (var i = 0; i < roleIdArray.length; i++)
            //         for (var j = 0; j < s.roleList.length; j++) {
            //             if (s.roleList[j].id == roleIdArray[i]) {
            //                 if (i == roleIdArray.length - 1)
            //                     s.userObject.roleName += s.roleList[j].name;
            //                 else
            //                     s.userObject.roleName += s.roleList[j].name + ',';
            //
            //                 break;
            //             }
            //         }
            // })();

            /**
             * 初始化多选框
             * */
            s.initCheckBox = function (roleId) {
                var roleIdArray = roleId.split(',');
                console.info(roleIdArray);
                for (var i = 0; i < roleIdArray.length; i++) {
                    // document.getElementById(roleIdArray[i]).checked = true;
                     console.info(document.getElementById(roleIdArray[i]));
                }
            };

            /**
             * 修改用户
             * */
            s.updateUserObject=function () {
            	console.info(s.userObject);
            	s.userObject.userId=s.id;
                //s.userObject.organization=s.orgCode;
            	userManagement.updateUserObject(s.userObject).then(function (data) {
                    if (data.status == "true") {
                        $state.go("center.userManagement");
                        showToast(getPrompt(1,'修改'));
                    } else if (data.status == "false") {
                        $state.go("center.userManagement");
                        showToast(getPrompt(2,'修改'));
                    }
                    else {
                        showMsg("error",getPrompt(12,'修改'));
                    }
                });
            };

            /**
             * 点击选择所属角色下拉框
             */
            s.caretFlag = true;
            $(".dropdown").click(function(){
                $(".dropdown-menu").slideToggle();
                if (s.caretFlag)
                    $('#caret').removeClass('caret_top').addClass('caret_bottom');
                else
                    $('#caret').removeClass('caret_bottom').addClass('caret_top');

                s.caretFlag = !s.caretFlag;
            });

            /**
             * 选择多选框触发事件
             */
            s.select=function() {
                var chk = $("input[name='isCheck']:checked");
                var ids;
                var name;
                if (chk.length != 0) {
                    if (chk.length == 1) {
                        ids = JSON.parse($(chk[0]).val()).id;
                        name = JSON.parse($(chk[0]).val()).name;
                    }
                    else {
                        ids = JSON.parse($(chk[0]).val()).id;
                        name = JSON.parse($(chk[0]).val()).name;
                        for (var i = 1; i < chk.length; i++) {
                            ids += "," + JSON.parse($(chk[i]).val()).id;
                            name += "," + JSON.parse($(chk[i]).val()).name;
                        }
                    }
                }

                s.userObject.roleId = ids;

                if (chk.length > 4) {
                    s.userObject.roleName = "已选中" + chk.length + '个角色';
                }
                else {
                    s.userObject.roleName = name;
                }
            };
        }];

    });

/**
 *密码一致性验证
 */
var userManagementAdd = angular.module('userManagementAdd', []);
userManagementAdd.directive('pwCheck', function () {
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
