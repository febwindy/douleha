/**
 * Created by ivan_ on 2015/8/24.
 */
require.config({
    baseUrl: "/resources/js",
    paths: {
        "angular" : "./angularjs/app/lib/angular",
        "app" : "./angularjs/app/app",
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

require(['angular', 'app', "customDirective", 'loginCtrl'], function() {
    //TODO
});