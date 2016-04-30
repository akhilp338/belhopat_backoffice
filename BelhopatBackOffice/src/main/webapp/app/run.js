(function () {
    'use strict';
    var Core_Run = function ($rootScope, $state, $cookieStore, $window, Core_Service, $http) {
        $rootScope.globals = $cookieStore.get('globals') || {};
        $rootScope.showLoader = false;
        var userName = angular.element("#successUser").text(),
            errorText = angular.element("#erorUser").text()
        if (userName != "") {
            localStorage["userName"] = userName;
            $state.go("coreuser.candidate");
        }
        else{
          $state.go("login");  
        }
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }
        $rootScope.$on('$stateNotFound', function (event, unfoundState, fromState, fromParams) {

        });

        $rootScope.$on('moduleRunLoaded', function (e) {

        });

        $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
        });

        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
            $rootScope.addPage = (toState.name == "coreuser.candidate.add" ||
                                  toState.name == "coreuser.employee.add" ||
                                  toState.name == "coreuser.candidate.edit" ||
                                  toState.name == "coreuser.employee.edit") ? true : false;
        });
    };
    angular.module('coreModule')
            .run(Core_Run);
})();
