/**
 * Created by TJC on 2017/07/04
 * 模块查看
 */
define(['angularAMD','gotop','ui-pagination','angular','angular-messages',
        'ng-verify','datePicker','/filter/displayDate.filter','popup-message',
        'angular-messages','ui-autocomplete','contest-app/moduleManagement/moduleManagement.service',
        'common-app/common.service'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','moduleManagement','common','$state','$stateParams', function(s,moduleManagement,common,$state,sp){

            /**
             * 返回顶部
             */
            gotop();

            /**
             * 得到一条数据
             */
            s.id = sp.id;//传过来的参数
            s.moduleObject={};
            s.moduleType=[];
            (s.loadBegin=function(){
                moduleManagement.getModuleObjectById(s.id).then(function(data){
                    s.moduleObject=data;
                    s.moduleName = data.module_name;
                    console.info(s.moduleType);
                    for (var i = 0; i < s.moduleType.length; i++) {
                        document.getElementById(s.moduleType[i]).value = s.moduleType[i];
                        document.getElementById(s.moduleType[i]).checked = true;
                    }
                });
            })();

            s.addModuleType=function (type) {
                if(document.getElementById(type).checked == true)
                    s.moduleType.push(type);
                else {
                    var index = s.moduleType.indexOf(type);
                    s.moduleType.splice(index,1);
                }
                console.info(s.moduleType);
            };

            /**
             * 修改模块
             */
            s.updateModuleObject=function(){
                moduleManagement.updateModuleObject(s.moduleObject).then(function(data){
                    if (data['status'] == 'true')
                        showToast(getPrompt(1, "修改"));
                    else
                        showToast(getPrompt(2, "修改"));

                    $state.go("center.moduleManagement");
                    moduleManagement.getNavList().then(function (data) {
                        s.navList = data;
                        if (s.navList.length == 0) {
                            showMsg("warning", getPrompt(15));
                        }
                    });
                });

            };
            
            /**
             * 返回上一个页面
             */
            s.goBack=function(){
            	 history.back();
            }
        }];

    });