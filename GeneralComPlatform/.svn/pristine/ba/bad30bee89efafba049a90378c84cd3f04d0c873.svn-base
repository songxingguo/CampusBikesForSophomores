/**
 * 如果数字大于1000,使用K(千)作为单位返回数字, 保留一位小数
 * 例如 1100 -> 1.1k
 */
define(["angularAMD"], function(angularAMD){

    angularAMD.filter('count', function(){
        return function(input){

            if(!input)
                return 0;

            return input < 1000 ? input : ((input/100) | 0) / 10 + 'k';
        }
    })

});