
<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<style>
	#button_style{
	margin-top: 5px;
	width: 150px;
	height: 29px;
	font-size: 12px;
	font-weight: bold;
	color: #ffffff;
	text-shadow: 0 1px #e3f1f1;
	background: #cde5ef;
	border: 1px solid;
	border-color: #b4ccce #b3c0c8 #9eb9c2;
	border-radius: 16px;
	cursor: pointer;
		background: url(images/buttons.png) center top no-repeat;
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
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/template.css" type="text/css"
	media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath()%>/js/jquery-1.4.min.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js"
	type="text/javascript"></script>
<script
	src="<%=request.getContextPath()%>/js/jquery.validationEngine.js"
	type="text/javascript"></script>

<script>
//alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='participatingProducer.action';
}

$(document).ready(function() {
				$("#frm_add_prod").validationEngine()
				});
</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		<TD>
			<br>
			<table width="50%" border="0" align="center" cellpadding="2"
				cellspacing="1" bgcolor="#BFBFBF">
				<s:form  id="frm_add_prod"
					enctype="multipart/form-data" cssClass="formular">

					<s:actionerror />
					<tr valign="top">
						<th colspan="2">
							<strong><b>Upload your file here</b> </strong>
						</th>
					</tr>
					<tr valign="top" bgcolor="#FFFFFF">
						<td width="20%">
							Select File
						</td>
						<td width="80%">

							<s:file name="excelFile" accept="text/excel" theme="simple" label="Upload" size="50" ></s:file>
						</td>
					</tr>
					<tr>
						<td><s:submit value="Upload" theme="simple" action="uploadProducer" id="button_style"/></td>
						<td><s:submit theme="simple" id="button_style" value="Reset" ></s:submit></td>
					</tr>
					<s:hidden name="method" value="uploadExcel" />
					<s:hidden name="raProducerMaster.producerId"></s:hidden>

				</s:form>
				</table>
				</table>