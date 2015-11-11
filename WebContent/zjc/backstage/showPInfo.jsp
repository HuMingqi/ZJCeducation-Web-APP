<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>家长申请</title>
<style type="text/css">
body {
	font-size: 14px;
 	font-family: "宋体";
	background-image:url('/ZJCeducation/zjc/image/regbg.jpg');
	background-repeat:no-repeat;
	background-position:10% 20%;
	background-size:cover;
}
/* common styling */
/* set up the overall width of the menu div, the font and the margins */
.menu {
font-family: arial, sans-serif; 
width:750px; 
margin-left:1168px;
float:left
}
/* remove the bullets and set the margin and padding to zero for the unordered list */
.menu ul {
padding:0; 
margin:0;
list-style-type: none;
}
/* float the list so that the items are in a line and their position relative so that the drop down list will appear in the right place underneath each list item */
.menu ul li {
float:left; 
position:relative;
}
/* style the links to be 104px wide by 30px high with a top and right border 1px solid white. Set the background color and the font size. */
.menu ul li a, .menu ul li a:visited {
display:block; 
text-align:center; 
text-decoration:none; 
width:104px; 
height:30px; 
color:#000; 
border:1px solid #fff;
border-width:1px 1px 0 0;
background:aqua; 
line-height:30px; 
font-size:11px;
}
/* make the dropdown ul invisible */
.menu ul li ul {
display: none;
}
/* specific to non IE browsers */
/* set the background and foreground color of the main menu li on hover */
.menu ul li:hover a {
color:#fff; 
background:#b3ab79;
}
/* make the sub menu ul visible and position it beneath the main menu list item */
.menu ul li:hover ul {
display:block; 
position:absolute; 
top:31px; 
left:0; 
width:105px;
}
/* style the background and foreground color of the submenu links */
.menu ul li:hover ul li a {
display:block; 
background:#faeec7; 
color:#000;
}
/* style the background and forground colors of the links on hover */
.menu ul li:hover ul li a:hover {
background:#dfc184; 
color:#000;
}
.contener{
	width:90%;
	height:500px;
	float:left;
	border:solid;
	border-width:2px;
	border-color:black;
	margin-left:50px;
}


.table1{
	margin-top:1px;
	border-style:double;
	border-width:1px;
	border-color:#000;
}
.a{
	float:right; margin-top:20px; margin-bottom:20px;}
</style>
<script language="javascript">
function dlog1(){
	var str=prompt("请输入家长编号查询：","六位编号，非零数字开头"); //弹出输入框，点击确定接收字符串,取消或叉掉  返回null。
	if(str==null) return;
	var regex=/[1-9][\d]{5}/;
	if(regex.test(str)&&str.length==6){
	document.getElementById('number').value=str;
	document.getElementById("A").submit();
	}else{
		alert("请输入六位编号，非零数字开头！");
		dlog1();
	}
}
function dlog2(){
	var str=prompt("请输入家长手机号码查询：","11位数字"); //弹出输入框，点击确定接收字符串,取消或叉掉  返回null。
	if(str==null) return;
	var regex=/[\d]{11}/;
	if(regex.test(str)&&str.length==11){
	document.getElementById('phone').value=str;
	document.getElementById("B").submit();
	}else{
		alert("输入错误，请输入11位手机号码！");
		dlog2();
	}
}
</script>
</head>
<body>
<font face="Tahoma, Geneva, sans-serif" size="+3" color="black">&nbsp;&nbsp;&nbsp;&nbsp;紫金草后台管理系统--></font><font size="+2">家长信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font size="+1">
<a href="/ZJCeducation/zjc/backstage/index.html">返回</a></font>
<br/>
<hr/>
<div class="menu">
<ul>
    <li><a class="hide" href="#">按ID查询</a>
    <ul>
    <li><a href="#" title="Query by number" onclick="dlog1()">按编号查询</a></li>
    <li><a href="#" title="Query by phone number " onclick="dlog2()">按手机号查询</a></li>
    </ul>
</li>
</ul>
<!-- clear the floats if required -->
<div class="clear"> </div>
</div>

<div  class="contener">
	<table border="1" frame="vsides" cellspacing="0" >
		<tr bgcolor="#669966"><th width="140px" height="40px">家长编号</th><th width="140px" >昵称</th><th width="140px" >家长姓名</th><th width="140px" >性别</th><th width="140px" >家庭地址</th>
		<th width="140px" >联系电话</th><th width="140px" >QQ</th><th width="140px">邮箱</th><th width="140px">注册日期</th></tr>
		<tr>
			<td height="50px">${parents_info.number}</td><td height="50px">${parents_info.nickname}</td><td height="50px">${parents_info.name}</td>
			<td height="50px">${parents_info.gender}</td><td height="50px">${parents_info.address}</td>
			<td height="50px">${parents_info.phone}</td><td height="50px">${parents_info.qq}</td><td height="50px">${parents_info.email}</td><td height="50px">${parents_info.register_date}</td>
		</tr>		
	</table>	
</div>
<form id="A" action="/ZJCeducation/numberPInfo.action" method="post">
<input type="hidden" id="number" name="number"></input>
</form>
<form id="B" action="/ZJCeducation/phonePInfo.action" method="post">
<input type="hidden" id="phone" name="phone"></input>
</form>
</body>
</html>
