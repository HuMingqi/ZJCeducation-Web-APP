<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册成功</title>
<style>
body {
	font-size: 14px;
 	font-family: "宋体";
	background-image:url('zjc/image/regsuss.jpg');
	background-repeat:no-repeat;
	background-position:10% 20%;
	background-size:cover;
}
</style>
</head>
<body>
	<font color="ffcc00" size="+1">&nbsp;&nbsp;紫金草家教网</font>
	<br/><br/><br/> <br/> <br/>
	<h1 align="center">注册成功，您的教员编号——${teacher_number}</h1>
    <br/>
    <h2 align="center">恭喜您，成为本站会员！！</h2>	
    <br/>
    <p align="center"><a href="/ZJCeducation/zjc/login.html">立即登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;返回<a href="/ZJCeducation/zjc/FEduCenter/index.html">家教中心</a>!</p>
</body>
</html>