<!--登录-->
<div class="login-body">
    <div class="login-main">

        <div class="login-input" >
        	<img src="img/loginFrame.png" >
        	<div style="position: absolute;left:35%;top:40%;"> <!--left:640px;top:165px;left:600px;top:200px;-->
        		<!--<img src="img/logo1.png">-->
				<h2>校园自行车租赁平台</h2>
        	</div>
        	<div class="login-for-controller" style="position: absolute;left:35%;top:40%;background-color: ;width:500px;height:140px;">
        		<div class="login-input-must1" >
                    <img src="img/userIcon.png">
                    <img src="img/passwordIcon.png" style="margin-top: 70px;">
                    <input type="text" placeholder="请输入用户名" id="user">
                    <input type="password" placeholder="请输入密码" id="password" style="margin-top: 30px;">	
	            </div>
	            
	            <!--登录信息显示区域-->
                <div class="login_return">
                	
                </div>

                <div class="login-button"  ng-click="loginJudge()">
                    <img src="img/loginButton.png">
                    <div id="loginName">登 录</div>
                </div>
                
                <div class="forget-password" ng-click="forgetPassword()">
                    <a>忘记密码？</a>
                </div>
        	</div>
        		<!--<div class="login-main-input" style="z-index: 2;">
	                <div class="left-input"  >
	
	                    <div class="login-input-must">
	                        <img src="img/user.png">
	                        <img src="img/password.png" style="margin-top: 76px;">
	                        <input type="text" placeholder="请输入用户名" id="user">
	                        <input type="password" placeholder="请输入密码" id="password" style="margin-top: 30px;">
	
	                    </div>
	                    
	                    <!--登录信息显示区域-->
	                    <!--<div class="login_return">
	                    	
	                    </div>
	
	                    <div class="login-button"  ng-click="loginJudge()">
	                        <img src="img/loginButton.png">
	                        <div id="loginName">登 录</div>
	                    </div>
	
	                    <div class="forget-password" ng-click="forgetPassword()">
	                        <span>忘记密码？</span>
	                    </div>
	                </div>
	            </div>-->-->
            
        </div>
    </div>

    <div class="login-backgroundImg">
        <img src="img/background.png" style="width: 100%;height: auto;">
    </div>
</div>