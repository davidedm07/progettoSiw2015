<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/login.css" rel="stylesheet" />
<title>Login</title>
</head>
<body>
	<div class="container">
		<section id="content"> <f:view>
			<h:form>
							Email<font color="red"><h:inputText
						value="#{userController.email}" required="true"
						requiredMessage="Email is mandatory" id="email" /> <h:message
						for="email" /> </font>
							Password<font color="red"><h:inputSecret
						value="#{userController.password}" required="true"
						requiredMessage="Password is mandatory" id="password" /> <h:message
						for="password" /> </font>


				<div>
					<h:commandLink action="#{userController.loginUser}" value="Login" />
			</h:form>


			<a href="registrazioneUtente.jsp">Registrati</a>
			<a href="loginAmministratore.jsp">Login Amministratore</a>
			<a href="homepage.jsp">Homepage</a>
	</div>
	</form>
	<!-- form -->
	<div class="button"></div>
	<!-- button -->
	</f:view>
	</section>
	<!-- content -->
	</div>
	<!-- container -->


</body>
</html>