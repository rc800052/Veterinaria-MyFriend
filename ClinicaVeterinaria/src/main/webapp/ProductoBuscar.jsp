<%@include file="main.jsp"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="clinicaveterinaria.negocio.GestionTipoProducto"%>
<%@page import="clinicaveterinaria.modelo.TipoProducto"%>
<%@page import="java.util.Collection, clinicaveterinaria.excepcion.DAOExcepcion"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lista de Productos</title>
<script type="text/javascript">
function ocultarColumna(num,num2,ver) {
  dis= ver ? '' : 'none';
  fila=document.getElementById('tabla').getElementsByTagName('tr');
  for(i=0;i<fila.length;i++)
    fila[i].getElementsByTagName('td')[num].style.display=dis;
    
    for(j=0;j<fila.length;j++)
    fila[j].getElementsByTagName('td')[num2].style.display=dis;
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
<% 	GestionTipoProducto negTipoProd = new GestionTipoProducto();
	Collection<TipoProducto> lista = negTipoProd.listar();
	  request.setAttribute("ListadoTipo",lista); %>
<div id="appDoctor">

  <form id="form1" name="form1" method="post" action="ProductoBuscarServlet">
    <table width="692" border="0">
      <tr>
        <td><div align="left"><span class="Estilo8">PRODUCTO</span></div></td>
        <td><span class="Estilo8">:</span></td>
        <td colspan="2"><label>
          <select name="cbotipo" id="cbotipo">
	        <option value="0">Seleccione</option>
	          <%
				for(TipoProducto c:lista){
					out.println("<option value="+c.getIdTipo()+">"+c.getTipo()+"</option>"); 
				}
				%>
        </select>
        </label></td>
                        
        <td><label><input type="text" name="bnombre" id="bnombre" /></label></td>
        <td><label>
          <input type="submit" name="button" id="button" value="Buscar" />
        </label></td>
        <td bgcolor="#6699FF">&nbsp;</td>
        <td><b><font face="Verdana" size="1"><a href="ProductoNuevo.jsp">Nuevo</a></font></b></td>
      </tr>
    </table>
  </form>



  <table width="100%" border="1">
  <br>
    <tr style="cursor:hand" onmouseover="this.style.background='#E1E1E1'; this.style.color='blue'" onmouseout="this.style.background='#FFFFFF'; this.style.color='black'">
    <td bgcolor="#D1F09D"><div align="center">
          <div align="right"><b><font face="Verdana" size="1" color="">REGISTRO</font></div></td>
      
		<td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color=""><div align="center"> PRODUCTO</div></font></b></td>
      <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center">PRECIO</div>
      </font></b></td>
            <td bgcolor="#D1F09D"><b><font face="Verdana" size="1" color="">
        <div align="center">TIPO</div>
      </font></b></td>
      <td colspan="2" bgcolor="#BFEA77"><b><font face="Verdana" size="1" color="">
        <div align="center">ACCIONES</div>
      </font></b></td>
    </tr>

<%@page import="java.util.*, clinicaveterinaria.modelo.Producto" %>
<%
Collection<Producto> arreglo = (ArrayList<Producto>)request.getAttribute("RESULTADO");
if(arreglo != null) { 
for(Producto x : arreglo) {
%>  
  <tr  bgcolor="#FFFFFF" style="cursor:hand" onmouseover="this.style.background='#E1E1E1'; this.style.color='blue'" onmouseout="this.style.background='#FFFFFF'; this.style.color='black'">
    <td bgcolor="#769EBC"><b><font face="Verdana" size="1" color="">
          <div align="right"><% out.print(x.getIdProducto()); %></div>
        </font></b></td>
    <td><b><font face="Verdana" size="1" color=""><% out.print(x.getProducto()); %></font></b></td>
    <td><b><font face="Verdana" size="1" color=""><% out.print(x.getPrecio()); %></font></b></td>
    
    <td bgcolor="#BFEA77"><b><font face="Verdana" size="1" color="">
    <div align="center"><a href="<%=request.getContextPath()%>/ProductoEliminarServlet?id=<%=x.getIdProducto()%>&tipo=<%=x.getoTipoProducto().getIdTipo()%>" onclick="return confirm('¿Está seguro que desea eliminar');">Eliminar</a></div>
    </font></b></td>
    <td bgcolor="#BFEA77"><b><font face="Verdana" size="1" color="">
    <div align="center"><a href="<%=request.getContextPath() %>/ProductoEditarServlet?id=<%=x.getIdProducto() %>">Modificar
    </a></div>
        </font></b></td>
  </tr>
<% }  
  } %>

  </table>

</div>
</body>
</html>
