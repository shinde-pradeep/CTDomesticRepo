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
<script>
//alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='loadPorts.action';
}

$(document).ready(function() {
				$("#frm_add_port").validationEngine()
				});
</script>
<%--   **********    --%>
<s:form id="frm_add_port" cssClass="formular">
<s:actionerror/>
	<div>
		<div >
					<b>destinationPort Type:</b>
					<br />
					<s:textfield name="destinationPort.destinationPort" theme="simple" cssClass="validate[required,custom[noSpecialCaracters],length[3,20]]"></s:textfield>
					<br />
					<b>destinationPort Description:</b>
					<br />
					<s:textfield name="destinationPort.description" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
					<br />
					<s:hidden name="destinationPort.destPortId"></s:hidden>
					<br />
					<s:if test="destinationPort.destPortId!=null">
						<s:submit value="Update" action="updateDestinationPort" theme="simple" id="button_style"></s:submit>
					</s:if>
					<s:else>
						<s:submit value="Save" action="addDestinationPort" theme="simple" id="button_style"></s:submit>
					</s:else>
					
					<s:reset theme="simple"></s:reset>
					</div>
	</div>
</s:form>
