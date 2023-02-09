<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<html>
	<head>
		<title>Customer Form - Struts2 Demo | onlyforjava.com</title>
	</head>

	<body>
		<h2>
			Producer Form
		</h2>

		<s:form action="customer.action" method="post" validate="true">
			<s:textfield name="name" key="name" size="20" />
			<s:textfield name="age" key="age" size="20" />
			<s:textfield name="email" key="email" size="20" />
			<s:textfield name="telephone" key="telephone" size="20" />
			<s:submit method="addCustomer" key="label.add.customer"
				align="center" id="button_style"/>
		</s:form>
	</body>
</html>
