(function () {
    'use strict';
    angular.module('app.constants')
            .constant('urlConfig', {
                "http": "http://",
                "api_endpoint": "/BelhopatBackOffice/app/assets/data/",
                "root_path": "/BelhopatBackOffice/",
                "api_root_path": "/BelhopatBackOffice/api/"
            })
            .constant('CANDIDATE', {
                "fieldMapping": {
                    "id": "ID",
                    "drivingLicenceNo": "Driving Liscence No.",
                    "forexCardNo": "Forex Card No.",
                    "forexCardAgency": "Forex Card Agency",
                    "panno": "PAN No.",
                    "esino": "ESI No.",
                    "pfno": "PF No."
                }
            });
    ;
})();
