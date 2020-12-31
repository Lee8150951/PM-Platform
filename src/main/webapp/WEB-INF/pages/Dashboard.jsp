<%--
  Created by IntelliJ IDEA.
  User: 61958
  Date: 2020/3/21
  Time: 13:47
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
            <!-- 图表展示总体层 -->
            <div class="panel panel-headline">
                <div class="panel-heading">
                    <h3 class="panel-title" id="greet"></h3>
                    <script type="text/javascript" language="javascript">
                        function showGreet() {
                            // 获取当前是日期
                            var greet_date_time = new Date();
                            // 获取当前时
                            var greet_hours = greet_date_time.getHours();
                            // 判断时间的时间段
                            if (greet_hours > 6 && greet_hours < 11) {
                                document.getElementById("greet").innerHTML = "早上好！<shiro:principal/>";
                            } else if (greet_hours >= 11 && greet_hours < 14){
                                document.getElementById("greet").innerHTML = "中午好！<shiro:principal/>";
                            } else if (greet_hours >= 14 && greet_hours < 19){
                                document.getElementById("greet").innerHTML = "下午好！<shiro:principal/>";
                            } else if (greet_hours >= 19 && greet_hours < 24){
                                document.getElementById("greet").innerHTML = "晚上好！<shiro:principal/>";
                            } else if (greet_hours >= 0 && greet_hours < 6){
                                document.getElementById("greet").innerHTML = "凌晨好！<shiro:principal/>";
                            } else {
                                document.getElementById("greet").innerHTML = "您好！<shiro:principal/>";
                            }
                        }
                        // 每一秒调用一次
                        setInterval("showGreet()", 100);
                    </script>
                    <p class="panel-subtitle" id="timer"></p>
                    <script type="text/javascript" language="javascript">
                        function showTimes() {
                            // 获取当前是日期
                            var date_time = new Date();
                            // 星期
                            var week;
                            // switch判断
                            switch (date_time.getDay()) {
                                case 1: week="Mon."; break;
                                case 2: week="Tue."; break;
                                case 3: week="Wed."; break;
                                case 4: week="Thu."; break;
                                case 5: week="Fri."; break;
                                case 6: week="Sat."; break;
                                default: week="Sun."; break;
                            }
                            // 年
                            var year = date_time.getFullYear();
                            // 月
                            var month = date_time.getMonth() + 1;
                            // 判断小于10，前面补0
                            if (month < 10) {
                                month = "0" + month;
                            }
                            // 日
                            var day = date_time.getDate();
                            // 判断小于10，前面补0
                            if (day < 10) {
                                day = "0" + day;
                            }
                            // 时
                            var hours = date_time.getHours();
                            // 判断小于10，前面补0
                            if (hours < 10) {
                                hours = "0" + hours;
                            }
                            // 分
                            var minutes = date_time.getMinutes();
                            // 判断小于10，前面补0
                            if (minutes < 10) {
                                minutes = "0" + minutes;
                            }
                            // 拼接
                            var date_str = year + "年" + month + "月" + day + "日" + hours + ":" + minutes + " " + week;
                            // 展示
                            document.getElementById("timer").innerHTML = date_str;
                        }
                        // 每一秒调用一次
                        setInterval("showTimes()", 100);
                    </script>
                </div>
                <div class="panel-body">
                    <shiro:hasAnyRoles name="examine, file, servant, assess, leader, admin">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-star"></i></span>
                                    <p>
                                        <span class="number" id="inEnter"></span>
                                        <span class="title">入驻企业</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-hourglass"></i></span>
                                    <p>
                                        <span class="number" id="waitEnter"></span>
                                        <span class="title">待处理企业</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-check-square-o"></i></span>
                                    <p>
                                        <span class="number" id="comEnter"></span>
                                        <span class="title">已完成企业</span>
                                    </p>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="metric">
                                    <span class="icon"><i class="fa fa-rmb"></i></span>
                                    <p>
                                        <span class="number" id="comMoney"></span>
                                        <span class="title">总扶持金额</span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="examine, file, servant, assess, leader, admin">
                        <div class="row">
                            <div class="col-md-5" style="margin-top: -100px">
                                <div id="enterpriseType" style="width: 650px;height:450px;"></div>
                            </div>
                            <div class="col-md-6" style="margin-top: -100px">
                                <div id="enterpriseScope" style="width: 650px;height:450px;"></div>
                            </div>
                        </div>
                    </shiro:hasAnyRoles>
                    <shiro:hasRole name="clerk">
                        <div class="row" style="margin-left: 30px">
                            <div class="col-md-1 col-sm-6">
                                <div class="award-item">
                                    <div class="hexagon">
                                        <span class="lnr lnr-exit-up award-icon"></span>
                                    </div>
                                    <span>企业信息上传</span>
                                </div>
                            </div>
                            <div class="col-md-1" style="border-bottom: 3px solid #eaeaea; margin-top: 60px; margin-left: 28px"></div>
                            <div class="col-md-1 col-sm-6">
                                <div class="award-item">
                                    <div class="hexagon">
                                        <span class="lnr lnr-pencil award-icon"></span>
                                    </div>
                                    <span>固定资产评估</span>
                                </div>
                            </div>
                            <div class="col-md-1" style="border-bottom: 3px solid #eaeaea; margin-top: 60px; margin-left: 28px"></div>
                            <div class="col-md-1 col-sm-6">
                                <div class="award-item">
                                    <div class="hexagon">
                                        <span class="lnr lnr-file-add award-icon"></span>
                                    </div>
                                    <span>政策申请</span>
                                </div>
                            </div>
                            <div class="col-md-1" style="border-bottom: 3px solid #eaeaea; margin-top: 60px; margin-left: 28px"></div>
                            <div class="col-md-1 col-sm-6">
                                <div class="award-item">
                                    <div class="hexagon">
                                        <span class="lnr lnr-eye award-icon"></span>
                                    </div>
                                    <span>申请政策审批</span>
                                </div>
                            </div>
                            <div class="col-md-1" style="border-bottom: 3px solid #eaeaea; margin-top: 60px; margin-left: 28px"></div>
                            <div class="col-md-1 col-sm-6">
                                <div class="award-item">
                                    <div class="hexagon">
                                        <span class="lnr lnr-spell-check award-icon"></span>
                                    </div>
                                    <span>领导批阅</span>
                                </div>
                            </div>
                        </div>
                    </shiro:hasRole>
                </div>
            </div>
            <shiro:hasAnyRoles name="examine, file, servant, assess, leader, admin">
                <div class="row">
                    <div class="col-md-7">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">企业枚举</h3>
                            </div>
                            <div class="panel-body no-padding">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>名称</th>
                                            <th>法人</th>
                                            <th>企业类型</th>
                                            <th>经营范围</th>
                                        </tr>
                                    </thead>
                                    <tbody id="enumerate">
                                    </tbody>
                                </table>
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <shiro:hasAnyRoles name="servant, leader">
                                        <div class="col-md-6 text-right" style="float: right">
                                            <a href="${pageContext.request.contextPath }/enterprise/getAllInfo" class="btn btn-primary">查看所有</a>
                                        </div>
                                    </shiro:hasAnyRoles>
                                    <shiro:hasAnyRoles name="file, examine, assess">
                                        <div class="col-md-6 text-right" style="float: right">
                                            <button class="btn btn-warning" disabled="disabled">查看所有</button>
                                        </div>
                                    </shiro:hasAnyRoles>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">企业评级</h3>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-6" style="margin-top: -90px; margin-left: -70px;">
                                    <div id="enterpriseRank" style="width: 550px;height:340px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </shiro:hasAnyRoles>
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
    $.ajax({
        method:"post",
        url: "${pageContext.request.contextPath }/user/storeSession",
        dataType: "json",
        success: function (data) {
            var obj_1 = document.getElementById("inEnter");
            obj_1.innerHTML= data.data_1 + "家";
            var obj_2 = document.getElementById("waitEnter");
            obj_2.innerHTML= data.data_4 + "家";
            var obj_3 = document.getElementById("comEnter");
            obj_3.innerHTML= data.data_2 + "家";
            var obj_4 = document.getElementById("comMoney");
            obj_4.innerHTML= data.data_3 + "元";
        }
    })
</script>
<script type="text/javascript">
    $.ajax({
        method:"post",
        url: "${pageContext.request.contextPath }/user/getCount",
        dataType: "json",
        success: function (data) {
            initEnterprise(data)
        }
    });
    function initEnterprise(data) {
        // 基于准备好的dom，初始化ECharts实例
        var myChart = echarts.init(document.getElementById('enterpriseType'), 'light');
        // 解析data
        var arr = [];
        if (data) {
            for (var i=0; i<data.listCont.length; i++) {
                arr.push({
                    name : data.listName[i],
                    value : data.listCont[i]
                })
            }
        }
        var app = {};
        option = null;
        // 指定图表的配置项和数据
        var option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            series : [
                {
                    name: '企业类型',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    roseType: 'angle',
                    data: arr,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        app.currentIndex = -1;
        setInterval(function () {
            var dataLen = option.series[0].data.length;
            // 取消之前高亮的图形
            myChart.dispatchAction({
                type: 'downplay',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
            app.currentIndex = (app.currentIndex + 1) % dataLen;
            // 高亮当前图形
            myChart.dispatchAction({
                type: 'highlight',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
            // 显示 tooltip
            myChart.dispatchAction({
                type: 'showTip',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
        }, 1000);
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    }
</script>
<script type="text/javascript">
    $.ajax({
        method:"post",
        url: "${pageContext.request.contextPath }/user/getScope",
        dataType: "json",
        success: function (data) {
            initScope(data)
        }
    });
    function initScope(data) {
        // 基于准备好的dom，初始化ECharts实例
        var myChart = echarts.init(document.getElementById('enterpriseScope'), 'light');
        // 解析data
        var arr = [];
        if (data) {
            for (var i=0; i<data.listCont.length; i++) {
                arr.push({
                    name : data.listName[i],
                    value : data.listCont[i]
                })
            }
        }
        var app = {};
        option = null;
        // 指定图表的配置项和数据
        var option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            series : [
                {
                    name: '经营范围',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    roseType: 'angle',
                    data: arr,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        app.currentIndex = -1;
        setInterval(function () {
            var dataLen = option.series[0].data.length;
            // 取消之前高亮的图形
            myChart.dispatchAction({
                type: 'downplay',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
            app.currentIndex = (app.currentIndex + 1) % dataLen;
            // 高亮当前图形
            myChart.dispatchAction({
                type: 'highlight',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
            // 显示 tooltip
            myChart.dispatchAction({
                type: 'showTip',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
        }, 1000);
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    }
</script>
<script type="text/javascript">
    $.ajax({
        method:"post",
        url: "${pageContext.request.contextPath }/user/getAll",
        dataType: "json",
        async: false,
        success: function (data) {
            var i;
            for (i = 0; i < 4; i++) {
                tr = '<td>'+data.list[i].enterpriseId+'</td>'
                    +'<td>'+data.list[i].enterpriseName+'</td>'
                    +'<td>'+data.list[i].enterpriseLegalman+'</td>'
                    +'<td>'+data.list[i].enterpriseType+'</td>'
                    +'<td>'+data.list[i].enterpriseScope+'</td>';
                $("#enumerate").append('<tr>'+tr+'</tr>')
            }
        }
    });
</script>
<script type="text/javascript">
    $.ajax({
        method:"post",
        url: "${pageContext.request.contextPath }/user/getRank",
        dataType: "json",
        success: function (data) {
            Rank(data)
        }
    });
    function Rank(data) {
        // 基于准备好的dom，初始化ECharts实例
        var myChart = echarts.init(document.getElementById('enterpriseRank'), 'light');
        // 解析data
        var arr = [];
        if (data) {
            for (var i=0; i<data.listCont.length; i++) {
                arr.push({
                    name : data.listName[i],
                    value : data.listCont[i]
                })
            }
        }
        var app = {};
        option = null;
        // 指定图表的配置项和数据
        var option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            series : [
                {
                    name: '企业等级',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    roseType: 'angle',
                    data: arr,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        app.currentIndex = -1;
        setInterval(function () {
            var dataLen = option.series[0].data.length;
            // 取消之前高亮的图形
            myChart.dispatchAction({
                type: 'downplay',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
            app.currentIndex = (app.currentIndex + 1) % dataLen;
            // 高亮当前图形
            myChart.dispatchAction({
                type: 'highlight',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
            // 显示 tooltip
            myChart.dispatchAction({
                type: 'showTip',
                seriesIndex: 0,
                dataIndex: app.currentIndex
            });
        }, 1000);
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    }
</script>
</body>
</html>
