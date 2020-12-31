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
        <img src="assets/img/logo-login.png" alt="logo">
    </div>
    <div class="lowin-wrapper">
        <div class="lowin-box lowin-login">
            <div class="lowin-box-inner">
                <form action="" method="post">
                    <p>账号登录</p>
                    <div class="lowin-group">
                        <label>用户名 </label>
                        <input type="text" name="username" class="lowin-input" id="username">
                    </div>
                    <div class="lowin-group password-group">
                        <label>密码 <a href="#" class="forgot-link"></a></label>
                        <input type="password" name="password" class="lowin-input" id="password">
                    </div>
                    <a class="lowin-btn login-btn" id="submitForm" style="text-align: center" type="submit">
                        登录
                    </a>
                    <div class="text-foot">
                        没有账号？ <a href="${pageContext.request.contextPath }/user/skipRegister" class="register-link">注册一个！</a>
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
            if (username == '') {
                alert("用户名不能为空！");
                return false;
            }
            if (password == '') {
                alert("密码不能为空！");
                return false;
            }
            $.ajax({
                url: "${pageContext.request.contextPath }/user/login",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"username":username,"password":password},
                dataType: "json",
                success: function (data) {
                    if (data.msg == "success") {
                        window.location.href = "${pageContext.request.contextPath }/user/dashboard";
                    } else if (data.msg == "false"){
                        alert("用户名或密码错误！");
                    } else if (data.msg == "deficiency") {
                        window.location.href = "${pageContext.request.contextPath }/user/permissionApply";
                    }
                }
            });
        });
    });
</script>
</body>
</html>