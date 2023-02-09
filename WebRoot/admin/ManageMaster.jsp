
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%--<link rel="stylesheet"
			href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
		<script src="/resources/demos/external/jquery.bgiframe-2.1.2.js"></script>
		<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>

--%><%--<s:iterator id="links" value="mapMenu">
	<br />
	<a href=<s:property value="value" />><s:property value="key" />	</a>
	<br />
</s:iterator>
--%>

<div class="cell">
	<a href=/CTDomestic/loadProduct.action>Products	</a>
</div> 
<div class="cell"> 
	<a href=/CTDomestic/loadGrowingRegions.action>Growing Regions	</a>
	</div>
<div class="cell">
	<a href=/CTDomestic/loadOrigin.action>OriginMaster	</a>
</div> 
 <div class="cell">
	<a href=/CTDomestic/loadCountry.action>State	</a>
 </div>
 <div class="cell">
	<a href=/CTDomestic/loadPorts.action>DestinationPorts	</a>
 </div>
 <div class="cell">
	<a href=/CTDomestic/loadOriginPorts.action>LoadOriginPorts	</a>
 </div>
 <!--  <div class="cell">
	<a href=/CTDomestic/loadRegisters.action>Register</a>
 </div>
 <div class="cell">
	<a href=/CTDomestic/companyRegister.action>Company Register</a>
 </div>-->