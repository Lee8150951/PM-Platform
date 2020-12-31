<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/22
  Time: 17:31
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
                                    <li><a href="${pageContext.request.contextPath }/enterprise/getAllInfo">信息总览</a></li>
                                </shiro:hasAnyRoles>
                                <shiro:hasAnyRoles name="servant, clerk">
                                    <li><a href="${pageContext.request.contextPath }/enterprise/skipEnterpriseAdd" class="active">信息新建</a></li>
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
                <h3 class="page-title">企业信息录入</h3>
                <div class="row">
                    <div class="col-md-6">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">基本信息</h3>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel-body">
                                        <form id="EnterpriseForm" style="margin-top: -20px">
                                            <input type="hidden" class="form-control" placeholder="账号" value="<shiro:principal/>" id="userName">
                                            <br>
                                            <input type="text" class="form-control" placeholder="企业ID" name="" id="enterpriseId" readonly>
                                            <br>
                                            <input type="text" class="form-control" placeholder="企业名称" name="" id="enterpriseName">
                                            <br>
                                            <input type="text" class="form-control" placeholder="注册地址" name="" id="enterpriseRegaddress">
                                            <br>
                                            <input type="text" class="form-control" placeholder="法人" name="" id="enterpriseLegalman">
                                            <br>
                                            <input type="text" class="form-control" placeholder="企业负责人" name="" id="enterprisePrincipal">
                                            <br>
                                            <input type="text" class="form-control" placeholder="联系电话" name="" id="enterprisePhone">
                                            <br>
                                            <input type="text" class="form-control" placeholder="邮箱" name="" id="enterpriseEmail">
                                            <br>
                                            <input type="text" class="form-control" placeholder="注册资金" name="" id="enterpriseFund">
                                            <br>
                                            <p>企业类型：</p>
                                            <select class="form-control" name="" id="enterpriseType">
                                                <option value="合资企业">合资企业</option>
                                                <option value="独资企业">独资企业</option>
                                                <option value="国有企业">国有企业</option>
                                                <option value="私营企业">私营企业</option>
                                                <option value="全民所有制企业">全民所有制企业</option>
                                                <option value="集体所有制企业">集体所有制企业</option>
                                                <option value="股份制企业">股份制企业</option>
                                                <option value="有限责任企业">有限责任企业</option>
                                                <option value="外资企业">外资企业</option>
                                            </select>
                                            <br>
                                            <p>成立时间：</p>
                                            <input type="date" class="form-control" name="" id="enterpriseSigntime">
                                            <br>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">相关信息</h3>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel-body">
                                        <p>经营范围：</p>
                                        <select class="form-control" name="" id="enterpriseScope">
                                            <option value="互联网">互联网</option>
                                            <option value="医疗">医疗</option>
                                            <option value="文娱">文娱</option>
                                            <option value="餐饮">餐饮</option>
                                            <option value="金融">金融</option>
                                            <option value="商贸">商贸</option>
                                            <option value="建筑">建筑</option>
                                            <option value="旅游">旅游</option>
                                            <option value="教育">教育</option>
                                            <option value="其他">其他</option>
                                        </select>
                                        <br>
                                        <p>企业等级：</p>
                                        <select class="form-control" name="" id="enterpriseRank">
                                            <option value="AAA级">AAA级</option>
                                            <option value="AA级">AA级</option>
                                            <option value="A级">A级</option>
                                            <option value="BBB级">BBB级</option>
                                            <option value="BB级">BB级</option>
                                            <option value="B级">B级</option>
                                            <option value="C级">C级</option>
                                        </select>
                                        <br>
                                        <input type="text" class="form-control" placeholder="联系地址" name="" id="enterpriseConaddress">
                                        <br>
                                        <input type="text" class="form-control" placeholder="邮编" name="" id="enterprisePostcode">
                                        <br>
                                        <input type="text" class="form-control" placeholder="开户银行" name="" id="enterpriseAccount">
                                        <br>
                                        <p>入驻时间：</p>
                                        <input type="date" class="form-control" name="" id="enterpriseIntime">
                                        <br><br>
                                        <div class="row">
                                            <div class="col-md-6"></div>
                                            <div class="col-md-3"></div>
                                            <div class="col-md-2">
                                                <a class="btn btn-success" id="submitForm">
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
                                                <a class="btn btn-success" id="submitFile">
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
        $('#enterpriseIntime').val(today);
    });
    // 获取随机ID
    $(document).ready(function () {
        var length = 8;
        var EnterpriseId = "";
        for (var i = 0; i < length; i++) {
            var number = parseInt(Math.random() * 10);
            var s = number.toString();
            EnterpriseId = EnterpriseId + s;
        }
        $('#enterpriseId').val(EnterpriseId);
    });
    $(function () {
        $("#submitForm").click(function () {
            var user = $("#userName").val();
            var id = $("#enterpriseId").val();
            var name = $("#enterpriseName").val();
            if (name == '') {
                alert("企业名称不能为空！");
                return false;
            }
            var regaddress = $("#enterpriseRegaddress").val();
            if (regaddress == '') {
                alert("注册地址不能为空！");
                return false;
            }
            var legalman = $("#enterpriseLegalman").val();
            if (legalman == '') {
                alert("法人不能为空！");
                return false;
            }
            var principal = $("#enterprisePrincipal").val();
            if (principal == '') {
                alert("责任人不能为空！");
                return false;
            }
            var phone = $("#enterprisePhone").val();
            var reg1 = /^1[3456789]\d{9}$/;
            if (phone == '') {
                alert("电话不能为空！");
                return false;
            }
            if (!reg1.test(phone)) {
                alert("请填入正确的电话号码！");
                return false;
            }
            var email = $("#enterpriseEmail").val();
            var reg2 = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
            if (email == '') {
                alert("邮箱不能为空！");
                return false;
            }
            if (!reg2.test(email)) {
                alert("请填入正确的邮箱！");
                return false;
            }
            var fund = $("#enterpriseFund").val();
            var reg3 = /^[0-9]*$/;
            if (fund == '') {
                alert("注册资金不能为空！");
                return false;
            }
            if (!reg3.test(fund)) {
                alert("注册资金必须为整数数值！");
                return false;
            }
            var type = $("#enterpriseType").val();
            if (type == '') {
                alert("企业类型不能为空！");
                return false;
            }
            var signtime = $("#enterpriseSigntime").val();
            if (signtime == '') {
                alert("注册时间不能为空！");
                return false;
            }
            var scope = $("#enterpriseScope").val();
            if (scope == '') {
                alert("经营范围不能为空！");
                return false;
            }
            var rank = $("#enterpriseRank").val();
            if (rank == '') {
                alert("企业等级不能为空！");
                return false;
            }
            var conaddress = $("#enterpriseConaddress").val();
            if (conaddress == '') {
                alert("联系地址不能为空！");
                return false;
            }
            var postcode = $("#enterprisePostcode").val();
            var reg4 = /^[1-9]\d{5}$/;
            if (postcode == '') {
                alert("邮编不能为空！");
                return false;
            }
            if (!reg4.test(postcode)) {
                alert("邮政编码格式不正确！");
                return false;
            }
            var account = $("#enterpriseAccount").val();
            if (account == '') {
                alert("开户银行不能为空！");
                return false;
            }
            var intime = $("#enterpriseIntime").val();
            if (intime == '') {
                alert("企业入住时间不能为空！");
                return false;
            }
            $.ajax({
                url: "${pageContext.request.contextPath }/enterprise/insertEnterprise",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"userName":user,"enterpriseId":id, "enterpriseName":name,
                    "enterpriseRegaddress":regaddress, "enterpriseLegalman":legalman,
                    "enterprisePrincipal":principal, "enterprisePhone":phone,
                    "enterpriseEmail":email, "enterpriseFund":fund,
                    "enterpriseType":type, "enterpriseSigntime":signtime,
                    "enterpriseScope":scope, "enterpriseRank":rank,
                    "enterpriseConaddress":conaddress, "enterprisePostcode":postcode,
                    "enterpriseAccount":account, "enterpriseIntime":intime,
                    "username":user},
                dataType: "json",
                success: function (data) {
                    if (data.msg == "no") {
                        alert("该ID已被使用!");
                    } else {
                        var message = confirm("录入成功！是否有附件需要上传?");
                        if (message == false) {
                            window.location.href = "${pageContext.request.contextPath }/enterprise/skipDashboard";
                        }
                    }
                }
            });
        });
        $("#submitFile").click(function (){
            var formData = new FormData();
            formData.append("file", $("#file")[0].files[0]);
            formData.append("enterpriseId",$("#enterpriseId").val());
            $.ajax({
                url: "${pageContext.request.contextPath }/enterprise/uploadFile",
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
                    window.location.href = "${pageContext.request.contextPath }/enterprise/skipDashboard";
                }
            });
        });
    });
</script>
</body>
</html>

