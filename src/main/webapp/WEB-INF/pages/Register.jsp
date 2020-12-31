<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/auth.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/vendor/sweetalert/sweetalert2.css">
</head>
<body>
<div class="lowin">
    <div class="lowin-brand">
        <img src="${pageContext.request.contextPath }/assets/img/logo-login.png" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-register">
            <div class="lowin-box-inner">
                <form action="" method="">
                    <p>账号注册</p>
                    <div class="lowin-group">
                        <label>用户名</label>
                        <input type="text" name="username" class="lowin-input" id="username">
                    </div>
                    <div class="lowin-group">
                        <label>密码</label>
                        <input type="password" name="password" class="lowin-input" id="password">
                    </div>
                    <a class="lowin-btn" id="submitForm" style="text-align: center">
                        注册
                    </a>
                    <div class="text-foot">
                        已有账号？ <a href="${pageContext.request.contextPath }/user/skipLogin" class="login-link">现在登录！</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Javascript -->
<script src="${pageContext.request.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#submitForm").click(function () {
            var username = $("#username").val();
            var password = $("#password").val();
            var reg2 = /^(?![^a-zA-Z]+$)(?!\D+$)/;
            if (username == '') {
                alert("用户名不能为空！");
                return false;
            }
            if (password == '') {
                alert("密码不能为空！");
                return false;
            }
            if (!reg2.test(password)) {
                alert("密码必须为6-18位字母、数字！");
                return false;
            }
            $.ajax({
                url: "${pageContext.request.contextPath }/user/register",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"username":username,"password":password},
                dataType: "json",
                success: function (data) {
                    if (data.msg == "success") {
                        alert("注册成功！");
                        window.location.href = "${pageContext.request.contextPath }/user/skipLogin";
                    } else {
                        alert("该用户名已被注册！");
                    }
                }
            });
        });
    });
</script>
</body>
</html>