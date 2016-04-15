(function () {
    'use strict';
    var Core_Run = function ($rootScope, $state, $cookieStore, $window, $location, Core_Service, $http) {
    	$rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; 
        }
    	$rootScope.$on('$stateNotFound',function(event, unfoundState, fromState, fromParams){
                
            });

        $rootScope.$on('moduleRunLoaded', function(e) {

        });        

        $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
        	var isLogin = toState.name === "login";
            if(isLogin){
               return; 
            }

      	   if ($state.current.name !== 'login' && !$rootScope.globals.currentUser) {
          	  event.preventDefault();
          	  $state.transitionTo('login');	
            }
        });

        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) { 
           $rootScope.addPage = (toState.name == "coreuser.candidate.add" || toState.name == "coreuser.candidate.edit") ?  true : false; 
           Core_Service.calculateSidebarHeight(1000)
           Core_Service.calculateSidebarHeight(1500)
        });
    };
    angular.module('coreModule')
        .run(Core_Run);
})();
