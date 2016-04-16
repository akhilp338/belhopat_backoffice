(function () {
    var ViewCandidate_Ctrl = function ($scope, $uibModalInstance, CANDIDATE, $timeout, candidateDetails) {
        var vm = this,
            fields = CANDIDATE.fieldMapping;        
            vm.template = "<div class = 'candidate-details-wrapper'>"
            for(var key in candidateDetails){
            	if(candidateDetails[key]==undefined&&candidateDetails[key]==null||key=='bankAccount'||
            			key=='passport'||key=='officialDetails'){
                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
                    +'-'+"</span></div>"; 
            	}else if(key=='createdBy'||key=='updatedBy'||key=='deletedBy'){
                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
                    +candidateDetails[key].username+"</span></div>"; 
            	}else if(key=='dob'||key=='doj'){
                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
                    +new Date(candidateDetails[key])+"</span></div>"; 
            	}else if(key=='bloodGroup'||key=='countryOfOrigin'||key=='countryToVisit'||key=='division'
            			||key=='designation'||key=='purpose'||key=='employmentStatus'){
                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
                    +candidateDetails[key].description+"</span></div>"; 
            	}else if(key=='currentAddress'||key=='permanentAddress'||key=='onsiteAddress'){
                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
                    +candidateDetails[key].address1+','+candidateDetails[key].address2+"</span></div>"; 
            	}else{
                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
                    +candidateDetails[key]+"</span></div>"; 
            	}
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