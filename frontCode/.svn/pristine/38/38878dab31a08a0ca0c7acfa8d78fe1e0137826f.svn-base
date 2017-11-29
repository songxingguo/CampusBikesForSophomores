/**
 *  Created by songxingguo on 2017/7/2.
 *  入口资源加载
 */
var root = '../base-app/js/';
require.config({
    baseUrl: "../cbr-app/",
    paths: {
        'jquery': root + 'jquery/jquery',
        'angular': root + 'angular/angular.min',
        'angularAMD' : root + 'angularAMD/angularAMD.min',
        'ui-router': root +  'ui-router/ui-router',
        'angularUiRouter' : root + 'angular/angular-ui-router.min',
        'ngLoad':root + 'angularAMD/ngload.min',
        'bootstrap' : '../base-app/bootstrap/dist/js/bootstrap.min',
        'shiv': root + 'adaptIE/html5shiv.min',
        'respond': root + 'adaptIE/respond.min'
    },
    shim: {
        "angular" : {
            experts : "angular"
        },
        "angularUiRouter" : {
            deps : ["angular"],
            experts : "angularUiRouter"
        },
        "angularAMD" : {
            deps : ["angular"],
            experts : "angularAMD"
        },
        "ngLoad" : {
            deps : ["angularAMD"],
            experts : "ngLoad"
        },
        "bootstrap" : {
            deps : ["jquery"],
            experts : 'bootstrap'
        }
    },
    deps : ['app']
});