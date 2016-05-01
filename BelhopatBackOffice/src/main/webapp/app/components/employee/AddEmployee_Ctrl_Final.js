(function () {
    var AddEmployee_Ctrl_Final = function ($scope, $state, $rootScope, Core_Service,urlConfig, $stateParams, Core_HttpRequest, validationService) {
        var vm = this;
        $rootScope.showLoader = true;
        vm.registration = {};
        if ($stateParams.id) {
            Core_Service.getCandidateImpl("api/employee/getAnEmployee", $stateParams.id).then(function (res) {
                vm.registration = res.data;               
                vm.isCheckboxEnable = true;
                vm.isChecked = true;
                $rootScope.showLoader = false;
            }, function (err) {
                vm.registration = {};
            });
        }
        vm.urlForLookups = "api/employee/getEmployeeDropdowns";
        Core_Service.getAllLookupValues(vm.urlForLookups)
                .then(function (response) {
                    vm.lookups = response.data;
                    console.log(vm.lookups);	
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
        vm.addEmployeeNextStep=function(candidateId){
        	
        	$scope.candidateId=candidateId;
        	$state.go('coreuser.employee.nextStep', {id: $rootScope.id});
        	 Core_Service.getCandidateImpl("api/employee/getAnEmployee", $stateParams.id).then(function (res) {
                 vm.registration = res.data;               
                 vm.isCheckboxEnable = true;
                 vm.isChecked = true;
                 $rootScope.showLoader = false;
             }, function (err) {
                 vm.registration = {};
             });
        }
        $scope.candidateId=$rootScope.id;
        Core_Service.calculateSidebarHeight();
        $rootScope.showLoader = false;
    };

    AddEmployee_Ctrl_Final.$inject = ["$scope", '$state', '$rootScope', 'Core_Service','urlConfig', '$stateParams', 'Core_HttpRequest', 'validationService'];
    angular.module('coreModule')
            .controller('AddEmployee_Ctrl_Final', AddEmployee_Ctrl_Final);
})();




