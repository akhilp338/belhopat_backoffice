(function () {
    'use strict';
    angular.module('app.constants')
        .constant('urlConfig', {
        	"http":"http://",
            "api_endpoint": "/BelhopatBackOffice/app/assets/data/",
            "root_path":"/BelhopatBackOffice/",
            "api_root_path":"/BelhopatBackOffice/api/candidate"
        })
        .constant('candidate_table', {
            "config": {
            	"bSortable":true
            }
        });;
})();
