<!--搜索区域-->
<div class="search_area">
    <span class="search_name">角色名称</span>
    <input type="text" ng-model="condition.roleName">

    <a class="button blue" ng-click='searchRole()'>搜索</a>
</div>

<!--操作区域-->
<div class="operate_area">
    <a class="button blue" ui-sref="center.rolePermissionAdd">新增</a>
    <a class="button red" ng-click="deleteRolePermissions()">删除</a>

    <a class="basisSet" ng-if="curRoleType=='PM'" ng-click="setBasisRole()" style="margin-right: 8px;">基础角色权限设置</a>
</div>

<div class="content">
    <table class="table">
        <thead>
            <tr>
                <th>选择</th>
                <th>角色名称</th>
                <th>创建人</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
        </thead>

        <tbody>
            <tr ng-repeat="rolePermission in rolePermissionList" ng-class="{'selected':$index%2==1}">
                <td style="text-align: center;">
                    <!--<input name="isCheck" type="checkbox" id="{{rolePermission.id}}" value="{{rolePermission}}">-->

                    <div class="myStyleCheckBox">
                        <input type="checkbox" id="{{rolePermission.id}}" value="{{rolePermission}}" name="isCheck" />
                        <label for="{{rolePermission.id}}"></label>
                    </div>

                </td>

                <td style=" text-align:center;" class="englishOrChinese" title="{{rolePermission.name}}">
                    {{rolePermission.name.substring(0,20)}}
                    <a class="clickmore icon-double-angle-down" onclick="clickMore(this,20);"
                       data-ng-if="rolePermission.name.length>20">更多</a>
                </td>

                <td style="text-align:center;" class="englishOrChinese" title="{{rolePermission.creatorName}}">
                    {{rolePermission.creatorName.substring(0,20)}}
                    <a class="clickmore icon-double-angle-down" onclick="clickMore(this,20);"
                       data-ng-if="rolePermission.creatorName.length>20">更多</a>
                </td>

                <td style=" text-align:center;" class="englishOrChinese" title="{{rolePermission.remark}}">
                    {{rolePermission.remark.substring(0,45)}}
                    <a class="clickmore icon-double-angle-down" onclick="clickMore(this,45);"
                       data-ng-if="rolePermission.remark.length>45">更多</a>
                </td>

                <td style="">
                    <a class='a-button' ui-sref="center.rolePermissionDetail({id:rolePermission.id})">查看</a>
                    <a class='a-button' ui-sref="center.rolePermissionUpdate({id:rolePermission.id})">修改</a>
                </td>
            </tr>

            <tr id="dateStateJudgOne">
                <td colspan="6">
                    <div style="text-align: center;" id='show'>暂无数据</div>
                </td>
            </tr>
        </tbody>
    </table>
    <!--分页-->
    <div style="background: #ffffff;" ui-pagination items-per-page="itemsPerPage" total-items="totalItems" current-page="currentPage"></div>
</div>
<link  rel="import" href="setBasisRole.tpl?__inline"/>