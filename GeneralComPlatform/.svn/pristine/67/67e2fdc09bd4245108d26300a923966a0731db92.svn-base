<!--新增码表-->
<form name="addCodeTable" show-one>
    <!--填写基本信息的区域-->
    <table class="basicMass">
        <tr class="basicMass-input">
            <td class="key">
                <span class="required">代码类型</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="code_type" ng-model="codeTableObject.codeType" ng-maxlength="250"
                       remote-Validation data="/NewCar/api/codeTable/validationDate" required/>
                <span ng-messages="addCodeTable.code_type.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="maxlength">最多输入250个字</span>
                        <span ng-message="record-loading">正在校验代码类型.....</span>
                        <span ng-message="remote">代码类型已存在</span>
                </span>
            </td>

            <td class="key noFirst">
                <span class="required">参数名称</span>
            </td>
            <td class="basicMass-input-td">
                <input type="text" name="param_name" ng-model="codeTableObject.paramName" ng-maxlength="250" required/>
                <span ng-messages="addCodeTable.param_name.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                    <span ng-message="maxlength">最多输入250个字</span>
                </span>
            </td>
        </tr>

        <tr class="basicMass-input">
            <td class="key">
                <span class="required">参数内容</span>
            </td>
            <td colspan="3" class="basicMass-input-td">
                <textarea name="param_text" ng-model="codeTableObject.paramText" ng-maxlength="500" required/></textarea>
                <span ng-messages="addCodeTable.param_text.$error" class="error-messages">
                    <span ng-message="required">必须输入</span>
                    <span ng-message="maxlength">最多输入500个字</span>
                </span>
            </td>
        </tr>

    </table>

    <!--按钮区域-->
    <div class="page-operator">
        <button type="submit" class='green btn' ng-disabled="addCodeTable.$invalid" ng-click="addCodeTableObject()">保存
        </button>
        <a class="button white" ui-sref="center.codeTable">返回</a>
    </div>
</form>
