<%@include file="main.jsp"%>
<%@page import="java.awt.Desktop.Action"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
<!--
.Estilo6 {font-size: 14px; font-weight: bold; }
.Estilo8 {font-size: 12px; font-weight: bold; }
.Estilo9 {color: #0066FF}
#appDoctor {
	position:absolute;
	left:0;
	top:30%;
	width:100%;
	height:50%;
	z-index:1;
}
.boton1 { 
  font-family: Verdana, sans-serif; 
  font-size: 10px; 
  color: #333333; 
  border: 1px #666666 solid; 
  background-color: #669900; 
  font-weight: bold}
}

-->
</style>
	        <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css"  />
	        <script type="text/javascript" src="js/jquery.js"></script>
	        <script type='text/javascript' src='js/jquery.autocomplete.js'></script>

 <script type="text/javascript">
 
 function validar(objeto) {
 
 var boton = objeto.value;
 
 if(boton=="Buscar"){
    document.getElementById("txtpeticion").value="Buscar";
 }
 
if (boton == "Grabar"){
	document.getElementById("txtpeticion").value="Grabar";

	var serie= document.f1.serie.value;
	
	if (serie == "") {
		alert("Ingrese Serie del Comprobante");
		document.f1.serie.focus();
		return false;
	}
	
	var numero = document.f1.numero.value;
	if (numero == "") {
		alert("Ingrese Numero del Comprobante");
		document.f1.numero.focus();
		return false;
	}
	
	var fecha = document.f1.fecha.value;
	if (fecha == "") {
		alert("Ingrese la Feha del Comprobante");
		document.f1.fecha.focus();
		return false;
	}
	
	var moneda = document.f1.moneda.value;
	if (moneda == "") {
		alert("Ingrese la moneda del Comprobante");
		document.f1.moneda.focus();
		return false;
	}
	
	var tc = document.f1.tc.value;
	if (tc == "") {
		alert("Ingrese el Tipo de Cambio");
		document.f1.tc.focus();
		return false;
	}
	
	var emision = document.f1.emsion.value;
	if (emision == "") {
		alert("Ingrese la Fecha de Emision");
		document.f1.emision.focus();
		return false;
	}
	
	var cliente_id = document.f1.cliente_id.value;
	if (cliente_id == "") {
		alert("Ingrese el Cliente");
		document.f1.cliente_id.focus();
		return false;
	}
	
	
    
 }
 
 document.forms[0].submit();
 //return true;
 
 }
 </script>
</head>

<body>`
<div id="appDoctor">
	<form name="f1" action="CitasPorClienteServlet" method="post">
	<input type="hidden" name="txtpeticion" value="" id="txtpeticion">
		<table>
			<tr>
				<td>Codigo :</td>
				<td colspan="10"> <input style="height: 19px; width: 101px" name="codigo" value="${CODIGO}"> </td>
			</tr>
			<tr>
				<td>Serie :</td>
				<td colspan="4"><input style="height: 19px; width: 101px" name="serie" value="${SERIE}"></td>

				<td>Numero :</td>
				<td colspan="5"><input style="height: 19px; width: 101px" name="numero" value="${NUMERO}"></td>
			</tr>
			<tr>
				<td>Fecha :</td>
				<td colspan="10"><input style="height: 19px; width: 101px" name="fecha" value="${FECHA}"></td>
			</tr>
			<tr>
				<td>Moneda :</td>
				<td colspan="4"><input style="height: 19px; width: 44px" name="moneda" value="${MONEDA}"></td>

				<td>T.C :</td>
				<td colspan="5"><input style="height: 19px; width: 42px" name="tc" value="${TC}"></td>
			</tr>
			<tr>
				<td>Emision :</td>
				<td colspan="10"><input style="height: 19px; width: 101px" name="emision" value="${EMISION}"></td>
			</tr>
			<tr>
				<td>Cliente :</td>
				<td colspan="10">  <input style="height: 19px; width: 25px" name="cliente_id" id="cliente_id" value="${CLIENTE_ID}">
				<input style="height: 19px; width: 208px" name="cliente" id="cliente" value="${CLIENTE}">
				<input type="button" value="Buscar" id="Boton" name="Boton" onclick=validar(this)>
				</td>
			
		 <script type="text/javascript">
	            $("#cliente").autocomplete("AutoCompleteJQuery", {
	                formatItem: function(data) {
	                    return data[1];
	                },
	                formatResult: function(data) {
	                    return data[1];
	                }
	            }).result(function(event, data) {
	                if (data) {
	                    $("#cliente_id").attr("value", data[0]);
	                }
	            }).setOptions({
	                max: '100%'
	            });
	        </script>
			</tr>
			<tr>
				<td colspan="11">Detalles de la Cita...</td>
			</tr>
			<tr>
				<td>Seleccionar</td>
				<td>Fecha Cita</td>
				<td>N CitaDeta</td>
				<td>idProducto</td>
				<td>Producto</td>
				<td>Tipo</td>
				<td>Cantidad</td>
				<td>Precio</td>
				<td>SubTototal</td>
				<td>IGV</td>
				<td>Total</td>
			</tr>
			<c:forEach items="${RESULTADO}" var="r" varStatus="i">
			<tr>
			    <td><input type="checkbox" name="seleccionar"></td>
			    <td><input type="text" value="${r.fchcita}" name="fecha" style="width: 104px; height: 19px"></td>
				<td><input type="text" value="${r.idCitaDet}" name="citadeta" style="width: 49px; height: 19px"></td>
				<td><input type="text" value="${r.idProducto}" name="idprod" style="width: 52px; height: 19px"></td>
				<td><input type="text" value="${r.producto}" name="prod" style="height: 19px; "></td>
				<td><input type="text" value="${r.tipo}" name="tipo" style="height: 19px; "></td>
				<td><input type="text" value="${r.cantidad}" name="cantidad" style="width: 80px; height: 19px"></td>
				<td><input type="text" value="${r.precio}" name="precio" style="width: 73px; height: 19px"></td>
				<td><input type="text" name="subtotal" style="width: 85px; height: 19px"></td>
				<td><input type="text" name="igv" style="width: 43px; height: 19px"></td>
				<td><input type="text" name="total" style="width: 39px; height: 19px"></td>
				<td><input type="text" name="nada" style="width: 51px; height: 19px"></td>
			</tr>			
		</c:forEach>
		<tr>
		<td colspan="11"><input type="submit" value="Grabar" id="Boton" name="Boton" onclick=validar(this)>
		<input type="submit" value="Cancelar"></td>
		</tr>
		</table>
		<br><em class="rojo">${GRABAR}</em>
	</form>
	</div>
</body>
</html>