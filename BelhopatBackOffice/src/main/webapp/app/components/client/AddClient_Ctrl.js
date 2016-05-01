(function () {
    var AddClient_Ctrl = function ($scope, $state, $rootScope, Core_Service, $stateParams, Core_HttpRequest, validationService) {
        var vm = this;
        $rootScope.showLoader = true;
        vm.registration = {};
//        if ($stateParams.id) {
//            Core_Service.getClientImpl("api/client/getClient", $stateParams.id).then(function (res) {
//                vm.registration = res.data;               
//                vm.isCheckboxEnable = true;
//                vm.isChecked = true;
//                $rootScope.showLoader = false;
//            }, function (err) {
//                vm.registration = {};
//            });
//        }
//        vm.urlForLookups = "api/client/getDropDownData";
//        Core_Service.getAllLookupValues(vm.urlForLookups)
//                .then(function (response) {
//                    vm.lookups = response.data;
//                }, function (error) {
//
//                });

        $rootScope.active = 'client';
//        vm.cancelRegisteration = function (){
//            $state.go("coreuser.client")
//        };
//        vm.addClient = function () {
//            $state.go("coreuser.client.add");
//        };
//        vm.clientRegister = function () {
//            vm.registerUrl = "api/client/saveOrUpdateClient";
//            Core_Service.registerImpl(vm.registerUrl, vm.registration)
//                    .then(function (response) {
//                    }, function (error) {
//
//                    });
//        };
        Core_Service.calculateSidebarHeight();
        $rootScope.showLoader = false;
    };

    AddClient_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service', '$stateParams', 'Core_HttpRequest', 'validationService'];
    angular.module('coreModule')
            .controller('AddClient_Ctrl', AddClient_Ctrl);
})();