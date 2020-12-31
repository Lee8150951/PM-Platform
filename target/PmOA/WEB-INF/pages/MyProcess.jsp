<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/21
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<!-- 左侧导航栏 -->
<div id="sidebar-nav" class="sidebar">
    <div class="sidebar-scroll">
        <nav>
            <ul class="nav">
                <li><a href="${pageContext.request.contextPath }/user/dashboard"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
                <shiro:hasAnyRoles name="examine, file, servant, assess, leader">
                    <li><a href="${pageContext.request.contextPath }/book/getAllInfo"><i class="lnr lnr-book"></i> <span>通讯录</span></a></li>
                </shiro:hasAnyRoles>
                <shiro:hasAnyRoles name="examine, file, servant, assess, leader" >
                    <li>
                        <a href="#emailManage" data-toggle="collapse" class="collapsed">
                            <i class="lnr lnr-briefcase"></i>
                            <span>邮件管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="emailManage" class="collapse ">
                            <ul class="nav">
                                <li><a href="${pageContext.request.contextPath }/email/skipToAdd">写信</a></li>
                                <li><a href="${pageContext.request.contextPath }/email/getAllGet">收信</a></li>
                                <li><a href="${pageContext.request.contextPath }/email/getAllSend">已发送</a></li>
                            </ul>
                        </div>
                    </li>
                </shiro:hasAnyRoles>
                <shiro:hasAnyRoles name="examine, leader">
                    <li>
                        <a href="#supportPolicy" data-toggle="collapse" class="collapsed">
                            <i class="lnr lnr-dice"></i>
                            <span>扶持政策兑现审批</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="supportPolicy" class="collapse ">
                            <ul class="nav">
                                <shiro:hasRole name="examine">
                                    <li><a href="${pageContext.request.contextPath }/examine/getMyUndone">我的审批任务</a></li>
                                </shiro:hasRole>
                                <shiro:hasAnyRoles name="examine, leader" >
                                    <li><a href="${pageContext.request.contextPath }/examine/getList">已审批项目</a></li>
                                </shiro:hasAnyRoles>
                            </ul>
                        </div>
                    </li>
                </shiro:hasAnyRoles>
                <shiro:hasAnyRoles name="servant, leader">
                    <li><a href="${pageContext.request.contextPath }/process/getAllProcess"><i class="lnr lnr-pushpin"></i> <span>在办业务</span></a></li>
                </shiro:hasAnyRoles>
                <shiro:hasRole name="servant">
                    <li><a href="${pageContext.request.contextPath }/user/getAllInfo" class=""><i class="lnr lnr-chart-bars"></i> <span>权限管理</span></a></li>
                </shiro:hasRole>
                <shiro:hasRole name="servant">
                    <li><a href="${pageContext.request.contextPath }/roleapply/getAllInfo" class=""><i class="lnr lnr-thumbs-up"></i> <span>角色审批</span></a></li>
                </shiro:hasRole>
                <shiro:hasAnyRoles name="servant, leader, clerk">
                    <li>
                        <a href="#bussiAdmin" data-toggle="collapse" class="collapsed">
                            <i class="lnr lnr-bookmark"></i>
                            <span>企业信息管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="bussiAdmin" class="collapse ">
                            <ul class="nav">
                                <shiro:hasAnyRoles name="servant, leader">
                                    <li><a href="${pageContext.request.contextPath }/enterprise/getAllInfo">信息总览</a></li>
                                </shiro:hasAnyRoles>
                                <shiro:hasAnyRoles name="servant, clerk">
                                    <li><a href="${pageContext.request.contextPath }/enterprise/skipEnterpriseAdd">信息新建</a></li>
                                </shiro:hasAnyRoles>
                            </ul>
                        </div>
                    </li>
                </shiro:hasAnyRoles>
                <shiro:hasRole name="clerk">
                    <li><a href="${pageContext.request.contextPath }/policy/skipPolicyAdd" class=""><i class="lnr lnr-thumbs-up"></i> <span>政策申报</span></a></li>
                </shiro:hasRole>
                <shiro:hasRole name="leader">
                    <li><a href="${pageContext.request.contextPath }/check/getAllInfo" class=""><i class="lnr lnr-thumbs-up"></i> <span>审批审阅</span></a></li>
                </shiro:hasRole>
                <shiro:hasAnyRoles name="file, leader">
                    <li>
                        <a href="#fileAdmin" data-toggle="collapse" class="collapsed">
                            <i class="lnr lnr-map"></i>
                            <span>招商引资档案管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="fileAdmin" class="collapse ">
                            <ul class="nav">
                                <shiro:hasAnyRoles name="file, leader">
                                    <li><a href="${pageContext.request.contextPath }/file/getAllInfo">档案总览</a></li>
                                </shiro:hasAnyRoles>
                                <shiro:hasRole name="file">
                                    <li><a href="${pageContext.request.contextPath }/complete/getAllInfo">未归档企业总览</a></li>
                                </shiro:hasRole>
                            </ul>
                        </div>
                    </li>
                </shiro:hasAnyRoles>
                <shiro:hasAnyRoles name="assess, leader">
                    <li>
                        <a href="#assessAdmin" data-toggle="collapse" class="collapsed">
                            <i class="lnr lnr-pencil"></i>
                            <span>固定资产投资评估</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="assessAdmin" class="collapse ">
                            <ul class="nav">
                                <shiro:hasRole name="assess">
                                    <li><a href="${pageContext.request.contextPath }/assess/getToEvaluate">我的评估任务</a></li>
                                </shiro:hasRole>
                                <shiro:hasAnyRoles name="assess, leader">
                                    <li><a href="${pageContext.request.contextPath }/assess/getAllInfo">已评估企业总览</a></li>
                                </shiro:hasAnyRoles>
                            </ul>
                        </div>
                    </li>
                </shiro:hasAnyRoles>
                <shiro:hasRole name="clerk">
                    <li><a href="${pageContext.request.contextPath }/process/getMyProcess" class="active"><i class="lnr lnr-hourglass"></i> <span>上报进度</span></a></li>
                </shiro:hasRole>
                <shiro:hasRole name="clerk">
                    <li><a href="${pageContext.request.contextPath }/complete/completeAdd" class=""><i class="lnr lnr-map"></i> <span>完成情况上报</span></a></li>
                </shiro:hasRole>
            </ul>
        </nav>
    </div>
</div>
<!-- 主体层1 -->
<div class="main">
    <!-- 主体层2 -->
    <div class="main-content">
        <!-- 主体层3 -->
        <div class="container-fluid">
            <h3 class="page-title">上报进度</h3>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title">总流程</h3>
                        </div>
                        <div class="row" style="margin-left: 30px">
                            <c:choose>
                                <c:when test="${processName.equals('提交企业信息')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-exit-up award-icon" style="color: #00aaff; font-weight: bold"></span>
                                            </div>
                                            <span style="color: #00aaff; font-weight: bold">企业信息上传</span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${!processName.equals('提交企业信息')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-exit-up award-icon"></span>
                                            </div>
                                            <span>企业信息上传</span>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                            <div class="col-md-1" style="border-bottom: 3px solid #eaeaea; margin-top: 60px; margin-left: 28px"></div>
                            <c:choose>
                                <c:when test="${processName.equals('固定资产评估')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-pencil award-icon" style="color: #00aaff; font-weight: bold"></span>
                                            </div>
                                            <span style="color: #00aaff; font-weight: bold">固定资产评估</span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${!processName.equals('固定资产评估')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-pencil award-icon"></span>
                                            </div>
                                            <span>固定资产评估</span>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                            <div class="col-md-1" style="border-bottom: 3px solid #eaeaea; margin-top: 60px; margin-left: 28px"></div>
                            <c:choose>
                                <c:when test="${processName.equals('申报政策')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-file-add award-icon" style="color: #00aaff; font-weight: bold"></span>
                                            </div>
                                            <span style="color: #00aaff; font-weight: bold">政策申请</span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${!processName.equals('申报政策')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-file-add award-icon"></span>
                                            </div>
                                            <span>政策申请</span>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                            <div class="col-md-1" style="border-bottom: 3px solid #eaeaea; margin-top: 60px; margin-left: 28px"></div>
                            <c:choose>
                                <c:when test="${processName.equals('政策审批')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-eye award-icon" style="color: #00aaff; font-weight: bold"></span>
                                            </div>
                                            <span style="color: #00aaff; font-weight: bold">申请政策审批</span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${!processName.equals('政策审批')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-eye award-icon"></span>
                                            </div>
                                            <span>申请政策审批</span>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                            <div class="col-md-1" style="border-bottom: 3px solid #eaeaea; margin-top: 60px; margin-left: 28px"></div>
                            <c:choose>
                                <c:when test="${processName.equals('领导审阅')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-spell-check award-icon" style="color: #00aaff; font-weight: bold"></span>
                                            </div>
                                            <span style="color: #00aaff; font-weight: bold">领导批阅</span>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${!processName.equals('领导审阅')}">
                                    <div class="col-md-1 col-sm-6">
                                        <div class="award-item">
                                            <div class="hexagon">
                                                <span class="lnr lnr-spell-check award-icon"></span>
                                            </div>
                                            <span>领导批阅</span>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="row" style="margin-top: 20px">
                            <div class="col-md-5"></div>
                            <div class="col-md-2">
                                <button type="submit" class="btn btn-warning" id="submitForm">
                                    <i class="fa fa-check-circle"></i>
                                    催办
                                </button>
                            </div>
                            <div class="col-md-5"></div>
                        </div>
                        <div class="row" style="height: 30px"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!-- Javascript -->
<script src="${pageContext.request.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/vendor/chartist/js/chartist.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/scripts/common.js"></script>
</body>
</html>
