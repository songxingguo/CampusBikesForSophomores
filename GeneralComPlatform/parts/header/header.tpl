<!--
    @require header.less
    @require header.js
	-->
<div id="header" class="clearfix" ng-cloak>
	<div class="container-fluid">
		<a class="logo pull-left" ui-sref="index" title="返回首页"></a>
		<div class="button-wrap">
            <a id="back-home" class="btn btn-link" ui-sref="index" ng-if="!$state.is('index')">返回首页</a>
			<a login>登录 · 注册</a>
		</div>
	</div>
</div>

	
