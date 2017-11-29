<div class="login-form" ng-controller="loginCtrl" ng-cloak>
	<a class="logo" href="${domain}"></a>
	<h4 class="title">副标题</h4>
	<div ng-if="error.msg" class="alert fade in"
		 ng-class="{'alert-warning':error.type=='warning', 'alert-danger':error.type=='error'}"
		 role="alert">
		<span ng-bind="error.msg"></span>
	</div>
	<div class="group-inputs">
		<div class="input-wrapper">
			<input type="text" ng-model="account" name="account" placeholder="账号">
		</div>
		<div class="input-wrapper">
			<input type="password" ng-model="password" name="password" placeholder="密码">
		</div>
	</div>
	<div id="login-btn" class="btn btn-lg btn-block btn-primary" ng-click="loginSubmit()">登录</div>
	<div class="clearfix">
		<label class="checkbox-inline pull-left">
			<input type="checkbox" ng-model="rememberMe"> 记住我 [7天内免登录]
		</label>
		<a class="forget pull-right btn btn-link" href="/org/appeal.action" target="_blank">忘记密码?</a>
	</div>
	<div id="cert-login-btn" class="btn btn-lg btn-block btn-success" ng-click="certLoginSubmit()">证书登录</div>
	<a id="register-btn" class="btn btn-lg btn-block btn-default" href="/org/user!userRegist" target="_blank">免费注册</a>
</div>
<div id="footer" class="hidden-print">
    <h5>copyright© gmsoft 2016</h5>
</div>