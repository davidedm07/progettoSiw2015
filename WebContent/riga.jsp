<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Riga Ordine</title>
</head>
<body>

<f:view>
<h1>${orderLineController.ol.quantity}</h1>
<h2>Details</h2>
<!--  <div>Code: ${orderLineController.ol.quantity}</div>
<div>Price: ${orderLineController.ol.unitPrice}</div>
<br><br><br><br>-->

</f:view>
<button onclick="goBack()">Torna al catalogo</button>

<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>