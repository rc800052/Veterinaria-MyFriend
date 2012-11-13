<%@include file="main.jsp"%>
<%@page import="clinicaveterinaria.negocio.GestionTipoProducto"%>
<%@page import="clinicaveterinaria.modelo.TipoProducto"%>
<%@page import="java.util.Collection, clinicaveterinaria.excepcion.DAOExcepcion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*" errorPage=""
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VeterinariaGozus</title>
<script language="javascript" type="text/javascript">
    //*** Este Codigo permite Validar que sea un campo Numerico
    function Solo_Numerico(variable){
        Numer=parseInt(variable);
        if (isNaN(Numer)){
            alert("Solo se Aceptan Números");
            return "";
            
        }
        return Numer;
    }
    function ValNumero(Control){
        Control.value=Solo_Numerico(Control.value);
    }
</script>

<script language="javascript">
function checkPass(){
  var guess = document.form1.clave.value;
  var secret = document.form1.clave1.value;
  if (guess == secret){
    return true;
  } else {
     alert("Las Contraseñas no Coinciden");
     return false;
  }
}
</script>

<script language="javascript">
function sololetras(){
if (event.keyCode >45 && event.keyCode  <=57) event.returnValue = false;
}
</script> 




<style type="text/css">
<!--
#appDoctorNew {
	position:absolute;
	left:0;
	top:30%;
	width:100%;
	height:50%;
	z-index:1;
}

.Estilo5 {font-size: 12px; font-weight: bold; }
-->
</style>
</head>

<body>
<div id="appDoctorNew">
<% 	GestionTipoProducto negTipoProd = new GestionTipoProducto();
	Collection<TipoProducto> lista = negTipoProd.listar();
	  request.setAttribute("ListadoTipo",lista); %>

<div id="apDiv1"></div>
<div id="apDiv2">
  <form id="form1" name="form1" method="post" action="ProductoInsertarServlet">
    <table width="100%" border="1">
      <tr bgcolor="#D1F09D">
        <td colspan="6" bgcolor="#D1F09D"><div align="center"><strong>PRODUCTO</strong><strong> : NUEVO REGISTRO</strong></div></td>
      </tr>
      <tr>
        <td width="15%" bgcolor="#D1F09D"><span class="Estilo5">NOMBRE</span></td>
        <td width="2%" bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td width="27%" bgcolor="#D6E9DE"><label>
          <input type="text" name="nombre" id="nombre" />
        </label></td>
        <td width="23%" bgcolor="#D1F09D"><span class="Estilo5">PRECIO</span></td>
        <td width="8%" bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td width="25%" bgcolor="#D6E9DE"><label>
          <input type="text" name="precio" id="precio" />
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">TIPO</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
		<select name="cbotipo" id="cbotipo">
	        <option value="0"></option>
	          <%
				for(TipoProducto c:lista){
					out.println("<option value="+c.getIdTipo()+">"+c.getTipo()+"</option>"); 
				}
				%>
          </select>
        </label></td>
        <td colspan="2" bgcolor="#CCCCCC"><label>
          <div align="center">
            <input type="submit" name="button" id="button" value="Guardar" />
            </div>
        </label></td>
        <td bgcolor="#CCCCCC"><label>
          <div align="center">
            <input type="button" value="Regresar" onclick="window.location='ProductoBuscar.jsp' " />
            </div>
        </label></td>
      </tr>
    </table>
    <br><em class="rojo">${MENSAJE }</em>
  </form>
</div>
</body>
</html>
