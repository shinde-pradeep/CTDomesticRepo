<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%--<script language="javascript">
javascript: window.history.forward(1);
</script>
--%>
			<div id=container>
				<UL class=nav id=nav>

					<LI>
						<A href="#" class="ImgtxtUp">Transaction</A>
						<UL>
							<li>
								<s:a href="producersTransaction">My Transaction</s:a>
							</li>
						</UL>
					</LI>
					<LI>
						<A href="# class="ImgtxtUp">Personal Detail</A>
						<UL>
							<li>
								<s:a href="producerProfile">My Profile</s:a>
							</li>
						</UL>
					</LI>
					<LI>
						<A href="#" class="ImgtxtUp">Reports</A>
						<UL>
							<li>
								<s:a href="transactionProducers">Reports for transations</s:a>
								
							</li>
						</UL>
					</LI>
					<LI>
						<A href="#" class="ImgtxtUp">User Administration</A>
						<UL>
							<li>
								<s:a href="producersUser">Producer Users</s:a>
							</li>
						</UL>
					</LI>
					<LI>
						<A href="#" class="ImgtxtUp">Offers Administration</A>
						<UL>
							<li>
								<s:a href="producersOffer">My Offers</s:a>
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
