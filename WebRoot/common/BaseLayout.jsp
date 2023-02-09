<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<style>

body {
    margin:0;
    padding:0;
    height:100%;
   
   <!-- background: url(images/main-bg.jpg) left top;-->
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

    height: 100px;
    color: White;
    text-align: center;
    position: relative;
    top:0px;
     background: url(images/bg.jpg) left top repeat-x #000000;   
}
#menuheader
{	
    width: 100%;
    height: 53px;
    color:white;
    text-align: center;
    position: relative;
    background-color: #131313;
    background: url(images/buttons.png) left top;
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
#content
{
    width: 1000px;
    height: 100%;
    margin: 0 auto 0 auto;
}

div.cell{
float: none;
padding-top: 0px;
padding-right: 40px;
padding-left: 0;
list-style: square;

}
</style>
<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
	
	
	<body> 
    <div id="wrap">
        <div id="header">
				<tiles:insertAttribute name="header" />
        </div>
        <div id="menuheader">
			<tiles:insertAttribute name="menuDropDown" />
        </div>
       
        <div id="inner-wrap">
            <div id="content">
					<tiles:insertAttribute name="body" />
            </div>
        </div>
        <div id="footer">
					<tiles:insertAttribute name="footer" />
        </div>
    </div> 
</body><%--
	
	
	
	
	<body>
		<table border="1" cellpadding="2" cellspacing="2" align="center"
			width="100%" height="100%">
			<tr>
				<td height="30" colspan="2">
					<tiles:insertAttribute name="header" />
				</td>
			</tr>
			<tr>
				<td height="30" colspan="2">
					<tiles:insertAttribute name="menuDropDown" />
				</td>
			</tr>
			<tr>
				<td height="25%">
					<tiles:insertAttribute name="menu" />
				</td>
				<td width="75%">
					<tiles:insertAttribute name="body" />
				</td>
			</tr>
			<tr>
				<td height="30" colspan="2">
					<tiles:insertAttribute name="footer" />
				</td>
			</tr>
		</table>--%>