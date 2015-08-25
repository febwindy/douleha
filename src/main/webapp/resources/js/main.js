/**
 * Created by ivan_ on 2015/8/24.
 */
require.config({
    baseUrl: "/resources/js",
    paths: {
        "angular" : "./angularjs/app/lib/angular",
        "app" : "./angularjs/app/app",
        "userService" : "./angularjs/app/service/userService",
        "customDirective" : "./angularjs/app/directive/custom-directives",
        "loginCtrl" : "./angularjs/app/controller/loginCtrl"
    },
    shim: {
        'angular': {
            exports: 'angular'
        }
    },
    waitSeconds:0
});

require(['angular', 'app', "userService", "customDirective", 'loginCtrl'], function() {
    //TODO
});