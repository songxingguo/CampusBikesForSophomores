<!--查看码表明细-->
<!--填写基本信息的区域-->
<form>
<table class="basicMass readDetail">
    <tr class="basicMass-input">
        <td class="key">
            <span>代码类型</span>:
        </td>
        <td class="basicMass-input-td">
            <p class="show-content">{{codeTableObject.codeType}}</p>
        </td>

        <td class="key">
            <span>参数名称</span>:
        </td>
        <td class="basicMass-input-td">
            <p class="show-content">{{codeTableObject.paramName}}</p>
        </td>
    </tr>

    <tr class="basicMass-input">
        <td class="key" width="20%">
            <span>参数内容</span>:
        </td>
        <td class="basicMass-input-td" colspan="3">
            <p class="show-content" style="height:auto;width:90%">{{codeTableObject.paramText}}</p>
        </td>
    </tr>
</table>
<!--按钮区域-->
<div class="page-operator">
    <a class="button white" ui-sref="center.codeTable">返回</a>
</div>
</form>