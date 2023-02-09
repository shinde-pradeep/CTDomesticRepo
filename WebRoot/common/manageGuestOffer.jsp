<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/tld/jmesa.tld" prefix="jmesa"%>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.8.2.js" /></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.js" /></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jmesa.js" /></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.jmesa.js" /></script>

<form name="offerForm" action="guestOffers">
	<jmesa:tableModel id="tag" items="${listOffer}" maxRows="8"
		exportTypes="csv,excel" maxRowsIncrements="4,8,12" stateAttr="restore"
		var="bean" >
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				
				<jmesa:htmlColumn property="firstName" title="User Name" />
				<jmesa:htmlColumn property="email" title="Email ID" />
				
				<jmesa:htmlColumn property="offerDate" title="Offer Date" pattern="dd/MM/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
				<jmesa:htmlColumn property="availabilityDate" title="Availability Date" pattern="dd/MM/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
				<jmesa:htmlColumn property="expirationDate" title=" Last Date" pattern="dd/MM/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
				<jmesa:htmlColumn property="offerPrice" title=" Offer Price" />
				
				
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
</form>

		<script type="text/javascript">
            function onInvokeAction(id) {alert("12"+id);
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {alert("2"+id);
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/CTDomestic/guestOffers?' + parameterString;
            }
           
        </script>

