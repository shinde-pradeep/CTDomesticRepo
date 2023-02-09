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

function addOffers(){
	popUpWithServerData("/CTDomestic/addOfferInput.action", "Manage Offers",600,800);
}
function updateOffers()
{alert($("#offerId").val());
	popUpWithServerData("/CTDomestic/updateOfferInput.action?raTraceOffers.offerId="+$("#offerId").val(), "Manage Offers",600,800);
}
</script>
<form name="offerForm" action="tradersOffer">
	<h2>My Offers</h2>
	<jmesa:tableModel id="tag" items="${listOffer}" maxRows="8"
		exportTypes="pdf" maxRowsIncrements="2,4,8" stateAttr="restore"
		var="bean" >
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				<jmesa:htmlColumn width="10" property="offerId" title="Select Offer">
					<center><input type="radio" name="offerIdRadio" id="offerIdRadio"
						value="${bean.offerId}" onclick="setId(this);" /></center>
				</jmesa:htmlColumn>
				<jmesa:htmlColumn property="firstName" title="User Name" />
				<jmesa:htmlColumn property="email" title="Email ID" />
				<jmesa:htmlColumn property="raCompanyMaster.companyName" title="Company" />
				<jmesa:htmlColumn property="otherCity" title="Product" />
				<jmesa:htmlColumn property="farmName" title="Given To" />
				<jmesa:htmlColumn property="offerDate" title="Offer Date" pattern="dd/MM/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
				<jmesa:htmlColumn property="availabilityDate" title="Availability Date" pattern="dd/MM/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
				<jmesa:htmlColumn property="expirationDate" title=" Last Date" pattern="dd/MM/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
				<jmesa:htmlColumn property="offerPrice" title=" Offer Price" />
				<jmesa:htmlColumn property="city" title=" City" />
				
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
			
			<input type="button" onclick="addOffers()" value="Add" id="button_style"/>
			<input type="button" onclick="updateOffers()" value="Update" id="button_style"/>
			<s:submit value="Delete" action="deActiveOffers" theme="simple" align="center" id="button_style"></s:submit>
		
		    <s:hidden name="raTraceOffers.offerId" id="offerId" theme="simple"></s:hidden>
		
</form>

		<script type="text/javascript">
            function onInvokeAction(id) {alert("12"+id);
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {alert("2"+id);
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/CTDomestic/tradersOffer?' + parameterString;
            }
            function setId(id){alert(id);
            	$("#offerId").val(id.value);
            }
        </script>

