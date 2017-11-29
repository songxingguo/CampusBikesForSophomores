<!--查看角色权限明细-->
<!--填写基本信息的区域-->
<form id="detail_style">
<table class="basicMass readDetail">
    <tr class="basicMass-input">
        <td class="key">
            <span>角色名称</span>:
        </td>
        <td class="basicMass-input-td" style="width: 650px;">
            <p class="show-content"  style="width: 75%;">{{rolePermissionObject.roleName}}</p>
        </td>

        <!--<td class="key noFirst">
            <span>角色类型</span>
        </td>
        <td class="basicMass-input-td">
            <p class="show-content">{{rolePermissionObject.type}}</p>
        </td>-->
    </tr>

    <tr class="basicMass-input">
        <td class="key" width="20%">
            <span>备注</span>:
        </td>

        <td class="basicMass-input-td" width="80%">
            <p style="width: 75%;height: auto;" class="show-content">{{rolePermissionObject.roleRemark}}</p>
        </td>
    </tr>
</table>
<!--选择权限的区域-->
<table class="table" id="rolePermission">
    <thead>
    <tr>
        <th>权限分类</th>
        <th>权限明细</th>
    </tr>
    </thead>

    <tbody>
    <tr ng-repeat="module in moduleList" class="{{module.module_code}} select_module"  ng-class="{'selected':colorChange(module.module_code)}" ng-if="isSelected(module.module_code)">
        <td style="width:20%; padding-top: 15px;">
            <label>
                <span class="first_module" style="text-align: center; margin: 0">{{module.module_name}}</span>
            </label>
        </td>
        <td style="width:80%; color:#466785;" id="{{module.id}}">
            <ul class="childrenUl" ng-if="module.children==0 && isSelected(module.module_code)">
                <li>
                    <label>
                        <span class="first_module" >{{module.module_name}}</span>
                    </label>
                </li>
            </ul>

            <ul class="childrenUl" ng-if="module.children!=0">
                <li ng-repeat="second in module.children" ng-if="isSelected(second.module_code)">
                    <label>
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
    <a class="button white" ui-sref="center.rolePermission">返回</a>
</div>
</form>