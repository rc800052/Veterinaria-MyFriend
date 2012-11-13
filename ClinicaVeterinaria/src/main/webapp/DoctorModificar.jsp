<%@include file="ValidarSession.jsp"%>
<%@include file="main.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
  <form id="form1" name="form1" method="post" action="DoctorModificarServlet">
<%@page import="clinicaveterinaria.modelo.Doctor"%>
<%
Doctor vo = (Doctor)request.getAttribute("vo");
%>
    <table width="100%" border="1">
      <tr bgcolor="#D1F09D">
        <td colspan="6" bgcolor="#D1F09D"><div align="center"><strong>DOCTOR</strong><strong> : MODIFICAR REGISTRO</strong></div></td>
      </tr>
      <tr>
        <td colspan="4" bgcolor="#D1F09D" class="Estilo5"><label></label>NUMERO DE REGISTRO</td>
        <td width="8%" bgcolor="#D1F09D" class="Estilo5">:</td>
        <td width="25%" bgcolor="#E9E9DE"><label>
          <input type="text" name="idDoctor" id="idDoctor" value="<%=vo.getIdDoctor()%>" readonly="readonly"/>
        </label></td>
      </tr>
      <tr>
        <td width="15%" bgcolor="#D1F09D"><span class="Estilo5">NOMBRE</span></td>
        <td width="2%" bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td width="27%" bgcolor="#D6E9DE"><input type="text" name="nombre" id="nombre" value="<%=vo.getNombre()%>" size="30"  maxlength="30" onKeypress="sololetras(this);"/></td>
        <td width="23%" bgcolor="#D1F09D"><span class="Estilo5">APELLIDO</span></td>
        <td width="8%" bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td width="25%" bgcolor="#D6E9DE"><input type="text" name="apellido" id="apellido" value="<%=vo.getApellido()%>" size="30" maxlength="30" onKeypress="sololetras(this);"/></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">EMAIL</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="text" name="email" id="email" value="<%=vo.getEmail()%>" size="30" maxlength="40" />
        </label></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">TELEFONO</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="text" name="telefono" id="telefono" value="<%=vo.getTelefono()%>" maxlength="9" onkeyUp="return ValNumero(this);" onchange="0"  />
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">USUARIO</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="text" name="usuario" id="usuario" value="<%=vo.getUsuario()%>" size="10" maxlength="10" onKeypress="sololetras(this);" />
        </label></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">CLAVE</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="password" name="clave" id="clave" maxlength="8" value="<%=vo.getClave()%>"/>
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">PERFIL</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="text" name="perfil" id="perfil" value="<%=vo.getPerfil()%>"/>
        </label></td>
        
        <td bgcolor="#D1F09D"><span class="Estilo5">REPETIR CLAVE</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="password" name="clave1" id="clave1" value="<%=vo.getClave()%> maxlength="8" onBlur="checkPass();"/>
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
        </label></td>
      </tr>
    </table>
  </form>
</div>  
</body>
</html>
