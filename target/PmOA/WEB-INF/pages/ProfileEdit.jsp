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
                <li><a href="${pageContext.request.contextPath }/user/dashboard" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
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
                    <li><a href="${pageContext.request.contextPath }/process/getMyProcess" class=""><i class="lnr lnr-hourglass"></i> <span>上报进度</span></a></li>
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
            <!-- 主体标题 -->
            <div class="panel panel-profile">
                <div class="clearfix">
                    <div class="profile-left">
                        <div class="profile-header">
                            <div class="overlay"></div>
                            <div class="profile-main">
                                <h1 style="color: white; font-size: 80px">${initial}</h1>
                                <h3 class="name">${user.username}</h3>
                            </div>
                            <div class="profile-stat">
                                <div class="row">
                                    <div class="col-md-6 stat-item">
                                        ${DoneNum} <span>已完成任务</span>
                                    </div>
                                    <div class="col-md-6 stat-item">
                                        ${UnNum} <span>待完成任务</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="profile-detail">
                            <div class="profile-info">
                                <h4 class="heading">基本信息</h4>
                                <ul class="list-unstyled list-justify">
                                    <li style="margin-top: 20px;">邮箱 <span>${user.email}</span></li>
                                    <li style="margin-top: 20px;">电话 <span>${user.phone}</span></li>
                                    <li style="margin-top: 20px;">隶属单位 <span>${user.unit}</span></li>
                                    <li style="margin-top: 20px;">职务 <span>${role}</span></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="profile-right">
                        <h4 class="heading">
                            ${user.username}的权限
                        </h4>
                        <div class="awards">
                            <div class="row">
                                <c:choose>
                                    <c:when test="${role.equals('企业业务员')||role.equals('高新区工作人员')||role.equals('领导')}">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="award-item">
                                                <div class="hexagon">
                                                    <span class="lnr lnr-sun award-icon"></span>
                                                </div>
                                                <span>企业信息管理</span>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${role.equals('档案局人员')||role.equals('领导')}">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="award-item">
                                                <div class="hexagon">
                                                    <span class="lnr lnr-clock award-icon"></span>
                                                </div>
                                                <span>档案信息管理</span>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${role.equals('高新区工作人员')}">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="award-item">
                                                <div class="hexagon">
                                                    <span class="lnr lnr-magic-wand award-icon"></span>
                                                </div>
                                                <span>用户信息管理</span>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${role.equals('固定资产评估员')||role.equals('领导')}">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="award-item">
                                                <div class="hexagon">
                                                    <span class="lnr lnr-pencil award-icon"></span>
                                                </div>
                                                <span>固定资产评估</span>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${role.equals('领导')}">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="award-item">
                                                <div class="hexagon">
                                                    <span class="lnr lnr-spell-check award-icon"></span>
                                                </div>
                                                <span>审阅信息管理</span>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${role.equals('政府审批人员')}">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="award-item">
                                                <div class="hexagon">
                                                    <span class="lnr lnr-license award-icon"></span>
                                                </div>
                                                <span>政策审批管理</span>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${!role.equals('领导')}">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="award-item">
                                                <div class="hexagon">
                                                    <span class="lnr lnr-users award-icon"></span>
                                                </div>
                                                <span>当前任务管理</span>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${role.equals('政府审批人员')||role.equals('高新区工作人员')||role.equals('固定资产评估员')}">
                                        <div class="col-md-3 col-sm-6">
                                            <div class="award-item">
                                                <div class="hexagon">
                                                    <span class="lnr lnr-sort-alpha-asc award-icon"></span>
                                                </div>
                                                <span>统计信息查看</span>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>
                        </div>
                        <div id="information" style="display: block">
                            <div class="custom-tabs-line tabs-line-bottom left-aligned">
                                <ul class="nav" role="tablist">
                                    <li class="active"><a href="#tab-bottom-left1" role="tab" data-toggle="tab">已完成任务</a></li>
                                    <li><a href="#tab-bottom-left2" role="tab" data-toggle="tab">待完成任务 </a></li>
                                    <li><a href="#tab-bottom-left3" role="tab" data-toggle="tab">信息修改 </a></li>
                                    <shiro:hasAnyRoles name="examine">
                                        <li><a href="#tab-bottom-left4" role="tab" data-toggle="tab">快捷意见 </a></li>
                                    </shiro:hasAnyRoles>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab-bottom-left1">
                                    <div class="table-responsive">
                                        <table class="table project-table">
                                            <thead>
                                            <tr>
                                                <th>任务ID</th>
                                                <th style="text-align: center;">任务名称</th>
                                                <th style="text-align: center;">开始时间</th>
                                                <th style="text-align: center;">结束时间</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${pageInfo_h.list}" var="history" begin="0" end="3">
                                                <tr>
                                                    <td>${history.ID_}</td>
                                                    <td style="text-align: center;">${history.ACT_NAME_}</td>
                                                    <td style="text-align: center;"><fmt:formatDate value="${history.START_TIME_}" pattern="yyyy-MM-dd"/></td>
                                                    <td style="text-align: center;"><fmt:formatDate value="${history.END_TIME_}" pattern="yyyy-MM-dd"/></td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="margin-top-30 text-center"><a href="#" class="btn btn-success">查看所有</a></div>
                                </div>
                                <div class="tab-pane fade" id="tab-bottom-left2">
                                    <div class="table-responsive">
                                        <table class="table project-table">
                                            <thead>
                                            <tr>
                                                <th>任务ID</th>
                                                <th style="text-align: center;">任务名称</th>
                                                <th style="text-align: center;">创建时间</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${pageInfo_p.list}" var="process" begin="0" end="3">
                                                <tr>
                                                    <td>${process.EXECUTION_ID_}</td>
                                                    <td style="text-align: center;">${process.NAME_}</td>
                                                    <td style="text-align: center;"><fmt:formatDate value="${process.CREATE_TIME_}" pattern="yyyy-MM-dd"/></td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="margin-top-30 text-center"><a href="#" class="btn btn-success">查看所有</a></div>
                                </div>
                                <div class="tab-pane fade" id="tab-bottom-left3">
                                    <div class="row">
                                        <form>
                                            <input type="hidden" class="form-control" placeholder="id" name="" value="${user.id}" id="id">
                                            <input type="hidden" class="form-control" placeholder="用户名" name="" value="${user.username}" id="username">
                                            <p>密码：</p>
                                            <input type="password" class="form-control" placeholder="密码" name="" value="${user.password}" id="password">
                                            <br>
                                            <p>邮箱：</p>
                                            <input type="text" class="form-control" placeholder="邮箱" name="" value="${user.email}" id="email">
                                            <br>
                                            <p>电话：</p>
                                            <input type="text" class="form-control" placeholder="电话" name="" value="${user.phone}" id="phone">
                                            <br>
                                            <p>隶属单位：</p>
                                            <input type="text" class="form-control" placeholder="隶属单位" name="" value="${user.unit}" id="unit">
                                            <br>
                                            <input type="hidden" class="form-control" placeholder="角色ID" name="" value="${user.roleId}" id="roleId">
                                            <br>
                                            <div class=" text-center">
                                                <a type="submit" class="btn btn-success" id="submitForm">
                                                    <i class="fa fa-check-circle"></i>
                                                    提交
                                                </a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                                <shiro:hasAnyRoles name="examine">
                                    <div class="tab-pane fade" id="tab-bottom-left4">
                                        <div class="row">
                                            <div class="col-md-6">
                                               <h4 style="font-size: 17px">
                                                    预设意见
                                                </h4>
                                                <p style="margin-top: 20px">${opinion.opinionContent}</p>
                                            </div>
                                            <div class="col-md-6" style="border-left: 1px solid #eaeaea;">
                                                <h4 style="font-size: 17px">
                                                    预设意见提交/修改
                                                </h4>
                                                <form style="margin-top: 20px">
                                                    <textarea class="form-control" placeholder="" rows="6" style="resize: none;" id="opinionContent"></textarea>
                                                    <div class="col-md-2" style="margin-top: 20px;margin-left: 230px">
                                                        <a class="btn btn-success" id="submitOpinion">
                                                            <i class="fa fa-check-circle"></i>
                                                            提交
                                                        </a>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </shiro:hasAnyRoles>
                            </div>
                        </div>
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
<script type="text/javascript">
    $(function () {
        $("#submitForm").click(function () {
            var id = $("#id").val();
            var username = $("#username").val();
            var password = $("#password").val();
            var email = $("#email").val();
            var phone = $("#phone").val();
            var unit = $("#unit").val();
            var roleId = $("#roleId").val();
            $.ajax({
                url: "${pageContext.request.contextPath }/user/updateUser",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"id":id,"username":username,
                    "password":password,"email":email,
                    "phone":phone,"unit":unit,"roleId":roleId},
                dataType: "json"
            });
            alert("修改成功！");
            window.location.href = "${pageContext.request.contextPath }/user/editProfile";
        });
        $("#submitOpinion").click(function () {
            var o_content = $("#opinionContent").val();
            $.ajax({
                url: "${pageContext.request.contextPath }/opinion/opinionUpdate",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"opinionContent":o_content},
                dataType: "json"
            });
            alert("提交成功！");
            window.location.href = "${pageContext.request.contextPath }/user/editProfile";
        });
    });
</script>
</body>
</html>
