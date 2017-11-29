
define(['angularAMD', 'index.service'], function (angularAMD) {

    //这里必须自己写数组形式的注入,工具不能识别这个格式自动修改
    return ['$scope', 'indexService', function(s, indexService) {

        var id = 1;

        indexService.getSomthing(id).then(function(data){
            //TODO data binding
            //s.data = data;
        });

    }];

});