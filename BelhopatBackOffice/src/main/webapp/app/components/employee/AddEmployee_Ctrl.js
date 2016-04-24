(function () {
    var AddEmployee_Ctrl = function ($scope, $state, $rootScope, Core_Service, $stateParams, Core_HttpRequest, validationService) {
        var vm = this;
        $rootScope.showLoader = true;
      
        vm.registration = {}
        vm.urlForLookups = "api/employee/getDropDownData";
        Core_Service.getAllLookupValues(vm.urlForLookups)
                .then(function (response) {
                    vm.lookups = response.data;
                }, function (error) {

                });

        $rootScope.active = 'employee';
        vm.cancelRegisteration = function (){
            $state.go("coreuser.employee")
        };
        vm.employeeRegister = function () {
            vm.registerUrl = "api/employee/saveOrUpdateEmployee";
            Core_Service.registerImpl(vm.registerUrl, vm.registration)
                    .then(function (response) {
                    }, function (error) {

                    });
        };
        Core_Service.calculateSidebarHeight();
        $rootScope.showLoader = false;
    };

    AddEmployee_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service', '$stateParams', 'Core_HttpRequest', 'validationService'];
    angular.module('coreModule')
            .controller('AddEmployee_Ctrl', AddEmployee_Ctrl);
})();




