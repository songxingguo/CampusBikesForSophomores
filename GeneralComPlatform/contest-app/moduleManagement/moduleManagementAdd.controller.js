/**
 * Created by tjc on 2017/07/02
 * 模块新增
 */
define(['angularAMD','gotop','ui-pagination','angular','angular-messages',
        'ng-verify','datePicker','/filter/displayDate.filter' ,
        'popup-message','angular-messages','ui-autocomplete','contest-app/moduleManagement/moduleManagement.service',
        'common-app/common.service'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','moduleManagement','common','$state','$stateParams', function(s,moduleManagement,common,$state,sp){
            s.moduleObject={}; //一个模块
            /**
             * 返回顶部
             */
            gotop();

            //传过来的父节点编码
            s.parentCode=sp.parentCode;

            /**
             * 新增模块
             */
            s.addModuleObject=function(){
                if (s.parentCode != null && s.parentCode != '')
                    s.moduleObject.parentCode=s.parentCode;
                moduleManagement.addModuleManagement(s.moduleObject).then(function(data){
                    if (data['status'] == 'true')
                        showToast(getPrompt(1, "新增"));
                    else
                        showToast(getPrompt(2, "新增"));

                    $state.go("center.moduleManagement");
                    moduleManagement.getNavList().then(function (data) {
                        s.navList = data;
                        if (s.navList.length == 0) {
                            showMsg("warning", getPrompt(15));
                        }
                    });
                });
            }
        }];

    });