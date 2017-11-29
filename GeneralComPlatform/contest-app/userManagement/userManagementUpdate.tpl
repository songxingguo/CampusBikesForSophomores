<form name="updateUser" show-one>
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
    <table class="basicMass">
        <tr class="basicMass-input">
            <td class="key user_key">
                <span class="required">用户名</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="username" ng-model="userObject.userName" value="{{userName}}"
                       remote-Validation data="/ContestPlatform/api/user/userNameDC" ng-maxlength="20" required/>
                    <span ng-messages="updateUser.username.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="maxlength">最多输入20个字</span>
                        <span ng-message="record-loading">正在校验用户名.....</span>
                        <span ng-message="remote">{{userName}}该用户名已存在</span>
                    </span>
            </td>

            <td class="key noFirst user_key">
                <span class="required">账号</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="account" ng-model="userObject.userNo" value="{{userCode}}"
                       remote-Validation data="/ContestPlatform/api/user/userCodeDC" ng-maxlength="20" required/>
                    <span ng-messages="updateUser.account.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="maxlength">最多输入20个字</span>
                        <span ng-message="record-loading">正在校验账号.....</span>
                        <span ng-message="remote">{{userNo}}该账号已存在</span>
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
                <input type="text" name="connectPhone" ng-model="userObject.userPhone" ng-pattern="/^[1][3,4,5,8,7][0-9]{9}$/"  required/>
                <span ng-messages="updateUser.connectPhone.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                    <span ng-message="pattern">请输入正确的手机号码</span>
                </span>
            </td>

            <td class="key noFirst user_key">
                <span class="required">学院名称</span>
            </td>
            <!--<td class="basicMass-input-td">
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
                            </div>
                        </li>
                    </ul>
                </div>
            </td>-->
            <td class="basicMass-input-td">
                <input type="text" name="collegeName" ng-model="userObject.userCollege" required/>
                <span ng-messages="updateUser.collegeName.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                </span>
            </td>
        </tr>
        <tr class="basicMass-input">

            <td class="key">
                <span class="required">邮箱</span>
            </td>
            <!--<td class="basicMass-input-td">
                <select class="user_select" name="state" ng-model="userObject.state" required>
                    <option value="">--请选择--</option>
                    <option value="1">启用</option>
                    <option value="0">禁用</option>
                    <span ng-messages="updateUser.state.$error" class="error-messages">
                        <span ng-message="required">必须选择</span>
                    </span>
                </select>
            </td>-->
            <td class="basicMass-input-td">
                <input type="text" name="mailBox" ng-model="userObject.userMailbox" ng-pattern="/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/" required/>
                <span ng-messages="updateUser.mailBox.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                    <span ng-message="pattern">请输入正确的邮箱</span>
                </span>
            </td>
        </tr>
        <!--<tr class="basicMass-input">
            <td class="key">
                <span>备注</span>
            </td>
            <td class="basicMass-input-td" colspan="3">
                <textarea name="remark" style="width: 92.5%;padding-left: 10px;" ng-model="userObject.remark" ng-maxlength="255"></textarea>
                <span ng-messages="updateUser.remark.$error" class="error-messages">
                    <span ng-message="maxlength">最多输入255个字</span>
                </span>
            </td>
        </tr>-->
    </table>

    <!--按钮区域-->
    <div class="page-operator">
        <button type="submit" class='green btn' ng-disabled="updateUser.$invalid" ng-click="updateUserObject()">修改</button>
        <a class="button white" ui-sref="center.userManagement">返回</a>
    </div>
</form>
