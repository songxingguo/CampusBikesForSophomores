<!--搜索区域-->
<div class="search_area">
    <span class="search_name">参数名称</span>
    <input type="text" ng-model='condition.paramName'>
    <span class="search_name">参数内容</span>
    <input type="text" ng-model='condition.paramText'>

    <a class="button blue" ng-click="searchObject()">搜索</a>

</div>

<!--操作区域-->
<div class="operate_area">
    <a class="button blue" ui-sref="center.codeTableAdd({parentCode:parentCode})">新增</a>
    <a class="button red" ng-click="deleteCodeTable()">删除</a>

    <div class="navigation_bars">
        <img src="img/location.png">
        <span style="color: #6cb7f1" id="level1">码表</span>
    </div>
</div>

<div class="content">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>选择</th>
            <th>代码类型</th>
            <th>名称</th>
            <th>内容</th>
            <th>级别</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <tr ng-repeat="codeTable in codeTableList" ng-class="{'selected':$index%2==1}">
            <td style="width:6%;text-align: center;">
                <div class="myStyleCheckBox" style="margin:auto">
                    <input type="checkbox" id="{{codeTable.param_code}}" value="{{codeTable}}" name="isCheck" />
                    <label for="{{codeTable.param_code}}"></label>
                </div>
            </td>

            <td style="width:17%;" class="englishOrChinese" title="{{codeTable.code_type}}">
                {{codeTable.code_type.substring(0,20)}}
                <a class="clickmore icon-double-angle-down" onclick="clickMore(this,20);"
                   data-ng-if="codeTable.code_type.length>20">更多</a>
            </td>

            <td style="width:15%;" class="englishOrChinese" title="{{codeTable.param_name}}">
                {{codeTable.param_name.substring(0,10)}}
                <a class="clickmore icon-double-angle-down" onclick="clickMore(this,10);"
                   data-ng-if="codeTable.param_name.length>10">更多</a>
            </td>

            <td style="width:30%;text-align: left" class="englishOrChinese" title="{{codeTable.param_text}}">
                {{codeTable.param_text.substring(0,22)}}
                <a class="clickmore icon-double-angle-down" onclick="clickMore(this,22);"
                   data-ng-if="codeTable.param_text.length>22">更多</a>
            </td>

            <td style="width:10%;" class="englishOrChinese" title="{{codeTable.level0}}">
                {{codeTable.level0}}
            </td>

            <td style="width:20%">
                <a class='a-button' ui-sref="center.codeTableDetail({codes:codeTable.param_code})">查看</a>
                <a class='a-button' ui-sref="center.codeTableUpdate({codes:codeTable.param_code})">修改</a>
                <a class='a-button' ng-click="gotoNextLevel(codeTable.param_name,codeTable.param_code,codeTable.level0)">进入下一级</a>
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