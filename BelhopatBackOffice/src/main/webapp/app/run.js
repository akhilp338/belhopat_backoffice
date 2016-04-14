(function () {
    'use strict';
    var Core_Run = function ($rootScope, $state, $window, $location, $interval, $http, $uibModalStack, $document, Core_Service) {
        $rootScope.$on('$stateNotFound',
            function(event, unfoundState, fromState, fromParams){
                
            });

        $rootScope.$on('moduleRunLoaded', function(e) {

        });        

        $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {

        });

        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) { 
           $rootScope.addPage = toState.name == "coreuser.candidate.add" ?  true : false; 
           Core_Service.calculetSidebarHeight(1000)
           Core_Service.calculetSidebarHeight(1500)
        });
    };
    angular.module('coreModule')
        .run(Core_Run);
})();
