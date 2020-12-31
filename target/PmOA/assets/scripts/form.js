$(function () {
    /*登录表单验证*/
    $("#loginForm").click(function () {
        var email = $("#adminEmail").val();
        var password = $("#adminPassword").val();
        if (email == '') {
            swal('抱歉...', '邮箱不能为空', 'error');
            return false;
        }
        if (password == '') {
            swal('抱歉...', '密码不能为空', 'error');
            return false;
        }
    });

    /*注册表单验证*/
    $("#registerForm").click(function () {
        var id = $("#adminId").val();
        var email = $("#adminEmail").val();
        var emailTemp = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        var password = $("#adminPassword").val();
        var passwordTemp = /^(?![^a-zA-Z]+$)(?!\D+$)/;
        if (id == '') {
            swal('抱歉...', 'ID不能为空', 'error');
            return false;
        }
        if (email == '') {
            swal('抱歉...', '邮箱不能为空', 'error');
            return false;
        }
        if (!emailTemp.test(email)) {
            swal('抱歉...', '邮箱格式有误', 'error');
            return false;
        }
        if (password == '') {
            swal('抱歉...', '密码不能为空', 'error');
            return false;
        }
        if (!passwordTemp.test(password)) {
            swal('抱歉...', '密码必须为6-18位字母、数字', 'error');
            return false;
        }
    });
});