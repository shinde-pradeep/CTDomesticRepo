<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%--<script language="javascript">
javascript: window.history.forward(1);
</script>
--%>
 
			<div id=container>
				<UL class=nav id=nav>

					<LI>
						<A href="#" class="ImgtxtUp">Transactions</A>
						<UL>
							<li>
								<s:a href="traders-Transaction">My Transactions</s:a>
								<s:a href="tradersAchivedTransaction">Achieved Transactions</s:a>
							</li>
						</UL>
					</LI>
					<LI>
						<A href="# class="ImgtxtUp">Personal Details</A>
						<UL>
							<li>
								<s:a href="tradersProfile">My Profile</s:a>
							</li>
						</UL>
					</LI>
					<LI>
						<A href="#" class="ImgtxtUp">Reports</A>
						<UL>
							<li>
								<s:a href="tradersTransactionReport">Reports for Transations</s:a>
								
							</li>
						</UL>
					</LI>
					<LI>
						<A href="#" class="ImgtxtUp">User Administration</A>
						<UL>
							<li>
								<s:a href="traders-form">Trader Users</s:a>
								
							</li>
						</UL>
					</LI>
					<LI>
						<A href="#" class="ImgtxtUp">Offers Administration</A>
						<UL>
							<li>
								<s:a href="tradersOffer">My Offers</s:a>
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
