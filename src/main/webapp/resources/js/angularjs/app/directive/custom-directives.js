/**
 * Created by ivan_ on 2015/8/24.
 */
define(['app'], function(app) {
    app.directive("tel", function () {
        return {
            restrict: "A",
            require: "?ngModel",
            link: function ($scope, $elem, $attrs, $ctrl) {
                var reg = /^(13\d|14[57]|15[^4,\D]|17[678]|18\d|170)\d{8}$/;
                $ctrl.$validators.tel = function(val) {
                    return $ctrl.$isEmpty(val) || reg.test(val);
                }
            }
        }
    });
});