
define(['angularAMD'], function(angularAMD){

    /*$http.get 语法糖*/
    angularAMD.factory('getData', function($http){

        return function(api, params, cache){
            var config = {};
            if(params)
                config = {"params": params};
            if(cache)
                config.cache = true;

            return $http.get(api, config).then(function(response){
                return response.data;
            });
        }
    })
});
