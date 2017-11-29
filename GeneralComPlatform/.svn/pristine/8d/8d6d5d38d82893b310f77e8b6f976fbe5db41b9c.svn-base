<!--新增模块-->
<form name="moduleManagementAdd" show-one>
    <!--填写基本信息的区域-->
    <table class="basicMass">
        <tr class="basicMass-input">
            <td class="key" style="width: 30%;">
                <span class="required">模块名称</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="name" ng-model="moduleObject.name"
                        ng-maxlength="20" required/>
                <span ng-messages="moduleManagementAdd.name.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                    <span ng-message="maxlength">最多输入20个字</span>
                    <span ng-message="record-loading">正在校验模块名.....</span>
                    <!--<span ng-message="remote">该模块名已存在</span>-->
                   <!-- remote-Validation data="/NewCar/api/module/validationDate"-->
                </span>
            </td>
        </tr>

        <tr class="basicMass-input">
            <td class="key">
                <span class="required">url</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="url" ng-model="moduleObject.url" ng-maxlength="50" required/>
                <span ng-messages="moduleManagementAdd.url.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                    <span ng-message="maxlength">最多输入50个字</span>
                </span>
            </td>
        </tr>

        <tr class="basicMass-input">
            <td class="key">
                <span>图标</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="updateUrl" ng-maxlength="50" ng-model="moduleObject.iconUrl"/>
                <span ng-messages="moduleManagementAdd.updateUrl.$error" class="error-messages">
                    <span ng-message="maxlength">最多输入50个字</span>
                </span>
            </td>
        </tr>

       <!-- <tr class="basicMass-input">
            <td class="key">
                <span class="required">模块类型</span>
            </td>
            <td class="basicMass-input-td">
                <label class="myStyleCheckBox" style="width: auto" ng-repeat="moduleChecked in moduleTypeList">
                    <input style="border:none;" name="ModuleCheck" type="checkbox" id="{{moduleChecked}}" value="{{moduleChecked}}" ng-click="addModuleType(moduleChecked)">
                    <label for="{{moduleChecked}}"></label>
                    <span style="margin-top:-1px;" class="moduleChecked" >{{moduleChecked}}</span>
                </label>
            </td>
        </tr>-->
    </table>
    <!--按钮区域-->
    <div class="page-operator">
        <button type="submit" class='green btn' ng-disabled="moduleManagementAdd.$invalid" ng-click="addModuleObject()">保存</button>
        <a class="button white" ui-sref="center.moduleManagement">返回</a>
    </div>
</form>
