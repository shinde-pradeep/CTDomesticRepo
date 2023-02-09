<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath()%>/js/jquery-1.4.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validationEngine.js" type="text/javascript"></script>
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
<script>
alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='loadRegisters.action';
}

$(document).ready(function() {
				$("#frm_add_register").validationEngine()
				});
</script>
<s:form id="frm_add_register" cssClass="formular">
	
					<br />
					<b>Product Type:</b>
					<br />
					<s:checkboxlist list="listProducts" name="productCompany" value="raProductMaster" listKey="productId" listValue="productType"  ></s:checkboxlist>
					<br/>
					<b>State Type:</b>
					<br />
					 <s:select list="listStates" name="stateCompany"  value="raStateMaster" headerKey="0" headerValue="--select--"  listKey="stateId" listValue="stateType"></s:select>
					<br />
					<br />
					<b>Bussiness Type:</b>
					<br />
					<s:checkboxlist list="listBussTypeMaster" name="bussinessCompany"  value="raBussinessTypeMaster" listKey="buisnessTypeId" listValue="buisnessType"></s:checkboxlist>
					 <br />
					
					<s:hidden  name="companyMaster.companyId"></s:hidden>
					<br />
					<s:if test="companyMaster.companyId!=null">
						<s:submit value="Update" action="updateRegister" theme="simple" id="button_style"></s:submit>
					</s:if>
					<s:else>
						<s:submit value="Save" action="addRegister" theme="simple" id="button_style"></s:submit>
					</s:else>
					
					<s:reset theme="simple"></s:reset>
					
	
</s:form>
