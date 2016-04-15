(function () {
    var Header_Ctrl = function ($scope, $state, $rootScope, Core_Service) {
        var vm = this;
        vm.username = "arun"
        vm.logout = function(){
        	Core_Service.ClearCredentials();
        	$state.go('login');
        }
		vm.getTheme = function(){
			angular.element("html").attr("class",vm.checkedValue);
		};
        vm.getUserName = localStorage["userName"];
    };
    Header_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service'];
    angular.module('coreModule')
            .controller('Header_Ctrl', Header_Ctrl);
})();


