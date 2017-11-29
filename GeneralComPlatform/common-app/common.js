/**
 * Created by yuanding on 2016/10/4.
 */
define(['jquery','jquery-ztree','jquery-blockUI','angular','jquery-ajaxfileupload/ajaxfileupload'],function(jQuery){

    (function() {

        /*判断无数据的时候显示“暂无数据”,还是显示“没有符合条件的项”*/
        var isFirst=true;
        window.changeDateState= function(res,columns){
            $("#dateStateJudgOne").hide();
            if(isFirst){
                if(res=="0"){
                    $("#dateStateJudgOne").show();
                }
            }
            else{
                if(res=="0"){
                    $("#dateStateJudgOne").show();
                    document.getElementById("show").innerHTML="没有符合条件的项";
                }
            }
            isFirst=false;
        }

        /*格式化时间*/
        Date.prototype.Format = function (fmt) { //author: meizz
            var o = {
                "M+": this.getMonth() + 1, //月份
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds(), //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds() //毫秒
            };
            if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        };

        /*当内容过多的时候可以点击更多*/
        window.clickMore= function(me, len) {
            var content = $(me).parent().attr("title");
            content = content.replace(/</g, "&lt;");//对尖括号转义，避免在页面上展示错误
            content = content.replace(/>/g, "&gt;");
            if($(me).html()=="更多"||$(me).html()=="更多<!--IE fix-->") {
                $(me).parent().html(content+"<a class=\"clickmore icon-double-angle-up\" onclick=\"clickMore(this,"+len+")\">收起</a>");
            }else {
                $(me).parent().html(content.substring(0,len)+"<a class=\"clickmore icon-double-angle-down\" onclick=\"clickMore(this,"+len+")\">更多</a>");
            }
        };

        window.clickSelectAll=function(){
            var inputs=document.getElementsByName("isCheck") ;
            var selectAll=document.getElementById('selectAll');

            //循环设置控件为选中状态
            for (var i=0;i<inputs.length ;i++){
                if(inputs[i].type=="checkbox"){
                    inputs[i].checked=selectAll.checked;
                }
            }
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
        var overlayCSS = {cursor:'default', backgroundColor: '#d0d1d2'};

        /**
         * 打开弹框
         */
        window.openBlockUI=function(div){
                if(div!=null){
                $.blockUI({
                    message:$("#"+div),
                    css:blockCsso,
                    overlayCSS:overlayCSS
            });
            }
            else {
                $.blockUI({
                    message: $("#openBlockUI"),
                    css: blockCsso,
                    overlayCSS: overlayCSS
                });
            }
        };

        /**
         * 关闭弹框
         */
        window.closeBlockUI=function(){
            $.unblockUI();
        }

		/**
		 * 得到提示语
		 */
		window.getPrompt=function(type,operator){
			if(type==1){
				return operator+'成功';
			}else if(type==2){
				return operator+'失败';
			}else if(type==3){
				return '您确定要删除选择的内容吗';
			}else if(type==4){
				return '请至少选择一项';
			}else if(type==5){
				return '请'+operator;
			}else if(type==6){
				return '您确定要删除选择的内容吗？删除之后其子节点也将删除！';
			}else if(type==7){
				return '删除失败，此内容在其他模块使用！';
			}else if(type==8){
				return '新增失败，此名称已存在！';
			}
            else if(type==9){
                return '修改失败，此名称已存在！';
            }
            else if(type==10){
                return '您要'+operator+'的数据重复，请重新输入！';
            }
            else if (type==12) {
                return '账号或用户名重复，请重新输入！';
            }
            else if (type == 13) {
                return '该车型的参数名称重复，请重新输入！';
            }

            else if(type==11){
                return '请选择你的所属角色!';
            }
			else if(type == 14){
				return '该职工号已存在！';
			}else if(type==15){
                return '暂无模块可操作，请联系平台管理员开放权限！';
            }
            else if(type==16){
                return '请将员工信息填写完整';
            }
            else if(type==17){
                return '请将必输入内容填写完成后生成用户';
            }else if(type==18){
                return '请选择所属角色后生成用户';
            }
            else if(type==21) {
                return '删除失败，此角色在其他模块使用！';
            }
            else if(type==22){
                return '该模块下并无子模块！';
            }
            else if(type==23){
                return '最多派发'+ operator +'辆车！';
            }
            else if(type==24){
                return '需派发' + operator + '车辆！';
            }
            else if(type==25){
                return '输入不能为空！';
            }
            else{
				return '';
			}
		}

		/**
		 * 加载树形插件
		 * zNodes:传过来的数据参数
		 */
		var condition={};
		var showTree=false;
		var result={};
		window.loadOrgTree=function(zNodes){
			$("#selectTree").show();
			
			var zTree;
                var setting = {
                    view: {
                        dblClickExpand: false, //取消默认双击展开父节点的功能
                        expandSpeed: 500,  //设置树展开的动画速度
                        showLine:true,
                        //增加连接线
                        selectedMulti: false
                        //不能够复选
                    },
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "id",
                            pIdKey: "pId", //父id编号命名
                            rootPId: ""
                        },
                        key:{
                        	name:"name"
                        }
                    },
                    /**
                     * 监听点击事件
                     */
                    callback: {
                        beforeClick: function (treeId, treeNode) {
                            var zTree = $.fn.zTree.getZTreeObj("tree");
                           
                            if (treeNode.isParent) {
                                zTree.expandNode(treeNode);
                                //如果是父节点 就展开
                                return false;
                            }
                            return true;
                        },

                        onClick:function (tree){
                            var zTree = $.fn.zTree.getZTreeObj("tree");
                            var sNodes = zTree.getSelectedNodes();
                            if (sNodes.length > 0) {
                            	$("#orgInput").val(sNodes[0].name);//将值复制到输入框
                            	$("#selectTree").hide();//隐藏
                            	result.orgName=sNodes[0].name;
                            	result.parentCode=sNodes[0].pId;
                            	result.orgCode=sNodes[0].id;
                                return true;
                            }

                            return false;
                        }

                    }
                };


                var t = $("#tree");
                t = $.fn.zTree.init(t, setting,zNodes);
                zTree = $.fn.zTree.getZTreeObj('tree');
                $("body").bind('click',onBodyDown); //绑定点击事件
                return result;
		}
		
		window.getOrg=function(){
			return result;
		}
		
		/**
             * 点击空白区域隐藏
             */
        var gldwTreeId={inputId:"orgInput",divId:"selectTree",treeId:"tree"};
       	window.onBodyDown = function(event){
            if (!(event.target.id == gldwTreeId.inputId || event.target.id == gldwTreeId.divId || $(event.target).parents("#"+gldwTreeId.divId).length>0)) {
                $("body").unbind('click',onBodyDown);
                $("#selectTree").hide();//隐藏
                result={};
            }
        };

        /**
         * 上传文件
         * */
        // window.ajaxFileUpload = function () {
        //     $.ajaxFileUpload(
        //         {
        //             url: '/NewCar/api/attachment/upload', //用于文件上传的服务器端请求地址
        //             secureuri: false, //是否需要安全协议，一般设置为false
        //             fileElementId: 'file', //文件上传域的ID
        //             dataType: 'json', //返回值类型 一般设置为json
        //             success: function (data, status)  //服务器成功响应处理函数
        //             {
        //                 alert("success");
        //             },
        //             error: function (data, status, e)//服务器响应失败处理函数
        //             {
        //                 alert(e);
        //             }
        //         }
        //     );
        //
        //     return false;
        // };
    })();

});
