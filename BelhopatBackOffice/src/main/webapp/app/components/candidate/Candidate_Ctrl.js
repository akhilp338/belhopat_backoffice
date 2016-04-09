(function () {
    var Candidate_Ctrl = function ($scope, $state, $rootScope, Core_Service, $timeout) {
        var vm = this;
        $rootScope.active = 'candidate';
    };

    Candidate_Ctrl.$inject = ["$scope", '$state', '$rootScope', 'Core_Service', '$timeout'];
    angular.module('coreModule')
            .controller('Candidate_Ctrl', Candidate_Ctrl);
})();


