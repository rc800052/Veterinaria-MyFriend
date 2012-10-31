<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.8.22.custom.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>


<script type="text/javascript">
$(document).ready(function() {
   $("#datepicker").datepicker();
});
</script>


</head>
<body>

	<input type="text" name="datepicker" id="datepicker"
		readonly="readonly" size="12" />

</body>
</html>