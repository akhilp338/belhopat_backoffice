(function () {
    var Core_ModalService = function (Core_Modal) {        
        var service = this;
        service.openForgotModal = function (data) {
            return Core_Modal.modalOpen('forgot-modal', '/BelhopatBackOffice/app/components/login/forgotPassword.html', 'Forgotpassword_Ctrl', 'vm', data);
        };        
    };
    angular.module('app.common')
        .service('Core_ModalService', Core_ModalService);
})();
