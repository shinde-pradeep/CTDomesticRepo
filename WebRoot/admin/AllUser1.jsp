
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
          function onInvokeExportAction(id) { 
            var parameterString = createParameterStringForLimit(id); 
            location.href = '<s:url action="alluser" />?' + parameterString; 
        } 
			
		function SendNotification(){
				alert($("#userId").val());
				popUpWithServerData("/CTDomestic/sendNotificationInput.action?raUserMaster.userId="+$("#userId").val(), "Send Notification",250,400);
		}
</script> 

<form name="adminForm"
	action="<%=request.getContextPath()%>/alluser.action">
	<h1>All Users</h1>
	<jmesa:tableModel id="tag" items="${listUser}" maxRows="8"
		exportTypes="csv,excel,pdf" maxRowsIncrements="4,8,12" stateAttr="restore"
		var="bean" editable="true">
		<jmesa:htmlTable width="100%">
			<jmesa:htmlRow>
				<jmesa:htmlColumn width="10%" property="userId" title="Select User">
					<center><input type="radio" name="userIdRadio" id="userIdRadio"
						value="${bean.userId}" onclick="setId(this);" /></center>
				
				</jmesa:htmlColumn>
				<jmesa:htmlColumn property="firstName" title="User Name" />
				<jmesa:htmlColumn property="city" title="City" filterable="true"/>
				<jmesa:htmlColumn property="position" title="Position" filterable="true"/>
				<jmesa:htmlColumn property="userStatus" title="User Status" />
			</jmesa:htmlRow>
		</jmesa:htmlTable>
	</jmesa:tableModel>

		<s:hidden name="raUserMaster.userId" id="userId" theme="simple"></s:hidden>
		<input type="button" onclick="SendNotification()" value="Send Notification" id="button_style"/>
		
</form>

<script type="text/javascript">
            function onInvokeAction(id) {
                $.jmesa.setExportToLimit(id, '');
                $.jmesa.createHiddenInputFieldsForLimitAndSubmit(id);
            }
             function onInvokeExportAction(id) {
                var parameterString = $.jmesa.createParameterStringForLimit(id);
                alert(parameterString);
                location.href = '/CTDomestic/alluser.action?' + parameterString;
            }
            function setId(id){
            	$("#userId").val(id.value);
            }
        </script>