(function () {
    'use strict';
    angular.module('app.common', []);
    angular.module('app.constants', []);
    window.app = angular.module('coreModule', [
        'ui.router',
        'ngAnimate',
        'ui.bootstrap',
        'app.constants',
        'app.common',
        'pascalprecht.translate',
        'ghiscoding.validation',
        'oitozero.ngSweetAlert',
        'ngCookies',
        'ngStorage'
    ]);
    window.app.config(['$locationProvider', function ($locationProvider) {
            $locationProvider.html5Mode({
                enabled: true,
                requireBase: false
            });
        }]);

})();
