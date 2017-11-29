<!--头部信息-->
<div class="center_head">
    <ul>
        <li style="cursor: pointer;" ng-module="noticeNum">
           <a ui-sref="center.noticeAlert"><img src="img/infoPointBack.png" class="img_info"></a>
           <div ng-show="judge">
               <img src="img/infoPointFont.png" class="img_infoCircle" >
               <div class="info_num">{{noticeNum}}</div>
           </div>
           <a ui-sref="center.noticeAlert"><p class="info_num_detail">您有{{noticeNum}}条新消息</p></a>
        </li>

        <li>
            <img style="margin-top: 12px;" src="img/time.png" class="img_info">
            <p class="info_num_detail">{{time}}&nbsp&nbsp&nbsp{{week}}</p>
        </li>

        <!--<li>-->
            <!--<div class="login_out" ui-sref="login">-->
                <!--<div class="button_out">-->
                    <!--<span>注销</span>-->
                    <!--<img src="img/loginOut.png"/>-->
                <!--</div>-->
            <!--</div>-->
        <!--</li>-->
        <li style="text-align: right;">
            <div class="person_info" ng-click="showInfo(1)" id="showInfo">
                <img src="img/person_small.png" style="margin-top:-2px;" id="hideId1">
                <span id="hideId2">{{loginInfo.name.substring(0,5)}}<span ng-if="loginInfo.name.length>5">...</span></span>
                <img id="hideId3" src="img/next_person.png">
            </div>
        </li>
        <div class="showAllInfo" id="showAllInfo" style="display: none">
            <div class="person_info" ng-click="showInfo(2)" style="text-align: center;">
                <img src="img/person_small.png" style="margin-top:-2px; margin-left: -8px;">
                <span>{{loginInfo.name.substring(0,5)}}<span ng-if="loginInfo.name.length>5">...</span></span>
                <img src="img/goOn.png" style="margin-right: 1px">
            </div>
            <div class="bothDivision">
                <div></div>
                <div style="background: #466785"></div>
            </div>

            <div class="bothDivision" style="cursor: pointer;height: 20px;margin-left:24px;" ng-click="showBaseInfoBounced()">
               <img src="img/ziliao.png">
                <span>个人信息</span>
            </div>

            <div class="bothDivision" style="cursor: pointer;height: 20px;margin-left:24px;" ng-click="showPasswordBounced()">
                <img src="img/mima.png">
                <span>修改密码</span>
            </div>

            <div class="bothDivision loginOUt" style="" ui-sref="login">
                <img src="img/zhuxiao.png">
                <span>注销</span>
            </div>
        </div>
    </ul>
</div>
