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
                        <a href="#bussiAdmin" data-toggle="collapse" class="active">
                            <i class="lnr lnr-bookmark"></i>
                            <span>企业信息管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="bussiAdmin" class="collapse in">
                            <ul class="nav">
                                <shiro:hasAnyRoles name="servant, leader">
                                    <li><a href="${pageContext.request.contextPath }/enterprise/getAllInfo" class="active">信息总览</a></li>
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
                <!-- 主体标题 -->
                <div class="row">
                    <div class="col-md-6">
                        <h3 class="page-title">企业基本信息总览</h3>
                    </div>
                    <div class="col-md-6" style="float: right;">
                        <form action="${pageContext.request.contextPath }/enterprise/queryEnterprise">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <select class="form-control" name="queryKind" id="queryKind">
                                            <option selected="selected" disabled>查询类别</option>
                                            <option value="1">企业名称</option>
                                            <option value="2">企业性质</option>
                                            <option value="5">企业法人</option>
                                            <option value="3">企业责任人</option>
                                            <option value="6">企业等级</option>
                                            <option value="7">入驻时间</option>
                                            <option value="4">开户银行</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <input class="form-control" type="text" name="queryContent" id="queryContent">
                                        <span class="input-group-btn">
                                            <button class="btn btn-primary" id="submitForm" type="submit">
                                                Search
                                            </button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <!-- 表单层 -->
                        <div class="panel"><br>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel-body">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th style="text-align: center;">企业名称</th>
                                                <th style="text-align: center;">企业法人</th>
                                                <th style="text-align: center;">企业负责人</th>
                                                <th style="text-align: center;">联系电话</th>
                                                <th style="text-align: center;">企业性质</th>
                                                <th style="text-align: center;">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${pageInfo.list}" var="enterprise">
                                                <tr>
                                                    <td>${enterprise.enterpriseId}</td>
                                                    <td style="text-align: center;">${enterprise.enterpriseName}</td>
                                                    <td style="text-align: center;">${enterprise.enterpriseLegalman}</td>
                                                    <td style="text-align: center;">${enterprise.enterprisePrincipal}</td>
                                                    <td style="text-align: center;">${enterprise.enterprisePhone}</td>
                                                    <td style="text-align: center;">${enterprise.enterpriseType}</td>
                                                    <td style="text-align: center;">
                                                        <a href="${pageContext.request.contextPath }/enterprise/getEnterprise?enterpriseId=${enterprise.enterpriseId}"><span class="label label-primary">详情</span></a>
                                                        <shiro:hasRole name="servant">
                                                            <a href="${pageContext.request.contextPath }/enterprise/editEnterprise?enterpriseId=${enterprise.enterpriseId}"><span class="label label-info">修改</span></a>
                                                            <a href="" onclick="del(${enterprise.enterpriseId})"><span class="label label-danger">删除</span></a>
                                                        </shiro:hasRole>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                        <div class="row">
                                            <!--分页文字信息  -->
                                            <div class="col-md-4" style="margin-top: 25px">
                                                当前 ${pageInfo.pageNum }页,总${pageInfo.pages}
                                                页,总 ${pageInfo.total } 条记录
                                            </div>
                                            <!-- 分页条信息 -->
                                            <div class="col-md-4">
                                                <nav aria-label="Page navigation">
                                                    <ul class="pagination">
                                                        <li><a href="${pageContext.request.contextPath }/enterprise/getAllInfo?pn=1">首页</a></li>
                                                        <c:if test="${pageInfo.hasPreviousPage }">
                                                            <li><a href="${pageContext.request.contextPath }/enterprise/getAllInfo?pn=${pageInfo.pageNum-1}"
                                                                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                                            </a></li>
                                                        </c:if>
                                                        <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                                                            <c:if test="${page_Num == pageInfo.pageNum }">
                                                                <li class="active"><a href="#">${page_Num }</a></li>
                                                            </c:if>
                                                            <c:if test="${page_Num != pageInfo.pageNum }">
                                                                <li><a href="${pageContext.request.contextPath }/enterprise/getAllInfo?pn=${page_Num }">${page_Num }</a></li>
                                                            </c:if>
                                                        </c:forEach>
                                                        <c:if test="${pageInfo.hasNextPage }">
                                                            <li><a href="${pageContext.request.contextPath }/enterprise/getAllInfo?pn=${pageInfo.pageNum+1 }"
                                                                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                                            </a></li>
                                                        </c:if>
                                                        <li><a href="${pageContext.request.contextPath }/enterprise/getAllInfo?pn=${pageInfo.pages}">末页</a></li>
                                                    </ul>
                                                </nav>
                                            </div>
                                            <!-- 补录 -->
                                            <shiro:hasRole name="servant">
                                                <div class="col-md-1" style="margin-top: 20px">
                                                    <a class="btn btn-warning" href="${pageContext.request.contextPath }/enterprise/skipEnterpriseAdd">
                                                        <i class="fa fa-plus"></i> 补录
                                                    </a>
                                                </div>
                                            </shiro:hasRole>
                                            <!-- 打印Excel -->
                                            <div class="col-md-2" style="margin-top: 20px;float: right">
                                                <a class="btn btn-success" href="${pageContext.request.contextPath }/enterprise/excelDown">
                                                    <i class="fa fa-download"></i> 导出
                                                </a>
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
    function del(id) {
        var message = confirm("是否确认要删除?");
        if (message == true) {
            window.location.href = "${pageContext.request.contextPath }/enterprise/deleteEnterprise?enterpriseId="+id;
            alert("删除成功");
        } else {
            alert("删除失败");
        }
    }
</script>
</body>
</html>
