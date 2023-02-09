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

function addRegisters(){
	alert("add......");
	popUpWithServerData("/CTDomestic/addRegisterInput.action", "Manage Register",650,1000);
}
function updateRegisters()
{alert($("#companyId").val());
	popUpWithServerData("/CTDomestic/updateRegisterInput.action?raCompanyMaster.companyId="+$("#companyId").val(), "Manage Register",650,1000);
}
</script>
<form name="registerForm" action="<%=request.getContextPath()%>/loadRegisters.action">
	<jmesa:tableModel id="tag" items="${listCompanys}" maxRows="8"
		exportTypes="pdf" maxRowsIncrements="2,4,8" stateAttr="restore"
		var="bean" >
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				<jmesa:htmlColumn width="10%" property="companyId" title="Select Company">
					<center><input type="radio" name="companyIdRadio" id="companyIdRadio"
						value="${bean.companyId}" onclick="setId(this);" /></center>
				</jmesa:htmlColumn>
				<jmesa:htmlColumn property="companyName" title="Company Name" />
				<jmesa:htmlColumn property="companyHolding" title="Company Holding" />
				<jmesa:htmlColumn property="priFname" title="Primary Name" />
				<jmesa:htmlColumn property="companyStatus" title="Company Status" />
				
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
			
			<input type="button" onclick="addRegisters()" value="Add" id="button_style"/>
			<input type="button" onclick="updateRegisters()" value="Update" id="button_style"/>
			<s:submit value="Delete" action="deActiveRegister" theme="simple" align="center" id="button_style"></s:submit>
		
		    <s:hidden name="raCompanyMaster.companyId" id="companyId" theme="simple"></s:hidden>
		
</form>

		<script type="text/javascript">
            function onInvokeAction(id) {alert("12"+id);
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {alert("2"+id);
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/CTDomestic/loadRegisters.action?' + parameterString;
            }
            function setId(id){alert(id);
            	$("#companyId").val(id.value);
            }
        </script>

