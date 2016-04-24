(function () {
    var AddCandidate_Ctrl = function ($scope, $state, $rootScope, Core_Service, $stateParams, Core_HttpRequest, validationService) {
        var vm = this;
        $rootScope.showLoader = true;
        Core_Service.getCandidateImpl("api/candidate/getCandidate",$stateParams.id).then(function(res){
            vm.registration = res.data;
            $rootScope.showLoader = false;
        },function(err){
           vm.registration = {};
           $rootScope.showLoader = false;
        });
        if(!$stateParams.id)
            vm.registration = {}
        vs = new validationService({
            controllerAs: vm
        });
        vm.mainSkillList = [{id: 1, skill: 'javascript'}, {id: 2, skill: 'java'}, {id: 3, skill: 'css'}, {id: 4, skill: 'c++'}, {id: 5, skill: 'c'}, {id: 6, skill: 'html'}, {id: 7, skill: 'cobol'}]
        vm.mainSelectedSkillList = [];
        vm.subSelectedSkillList = [];
        vm.deSelectedSkills = [];
        vm.confirmedSelectionItems = [];
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
            if (!_.isUndefined($scope.steps[index])) {
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
        vm.copyAddress = function ($event) {
            if (vm.registration.permanentAddress) {
            	var _this = $event.target;
                vm.registration.currentAddress = {};
                vm.isCheckboxEnable = true;
                for (var key in vm.registration.permanentAddress) {
                    vm.registration.currentAddress[key] = vm.registration.permanentAddress[key];
                }
//                angular.element('.permntCountry').triggerHandler('change');//temp
                vm.statesCurnt = vm.statesPerm;
                vm.citiesCurnt =vm.citiesPerm;
            } else {
                vm.isCheckboxEnable = false;
            }
             if (!vm.isChecked) {
                 for(var key in vm.registration.currentAddress){
                     vm.registration.currentAddress[key] = "";
                 }
                 vm.statesCurnt = [];
                 vm.citiesCurnt =[];
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
            if(vs.checkFormValidity($scope["regForm"])){
            vm.registerUrl = "api/candidate/saveOrUpdateCandidate";
            Core_Service.candidateRegisterImpl(vm.registerUrl, vm.registration)
                    .then(function (response) {
                    }, function (error) {

                    });
        }
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
        vm.getStatesByCountryPerm = function(countryId){
        	var data = {"id":countryId};
        	vm.apiUrl = "api/getStatesByCountry";
            Core_Service.defaultApiByIdAndUrlImpl(vm.apiUrl,data)
            .then( function(response) {
            	vm.statesPerm =  response.data;
            },function(error){
            	console.log('theng...')
            });
        }
        vm.getCitiesByStatesPerm = function(stateId){
        	var data = {"id":stateId};
        	vm.apiUrl = "api/getCitiesByState";
            Core_Service.defaultApiByIdAndUrlImpl(vm.apiUrl,data)
            .then( function(response) {
            	vm.citiesPerm =  response.data;
            },function(error){
            	console.log('theng...')
            });
        }
        vm.getStatesByCountryCurnt = function(countryId){
        	var data = {"id":countryId};
        	vm.apiUrl = "api/getStatesByCountry";
            Core_Service.defaultApiByIdAndUrlImpl(vm.apiUrl,data)
            .then( function(response) {
            	vm.statesCurnt =  response.data;
            },function(error){
            	console.log('theng...')
            });
        }
        vm.getCitiesByStatesCurnt = function(stateId){
        	var data = {"id":stateId};
        	vm.apiUrl = "api/getCitiesByState";
            Core_Service.defaultApiByIdAndUrlImpl(vm.apiUrl,data)
            .then( function(response) {
            	vm.citiesCurnt =  response.data;
//            	angular.element('.permntState').triggerHandler('change');//temp
            },function(error){
            	console.log('theng...')
            });
        }        
        vm.getStatesByCountryOnsite = function(countryId){
        	var data = {"id":countryId};
        	vm.apiUrl = "api/getStatesByCountry";
            Core_Service.defaultApiByIdAndUrlImpl(vm.apiUrl,data)
            .then( function(response) {
            	vm.statesOnsite =  response.data;
            },function(error){
            	console.log('theng...')
            });
        }
        vm.getCitiesByStatesOnsite = function(stateId){
        	var data = {"id":stateId};
        	vm.apiUrl = "api/getCitiesByState";
            Core_Service.defaultApiByIdAndUrlImpl(vm.apiUrl,data)
            .then( function(response) {
            	vm.citiesOnsite =  response.data;
            },function(error){
            	console.log('theng...')
            });
        }      
        vm.getStatesByCountryBank = function(countryId){
        	var data = {"id":countryId};
        	vm.apiUrl = "api/getStatesByCountry";
            Core_Service.defaultApiByIdAndUrlImpl(vm.apiUrl,data)
            .then( function(response) {
            	vm.statesBank =  response.data;
            },function(error){
            	console.log('theng...')
            });
        }
        vm.getCitiesByStatesBank = function(stateId){
        	var data = {"id":stateId};
        	vm.apiUrl = "api/getCitiesByState";
            Core_Service.defaultApiByIdAndUrlImpl(vm.apiUrl,data)
            .then( function(response) {
            	vm.citiesBank =  response.data;
            },function(error){
            });
        };
        
//        $('#defaultPopup').datepick(); 
        
        Core_Service.calculateSidebarHeight();
        $rootScope.showLoader = false;
    };

    AddCandidate_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service', '$stateParams', 'Core_HttpRequest', 'validationService'];
    angular.module('coreModule')
            .controller('AddCandidate_Ctrl', AddCandidate_Ctrl);
})();




