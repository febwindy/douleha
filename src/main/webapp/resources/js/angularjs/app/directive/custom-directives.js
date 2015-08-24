/**
 * Created by ivan_ on 2015/8/24.
 */
define(['app'], function(app) {
    app.directive("tel", function () {
        return {
            restrict: "A",
            require: "?ngModel",
            link: function ($scope, $elem, $attrs, $ctrl) {
                var reg = /(13\d|14[57]|15[^4,\D]|17[678]|18\d)\d{8}|170[059]\d{7}/;
                $ctrl.$validators.tel = function(val) {
                    return $ctrl.$isEmpty(val) || reg.test(val);
                }
            }
        }
    });
});