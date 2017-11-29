/**
 * Created by tjc on 2017/07/06.
 */

define(['angularAMD', 'gotop', 'ui-pagination', 'angular', 'angular-messages',
        'ng-verify', 'datePicker', '/filter/displayDate.filter'
        , 'popup-message', 'angular-messages', 'ui-autocomplete', 'contest-app/codeTable/codeTable.service'],
    function (angularAMD, gotop) {

        //延迟加载的module需要调用
        angularAMD.processQueue();

        //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
        return ['$scope', 'codeTable', '$state', '$stateParams', function (s, codeTable, $state, sp) {

            /**
             * 返回顶部
             */
            gotop();

            s.codes = sp.codes;//传过来的参数

            /**
             * 得到一条数据
             */
            s.codeTableObject = {};
            (s.loadBegin = function () {
                codeTable.getCodesByCodes(s.codes).then(function (data) {
                	console.info(data);
                    s.codeTableObject = data;
                });
            })();
        }];

    });
