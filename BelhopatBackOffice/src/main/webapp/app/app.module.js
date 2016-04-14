(function () {
    'use strict';
    angular.module('app.common', []);
    angular.module('app.constants', []);
    angular.module('coreModule', ['ui.router','ui.bootstrap','app.constants','app.common','ngCookies'])
    .run(['$rootScope', '$state', '$cookieStore', '$http',
          function ($rootScope, $state, $cookieStore, $http) {
              $rootScope.globals = $cookieStore.get('globals') || {};
              if ($rootScope.globals.currentUser) {
                  $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; 
              }
        
              $rootScope.$on('$stateChangeStart', function (event,toState  , toParams
                      , fromState, fromParams) {
            	  var isLogin = toState.name === "login";
                  if(isLogin){
                     return; 
                  }

            	   if ($state.current.name !== 'login' && !$rootScope.globals.currentUser) {
                	  event.preventDefault();
                	  $state.transitionTo('login');	
                  }
              });
          }]);
    window.app = angular.module('coreModule', [
        'ui.router',
        'ngAnimate',
        'ui.bootstrap',
        'app.constants',
        'app.common',
        'pascalprecht.translate',
        'ghiscoding.validation',
        'oitozero.ngSweetAlert'
    ]);
    window.app.config(['$locationProvider', function ($locationProvider) {
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        }]);

})();
