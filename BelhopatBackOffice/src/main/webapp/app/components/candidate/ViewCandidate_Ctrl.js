(function () {
    var ViewCandidate_Ctrl = function ($scope, $uibModalInstance, CANDIDATE, $timeout, candidateDetails) {
        var vm = this,
            fields = CANDIDATE.fieldMapping;        
            vm.template = "<div class = 'candidate-details-wrapper'>"
            for(var key in candidateDetails){
                vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
                +candidateDetails[key]+"</span></div>"; 
            }
            vm.template += "</div>";
                vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
        
    };
    ViewCandidate_Ctrl.$inject = ["$scope", '$uibModalInstance', 'CANDIDATE', '$timeout', 'candidateDetails'];
    angular.module('coreModule')
            .controller('ViewCandidate_Ctrl', ViewCandidate_Ctrl);
})();