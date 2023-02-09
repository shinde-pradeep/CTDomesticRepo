<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/tld/jmesa.tld" prefix="jmesa"%>
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
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js" /></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.js" /></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jmesa.js" /></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.jmesa.js" /></script>

<script type="text/javascript">
function loadProducts(){
	popUpWithServerData("/CTDomestic/addProductInput.action", "Manage Products",270,550);
}
function updateProductInfo()
{
	popUpWithServerData("/CTDomestic/updateProductInput.action?raProductMaster.productId="+$("#productId").val(), "Manage Product",250,400);
}
</script>
<form name="productForm"
	action="<%=request.getContextPath()%>/loadProduct.action">
	<h1>Add/Update Products</h1>
	<jmesa:tableModel id="tag" items="${listProduct}" maxRows="8"
		exportTypes="pdf" maxRowsIncrements="2,4,8" stateAttr="restore"
		var="bean">
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				<jmesa:htmlColumn width="10%" property="productId" title="Select Product">
					<center><input type="radio" name="productIdRadio" id="productIdRadio"
						value="${bean.productId}" onclick="setId(this);" /></center>
				</jmesa:htmlColumn>
				<jmesa:htmlColumn property="productType" title="Product Name" />
				<jmesa:htmlColumn property="description" title="Product Description" />
				<jmesa:htmlColumn property="productStatus" title="Product Status" />
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
	<input type="button" onclick="loadProducts()" value="Add" id="button_style"/>
	<input type="button" onclick="updateProductInfo()" value="Update" id="button_style"/>
	<s:submit value="Delete" action="deleteProcess" theme="simple"
		align="center" id="button_style"></s:submit>	
	<s:hidden name="raProductMaster.productId" id="productId" theme="simple"></s:hidden>
</form>

<script type="text/javascript">
            function onInvokeAction(id) {
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '${pageContext.request.contextPath}/loadProduct.action?' + parameterString;
            }
            function setId(id){
            	$("#productId").val(id.value);
            }</script>

