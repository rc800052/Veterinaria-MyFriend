<%@include file="main.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VeterinariaGozus</title>
<script type="text/javascript">
function ocultarColumna(num,ver) {
  dis= ver ? '' : 'none';
  fila=document.getElementById('tabla').getElementsByTagName('tr');
  for(i=0;i<fila.length;i++)
    fila[i].getElementsByTagName('td')[num].style.display=dis;

}
</script>
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
</head>
<body link="#3366CC" onLoad="ocultarColumna(6,false);">
<div id="appDoctor">
  <form id="form1" name="form1" method="post" action="DoctorMostrarServlet">
    <table width="200" border="0">
      <tr>
        <td><div align="left"><span class="Estilo8">DOCTOR</span></div></td>
        <td><span class="Estilo8">:</span></td>
        <td><label>
          <input type="text" name="bnombre" id="bnombre" />
        </label></td>
        <td><label>
          <input type="submit" class = "boton1" name="button" id="button" value="Buscar Doctor" />
        </label></td>
        <td bgcolor="#6699FF">&nbsp;</td>
        <td><b><font face="Verdana" size="1"><a href="DoctorNew.jsp" class="Estilo9">Nuevo</a></font></b></td>
      </tr>
    </table>
  </form>
  <table  id="tabla" width="100%" border="1">
    <tr style="cursor:hand" onmouseover="this.style.background='#E1E1E1'; this.style.color='blue'" onmouseout="this.style.background='#FFFFFF'; this.style.color='black'">
      <td bgcolor="#D1F09D"><div align="center">
          <div align="right"><b><font face="Verdana" size="1" color="">REG</font></b></div>
      </div></td>
      <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center"> NOMBRES</div>
      </font></b></td>
      <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center"> APELLIDOS</div>
      </font></b></td>
      <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center"> EMAIL</div>
      </font></b></td>
      <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center"> TELEFONO</div>
      </font></b></td>
      <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center"> USUARIO</div>
      </font></b></td>
      <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center"> CLAVE</div>
      </font></b></td>
	 <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center"> PERFIL</div>
      </font></b></td>
      
      
      <td colspan="2" bgcolor="#BFEA77"><b><font face="Verdana" size="1" color="">
        <div align="center">ACCIONES</div>
      </font></b></td>
    </tr>
    <c:forEach items="${RESULTADO}" var="r" varStatus="i">
      <tr  bgcolor="#FFFFFF" style="cursor:hand" onmouseover="this.style.background='#E1E1E1'; this.style.color='blue'" onmouseout="this.style.background='#FFFFFF'; this.style.color='black'">
        <td bgcolor="#769EBC"><b><font face="Verdana" size="1" color="">
          <div align="right">${r.idDoctor}</div>
        </font></b></td>
        <td><b><font face="Verdana" size="1" color="">${r.nombre}</font></b></td>
        <td><b><font face="Verdana" size="1" color="">${r.apellido}</font></b></td>
        <td><b><font face="Verdana" size="1" color="">${r.email}</font></b></td>
        <td><b><font face="Verdana" size="1" color="">${r.telefono}</font></b></td>
        <td><b><font face="Verdana" size="1" color="">${r.usuario}</font></b></td>
        <td><b><font face="Verdana" size="1" color="">${r.clave}</font></b></td>
        <td><b><font face="Verdana" size="1" color="">${r.perfil}</font></b></td>
        <td bgcolor="#BFEA77"><b><font face="Verdana" size="1" color="">
                    <div align="center"><a href="DoctorEliminarServlet?idDoctor=${r.idDoctor}" onclick="return confirm('�Est� Seguro de Eliminar al Prospecto');">Eliminar</a></div>
        </font></b></td>
        <td bgcolor="#BFEA77"><b><font face="Verdana" size="1" color="">
          <div align="center"><a href="DoctorEditarServlet?idDoctor=${r.idDoctor}">Modificar</a></div>
        </font></b></td>
          
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
