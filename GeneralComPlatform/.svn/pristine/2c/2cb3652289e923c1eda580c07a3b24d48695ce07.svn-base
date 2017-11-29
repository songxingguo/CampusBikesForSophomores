//fis install 配置
fis.config.set("component.dir","/modules");
fis.config.set("component.protocol","gitlab");
fis.config.set("component.github.author","angular-moon");
fis.config.set("component.gitlab.domain","http://192.168.2.219/");
fis.config.set("component.gitlab.author","gmsoft");
fis.config.set("component.gitlab.token","FDfSKZymsPoWYXb2rLqf");

//排除编译的文件
fis.config.set('project.ignore', ['.idea/**','*.bat',"**/README.md"]);

//开启AMD模式,项目中用的很多的模块想定义ID可以在这里配置
fis.hook('amd');

//less预处理,定义基础的css依赖(bootstrap,common),项目中不用再写了
fis.match('**.less', {
  // fis-parser-less 插件进行解析
  useSprite: true,
  parser: fis.plugin('less'),
  // .less 文件后缀构建后被改成 .css 文件
  rExt: '.css',
  requires : ['modules/bootstrap/css/bootstrap.css','modules/bootstrap/css/bootstrap-theme.css','css/common.less']
});

//为app结尾的文件夹做css2js处理
fis.match('/*app/**.less',{
    preprocessor: [fis.plugin('cssgrace'), fis.plugin('css2js')],
    rExt: '.js',
    id: 'css2js$0',
    isMod: true,
    release: 'css2js/$0'
})

//生成css延迟加载代码
var reg = /css:require\(\[?([^\(\[\]\)]*)\]?\)/igm;
fis.match('**.router.js', {
    preprocessor: function(content, file, conf) {
        if(reg.test(content)){
            content = content.replace(reg, "resolve:{css:['$q',function($q){var deferred = $q.defer();require([$1],function(){deferred.resolve();});return deferred.promise;}]}");
        }
        reg.lastIndex = 0;
        return content;
    }
});

//modules下面都是模块化资源
fis.match(/^\/modules\/(.*)\.(js)$/i,{
    isMod: true
})
//datePicker,umeditor中的非主文件不包装define
.match("/modules/{umeditor,datePicker}/**.js", {
    isMod : false
})
.match("/modules/umeditor/umeditor.js", {
    isMod : true
})
.match("/modules/datePicker/datePicker.js", {
    isMod : true
})
//自动增加angularjs依赖注入注解,保证压缩后的代码依赖注入不会出错
.match(/^(?!\/modules\/)(.*)\.(js)$/i, {
    extras:{
        isAnnotate:true
    },
    postprocessor : fis.plugin("annotate", null, "append")
})
//tpl编译时使用html标准编译流程处理
.match("**.tpl", {
    isHtmlLike : true,
        useMap: true
})
//页面模板不用编译缓存
.match(/.*\.(html|jsp|tpl|vm|htm|asp|aspx|php)$/,{
    useCache: false
})

//静态资源前端加载器，用来分析页面中使用的和依赖的资源（js或css）, 并将这些资源做一定的优化后插入页面中。如把零散的文件合并。
//详见: https://github.com/fex-team/fis3-postpackager-loader
fis.match('::package', {
    // npm install [-g] fis3-postpackager-loader
    // 分析 __RESOURCE_MAP__ 结构，来解决资源加载问题
    spriter: fis.plugin('csssprites'),
    postpackager: fis.plugin('loader', {
        resourceType: 'amd',
        include: "**.js",
         processor: {
          '.html': 'html',
          '.tpl': 'html'
        }
    })
})

function replacer(opt) {
    if (!Array.isArray(opt)) {
        opt = [opt];
    }
    var r = [];
    opt.forEach(function (raw) {
        r.push(fis.plugin('replace', raw));
    });
    return r;
};

fis.match('**', {
    deploy: replacer([
        {
            from: /\$\{location_admin\}/g, //政府采购信息发布系统
            to: 'sign.action'
        },{
            from: /\$\{location_provider\}/g, //供应商管理系统
            to: 'supplier/home.action'
        },{
            from: /\$\{location_agent\}/g, //代理机构管理系统
            to: '/Agent/首页.html'
        },{
            from: /\$\{location_expert\}/g, //专家管理系统
            to: 'sign!expert.action'
        },{
            from: /\$\{location_contract\}/g, //合同公示系统
            to: 'contractpost/home.action'
        },{
            from: /\$\{location_statistics\}/g, //政府采购信息统计管理系统
            to: 'http://xxtj.ccgp.gov.cn/rone/SignOnServlet'
        },{
            from: /\$\{location_bad_behaviors\}/g, //严重违法失信行为记录名单
            to: 'http://www.ccgp.gov.cn/cr/list'
        },{
            from: /\$\{location_provider_reg\}/g, //供应商注册
            to: '/supplier/regist_registration'
        },{
            from: /\$\{location_expert_reg\}/g, //专家注册
            to: '/expert_rp/reg.html'
        },{
            from: /\$\{location_agent_reg\}/g, //代理机构注册
            to: '/Agent/代理机构注册条款阅读.html'
        },{
            from: /\$\{location_provider_more\}/g, //查看更多供应商
            to: '/supplier/searchAction_toSearch.action'
        },{
            from: /\$\{location_agent_more\}/g, //查看更多代理机构
            to: '/Agent/代理机构搜索页.html'
        }
    ])/*.concat(fis.plugin('http-push', {
         receiver: 'http://192.168.2.62:8999/receiver',
            to: 'd:/work/htdocs' // 注意这个是指的是测试机器的路径，而非本地机器
        }))*/
    .concat(fis.plugin('local-deliver'))//发布到本地
});


//上线发布,压缩,打包
fis.media('prod')
    // 加 md5
    .match('**.{js,less,css,png,jpg,gif}', {
        useHash: true
    })
    .match('**.js', {
        // fis-optimizer-uglify-js 插件进行压缩，已内置
        optimizer: fis.plugin('uglify-js')
    })
    .match('**.{less,css}', {
        // 给匹配到的文件分配属性 `useSprite`
        useSprite: true,
        //压缩css
        optimizer: fis.plugin('clean-css', {
            'keepBreaks': false //不保持一个规则一个换行
        })
    })
    .match('**.png', {
        // fis-optimizer-png-compressor 插件进行压缩，已内置
        optimizer: fis.plugin('png-compressor')
    })
    //打包和CND示例
    /*.match('/website/*.{scss,css,less}',{
        packTo:"css2js/website.js"
    })
    .match("css2js/website.js",{
        domain:"http://192.168.2.62:8080"
    })*/


 //代码检查
fis.match('**.js', {
    lint: fis.plugin('jshint',{
        //ignored :
        ignored : [ '/modules/**.js', '/parts/shim/**.js',
            '/interceptor/**.js', '/require.js', '/fis-conf.js'],
        //using Chinese reporter
        i18n : 'zh-CN',
        //jshint options http://jshint.com/docs/options/
        camelcase : true,
        es3: true,
        eqeqeq: false,
        curly : true,
        forin : true,
        latedef : true,
        newcap : true,
        noarg : true,
        noempty : true,
        unused : false
    })
});


