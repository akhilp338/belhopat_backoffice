(function () {
    var AddCandidate_Ctrl = function ($scope, $state, $rootScope, Core_Service, $timeout, Core_HttpRequest, validationService) {
        var vm = this;
        vs = new validationService({
            controllerAs: vm
        });
        vm.mainSkillList = [{id: 1, skill: 'javascript'}, {id: 2, skill: 'java'}, {id: 3, skill: 'css'}, {id: 4, skill: 'c++'}, {id: 5, skill: 'c'}, {id: 6, skill: 'html'}, {id: 7, skill: 'cobol'}]
        vm.mainSelectedSkillList = [];
        vm.subSelectedSkillList = [];
        vm.deSelectedSkills = [];
        vm.confirmedSelectionItems = [];
        vm.registration = {};
        vs.setGlobalOptions({
            debounce: 1500,
            scope: $scope,
            isolatedScope: $scope,
            preValidateFormElements: false,
            displayOnlyLastErrorMsg: true
        });
        vm.addSkills = function () {
            vm.mainSelectedSkillList = vm.mainSelectedSkillList.concat(vm.subSelectedSkillList);
            vm.removeFromMainListArray(vm.getIndexesToRemove(vm.mainSkillList, vm.subSelectedSkillList));
        };
        vm.removeSkills = function () {
            vm.mainSkillList = vm.mainSkillList.concat(vm.deSelectedSkills);
            vm.removeFromSelectedListArray(vm.getIndexesToRemove(vm.mainSelectedSkillList, vm.deSelectedSkills));
        };

        vm.isCheckboxEnable = false;
        vm.urlForLookups = "api/candidate/getDropDownData";
        Core_Service.getAllLookupValues(vm.urlForLookups)
                .then(function (response) {
                    vm.lookups = response.data;
                }, function (error) {

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
            if (vm.registration.permanentAddress) {
                vm.registration.currentAddress = {};
                vm.isCheckboxEnable = true;
                for (var key in vm.registration.permanentAddress) {
                    vm.registration.currentAddress[key] = vm.registration.permanentAddress[key];
                }
            } else {
                vm.isCheckboxEnable = false;
            }
             if (!vm.isChecked) {
                 for(var key in vm.registration.currentAddress){
                     vm.registration.currentAddress[key] = "";
                 }
            }
        };

        vm.checkAddress = function () {            
                if (vm.registration.permanentAddress) {
                    for (var key in vm.registration.permanentAddress) {
                        if (vm.registration.permanentAddress[key] != "") {
                            vm.isCheckboxEnable = true;
                            return;
                        }
                    }
                    vm.isCheckboxEnable = false;
                }           
        };
        vm.addCandidate = function () {
            $state.go("coreuser.candidate.add");
        };

        vm.candidateRegister = function () {
            vm.registerUrl = "api/candidate/saveOrUpdateCandidate";
            Core_Service.candidateRegisterImpl(vm.registerUrl, vm.registration)
                    .then(function (response) {
                    }, function (error) {

                    });
        };
        vm.getIndexesToRemove = function (array, data) {
            var indexes = [];
            for (var i = 0; i < data.length; i++) {
                for (var j = 0; j < array.length; j++) {
                    if (data[i].id == array[j].id) {
                        indexes.push(j);
                    }
                }
            }
            return  indexes;
        };

        vm.removeFromSelectedListArray = function (indexes) {
            var selected = [];
            for (var i = indexes.length - 1; i >= 0; i--)
                vm.mainSelectedSkillList.splice(indexes[i], 1);
            vm.deSelectedSkills = [];
            for (var j = 0; j < vm.mainSelectedSkillList.length; j++) {
                selected.push(vm.mainSelectedSkillList[j].id)
            }
            vm.confirmedSelectionItems = selected;
        };
        vm.removeFromMainListArray = function (indexes) {
            var selected = [];
            for (var i = indexes.length - 1; i >= 0; i--)
                vm.mainSkillList.splice(indexes[i], 1);
            vm.subSelectedSkillList = [];
            for (var j = 0; j < vm.mainSelectedSkillList.length; j++) {
                selected.push(vm.mainSelectedSkillList[j].id)
            }
            vm.confirmedSelectionItems = selected;
        };
        //To Do(move these methods to base controller)
        vm.getStatesByCountry = function () {
            var countryId = vm.registration.currentAddress.city.state.country.id,
                    data = {"id": countryId};
            vm.apiUrl = "api/getStatesByCountry";
            vm.states = vm.defaultApiByIdAndUrl(data, vm.apiUrl);
        }
        vm.getCitiesByStates = function () {
            var stateId = vm.registration.currentAddress.city.state.id,
                    data = {"id": stateId};
            vm.apiUrl = "api/getCitiesByState";
            vm.cities = vm.defaultApiByIdAndUrl(data, vm.apiUrl)
        }

        vm.defaultApiByIdAndUrl = function (data, url) {
            Core_Service.defaultApiByIdAndUrlImpl(url, data)
                    .then(function (response) {
                        vm.states = response.data;
                    }, function (error) {
                    });
        }

        Core_Service.calculateSidebarHeight();
    };

    AddCandidate_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service', '$timeout', 'Core_HttpRequest', 'validationService'];
    angular.module('coreModule')
            .controller('AddCandidate_Ctrl', AddCandidate_Ctrl);
})();




