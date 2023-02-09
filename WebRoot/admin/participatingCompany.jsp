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

function addCompany(){
	popUpWithServerData("/CTDomestic/addCompanyInput.action", "Manage Products",400,400);
}
function updateCompany()
{alert($("#companyId").val());
	popUpWithServerData("/CTDomestic/updateCompanyInput.action?raCompanyMaster.companyId="+$("#companyId").val(), "Send Notification",250,400);
}
</script>
<form name="ParticipatingCompanyform" action="<%=request.getContextPath()%>/participatingCompany.action">
	<h1>Participating Companies</h1>
	<jmesa:tableModel id="tag" items="${listCompany}" maxRows="8"
		exportTypes="pdf" maxRowsIncrements="2,4,8" stateAttr="restore"
		var="bean" >
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				
				<jmesa:htmlColumn property="companyId" title="Company Id">
					<input type="radio" name="companyIdRadio" id="companyIddRadio"
						value="${bean.companyId}" onclick="setId(this);" />
				</jmesa:htmlColumn>
				<jmesa:htmlColumn property="companyName" title="Company name"/>
				<jmesa:htmlColumn property="description" title="Company Description"/>
				<jmesa:htmlColumn property="productType" title="Product Name"/>
				<jmesa:htmlColumn property="companyStatus" title="Company Status"/>
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
		
		<input type="button" onclick="updateCompany()" value="Send Notification" id="button_style"/>
		<s:submit value="Deactive" action="deActiveCompany" theme="simple"
		align="center" id="button_style"></s:submit>
		<s:submit value="Active" action="ActiveCompany" theme="simple"
		align="center" id="button_style"></s:submit>
		<s:hidden name="raCompanyMaster.companyId" id="companyId"
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
                location.href = '/CTDomestic/participatingCompany.action?' + parameterString;
            }
            function setId(id){alert(id);
            	$("#companyId").val(id.value);
            }
        </script>

