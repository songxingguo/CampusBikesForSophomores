/*
* 格式化时间显示
* */
define(["angularAMD", "countdown"], function(angularAMD, countdown){

    angularAMD.filter('displayDate', function($filter) {

        var oneDay = 60 * 60 * 24;
        var newly = 3 * 60; //3分钟
        var oneHour = 60 * 60;// 1 hours
        var halfday = 60 * 60 * 12;// 12 hours
        return function(input) {
            if(!input)
                return '';

            var now = new Date();
            var year = now.getFullYear();
            var month = now.getMonth();
            var day = now.getDate();

            var todaySeconds = countdown(new Date(year,month, day), now, countdown.SECONDS).seconds;
            var seconds = countdown(input, now, countdown.SECONDS).seconds;
            var timespan = todaySeconds - seconds;

            if(timespan >= 0){
                if(seconds < newly)
                    return "刚刚";
                if(seconds <= oneHour){
                    return Math.floor(seconds / 60) + '分钟' + '前';
                }
                if(oneHour < seconds <= halfday){
                    return Math.floor(seconds / oneHour) + '小时' + '前';
                }
                return "今天";
            }else if(timespan + oneDay >= 0){
                return '昨天';
            }else if(timespan + oneDay*2 >= 0){
                return '前天';
            }else {
                return $filter("date")(input, "yyyy-MM-dd hh:mm");
            }
        };

    })

});