(function () {
    'use strict';
    angular.module('app.common', []);
    angular.module('app.constants', []);
    angular.module('coreModule', ['ui.router','ui.bootstrap','app.constants','app.common']);
})();
