<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/21
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head.jsp"%>
<!-- 左侧导航栏 -->
<div id="sidebar-nav" class="sidebar">
    <div class="sidebar-scroll">
        <nav>
            <ul class="nav">
                <li><a class="active"><i class="lnr lnr-home"></i> <span><strong>角色申请</strong></span></a></li>
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
                            <div class="profile-main" style="height: 440px">
                                <div style="margin-top: 100px">
                                    <h1 style="color: white; font-size: 80px">${initial}</h1>
                                    <h3 class="name">${user.username}</h3>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="profile-right">
                        <div id="information" style="display: block">
                            <div class="custom-tabs-line tabs-line-bottom left-aligned">
                                <ul class="nav" role="tablist">
                                    <li class="active"><a href="#tab-bottom-left1" role="tab" data-toggle="tab">角色申请</a></li>
                                </ul>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane fade in active" id="tab-bottom-left1">
                                    <div class="row">
                                        <form>
                                            <input type="hidden" class="form-control" placeholder="id" name="" value="${user.id}" id="id">
                                            <input type="hidden" class="form-control" placeholder="用户名" name="" value="${user.username}" id="username">
                                            <input type="hidden" class="form-control" placeholder="密码" name="" value="${user.password}" id="password">
                                            <input type="text" class="form-control" placeholder="邮箱" name="" id="email">
                                            <br>
                                            <input type="text" class="form-control" placeholder="电话" name="" id="phone">
                                            <br>
                                            <input type="text" class="form-control" placeholder="隶属单位" name="" id="unit">
                                            <br>
                                            <p>申请角色：</p>
                                            <select class="form-control" name="" id="role_id">
                                                <option value="1">企业业务员</option>
                                                <option value="2">政府审批员</option>
                                                <option value="3">档案局人员</option>
                                                <option value="4">高新区工作人员</option>
                                                <option value="5">固定资产评估员</option>
                                                <option value="6">领导</option>
                                                <option value="7">超级管理员</option>
                                            </select>
                                            <br><br>
                                            <div class=" text-center">
                                                <a type="submit" class="btn btn-success" id="submitForm">
                                                    <i class="fa fa-check-circle"></i>
                                                    申请
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
</div>
<!-- Javascript -->
<script src="${pageContext.request.contextPath }/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/vendor/chartist/js/chartist.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#submitForm").click(function () {
            var id = $("#id").val();
            var username = $("#username").val();
            var password = $("#password").val();
            var email = $("#email").val();
            var phone = $("#phone").val();
            var unit = $("#unit").val();
            var role_id = $("#role_id").val();
            $.ajax({
                url: "${pageContext.request.contextPath }/user/apply",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                type: "post",
                data: {"id":id,"username":username,
                    "password":password,"email":email,
                    "phone":phone,"unit":unit,"role_id":role_id},
                dataType: "json",
                success: function (data) {
                    if (data.msg == "success") {
                        alert("申请成功，请耐心等待审批！");
                    } else {
                        alert("已经存在一份申请，请耐心等待审批！");
                        return false;
                    }
                }
            });
        });
    });
</script>
</body>
</html>
