<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/24
  Time: 11:59
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
                        <a href="#assessAdmin" data-toggle="collapse" class="active">
                            <i class="lnr lnr-pencil"></i>
                            <span>固定资产投资评估</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="assessAdmin" class="collapse in">
                            <ul class="nav">
                                <shiro:hasRole name="assess">
                                    <li><a href="${pageContext.request.contextPath }/assess/getToEvaluate">我的评估任务</a></li>
                                </shiro:hasRole>
                                <shiro:hasAnyRoles name="assess, leader">
                                    <li><a href="${pageContext.request.contextPath }/assess/getAllInfo" class="active">已评估企业总览</a></li>
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
                <h3 class="page-title">固定资产评估信息修改</h3>
                <div class="row">
                    <div class="col-md-6">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">评估公司信息</h3>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel-body">
                                        <div class="alert alert-success alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                                            <i class="fa fa-check-circle"></i> 当前修改的评估ID为：${assess.assessId}号
                                        </div>
                                        <form action="" method="" style="margin-top: -40px;">
                                            <input type="hidden" class="form-control" placeholder="账号" value="<shiro:principal/>" id="userName">
                                            <br>
                                            <input type="hidden" class="form-control" placeholder="企业ID" name="" value="${assess.assessId}" id="assessId">
                                            <br>
                                            <input type="text" class="form-control" placeholder="评估公司" name="" value="${assess.assessName}" id="assessName">
                                            <br>
                                            <input type="text" class="form-control" placeholder="负责人" name="" value="${assess.assessBoss}" id="assessBoss">
                                            <br>
                                            <p>公司成立时间：</p>
                                            <input type="date" class="form-control" name="" value="<fmt:formatDate value="${assess.assessSigntime}" pattern="yyyy-MM-dd"/>" id="assessSigntime">
                                            <br>
                                            <input type="text" class="form-control" placeholder="公司地址" name="" value="${assess.assessAddress}" id="assessAddress">
                                            <br>
                                            <p>组织形式：</p>
                                            <select class="form-control" name="" id="assessType">
                                                <option disabled="disabled" value="${assess.assessType}">${assess.assessType}</option>
                                                <option value="律师事务所">律师事务所</option>
                                                <option value="有限公司">有限公司</option>
                                            </select>
                                            <br>
                                            <input type="text" class="form-control" placeholder="邮箱" name="" value="${assess.assessEmail}" id="assessEmail">
                                            <br>
                                            <input type="text" class="form-control" placeholder="电话" name="" value="${assess.assessPhone}" id="assessPhone">
                                            <br>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">经办人信息</h3>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel-body">
                                        <input type="text" class="form-control" placeholder="经办人姓名" name="" value="${assess.assessOperateName}" id="assessOperateName">
                                        <br>
                                        <input type="text" class="form-control" placeholder="经办人电话" name="" value="${assess.assessOperatePhone}" id="assessOperatePhone">
                                        <br>
                                        <input type="text" class="form-control" placeholder="经办人邮箱" name="" value="${assess.assessOperateEmail}" id="assessOperateEmail">
                                        <br>
                                        <input type="text" class="form-control" placeholder="经办人地址" name="" value="${assess.assessOperateAddress}" id="assessOperateAddress">
                                        <br>
                                        <p>评估时间：</p>
                                        <input type="date" class="form-control" name="" value="<fmt:formatDate value="${assess.assessTime}" pattern="yyyy-MM-dd"/>" id="assessTime">
                                        <input type="hidden" class="form-control" name="" value="${assess.assessPath}" id="assessPath">
                                        <br><br>
                                        <div class="row">
                                            <div class="col-md-6"></div>
                                            <div class="col-md-3">
                                                <button type="reset" class="btn btn-warning">
                                                    <i class="fa fa-refresh"></i>
                                                    重置
                                                </button>
                                            </div>
                                            <div class="col-md-2">
                                                <a type="submit" class="btn btn-success" id="submitForm">
                                                    <i class="fa fa-check-circle"></i>
                                                    提交
                                                </a>
                                            </div>
                                        </div>
                                        </form>
                                    </div>
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
            var user = $("#userName").val();
            var id = $("#assessId").val();
            var name = $("#assessName").val();
            var boss = $("#assessBoss").val();
            var signtime = $("#assessSigntime").val();
            var address = $("#assessAddress").val();
            var type = $("#assessType").val();
            var email = $("#assessEmail").val();
            var phone = $("#assessPhone").val();
            var o_name = $("#assessOperateName").val();
            var o_phone = $("#assessOperatePhone").val();
            var o_email = $("#assessOperateEmail").val();
            var o_address = $("#assessOperateAddress").val();
            var time = $("#assessTime").val();
            var path = $("#assessPath").val();
            $.ajax({
                url: "${pageContext.request.contextPath }/assess/updateAssess",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"assessId":id, "assessName":name,
                    "assessBoss":boss, "assessSigntime":signtime,
                    "assessAddress":address, "assessType":type,
                    "assessEmail":email, "assessPhone":phone,
                    "assessOperateName":o_name, "assessOperatePhone":o_phone,
                    "assessOperateEmail":o_email, "assessOperateAddress":o_address,
                    "assessTime":time,"assessPath":path,"username":user
                },
                dataType: "json"
            });
            alert("修改成功！");
            window.location.href = "${pageContext.request.contextPath }/assess/getAllInfo";
        });
    });
</script>
</body>
</html>

