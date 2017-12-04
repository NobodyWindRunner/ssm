<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>无权限页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path%>/skin/default/style.css" rel="stylesheet" type="text/css" />
    <link href="<%=path%>/js/artDialog/skins/default.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/artDialog/artDialog.js"></script>
    <script type="text/javascript" src="<%=path%>/js/sys_dialog.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		${message}
	});
	$(function () {
        //检测IE
        if ('undefined' == typeof (document.body.style.maxHeight)) {
            window.location.href = 'ie6update.html';
        }
    });
    </script>
  <body>
  <h1>没有权限</h1>
  </body>
</html>
