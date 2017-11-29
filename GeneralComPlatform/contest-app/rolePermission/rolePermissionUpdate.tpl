<!--更新角色权限-->
<form name="updateRolePermission" show-one>
    <!--填写基本信息的区域-->
    <table  class="basicMass">
        <tr class="basicMass-input">
            <td class="key">
                <span class="required">角色名称</span>
            </td>
            <td class="basicMass-input-td" style="width: 650px;">
                <input type="text" name="na" ng-model="rolePermissionObject.roleName" ng-maxlength="20"  style="width: 75%;" required/>
                    <span ng-messages="updateRolePermission.na.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="maxlength">最多输入20个字</span>
                    </span>
            </td>

            <!--<td class="key noFirst">
                <span class="required">角色类型</span>
            </td>
            <td class="basicMass-input-td">
                <select name="type" ng-model="rolePermissionObject.type"
                        ng-options="type.param_code as type.param_text for type in typeList" required>
                    <option value="">&#45;&#45;请选择&#45;&#45;</option>
                </select>
                <span ng-messages="addRolePermission.type.$error" class="error-messages">
                    <span ng-message="required">必须选择</span>
                </span>
            </td>-->
        </tr>

        <tr class="basicMass-input">
            <td class="key" width="20%">
                <span>备注</span>
            </td>

            <td class="basicMass-input-td" width="80%">
                <textarea name="remark" ng-model="rolePermissionObject.roleRemark" ng-maxlength="1000" style="width: 75%;"></textarea>
                    <span ng-messages="updateRolePermission.remark.$error" class="error-messages">
                        <span ng-message="maxlength">最多输入1000个字</span>
                    </span>
            </td>
        </tr>
    </table>
    <!--选择权限的区域-->
    <table class="table" id="rolePermission" style="margin-top: 30px;">
        <thead>
        <tr>
            <th>权限分类</th>
            <th>权限明细</th>
        </tr>
        </thead>

        <tbody>
        <tr ng-repeat="module in moduleList" on-finish-render class="text_left select_module" ng-class="{'selected':$index%2==1}">
            <td style="width:20%; padding-top: 15px;" >
                <ul>
                    <li>
                        <label class="myStyleCheckBox" style="width: auto;">
                            <input name="isCheck" type="checkbox" id="{{module.id}}Parent" class="{{module.module_code}}Parent" value="{{module}}" ng-click="isSelected(module.id,1)"/>
                            <label for="{{module.id}}Parent"></label>
                            <span class="first_module" >{{module.module_name}}</span>
                        </label>
                    </li>
                </ul>
            </td>
            <td style="width:80%;"  id="{{module.id}}Children" class="">
                <ul class="childrenUl" ng-if="module.children==0">
                    <li>
                        <label class="myStyleCheckBox" style="width: auto">
                            <input name="isCheck" type="checkbox" value="{{module}}" id="{{module.module_code}}" ng-click="isSelected(module.id)" />
                            <label for="{{module.module_code}}"></label>
                            <span class="first_module" >{{module.module_name}}</span>
                        </label>
                    </li>
                </ul>

                <ul class="childrenUl" ng-if="module.children!=0">
                    <li ng-repeat="second in module.children">
                        <label class="myStyleCheckBox" style="width: auto">
                            <input name="isCheck" type="checkbox" id="{{second.module_code}}" value="{{second}}" ng-click="isSelected(module.id)" />
                            <label for="{{second.module_code}}"></label>
                            <span class="first_module" >{{second.module_name}}</span>
                        </label>
                    </li>
                </ul>
            </td>
        </tr>
        </tbody>
    </table>
    <!--按钮区域-->
    <div class="page-operator">
        <button type="submit" class='green btn' ng-disabled="updateRolePermission.$invalid || moduleCodes.length==0" ng-click="updateRolePermissionObject()">修改</button>
        <a class="button white" ui-sref="center.rolePermission">返回</a>
    </div>
</form>
