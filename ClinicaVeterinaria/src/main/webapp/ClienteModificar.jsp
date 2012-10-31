<%@include file="ValidarSession.jsp"%>
<%@include file="main.jsp"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Documento sin t&iacute;tulo</title>


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
  <form id="form1" name="form1" method="post" action="ClienteModificarServlet">
  <%@page import="clinicaveterinaria.modelo.Cliente;"%>
<%
Cliente vo = (Cliente)request.getAttribute("vo");
%>
  
    <table width="100%" border="1">
      <tr bgcolor="#D1F09D">
        <td colspan="6" bgcolor="#D1F09D"><div align="center"><strong>CLIENTE</strong><strong> : EDITAR REGISTRO</strong></div></td>
      </tr>
      
      <tr>
        
        <td width="15%" bgcolor="#D1F09D"><span class="Estilo5">Num REGISTRO</span></td>
        <td width="2%" bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td width="27%" bgcolor="#D6E9DE"><label>
          <input type="text" name="idCliente" id="idCliente" value="<%=vo.getIdCliente()%>" readonly="readonly"/>
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
          <input type="text" name="email" id="email" value="<%=vo.getEmail() %>" size="50"/>
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">DIRECCION</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="text" name="direccion" id="direccion" size="50" value="<%=vo.getDireccion() %>"  size="50"/>
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
          <input type="text" name="celular" id="celular" value="<%=vo.getTelcelular()%>" maxlength="9" onkeyUp="return ValNumero(this);" onchange="0" />
        </label></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">IMAGEN</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
          <input type="file" name="imagen" id="imagen" value="<%=vo.getImagen()%>" />
        </label></td>
      </tr>
      <tr>
        <td bgcolor="#D1F09D"><span class="Estilo5">NOTAS</span></td>
        <td bgcolor="#D1F09D"><span class="Estilo5">:</span></td>
        <td bgcolor="#D6E9DE"><label>
        <textarea name="notas" id="notas" rows="5" cols="75" wrap="virtual" /><%=vo.getNotas()%>
        
</textarea>
        </tr>

        </label></td>
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
