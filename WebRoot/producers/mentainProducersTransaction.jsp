<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
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
<html>
	<head>
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
alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='traders-Transaction';
}

$(document).ready(function() {
				$("#frm_add_Transaction").validationEngine()
				});
</script>
	</head>
	<%--   **********    --%>
	<body>
		<form id="frm_add_Transaction" cssClass="formular">
			<table border="1" width="100%" height="150">
				<tr>
					<td colspan="2">
						Manage Traceability
					</td>
				</tr>
				<tr>
					<td width="35%">
						Certificate of Transation No.*
					</td>
					<td width="50%">
						<s:textfield name="raTraceability.transactionId" theme="simple"></s:textfield>
					</td>
				</tr>
				<tr>
					<td width="35%">
						Buyer ID*
					</td>
					<td width="50%">
						<s:textfield name="raTraceability.buyerId" theme="simple"></s:textfield>
					</td>
				</tr>
				<tr>
					<td width="35%">
						Seller ID*
					</td>
					<td width="50%">
						<s:textfield name="raTraceability.sellerId" theme="simple"></s:textfield>
					</td>
				</tr>
				<tr>
					<td width="35%">
						Transaction Date*
					</td>
					<td width="50%">
						<s:textfield name="raTraceability.transDate" theme="simple"></s:textfield>
					</td>
				</tr>
				<tr>
					<td width="35%">
						Customer
					</td>
					<td width="50%">
						<s:select list="listCompanymaster"
							name="raCompanyMaster_CustomerId" value="raCompanyMaster"
							headerKey="0" headerValue="--select--" listKey="companyId"
							listValue="companyName" theme="simple"></s:select>
					</td>

				</tr>
				<tr>
					<td width="35%">
						Origin
					</td>
					<td width="50%">
						<s:select list="listOrigin" name="originNameId" headerKey="0"
							headerValue="--select--" value="raOriginMaster"
							listKey="originId" listValue="originDispName" theme="simple"></s:select>
					</td>

				</tr>
				<tr>
					<td width="35%">
						Crop Year*
					</td>
					<td width="50%">
						<s:select list="listCropYear" name="cropNameId" headerKey="0"
							headerValue="--select--" value="raTracCropYear"
							listKey="cropYearId" listValue="description" theme="simple"></s:select>
					</td>

				</tr>
				<tr>
					<td width="35%">
						Deliver Info*
					</td>
					<td width="50%">
						<s:select list="listDeliveryMonth" name="deliverMonthId" headerKey="0"
							headerValue="--select--" value="raDeliveryMonth"
							listKey="monthId" listValue="description" theme="simple"></s:select>
					</td>

				</tr>
				<tr>
					<td width="35%">
						Price Basis
					</td>
					<td width="50%">
						<s:select list="listPriceBasis" name="priceNameId" headerKey="0"
							headerValue="--select--" value="raPriceBasis" listKey="prBasisId"
							listValue="prBasisDspName" theme="simple"></s:select>
					</td>

				</tr>
				<tr>
					<td width="35%">
						Pricing
					</td>
					<td valign="middle" width="2205">
						<br>
						<s:textfield name="raTraceability.price" theme="simple" size="10"></s:textfield>

					</td>


				</tr>
				<tr>
					<td width="35%">
						Estimated Premium*
					</td>
					<td valign="middle" width="2205">
						<br>
						<s:textfield name="raTraceability.premPrice" theme="simple"
							size="10"></s:textfield>

					</td>

				</tr>
				<tr>
					<td width="35%">
						Destination State*
					</td>
					<td width="50%">
						<s:select name="stateNameId" list="listState" headerKey="0"
							headerValue="--Select--" listKey="stateId"
							listValue="description" value="raStateMaster" theme="simple"></s:select>
					</td>

				</tr>
				<tr>
					<td width="35%">
						Load Port*
					</td>
					<td width="50%">
						<s:select name="loadPortNameId" list="listLoadport"
							listKey="loadId" listValue="loadPortType" value="raLoadPort"
							headerKey="0" headerValue="--Select--" theme="simple"></s:select>
					</td>

				</tr>
				<tr>
					<td width="35%">
						Destination Port*
					</td>
					<td width="50%">
						<s:select list="listDestPort" name="destPortNameId"
							value="raDestinationPort" headerKey="0" headerValue="--Select--"
							listKey="destPortId" listValue="destinationPort" theme="simple"></s:select>
					</td>
					</tr>
				<tr bgcolor="#FFFFFF">
					<th height="20" colspan="3" width="1342">
						<strong class="content"><b>Coffee Information at
								Container Level</b> </strong>
					</th>
				</tr>
			</table>
			<s:hidden name="raTraceability.traceId" id="traceId" theme="simple"></s:hidden>
			<s:if test="raTraceability.traceId!=null">
				<s:submit value="Update" action="updateTransaction" theme="simple" id="button_style"></s:submit>
			</s:if>
			<s:else>
				<s:submit value="Save" action="addTransaction" theme="simple" id="button_style"></s:submit>
			</s:else>

			<s:reset theme="simple" id="button_style"></s:reset>
		</form>
	</body>
</html>
