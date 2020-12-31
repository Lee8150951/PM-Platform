<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/24
  Time: 12:00
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
                        <a href="#emailManage" data-toggle="collapse" class="collapse">
                            <i class="lnr lnr-briefcase"></i>
                            <span>邮件管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="emailManage" class="collapse">
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
                        <a href="#supportPolicy" data-toggle="collapse" class="collapse">
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
                        <a href="#bussiAdmin" data-toggle="collapse" class="collapse">
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
                        <a href="#fileAdmin" data-toggle="collapse" class="active">
                            <i class="lnr lnr-map"></i>
                            <span>招商引资档案管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="fileAdmin" class="collapse in">
                            <ul class="nav">
                                <shiro:hasAnyRoles name="file, leader">
                                    <li><a href="${pageContext.request.contextPath }/file/getAllInfo" class="active">档案总览</a></li>
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
                        <a href="#assessAdmin" data-toggle="collapse" class="collapse">
                            <i class="lnr lnr-pencil"></i>
                            <span>固定资产投资评估</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="assessAdmin" class="collapse">
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
                <h3 class="page-title">招商引资档案信息修改</h3>
                <div class="row">
                    <div class="col-md-6">
                        <div class="panel">
                            <div class="row">
                                <div class="profile-right" style="float: left; margin-left: 10px; margin-top: -13px">
                                    <div class="custom-tabs-line tabs-line-bottom left-aligned" style="width: 450px">
                                        <ul class="nav" role="tablist">
                                            <li class="active"><a href="#tab-bottom-left1" role="tab" data-toggle="tab" style="font-size: 17px; font-weight: 300">企业信息</a></li>
                                            <li><a href="#tab-bottom-left2" role="tab" data-toggle="tab" style="font-size: 17px; font-weight: 300">申请政策 </a></li>
                                            <li><a href="#tab-bottom-left3" role="tab" data-toggle="tab" style="font-size: 17px; font-weight: 300">审批结论 </a></li>
                                            <li><a href="#tab-bottom-left4" role="tab" data-toggle="tab" style="font-size: 17px; font-weight: 300">完成申报 </a></li>
                                        </ul>
                                    </div>
                                    <div class="tab-content">
                                        <div class="tab-pane fade in active" id="tab-bottom-left1">
                                            <ul class="list-unstyled activity-timeline">
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${enterprise.enterpriseName}
                                                        <span class="timestamp">企业名称</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${enterprise.enterpriseLegalman}
                                                        <span class="timestamp">企业法人</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${enterprise.enterprisePrincipal}
                                                        <span class="timestamp">企业责任人</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${enterprise.enterprisePhone}
                                                        <span class="timestamp">联系电话</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${enterprise.enterpriseFund}元
                                                        <span class="timestamp">注册资金</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${enterprise.enterpriseType}
                                                        <span class="timestamp">企业类型</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${enterprise.enterpriseScope}
                                                        <span class="timestamp">经营范围</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${enterprise.enterpriseRank}
                                                        <span class="timestamp">企业等级</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>
                                                        <fmt:formatDate value="${enterprise.enterpriseIntime}" pattern="yyyy-MM-dd"/>
                                                        <span class="timestamp">入驻时间</span>
                                                    </p>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="tab-pane fade" id="tab-bottom-left2">
                                            <ul class="list-unstyled activity-timeline">
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${policy.policyBank}
                                                        <span class="timestamp">开户行</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${policy.policyType}
                                                        <span class="timestamp">资金类别</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${policy.policyGotmoney}元
                                                        <span class="timestamp">已获得扶持资金</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p><fmt:formatDate value="${policy.policyApplytime}" pattern="yyyy-MM-dd"/>
                                                        <span class="timestamp">申请时间</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${policy.policyArea}
                                                        <span class="timestamp">项目所在国(地区)</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${policy.policyPolicy}
                                                        <span class="timestamp">申请条例</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${policy.policyContain}
                                                        <span class="timestamp">申请扶持内容</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${policy.policyMoney}元
                                                        <span class="timestamp">申请扶持金额</span>
                                                    </p>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="tab-pane fade" id="tab-bottom-left3">
                                            <ul class="list-unstyled activity-timeline">
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${examine.examineMan}
                                                        <span class="timestamp">经办人</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${examine.examinePrincipal}
                                                        <span class="timestamp">责任人</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${examine.examinePhone}元
                                                        <span class="timestamp">联系电话</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p><fmt:formatDate value="${examine.examineTime}" pattern="yyyy-MM-dd"/>
                                                        <span class="timestamp">审批时间</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${examine.examineResult}
                                                        <span class="timestamp">审批结果</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${examine.examineOpinion}
                                                        <span class="timestamp">审批意见</span>
                                                    </p>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="tab-pane fade" id="tab-bottom-left4">
                                            <ul class="list-unstyled activity-timeline">
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p><fmt:formatDate value="${complete.completeStarttime}" pattern="yyyy-MM-dd"/>
                                                        <span class="timestamp">实施时间</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p><fmt:formatDate value="${complete.completeComtime}" pattern="yyyy-MM-dd"/>
                                                        <span class="timestamp">完成时间</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${complete.completeCondition}
                                                        <span class="timestamp">完成情况</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${complete.completeManager}
                                                        <span class="timestamp">项目经理</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${complete.completeContain}
                                                        <span class="timestamp">完成内容</span>
                                                    </p>
                                                </li>
                                                <li>
                                                    <i class="fa fa-check activity-icon"></i>
                                                    <p>${complete.completeRemark}
                                                        <span class="timestamp">备注</span>
                                                    </p>
                                                </li>
                                            </ul>
                                            <div class="col-md-6"></div>
                                            <div class="col-md-2" style="margin-top: 20px; margin-left: 10px">
                                                <a class="btn btn-success" href="${pageContext.request.contextPath }/file/downloadFile?id=${enterprise.enterpriseId}">
                                                    <i class="fa fa-download"></i> 导出全部信息
                                                </a>
                                            </div>
                                            <div class="col-md-4"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">档案补充信息</h3>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel-body">
                                        <form action="" method="">
                                            <input type="hidden" class="form-control" placeholder="ID" value="${enterprise.enterpriseId}" name="" id="fileId">
                                            <input type="text" class="form-control" placeholder="责任人" name="" value="${file.fileDutyofficer}" id="fileDutyofficer">
                                            <br>
                                            <input type="text" class="form-control" placeholder="责任处室名" name="" value="${file.fileResponse}" id="fileResponse">
                                            <br>
                                            <input type="text" class="form-control" placeholder="档案题名" name="" value="${file.fileTitle}" id="fileTitle">
                                            <br>
                                            <p>档案写入时间：</p>
                                            <input type="date" class="form-control" name="" value="<fmt:formatDate value="${file.fileTime}" pattern="yyyy-MM-dd"/>" id="fileTime">
                                            <input type="hidden" class="form-control" name="${file.filePath}" id="filePath">
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
            var id = $("#fileId").val();
            var dutyofficer = $("#fileDutyofficer").val();
            var response = $("#fileResponse").val();
            var title = $("#fileTitle").val();
            var time = $("#fileTime").val();
            var path = $("#filePath").val();
            $.ajax({
                url: "${pageContext.request.contextPath }/file/updateFile",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"fileId":id,"fileDutyofficer":dutyofficer,
                    "fileResponse":response,"fileTitle":title,
                    "fileTime":time,"filePath":path
                },
                dataType: "json"
            });
            alert("修改成功！");
            window.location.href = "${pageContext.request.contextPath }/file/getAllInfo";
        });
    });
</script>
</body>
</html>

