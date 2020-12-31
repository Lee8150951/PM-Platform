<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/23
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/vendor/chartist/css/chartist-custom.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/main.css">
    <script src="${pageContext.request.contextPath }/assets/vendor/echarts/echarts.min.js"></script>
</head>

<body>
<div id="wrapper">
    <!-- 顶部导航栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <!-- 左侧Logo -->
        <div class="brand" style="width: 250px;">
            <img src="${pageContext.request.contextPath }/assets/img/logo.png" alt="Logo" class="img-responsive logo" style="height: 50px;">
        </div>
        <!-- 右侧菜单栏 -->
        <div class="container-fluid">
            <!-- 左侧导航栏缩进 -->
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
            </div>
            <!-- 个人信息下拉菜单 -->
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span><span class="fa fa-user"></span>&nbsp;<shiro:principal/></span>
                            <i class="icon-submenu lnr lnr-chevron-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath }/user/editProfile"><i class="lnr lnr-user"></i> <span>个人信息</span></a></li>
                            <li><a href="${pageContext.request.contextPath }/user/skipLogin"><i class="lnr lnr-exit"></i> <span>退出</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
