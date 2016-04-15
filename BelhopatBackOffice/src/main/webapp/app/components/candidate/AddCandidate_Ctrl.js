(function () {
    var AddCandidate_Ctrl = function ($scope, $state, $rootScope, Core_Service, $timeout, Core_HttpRequest, validationService) {
        var vm = this;
                vs = new validationService({
                    controllerAs: vm
                });

        vm.registration = {};
        vs.setGlobalOptions({
            debounce: 1500,
            scope: $scope,
            isolatedScope: $scope,
            preValidateFormElements: false,
            displayOnlyLastErrorMsg: true
        });

          vm.isCheckboxEnable = false;
          vm.urlForLookups = "api/candidate/getDropDownData";
       Core_Service.getAllLookupValues(vm.urlForLookups)
        .then( function(response) {
           console.log(response)
           vm.lookups = response.data;
        },function(error){
        	
        });
        
        $scope.steps = [
            'Step 1: Personal Information',
            'Step 2: Employment Details',
            'Step 3: Official Information',
            'Step 4: Family Details'
        ];
        $scope.selection = $scope.steps[0];
        $scope.getCurrentStepIndex = function () {
            return _.indexOf($scope.steps, $scope.selection);
        };

        // Go to a defined step index
        $scope.goToStep = function (index) {
            if (!_.isUndefined($scope.steps[index]))
            {
                $scope.selection = $scope.steps[index];
            }
            Core_Service.calculateSidebarHeight();
        };

        $scope.hasNextStep = function () {
            var stepIndex = $scope.getCurrentStepIndex();
            var nextStep = stepIndex + 1;
            // Return true if there is a next step, false if not
            return !_.isUndefined($scope.steps[nextStep]);
        };

        $scope.hasPreviousStep = function () {
            var stepIndex = $scope.getCurrentStepIndex();
            var previousStep = stepIndex - 1;
            // Return true if there is a next step, false if not
            return !_.isUndefined($scope.steps[previousStep]);
        };

        $scope.incrementStep = function () {
            var stepIndex = $scope.getCurrentStepIndex();
            //vs.checkFormValidity($scope)
            if ($scope.hasNextStep())
            {
                var nextStep = stepIndex + 1;
                $scope.selection = $scope.steps[nextStep];
            }
            Core_Service.calculateSidebarHeight();
        };

        $scope.decrementStep = function () {
            if ($scope.hasPreviousStep())
            {
                var stepIndex = $scope.getCurrentStepIndex();
                var previousStep = stepIndex - 1;
                $scope.selection = $scope.steps[previousStep];
            }
            Core_Service.calculateSidebarHeight();
        };
       
        $rootScope.active = 'candidate';
        vm.copyAddress = function () {
            console.log(vm.registration.permenant)
            if (vm.registration.permenant) {
                vm.registration.current = {};
                vm.isCheckboxEnable = true;
                for (var key in vm.registration.permenant) {
                    vm.registration.current[key] = vm.registration.permenant[key];
                }
            } else {
                vm.isCheckboxEnable = false;
            }
        };

        vm.checkAddress = function () {
            if (vm.registration.permenant) {
                for (var key in vm.registration.permenant) {
                    if (vm.registration.permenant[key] != "") {
                        vm.isCheckboxEnable = true;
                        return;
                    }
                }
                vm.isCheckboxEnable = false;
            }
        };
        vm.addCandidate = function(){
            $state.go("coreuser.candidate.add");
        };
        
        vm.candidateRegister = function(){
        	console.log(vm.registration);
        	vm.registerUrl = "api/candidate/saveOrUpdateCandidate";
            Core_Service.candidateRegisterImpl(vm.urlForRegister,vm.registration)
            .then( function(response) {
               console.log(response)
            },function(error){
            	
            });
        };
        
        Core_Service.calculateSidebarHeight();
    };
    
    AddCandidate_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service', '$timeout', 'Core_HttpRequest', 'validationService'];
    angular.module('coreModule')
            .controller('AddCandidate_Ctrl', AddCandidate_Ctrl);
})();




