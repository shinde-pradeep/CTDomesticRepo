<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
<script type="text/javascript"	src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/validationEngine.jquery.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/template.css" type="text/css" media="screen" title="no title" charset="utf-8" />
<script src="<%=request.getContextPath()%>/js/jquery-1.4.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validationEngine.js" type="text/javascript"></script>

<script>
//alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='loadCountry.action';
}

$(document).ready(function() {
				$("#frm_add_state").validationEngine()
				});
</script>
<s:form id="frm_add_state" cssClass="formular">
	<s:actionerror />
					
			<table>
			<tr>
			<th>
					State Name:
			</th>
			<th>		
						<s:textfield name="stateMaster.description" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
					
			</th>
			</tr>
			<tr>
			<th>		
				    		
							
					State Description:
			</th>
			<th>
					<s:textfield name="stateMaster.stateType" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
			</th>
			</tr>
		<tr>
		
		<th>
				<s:select list="regionList" name="stateMaster_raSellingRegions" label="Region Type" value="raSellingRegion" headerKey="0" headerValue="--select--"  listKey="regionId" listValue="regionType"></s:select>
		
		
		</th>
		</tr>			
					
			</table>		
					
					<s:hidden  name="stateMaster.stateId"></s:hidden>
					
				
				
			
				
					<s:if test="stateMaster.stateId!=null">
						<s:submit value="Update" action="updateState" theme="simple" id="button_style"></s:submit>
					</s:if>
					<s:else>
						<s:submit value="Save" action="addState" theme="simple" id="button_style"></s:submit>
					</s:else>
					
					<s:submit theme="simple" value="Reset" id="button_style"></s:submit>
					
	
</s:form>
