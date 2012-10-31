<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="css1/jquery-ui-1.8.6.css" rel="Stylesheet" />
<script type="text/javascript" src="css1/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="css1/jquery-ui-1.8.6.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
$(function() {
	$('#dob').datepicker({dateFormat: 'dd/mm/yy', changeMonth: true, changeYear: true, yearRange: '-100:+0'});
});
</script>
<title>Insert title here</title>
</head>
<body>
<input type="text" name="dob" id="dob" />

	<img src="_img\uno.jpg" alt="a"/>
</body>
</html>