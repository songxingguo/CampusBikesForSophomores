/**
 * Created by tjc on 2017/07/06.
 */
define(['angularAMD','gotop','ui-pagination','angular','angular-messages',
        'ng-verify','datePicker','/filter/displayDate.filter','directive/remoteValidationDate',
        'popup-message','angular-messages','ui-autocomplete','contest-app/userManagement/userManagement.service',
        'common-app/common.service'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','userManagement','common','$state','$stateParams', function(s,userManagement,common,$state,sp){

            /**
             * 返回顶部
             */
            gotop();

            s.stateType=[{'state':0,'name':"禁用"},{'state':1,'name':"启用"}];
            s.curRoleType = window.localStorage["curRoleType"];

            /**
             * 新增用户
             */
            s.userObject={};

            s.addUserObject=function(){
            	console.info(s.userObject);
                userManagement.addUsers(s.userObject).then(function(data){
                    console.info(data);
                    if(data.status == "true"){
                        $state.go("center.userManagement");
                        showToast(getPrompt(1,'新增'));
                    }
                    else if (data.status == "false"){
                        $state.go("center.userManagement");
                        showToast(getPrompt(2,'新增'));
                    } else {
                        showMsg("error", getPrompt(12,"修改"));
                    }

                });
            };
            
            /**
             * 得到单位名称和角色
             * */
        //    s.organization={};
            s.orgList=[];
            s.roleList=[];
            (s.getRoleAndOrg=function () {
                userManagement.getRole().then(function(data){
                    s.roleList=data;
                });
            })();

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

                s.userObject.roleId=ids;

                if(chk.length>4){
                    s.userObject.roleName="已选中"+chk.length+'个角色';
                }
                else{
                    s.userObject.roleName=name;
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
