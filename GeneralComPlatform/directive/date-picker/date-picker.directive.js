/*
* 示例:
*  <div date-picker="editor.startDate" required format="yyyy-MM-dd HH:mm:ss" max="'2016-4-1'" class="pull-left"></div>
*  <div date-picker="editor.endDate" required min="editor.startDate" class="pull-left"></div>
* */

define(['angularAMD', 'datePicker', 'ng-verify'], function(angularAMD, datePicker){

    angularAMD.directive("datePicker", function() {
        return {
            restrict: 'EA',
            template: function(tElement, tAttrs){
                //随机生成表单名称
                var fromName = 'dpf' + new Date().getTime() + Math.round(Math.random() * 100);
                //随机生成input名称
                var inputName = 'dpi' + new Date().getTime() + Math.round(Math.random() * 100);

                //模板
                var ele = $(__inline('date-picker.tpl'));

                ele.attr('ng-form', fromName);
                ele.find('input').attr('name', inputName);
                ele.find('.error-messages').attr('ng-messages', fromName+'.'+inputName+'.$error');

                if(angular.isDefined(tAttrs.placeholder)){
                    ele.find('input').attr('placeholder', tAttrs.placeholder);
                }

                //必填验证
                if(angular.isDefined(tAttrs.required)){
                    ele.find('input').attr('required', 'required');
                    var errorMsg = tAttrs.requiredError ? '{{requiredError}}' : '请输入日期';
                    ele.find('.error-messages').append('<span ng-message="required">'+errorMsg+'</span>');
                    tElement.removeAttr('required');
                }
                //最大值验证
                if(angular.isDefined(tAttrs.max)){
                    ele.find('input').attr('max-time', 'max');
                    var errorMsg = tAttrs.maxError || '必须小于等于 {{max | date:format}}';
                    ele.find('.error-messages').append('<span ng-message="maxTime">'+errorMsg+'</span>');
                    tElement.removeAttr('max');
                }
                //最小值验证
                if(angular.isDefined(tAttrs.min)){
                    ele.find('input').attr('min-time', 'min');
                    var errorMsg = tAttrs.minError || '必须大于等于 {{min | date:format}}';
                    ele.find('.error-messages').append('<span ng-message="minTime">'+errorMsg+'</span>');
                    tElement.removeAttr('min');
                }

                return ele;
            },
            scope:{
                'datePicker': '=',
                'requiredError': '@',
                'max': '=',
                'maxError': '@',
                'min': '=',
                'minError': '@'
            },
            link: function (scope, element, attrs, controller) {
                scope.format = attrs.format || 'yyyy-MM-dd';
                element.find('input').bind('click', function () {
                    datePicker({dateFmt: scope.format});
                })

            }

        };
    });
});