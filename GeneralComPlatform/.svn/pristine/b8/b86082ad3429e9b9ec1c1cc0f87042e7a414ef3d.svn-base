
//hm 百度统计
define(["angularAMD", 'gotop', 'hm'], function(angularAMD){

  var app = angular.module("app", [
      require('angular-sanitize'),
      require('angular-loading-bar'),
      require('angular-once'),
      require('interceptor/rap.interceptor'),
      require('interceptor/errorHandler.interceptor'),
      require('ui-router'),
      require('index/index.router')
      /*
      * TODO
      * 在此处增加需要加载的router
      */
  ]);

  app.config(['$locationProvider', function ($locationProvider) {
      //SEO fragment
      $locationProvider.hashPrefix('!');
  }]);

  app.run(function($rootScope, $state) {
      $rootScope.$state = $state;

      //百度统计 ajax http://tongji.baidu.com/open/api/more?p=guide_trackPageview
      $rootScope.$on("$stateChangeSuccess", function(event, toState, toParams){
          var _hmt = _hmt || [];
          var pageURL = $state.href(toState, toParams);
          _hmt.push(['_trackPageview', pageURL]);
      });
  });

  angular.element(document).ready(function() {
      angularAMD.bootstrap(app);
  });

  return app;

});