(function (angular) {
    var Core_Service = function (Core_HttpRequest, $state, $timeout, $q) {
        var service = this;

        service.login = function (data) {
            var deferred = $q.defer();
            Core_HttpRequest.get("logincreds")
                    .then(function (response) {
                        if (response.status == 200) {
                            deferred.resolve(service.isAuthenticated(data, response.data))

                        }
                    }, function (response) {
                        response.data = false;
                        deferred.reject(response.data);
                    });
            return deferred.promise;
        };

        service.isAuthenticated = function (item, data) {
            var isUserNameOk, isPasswordOk;
            for (var i = 0; i < data.length; i++) {
                isUserNameOk = false;
                isPasswordOk = false;
                for (var key in data[i]) {
                    if (item[key] == data[i][key]) {
                        if (key == "username")
                            isUserNameOk = true;
                        else if (key == "password")
                            isPasswordOk = true;
                    }
                }
                if (isUserNameOk && isPasswordOk) {
                    return true;
                }
            }
            return false;
        };

        service.calculetSidebarHeight = function () {
            $timeout(function () {
                var height = angular.element(".page-content-div").height();
                if (height < 171) {
                    height = 171;
                }
                angular.element("#sidebar-wrapper").height(height);
            }, 200);
        };
        
        service.getAllLookupValues = function(url){
        	var deferred = $q.defer();
            Core_HttpRequest.postHttp(url)
                    .then(function (response) {
                        console.log(response)
                    }, function (response) {
                    	
                    });
            return deferred.promise;
        }
    };


    
    Core_Service.$inject = ['Core_HttpRequest', '$state', '$timeout', '$q'];
    angular.module('app.common')
            .service('Core_Service', Core_Service);
})(angular);
