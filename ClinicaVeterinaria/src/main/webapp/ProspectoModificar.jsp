<%@include file="ValidarSession.jsp"%>
<%@include file="main.jsp"%>
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
     alert("Las Contrasenas no Coinciden");
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
  <form id="form1" name="form1" method="post" action="ProspectoModificarServlet">
  <%@page import="clinicaveterinaria.modelo.Prospecto;"%>
<%
Prospecto vo = (Prospecto)request.getAttribute("vo");
%>
  
    <table width="100%" border="1">
      <tr bgcolor="#D1F09D">
        <td colspan="6" bgcolor="#D1F09D"><div align="center"><strong>PROSPECTO</strong><strong> : EDITAR REGISTRO</strong></div></td>
      </tr>
      
      <tr>
        
        <td width="15%" bgcolor="#D1F09D"><span class="Estilo5">Num REGISTRO</span></td>
        <td width="2%" bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td width="27%" bgcolor="#D6E9DE"><label>
          <input type="text" name="idProspecto" id="idProspecto" value="<%=vo.getIdProspecto()%>" readonly="readonly"/>
        </label></td>
     
      </tr>
      <tr>
        <td width="15%" bgcolor="#D1F09D"><span class="Estilo5">NOMBRE</span></td>
        <td width="2%" bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td width="27%" bgcolor="#D6E9DE"><label>
          <input type="text" name="nombre" id="nombre" value="<%=vo.getNombre()%>" size="40" onKeypress="sololetras(this);"/>
        </label></td>
        <td width="23%" bgcolor="#D1F09D"><span class="Estilo5">E-MAIL</span></td>
        <td width="8%" bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td width="25%" bgcolor="#D6E9DE"><label>
          <input type="text" name="email" id="email" size="40" value="<%=vo.getEmail() %>" />
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">DIRECCION</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="text" name="direccion" id="direccion" size="50" value="<%=vo.getDireccion() %>" />
        </label></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">TELEFONO</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="text" name="telefono" id="telefono" value="<%=vo.getTelcasa()%>" maxlength="7" onkeyUp="return ValNumero(this);" onchange="0"/>
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">CELULAR</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="text" name="celular" id="celular" value="<%=vo.getTelcelular()%>" maxlength="8" onkeyUp="return ValNumero(this);" onchange="0"/>
        </label></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">IMAGEN</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="file" name="imagen" id="imagen" value="<%=vo.getImagen()%>" />
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">CONDICION</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
        <input type="text" name="cliente" id="cliente" value="<%=vo.getCliente()%>" maxlength="1" onkeyUp="return ValNumero(this);" onchange="0"/>  
        </label></td>
        </tr>
        
        <tr>
        <td colspan="2" bgcolor="#CCCCCC"><label>
          <div align="center">
            <input type="submit" name="button" id="button" value="Guardar" onclick="return confirm('¿Seguro de Guardar Los Cambios');"/>
            </div>
        </label></td>
        <td bgcolor="#CCCCCC"><label>
          <div align="center">
            <input type="submit" name="button2" id="button2" value="Cancelar" />
              
            </div>
        </label>
        
     
        
      </tr>
    </table>

  </form>
  
</div>  


</body>
</html>
