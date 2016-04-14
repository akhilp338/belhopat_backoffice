(function () {
    var Employee_Ctrl = function ($scope, $state, $rootScope, Core_Service) {
        var vm = this;
        $rootScope.active = 'employee';
        Core_Service.calculetSidebarHeight();
         };

    Employee_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service'];
    angular.module('coreModule')
            .controller('Employee_Ctrl', Employee_Ctrl);
})();

