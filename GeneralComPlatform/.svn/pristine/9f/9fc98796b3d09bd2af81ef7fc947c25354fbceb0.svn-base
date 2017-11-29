<!----------------------------------------------登录后跳转的框架---------------------------------------------------------->
<div class="container-fluid ">
<div class="mainBody" id="mainBody">
    <!--左侧内容-->
    <div class="left_content">
        <!--头部-->
        <div class="head_portrait">
            <div class="login-head">
                <div class="radius-head">
                    <img src="img/head.png">
                </div>
            </div>
            <div class="organizationName">
                <span ng-show='loginInfo.unitName!=null'>{{loginInfo.unitName}}</span>
                <span ng-show='loginInfo.unitName==null'>自行车租赁管理</span>
            </div>
        </div>

        <div class="divScroll">
            <div class="nav_left">
                <div class="nav_line" ng-repeat="nav in navList">
                    <div ui-sref="{{nav.url}}" class="link_style">
                        <img src="img/basicData.png" />
                        <span>{{nav.name}}</span>
                    </div>

                    <!--<div ng-if="nav.children.length!=0" id="{{nav.menu_id}}Nav" class="link_style" ng-click="showChildNode(nav.menu_id,nav.children.length)">
                        <img src="img/basicData.png" />
                        <span>{{nav.menu_name}}</span>
                    </div>
                    <ul ng-if="nav.children.length!=0" ng-if="nav.children.length!=0" style="display: none" id="{{nav.menu_id}}">
                        <li ng-repeat="childrenNav in nav.children">
                            <div class="second_style" ui-sref="{{childrenNav.path}}">{{childrenNav.menu_name}}</div>
                        </li>
                    </ul>-->
                </div>
            </div>
        </div>
        <!--
        	作者：tjc
        	时间：2017-07-02
        	描述：尾部图片和信息
        -->
        <div class="boottom_info">
        	<!--<img src="/img/navBackground.png">-->
        	<div class="clearfix"></div>
    		<div class="bottom-info">
       			 <!--<img src="img/navBackground.png"/>-->
        		<p>©校园自行车租赁管理系统</p>
    		</div>
        </div>
    </div>
    <!--右侧内容-->
    <div class="content_right" >
        <link rel="import" href="center.head.tpl?__inline">
        <!--导航-->
        <div id="mainContent" style="width: 100%;">
            <div class="crumb" style="border-radius: 0;">
                <div class="guide"></div>
                <div ncy-breadcrumb class="guide_name"></div>
            </div>

            <div id="mainCenter"
                 style="width: 100%;background: #ffffff;padding-top:20px;" ui-view>

            </div>
        </div>

    </div>

    <form name="selectUserForm" show-one>
        <!--用户选择-->
        <div id="openPwdUI" class="scM-AddOrEdit blockUI"
             style="width: 500px;height: 290px;">
            <div class="titleArea">
                <table width="500px">
                    <tr>
                        <td width="5%" style="vertical-align: middle;">
                            <img src="../../img/blue_dot.png">
                        </td>

                        <td width="87%" style="text-align: left; line-height: 29px;">
                            <span>修改密码</span>
                        </td>
                        <td width="8%" style="vertical-align: middle; cursor: pointer;">
                            <div onclick="closeBlockUI()"><img src="../../img/close1.png"></div>
                        </td>
                    </tr>
                </table>
            </div>
            <!--<div id="remind" style="line-height: 40px;margin-bottom: -40px;">
                <span style="margin-left: -190px;color: #5cbce1">温馨提醒：您的密码存在安全隐患，请及时修改密码！</span>
            </div>-->
            <table style="margin-top: 40px;width: 500px;">
                <tr class="basicMass-input">
                    <td style="text-align: right" width="25%">
                        <span class="required">初始密码</span>
                    </td>
                    <td>
                        <input type="password" class="password" name="oldPassword" ng-model="oldPassword" ng-minlength="6" required/>
                        <span ng-messages="selectUserForm.oldPassword.$error" class="error-messages">
                            <span ng-message="required">必须输入</span>
                            <span ng-message="minlength">最少输入6个字</span>
                        </span>
                    </td>
                </tr>
                <tr class="basicMass-input">
                    <td style="text-align: right" width="25%">
                        <span class="required">新密码</span>
                    </td>
                    <td>
                        <input type="password" class="password" name="password" ng-model="password" ng-minlength="6" required/>
                        <span ng-messages="selectUserForm.password.$error" class="error-messages">
                            <span ng-message="required">必须输入</span>
                            <span ng-message="minlength">最少输入6个字</span>
                        </span>
                    </td>
                </tr>
                <tr class="basicMass-input">
                    <td style="text-align: right" width="25%">
                        <span class="required">确认新密码</span>
                    </td>
                    <td>
                        <input type="password" class="password" pw-check="password" name="againPassword" ng-model="againPassword" ng-minlength="6" required/>
                        <span ng-messages="selectUserForm.againPassword.$error" class="error-messages">
                            <span ng-message="required">必须输入</span>
                            <span ng-message="pwmatch">预设密码和确认密码不一致</span>
                        </span>
                    </td>
                </tr>
            </table>

            <div style="text-align: center;margin-top: 20px;">
                <button type="submit" style="margin-left: 20px;" class='green btn' ng-disabled="selectUserForm.$invalid" ng-click="updateUserPasswordCreatedByTY()">修改</button>
                <a class="button white" ng-show="showCancel" name="" ng-click="hidePasswordBounced()">取消</a>
            </div>
        </div>
    </form>

    <!--修改基本信息弹框-->
    <form name="updateUserBaseInfo" show-one>
        <div id="openSingleUI" class="scM-AddOrEdit blockUI" style="width:500px;height: 410px">
            <div class="titleArea">
                <table width="500px">
                    <tr>
                        <td width="5%" style="vertical-align: middle;">
                            <img src="../../img/blue_dot.png">
                        </td>

                        <td width="87%" style="text-align: left; line-height: 29px;">
                            <span>修改基本信息</span>
                        </td>
                        <td width="8%" style="vertical-align: middle; cursor: pointer;">
                            <div onclick="closeBlockUI()"><img src="../../img/close1.png"></div>
                        </td>
                    </tr>
                </table>
            </div>

            <table style="margin-top: 30px;width: 500px;">
                <tr class="basicMass-input">
                    <td style="text-align: right" width="25%">
                        <span class="required">用户名</span>
                    </td>
                    <td>
                        <input type="text"  style="width: 300px;height: 30px;" name="userName" ng-model="loginInfo.name" required/>
                        <span ng-messages="updateUserBaseInfo.userName.$error" class="error-messages">
                            <span ng-message="required">必须输入</span>
                        </span>
                    </td>
                </tr>
                <tr class="basicMass-input">
                    <td style="text-align: right" width="25%">
                        <span class="required">账号</span>
                    </td>
                    <td>
                        <input type="text"  style="width: 300px;height: 30px;margin-top: 8px;" name="code" ng-model="loginInfo.code" required/>
                            <span ng-messages="updateUserBaseInfo.code.$error" class="error-messages">
                            <span ng-message="required">必须输入</span>
                        </span>
                    </td>
                </tr>
                <tr class="basicMass-input">
                    <td style="text-align: right" width="25%">
                        <span class="required">联系电话</span>
                    </td>
                    <td>
                        <input type="text" name="phone" style="width: 300px;height: 30px;" ng-model="loginInfo.phone"  ng-pattern="/^[1][3,4,5,8,7][0-9]{9}$/"  required/>
                        <span ng-messages="updateUserBaseInfo.phone.$error" class="error-messages">
                            <span ng-message="pattern">请输入正确的手机号码</span>
                            <span ng-message="required">必须输入</span>
                        </span>
                    </td>
                </tr>

                <tr class="basicMass-input">
                    <td style="text-align: right">
                        <span>备注</span>
                    </td>
                    <td>
                        <textarea name="remark" ng-model="loginInfo.remark" style="width: 300px;height: 125px;margin-top: 5px;"/>
                    </td>
                </tr>
            </table>

            <!--按钮区域-->
            <div style="text-align: center;margin-top: 20px;">
                <button type="submit" style="margin-left: 20px;" class='green btn' ng-disabled="updateUserBaseInfo.$invalid" ng-click="updateBaseInfo()">修改</button>
                <a class="button white" ng-click="hideBaseInfoBounced()">取消</a>
            </div>
        </div>
    </form>
</div>
</div>
