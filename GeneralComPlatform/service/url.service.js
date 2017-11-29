define(function(){

    /**根据配置获取,路由的url 用于跨app的跳转**/
    var urlBuilder = {};

    //${domain} ${app_base} ${hash} 来自fis-conf.js 的配置
    var appPrefix = '${hash}'.length ? '${domain}${app_base}${hash}' : '${domain}${app_base}'.slice(0, -1);

    //${domain} ${admin_base} ${hash} 来自fis-conf.js 的配置
    var adminPrefix = '${hash}'.length ? '${domain}${admin_base}${hash}' : '${domain}${admin_base}'.slice(0, -1);

    //${domain} ${user_base} ${hash} 来自fis-conf.js 的配置
    var userPrefix = '${hash}'.length ? '${domain}${user_base}${hash}' : '${domain}${user_base}'.slice(0, -1);

    urlBuilder.adminApp = function(){
        return adminPrefix;
    }

    urlBuilder.userApp = function(){
        return userPrefix;
    }

    /**获取url请求参数**/
    function getUrlQueryString(url) {
        // spliting the url and query string using question mark
        var splitUrl = url.split("?");

        // again spliting the data which will have & symbol
        var strUrl = (splitUrl.length>1) ? splitUrl[1].split("&") : 0;

        var i = 0;
        var iLen = strUrl.length;

        var str = '';
        var obj = {};

        // iterator to assign key pair values into obj variable
        for(i=0;i<iLen;i++) {
            str = strUrl[i].split("=");
            obj[str[0]] = str[1];
        }

        // returning the value
        return Array.prototype.sort.call(obj);
    }

    return {urlBuilder: urlBuilder, getUrlQueryString: getUrlQueryString};
});
