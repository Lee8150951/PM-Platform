<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/4/17
  Time: 11:54
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
                        <a href="#emailManage" data-toggle="collapse" class="active">
                            <i class="lnr lnr-briefcase"></i>
                            <span>邮件管理</span>
                            <i class="icon-submenu lnr lnr-chevron-left"></i>
                        </a>
                        <div id="emailManage" class="collapse in">
                            <ul class="nav">
                                <li><a href="${pageContext.request.contextPath }/email/skipToAdd" class="active">写信</a></li>
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
                    <li><a href="${pageContext.request.contextPath }/complete/completeAdd" class="active"><i class="lnr lnr-map"></i> <span>完成情况上报</span></a></li>
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
            <h3 class="page-title">写信</h3>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-headline">
                        <div class="panel-body">
                            <div class="custom-tabs-line tabs-line-bottom left-aligned">
                                <ul class="nav" role="tablist">
                                    <li class="active"><a href="#tab-bottom-left1" role="tab" data-toggle="tab">普通邮件</a></li>
                                    <li><a href="#tab-bottom-left2" role="tab" data-toggle="tab">群发邮件</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab-bottom-left1">
                                    <form>
                                        <div class="col-md-12" style="margin-left:-40px;">
                                            <div class="col-md-1">
                                                <p style="float: left; margin-top: 7px;">收件人：</p>
                                            </div>
                                            <div class="col-md-10">
                                                <input type="text" class="form-control" placeholder="" name="" id="emailGet1">
                                            </div>
                                            <div class="col-md-1" style="margin-top: 5px;">
                                                <a href="javascript:void(0)" onclick="show()"><span class="label label-primary">添加抄送</span></a>
                                            </div>
                                        </div>
                                        <div class="col-md-12" style="margin-top: 10px; margin-left: -40px;display: none" id="carbonDiv">
                                            <div class="col-md-1">
                                                <p style="float: left; margin-top: 7px;">抄&nbsp;&nbsp;&nbsp;送：</p>
                                            </div>
                                            <div class="col-md-10">
                                                <input type="text" class="form-control" placeholder="" name="" id="carbon">
                                            </div>
                                            <div class="col-md-1" style="margin-top: 5px;">
                                                <a href="javascript:void(0)" onclick="hide()"><span class="label label-danger">删除抄送</span></a>
                                            </div>
                                        </div>
                                        <div class="col-md-12" style="margin-top: 10px; margin-left:-40px;" id="">
                                            <div class="col-md-1">
                                                <p style="float: left; margin-top: 7px;">主&nbsp;&nbsp;&nbsp;题：</p>
                                            </div>
                                            <div class="col-md-11">
                                                <input type="text" class="form-control" placeholder="" name="" id="emailHead1">
                                            </div>
                                        </div>
                                        <input type="date" placeholder="时间" id="emailTime1" style="display: none">
                                        <div class="col-md-12" style="margin-top: 10px; margin-left:-40px;">
                                            <div class="col-md-1">
                                                <p style="float: left; margin-top: 7px;">正&nbsp;&nbsp;&nbsp;文：</p>
                                            </div>
                                            <div class="col-md-11">
                                                <textarea class="form-control" placeholder="" rows="15" style="resize: none;" id="emailContent1"></textarea>
                                            </div>
                                        </div>
                                        <div class="col-md-2" style="margin-top: 30px;float: right;">
                                            <a class="btn btn-success" id="submitForm1">
                                                <i class="fa fa-check-circle"></i>
                                                提交
                                            </a>
                                        </div>
                                        <div class="row"></div>
                                    </form>
                                </div>
                                <div class="tab-pane fade" id="tab-bottom-left2">
                                    <form>
                                        <div class="col-md-12" style="margin-left:-40px;">
                                            <div class="col-md-1">
                                                <p style="float: left; margin-top: 7px;">收件人：</p>
                                            </div>
                                            <div class="col-md-11">
                                                <select class="form-control" name="" id="group">
                                                    <option disabled="disabled" selected="selected">--请选择发送集体--</option>
                                                    <option value="2">政府审批员</option>
                                                    <option value="3">档案局人员</option>
                                                    <option value="4">高新区工作人员</option>
                                                    <option value="5">固定资产评估员</option>
                                                    <option value="6">领导</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-12" style="margin-top: 10px; margin-left:-40px;">
                                            <div class="col-md-1">
                                                <p style="float: left; margin-top: 7px;">主&nbsp;&nbsp;&nbsp;题：</p>
                                            </div>
                                            <div class="col-md-11">
                                                <input type="text" class="form-control" placeholder="" name="" id="emailHead2">
                                            </div>
                                        </div>
                                        <input type="date" placeholder="时间" id="emailTime2" style="display: none">
                                        <div class="col-md-12" style="margin-top: 10px; margin-left:-40px;">
                                            <div class="col-md-1">
                                                <p style="float: left; margin-top: 7px;">正&nbsp;&nbsp;&nbsp;文：</p>
                                            </div>
                                            <div class="col-md-11">
                                                <textarea class="form-control" placeholder="" rows="15" style="resize: none;" id="emailContent2"></textarea>
                                            </div>
                                        </div>
                                        <div class="col-md-2" style="margin-top: 30px;float: right;">
                                            <a class="btn btn-success" id="submitForm2">
                                                <i class="fa fa-check-circle"></i>
                                                提交
                                            </a>
                                        </div>
                                        <div class="row"></div>
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
    $(document).ready(function () {
        var time = new Date();
        var day = ("0" + time.getDate()).slice(-2);
        var month = ("0" + (time.getMonth() + 1)).slice(-2);
        var today = time.getFullYear() + "-" + (month) + "-" + (day);
        $('#emailTime1').val(today);
        $('#emailTime2').val(today);
    });
    $(function () {
        $("#submitForm1").click(function () {
            var em_get = $("#emailGet1").val();
            var em_time = $("#emailTime1").val();
            var em_head = $("#emailHead1").val();
            var em_content = $("#emailContent1").val();
            var carbon = $("#carbon").val();
            $.ajax({
                url: "${pageContext.request.contextPath }/email/insertEmailSingle",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"emailGet":em_get, "emailTime":em_time,
                    "emailHead":em_head, "emailContent":em_content,
                    "carbon":carbon},
                dataType: "json",
                success: function (data) {
                    if (data.msg == "success") {
                        alert("邮件发送成功！");
                        window.location.href = "${pageContext.request.contextPath }/email/getAllSend";
                    } else {
                        alert("发送对象不存在！")
                    }
                }
            });
        });
        $("#submitForm2").click(function () {
            var group = $("#group").val();
            var em_time = $("#emailTime2").val();
            var em_head = $("#emailHead2").val();
            var em_content = $("#emailContent2").val();
            $.ajax({
                url: "${pageContext.request.contextPath }/email/insertEmailGroup",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"group":group, "emailTime":em_time,
                    "emailHead":em_head, "emailContent":em_content},
                dataType: "json",
                success: function (data) {
                    if (data.msg == "success") {
                        alert("邮件发送成功！");
                        window.location.href = "${pageContext.request.contextPath }/email/getAllSend";
                    } else {
                        alert("发送对象不存在！")
                    }
                }
            });
        });
    });
    function show() {
        document.getElementById("carbonDiv").style.display = "block";
    }
    function hide() {
        document.getElementById("carbonDiv").style.display = "none";
    }
</script>
</body>
</html>


