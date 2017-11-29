/**
 * Created by tjc on 2017/07/06.
 */

define(['angularAMD', 'gotop', 'ui-pagination', 'angular', 'angular-messages',
        'ng-verify', 'datePicker', '/filter/displayDate.filter'
        , 'popup-message', 'angular-messages', 'ui-autocomplete', 'contest-app/codeTable/codeTable.service',
        'common-app/common.service','directive/remoteValidationDate'],
    function (angularAMD, gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope', 'codeTable', '$state', 'common', '$stateParams', function (s, codeTable, $state, common, sp) {

            /**
             * 返回顶部
             */
            gotop();

            /**
             * 得到一条数据
             */
            s.codes = sp.codes;//传过来的参数
            s.codeTableObject = {};

            (s.loadBegin = function () {
                if (s.codes) {
                    codeTable.getCodesByCodes(s.codes).then(function (data) {
                        s.codeType=data.codeType;
                        s.paramName=data.paramName;
                        s.codeTableObject = data;
                    });
                }
            })();
            /**
             * 加载码表类型
             */
            s.typeList = [];
            s.typeConds = {};
            (s.loadType = function () {
                common.getParamList(s.typeConds).then(function (data) {
                    s.typeList = data;
                });
            })();

            /**
             * 修改码表
             */
            s.codeTableObject = {};

            s.updateCodeTableObject = function () {
                console.info(s.codeTableObject);
                codeTable.updateCodes(s.codeTableObject).then(function (data) {
                    if (data.status == 'true') {
                        $state.go("center.codeTable");
                        showToast(getPrompt(1,'修改'));
                    }
                    else
                        showMsg("error", getPrompt(2,"修改"));
                });
            }
        }];
    });
