
<%@ page language="java" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
			src="<%=request.getContextPath()%>/js/jquery.validate.min.js" /></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/jquery-1.3.min.js" /></script>

		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/validationEngine.jquery.css"
			type="text/css" media="screen" title="no title" charset="utf-8" />
		<link rel="stylesheet"
			href="<%=request.getContextPath()%>/css/template.css" type="text/css"
			media="screen" title="no title" charset="utf-8" />
		<script src="<%=request.getContextPath()%>/js/jquery-1.4.min.js"
			type="text/javascript"></script>
		<script
			src="<%=request.getContextPath()%>/js/jquery.validationEngine-en.js"
			type="text/javascript"></script>
		<script
			src="<%=request.getContextPath()%>/js/jquery.validationEngine.js"
			type="text/javascript"></script>

		<script>
alert('<s:property value='navigationFlg'/>');
if('<s:property value='navigationFlg'/>'=='success'){
window.parent.location.href='loadRegisters.action';
}

$(document).ready(function() {
				$("#frm_add_register").validationEngine()
				});
</script>
</HEAD>
<body  bgcolor="#FFFFFF" topmargin="0" leftmargin="0"marginwidth="0" marginheight="0">
<tr>
<td colspan="2" valign="top">
<table width="99%" border="0" align="center">
    <td width="100%" height="22" >
        
        <font size="2"><b><span >Member Registration</span></b></font>
        
        <font size="2"><b><span class="main">Member Profile</span></b></font>
       
        <font size="2"><b><span class="main">Member Registration Update</span></b></font>
       
    </td>
    <tr>
        <td  height="20">All fields marked <span>*</span> are mandatory.</td>
    </tr>
</table>


<tr>
<td colspan="2" valign="top" >
<table width="100%" height="71" border="0">
    <td width="99%" height="22">
        <h1><span ><br>Member Registration </span></h1></td>
    <tr>
        <td width="100%" height="16" >Welcome! If you are currently or intending to buy or sell
            Rainforest Alliance Certified? products then you've come to the right place! This web portal is an
            easy-to-use administrative tool for you to manage and track all your Rainforest Alliance Certified?
            business. Before gaining access to this member portal, you need to complete this registration form. Select
            information gathered here will appear in the Membership Directory and our consumer-friendly Shop Certified
            Guide, so please take the time to complete this form accurately so your company is properly listed in these
            public listings. All fields marked * are mandatory.
        </td>
    </tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="box3">
<s:form id="frm_add_register" cssClass="formular" enctype="multipart/form-data">

<TR>
<TD colSpan=2>
<TABLE  cellSpacing=1 align="center" cellPadding=4 width="100%" bgColor=#dfdfdf border=0>
    <TBODY>
    <tr>
    <th colspan="3"><STRONG ><b>Products</b></STRONG>*</th>
</tr>
<TR bgColor=#ffffff>
    <Td>
        Please indicate which Rainforest Alliance Certified&trade; products you are selling and/or buying. Check all
        that apply.
        <TABLE cellSpacing=0 cellPadding=5 width="95%" bgColor=#ffffff border=0 >
            <TR>
                <td width="27%">
                    <s:checkboxlist list="listProducts" name="productCompany" value="raProductMaster" listKey="productId" listValue="productType"  ></s:checkboxlist>*
                </td>
                <td>
                
                </td>
                <TR>
                    
                    <td colspan="7">Other, Please Specify
                        <s:textfield name="other_Product" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                    </td>
                </TR>
        </TABLE>
    </TD>
</TR>

<TR bgColor=#ffffff>
    <TH colSpan=3><strong ><b>Company Information</b></strong></TH>
</TR>
<TR bgColor=#ffffff>
    <td colspan=3>
        <TABLE  cellSpacing="1" cellPadding="0" width="100%" border="0">
           <tbody>
            <tr>
                <TD width="28%" height=30  valign="top">
                   companyName *
                </TD>
                
                <TD align=left valign="top">
                   <s:textfield name="companyName" key="registration.companyName" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
                
            </tr>
            <TR bgColor=#ffffff>
                <TD  valign="top">
                  companyHolding  *
                </TD>
                <TD valign="top">
                    <s:textfield name="companyHolding" key="registration.companyHolding" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
         </tbody>
        </table>
    </td>
</TR>
</TBODY>
</TABLE>
<TABLE  cellSpacing=1 cellPadding=5 width="100%" bgColor=#dfdfdf border=0>
    <TBODY>
<TR bgColor=#ffffff>
    <TH colSpan=2 height=20 width="50%"><strong ><b>Primary Contact Information</b></strong></TH>
    <TH width="50%"><strong><b>Secondary Contact Information</b></strong></TH>
</TR>
<TR bgColor=#ffffff>
    <TD colSpan=2 height=20>
    <TABLE  cellSpacing=0 cellPadding=0 width="100%"   border=0>
        <TBODY>

        <td colspan=2>
        <TABLE  cellSpacing="1" cellPadding="0" width="100%" border="0">
            <TR>
                <TD height=30 width="36%" valign="top">
                   First Name *
                </TD>
                <TD valign="top">
                    <s:textfield name="priFname" key="registration.priFname" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                    Last Name*
                </TD>
                <TD valign="top">
                    <s:textfield name="priLname" key="registration.priLname" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">User ID*
                </TD>
                
                <TD valign="top">
                <s:textfield name="priEmail" key="registration.priEmail" theme="simple"  cssClass="validate[required,length[10,30]]"></s:textfield><br/>
                    
                    <span class="content">(your email address)</span>
                </TD>
             </TR>
                <TR>
                <TD valign="top">
                   <s:textfield name="priEmail" key="registration.priEmail" theme="simple"  cssClass="validate[required,length[10,30]]"></s:textfield><br/>
                    <span >(your email address)</span>
                    </TD>
                </TR>
                <TR>
                 <TD height=30  valign="top">User ID*</td>
				 <td><s:textfield name="priEmail" key="registration.priEmail" theme="simple"  cssClass="validate[required,length[10,30]]"></s:textfield><br/>
                    <span class="content">(Please re-enter email address for verification)</span>
                </TD>
              
                </TR>
                

            <TR>
                <TD height=30  valign="top">
                    Primary Position*
                </TD>
                <TD valign="top">
                    <s:textfield name="priPosition" key="registration.priPosition" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30 valign="top">
                   Office Address*
                </TD>
                <TD  valign="top">
                    <s:textarea name="priOffaddress" key="registration.priOffaddress" theme="simple" cssClass="validate[required,length[3,20]]" rows="4" cols="39" ></s:textarea> 
                </TD>
            </TR>
			<tr><td colspan="4">&nbsp;</td></tr>
            <TR>
                <TD height=30  valign="top">
                    Primary City*
                </TD>
                <TD  valign="top">
                     <s:textfield name="priCity" key="registration.priCity" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                    Primary District*
                </TD>
                <TD valign="top">
                   <s:textfield name="priDistrict" key="registration.priDistrict" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                    Primary Zip *
                </TD>
                <TD valign="top">
                    <s:textfield name="priZip" key="registration.priZip" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                    State*
                </TD>
                <TD valign="top">
                <s:select list="listStates" name="stateCompany"  value="raStateMaster" headerKey="0" headerValue="--select--"  listKey="stateId" listValue="stateType"  theme="simple"></s:select>
                    
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                   Primary Phone*
                </TD>
                <TD valign="top">
                    <s:textfield name="priPhone" key="registration.priPhone" theme="simple" cssClass="validate[required,length[10,15]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                   Fax *
                </TD>
                <TD valign="top">
                    <s:textfield name="priFax" key="registration.priFax" theme="simple" cssClass="validate[required,length[10,15]]"></s:textfield>
            </TR>
            <TR>
                <TD valign="top">
                    Customer Phone*</TD>
				<TD >
				<s:textfield name="custPhone" key="registration.custPhone" theme="simple" cssClass="validate[required,length[10,15]]"></s:textfield>
				<span>(This is the number that will appear in our Shop Certified Guide that will enable consumers find your products and brands easily.)</span>
                </TD>

            </TR>
            <TR>
            <TD height=30  valign="top">
                Primary Url*
            </TD>
            <TD valign="top">
                <s:textfield name="priUrl1" key="registration.priUrl1" theme="simple" cssClass="validate[required,length[10,30]]"></s:textfield>
            </td>
</TR>
</table>
</td></tbody>
</TABLE></TD>
       <TD vAlign=top>
        <TABLE class=text cellSpacing=0 cellPadding=0 width="100%"
           border=0>
        <TBODY>
        	<TR>
                <TD height=30 width="36%" valign="top">
                   First Name 
                </TD>
                <TD valign="top">
                    <s:textfield name="srFname" key="registration.srFname" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                    Last Name
                </TD>
                <TD valign="top">
                    <s:textfield name="srLname" key="registration.srLname" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            
             <TR>
                <TD height=30  valign="top">
                    Primary Position
                </TD>
                <TD valign="top">
                    <s:textfield name="srPosition" key="registration.srPosition" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30 valign="top">
                   Office Address
                </TD>
                <TD  valign="top">
                    <s:textarea name="srAddress" key="registration.srAddress" theme="simple" cssClass="validate[required,length[3,20]]" rows="4" cols="39" ></s:textarea> 
                </TD>
            </TR>
			<tr><td colspan="4">&nbsp;</td></tr>
			<TR>
                <TD height=30  valign="top">
                    Primary City
                </TD>
                <TD  valign="top">
                     <s:textfield name="srCity" key="registration.srCity" size="20" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                    Primary District
                </TD>
                <TD valign="top">
                   <s:textfield name="srDistrict" key="registration.srDistrict" size="20" theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                    Primary Zip 
                </TD>
                <TD valign="top">
                    <s:textfield name="srZip" key="registration.srZip"  theme="simple" cssClass="validate[required,length[3,20]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                    State
                </TD>
                <TD valign="top">
                <s:select list="listStates" name="stateCompany"  value="raStateMaster" headerKey="0" headerValue="--select--"  listKey="stateId" listValue="stateType" theme="simple"></s:select>
                    
                </TD>
            </TR>
            
            
            <TR>
                <TD height=30  valign="top">
                   Primary Phone
                </TD>
                <TD valign="top">
                    <s:textfield name="srPhone" key="registration.srPhone" theme="simple" cssClass="validate[required,length[10,15]]"></s:textfield>
                </TD>
            </TR>
            <TR>
                <TD height=30  valign="top">
                   Fax 
                </TD>
                <TD valign="top">
                    <s:textfield name="srFax" key="registration.srFax" theme="simple" cssClass="validate[required,length[10,15]]"></s:textfield>
            </TR>
            <TR>
                <TD height=30  valign="top">Email
                </TD>
                
                <TD valign="top">
                <s:textfield name="srEmail" key="registration.srEmail" theme="simple"  cssClass="validate[required,length[3,20]]"></s:textfield><br/>
                    
                    <span>(your email address)</span>
                </TD>
             </TR>
            
        </TBODY>
    </TABLE>
</TD>
</TBODY>
</TABLE>

<TABLE  cellSpacing=1 cellPadding=5 width="100%" bgColor=#dfdfdf border=0>
    <TBODY>
        <TR bgColor=#ffffff>
            <TH colspan="3"><STRONG><b>Type of Business</b>*</STRONG></TH>
        </TR>
<tr bgColor=#ffffff>
    <td colspan="3">
        Please indicate your type of business. Check all that apply, as your company will be listed in the Membership
        Directory under all selected categories.<br>
        <TABLE  cellSpacing=0 cellPadding=5 width="95%" border=0>
            <TBODY>
                <TR>
                    <td> Bussiness*  </td>
                    <TD width="80%">
                        <s:checkboxlist list="listBussTypeMaster" name="bussinessCompany"  value="raBussinessTypeMaster" listKey="buisnessTypeId" listValue="buisnessType" theme="simple"></s:checkboxlist>
                    </TD>
                    <TD width="27%" >
                    </TD>
                       
                    <TD width="3%">
                        
                    </TD>
                    <TD width="37%" >
                    </TD>
                    <TR>
                        
                        <TD width="35%">Other, Please Specify :
                                <s:textfield name="other_Bussiness" key="registration.other_Bussiness" theme="simple" readonly="true" cssClass="validate[required,length[3,20]]"></s:textfield><br/>
                    </TR>
            </TBODY>
        </TABLE>
		  <TABLE  cellSpacing=1 cellPadding=5 width="100%" bgColor=#dfdfdf border=0>
    <TBODY>
        <TR bgColor=#ffffff>
                    <td  width="30%"><s:submit value="Submit" action="addCompanyRegister" theme="simple" id="button_style"></s:submit></td>**
                    <TD width="30%"><s:reset theme="simple" id="button_style"></s:reset></TD>$$
				</TR>
				</TBODY>	
		
		</table>
    </TD>
</TR>
</tbody>
</table>
</TD>
</TR>
</s:form>
</table>
</td>
</tr>
</body>
</html>

