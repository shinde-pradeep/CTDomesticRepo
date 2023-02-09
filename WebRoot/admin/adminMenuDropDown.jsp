<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>

</head>
<%--<script language="javascript">
javascript: window.history.forward(1);
</script>
<head>
<link href="styles.css" rel="stylesheet" type="text/css" />
--%>

<div id=container>
	<UL class=nav id=nav>
			<LI>
			<A href="#" class="ImgtxtUp">Manage Master</A>
			<UL>
				<li>
					<a href=/CTDomestic/loadProduct.action>Products	</a>
					<a href=/CTDomestic/loadGrowingRegions.action>Growing Regions	</a>
					
					<a href=/CTDomestic/loadCountry.action>State</a>
					<a href=/CTDomestic/loadPorts.action>DestinationPorts	</a>
					<a href=/CTDomestic/portsLoad.action>LoadOriginPorts	</a>
					
				</li>
			</UL>
		</LI>
		
		<LI>
			<A href="#" class="ImgtxtUp">Administration</A>
			<UL>
				<li>
					
					<s:a href="participatingCompany">Participating  Companies</s:a>
					<s:a href="participatingProducer" cssStyle="border: thick">Participating Producers</s:a>
					
					
				</li>
			</UL>
		</LI>
		
		<LI>
			<A href="# class="ImgtxtUp">Transaction</A>
			<UL>
				<li>
					<s:a href="traders-Transaction1">Current transations</s:a>
					<s:a href="achieved-Transaction1">Achieved Transactions</s:a>
				</li>
			</UL>
		</LI>
		<LI>
			<A href="#" class="ImgtxtUp">Reports</A>
			<UL>
				<li>
					<s:a href="transactionReport">Reports for Transations</s:a>
					<s:a href="participatingCompanyReport">Reports for Companies</s:a>
					<s:a href="producerReport">Reports for Producers</s:a>
				</li>
			</UL>
		</LI>
		<LI>
			<A href="#" class="ImgtxtUp">User Administration</A>
			<UL>
				<li>
					<s:a href="alluser">Show Admin Users</s:a>
				</li>
			</UL>
		</LI>
	</UL>
	<UL class=nav id=nav style="float: right;">

		<li><s:a href="#">Welcome	<s:property value="%{#session.UserName}" /></s:a>
		
		</li>
	
		<li>
			<s:a href="logout">LogOut</s:a>
		</li>
	</UL>

</div>

