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
<script>
alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='loadProduct.action'; //doc.formname.action
}
// Below code need to addd to javascript for validations "frm_add_products" is form id
	$(document).ready(function() {
			$("#frm_add_products").validationEngine()
		});
</script>
<%//cssClass="validate[required,custom[noSpecialCaracters],length[3,20]]" %>
<s:form id="frm_add_products" cssClass="formular">

		<s:actionerror />
	<b>Product Name:</b>
	<br />
	<s:textfield name="raProductMaster.productType" theme="simple"
		cssClass="required,validate[length[3,20]]"></s:textfield>
	<br />
	<b>Product Description:</b>
	<br />
	<s:textfield name="raProductMaster.description" theme="simple"
		cssClass="validate[length[3,20]]"></s:textfield>
	<br />
	<s:hidden name="raProductMaster.productId"></s:hidden>
	
	
	<s:submit value="Save" action="addProduct" theme="simple" id="button_style"></s:submit>
	
</s:form>
