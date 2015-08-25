/**
 * Created by ivan_ on 2015/8/25.
 */
define(['app'], function(app) {
   app.service("userService", function($q, $http) {
       /**
        * user login method
        * @param params params is a object, the following parameter's structure: {username:"", password:""}
        * @returns {h.promise|promise|qFactory.Deferred.promise|fd.g.promise}
        */
       this.login = function(param) {
           var errorMsg = {};
           var deferred = $q.defer();
           $http.post("/login", param)
               .success(function(data) {
                   if (data["status"] == "FAILED") {
                       if (typeof data["errorMsg"] == "object") {
                           angular.forEach(data["errorMsg"], function(v, k) {
                               errorMsg[k] = v;
                           });
                       } else {
                           errorMsg.unknownAccountError = data["errorMsg"];
                       }
                       deferred.reject(errorMsg);
                   } else {
                       deferred.resolve();
                   }
               })
               .error(function(data) {
                   deferred.reject("The request was an error.");
               });
           return deferred.promise;
       }
   });
});