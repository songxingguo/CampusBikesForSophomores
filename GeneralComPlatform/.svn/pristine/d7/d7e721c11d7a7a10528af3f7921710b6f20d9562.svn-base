/**
 * Created by tjc on 2017/07/02.
 */

define(['angularAMD', 'ui-bootstrap', 'ui-countdown','contest-app/login/login.service',
'popup-message','angular-messages','jquery.nicescroll'], function (angularAMD) {

    //延迟加载的module需要调用
    angularAMD.processQueue();

    //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
    return ['$scope','$state','login', function(s,$state,server){

        //设置高度
        if($(window).height()>=768){
            $('.login-backgroundImg').css('height',$(window).height()+'px');
        }else {
			$('.login-backgroundImg').css('height', 768 + 'px');
		}

        //存储输入信息
        var login={};

        /*验证浏览器版本*/
		(s.JudgeExplorer=function(){
			//alert(1);
			var explorer = window.navigator.userAgent.toLowerCase() ;
 			//ie 
 			if (explorer.indexOf("msie") >= 0) {
    			var ver=explorer.match(/msie ([\d.]+)/)[1];
    			if(ver<=8.0){
    				window.location.href="parts/ie-lower/ie-lower.html";
    			}
 			}
		})();



		/**
         * 登录验证
         */
        s.loginJudge=function(){
        	var errorTitle='用户名或密码错误！';
			//alert("1");
        	var userid=$("#user").val();
        	var passwordVal=$("#password").val();
        	
        	var flag=false;
        	if(userid==''||userid==null){
        		$('.login_return').text('用户名不能为空，请输入用户名！');
        	}else if(passwordVal==''||passwordVal==null){
        		$('.login_return').text('密码不能为空，请输入密码！');
        	}else{
                $("#loginName").html('登录中...');
				$state.go("center.moduleManagement");
        		server.loginJudge(userid,passwordVal).then(function(data){
        			//alert(data);
        			if(data.status==true){
        				//var roleName=window.localStorage["roleType"];/*curRoleType*/
        				var roleName=data.roleType;
                    	if(roleName=='OP'){
                    		$state.go("center.moduleManagement");//myCenter
                    	}else{
                    		$state.go("center.moduleManagement");
                    	}
        				return;
        			}else{
                        server.loginJudgeOP(userid,passwordVal).then(function(data){
                        	//alert(data.status);
                            if(data.status==true){
                            	//var roleName1=window.localStorage["roleType"];
                            	var roleName1=data.roleType;
                            	//alert(roleName1);
                            	if(roleName1=='OP'){
                            		//alert(1);
                            		$state.go("center.moduleManagement");
                            	}else{
                            		$state.go("center.moduleManagement");
                            	}
                                return;
                            }else{
                                server.loginJudgeJD(userid,passwordVal).then(function(data){
                                	//alert(data);
                                    if(data.status==true){
                                    	//var roleName2=window.localStorage["roleType"];
                                    	var roleName2=data.roleType;
                                    	if(roleName2=='OP'){
                                    		$state.go("center.moduleManagement");
                                    	}else{
                                    		$state.go("center.moduleManagement");
                                    	}
                                        
                                        return;
                                    }else{
                                        $("#loginName").html('登 录');
                                        $('.login_return').text(errorTitle);
                                    }
                                });
							}
                        });
					}
            	});
        	} 
        };

        /**
		 * 按键时间
         */
        $(document).keydown(function(event){
            if(event.keyCode == 13){
                s.loginJudge();
            }
        });

        /**
         * 忘记密码
         */
        s.forgetPassword=function(){
			showMsg("warning",'此功能暂未开放，请联系系统管理员！');
        }
    }];

});