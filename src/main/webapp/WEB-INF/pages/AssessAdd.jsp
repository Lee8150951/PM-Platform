<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/23
  Time: 13:30
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
                                    <li><a href="${pageContext.request.contextPath }/assess/getToEvaluate" class="active">我的评估任务</a></li>
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
                <h3 class="page-title">固定资产评估信息录入</h3>
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
                                            <i class="fa fa-check-circle"></i> 当前评估的企业ID为：${enterprise.enterpriseId}号
                                        </div>
                                        <form action="" method="" style="margin-top: -40px;">
                                            <input type="hidden" class="form-control" placeholder="账号" value="<shiro:principal/>" id="userName">
                                            <br>
                                            <input type="hidden" class="form-control" placeholder="企业ID" name="" value="${enterprise.enterpriseId}" id="assessId">
                                            <br>
                                            <input type="text" class="form-control" placeholder="评估公司" name="" id="assessName">
                                            <br>
                                            <input type="text" class="form-control" placeholder="负责人" name="" id="assessBoss">
                                            <br>
                                            <p>公司成立时间：</p>
                                            <input type="date" class="form-control" name="" id="assessSigntime">
                                            <br>
                                            <input type="text" class="form-control" placeholder="公司地址" name="" id="assessAddress">
                                            <br>
                                            <p>组织形式：</p>
                                            <select class="form-control" name="" id="assessType">
                                                <option value="律师事务所">律师事务所</option>
                                                <option value="有限公司">有限公司</option>
                                            </select>
                                            <br>
                                            <input type="text" class="form-control" placeholder="邮箱" name="" id="assessEmail">
                                            <br>
                                            <input type="text" class="form-control" placeholder="电话" name="" id="assessPhone">
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
                                        <input type="text" class="form-control" placeholder="经办人姓名" name="" id="assessOperateName">
                                        <br>
                                        <input type="text" class="form-control" placeholder="经办人电话" name="" id="assessOperatePhone">
                                        <br>
                                        <input type="text" class="form-control" placeholder="经办人邮箱" name="" id="assessOperateEmail">
                                        <br>
                                        <input type="text" class="form-control" placeholder="经办人地址" name="" id="assessOperateAddress">
                                        <br>
                                        <p>评估时间：</p>
                                        <input type="date" class="form-control" name="" id="assessTime">
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
                                                <a type="submit" class="btn btn-success" id="submitAssessForm">
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
                        <div class="panel">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">附件上传</h3>
                                        <div class="right">
                                            <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
                                            <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
                                        </div>
                                    </div>
                                    <div class="panel-body">
                                        <form action="" method="">
                                            <div class="col-md-9" style="margin-left: -20px;">
                                                <a class="btn btn-info btn-block upload">
                                                    <i class="fa fa-refresh fa-spin"></i>
                                                    附件
                                                    <input type="file" class="form-control" name="file" id="file">
                                                </a>
                                            </div>
                                            <div class="col-md-3" style="float: right;">
                                                <a type="submit" class="btn btn-success" id="submitAssessFile">
                                                    <i class="fa fa-check-circle"></i>
                                                    上传
                                                </a>
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
    $(document).ready(function () {
        var time = new Date();
        var day = ("0" + time.getDate()).slice(-2);
        var month = ("0" + (time.getMonth() + 1)).slice(-2);
        var today = time.getFullYear() + "-" + (month) + "-" + (day);
        $('#assessTime').val(today);
    });
    $(function () {
        $("#submitAssessForm").click(function () {
            var user = $("#userName").val();
            var id = $("#assessId").val();
            var name = $("#assessName").val();
            if (name == '') {
                alert("评估公司不能为空！");
                return false;
            }
            var boss = $("#assessBoss").val();
            if (boss == '') {
                alert("责任人不能为空！");
                return false;
            }
            var signtime = $("#assessSigntime").val();
            if (signtime == '') {
                alert("公司成立时间不能为空！");
                return false;
            }
            var address = $("#assessAddress").val();
            if (address == '') {
                alert("公司地址不能为空！");
                return false;
            }
            var type = $("#assessType").val();
            if (type == '') {
                alert("组织形式不能为空！");
                return false;
            }
            var email = $("#assessEmail").val();
            var reg1 = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
            if (email == '') {
                alert("邮箱不能为空！");
                return false;
            }
            if (!reg1.test(email)) {
                alert("邮箱格式不正确！");
                return false;
            }
            var phone = $("#assessPhone").val();
            var reg2 = /^1[3456789]\d{9}$/;
            if (phone == '') {
                alert("电话不能为空！");
                return false;
            }
            if (!reg2.test(phone)) {
                alert("请填入正确的电话号码！");
                return false;
            }
            var o_name = $("#assessOperateName").val();
            if (o_name == '') {
                alert("经办人姓名不能为空！");
                return false;
            }
            var o_phone = $("#assessOperatePhone").val();
            var reg3 = /^1[3456789]\d{9}$/;
            if (o_phone == '') {
                alert("经办人电话不能为空！");
                return false;
            }
            if (!reg3.test(o_phone)) {
                alert("请填入正确的经办人电话号码！");
                return false;
            }
            var o_email = $("#assessOperateEmail").val();
            var reg4 = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
            if (o_email == '') {
                alert("经办人邮箱不能为空！");
                return false;
            }
            if (!reg4.test(o_email)) {
                alert("经办人邮箱格式不正确！");
                return false;
            }
            var o_address = $("#assessOperateAddress").val();
            if (o_address == '') {
                alert("经办人地址不能为空！");
                return false;
            }
            var time = $("#assessTime").val();
            if (time == '') {
                alert("评估时间不能为空！");
                return false;
            }
            $.ajax({
                url: "${pageContext.request.contextPath }/assess/insertAssess",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"userName":user,"assessId":id, "assessName":name,
                    "assessBoss":boss, "assessSigntime":signtime,
                    "assessAddress":address, "assessType":type,
                    "assessEmail":email, "assessPhone":phone,
                    "assessOperateName":o_name, "assessOperatePhone":o_phone,
                    "assessOperateEmail":o_email, "assessOperateAddress":o_address,
                    "assessTime":time,"username":user
                },
                dataType: "json"
            });
            var message = confirm("录入成功！是否有附件需要上传?");
            if (message == false) {
                window.location.href = "${pageContext.request.contextPath }/assess/getAllInfo";
            }
        });
        $("#submitAssessFile").click(function (){
            var formData = new FormData();
            formData.append("file", $("#file")[0].files[0]);
            formData.append("assessId",$("#assessId").val());
            $.ajax({
                url: "${pageContext.request.contextPath }/assess/uploadFile",
                type: "post",
                data: formData,
                /*设定同步请求，没有返回之前锁定浏览器*/
                async: false,
                /*上传文件时使用contentType: false*/
                contentType: false,
                /*禁止序列化data，直接进行使用*/
                processData: false,
                success: function () {
                    alert("附件上传成功！");
                    window.location.href = "${pageContext.request.contextPath }/assess/getAllInfo";
                }
            })
        });
    })
</script>
</body>
</html>

