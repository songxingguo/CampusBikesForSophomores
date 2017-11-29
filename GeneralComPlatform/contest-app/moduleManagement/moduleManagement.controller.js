/**
 * Created by tjc on 2017/07/02.
 * 模块管理
 */
define(['angularAMD','gotop', 'ui-bootstrap','ui-countdown','contest-app/moduleManagement/moduleManagement.service',
        'common-app/common','datePicker','popup-message','angular-messages','ui-pagination'],
    function (angularAMD,gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope','moduleManagement', function(s,moduleManagement){

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
             * 得到模块列表
             */
            s.moduleManagementList=[];
            s.condition={};
            s.conditionOther={};
            s.searchValue = ""; //搜索框里面的值
            s.currentPage = 1;//当前页数
            s.itemsPerPage = 10;//每页显示的条数
            s.nextPageNum = 0;//进入下一级数据条数
            s.totalItems=0;//总条数
            s.loadList=function(){
                s.condition.curPage=s.currentPage;
                s.condition.itemPerPage=s.itemsPerPage;
                moduleManagement.getModuleManagementList(s.condition).then(function(data){
                    //console.info(data);
                    s.moduleManagementList=data;
                });

                moduleManagement.getModuleManagementListCount(s.condition).then(function(data){
                    s.totalItems = data;
                    changeDateState(s.totalItems,5);//暂无数据的方法
                });
            };

            /**
             * 删除选择的数据
             */
            s.deleteModuleManagements=function(){
                var chk = $("input[name='isCheck']:checked");
                var ids;
                if(chk.length != 0) {
                    if(chk.length == 1) {
                        ids = JSON.parse($(chk[0]).val()).code;
                    }
                    else {
                        ids = JSON.parse($(chk[0]).val()).code;
                        for(var i=1; i<chk.length; i++) {
                            ids += "," + JSON.parse($(chk[i]).val()).code;
                        }
                    }

                    showMsg("confirm",'您确定要删除选择的内容吗?',function(){
                        moduleManagement.deleteByIds(ids).then(function(data){
                            if (data['status'])
                                showToast(getPrompt(1, "删除"));
                            //    showToast("删除成功");
                            else
                                showToast(getPrompt(2, "删除"));
                             //   showToast("删除失败");
                            s.loadList();
                        });
                    });
                }
                else {
                    showMsg("warning",'请至少选择一项');
                }
            };

            /**
             * 上移
             */
            s.moveUp=function(object){
                if (s.moduleManagementList.indexOf(object) == 0)
                    showMsg("error","已经在最上方,不可移动");
                else
                    moduleManagement.moveUp(object).then(function(data){
                        if (data['status'] == 'true') {
                            showToast(getPrompt(1, "上移"));
                            s.loadList();
                        }
                        else
                            showMsg("error","上移失败");
                    });
            };

            /**
             * 下移
             */

            s.moveDown=function(object){
                if (s.moduleManagementList.indexOf(object) == (s.itemsPerPage - 1) ||
                    s.moduleManagementList.indexOf(object) == (s.moduleManagementList.length - 1))
                    showMsg("error","已经在最下方,不可移动");
                else
                    moduleManagement.moveDown(object).then(function(data){
                        if (data['status'] == 'true') {
                            showToast(getPrompt(1, "下移"));
                            s.loadList();
                        }
                        else
                            showMsg("error","下移失败");
                    });
            };

            /**
             * 进入下一级
             */
            s.parentCodesArray = []; //每个等级的parentCode
            //s.parentCode="";
            //$("#changeState").disabled = true;
            s.idLevel = 0; //当前导航栏的等级
            //提取公共字符串      
            s.intoId="#level";
            var judge = true;
            if(judge == true){	 	
	            s.enterNextLevel=function(moduleName,moduleCode,level){
	            	//将每个级别的parentCode存入数组，方便返回父级
	                s.parentCodesArray[s.idLevel]=moduleCode;
	                s.idLevel2 =s.idLevel+1;
	
	                //在当前导航栏末尾添加一个span标签
	                $(s.intoId+s.idLevel).after("<span style=color:#e6e9eb;"+ "margin-left:-2px; id='"+"symbol"+s.idLevel2+"'>＞</span>"+
	                    "<span style='color: #6cb7f1' id='"+"level"+s.idLevel2+"'>"+moduleName+"</span>");
	                //将当前的span改为a标签
	                $(s.intoId+s.idLevel).html("<a onclick='gotoFather("+level+")'>"+$(s.intoId+s.idLevel).text() +"</a>");
	                //更新当前等级
	                s.idLevel=s.idLevel2;
	                s.parentCode=moduleCode;
                	s.condition.currentPage=s.currentPage;
                	s.condition.itemsPerPage=s.itemsPerPage;
                	s.condition.parentCode=moduleCode;
                	console.info(s.conditionOther);
	                moduleManagement.getModuleManagementList(s.condition).then(function(data) {
	                    s.moduleManagementList=data;
	                    /*if(data==null||data==""){
	                    	showToast(getPrompt(22,''));
	                    	gotoFather(level);
	                    }*/
	                });
	
	                moduleManagement.getModuleManagementListCount(s.condition).then(function(data) {
	                    s.totalItems = data;
	                    //alert(data.total);
	                    changeDateState(s.totalItems,5);
	                });
	            }
                judge = false;
            };

            /**
             * 进入父级，强制进入当前的上一级
             */
            window.gotoFather = function (level) {
            	var judge = true;
            	if(judge == true){
            		//删除当前节点的元素
	                for(;s.idLevel>level;s.idLevel--){
	                	if(s.idLevel == 0){
	                		break;
	                	}
	                    $("#symbol"+s.idLevel).remove();
	                    $(s.intoId+s.idLevel).remove();
	                }
	                //更新当前节点
	                //s.idLevel =level;
	                //修改当前节点元素
	                $(s.intoId+s.idLevel).html( "<span style='color: #6cb7f1'>"+$(s.intoId+s.idLevel).text()+"</span>");
					s.condition.parentCode=s.parentCodesArray[s.idLevel-1];
					s.parentCode=s.parentCodesArray[s.idLevel-1];
	                if(s.parentCodesArray[s.idLevel-1] == null){
	                    s.loadList();
	                }
	                else{
	                	s.condition.currentPage=s.currentPage;
	                	s.condition.itemsPerPage=s.itemsPerPage;
	                	s.condition.parentCode=s.parentCode;
	                    moduleManagement.getModuleManagementList(s.condition).then(function(data) {
	                        s.moduleManagementList=data;
	                    });
	
	                    moduleManagement.getModuleManagementListCount(s.condition).then(function(data) {
	                        s.totalItems = data;
	                        changeDateState(s.totalItems,5);
	                    });
	                }
	            }
                judge = false;
            };

            /**
             * 搜索
             */
            s.searchObject=function(level){
                s.loadList();
            };
        }];
    });