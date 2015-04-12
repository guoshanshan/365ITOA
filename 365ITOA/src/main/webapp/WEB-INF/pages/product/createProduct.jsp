<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>新增课程</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="${pageContext.request.contextPath}/css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- daterange picker -->
    <link href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
    <!-- iCheck for checkboxes and radio inputs -->
    <link href="${pageContext.request.contextPath}/plugins/iCheck/all.css" rel="stylesheet" type="text/css" />
    <!-- Bootstrap Color Picker -->
    <link href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet"/>
    <!-- Bootstrap time Picker -->
    <link href="${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css" rel="stylesheet"/>
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath}/plugins/iCheck/all.css" rel="stylesheet" type="text/css" />
</head>
<body class="skin-blue">
<div class="wrapper">

    <header class="main-header">
        <%@ include file="../common/commonHead.jsp"%>
    </header>



    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <%@ include file="../common/commonMenu.jsp"%>
    </aside>

    <!-- Right side column. Contains the navbar and content of the page -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                课程基本信息
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li><a href="#">Tables</a></li>
                <li class="active">Data tables</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <form action="${pageContext.request.contextPath}/product/saveProduct.action" method="post" role="form">
                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">所有课程</h3>
                            </div><!-- /.box-header -->
                            <div class="box-body">


                                <div class="col-xs-6 col-md-3">

                                    <div class="form-group">
                                        <label>课程名称</label>
                                        <input class="form-control" type="text" name="productName"">
                                    </div>
                                </div>


                                <div class="col-xs-6 col-md-3">
                                    <div class="form-group">
                                        <label>课程价格</label>
                                        <input class="form-control" type="text" name="productPrice">
                                    </div>

                                </div>

                                <div class="col-xs-6 col-md-3">
                                    <div class="form-group">
                                        <label>上线时间</label>
                                        <input class="form-control" type="text" name="onlineTime"/>
                                    </div>
                                </div>


                                <div class="col-xs-6 col-md-3">
                                    <div class="form-group">
                                        <label>下线时间</label>
                                        <input class="form-control" type="text" name="offlineTime"/>
                                    </div>
                                </div>

                                <div class="col-xs-6 col-md-3">
                                    <div class="form-group">
                                        <label>网盘地址</label>
                                        <input class="form-control" type="text" name="cloudeUrl">
                                    </div>
                                </div>


                                <div class="col-xs-6 col-md-3">
                                    <div class="form-group">
                                        <label>网盘提取码</label>
                                        <input class="form-control" type="text" name="cloudeCode">
                                    </div>
                                </div>


                                <div class="col-xs-6 col-md-3">
                                    <div class="form-group">
                                        <label>课程状态</label>
                                        <select class="form-control" name="status" >
                                            <c:forEach items="${productStatusDicList}" var="productStatusDic">
                                                    <option value="${productStatusDic.dicCode}">${productStatusDic.dicCn}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-xs-6 col-md-3">
                                    <div class="form-group">
                                        <label>课程更新时间</label>
                                        <input class="form-control" type="text" name="updateDate"/>
                                    </div>
                                </div>


                                <div class="col-xs-12">
                                    <div class="form-group">
                                        <label for="intro">课程简介</label>
                                        <textarea id="intro" class="form-control" rows="3" name="productIntroduction"></textarea>
                                    </div>
                                </div>

                                <div class="col-xs-12">
                                    <div class="form-group">
                                        <label for="desc">课程描述</label>
                                        <textarea id="desc" class="form-control" rows="3" name="productDesc"></textarea>
                                    </div>
                                </div>
                            </div><!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">保存课程</button>
                            </div>
                        </div><!-- /.box -->
                    </form>



                </div><!-- /.col -->
            </div><!-- /.row -->
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <footer class="main-footer">
        <%@ include file="../common/commonFooter.jsp"%>
    </footer>
</div><!-- ./wrapper -->

<!-- jQuery 2.1.3 -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jQuery-2.1.3.min.js"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!-- InputMask -->
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js" type="text/javascript"></script>
<!-- date-range-picker -->
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
<!-- bootstrap color picker -->
<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js" type="text/javascript"></script>
<!-- bootstrap time picker -->
<script src="${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js" type="text/javascript"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<!-- iCheck 1.0.1 -->
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
<!-- FastClick -->
<script src='${pageContext.request.contextPath}/plugins/fastclick/fastclick.min.js'></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/app.min.js" type="text/javascript"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/dist/js/demo.js" type="text/javascript"></script>
</body>
</html>