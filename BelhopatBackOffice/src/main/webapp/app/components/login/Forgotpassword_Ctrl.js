(function () {
    var Forgotpassword_Ctrl = function ($scope, $uibModalInstance, validationService) {
        var vm = this,
                vs = new validationService({
                    controllerAs: vm
                });
        vs.setGlobalOptions({
            debounce: 1500,
            scope: $scope,
            isolatedScope: $scope,
            preValidateFormElements: false,
            displayOnlyLastErrorMsg: true
        });
        vm.submit = function () {
            if (vs.checkFormValidity($scope)) {
                $uibModalInstance.close();
            }
        };
        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    };
    Forgotpassword_Ctrl.$inject = ["$scope", '$uibModalInstance', 'validationService'];
    angular.module('coreModule')
            .controller('Forgotpassword_Ctrl', Forgotpassword_Ctrl);
})();