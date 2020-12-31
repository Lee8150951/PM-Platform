<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/24
  Time: 16:41
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
                    <li><a href="${pageContext.request.contextPath }/policy/skipPolicyAdd" class="active"><i class="lnr lnr-thumbs-up"></i> <span>政策申报</span></a></li>
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
            <h3 class="page-title">政策申报</h3>
            <div class="row">
                <div class="col-md-6">
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title">企业基本信息</h3>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel-body">
                                    <form action="" method="" style="margin-top: -20px">
                                        <input type="hidden" class="form-control" placeholder="账号" value="<shiro:principal/>" id="userName">
                                        <br>
                                        <input type="text" class="form-control" placeholder="申请单位" value="${enterprise.enterpriseName}" name="" id="policyEnterprise">
                                        <br>
                                        <input type="text" class="form-control" placeholder="企业地址" value="${enterprise.enterpriseRegaddress}" name="" id="policyAddress">
                                        <br>
                                        <input type="text" class="form-control" placeholder="邮政编码" value="${enterprise.enterprisePostcode}" name="" id="policyPostcode">
                                        <br>
                                        <input type="text" class="form-control" placeholder="联系人" value="${enterprise.enterprisePrincipal}" name="" id="policyMan">
                                        <br>
                                        <input type="text" class="form-control" placeholder="开户银行" value="${enterprise.enterpriseAccount}" name="" id="policyBank">
                                        <br>
                                        <input type="text" class="form-control" placeholder="账号" value="${policy.policyAccount}" name="" id="policyAccount">
                                        <br>
                                        <input type="text" class="form-control" placeholder="资金类别" value="${policy.policyType}" name="" id="policyType">
                                        <br>
                                        <input type="text" class="form-control" placeholder="已获得扶持资金" value="${policy.policyGotmoney}" name="" id="policyGotmoney">
                                        <br>
                                        <p>申请时间：</p>
                                        <input type="date" class="form-control" value="<fmt:formatDate value="${policy.policyApplytime}" pattern="yyyy-MM-dd"/>" name="" id="policyApplytime">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title">项目详情</h3>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel-body">
                                    <input type="text" class="form-control" placeholder="项目所在国(地区)" value="${policy.policyArea}" name="" id="policyArea">
                                    <br>
                                    <p>项目实施时间：</p>
                                    <input type="date" class="form-control" value="<fmt:formatDate value="${policy.policyStarttime}" pattern="yyyy-MM-dd"/>" name="" id="policyStarttime">
                                    <br>
                                    <input type="text" class="form-control" placeholder="项目负责人" value="${policy.policyPrincipal}" name="" id="policyPrincipal">
                                    <br>
                                    <input type="text" class="form-control" placeholder="联系电话" value="${policy.policyPhone}" name="" id="policyPhone">
                                    <br>
                                    <input type="text" class="form-control" placeholder="申请条例" value="${policy.policyPolicy}" name="" id="policyPolicy">
                                    <br>
                                    <input type="text" class="form-control" placeholder="申请扶持内容" value="${policy.policyContain}" name="" id="policyContain">
                                    <br>
                                    <input type="text" class="form-control" placeholder="申请扶持金额" value="${policy.policyMoney}" name="" id="policyMoney">
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
            var enterprise = $("#policyEnterprise").val();
            if (enterprise == '') {
                alert("申请单位不能为空！");
                return false;
            }
            var address = $("#policyAddress").val();
            if (address == '') {
                alert("企业地址不能为空！");
                return false;
            }
            var postcode = $("#policyPostcode").val();
            var reg1 = /^[1-9]\d{5}$/;
            if (postcode == '') {
                alert("邮编不能为空！");
                return false;
            }
            if (!reg1.test(postcode)) {
                alert("邮政编码格式不正确！");
                return false;
            }
            var bank = $("#policyBank").val();
            if (bank == '') {
                alert("开户银行不能为空！");
                return false;
            }
            var account = $("#policyAccount").val();
            var reg2 = /^([1-9]{1})(\d{14}|\d{18})$/;
            if (account == '') {
                alert("银行卡号不能为空！");
                return false;
            }
            if (!reg2.test(account)) {
                alert("银行卡号格式不正确！");
                return false;
            }
            var type = $("#policyType").val();
            if (type == '') {
                alert("资金类别不能为空！");
                return false;
            }
            var area = $("#policyArea").val();
            if (area == '') {
                alert("项目所在地不能为空！");
                return false;
            }
            var starttime = $("#policyStarttime").val();
            if (starttime == '') {
                alert("项目实施时间不能为空！");
                return false;
            }
            var principal = $("#policyPrincipal").val();
            if (principal == '') {
                alert("项目责任人不能为空！");
                return false;
            }
            var man = $("#policyMan").val();
            if (man == '') {
                alert("联系人不能为空！");
                return false;
            }
            var phone = $("#policyPhone").val();
            var reg3 = /^1[3456789]\d{9}$/;
            if (phone == '') {
                alert("电话不能为空！");
                return false;
            }
            if (!reg3.test(phone)) {
                alert("请填入正确的电话号码！");
                return false;
            }
            var gotmoney = $("#policyGotmoney").val();
            var reg4 = /^[0-9]*$/;
            if (gotmoney == '') {
                alert("已获得扶持资金不能为空！");
                return false;
            }
            if (!reg4.test(gotmoney)) {
                alert("已获得扶持资金必须为整数数值！");
                return false;
            }
            var applytime = $("#policyApplytime").val();
            if (applytime == '') {
                alert("项目实施时间不能为空！");
                return false;
            }
            var policy = $("#policyPolicy").val();
            if (policy == '') {
                alert("申请条例不能为空！");
                return false;
            }
            var contain = $("#policyContain").val();
            if (contain == '') {
                alert("扶持内容不能为空！");
                return false;
            }
            var money = $("#policyMoney").val();
            var reg5 = /^[0-9]*$/;
            if (money == '') {
                alert("申请扶持金额不能为空！");
                return false;
            }
            if (!reg5.test(money)) {
                alert("申请扶持金额必须为整数数值！");
                return false;
            }
            $.ajax({
                url: "${pageContext.request.contextPath }/policy/policyAdd",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"userName":user, "policyEnterprise":enterprise,
                    "policyAddress":address, "policyPostcode":postcode,
                    "policyBank":bank, "policyAccount":account,
                    "policyType":type, "policyArea":area,
                    "policyStarttime":starttime, "policyPrincipal":principal,
                    "policyMan":man, "policyPhone":phone,
                    "policyGotmoney":gotmoney, "policyApplytime":applytime,
                    "policyPolicy":policy, "policyContain":contain,
                    "policyMoney":money
                },
                dataType: "json"
            });
            alert("录入成功！");
            window.location.href = "${pageContext.request.contextPath }/process/getMyProcess";
        })
    })
</script>
</body>
</html>