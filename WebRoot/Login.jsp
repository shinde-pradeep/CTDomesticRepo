<style>
<!--

-->

#button_style{
	margin-top: 5px;
	width: 75px;
	height: 29px;
	font-size: 12px;
	font-weight: bold;
	color: #527881;
	text-shadow: 0 1px #e3f1f1;
	background: #cde5ef;
	border: 1px solid;
	border-color: #b4ccce #b3c0c8 #9eb9c2;
	border-radius: 16px;
	cursor: pointer;
	}
	
	
	#text_style{
	margin-top: 5px;
	width: 200px;
	height: 29px;
	font-size: 12px;
	font-weight: bold;
	color: #527881;
	text-shadow: 0 1px #e3f1f1;
	background: #cde5ef;
	border: 1px solid;
	border-color: #b4ccce #b3c0c8 #9eb9c2;
	
	}
	
</style>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Login</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/new.css" type="text/css">

		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.8.2.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-ui.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jmesa.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery.jmesa.js" /></script>


</head>
<body>

<s:include value="Login1.jsp"></s:include>
<div id="main">
<!-- header begins -->

</div>

<!-- header ends -->
<div align="right" id="content" style="height: 100%;">
<div id="wrapper">
			<div id="content-box">
				<div class="slider">
					<div id="slidercontainer">
						<ul>
							<li>
								<img src="images/home0.jpg"
									width="604" height="453" />
							</li>
							<li>
								<img src="images/home01.jpg" width="604"
									height="453" />
							</li>
							<li>
								<img
									src="images/home1.JPG"
									width="604" height="453" />
							</li>
							<li>
								<img
									src="images/home2.jpg"
									width="604" height="453" />
							</li>
							<li>
								<img
									src="images/home3.jpg"
									width="604" height="453" />
							</li>
							<li>
								<img
									src="images/home4.jpg"
									width="604" height="453" />
							</li>
							<li>
								<img
									src="images/home5.jpg"
									width="604" height="453" />
							</li>
						</ul>
						
					</div>
					<script>
$(window).load(function(){
		var pages = $('#slidercontainer li'), current=0;
		var currentPage,nextPage;
		var timeoutID;
		var buttonClicked=0;

		var handler1=function(){
			buttonClicked=1;
			$('#slidercontainer .button').unbind('click');
			currentPage= pages.eq(current);
			if($(this).hasClass('prevButton'))
			{
				if (current <= 0)
					current=pages.length-1;
					else
					current=current-1;
			}
			else
			{

				if (current >= pages.length-1)
					current=0;
				else
					current=current+1;
			}
			nextPage = pages.eq(current);	
			currentPage.fadeTo('slow',0.3,function(){
				nextPage.fadeIn('slow',function(){
					nextPage.css("opacity",1);
					currentPage.hide();
					currentPage.css("opacity",1);
					$('#slidercontainer .button').bind('click',handler1);
				});	
			});			
		}

		var handler2=function(){
			if (buttonClicked==0)
			{
			$('#slidercontainer .button').unbind('click');
			currentPage= pages.eq(current);
			if (current >= pages.length-1)
				current=0;
			else
				current=current+1;
			nextPage = pages.eq(current);	
			currentPage.fadeTo('slow',0.3,function(){
				nextPage.fadeIn('slow',function(){
					nextPage.css("opacity",1);
					currentPage.hide();
					currentPage.css("opacity",1);
					$('#slidercontainer .button').bind('click',handler1);				
				});	
			});
			timeoutID=setTimeout(function(){
				handler2();	
			}, 4000);
			}
		}

		$('#slidercontainer .button').click(function(){
			clearTimeout(timeoutID);
			handler1();
		});

		timeoutID=setTimeout(function(){
			handler2();	
			}, 4000);
		
});

</script>
				</div>
<div id="info-content">
					

<s:form action="login.action" name="showfrm" method="post">
		
		</br>
		</br>
				<s:actionerror />
				<a href=/CTDomestic/forgetPass.action>Forgot Password</a>
						<a href=/CTDomestic/addRegisterUser.action> | New User</a>
							
				
						<s:textfield name="userTo.loginName" key="User Name"
							id="text_style" />
					
						<s:password name="userTo.password" key="label.password" id="text_style" />
					
	
						<s:submit key="label.login" align="center" onclick="loginUser();" id="button_style"  />
					
				
											</s:form>
						</div>
			</div>
		</div>
						

<font color="white"><p align="center">Copyright &copy; www.kjnext.com 2012-2013</font>


</body>
</html>
