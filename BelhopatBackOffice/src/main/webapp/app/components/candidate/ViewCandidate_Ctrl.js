(function () {
    var ViewCandidate_Ctrl = function ($scope, $uibModalInstance, validationService, $timeout, candidateDetails) {
        var vm = this;        
            vm.template = "<div class = 'candidate-details-wrapper'>"
            for(var key in candidateDetails){
                vm.template += "<span class = 'catagory'>"+key+" :</span><span class='cat-value'>"+candidateDetails[key]+"</span></br>"; 
            }
            vm.template += "</div>";
                vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
        $timeout(function(){
          document.querySelector(".view-modal .modal-body").innerHTML = vm.template;  
        },500)
        
    };
    ViewCandidate_Ctrl.$inject = ["$scope", '$uibModalInstance', 'validationService', '$timeout', 'candidateDetails'];
    angular.module('coreModule')
            .controller('ViewCandidate_Ctrl', ViewCandidate_Ctrl);
})();