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

function addTraders(){
	popUpWithServerData("/CTDomestic/addTraderInput.action", "Manage Trader",500,800);
}
function updateTraders()
{alert($("#userId").val());
	popUpWithServerData("/CTDomestic/updateTraderInput.action?raUserMaster.userId="+$("#userId").val(), "Manage Trader",500,800);
}
</script>
<form name="userForm" action="traders-form">
	<h1>Add/Update Company Users</h1>
	<jmesa:tableModel id="tag" items="${traderList}" maxRows="8"
		exportTypes="pdf" maxRowsIncrements="2,4,8" stateAttr="restore"
		var="bean" >
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				<jmesa:htmlColumn property="userId" title="Select User">
					<center><input type="radio" name="userIdRadio" id="userIdRadio"
						value="${bean.userId}" onclick="setId(this);" /></center>
				</jmesa:htmlColumn>
				<jmesa:htmlColumn property="loginName" title="UserID" />
				<jmesa:htmlColumn property="firstName" title="User Name" />
				<jmesa:htmlColumn property="position" title="Position" />
				<jmesa:htmlColumn property="createDate" title="Create Date" pattern="dd/MM/yyyy" cellEditor="org.jmesa.view.editor.DateCellEditor" />
				<jmesa:htmlColumn property="userStatus" title=" Status" />
				
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>
			 <s:hidden name="raUserMaster.userId" id="userId" theme="simple" id="button_style"></s:hidden>
			<input type="button" onclick="addTraders()" value="Add" id="button_style"/>
			<input type="button" onclick="updateTraders()" value="Update" id="button_style"/>
			<s:submit value="Delete" action="deActiveTrader" theme="simple" id="button_style"></s:submit>
			<s:submit value="Change to Trader/User" action="traderPriamryUser" theme="simple" id="button_style"></s:submit>
		
		   
		
</form>

		<script type="text/javascript">
            function onInvokeAction(id) {alert("12"+id);
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {alert("2"+id);
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/CTDomestic/traders-form?' + parameterString;
            }
            function setId(id){alert(id);
            	$("#userId").val(id.value);
            }
        </script>

