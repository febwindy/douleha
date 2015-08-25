/**
 * Created by ivan_ on 2015/8/24.
 */
define(['app'], function(app) {
    app.controller("loginCtrl", function ($scope, $http, userService) {
        $scope.username = "";
        $scope.password = "";
        $scope.login = function () {
            $scope.errorMsg = {};
            if (this.loginForm.$invalid) {
                return;
            }
            userService.login({username:$scope.username, password:$scope.password})
                .then(function() {
                    //TODO login successfully
                }
                ,function(data) {
                    $scope.errorMsg = data;
                });
        }
    });
});