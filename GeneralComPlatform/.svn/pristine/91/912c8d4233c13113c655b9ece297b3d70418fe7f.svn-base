/*demo
 <div placeholder="最低预算" currency="minBudget" required min="1" max="999999999"></div>
 <div class="col-sm-6" placeholder="最高预算" currency="maxBudget" required min="minBudget" max="999999999"></div>
 */
define(['angularAMD', 'ng-verify'], function(angularAMD){

    angularAMD.directive("currency", function() {
        return {
            restrict: 'EA',
            template: function(tElement, tAttrs){
                //随机生成表单名称
                var fromName = 'dpf' + new Date().getTime() + Math.round(Math.random() * 100);
                //随机生成input名称
                var inputName = 'dpi' + new Date().getTime() + Math.round(Math.random() * 100);

                //模板
                var ele = $(__inline('currency.tpl'));

                ele.attr('ng-form', fromName);
                ele.find('input').attr('name', inputName);
                ele.find('.error-messages').attr('ng-messages', fromName+'.'+inputName+'.$error');

                if(angular.isDefined(tAttrs.placeholder)){
                    ele.find('input').attr('placeholder', tAttrs.placeholder);
                }

                //必填验证
                if(angular.isDefined(tAttrs.required)){
                    ele.find('input').attr('required', 'required');
                    var errorMsg = tAttrs.requiredError ? '{{requiredError}}' : '请输金额';
                    ele.find('.error-messages').append('<span ng-message="required">'+errorMsg+'</span>');
                    tElement.removeAttr('required');
                }
                //最大值验证
                if(angular.isDefined(tAttrs.max)){
                    ele.find('input').attr('ng-max', 'max');
                    var errorMsg = tAttrs.maxError || '必须小于等于 {{max | currency:"¥"}}';
                    ele.find('.error-messages').append('<span ng-message="max">'+errorMsg+'</span>');
                    tElement.removeAttr('max');
                }
                //最小值验证
                if(angular.isDefined(tAttrs.min)){
                    ele.find('input').attr('ng-min', 'min');
                    var errorMsg = tAttrs.minError || '必须大于等于 {{min | currency:"¥"}}';
                    ele.find('.error-messages').append('<span ng-message="min">'+errorMsg+'</span>');
                    tElement.removeAttr('min');
                }

                return ele;
            },
            scope:{
                'currency': '=',
                'requiredError': '@',
                'max': '=',
                'maxError': '@',
                'min': '=',
                'minError': '@'
            }
        };
    });
});