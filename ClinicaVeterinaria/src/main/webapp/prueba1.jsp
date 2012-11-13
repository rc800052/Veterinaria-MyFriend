<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VeterinariaGozus</title>
<link type="text/css" href="css1/jquery-ui-1.8.6.css" rel="Stylesheet" />
<script type="text/javascript" src="css1/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="css1/jquery-ui-1.8.6.min.js"></script>

<script type="text/javascript">
$(function() {
	$('#dob').datepicker({dateFormat: 'dd/mm/yy', changeMonth: true, changeYear: true, yearRange: '-100:+0'});
});
</script>
</head>
<body>
<input type="text" name="dob" id="dob" />

	<img src="img\uno.jpg" alt="a"/>
</body>
</html>