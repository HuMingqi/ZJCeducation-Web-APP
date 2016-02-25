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
	background-image:url('zjc/image/regbg.jpg');
	background-repeat:no-repeat;
	background-position:10% 20%;
	background-size:cover;
}
/* common styling */
/* set up the overall width of the menu div, the font and the margins */
.menu {
font-family: arial, sans-serif; 
width:750px; 
margin-left:955px;
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
	width:91%;
	height:600px;
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
	var str=prompt("请输入家长手机号码查询：","");
	document.getElementById('phone').value=str;
	document.getElementById("B").submit();
}
function modifyState(){
	var str=prompt("更改成交状态：","模式：set order true/false"); //弹出输入框，点击确定接收字符串,取消或叉掉  返回null。
	if(str==null) return;
	var regex=/set ([\d]{1,}) ((true)|(false))/;
	if(regex.test(str)){
	var group=regex.exec(str);	
	document.getElementById('count').value=group[1];
	document.getElementById('state').value=group[2];
	document.getElementById("C").submit();
	}else{
		alert("请按照模式输入——set order true/false");
		modifyState();
	}
}

</script>
</head>
<body onload="brushRed()">
<font face="Tahoma, Geneva, sans-serif" size="+3" color="black">&nbsp;&nbsp;&nbsp;&nbsp;紫金草后台管理系统--></font><font size="+2">家长申请&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font><font size="+1">
<a href="/ZJCeducation/zjc/backstage/index.html">返回</a></font>
<br/>
<hr/>
<div class="menu">
<ul>
<li><a class="hide" href="#">按日期查询</a>
<!--[if lte IE 6]>
<a href="../menu/index.html">DEMOS
<table><tr><td>
<![endif]-->
    <ul>
    <li><a href="/ZJCeducation/readWeekPApply.action" title="The last seven days">最近七日</a></li>
    <li><a href="/ZJCeducation/readCurMonthPApply.action" title="Recently in January">最近一月</a></li>
    <li><a href="/ZJCeducation/readAllPApply.action" title="All orders">所有订单</a></li>
    </ul>
<!--[if lte IE 6]>
</td></tr></table>
</a>
<![endif]-->
</li>
<li><a class="hide" href="#">按状态查询</a>
<!--[if lte IE 6]>
<a href="index.html">MENUS
<table><tr><td>
<![endif]-->
    <ul>
    <li><a href="/ZJCeducation/undonePApply.action" title="undone orders">未成交订单</a></li>
    <li><a href="/ZJCeducation/donePApply.action" title="done orders">已成交订单</a></li>
    
    </ul>
<!--[if lte IE 6]>
</td></tr></table>
</a>
<![endif]-->
</li>
<li><a class="hide" href="#">其他</a>
<!--[if lte IE 6]>
<a href="../menu/index.html">DEMOS
<table><tr><td>
<![endif]-->
    <ul>
    <li><a href="#" title="Query by number" onclick="dlog1()">按编号查询</a></li>
    <!-- <li><a href="#" title="Query by phone number " onclick="dlog2()">按手机号查询</a></li> -->
    <li><a href="#" title="set state" onclick="modifyState()">更改成交状态</a></li>
    </ul>
<!--[if lte IE 6]>
</td></tr></table>
</a>
<![endif]-->
</li>
</ul>
<!-- clear the floats if required -->
<div class="clear"> </div>
</div>

<div  class="contener">
	<table border="1" frame="vsides" cellspacing="0" >
	<tr bgcolor="#669966"><th width="5%" height="40px">订单编号</th><th width="5%" height="40px">家长编号</th><th width="5%" >家长姓名</th><th width="5%" >性别</th><th width="5%" >家教地址</th>
	<th width="5%" >学员姓名</th><th width="5%" >学员性别</th><th width="5%" >学员年级</th><th width="5%" >辅导科目</th><th width="5%" >辅导时间</th>
	<th width="5%" >教员性别</th><th width="5%" >其他要求</th><th width="5%" >联系电话</th><th width="5%" >QQ</th><th width="5%" >邮箱</th><th width="5%" >申请日期</th><th width="5%" >成交状态</th></tr>
	<s:iterator value="PRS" var="apply"> <!-- id/var是元素别名 --> 
    	<tr height=50px><td><s:property value="#apply.count"/></td><td><s:property value="#apply.number"/></td><td><s:property value="#apply.name"/></td><td><s:property value="gender"/></td>
    	<td><s:property value="address"/></td><td><s:property value="childName"/></td><td><s:property value="childGender"/></td><td><s:property value="grade"/></td>
    	<td><s:property value="subject"/></td><td><s:property value="teach_time"/></td><td><s:property value="teacherGender"/></td>
    	<td><s:property value="request"/></td><td><s:property value="phone"/></td><td><s:property value="qq"/></td>
    	<td><s:property value="email"/></td><td><s:property value="apply_date"/></td><td><s:property value="state"/></td>    	
    	</tr>                  
	</s:iterator>	
	</table>	
</div>
<form id="A" action="/ZJCeducation/numberPApply.action" method="post">
<input type="hidden" id="number" name="number"></input>
</form>
<form id="B" action="/ZJCeducation/phonPTApply.action" method="post">
<input type="hidden" id="phone" name="phone"></input>
</form>
<form id="C" action="/ZJCeducation/setPAppState.action" method="post">
<input type="hidden" id="count" name="count"></input>
<input type="hidden" id="state" name="state"></input>
</form>
</body>
</html>
