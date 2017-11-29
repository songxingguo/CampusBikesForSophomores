<!--新增角色权限-->
<form name="addRolePermission" show-on >
    <!--填写基本信息的区域-->
    <table  class="basicMass">
        <tr class="basicMass-input">
            <td class="key">
                <span class="required">角色名称</span>
            </td>
            <td class="basicMass-input-td" style="width: 650px;">
                <input type="text" name="na" ng-model="rolePermissionObject.name" ng-maxlength="20" style="width: 75%;" required/>
                <span ng-messages="addRolePermission.na.$error" class="error-messages">
                        <span ng-message="required">必须输入</span>
                        <span ng-message="maxlength">最多输入20个字</span>
                </span>
            </td>

            <!--&lt;!&ndash;<td class="key noFirst">&ndash;&gt;-->
                <!--&lt;!&ndash;<span>角色类型</span>&ndash;&gt;-->
            <!--&lt;!&ndash;</td>&ndash;&gt;-->
            <!--&lt;!&ndash;<td class="basicMass-input-td">&ndash;&gt;-->
                <!--&lt;!&ndash;<select name="type" ng-model="rolePermissionObject.type"&ndash;&gt;-->
                        <!--&lt;!&ndash;ng-options="type.param_code as type.param_text for type in typeList" required>&ndash;&gt;-->
                    <!--&lt;!&ndash;<option value="">&#45;&#45;请选择&#45;&#45;</option>&ndash;&gt;-->
                <!--&lt;!&ndash;</select>&ndash;&gt;-->
                <!--&lt;!&ndash;<span ng-messages="addRolePermission.type.$error" class="error-messages">&ndash;&gt;-->
                    <!--&lt;!&ndash;<span ng-message="required">必须选择</span>&ndash;&gt;-->
                <!--&lt;!&ndash;</span>&ndash;&gt;-->
            <!--&lt;!&ndash;</td>&ndash;&gt;-->
        </tr>

        <tr class="basicMass-input">
            <td class="key" width="20%">
                <span>备注</span>
            </td>

            <td class="basicMass-input-td" width="80%">
                <textarea name="remark" ng-model="rolePermissionObject.remark" ng-maxlength="1000" style="width: 75%;"></textarea>
                    <span ng-messages="addRolePermission.remark.$error" class="error-messages">
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
        <tr ng-repeat="module in moduleList" id="mainPro" class="text_left select_module" ng-class="{'selected':$index%2==1}">
            <td style="width:20%; padding-top: 15px;">
                <ul>
                    <li>
                        <label class="myStyleCheckBox" style="width: auto;">
                            <input name="isCheck" type="checkbox" value="{{module}}"  id="{{module.id}}Parent" ng-click="isSelected(module.id,1)"/>
                            <label for="{{module.id}}Parent"></label>
                           <!-- <span class="first_module">{{module.module_name}}</span>-->
                        </label>
                    </li>
                </ul>
            </td>
            <td style="width:80%;" id="{{module.id}}Children">
                <ul class="childrenUl" style="text-align: left;">
                    <li>
                        <label class="myStyleCheckBox" style="width: auto">
                            <input name="isCheck" type="checkbox" value="{{module}}" id="{{module.code}}" ng-click="isSelected(module.id)" />
                            <label for="{{module.code}}"></label>
                            <span class="first_module" >{{module.name}}</span>
                        </label>
                    </li>
                </ul>

                <ul class="childrenUl" ng-if="module.children!=0" style="text-align: left;">
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
        <button type="submit" class='green btn' ng-disabled="addRolePermission.$invalid || moduleCodes.length==0" ng-click="addRolePermissionObject()">保存</button>
        <a class="button white" ui-sref="center.rolePermission">返回</a>
    </div>
</form>
