<!--搜索区域-->
<div class="search_area">
    <span class="search_name">模块名</span>
    <input type="text" ng-model="condition.name" />

    <a class="button blue" ng-click="searchObject()">搜索</a>
</div>

<!--操作区域-->
<div class="operate_area">
    <a class="button blue" ui-sref="center.moduleManagementAdd({parentCode:parentCode})">新增</a>
    <a class="button red" ng-click="deleteModuleManagements()">删除</a>

    <div class="navigation_bars">
        <img src="img/location.png">
        <span style="color: #6cb7f1" id="level0">模块</span><!--firstLevel-->
    </div>
</div>

<div class="content">
    <table class="table">
        <thead>
            <tr>
                <th>选择</th>
                <th>模块编码</th>
                <th>模块名称</th>
                <th>url</th>
                <th>操作</th>
            </tr>
        </thead>

        <tbody>
            <tr ng-repeat="moduleManagement in moduleManagementList" ng-class="{'selected':$index%2==1}">
                <td style="width:5%;text-align: center;" >
                    <div class="myStyleCheckBox" >
                        <input type="checkbox" id="{{moduleManagement.id}}" value="{{moduleManagement}}" name="isCheck"/>
                        <label for="{{moduleManagement.id}}"></label>
                    </div>
                </td>

                <td style="width:15%;" class="englishOrChinese" title="{{moduleManagement.code}}">
                    {{moduleManagement.code}}
                </td>

                <td style="width:20%;" class="englishOrChinese" title="{{moduleManagement.name}}">
                    {{moduleManagement.name}}
                </td>

                <td style="width:15%;" class="englishOrChinese" title="{{moduleManagement.url}}">
                    {{moduleManagement.url.substring(0,20)}}
                    <a class="clickmore icon-double-angle-down" onclick="clickMore(this,20);"
                       data-ng-if="moduleManagement.url.length>20">更多</a>
                </td>

                <td style="width:25%;" class="englishOrChinese">
                    <a class='a-button' ui-sref="center.moduleManagementDetail({id:moduleManagement.id})"><span>查看</span></a>
                    <a class='a-button' ui-sref="center.moduleManagementUpdate({id:moduleManagement.id})"><span>修改</span></a>
                    <a class='a-button' ng-click="moveUp(moduleManagement)"><span>上移</span></a>
                    <a class='a-button' ng-click="moveDown(moduleManagement)"><span>下移</span></a> 
                    <a class='a-button' id="changeState" ng-click="enterNextLevel(moduleManagement.moduleName,moduleManagement.moduleCode,moduleManagement.level0)"><span>进入下一级</span></a>
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
    <div ui-pagination items-per-page="itemsPerPage" total-items="totalItems" current-page="currentPage"></div>
</div>