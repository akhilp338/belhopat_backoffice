(function () {
    var Header_Ctrl = function ($scope, $state, $rootScope, Core_Service) {
        var vm = this;
        vm.username = "arun";
        vm.getTheme = function(){
            angular.element("html").attr("class",vm.checkedValue);
        };
        vm.logout = function(){
           $state.go("login"); 
        };
    };
    Header_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service'];
    angular.module('coreModule')
            .controller('Header_Ctrl', Header_Ctrl);
})();


