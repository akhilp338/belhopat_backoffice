<!DOCTYPE html>
<html ng-app="coreModule" class="theme3">
<head>
<link rel="shortcut icon" href="app/assets/images/B-Icon.ico">
<title>Belhopat Global Services Pvt Ltd</title>
<link rel="stylesheet" ng-href="app/assets/libs/css/bootstrap.min.css">
<link rel="stylesheet" ng-href="app/assets/libs/css/font-awesome.min.css">
<link rel="stylesheet" ng-href="app/assets/libs/css/awesome-checkbox.css">
<link rel="stylesheet" ng-href="app/assets/libs/css/sweetalert.css">
<link rel="stylesheet" ng-href="app/assets/styles/style.css">
<link rel="stylesheet" ng-href="app/assets/libs/css/jquery.dataTables.min.css">
	<!-- Libraries -->
<script src="app/assets/libs/js/jquery-2.2.3.min.js"></script>
<script src="app/assets/libs/js/angular.min.js"></script>
<script src="app/assets/libs/js/angular-ui-router.js"></script>
<script src="app/assets/libs/js/angular-cookies.js"></script>
<script src="app/assets/libs/js/ngstorage.js"></script>
<script src="app/assets/libs/js/jquery.dataTables.min.js"></script>
<!-- <script src="app/assets/libs/js/angular.min.js"></script> -->
<script src="app/assets/libs/js/underscore.js"></script>
<script src="app/assets/libs/js/ui-bootstrap-tpls-1.3.1.min.js"></script>
<script src="app/assets/libs/js/sweetalert.js"></script>
<script src="app/assets/libs/js/sweet-alert.js"></script>
<script src="app/assets/libs/js/angular-animate.min.js"></script>
<script src="app/assets/libs/js/angular-ui-router.js"></script>
<script src="app/assets/libs/js/angular-translate.min.js"></script>
<script src="app/assets/libs/js/angular-translate-loader-static-files.min.js"></script>
<script src="app/assets/libs/js/angular-validation.min.js"></script>
<script src="app/assets/libs/js/jquery.spring-friendly.min.js"></script>


<!-- AngularJS custom codes -->

<script src="app/app.module.js"></script>
<script src="app/app.route.js"></script>
<script src="app/shared/encode-util.js"></script>
<script src="app/run.js"></script>
<script src="app/shared/appConstants.js"></script>
<script src="app/shared/HttpRequest.js"></script>
<script src="app/shared/CoreService.js"></script>
<script src="app/shared/Core_Modal.js"></script>
<script src="app/shared/CommonModalService.js"></script>
<script src="app/components/common/directives.js"></script>
<script src="app/components/login/LoginCtrl.js"></script>
<script src="app/components/login/Forgotpassword_Ctrl.js"></script>
<script src="app/components/common/Header_Ctrl.js"></script>
<script src="app/components/home/Home_Ctrl.js"></script>
<script src="app/components/dashboard/Dash_Ctrl.js"></script>
<script src="app/components/candidate/Candidate_Ctrl.js"></script>
<script src="app/components/candidate/AddCandidate_Ctrl.js"></script>
<script src="app/components/candidate/ViewCandidate_Ctrl.js"></script>
<script src="app/components/candidate/DeleteCandidate_Ctrl.js"></script>
<script src="app/components/employee/Employee_Ctrl.js"></script>
<script src="app/components/client/Client_Ctrl.js"></script>
<script src="app/components/holiday/Holiday_Ctrl.js"></script>
<script src="app/components/opportunity/Opp_Ctrl.js"></script>
<script src="app/components/candidate/ViewCandidate_Ctrl.js"></script>

<style>
[ng:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
display: none !important;
}
</style>
</head>

<body ng-class="{'login-page':isLogin}" ng-cloak>
    <div id="errorUser">${error}</div>
     <div id="successUser">${user}</div>
    <header ui-view="header" class="header-div"></header>
    <div ui-view="sidebar" class="page-side-bar"></div>
    <div ui-view="content" class="page-content-div" ng-class="{'add-candidate':addPage}"></div>
    <footer ui-view="footer" class="footer-div"></footer>
</html>
