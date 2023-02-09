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

function addOrigin(){
	popUpWithServerData("/CTDomestic/addOriginInput.action", "Manage Origin",250,400);
}
function updateOrigin()
{alert($("#originId").val());
	popUpWithServerData("/CTDomestic/updateOriginInput.action?raOriginMaster.originId="+$("#originId").val(), "Manage Origin",250,400);
}
</script>
<form name="OriginForm"
	action="<%=request.getContextPath()%>/loadOrigin.action">
		<h1>Add/Update Origin Port</h1>
		<jmesa:tableModel id="tag" items="${raOriginMasterList}" maxRows="8"
		exportTypes="pdf" maxRowsIncrements="2,4,8" stateAttr="restore"
		var="bean">
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				<jmesa:htmlColumn width="10%" property="originId" title="Select Origin">
					<center><input type="radio" name="originIdIdRadio" id="originIdIdRadio"
						value="${bean.originId}" onclick="setId(this);" /></center>
				</jmesa:htmlColumn>
				<jmesa:htmlColumn property="originDispName" title="Origin Description" />
				<jmesa:htmlColumn property="originType" title="Origin Name" />
				<jmesa:htmlColumn property="originStatus" title="Origin Status" />
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
	<input type="button" onclick="addOrigin()" value="Add" id="button_style"/>
	<input type="button" onclick="updateOrigin()" value="Update" id="button_style"/>
	
	<s:submit value="Delete" action="deActiveOrigin" theme="simple"
		align="center" id="button_style"></s:submit>

	<s:hidden name="raOriginMaster.originId" id="originId"
		theme="simple"></s:hidden>

</form>

<script type="text/javascript">
            function onInvokeAction(id) {
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/CTDomestic/loadOrigin.action?' + parameterString;
            }
            function setId(id){
            	$("#originId").val(id.value);
            }
        </script>

