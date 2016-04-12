(function () {
    'use strict';
    angular.module('app.common', []);
    angular.module('app.constants', []);
    angular.module('coreModule', ['ui.router','ui.bootstrap','app.constants','app.common','$cookieStore'])
    .run(['$rootScope', '$state', '$cookieStore', '$http',
          function ($rootScope, $state, $cookieStore, $http) {
              // keep user logged in after page refresh
              $rootScope.globals = $cookieStore.get('globals') || {};
              if ($rootScope.globals.currentUser) {
                  $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
              }
        
              $rootScope.$on('$stateChangeStart', function (event, next, current) {
                  // redirect to login page if not logged in
                  if ($state.current !== 'login' && !$rootScope.globals.currentUser) {
                	  event.preventDefault();
                	  $state.go('login');
                  }
              });
          }]);
})();
