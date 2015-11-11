<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>个人中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="description" content="Pretty Simple Content Slider with jQuery and CSS3" />
<meta name="keywords" content="jquery,css3, content slider, slide, auto-play"/>
<link rel="stylesheet" href="/ZJCeducation/zjc/parentsCenter/css/style.css" type="text/css" media="screen"/>
<style>
* { margin:0; padding:0; }
body { font-family:Arial; background:#C1C7D5 url('/ZJCeducation/zjc/parentsCenter/title.png') no-repeat top center; }
a.back { background:transparent url('/ZJCeducation/zjc/parentsCenter/back.png') no-repeat top left; position:fixed; width:150px; height:27px; outline:none; bottom:0px; left:0px; }
#content { margin:150px auto 10px auto;width:800px;height:800px; }
.reference { clear:both; width:800px; margin:30px auto; }
.reference p a { text-transform:uppercase; text-shadow:1px 1px 1px #fff; color:#666; text-decoration:none; font-size:10px; }
.reference p a:hover { color:#333; }
</style>
<script>
function okHandle(){
	if(document.form1.nickname.value==""){
		alert("请输入用户名！");
	}else if(document.getElementById('address').value==""){
		alert("请输入住址！");
	}else if(document.getElementById('phone').value==""){
		alert("请输入联系电话！");
	}else if(document.getElementById('qq').value==""){
		alert("请输入QQ号！");
	}else if(document.getElementById('email').value==""){
		alert("请输入Email！");
	}
}
  function regex(obj,regex,prompt){
 //在JavaScript中，正则表达式使用"/"开头和结束,一个正则常量
  if(obj.value==""){
    alert("内容不能为空！");obj.focus();
  }else{
    if(!regex.test(obj.value)){   
      alert(prompt);
      obj.focus();  
    }
  }
} 
  function equals(id1,id2){
		var e1=document.getElementById(id1);
		var e2=document.getElementById(id2);
		if(e1.value==''||e2.value==''){
			alert("请输入密码！");
		}else if(e1.value!=e2.value){
			alert("两次输入密码不一致！");
		}
	} 
</script>
</head>
<body>
<div id="content"> <a class="" href=""></a>
  <div class="rotator">
    <ul id="rotmenu">
      <li> <a href="rot1">个人资料</a>
        <div style="display:none;">
          <div class="info_image">1.jpg</div>
          <div class="info_heading">个人资料</div>
          <div class="info_description">
                                     用户名：${parentsInfo.nickname}<br />   <!--<s:property value="#parentsInfo.nickname"/>空结果 -->
                                      家长编号：${parentsInfo.number}<br />
                                      性别：${parentsInfo.gender}<br />
                                      住址：${parentsInfo.address}<br />
       <!-- 学员性别：${parentsApply.child_gender}<br /> 
                                      学员年级：${parentsApply.child_grade}<br />
                                      薄弱科目：${parentsApply.subject}<br />		-->  
                                      联系电话：${parentsInfo.phone}<br/>
             QQ: ${parentsInfo.qq}<br/>
                                      邮箱：${parentsInfo.email}<br/>
          
          </div>
        </div>
      </li>
      <li> <a href="rot2">编辑资料</a>
        <div style="display:none;">
          <div class="info_image">2.jpg</div>
          <div class="info_heading">编辑资料</div>
          <div class="info_description"> 
            <form action="/ZJCeducation/parents/editPersonalData.action" method="post" name="form1">
                                    <p>用户名：<input name="parentsInfo.nickname" id="nickname" type="text" size="20" maxlength="15" value="${parentsInfo.nickname}" onBlur="regex(this,/[\w\u4E00-\u9FA5]{4,15}/,'请按照格式填写!\n只能使用字母，数字，下划线和汉字,长度4-15个字符')" onclick="this.value=''" /></p>                                                                                                                                              
                                    <p>性别：&nbsp;&nbsp;&nbsp;<input name="parentsInfo.gender" id="gender" type="radio" value="男" checked="checked"/>男<input name="parentsInfo.gender" type="radio" value="女"/>女</p>                                                                
                                    <p>住址：&nbsp;&nbsp;&nbsp;<input name="parentsInfo.address" id="address" type="text" value="${parentsInfo.address}" onclick="this.value=''" onblur="regex(this,/.+/,'地址不能为空！')"/></p>
                                <!--<p>学员性别：<input name="parentsInfo.child_gender" id="child_gender" type="radio" value="男" checked="checked"/>男<input name="parentsInfo.child_gender" type="radio" value="女"/>女</p>
                                    <p>学员年级：<select name="parentsInfo.child_grade" ><option value="小学" selected="selected">小学</option><option value="初一/二">初一/二</option><option value="初三">初三</option><option value="高一/二">高一/二</option><option value="高三">高三</option></select></p>
                                    <p>薄弱科目：<input type="checkbox" name="parentsApply.subject" value="语文" onClick="countChoices(this)" />语文<input type="checkbox" name="parentsApply.subject" value="数学" onClick="countChoices(this)" />数学<input type="checkbox" name="parentsApply.subject" value="英语" onClick="countChoices(this)" />英语<input type="checkbox" name="parentsApply.subject" value="物理"  onClick="countChoices(this)"/>物理<input type="checkbox" name="parentsApply.subject" value="化学" onClick="countChoices(this)" />化学<input type="checkbox" name="parentsApply.subject" value="生物" onClick="countChoices(this)" />生物<input type="checkbox" name="parentsApply.subject" value="政治" onClick="countChoices(this)"/>政治<input type="checkbox" name="parentsApply.subject" value="历史" onClick="countChoices(this)"/>历史<input type="checkbox" name="parentsApply.subject" value="地理" onClick="countChoices(this)" />地理                                
                                --> <p>联系电话：<input id="phone" name="parentsInfo.phone" onblur="regex(this,/[\d]{11}/,'请输入11位手机号')" type="text" size="20" maxlength="15" value="${parentsInfo.phone}" onclick="this.value=''"/></p>
                                    <p>QQ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input name="parentsInfo.qq" id="qq" type="text" size="20" maxlength="10" value="${parentsInfo.qq}" onBlur="regex(this,/[1-9][0-9]{4,}/,'请填写真实的QQ！\n至少5位数字')" onclick="this.value=''"/></p>
                                    <p>邮箱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input name="parentsInfo.email" id="email" type="text" size="20" maxlength="30" value="${parentsInfo.email}" onBlur="regex(this,/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/,'请填写正确的邮箱地址！')" onclick="this.value=''"/></p>  
                                    <br/><br/>

                  <p><input type="submit" value="提交" onmouseover="okHandle()" />&nbsp;&nbsp;<input type="reset" name="reset" value="重置"/></p>
                  </form> 
            </div>
        </div>
      </li>
      <li> <a href="rot3">请家教</a>
        <div style="display:none;">
          <div class="info_image">3.jpg</div>
          <div class="info_heading">请家教</div>
          <div class="info_description"> 
          <a href="/ZJCeducation/parents/findTutor.action" class="more"><font size="+1">点击去请家教！</font></a> 
          </div>
        </div>
      </li>
      <li> <a href="rot4">家教中心</a>
        <div style="display:none;">
          <div class="info_image">4.jpg</div>
          <div class="info_heading">家教中心</div>
          <div class="info_description">
          <a href="/ZJCeducation/zjc/FEduCenter/index.html" class="more"><font size="+1">点击去家教中心！</font></a> 
          </div>
        </div>
      </li>
      <li> <a href="rot5">安全中心</a>
        <div style="display:none;">
          <div class="info_image">5.jpg</div>
          <div class="info_heading">安全中心</div>
          <div class="info_description">
            <form action="/ZJCeducation/parents/changePassword.action" method="post">
                  <p>新的密码：<input id="pass1" name="parentsInfo.password" type="password" onblur="regex(this,/[a-zA-Z0-9]{6,15}/,'请注意密码格式：6—15位字母、数字组合，区分大小写！')" /></p>
                  <p>确认密码：<input id="pass2" type="password" /></p>
                  <br/>
                  <p><input type="submit" value="提交"/>&nbsp;&nbsp;<input type="reset" value="重置"/>
                </form>      
          </div>
        </div>
      </li>
    </ul>
    <div id="rot1"> <img src="" width="800" height="184" class="bg" alt=""/>
     <div class="heading">
        <h1></h1>
      </div>
      <div class="description">
        <p><font size="+2" color="#ff6600">紫金草家教——家长中心</font></p>
      </div>
    </div>
  </div>
</div>
<!-- The JavaScript -->
<script type="text/javascript" src="/ZJCeducation/zjc/parentsCenter/jquery.min.js"></script>
<script type="text/javascript" src="/ZJCeducation/zjc/parentsCenter/jquery.easing.1.3.js"></script>
<script type="text/javascript">
            $(function() {
                var current = 1;
                
                var iterate		= function(){
                    var i = parseInt(current+1);
                    var lis = $('#rotmenu').children('li').size();
                    if(i>lis) i = 1;
                    display($('#rotmenu li:nth-child('+i+')'));
                }
                //display($('#rotmenu li:first'));
                var slidetime = setInterval(iterate,3000);
				
                $('#rotmenu li').bind('click',function(e){
                    clearTimeout(slidetime);
                    display($(this));
                    e.preventDefault();
                });
				
                function display(elem){
                    var $this 	= elem;
                    var repeat 	= false;
                    if(current == parseInt($this.index() + 1))
                        repeat = true;
					
                    if(!repeat)
                        $this.parent().find('li:nth-child('+current+') a').stop(true,true).animate({'marginRight':'-20px'},300,function(){
                            $(this).animate({'opacity':'0.7'},700);
                        });
					
                    current = parseInt($this.index() + 1);
					
                    var elem = $('a',$this);
                    
                        elem.stop(true,true).animate({'marginRight':'0px','opacity':'1.0'},300);
					
                    var info_elem = elem.next();
                    $('#rot1 .heading').animate({'left':'-420px'}, 500,'easeOutCirc',function(){
                        $('h1',$(this)).html(info_elem.find('.info_heading').html());
                        $(this).animate({'left':'0px'},400,'easeInOutQuad');
                    });
					
                    $('#rot1 .description').animate({'bottom':'-270px'},500,'easeOutCirc',function(){
                        $('p',$(this)).html(info_elem.find('.info_description').html());
                        $(this).animate({'bottom':'0px'},400,'easeInOutQuad');
                    })
                    $('#rot1').prepend(
                    $('<img/>',{
                        style	:	'opacity:0',
                        className : 'bg'
                    }).load(
                    function(){
                        $(this).animate({'opacity':'1'},600);
                        $('#rot1 img:first').next().animate({'opacity':'0'},700,function(){
                            $(this).remove();
                        });
                    }
                ).attr('src','/ZJCeducation/zjc/parentsCenter/images/'+info_elem.find('.info_image').html()).attr('width','800').attr('height','506')
                );
                }
            });
        </script>
</body>
</html>