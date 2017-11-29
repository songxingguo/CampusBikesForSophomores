/*
* rap ->rap项目地址 http://192.168.2.217:9080/org/index.do
* baiduMap ->百度地图api
* hm ->百度统计安装代码, 替换youDomainCode为自己站点的code, /hm.js 中也需要替换
* */
require.config({paths:{
    'rap': 'http://192.168.2.217:9080/rap.plugin.js?projectId=17&mode=3',
    'baiduMap': 'http://api.map.baidu.com/getscript?v=2.0&ak=R9P32kkkbCXSlZAV2XtVg4Ml',
     // /hm为备选的加载路径. 当第一个path加载失败时在hm中尝试再次手动加载.
     // 解决hm加载失败导致项目js不能被加载的问题
    'hm': ['//hm.baidu.com/hm.js?youDomainCode', '/hm'] 
    },
    waitSeconds: 60
});