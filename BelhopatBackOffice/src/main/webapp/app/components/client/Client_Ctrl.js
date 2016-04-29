(function () {
    var Client_Ctrl = function ($scope, $state, $rootScope, Core_Service) {
        var vm = this;
        $rootScope.active = 'client';
        
         };

    Client_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service'];
    angular.module('coreModule')
            .controller('Client_Ctrl', Client_Ctrl);
})();