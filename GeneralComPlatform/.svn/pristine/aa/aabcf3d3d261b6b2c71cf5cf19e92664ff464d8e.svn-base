<!--修改模块-->
<form name="moduleManagementUpdate" show-one>
    <!--填写基本信息的区域-->
    <table class="basicMass">
        <tr class="basicMass-input">
            <td class="key" style="width: 30%;">
                <span class="required">模块名称</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="updateName" ng-model="moduleObject.name"
                        value="{{moduleName}}" ng-maxlength="20" required/>
                    <span ng-messages="moduleManagementUpdate.updateName.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="maxlength">最多输入20个字</span>
                        <span ng-message="record-loading">正在校验模块名.....</span>
                    </span>
            </td>
        </tr>

        <tr class="basicMass-input">
            <td class="key">
                <span class="required">url</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="updateUrl" ng-model="moduleObject.url" required/>
                <span ng-messages="moduleManagementUpdate.updateUrl.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                </span>
            </td>
        </tr>

        <tr class="basicMass-input">
            <td class="key">
                <span>图标</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="updateUrl" ng-maxlength="50" ng-model="moduleObject.iconUrl">
                <span ng-messages="moduleManagementAdd.updateUrl.$error" class="error-messages">
                    <span ng-message="maxlength">最多输入50个字</span>
                </span>
            </td>
        </tr>
    </table>
    <!--按钮区域-->
    <div class="page-operator">
        <button type="submit" class='green btn' ng-disabled="moduleManagementUpdate.$invalid" ng-click="updateModuleObject()">修改</button>
        <a class="button white" ui-sref="center.moduleManagement">返回</a>
    </div>
</form>
