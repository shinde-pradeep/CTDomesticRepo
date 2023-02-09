<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath()%>/js/jquery-1.4.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validationEngine.js" type="text/javascript"></script>

<script>
alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='participatingCompany.action';
}

$(document).ready(function() {
				$("#frm_add_company").validationEngine()
				});
</script>
<%--   **********    --%>
<s:form id="frm_add_company" cssClass="formular">
	
					<b>TO:</b>
					<br />
					<s:textfield name="raCompanyMaster.priEmail" theme="simple" cssClass="validate[required,length[3,30]]"></s:textfield>
					<br />
					<b>Subject</b>
					<br />
					<s:textfield name="subject" value="Notification" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
					<br />
					<b>Body</b>
					<br />
					<s:textarea name="body" theme="simple" cssClass="validate[required,length[3,100]]"></s:textarea>
					<br />
					<s:hidden name="raCompanyMaster.companyId"></s:hidden>
					<br />
					<s:if test="raCompanyMaster.companyId!=null">
						<s:submit value="Send" action="updateCompany" theme="simple" id="button_style"></s:submit>
					</s:if>
					<s:else>
						<s:submit value="Save" action="addCompany" theme="simple" id="button_style"></s:submit>
					</s:else>
					
					<s:reset theme="simple" id="button_style"></s:reset>
					
	
</s:form>
