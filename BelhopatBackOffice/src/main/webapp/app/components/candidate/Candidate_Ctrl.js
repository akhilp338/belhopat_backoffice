(function () {
    var Candidate_Ctrl = function ($scope, $state, $rootScope, Core_Service, $timeout, urlConfig, Core_HttpRequest,candidate_table) {
        var vm = this;
        $rootScope.active = 'candidate';
        vm.ii = function(){
        	console.log(candidate_table.config)
        	console.log(urlConfig.http + window.location.host + urlConfig.api_root_path + '/getCandidate')
        }
        vm.toggler = function(){
        	$('#pro_expander').toggle();
        }
        //datatble start
        $(document).ready(function() {
            $('#candidatesList').DataTable({});
        } );
        //datatble ends
    };

    Candidate_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service', '$timeout', 'urlConfig', 'Core_HttpRequest','candidate_table'];
    angular.module('coreModule')
            .controller('Candidate_Ctrl', Candidate_Ctrl);
})();


