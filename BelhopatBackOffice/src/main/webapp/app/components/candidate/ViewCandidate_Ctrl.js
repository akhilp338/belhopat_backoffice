(function () {
    var ViewCandidate_Ctrl = function ($scope, $uibModalInstance, CANDIDATE, $timeout, candidateDetails) {
        var vm = this,
                fields = CANDIDATE.fieldMapping;
        vm.template = "<div class = 'candidate-details-wrapper'>"
        var array = [];
        vm.getFormattedDate = function (intDate) {
            var date = new Date(intDate * 1000);
            var datevalues = ('0' + date.getDate()).slice(-2) +
                    '-' + ('0' + (date.getMonth() + 1)).slice(-2) +
                    '-' + date.getFullYear();
            return datevalues;
        };
        for (var key in candidateDetails) {
            console.log(typeof (candidateDetails[key]))
            if (candidateDetails[key] == undefined && candidateDetails[key] == null) {
                vm.template += "<div class='cat-row'><span class = 'catagory'>" + fields[key] + " </span><span class='cat-value'>"
                        + '-' + "</span></div>";
            }
//            	else if(key=='createdBy'||key=='updatedBy'||key=='deletedBy'){
//                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
//                    +candidateDetails[key].username+"</span></div>"; 
//            	}
            else if (key == 'dob' || key == 'doj') {
                vm.template += "<div class='cat-row'><span class = 'catagory'>" + key + " </span><span class='cat-value'>"
                        + vm.getFormattedDate(candidateDetails[key]) + "</span></div>";
//            	}else if(key=='bloodGroup'||key=='countryOfOrigin'||key=='countryToVisit'||key=='division'
//            			||key=='designation'||key=='purpose'||key=='employmentStatus'){
//                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
//                    +candidateDetails[key].description+"</span></div>"; 
//            	}else if(key=='currentAddress'||key=='permanentAddress'||key=='onsiteAddress'){
//                    vm.template += "<div class='cat-row'><span class = 'catagory'>"+key+" </span><span class='cat-value'>"
//                    +candidateDetails[key].address1+','+candidateDetails[key].address2+"</span></div>"; 
            } else {
                vm.template += "<div class='cat-row'><span class = 'catagory'>" + fields[key] + " </span><span class='cat-value'>"
                        + candidateDetails[key] + "</span></div>";
            }
        }
        vm.template += "</div>";
        vm.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
        vm.close = function () {
            $uibModalInstance.dismiss('cancel');
        };


    };
    ViewCandidate_Ctrl.$inject = ["$scope", '$uibModalInstance', 'CANDIDATE', '$timeout', 'candidateDetails'];
    angular.module('coreModule')
            .controller('ViewCandidate_Ctrl', ViewCandidate_Ctrl);
})();