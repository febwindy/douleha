/**
 * Created by ivan_ on 2015/8/24.
 */
define(['app'], function(app) {
    app.controller("loginCtrl", function ($scope) {
        $scope.login = function () {
            $scope.username = "liwenhe";
        }
    });
});