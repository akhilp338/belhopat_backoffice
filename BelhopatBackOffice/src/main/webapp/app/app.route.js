(function () {
    'use strict';
    var Core_Routes = function ($stateProvider, $locationProvider, $urlRouterProvider,urlConfig) {
$locationProvider.html5Mode(true);
//        $urlRouterProvider.otherwise(function () {
//            window.location = urlConfig.root_path;
//        });

        $stateProvider
                .state('coreuser', {
                    url: '',
                    abstract: true,
                    views: {
                        'header': {
                            templateUrl: 'app/components/common/innerHeader.html',
                            controller: 'Header_Ctrl',
                            controllerAs: 'vm'
                        },
                        'sidebar': {
                            templateUrl: 'app/components/common/sidebar.html',
                            controller: 'Home_Ctrl',
                            controllerAs: 'vm'
                        },
                        'footer': {
                            templateUrl: 'app/components/common/footer.html'
                        }
                    }
                })
                .state('login', {
                    url: urlConfig.root_path,
                    views: {
                        'content@': {
                            templateUrl: 'app/components/login/login.html',
                            controller: 'Login_Ctrl',
                            controllerAs: 'vm'
                        }
                    }
                }).state('coreuser.dashboard', {
            url: urlConfig.root_path+'dashboard',
            views: {
                'content@': {
                    templateUrl: 'app/components/dashboard/dashboard.html',
                    controller: 'Dash_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.success', {
            url: urlConfig.root_path+'loginSuccess',
            views: {
                'content@': {
                    templateUrl: 'app/components/dashboard/dashboard.html',
                    controller: 'Dash_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('login.error', {
            url: urlConfig.root_path+'loginerror',
            views: {
                'content@': {
                    templateUrl: 'app/components/login/login.html',
                    controller: 'Login_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.candidate', {
            url: urlConfig.root_path+'candidate',
            views: {
                'content@': {
                    templateUrl: 'app/components/candidate/candidate.html',
                    controller: 'Candidate_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.candidate.add', {
            url: '/add',
            views: {
                'sidebar@':{
                    templateUrl: 'app/components/common/defaultTemplate.html' 
                },
                'content@': {
                    templateUrl: 'app/components/candidate/candidateAdd.html',
                    controller: 'AddCandidate_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.candidate.edit', {
            url: '/edit/:id',
            views: {
                'sidebar@':{
                    templateUrl: 'app/components/common/defaultTemplate.html' 
                },
                'content@': {
                    templateUrl: 'app/components/candidate/candidateAdd.html',
                    controller: 'AddCandidate_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.employee', {
            url: urlConfig.root_path+'employee',
            views: {
                'content@': {
                    templateUrl: 'app/components/employee/employee.html',
                    controller: 'Employee_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.employee.add', {
            url: '/addEmployee',
            views: {
                'sidebar@':{
                    templateUrl: 'app/components/common/defaultTemplate.html' 
                },
                'content@': {
                    templateUrl: 'app/components/employee/employeeAdd.html',
                    controller: 'AddEmployee_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.employee.edit', {
            url: '/edit/:id',
            views: {
                'sidebar@':{
                    templateUrl: 'app/components/common/defaultTemplate.html' 
                },
                'content@': {
                    templateUrl: 'app/components/employee/employeeAdd.html',
                    controller: 'AddEmployee_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.client', {
            url: urlConfig.root_path+'client',
            views: {
                'content@': {
                    templateUrl: 'app/components/client/client.html',
                    controller: 'Client_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.opportunity', {
            url: urlConfig.root_path+'opportunity',
            views: {
                'content@': {
                    templateUrl: 'app/components/opportunity/opportunity.html',
                    controller: 'Opp_Ctrl',
                    controllerAs: 'vm'
                }
            }
        }).state('coreuser.holiday', {
            url: urlConfig.root_path+'holiday',
            views: {
                'content@': {
                    templateUrl: 'app/components/holiday/holiday.html',
                    controller: 'Holiday_Ctrl',
                    controllerAs: 'vm'
                }
            }
        });
    };
    angular.module('coreModule')
            .config(Core_Routes);
})();
