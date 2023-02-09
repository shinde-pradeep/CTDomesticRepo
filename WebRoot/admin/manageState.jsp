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

function addStates(){
	popUpWithServerData("/CTDomestic/addStateInput.action", "Manage States",270,550);
}
function updateStates()
{//alert($("#stateId").val());
	popUpWithServerData("/CTDomestic/updateStateInput.action?stateMaster.stateId="+$("#stateId").val(), "Manage States",270,550);
}
</script>
<form name="sateForm" action="<%=request.getContextPath()%>/loadCountry.action">
	<h1>Add/Update States</h1>
	<jmesa:tableModel id="tag" items="${stateList}" maxRows="8"
		exportTypes="pdf" maxRowsIncrements="2,4,8" stateAttr="restore"
		var="bean" >
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				<jmesa:htmlColumn width="10%" property="stateId" title=" Select State">
					<center><input type="radio" name="stateIdRadio" id="stateIdRadio"
						value="${bean.stateId}" onclick="setId(this);" /></center>
				</jmesa:htmlColumn>
				<jmesa:htmlColumn property="description" title="State Description" />
				<jmesa:htmlColumn property="stateType" title="State Name" />
				<jmesa:htmlColumn property="stateStatus" title="State Status" />
				
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
			
			<input type="button" onclick="addStates()" value="Add" id="button_style"/>
			<input type="button" onclick="updateStates()" value="Update" id="button_style"/>
			<s:submit value="Delete" action="deActiveState" theme="simple" align="center" id="button_style"></s:submit>
		
		    <s:hidden name="stateMaster.stateId" id="stateId" theme="simple"></s:hidden>
		
</form>

		<script type="text/javascript">
            function onInvokeAction(id) {//alert("12"+id);
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {alert("2"+id);
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/CTDomestic/loadCountry.action?' + parameterString;
            }
            function setId(id){//alert(id);
            	$("#stateId").val(id.value);
            }
        </script>

