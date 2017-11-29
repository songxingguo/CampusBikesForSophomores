/**
 * Created by tjc on 2017/07/06.
 * 角色权限
 */
define(['angularAMD','gotop', 'ui-bootstrap','ui-countdown','contest-app/rolePermission/rolePermission.service',
        'common-app/common','datePicker','popup-message','angular-messages','ui-pagination',
'common-app/commonPrompt','jquery-ztree','modules/jquery-ztree/jquery.ztree.excheck','contest-app/center/center.service'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','rolePermission','center', function(s,rolePermission,center){

            /**
             * 返回顶部
             */
            gotop();

            /**
             *检测分页
             */
            s.$watch('currentPage', function(currentPage) {
                s.loadList();
            });

            /**
             * 得到角色权限列表
             */
            s.rolePermissionList=[];
            s.condition={};
            s.currentPage = 1;//当前页数
            s.itemsPerPage = 10;//每页显示的条数
            s.totalItems=0;//总条数
            s.loadList=function(){
                s.condition.curPage=s.currentPage;
                s.condition.itemPerPage=s.itemsPerPage;
                s.condition.userId = '0001';
                rolePermission.getRolePermissionList(s.condition).then(function(data){
                    s.rolePermissionList=data;
                });

                rolePermission.getRolePermissionListCount(s.condition).then(function(data){
                    s.totalItems = data;
                    changeDateState(s.totalItems,5);//暂无数据的方法
                });
            };

            /**
             * 删除选择的数据
             */
            s.deleteRolePermissions=function(){

                var chk = $("input[name='isCheck']:checked");
                var ids;
                if(chk.length != 0) {
                    if(chk.length == 1) {
                        ids = JSON.parse($(chk[0]).val()).id;
                    }
                    else {
                        ids = JSON.parse($(chk[0]).val()).id;
                        for(var i=1; i<chk.length; i++) {
                            ids += "," + JSON.parse($(chk[i]).val()).id;
                        }
                    }

                    showMsg("confirm",getPrompt(3),function(){
                        rolePermission.deleteByIds(ids).then(function(data){
                            console.info(typeof data.status);
                        	if(data.status == 'true'){
                        		showToast(getPrompt(1,'删除'));                        
                        	}else
                                showMsg("error", getPrompt(21,'删除'));
                            s.loadList();
                        });
                    });
                }
                else {
                    showMsg("warning",getPrompt(4));
                }
            }
            
            /**
             * 搜索
             */
            s.searchRole=function(){
                s.currentPage = 1;
                window.localStorage["isLoading"]=false;
                s.loadList();
            }

            /**
             * 基础权限设置
             */
            s.curRoleType=window.localStorage["curRoleType"];
            s.basisRole=[];
            s.navList=[];
            s.setBasisRole=function(){
                s.roleBasis={};
                window.localStorage["isLoading"]=false;
                rolePermission.getRolePermissionList(s.roleBasis).then(function(data){
                    s.basisRole=data;
                    openBlockUI();
                    s.loadTree("tree",s.basisRole,1,"id","","name");
                });

                s.loadModuleTree();
            };

            s.loadModuleTree=function(id){
                s.navList=[];
                center.getmodule().then(function(data){
                    var temp=data;
                    if(id){
                        rolePermission.getPermissionsById(id).then(function(data){
                            s.navList=s.setModule(temp,data);
                            s.loadTree("module",s.navList,2,"module_code","parent_code","module_name");
                        });
                    }else{
                        s.navList=s.setModule(temp);
                        s.loadTree("module",s.navList,2,"module_code","parent_code","module_name");
                    }

                });
            }

            /**
             * 加载树
             * @param treeID
             * @param data
             * @param type
             * @param idKey
             * @param pIdKey
             * @param name
             */
            s.loadTree = function (treeID,data,type,idKey,pIdKey,name) {
                var zTree;

                var check1={
                    enable: true,
                    chkStyle:"checkbox"
                };
                if(type==1){
                    check1={
                        enable: true,
                        chkStyle: "radio",
                        radioType: "all"
                    };
                }

                var setting = {
                    check:check1,
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: idKey,
                            pIdKey: pIdKey, //父id编号命名
                            rootPId: ""
                        },
                        key:{
                            name:name
                        }
                    },
                    /**
                     * 监听点击事件
                     */
                    callback: {
                        onClick: zTreeOnClick,

                        beforeClick: function (treeId, treeNode) {
                            var zTree = $.fn.zTree.getZTreeObj("tree");
                            if (treeNode.isParent) {
                                zTree.expandNode(treeNode);
                            }
                            return true;
                        },
                        onCheck: zTreeOnCheck
                    }
                };

                /**
                 * 点击触发onclick事件
                 */
                function zTreeOnClick() {

                }

                function zTreeOnCheck(event, treeId, treeNode){
                    if(type==1){
                        s.loadModuleTree(treeNode.id);
                    }else{
                        var role = $.fn.zTree.getZTreeObj("tree");

                        var roleNodes=role.getCheckedNodes(true);
                        if(roleNodes.length==0){
                            showMsg("warning","请选择角色名称！");
                            return false;
                        }
                    }
                }

                var t = $("#"+treeID);
                t = $.fn.zTree.init(t, setting, data);
                var zTree = $.fn.zTree.getZTreeObj(treeID);
                zTree.expandAll(false);
            };

            /**
             * 设置数据
             */
            s.setModule=function(data,selectData){
                for(var i=0;i<data.length;i++){
                    data[i].url=null;
                    if(selectData){
                        if(selectData.moduleCodes){
                            for(var j=0;j<selectData.moduleCodes.length;j++){
                                if(data[i].module_code==selectData.moduleCodes[j]){
                                    data[i].checked=true;
                                }
                            }
                        }
                    }
                }
                return data;
            };

            s.permissionList=[];
            s.getRolePermissionsOfId=function(id){
                rolePermission.getPermissionsById(id).then(function(data){
                    s.permissionList=data;
                    return  s.permissionList;
                });
            }

            s.savePermission=function(){
                var zTree = $.fn.zTree.getZTreeObj("module");

                var nodes=zTree.getCheckedNodes(true);

                var result=[];
                var num=0;
                if(nodes.length==0){
                    showMsg("warning","请选择权限明细！");
                    return false;
                }
                for (var i = 0; i < nodes.length; i++) {
                    var halfCheck = nodes[i].getCheckStatus();
                    if (!halfCheck.half){
                        result[num++] = nodes[i].module_code;
                        if(nodes[i].parent_code){
                            if($.inArray(nodes[i].parent_code, result)==-1){
                                result[num++] = nodes[i].parent_code;
                            }
                        }
                    }
                }

                var role = $.fn.zTree.getZTreeObj("tree");

                var roleNodes=role.getCheckedNodes(true);
                if(roleNodes.length==0){
                    showMsg("warning","请选择角色名称！");
                    return false;
                }

                var roleCode=roleNodes[0].id;
                var object={
                    id:roleCode,
                    moduleCodes:result,
                    roleName:roleNodes[0].name,
                    roleRemark:roleNodes[0].remark,
                    type:1
                };

                rolePermission.updateRolePermission(object).then(function(data){
                    showToast(getPrompt(1,'设置'));
                    closeBlockUI();
                });

            }

            s.judgeParentCode=function(){

            }
        }];

    });
