<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
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
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath()%>/js/jquery-1.4.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validationEngine.js" type="text/javascript"></script>

<script>
alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='producersOffer';
}

$(document).ready(function() {
				$("#frm_add_producerOffer").validationEngine()
				});
</script>
</head>
<%--   **********    --%>
<body>
<form id="frm_add_producerOffer" cssClass="formular">
		<table border="1" width="200" height="150">
		<br/><br/>
		<tr><td>
			<table width="100">
				<tbody>
					<tr><td>First Name</td><td><s:textfield name="raTraceOffers.firstName" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Last name</td><td><s:textfield name="raTraceOffers.lastName" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Email ID*</td><td><s:textfield name="raTraceOffers.email" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Telephone</td><td><s:textfield name="raTraceOffers.phone" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>City*</td><td><s:textfield name="raTraceOffers.city" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>State*</td><td><s:select list="listStates" name="stateTraderOffer"  value="raStateMaster" headerKey="0" headerValue="--select--"  listKey="stateId" listValue="stateType"></s:select></td></tr>
					<tr><td>Offer Quantity *</td><td><s:textfield name="raTraceOffers.offerQty" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>QTY_UOM *</td><td><s:textfield name="raTraceOffers.qtyUom" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Offer Price*</td><td><s:textfield name="raTraceOffers.offerPrice" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
					<tr><td>Offer Price Uom*</td><td><s:textfield name="raTraceOffers.offerPriceUom" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield></td></tr>
										
				</tbody>
			</table>
		</td>
			<td >
			<table width="100">
				<tbody>
					<tr><td colspan="2"><s:select list="listGrade" label="Grade *" name="gradeOfferId"  value="raGradeMaster" headerKey="0" headerValue="--select--"  listKey="gradeId" listValue="gradeDispName"></s:select></td></tr>
					<tr><td colspan="2"><td><s:select list="listOrigin" label="Origin *" name="OriginOfferId"  value="raOriginMaster" headerKey="0" headerValue="--select--"  listKey="originId" listValue="originDispName"></s:select></td></tr>
					<tr><td colspan="2"><s:select list="listCompany" label="Company*" name="companyTraderId"  value="raCompanyMaster" headerKey="0" headerValue="--select--"  listKey="companyId" listValue="companyName"></s:select></td></tr>
					<tr>
					
					<td colspan="2">
						Load_Port<s:select name="loadPortNameId" list="listLoadPort" label="Load_Port*" listKey="loadId" listValue="loadPortType" value="raLoadPort"
							headerKey="0" headerValue="--Select--" theme="simple"></s:select>
					</td>

				</tr>
				<tr>
					
					<td colspan="2">
						<s:select list="listDestPort" name="destPortOfferId" label="Destination Port*"
							value="raDestinationPort" headerKey="0" headerValue="--Select--"
							listKey="destPortId" listValue="destinationPort" theme="simple"></s:select>
					</td>
					</tr>
					<tr>
					
					<td colspan="2">
						<s:select list="listProduct" name="productTraderId" label="Product Name*"
							value="raProducerMaster" headerKey="0" headerValue="--Select--"
							listKey="productId" listValue="productType" theme="simple"></s:select>
					</td>
					</tr>
					<tr><td>Comments</td><td><s:textarea rows="5" cols="5" name="raTraceOffers.comments" theme="simple" ></s:textarea></td></tr>
					<tr>
					<td colspan="2">
						<s:select list="listFarm" name="farmId" label="Farm Name "
							value="raFarmMaster" headerKey="0" headerValue="--Select--"
							listKey="farmId" listValue="farmName" theme="simple"></s:select>
					</td>
					</tr>
					<tr>
					<td>Other City</td>
					<td><s:textfield name="raTraceOffers.otherCity" theme="simple"></s:textfield></td>
					</tr>
				</tbody>
			</table>
		</td>
		</tr>
		<tr></tr>
		
		</table>
					<s:hidden name="raTraceOffers.offerId"/>
					<s:if test="raTraceOffers.offerId!=null">
						<s:submit value="Update" action="updateProducerOffers" theme="simple" id="button_style"></s:submit>
					</s:if>
					<s:else>
						<s:submit value="Save" action="addProducerOffers" theme="simple" id="button_style"></s:submit>
					</s:else>
					
					<s:reset theme="simple" id="button_style"></s:reset>		
					
	
</form>
</body>
</html>
