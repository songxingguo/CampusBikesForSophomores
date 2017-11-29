/**
 * Created by tjc on 2017/07/06.
 * 角色新增
 */
define(['angularAMD','gotop','ui-pagination','angular','angular-messages',
        'ng-verify','datePicker','/filter/displayDate.filter'
        ,'popup-message','angular-messages','ui-autocomplete','contest-app/rolePermission/rolePermission.service',
        'common-app/common.service','contest-app/center/center.service'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','rolePermission','common','$state','$stateParams','center',
        function(s,rolePermission,common,$state,sp,center){

            /**
             * 返回顶部
             */
            gotop();

            /**
             * 得到模块
             */
            s.moduleConds={};
            s.moduleList=[];
            s.getModuleList=function(){
                center.getNavList().then(function(data){
                    s.moduleList=data;
                    s.loadBegin();
                });
            };

            /**
             * 得到一条数据
             */
            s.id = sp.id;//传过来的参数
            s.rolePermissionObject={};
            s.loadBegin=function(){
                if(s.id){
                    rolePermission.getPermissionsById(s.id).then(function(data){
                        s.rolePermissionObject=data;
                        s.moduleCodes=data.moduleCodes;
                        s.showSelect();
                    });
                }
            };

            /**
             * 按顺序初始化多选框
             */
            (s.initRun = function () {
                s.getModuleList();
                s.loadBegin();
            })();

            //显示被选择的模块
            s.moduleCodes=[];
            s.showSelect = function () {
                for(var i=0;i<s.moduleCodes.length;i++){
                    $("." + s.moduleCodes[i] + "Parent").attr("checked",true);//打勾
                    $("#"+ s.moduleCodes[i]).attr("checked",true);//打勾
                }
            };

            /**
             * 新增角色权限
             */
            s.rolePermissionObject={};
            s.addRolePermissionObject=function(){
                s.rolePermissionObject.code = s.moduleCodes;
                s.rolePermissionObject.userId = '0001';
                console.info(s.rolePermissionObject);

                rolePermission.addPermissions(s.rolePermissionObject).then(function(data){
                    if (data.status == 'true') {
                        $state.go("center.rolePermission");
                        showToast(getPrompt(1,'新增'));
                    }
                    else
                        showMsg("error", getPrompt(2,"新增"));
                });
            };

            /**
             * 修改角色权限
             */
            s.updateRolePermissionObject=function(){
                console.info(s.rolePermissionObject);
                s.rolePermissionObject.moduleIds = s.selectModule;
                s.rolePermissionObject.moduleCodes = s.moduleCodes;

                rolePermission.updateRolePermission(s.rolePermissionObject).then(function(data){
                    if (data.status == 'true') {
                        $state.go("center.rolePermission");
                        showToast(getPrompt(1,'修改'));
                    }
                    else
                        showMsg("error", getPrompt(2,"修改"));
                });
            };

            /**
             * 点击输入框
             * @param id
             * @param type
             */
            s.isSelected=function(id,type){
                if(id && type==1){
                    s.select=false;
                    if($("#"+id+"Parent").attr('checked')==undefined){
                        s.select=false;
                    }else{
                        s.select=true;
                    }

                    $("#"+id+"Children" + " input[name='isCheck']").attr("checked",s.select);//打勾

                }else{
                    var temp = $("#"+id+"Children input[name='isCheck']:checked");
                    if(temp.length>0){
                        $("#"+id+"Parent").attr('checked',true);
                    }else{
                        $("#"+id+"Parent").attr('checked',false);
                    }
                }

                s.selectModule=[];
                s.moduleCodes = [];
                var chk = $(".select_module input[name='isCheck']:checked");
                for(var i=0;i<chk.length;i++){
                    s.selectModule[i]=JSON.parse($(chk[i]).val()).id;
                    s.moduleCodes[i]=JSON.parse($(chk[i]).val()).module_code;
                }
            }
        }];

    });
