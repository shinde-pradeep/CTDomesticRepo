<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Basic JMesa Example</title>
		<%@ taglib uri="/tld/jmesa.tld" prefix="jmesa"%>
	</head>

	<body>

		<form name="presidentsForm" action="<%=request.getContextPath()%>/loadProductJemesa.action">
			<jmesa:tableModel id="tag" items="${listProduct}" maxRows="8"
				exportTypes="csv,excel" maxRowsIncrements="8,16,24"
				stateAttr="restore" var="bean">
				<jmesa:htmlTable width="600px">
					<jmesa:htmlRow>
						<jmesa:htmlColumn property="productId" title="Product Id">
						</jmesa:htmlColumn>
						<jmesa:htmlColumn property="productName" title="Product Name" />
					</jmesa:htmlRow>
				</jmesa:htmlTable>
			</jmesa:tableModel>

		</form>

		<script type="text/javascript">
            function onInvokeAction(id) {
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                location.href = '/proj/loadProduct.action' + parameterString;
            }
        </script>

	</body>

</html>
