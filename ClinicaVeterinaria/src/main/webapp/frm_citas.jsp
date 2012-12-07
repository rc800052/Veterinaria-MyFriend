<%@taglib uri="/WEB-INF/displaytag.tld"  prefix="dt" %>
<%@taglib uri="/WEB-INF/c.tld"  prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Formulario Citas</title>

<link type="text/css" href="jquery/jquery-ui-1.8.13.custom.css" rel="stylesheet" />
<script type="text/javascript" src="jquery/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="jquery/jquery-ui-1.8.13.custom.min.js"></script>
<script type="text/javascript" src="jquery/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript">
$(function() {
//     $( "#txt_Fecha" ).datepicker({ 
//     	minDate: new Date(),
//     	dateFormat: 'yy-mm-dd hh:mm:ss'
//     });
    
    
    
    $('#txt_Fecha').datetimepicker({
		controlType: 'select',
		dateFormat: 'yy-mm-dd',
		timeFormat: 'hh:mm:ss',
		currentText: 'Ahora',
		closeText: 'Listo',
		timeText: '',
		dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
		monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo','Junio', 'Julio', 'Agosto', 'Septiembre','Octubre', 'Noviembre', 'Diciembre'],
		monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr','May', 'Jun', 'Jul', 'Ago','Sep', 'Oct', 'Nov', 'Dic']
	});
    $( "#txt_Fecha" ).datepicker("setDate", new Date() );
    
});
</script>

<script language="Javascript"> 

function f_buscar(){
	
	document.frmCitas.txh_Accion.value='buscar';
		document.frmCitas.action="ServletCitas";
		///alert("llleggooooooooooooooooooooooooooooooooo");
		document.frmCitas.submit();
	
	
	}
	function f_elegir(codigo){
	document.frmCitas.txt_codpaciente.value = (codigo);	
	//alert("llleggooooooooooooooooooooooooooooooooo");
	mostrar("capa1");
	
	}
	
	function mostrar(nombreCapa){ 
		document.getElementById(nombreCapa).style.visibility="visible"; 
} 
function ocultar(nombreCapa){ 
		document.getElementById(nombreCapa).style.visibility="hidden"; 
} 	
	function ValidaForm(){
	
	
	if(document.frmCitas.cbo_doctor.value==0){
	   alert("Seleccione Doctor");
       document.frmCitas.cbo_doctor.focus();
	  	}else if(document.frmCitas.txt_Descripcion.value==""){
	   alert("Inserte Descripcion");
       document.frmCitas.txt_Descripcion.focus();
   		}else if(document.frmCitas.txt_Telefono.value==""){
	   alert("Inserte Telefono");
       document.frmCitas.txt_Telefono.focus();
	   }else if(document.frmCitas.txt_Direccion.value==""){
	   alert("Inserte Direccion");
       document.frmCitas.txt_Direccion.focus();
	   }else if(document.frmCitas.txt_Fecha.value==""){
	   alert("Inserte Fecha");
       document.frmCitas.txt_Fecha.focus();
   	}else {f_aceptar();}

	}
function f_aceptar(){
		
		
		
		if (confirm("¿Seguro que desea GRABAR ?")) {
     	document.frmCitas.txh_Accion.value='insertar';
		document.frmCitas.action="ServletCitas";
		document.frmCitas.submit();
		 alert("Gravacion satisfactoria");
     
}

	}	
</script>
</head>
<style type="text/css" media="all">
     
      @import url("css/screen.css");

</style>
<body>
<form name="frmCitas" method="post" action="">
<input type="hidden" name="txh_Accion" >
<input type="hidden" name="txt_codpaciente" >
<input type="hidden" name="txt_codcliente" value="<%=request.getAttribute("cod1")%>" >


<table width="700" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#7d9477">
  <tr>
    <td><img src="<%= request.getContextPath() %>/_img/veterinariaGozus1.jpg" /></td>
  </tr>
  <tr>
    <td><div align="center">
      <input name="txt_Codigo" type="text" id="txt_Codigo" value="" size="10">
      <a href="javascript:f_buscar()" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('agregar','',
		'<%= request.getContextPath() %>/_img/btn_buscar_b.gif',1)"><img src="<%= request.getContextPath() %>/_img/btn_buscar_a.gif" name="btn_Agregar" width="90" height="30" border="0" id="agregar"></a></div></td>
  </tr>
  <tr>
    <td>
<dt:table  name="listaPacientes" requestURI="CitasDTServlet" pagesize="10" id="clasif"  class="isis"> 	
<dt:column property="idPaciente"  title="CODIGO" sortable="true"   > </dt:column>
<dt:column property="nombre"  title="DESCRIPCION" sortable="true" maxLength="25" > </dt:column>
<dt:column property="especie"  title="IDENTIFICACION" sortable="true" > </dt:column>
<dt:column property="raza"  title="ESTADO" sortable="true" > </dt:column>
<dt:column property="genero"  title="ESTADO" sortable="true" > </dt:column>
<dt:column title="Elegir" >  
<input type="radio" name="radio" id="radio" value="radio" onClick="javascript:f_elegir('<c:out value="${clasif.idPaciente}"/>',
                    '<c:out value="${clasif.nombre}"/>');" />
</dt:column>

</dt:table>	

</td>
  </tr>
  <tr>
    <td><div align="center" id="capa1" style="visibility:hidden" >
    <table width="736" border="0" cellpadding="0" cellspacing="0">
    <tr>
              <td colspan="2">DETALLES DE LA CITAS</td>
            </tr>
            <tr>
              <td width="94"><div align="right"><span class="Estilo1">Doctor : </span></div></td>
              <td width="638"><select name=cbo_doctor id="cbo_doctor">
                  <option value="0">Seleccione</option>
                  <option value="1">Juan-Perez</option>
                  <option value="2">Ricardo-Campos</option>
                  <option value="3">Juan-Tapia</option>
              </select></td>
            </tr>
            <tr>
              <td height="54"><div align="right"><span class="Estilo1">Descripcion : </span></div></td>
              <td><textarea name="txt_Descripcion" cols="2"  rows="1" style="width:200px;height:50px" ></textarea></td>
            </tr>
            <tr>
              <td><div align=right width="50%"><span class="Estilo1">Telefono : </span></div></td>
              <td><input name="txt_Telefono" type="text" id="txt_Telefono" size="10" /></td>
            </tr>
            <tr>
              <td><div align=right width="30%"><span class="Estilo1">Direccion : </span></div></td>
              <td><input name="txt_Direccion" type="text" id="txt_Direccion" size="70" /></td>
            </tr>
            <tr>
              <td><div align=right width="50%"><span class="Estilo1">Fecha : </span></div></td>
              <td><input name="txt_Fecha" type="text" id="txt_Fecha" size="50" /></td>
            </tr>
            <tr>
                <td width="112"><div align="left"><a href="javascript:ValidaForm()" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('grabar','','<%= request.getContextPath() %>/_img/btn_grabar_b.gif',1)"><img src="<%= request.getContextPath() %>/_img/btn_grabar_a.gif" alt="buscar" name="grabar" width="90" height="30" border="0" id="grabar"></a></div></td>
                <td width="248"><div align="left"><a href="javascript:f_reset();" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('cancela','','<%= request.getContextPath() %>/_img/btn_cancelar_b.gif',1)"><img src="<%= request.getContextPath() %>/_img/btn_cancelar_a.gif" alt="buscar" name="cancela" width="90" height="30" border="0"></a></div></td>
              </tr>
          </table>
    </div></td>
  </tr>
</table>
</form>
</body>
</html>
