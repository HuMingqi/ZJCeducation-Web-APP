<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html  xmlns="http://www.w3.org/1999/xhtml"  xml:lang="en"  lang="en">
<head>
<title>个人中心</title>		
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="www.">	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="/ZJCeducation/zjc/personalCenter/css/reset.css" type="text/css" media="all">
  <link rel="shortcut icon" href="index/images/favicon.ico">
  <link rel="stylesheet" href="/ZJCeducation/zjc/personalCenter/css/jquery.fancybox-1.3.4.css" type="text/css" media="screen">
  <link rel="stylesheet" href="/ZJCeducation/zjc/personalCenter/css/style.css" type="text/css" media="all">
  <link href="/ZJCeducation/zjc/personalCenter/css/prettyPhoto.css" rel="stylesheet" />
  <script type="text/javascript" src="/ZJCeducation/zjc/personalCenter/js/jquery.min.js" ></script>
  <script type="text/javascript" src="/ZJCeducation/zjc/personalCenter/js/content_switch.js"></script>
  <script type="text/javascript" src="/ZJCeducation/zjc/personalCenter/js/jquery.easing.1.3.js"></script>
  <script type="text/javascript" src="/ZJCeducation/zjc/personalCenter/js/jquery.mousewheel.js"></script>
  <script type="text/javascript" src="/ZJCeducation/zjc/personalCenter/js/jquery-ui.js"></script>
  <script type="text/javascript" src="/ZJCeducation/zjc/personalCenter/js/cScroll.js"></script>
  <script src="/ZJCeducation/zjc/personalCenter/js/jquery.cycle.all.latest.js" type="text/javascript"></script>
  <script src="/ZJCeducation/zjc/personalCenter/js/jquery.color.js" type="text/javascript"></script>
  <script type="text/javascript" src="/ZJCeducation/zjc/personalCenter/js/script.js"></script>
  <script type="text/javascript" src="/ZJCeducation/zjc/personalCenter/js/functions.js"></script>
  <script src="/ZJCeducation/zjc/personalCenter/js/prettyPhoto.js"></script>
  <!--[if lt IE 9]>
  	<script type="text/javascript" src="./js/html5.js"></script>
    <link rel="stylesheet" href="./css/ie.css" type="text/css" media="all">
  <![endif]-->
	<!--[if lt IE 8]>
		<div style=' clear: both; text-align:center; position: relative;'>
			<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." /></a>
		</div>
	<![endif]-->
	<body onpaste="return false" ondragstart="return false" onmouseover="window.status='';return true" oncopy="return false;">
	<frameset> <frame src="/ZJCeducation/teacherCenter.action"> </frameset>
<script> 
function stop(){ 
alert('宝贝，我爱你！');
return false; 
} 
<!--document.oncontextmenu=stop;--> 
</script>

<body onselectstart="return false" onpaste="return false" oncopy="return false;" 
oncut="return false;" >
</a>
    <script>
	
        function checkhtml5()
        {
            if ($.browser.msie  && parseInt($.browser.version, 10) < 9) {
                document.body.innerHTML="<div style=' clear: both; text-align:center; position: relative; height: 50px; margin-top: 30px; padding: 20px; background-color: red; color: white; font-size:20px;'>你的浏览器非常落后，不支持 HTML5!<br/>请使用 Chrome 14+/IE 9+/Firefox 7+/Safari 4+ 其中任意一款浏览器访问此页面。</a></div>";

            }
        }
    </script>
    <style>
        a.wb_sina {
            float:left;
            margin-top:20px;
            margin-left:15px;
            display:inline-block;
            padding:4px 10px;
            border-radius:3px;
            background-color:#e55345;
            background-image:-moz-linear-gradient(top,#e96249,#e03c40);
            background-image:-ms-linear-gradient(top,#e96249,#e03c40);
            background-image:-webkit-gradient(linear,0 0,0 100%,from(#e96249),to(#e03c40));
            background-image:-webkit-linear-gradient(top,#e96249,#e03c40);
            background-image:-o-linear-gradient(top,#e96249,#e03c40);
            background-image:linear-gradient(top,#e96249,#e03c40);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e96249',endColorstr='#e03c40',GradientType=0);
            background-repeat:repeat-x;
            text-shadow:0 -1px 0 rgba(0,0,0,.5);
            border:1px solid #cf2b28;
            color:#fff!important;
            box-shadow:0 1px 0 rgba(255,255,255,.2) inset,0 1px 0 rgba(0,0,0,.2);
        }
        a.wb_sina:hover {
            background-image:-moz-linear-gradient(top,#e03c40,#e96249);
            background-image:-ms-linear-gradient(top,#e03c40,#e96249);
            background-image:-webkit-gradient(linear,0 0,0 100%,from(#e03c40),to(#e96249));
            background-image:-webkit-linear-gradient(top,#e03c40,#e96249);
            background-image:-o-linear-gradient(top,#e03c40,#e96249);
            background-image:linear-gradient(top,#e03c40,#e96249);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e03c40',endColorstr='#e96249',GradientType=0);
        }
        a.wb_sina span {
            display:inline-block;
            vertical-align:-5px;
            margin-right:7px;
            height:20px;
            width:24px;
            background:url(./images/weibo.png) no-repeat;/*没有这张图片*/
        }
        a.wb_tencent {
            float:left;
            margin-top:20px;
            margin-left:15px;
            display:inline-block;
            padding:4px 10px;
            border-radius:3px;
            background-color:#0e7fcc;
            background-image:-moz-linear-gradient(top,#1288d4,#0771c1);
            background-image:-ms-linear-gradient(top,#1288d4,#0771c1);
            background-image:-webkit-gradient(linear,0 0,0 100%,from(#1288d4),to(#0771c1));
            background-image:-webkit-linear-gradient(top,#1288d4,#0771c1);
            background-image:-o-linear-gradient(top,#1288d4,#0771c1);
            background-image:linear-gradient(top,#1288d4,#0771c1);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#1288d4',endColorstr='#0771c1',GradientType=0);
            background-repeat:repeat-x;
            text-shadow:0 -1px 0 rgba(0,0,0,.5);
            border:1px solid #0D6EB8;
            color:#fff!important;
            box-shadow:0 1px 0 rgba(255,255,255,.2) inset,0 1px 0 rgba(0,0,0,.2);
        }
        a.wb_tencent:hover {
            background-color:#0e7fcc;
            background-image:-moz-linear-gradient(top,#0771c1,#1288d4);
            background-image:-ms-linear-gradient(top,#0771c1,#1288d4);
            background-image:-webkit-gradient(linear,0 0,0 100%,from(#0771c1),to(#1288d4));
            background-image:-webkit-linear-gradient(top,#0771c1,#1288d4);
            background-image:-o-linear-gradient(top,#0771c1,#1288d4);
            background-image:linear-gradient(top,#0771c1,#1288d4);
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0771c1',endColorstr='#1288d4',GradientType=0);
        }
        a.wb_tencent span {
            display:inline-block;
            vertical-align:-5px;
            margin-right:7px;
            height:20px;
            width:24px;
            background:url(./images/weibo.png) no-repeat 0 -20px;/*没有这张图片*/
        }
        #abox
        {
            position: fixed;
            _position: absolute;
            right: 15px;
            z-index: 99999999;
        }
    </style>
</head>

<body onLoad="checkhtml5()">
<div id="abox">
</div>
<div class="page_spinner">
    <div></div>
</div>
<div class="over">
	<div class="centre">
		<div class="main">
			<!--header -->
	  <header>
				<h1><span id="logo"><img src="/ZJCeducation/zjc/personalCenter/images/logo1.png" alt="" usemap="#logo"></span></h1><!--中间心形的图片-->
				<nav class="menu">
					<ul id="menu">
						<li id="nav1"><img src="/ZJCeducation/zjc/personalCenter/images/nav1.png" alt=""><span>个人资料</span></li>
						<li id="nav2"><img src="/ZJCeducation/zjc/personalCenter/images/nav2.png" alt=""><span>编辑资料</span>						</li>
						<li id="nav3"><img src="/ZJCeducation/zjc/personalCenter/images/nav3.png" alt=""><span>我的老师</span></li>
						<li id="nav4"><img src="/ZJCeducation/zjc/personalCenter/images/nav4.png" alt=""><span>做家教</span></li>
						<li id="nav5"><img src="/ZJCeducation/zjc/personalCenter/images/nav5.png" alt=""><span>我发布的话题</span></li>
						<li id="nav6"><img src="/ZJCeducation/zjc/personalCenter/images/nav6.png" alt=""><span>时光沙漏</span></li>
					</ul>
				</nav>
				<img src="/ZJCeducation/zjc/personalCenter/images/spacer.gif" alt="" id="navigation" usemap="#navigation"><!--这尼玛是什么-->
				<map name="navigation" class="navigation">
	    </map>
				<map name="logo" class="map_logo"></map>
			</header>
			<!--header end-->
			<!--content -->
			<map name="back" class="map_back"></map>
			<article id="content">
				<ul>
					<li id="page_Home">
						<img src="/ZJCeducation/zjc/personalCenter/images/bg_content.png" alt="" class="bg_cont"><!--弹窗的背景-->
						<span class="back"><img src="/ZJCeducation/zjc/personalCenter/images/nav1.png" alt="" usemap="#back"><a href="/ZJCeducation/teacherCenter.action#close">返回</a></span><!--返回的那张叶子-->
						<div class="pad">
							<h2>个人资料</h2>
                          	            用户名：${teacher_info.nickname}<br />   <!--<s:property value="#teacher_info.nickname"/>空结果 -->
                            	教员编号：${teacher_info.number}<br />
                            	性别：${teacher_info.gender}<br />
                         	            学校：${teacher_info.school}<br />
                         	            专业：${teacher_info.major}<br/>
                         	            目前身份：${teacher_info.identity}<br/>
                         	            联系电话：${teacher_info.phone}<br/>
                         	            邮箱：${teacher_info.email}<br/>
                         	    QQ: ${teacher_info.qq}<br/>                         	    
                        </div>
					</li>
					<li id="page_About">
						<img src="/ZJCeducation/zjc/personalCenter/images/bg_content.png" alt="" class="bg_cont">
						<span class="back"><img src="/ZJCeducation/zjc/personalCenter/images/nav2.png" alt="" usemap="#back"><a href="/ZJCeducation/teacherCenter.action#close">返回</a></span>
						<div class="pad">
							<h2>编辑资料</h2>
							<div class="relative">
								<div class="scroll">
									<form action="/ZJCeducation/editPersonalData.action" method="post">
                                    <p>用户名：<input name="teacher_info.nickname" type="text" size="20" maxlength="15" value="${teacher_info.nickname}"/></p>                                                                                                                                              
                                    <p>性别：<input name="teacher_info.gender" type="radio" value="男" checked="checked"/>男<input name="teacher_info.gender" type="radio" value="女"/>女</p>
                                    <p>出生日期：<input name="birth_date" type="text" value="${teacher_info.birth_date}"></p>
                                    <p>学校：<input name="teacher_info.school" type="text" value="${teacher_info.school}"/></p> 
                                    <p>学历：<input name="teacher_info.background" type="text" value="${teacher_info.background }"/></p>
                                    <p>专业：<input name="teacher_info.major" type="text" value="${teacher_info.major}"/></p> 
                                    <p>住址：<input name="teacher_info.address" type="text" value="${teacher_info.address}"/></p>
                                    <p>邮箱：<input name="teacher_info.email" type="text" size="30" maxlength="30" value="${teacher_info.email}"/></p>
                                    <p>QQ：<input name="teacher_info.qq" type="text" size="20" maxlength="10" value="${teacher_info.qq}"/></p>                                                                       
									<p><input type="submit" value="提交" onClick="okHandle()" />&nbsp;&nbsp;<input type="reset" name="reset" value="重置" onClick="cancelHandle()"/></p>
									</form>								
								</div>
							</div>
						</div>
					</li>
					<li id="page_Talk">
						<img src="/ZJCeducation/zjc/personalCenter/images/bg_content.png" alt="" class="bg_cont">
						<span class="back"><img src="/ZJCeducation/zjc/personalCenter/images/nav3.png" alt="" usemap="#back"><a href="/ZJCeducation/teacherCenter.action#close">返回</a></span>
						<div class="pad">
							<h2>我的学生</h2><!--
                            <div class="relative">
                                <div class="scroll">
                                    <div style="width:100%;float: left; border-bottom: 1px solid #CCCCCC;">浟佳<br/><span style="float: right"> --by 浟佳好资源 2015-2-7</span></div>



                                    <div style="width:100%;float: left">分享我所知道的<br/><span style="float: right"> --by 浟佳, www.ayoujia.com</span></div>
                                </div>
                            </div>-->
                            <span>学习评价</span>
						</div>
					</li>
					<li id="page_Message">
						<img src="/ZJCeducation/zjc/personalCenter/images/bg_content.png" alt="" class="bg_cont">
						<span class="back"><img src="/ZJCeducation/zjc/personalCenter/images/nav4.png" alt="" usemap="#back"><a href="/ZJCeducation/teacherCenter.action#close">返回</a></span>
						<div class="pad">
							<h2>做家教</h2>
                            <div class="relative">
                                <div class="scroll">

                                    <div style="min-height: 300px; padding-bottom: 50px;">
<!-- 多说评论框 start -->
	<div class="ds-thread" data-thread-key="yyu" data-title="bb" data-url="http://"></div>
<!-- 多说评论框 end -->
<!-- 多说公共JS代码 start (一个网页只需插入一次) -->
<script type="text/javascript"> var duoshuoQuery = {short_name:"love90"}; (function() { var ds = document.createElement('script'); ds.type = 'text/javascript';ds.async = true; ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '/static.duoshuo.com/embed.js'; ds.charset = 'UTF-8'; (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ds); })(); </script>
<!-- 多说公共JS代码 end -->
                                    </div>
                                </div>
                            </div>
						</div>
					</li>
					<li id="page_Blog">
						<img src="/ZJCeducation/zjc/personalCenter/images/bg_content.png" alt="" class="bg_cont">
						<span class="back"><img src="/ZJCeducation/zjc/personalCenter/images/nav5.png" alt="" usemap="#back"><a href="/ZJCeducation/teacherCenter.action#close">返回</a></span>
						<div class="pad">
							<h2>我发布的话题</h2>
							<div class="relative">
								<div class="scroll">
									<ul class="gallery fancybox">
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/imglsh001.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/imglsh001small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/imglsh002.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/imglsh002small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/img003.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/img003small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/imglsh001.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/imglsh001small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/imglsh002.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/imglsh002small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/img003.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/img003small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/img004.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/img004small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/imglsh002.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/imglsh002small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/img003.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/img003small.jpg" alt=""></a></li>
                                        <li style="line-height:120px"><a href="/ZJCeducation/zjc/personalCenter/images/uploadimage/img004.jpg" rel="prettyPhoto[gallery1]"><img src="images/uploadimage/img004small.jpg" alt=""></a></li>
									</ul>
								</div>
							</div>
						</div>
					</li>
					<li id="page_Time">
						<img src="/ZJCeducation/zjc/personalCenter/images/bg_content.png" alt="" class="bg_cont">
						<span class="back"><img src="/ZJCeducation/zjc/personalCenter/images/nav6.png" alt="" usemap="#back"><a href="/ZJCeducation/teacherCenter.action#close">返回</a></span>
						<div class="pad">
<h2>时光沙漏</h2>
                            <div id="loveHeart" style="margin-top: 30px;font-size: 25px;">
                                        <span style="">宝贝你知道我爱你爱了多久了吗？</span>
                                        <div id="elapseClock" style="margin: 10px 0px 10px 0px;"></div>
                                <img src="/ZJCeducation/zjc/personalCenter/images/1.gif" />　　　　<img src="/ZJCeducation/zjc/personalCenter/images/2.gif" /><br/><br/>
                                    <div id="loveu">
                                        爱：从2014-2-6开始！<br/>
                                        <div class="signature" style="float: right; margin-right: 50px;">by 浟佳 </div>
                                    </div>
                          </div>
                      </div>
				  </div>
					</li>
					
					
				</ul>
			</article>
			<!--content end-->
  </div>
</div>
	<div class="bg1">	
		<div class="main">
			<!--footer -->
			<footer style="line-height:20px">
                <div id="copyright">
                    紫金草学子网<a href="" target=_blank>个人中心</a> 
					<script 
 language="JavaScript"></script>



                </object>
                </div>
				<!-- {%FOOTER_LINK} -->
			</footer>
			<!--footer end-->
		</div>
	</div>
</div>
<script>
$(window).load(function() {	
	$('.page_spinner').fadeOut();
	$('body').css({overflow:'visible'});
	
})
</script>

<script type="text/javascript">//修改时光沙漏时间
    var offsetX = $("#loveHeart").width() / 2;
    var offsetY = $("#loveHeart").height() / 2 - 55;
    var together = new Date();
    together.setFullYear(2014, 02, 06);
    together.setHours(17);
    together.setMinutes(0);
    together.setSeconds(0);
    together.setMilliseconds(0);

        setTimeout(function () {
            adjustWordsPosition();
            startHeartAnimation();
        }, 3000);

        timeElapse(together);
        setInterval(function () {
            timeElapse(together);
        }, 500);

        adjustCodePosition();
        $("#code").typewriter();
</script>
   <!-- <audio id="bgmMusic" src="http://www.51mp3ring.com/51mp3ring_com2/at200611121582079026.mp3" preload="auto" type="audio/mp3" autoplay loop></audio>-->   

<!--coded by koma-->

<!--LIVEDEMO_00 -->
</div>

</body>
</html>
