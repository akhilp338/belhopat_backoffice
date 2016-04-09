<!DOCTYPE html>
<html ng-app="coreModule">
<head>
<link rel="shortcut icon" href="app/assets/images/B-Icon.ico">
<title>Belhopat Global Services Pvt Ltd</title>
<link rel="stylesheet" ng-href="app/assets/libs/css/bootstrap.min.css">
<link rel="stylesheet" ng-href="app/assets/libs/css/font-awesome.min.css">
<link rel="stylesheet" ng-href="app/assets/styles/style.css">
	<!-- Libraries -->
        <script src="app/assets/libs/js/jquery-2.2.3.min.js"></script>
<script src="app/assets/libs/js/angular.min.js"></script>
<script src="app/assets/libs/js/angular-ui-router.js"></script>
<script src="app/assets/libs/js/ui-bootstrap-tpls-1.3.1.min.js"></script>

<!-- AngularJS custom codes -->

<script src="app/app.module.js"></script>
<script src="app/app.route.js"></script>
<script src="app/shared/appConstants.js"></script>
<script src="app/shared/HttpRequest.js"></script>
<script src="app/shared/CoreService.js"></script>
<script src="app/components/login/LoginCtrl.js"></script>
<script src="app/components/common/Header_Ctrl.js"></script>
<script src="app/components/home/Home_Ctrl.js"></script>
<script src="app/components/dashboard/Dash_Ctrl.js"></script>
<script src="app/components/candidate/Candidate_Ctrl.js"></script>
<script src="app/components/employee/Employee_Ctrl.js"></script>
<script src="app/components/client/Client_Ctrl.js"></script>
<script src="app/components/holiday/Holiday_Ctrl.js"></script>
<script src="app/components/opportunity/Opp_Ctrl.js"></script>


</head>
<body ng-class="{'login-page':isLogin}">
    <header ui-view="header" class="header-div"></header>
    <div ui-view="sidebar"></div>
    <div ui-view="content" class="page-content-div"></div>
    <footer ui-view="footer" class="footer-div"></footer>
</html>
