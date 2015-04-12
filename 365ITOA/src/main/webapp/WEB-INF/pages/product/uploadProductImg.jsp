<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>课程列表</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- Font Awesome Icons -->
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Ionicons -->
    <link href="${pageContext.request.contextPath}/css/ionicons.min.css" rel="stylesheet" type="text/css"/>
    <!-- DATA TABLES -->
    <link href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css" rel="stylesheet"
          type="text/css"/>
    <!-- Theme style -->
    <link href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link href="${pageContext.request.contextPath}/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css"/>
</head>
<body class="skin-blue">
<div class="wrapper">

    <header class="main-header">
        <%@ include file="../common/commonHead.jsp" %>
    </header>


    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <%@ include file="../common/commonMenu.jsp" %>
    </aside>

    <!-- Right side column. Contains the navbar and content of the page -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                课程图片上传
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
                <div class="col-xs-12 col-lg-4">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">课程logo上传</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" action="${pageContext.request.contextPath}/product/uploadProductImg.action"
                              method="post" enctype="multipart/form-data">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="exampleInputFile">课程logo</label>
                                    <input id="exampleInputFile" type="file" name="imgFile">
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <input type="hidden" name="productId" value="${productId}"/>
                                <input type="hidden" name="imgType" value="1"/>
                                <button type="submit" class="btn btn-primary">上传</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /.col -->


                <div class="col-xs-12 col-lg-4">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">课程详情图上传</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" action="${pageContext.request.contextPath}/product/uploadProductImg.action"
                              method="post" enctype="multipart/form-data">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="exampleInputFile">课程详情图</label>
                                    <input id="exampleInputFile" type="file" name="imgFile">
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <input type="hidden" name="productId" value="${productId}"/>
                                <input type="hidden" name="imgType" value="2"/>
                                <button type="submit" class="btn btn-primary">上传</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /.col -->


                <div class="col-xs-12 col-lg-4">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">课程精彩截图上传</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" action="${pageContext.request.contextPath}/product/uploadProductImg.action"
                              method="post" enctype="multipart/form-data">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="exampleInputFile">课程精彩截图</label>
                                    <input id="exampleInputFile" type="file" name="imgFile">
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <input type="hidden" name="productId" value="${productId}"/>
                                <input type="hidden" name="imgType" value="3"/>
                                <button type="submit" class="btn btn-primary">上传</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->


            <div class="row">
                <div class="col-xs-12 col-lg-4">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">课程logo</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <div class="box-body">
                            <div class="row">
                                <c:forEach items="${productImgIdList}" var="productImgId">
                                    <div class="col-xs-12">
                                        <img src="${pageContext.request.contextPath}/product/takeProductImg.action?id=${productImgId}"
                                             style="width: 100%" alt="">
                                    </div>
                                </c:forEach>

                            </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
                <!-- /.col -->


                <div class="col-xs-12 col-lg-4">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">课程详情图</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                            <div class="box-body">
                                <div class="row">
                                    <c:forEach items="${productDetailImgIdList}" var="productDetailImgId">
                                        <div class="col-xs-12">
                                            <img src="${pageContext.request.contextPath}/product/takeProductDatailImg.action?id=${productDetailImgId}"
                                                 style="width: 100%" alt="">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!-- /.box-body -->
                    </div>
                </div>
                <!-- /.col -->


                <div class="col-xs-12 col-lg-4">
                    <div class="box box-primary">
                        <div class="box-header">
                            <h3 class="box-title">课程精彩截图</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                            <div class="box-body">
                                <div class="row">
                                    <c:forEach items="${productGreateImgIdList}" var="productGreateImgId">
                                        <div class="col-xs-12">
                                            <img src="${pageContext.request.contextPath}/product/takeProductGreateImg.action?id=${productGreateImgId}"
                                                 style="width: 100%" alt="">
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!-- /.box-body -->
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <%@ include file="../common/commonFooter.jsp" %>
    </footer>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.1.3 -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jQuery-2.1.3.min.js"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<!-- DATA TABES SCRIPT -->
<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.js"
        type="text/javascript"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"
        type="text/javascript"></script>
<!-- FastClick -->
<script src='${pageContext.request.contextPath}/plugins/fastclick/fastclick.min.js'></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/app.min.js" type="text/javascript"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/dist/js/demo.js" type="text/javascript"></script>

</body>
</html>