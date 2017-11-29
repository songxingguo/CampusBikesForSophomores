/**
 * Created by yuanding on 2016/10/12.
 * 角色权限查看
 */
define(['angularAMD','gotop','ui-pagination','angular','angular-messages',
        'ng-verify','datePicker','/filter/displayDate.filter'
        ,'popup-message','angular-messages','ui-autocomplete','contest-app/rolePermission/rolePermission.service'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','rolePermission','$state','$stateParams','center', function(s,rolePermission,$state,sp,center){

            /**
             * 返回顶部
             */
            gotop();

            s.id = sp.id;//传过来的参数

            /**
             * 得到一条数据
             */
            s.rolePermissionObject={};
            s.selectModule =[]; //被选择的模块
            (s.loadBegin=function(){
                rolePermission.getPermissionsById(s.id).then(function(data){
                    s.rolePermissionObject=data;
                    s.selectModule=data.moduleCodes;
                });
            })();

            /**
             * 得到模块
             */
            s.moduleConds={};
            s.moduleList=[];
            (s.getModuleList=function(){
                center.getNavList().then(function(data){
                    s.moduleList=data;
                });
            })();

            /**
             * 显示被选择的模块
             */
            s.isSelected=function(moduleCode){
                for(var i=0;i<s.selectModule.length;i++){
                    if (moduleCode == s.selectModule[i]) {
                        return true;
                    }
                }
                return false;
            };

            /**
             * 隔行换色
             */
            s.count  = 0;
            s.colorChange = function (moduleCode) {
                s.count++;
                if (s.isSelected(moduleCode)) {
                    if (s.count%2==1) {
                        return true;
                    }
                }
                return false;
            };
        }];

    });
