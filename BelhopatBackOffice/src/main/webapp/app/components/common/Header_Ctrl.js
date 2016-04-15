(function () {
    var Header_Ctrl = function ($scope, $state, $rootScope, Core_Service) {
        var vm = this;
        vm.username = "arun"
        vm.init =function(){
        	vm.userName=vm.getUserName();
        }
        vm.logout = function(){
        	Core_Service.ClearCredentials();
        	$state.go('login');
        }
		vm.getTheme = function(){
			angular.element("html").attr("class",vm.checkedValue);
		};
        vm.getUserName = function(){
        	var userName=Core_Service.getUserName();
        	return userName;
        }
    };
    Header_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service'];
    angular.module('coreModule')
            .controller('Header_Ctrl', Header_Ctrl);
})();


