define(['angularAMD', 'service/get.service'], function (angularAMD){

    var api = 'somthing/:id';

    angularAMD.service('indexService', function($http, getData){
        
        /**
         * 获取xxx
         * @param id 参数说明
         * @returns {*}
         */
        this.getSomthing = function(id){

            return getData(api.replace(':id', id));
        }

    })


});