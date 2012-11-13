<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VeterinariaGozus</title>

<script>
	function validar() {

		var x = document.f1.txtUsuario.value;
		var y = document.f1.txtClave.value;

		if (x == "") {
			alert("Ingrese Usuario");
			return false;
		}

		if (y == "") {
			alert("Ingrese Clave");
			return false;
		}

		return true;

	}
</script>

<style type="text/css">
#apDiv2 {
	position: absolute;
	left: 0;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 2;
	background-color: #D1E09D;
}

.boton {
	font-family: Verdana, sans-serif;
	font-size: 10px;
	color: #333333;
	border: 1px #666666 solid;
	background-color: #669900;
	font-weight: bold
}
</style>
</head>
<body>
	<div id="apDiv2">
		<center>
			<form name="f1" action="LoginServlet" method="post">
				<br /> <br /> <br /> <br /> 
				<font face="Verdana" size="2" color="">								
					<table width="463" border="0" cellpadding="2" cellspacing="4" style="border: 1px solid #669900; color: #000000; width: 430px;">
						<tr>
							<td rowspan="4"><img src="img/veterinariaGozus.jpg" alt="a" width="183" height="138" />
							</td>
							<td height="28" colspan="2"><div align="center">
									<strong>INICIAR SESION</strong>
								</div>
							</td>
						</tr>
						<tr>
							<td height="29"><div align="right">
									<b>Usuario :</b>
								</div>
							</td>
							<td><input type="text" name="usuario" />
							</td>
						</tr>
						<tr>
							<td height="29"><div align="right">
									<b>Clave :</b>
								</div>
							</td>
							<td><input type="password" name="clave" />
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input class="boton" type="submit" value="Ingresar"></input> 
								<input class="boton" type="reset" value="Cancelar"></input>
							</td>
						</tr>
					</table> 
					</font>
			</form>
		</center>
	</div>
</body>
</html>
