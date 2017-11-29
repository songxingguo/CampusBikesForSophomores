<!--新增用户-->
<form name="addUsers" show-one >
    <div class="input-title">
        <div>
            <img src="img/inputImg.png"/>
        </div>
        <div style="width: 10%;text-align: center;">
            <span>用户登录信息</span>
        </div>
        <div style="width: 88%;" class="line-full">

        </div>
    </div>
    <!--填写基本信息的区域-->
    <table  class="basicMass">
        <tr class="basicMass-input">
            <td class="key user_key">
                <span class="required">用户名</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="username" ng-model="userObject.name"
                       remote-Validation data="/NewCar/api/userManagement/userNameDC" ng-maxlength="20" required/>
                    <span ng-messages="addUsers.username.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="maxlength">最多输入20个字</span>
                        <span ng-message="record-loading">正在校验用户名.....</span>
                        <span ng-message="remote">该用户名已存在</span>
                    </span>
            </td>

            <td class="key noFirst user_key">
                <span class="required">账号</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="account" ng-model="userObject.code"
                       remote-Validation data="/NewCar/api/userManagement/userCodeDC" ng-maxlength="20" required/>
                    <span ng-messages="addUsers.account.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="maxlength">最多输入20个字</span>
                        <span ng-message="record-loading">正在校验账号.....</span>
                        <span ng-message="remote">该账号已存在</span>
                    </span>
            </td>
        </tr>

        <tr class="basicMass-input">
            <td class="key">
                <span class="required">密码</span>
            </td>
            <td class="basicMass-input-td">
                <input class="user_password" type="password" name="password" ng-model="userObject.password" maxlength="16" ng-minlength="6" required/>
                    <span ng-messages="addUsers.password.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="minlength">最少输入6个字</span>
                    </span>
            </td>

            <td class="key noFirst">
                <span class="required">重复密码</span>
            </td>
            <td class="basicMass-input-td">
                <input class="user_password" type="password" pw-check="password" name="againPassword" ng-model="againPassword" maxlength="16" ng-minlength="6" required/>
                    <span ng-messages="addUsers.againPassword.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="pwmatch">预设密码和确认密码不一致</span>
                    </span>
            </td>
        </tr>
    </table>

    <div class="input-title">
        <div>
            <img src="img/inputImg.png"/>
        </div>
        <div style="width: 10%;text-align: center;">
            <span>用户基本信息</span>
        </div>
        <div style="width: 88%;" class="line-full">

        </div>
    </div>

    <table  class="basicMass">
        <tr class="basicMass-input">
            <td class="key user_key">
                <span class="required">联系电话</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="connectPhone" ng-model="userObject.phone" ng-pattern="/^[1][3,4,5,8,7][0-9]{9}$/"  required/>
                <span ng-messages="addUsers.connectPhone.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                    <span ng-message="pattern">请输入正确的手机号码</span>
                </span>
            </td>

            <td class="key noFirst user_key">
                <span class="required">所属角色</span>
            </td>
            <td class="basicMass-input-td">
                <!--<select class="user_select" type="text" name="belongRole" ng-model="usersObject.roleId"-->
                    <!--ng-options="role.id as role.name for role in roleList" required>-->
                <!--<option value="">&#45;&#45;请选择&#45;&#45;</option>-->
                <!--</select>-->
                <!--<span ng-messages="addUsers.belongRole.$error" class="error-messages">-->
                    <!--<span ng-message="required">必须选择</span>-->
                <!--</span>-->
                <div style="position: relative;width:315px">
                    <a class="button white dropdown" style="width:100%">
                        <span ng-show="userObject.roleName == null">请选择所属角色</span>
                        <span>{{userObject.roleName}}</span>
                        <b class="caret_top" id="caret"></b>
                    </a>
                    <ul class="multiselect-container dropdown-menu">
                        <li ng-repeat="role in roleList">
                            <div class="myStyleCheckBox" style="margin:auto;width:100%">
                                <input type="checkbox" id="{{role.id}}" value="{{role}}" name="isCheck" ng-click="select()"/>
                                <label for="{{role.id}}"></label>
                                <span style="margin-left:5px;">{{role.name}}</span>
                                <!--文字放在label标签里可以起到点击label触发点击多选框事件-->
                            </div>
                        </li>
                    </ul>
                </div>
            </td>
        </tr>

        <tr class="basicMass-input">
            <!--<td class="key" ng-show="curRoleType == 'PM'">-->
                 <!--<span>单位名称</span>-->
            <!--</td>-->
            <!--<td class="basicMass-input-td" ng-show="curRoleType == 'PM'">-->
                <!--<select name="unitName" ng-model="usersObject.organization"-->
                    <!--ng-options="org.orgCode as org.organizationName for org in orgList">-->
                    <!--<option value="">&#45;&#45;请选择&#45;&#45;</option>-->
                <!--</select>-->
            <!--</td>-->

            <td class="key noFirst">
                <span class="required">状态</span>
            </td>
            <td class="basicMass-input-td">
                <select class="user_select" name="type" ng-model="userObject.state"
                    ng-options="state.state as state.name for state in stateType" required>
                    <option value="">--请选择--</option>
                </select>
                <span ng-messages="addUsers.type.$error" class="error-messages">
                    <span ng-message="required">必须选择</span>
                </span>
            </td>
        </tr>

        <tr class="basicMass-input">
            <td class="key">
                <span>备注</span>
            </td>
            <td class="basicMass-input-td" colspan="3">
                <textarea name="remark" style="width: 92.5%;padding-left: 10px;" ng-model="userObject.remark" ng-maxlength="255"></textarea>
                <span ng-messages="addUsers.remark.$error" class="error-messages">
                    <span ng-message="maxlength">最多输入255个字</span>
                </span>
            </td>
        </tr>
    </table>

    <div class="page-operator">
        <button type="submit" class='green btn' ng-disabled="addUsers.$invalid || userObject.roleId == null" ng-click="addUserObject()">保存</button>
        <a class="button white" ui-sref="center.userManagement">返回</a>
    </div>
</form>

    <!--用户选择-->
<div id="openBlockUI" class="scM-AddOrEdit blockUI"
         style="width:650px;height:540px;">
    <form name="selectUserForm">
    <div class="content">
        <table class="table">
            <thead>
            <tr>
                <th style="text-align: center;">选择</th>
                <th>用户名</th>
                <th>单位名称</th>
                <th>备注</th>
            </tr>
            </thead>

            <tbody>
            <tr ng-repeat="userManagement in userList" ng-class="{'selected':$index%2==1}">
                <td style="width:5%;text-align: center;" >
                    <input name="isCheck" type="checkbox" value="{{userManagement.id}}" id="{{userManagement.id}}"
                           ng-click="addSelectUserID(userManagement.id,userManagement.username)">
                </td>

                <td style="width:10%;" title="{{userManagement.username}}">{{userManagement.username}}
                </td>

                <td style="width:15%;" class="englishOrChinese" title="{{userManagement.companyName}}">{{userManagement.companyName}}</td>

                <td style="width:20%;" class="englishOrChinese" title="{{userManagement.remark}}">
                    {{userManagement.remark.substring(0,10)}}
                    <a class="clickmore icon-double-angle-down" onclick="clickMore(this,10);"
                       data-ng-if="userManagement.remark.length>10">更多</a>
                </td>
            </tr>
            </tbody>
        </table>
        <!--分页-->
        <div style="background: #FFF;" ui-pagination items-per-page="itemsPerPage" total-items="totalItems" current-page="currentPage"></div>

            <!--按钮区域-->
            <div class="page-operator">
                <button type="submit" class='green btn' ng-disabled="selectUser.length==0" ng-click="showSelectInInput()">确定</button>
                <a class="button white" onclick="closeBlockUI()">返回</a>
            </div>
        </div>
   </form>
</div>