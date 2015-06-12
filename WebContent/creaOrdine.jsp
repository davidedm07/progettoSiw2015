<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<title>Products</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<f:view>



		<h:form>
			<h1 class="description">Catalogo Store</h1>

			<table class="table table-striped">

				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Code</th>
					<th>Quantity</th>

					<th>Ordina</th>
					<h:commandLink action="#{orderController.createOrder}"
								value="crea">
								</h:commandLink>

				</tr>
				<c:forEach var="product" items="#{productController.products}">
					<tr>
						<td><h:commandLink action="#{productController.findProduct}"
								value="#{product.name}">
								<f:param name="id" value="#{product.id}" />
							</h:commandLink></td>
						<td>${product.price}</td>
						<td>${product.code}</td>
						<td><h:form>
								<h:inputText value="#{orderController.quantity}" />
							</h:form>

				
<td><h:form>
								<h:commandButton action="#{orderController.createOrderLine}" value="Aggiungi" />
			</h:form>

					</tr>

				</c:forEach>
			</table>
			<br>
			<br>
			<br>
			<h3>
				<a href="homepage.jsp"> Homepage</a>

				<h:form>
								<h:commandLink action="#{orderController.confirmOrder}" value="Conferma" />
			</h:form>

			</h3>
		</h:form>

	</f:view>
</body>
</html>