<!--搜索区域-->
<div class="search_area">
    <span class="search_name">姓名</span>
    <input type="text" ng-model='condition.nickname'>

    <a class="button blue" ng-click="searchObject()">搜索</a>
</div>


<!--操作区域-->
<div class="operate_area">
    <!--<a class="button blue" ui-sref="center.userManagementAdd">新增</a>-->
    <a class="button red" ng-click="deleteUser()">删除</a>
</div>

<div class="content">
    <table class="table">
        <thead>
        <tr>
            <th>选择</th>
            <th>姓名</th>
            <th>角色</th>
            <th>运营商</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <tr ng-repeat="userManagement in userManagementList" ng-class="{'selected':$index%2==1}">
            <td style="width:5%" >
                <div class="myStyleCheckBox" style="margin: auto">
                    <input type="checkbox" id="{{userManagement.id}}" value="{{userManagement}}" name="isCheck" />
                    <label for="{{userManagement.id}}"></label>
                </div>
            </td>

            <td style="width:5%" title="{{userManagement.nickname}}">
                {{userManagement.nickname}}
            </td>

            <td style="width:15%" title="{{userManagement.roleName}}">
                {{userManagement.roleName}}
            </td>

            <td style="width:10%" title="{{userManagement.operatorName}}">
            	{{userManagement.operatorName}}
            </td>

            <td style="width:20%;" class="englishOrChinese" title="{{userManagement.createTime}}">
                {{userManagement.createTime}}
            </td>

            <td style="width:10%;">
                <a class='a-button' ui-sref="center.userManagementDetail({id:userManagement.id})">查看</a>
                <a class='a-button' ui-sref="center.userManagementUpdate({id:userManagement.id})">修改</a>
            </td>
        </tr>

        <tr id="dateStateJudgOne">
            <td colspan="8">
                <div style="text-align: center;" id='show'>暂无数据</div>
            </td>
        </tr>
        </tbody>
    </table>
    <!--分页-->
    <div ui-pagination items-per-page="itemsPerPage" total-items="totalItems" current-page="currentPage"></div>
</div>