/**
 * Created by tjc on 2017/07/07.
 */
define(['angularAMD','gotop', 'ui-bootstrap','ui-countdown','contest-app/userManagement/userManagement.service',
        'common-app/common.service','common-app/common','datePicker','popup-message','angular-messages','ui-pagination'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','userManagement','common', function(s,userManagement,common){

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
             * 加载角色类型
             */
            // s.typeList=[];
            // s.typeConds={};
            // (s.loadType=function(){
            //     common.getParamList(s.typeConds).then(function(data){
            //         s.typeList=data;
            //     });
            // })();

            
            /**
             * 得到用户列表
             */
            s.userManagementList=[];
            s.roleList={};
            s.condition={};
            s.currentPage = 1;//当前页数
            s.itemsPerPage = 10;//每页显示的条数
            s.totalItems=0;//总条数
            s.loadList=function(){
                s.initList();
                
                userManagement.getRole().then(function(data){
            		s.roleList = data;
            	});
            };
			
			/**
			 * 初始化列表
			 */
			s.initList=function(){
				s.condition.curPage=s.currentPage;
                s.condition.itemPerPage=s.itemsPerPage;
                s.condition.userId = '0001';
                if(s.condition.userName == null||s.condition.userName == undefined){
                	s.condition.userName = "";
                }
                userManagement.getUserManagementList(s.condition).then(function(data){
                    s.userManagementList=data;
                    console.info(s.userManagementList);
                });

                userManagement.getUserManagementListCount(s.condition).then(function(data){
                    s.totalItems = data.totalItems;
                    changeDateState(s.totalItems,5);//暂无数据的方法
                });
			}
			
            /**
             * 删除选择的数据
             */
            s.deleteUser=function(){
                var chk = $("input[name='isCheck']:checked");
                var ids;
                console.info(chk);
                if(chk.length != 0) {
                    if(chk.length == 1) {
                        ids = JSON.parse($(chk[0]).val()).id;
                    }else{
                        ids = JSON.parse($(chk[0]).val()).id;
                        for(var i=1; i<chk.length; i++) {
                            ids += "," + JSON.parse($(chk[i]).val()).id;
                        }
                    }
                    showMsg("confirm",getPrompt(3),function(){
                        userManagement.deleteByIds(ids).then(function(data){
                            if (data.status == "true")
                                showToast(getPrompt(1, "删除"));
                            else if (data.status == "false")
                                showMsg("error","该用户已被使用,不能删除!");
                            else
                                showMsg("error","成功删除" + data.success + "条,删除失败" + data.fail + "条失败原因:该用户被占用,不能删除！");

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
            //s.userObject={};
            s.searchObject=function(){
                s.initList();
            };
            
            /**
             * 加载角色
             */
            
            s.roleObject=function(){
            	userManagement.getRole().then(function(data){
            		s.roleObject = data;
            	});
            }
        }];

    });
