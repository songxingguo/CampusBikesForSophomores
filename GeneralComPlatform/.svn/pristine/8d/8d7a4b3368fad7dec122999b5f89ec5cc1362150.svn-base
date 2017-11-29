define(["angular", "mock"], function(angular, Mock){

 	function find(options) {
        for (var sUrlType in Mock._mocked) {
            var item = Mock._mocked[sUrlType];
            if ((!item.rurl || match(item.rurl, options.url)) && (!item.rtype || match(item.rtype, options.method.toLowerCase()))) {
                return item;
            }
        }
        function match(expected, actual) {
            if (Mock.Util.type(expected) === "string") {
                return expected === actual;
            }
            if (Mock.Util.type(expected) === "regexp") {
                return expected.test(actual);
            }
        }
    }
    function convert(item, options) {
        return Mock.Util.isFunction(item.template) ? item.template(options) : Mock.mock(item.template);
    }

	angular.module("mock.interceptor", [])
	.config(["$httpProvider", function($httpProvider){
			$httpProvider.interceptors.push(function() {
		    return {
		     'request': function(config) {
		           var item = find(config);
	                if (item) {
	                	config.mockData = convert(item, config);
						config.method = "GET";
                  		config.url = "?mockUrl=" + config.url;
			      	}
			      	return config;
			    },

		      'response': function(response) {
	                if (response.config.mockData) {
	                  response.data = response.config.mockData;
	                }
	                return response;
		      	}
		    };
		});
	}]);

	return "mock.interceptor";
});