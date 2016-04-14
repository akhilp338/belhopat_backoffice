(function (angular) {
    var Core_Service = function ($rootScope,Core_HttpRequest,Base64, $state,$cookieStore, $http, $q) {
        var service = this;

        service.login = function (data) {
            var deferred = $q.defer();
            var user={};
            user.username=data.username;
            user.password=data.password;
            Core_HttpRequest.post("api/login",user)
                    .then(function (response) {
                        if (response.status == 200) {
                               deferred.resolve(response.data);
 
                        }
                    }, function (response) {
                        response.data = false;
                        deferred.reject(response.data);
                    });
            return deferred.promise;
        };

        service.isAuthenticated = function (item,data) {
            var isUserNameOk,isPasswordOk;
            for(var i=0; i<data.length; i++){
                isUserNameOk = false;
                isPasswordOk = false;
            for(var key in data[i]){
                if(item[key] == data[i][key]){
                    if(key == "username")
                        isUserNameOk = true;
                    else if(key == "password")
                        isPasswordOk  = true;
                }
            }
            if(isUserNameOk && isPasswordOk){
                return true;
            }
        }
        return false;
        };
        service.SetCredentials = function (username, password) {
            var authdata = Base64.encode(username + ':' + password);
  
            $rootScope.globals = {
                currentUser: {
                    username: username,
                    authdata: authdata
                }
            };
  
            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
            $cookieStore.put('globals', $rootScope.globals);
        };
  
        service.ClearCredentials = function () {
            $rootScope.globals = {};
            $cookieStore.remove('globals');
            $http.defaults.headers.common.Authorization = 'Basic ';
        };
    };
    
    Core_Service.$inject = ['$rootScope','Core_HttpRequest','Base64', '$state', '$cookieStore','$http', '$q'];
    angular.module('app.common')
            .service('Core_Service', Core_Service);
})(angular);
