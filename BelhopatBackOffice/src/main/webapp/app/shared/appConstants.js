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
            "config": {'ajax': "/getOfficialDetails",
                'serverSide': true,
                "responsive": true,
                "bDestroy": true,
                "order": [[ 13, "asc" ]],
                "language": {
                    zeroRecords: "No data to dispay"
                },
                 "processing": true,
                 "sScrollX": '100%',
                "aoColumns": [{
                    data: 'id',
                    "title": "<input type='checkbox' name='offer-id-title' class='select_all_check'>",
                    "bSortable": false,
                    "render": function(data) {
                        return "<input class='offer_checkbox' type='checkbox' name='offer-id' value='" + data + "'>"
                    }
                }, {
                	title: "offerId",
                    data: 'offerId',
                    sClass: 'align-center'
                }, {
                	title: "offerId",
                    data: 'offerMaster.commodity.metal.metal',
                    sClass: 'align-center'
                }, {
                	title: "offerId",
                    data: 'offerMaster.commodity.metal.inventory',
                    sClass: 'align-center'
                }, {
                	title: "offerId",
                    data: 'offerMaster.commodity.commodityBrand.code',
                    sClass: 'align-center'
                }, {
                	title: "offerId",
                    data: 'offerMaster.commodity.commodityType.code',
                    sClass: 'align-center'
                }, {
                	title: "offerId",
                    data: 'offerMaster.commodity.metal.purity',
                    sClass: 'align-right'
                }],
				"fnCreatedRow" : function(nRow, aData, iDataIndex) {
					$(nRow)[0].id = iDataIndex;
				}
            }
        });;
})();
