<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
window.parent.location.href='alluser';
}

$(document).ready(function() {
				$("#frm_add_trader").validationEngine()
				});
</script>
</head>
<%--   **********    --%>
<body>
<form id="frm_add_trader" cssClass="formular">
		<table border="1" width="200" height="150">
		<br/><br/>
		<tr><td>
			<table width="100">
				<tbody>
					<tr><td>First Name</td><td><s:textfield name="raUserMaster.firstName" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Last name</td><td><s:textfield name="raUserMaster.lastName" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Login Name*</td><td><s:textfield name="raUserMaster.loginName" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Email ID*</td><td><s:textfield name="raUserMaster.email" theme="simple" cssClass="validate[required,length[3,30]]"></s:textfield></td></tr>
					<tr><td>Password*</td><td><s:password name="raUserMaster.password" theme="simple" cssClass="validate[required,length[3,20]]"></s:password></td></tr>
					<tr><td>Position*</td><td><s:textfield name="raUserMaster.position" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td colspan="2"><s:select label="User Type" name="raUserMaster.userType" list="{'admin','traders'}"></s:select></td></tr>
					<tr><td>Office Address</td><td><s:textarea name="raUserMaster.officeAddress" theme="simple" cssClass="validate[required,length[3,20]]" rows="10" cols="10"></s:textarea></td></tr>
					
				</tbody>
			</table>
		</td>
			<td >
			<table width="100">
				<tbody>
					<tr><td>City *</td><td><s:textfield name="raUserMaster.city" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>District *</td><td><s:textfield name="raUserMaster.district" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Postal Code*</td><td><s:textfield name="raUserMaster.zip" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td><s:select list="listProducer" label="Producer *" name="producerTraderId"  value="raProducerMaster" headerKey="0" headerValue="--select--"  listKey="producerId" listValue="orignizationName"></s:select></td></tr>
					<tr><td><s:select list="listCompany" label="Company*" name="companyTraderId"  value="raCompanyMaster" headerKey="0" headerValue="--select--"  listKey="companyId" listValue="companyName"></s:select></td></tr>
					<tr><td><s:select list="listState" label="State*" name="stateTraderName"  value="raStateMaster" headerKey="0" headerValue="--select--"  listKey="stateId" listValue="stateType"></s:select></td></tr>
					<tr><td>Telephone</td><td><s:textfield name="raUserMaster.phone" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Fax</td><td><s:textfield name="raUserMaster.fax" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					
				</tbody>
			</table>
		</td>
		</tr>
		<tr></tr>
		
		</table>
					<s:hidden name="raUserMaster.userId"/>
					<s:if test="raUserMaster.userId!=null">
						<s:submit value="Update" action="updateAdmin" theme="simple" id="button_style"></s:submit>
					</s:if>
					<s:else>
						<s:submit value="Save" action="addAdmin" theme="simple" id="button_style"></s:submit>
					</s:else>
					
					<s:submit theme="simple" id="button_style" value="Reset"></s:submit>		
					
	
</form>
</body>
</html>
