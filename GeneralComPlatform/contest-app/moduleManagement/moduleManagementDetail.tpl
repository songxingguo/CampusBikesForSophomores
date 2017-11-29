<!--查看模块信息-->
<!--填写基本信息的区域-->
<form>
<table  class="basicMass readDetail">
    <tr class="basicMass-input">
        <td class="key" style="width: 40%">
            <span>模块名称</span>:
        </td>
        <td class="basicMass-input-td">
            <p class="show-content">{{moduleObject.name}}</p>
        </td>
    </tr>
    <tr class="basicMass-input">
        <td class="key noFirst">
            <span>url</span>:
        </td>
        <td class="basicMass-input-td">
            <p class="show-content">{{moduleObject.url}}</p>
        </td>
    </tr>
    <tr class="basicMass-input">
        <td class="key">
            <span>模块编码</span>:
        </td>
        <td class="basicMass-input-td">
            <p class="show-content">{{moduleObject.code}}</p>
        </td>
    </tr>
</table>

<!--按钮区域-->
<div class="page-operator">
    <a class="button white" ng-click="goBack()">返回</a>
</div>
</form>