<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Domestic Commodity Trading</title>
		<link href="styles1.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="lib/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="lib/jquery.tools.js"></script>	
		<script type="text/javascript" src="lib/jquery.custom.js"></script>
		
		<!-- Pirobox setup and styles -->
<script type="text/javascript" src="lib/pirobox.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$().piroBox({
			my_speed: 400, //animation speed
			bg_alpha: 0.1, //background opacity
			slideShow : false, // true == slideshow on, false == slideshow off
			slideSpeed : 4, //slideshow duration in seconds(3 to 6 Recommended)
			close_all : '.piro_close,.piro_overlay'// add class .piro_overlay(with comma)if you want overlay click close piroBox

	});
});
</script>

<link href="images/style.css" rel="stylesheet" type="text/css" />

		
		
		
		<script type="text/javascript">
			
			function loginUser()
			{
				alert("Do see loginUser....");
				document.showfrm.action='login';
				document.showfrm.submit();
			}
			
		</script>
		<style>

body {
    margin:0;
    padding:0;
    height:100%;
}

#wrap {
    height: 100%;
}
* html #wrap { height:100% }

#inner-wrap {
    padding-bottom:50px;
    min-height: 100%;
    padding-top:10%;
}
#inner-wrap:after {
    content:" ";
    display:block;
    clear:both;

}
* html #inner-wrap {
    height:100%;
}

#header
{
    width: 100%;
    background-color: #190707;
    height: 70px;
    color: White;
    text-align: center;
    position: relative;
    top:0px;
}

#footer
{
    width: 100%;
    background-color: #190707;
    height: 25px;
    position:absolute;
    bottom: 0;
    color: White;
    text-align: center;
}
#division
{
 background-color: #0000ff;
    color: White;
   
    height: 100px;
	width: 30px;
	position: relative;
}


</style>
<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.2.2.pack.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>
		
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css">
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/jmesa.css" type="text/css"><link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/kjnextstyle.css"
			type="text/css" />
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/kjnextDropDown.css"
			type="text/css" />
	</head>

	<body>
	
        <div id="header">
				<h1>Domestic Commodity Trading</h1>
        </div>
        <marquee bgcolor="blue"><font color="white">Commodity Trading-Online Firm for Farmer</font></marquee>
		<s:actionerror />
		<s:form action="login.action" name="showfrm" method="post">
		</br>
			
			
			
			
			<div>
				<table width="100" height="100" align="left">
		
				<tr>
					<td colspan="1">
						<s:textfield name="userTo.loginName" key="label.username"
							size="20" />
					</td>
				</tr>
				<tr>
					<td colspan="1">
						<s:password name="userTo.password" key="label.password" size="20" />
					</td>
				</tr>
				<tr>
					<td colspan="1">
						<s:submit key="label.login" align="center" onclick="loginUser();" />
					</td>
				</tr>
				<tr>
					<td width="50">
						<a href=/CTDomestic/forgetPass.action>ForgotPassword</a>
					</td>
					<td width="50">
						<a href=/CTDomestic/addRegisterUser.action>| New User</a>
					</td>
				</tr>
			<tr>
			<td colspan="2">
			<marquee direction="up"  scrollamount=3><a href="#">Registration Started for Maharashtra</a><br>
			<br> <a href="#"> Registration Started for Karnataka</a><br>
			
			 </marquee>
			</td>
			</tr>
			</table>
			
			
			</div>
			<!-- <table width="100" height="100" align="left">
			<tr><td colspan="2" width="100" height=""><h2><font color="blue">
			Login</font></h2>
		</td></tr>
				<tr>
					<td colspan="1">
						<s:textfield name="userTo.loginName" key="label.username"
							size="20" />
					</td>
				</tr>
				<tr>
					<td colspan="1">
						<s:password name="userTo.password" key="label.password" size="20" />
					</td>
				</tr>
				<tr>
					<td colspan="1">
						<s:submit key="label.login" align="center" onclick="loginUser();" />
					</td>
				</tr>
				<tr>
					<td width="50">
						<a href=/CTDomestic/forgetPass.action>ForgotPassword</a>
					</td>
					<td width="50">
						<a href=/CTDomestic/addRegisterUser.action>| New User</a>
					</td>
				</tr>
			<tr>
			<td colspan="2">
			<marquee direction="up"  scrollamount=3><a href="#">Registration Started for Maharashtra</a><br>
			<br> <a href="#"> Registration Started for Karnataka</a><br>
			
			 </marquee>
			</td>
			</tr>
			</table>
			 -->
			
			
			<div>
			
			
			
			
			
			</div>
			
	 
			 <div align="left">
			 
			 <table width="100" height="100" align="left" border="1" bordercolor="grey">
			<tr><td colspan="2" width="100" height=""><h2><font color="blue">
			For More Detail</font></h2>
		</td></tr>
				<tr>
					<td colspan="1">
						 <s:textfield key="UserName" size="20"></s:textfield>
					</td>
				</tr>
				<tr>
					<td colspan="1">
						<s:textfield key="MobileNo" size="20"></s:textfield>
					</td>
				</tr>
				<tr>
					<td colspan="1">
						 <s:submit key="submit" align="justify"></s:submit><br>
					</td>
				</tr>
			 
			 
			 </table>
			 
			 
			 
			 <!-- <table>
			 <tr>
			 <th bgcolor="grey">
			 <font color="white" size="4" > For More Detail  
			 </font>
			 </th>
			 </tr>
			 <tr>
			 <td>
			 <s:textfield key="UserName" size="20"></s:textfield><br>
			 </td>
			 </tr>
			 <tr>
			 <td>
			 <s:textfield key="Mobile No" size="20"></s:textfield><br>
			 </td>
			 </tr>
			 <tr>
			 <td>
			 <s:submit key="submit" align="justify"></s:submit><br>
			  </td>
			 </tr>
			 </table>
			  -->
			 </div>
		</s:form>
		<div id="footer">
				Copyright &copy; www.kjnext.com 2012-2013
        </div>
	</body>
</html>
