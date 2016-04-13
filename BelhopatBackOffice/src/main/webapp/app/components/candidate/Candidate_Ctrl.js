(function () {
    var Candidate_Ctrl = function ($scope, $state, $rootScope, Core_Service, urlConfig, Core_HttpRequest, validationService) {
        var vm = this,
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
        $scope.steps = [
            'Step 1: Personal Information',
            'Step 2: Employment Details',
            'Step 3: Official Information',
            'Step 4: Family Details'
        ];
        $scope.selection = $scope.steps[0];

        $scope.getCurrentStepIndex = function () {
            // Get the index of the current step given selection
            return _.indexOf($scope.steps, $scope.selection);
        };

        // Go to a defined step index
        $scope.goToStep = function (index) {
            if (!_.isUndefined($scope.steps[index]))
            {
                $scope.selection = $scope.steps[index];
            }
            Core_Service.calculetSidebarHeight();
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
            vs.checkFormValidity($scope)
            if ($scope.hasNextStep())
            {
                var nextStep = stepIndex + 1;
                $scope.selection = $scope.steps[nextStep];
            }
            Core_Service.calculetSidebarHeight();
        };

        $scope.decrementStep = function () {
            if ($scope.hasPreviousStep())
            {
                var stepIndex = $scope.getCurrentStepIndex();
                var previousStep = stepIndex - 1;
                $scope.selection = $scope.steps[previousStep];
            }
            Core_Service.calculetSidebarHeight();
        };

        $rootScope.active = 'candidate';
        vm.toggler = function () {
            $('#pro_expander').toggle();
        };

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

//datatble start
        angular.element(document).ready(function () {
            angular.element('#candidatesList').DataTable({
            	'ajax': urlConfig.http+window.location.host+urlConfig.api_root_path+"/getOfficialDetails",
                'serverSide': true,
                "bDestroy": true,
//                "order": [[ 1, "asc" ]],
                "language": {
                    zeroRecords: "No data to dispay"
                },
                 "processing": true,
                 "sScrollX": '100%',
                "aoColumns": [{
                	title: "drivingLicenceNo",
                    data: 'drivingLicenceNo',
                }, {
                	title: "PAN No",
                    data: 'panno',
                }, {
                	title: "ESI No",
                    data: 'esino',
                }, {
                	title: "PF No",
                    data: 'pfno',
                }, {
                	title: "FOREX CARD NO",
                    data: 'forexCardNo',
                }, {
                	title: "FOREX CARD AGENCY",
                    data: 'forexCardAgency',
                }]
            });
        });
        //datatble ends
        Core_Service.calculetSidebarHeight();
    };

    Candidate_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service', 'urlConfig', 'Core_HttpRequest', 'validationService'];
    angular.module('coreModule')
            .controller('Candidate_Ctrl', Candidate_Ctrl);
})();


