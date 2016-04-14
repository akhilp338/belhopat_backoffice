(function(angular) {
    angular.module('app.common')
            .factory('Core_HttpRequest', function($http, urlConfig) {
                var service = this;                
                var getUrl = function(path) {
                    return urlConfig.api_endpoint + path + ".json";
                };
                var buildUrl = function(path) {
                    return urlConfig.api_root_path + path;
                };
                service.get = function(path) {
                    return $http.get(getUrl(path));
                };
                service.post = function(path, jsonData, id) {
                    return $http.post(getUrl(path), jsonData);
                };
                
                service.postHttp = function(path, jsonData, id) {
                    return $http.post(buildUrl(path), jsonData);
                };
                
                service.formPost = function(path, jsonData, id) {
                    return $http.post(getUrl(path), jsonData, {
                        transformRequest: angular.identity,
                        headers: {'Content-Type': undefined}});
                };
                return service;
            });
})(angular);
