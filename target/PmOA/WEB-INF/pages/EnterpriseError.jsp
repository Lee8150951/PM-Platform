<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/4/18
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ERROR</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/style.css">
</head>
<body>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-6 align-self-center">
                <img src="${pageContext.request.contextPath }/assets/img/404.PNG" alt="error">
            </div>
            <div class="col-md-6 align-self-center">
                <h1>Error</h1>
                <h2>UH OH！错误操作</h2>
                <p>您已经添加过一个企业信息，请耐心等待审核！</p>
                <a href="${pageContext.request.contextPath }/user/dashboard"><button class="btn green">返回首页</button></a>
            </div>
        </div>
    </div>
</main>
</body>
</html>
