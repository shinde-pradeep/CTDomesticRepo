
<%@ page  contentType="text/html;charset=utf-8"%>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.js" /></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.js" /></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jmesa.js" /></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jmesa.js" /></script>
<script type="text/javascript">

function addTransaction(){
	popUpWithServerData("/CTDomestic/addTransactionInput.action", "Manage Transactions",600,800);
}
function updateTransaction()
{alert($("#transactionId").val());
	popUpWithServerData("/CTDomestic/updateTransactionInput.action?raTraceability.transactionId="+$("#transactionId").val(), "Manage Transactions",600,800);
}
</script>
<form name="Traders_Transactionform" action="<%=request.getContextPath()%>/tradersTransactionReport">
	<h1>All Transactions Reports</h1><h2> Date:<%=new java.util.Date() %></h2>
	<jmesa:tableModel id="tag" items="${listTraceability}" maxRows="10" exportTypes="pdf"
		 maxRowsIncrements="10,20,30" stateAttr="restore"
		var="bean" >
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				
				
				<jmesa:htmlColumn property="transactionId" title="Transaction ID"/>
				<jmesa:htmlColumn property="prcieExchange" title="Buyer"/>
				<jmesa:htmlColumn property="priceUnit" title="Seller"/>
				<jmesa:htmlColumn property="priceType" title="Producer"/>
				<jmesa:htmlColumn property="transDate" title="Shipment Date"pattern="dd/MM/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" /><jmesa:htmlColumn property="raStateMaster.stateType" title="State"/>
				<jmesa:htmlColumn property="raDestinationPort.destinationPort" title="DestinationPort"/>
				
				<jmesa:htmlColumn property="status" title="Status"/>
				
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
		
		<s:hidden name="raTraceability.transactionId" id="transactionId"
		theme="simple"></s:hidden>
		
		<s:hidden name="raTraceability.traceId" id="traceId"
		theme="simple"></s:hidden>
		
</form>

		<script type="text/javascript">
            function onInvokeAction(id) {alert("12"+id);
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {alert("2"+id);
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/CTDomestic/tradersTransactionReport?' + parameterString;
            }
            function setId(id){alert(id);
            	$("#transactionId").val(id.value);
            }
        </script>


