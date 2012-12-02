<?php $current_page = 5; ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Veterinaria Gozus</title>
<meta name="keywords" content="mascotas, veterinaria, clinica, perros, gatos" />
<meta name="description" content="Web site comercial de la veterinaria Gozus" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ennui.contentslider.css" rel="stylesheet" type="text/css" media="screen,projection" />
</head>
<body>

<?php require_once 'include/header.php'; ?>

<div id="templatemo_content_wrapper_outer">
<div id="templatemo_content_wrapper_inner">
<div id="templatemo_content_wrapper">

    <div id="templatemo_content">
        <h4>Company Name</h4>
        120-240 Quisque odio quam, <br />
        Pulvinar sit amet convallis eget, 10980<br />
        Venenatis ut turpis<br /><br />
        <strong>Email:</strong> info@yourcompany.com  
        
        <div class="cleaner_h40"></div>
        
        <h4>Envíanos un mensaje!</h4>
        <div id="contact_form">
        
            <form method="post" name="contact" action="#">
            
                <input type="hidden" name="post" value=" Send " />
                <label for="author">Nombre:</label> <input type="text" id="author" name="author" class="required input_field" />
                <div class="cleaner_h10"></div>
                
                <label for="email">Correo:</label> <input type="text" id="email" name="email" class="validate-email required input_field" />
                <div class="cleaner_h10"></div>
                
                <label for="url">Teléfono:</label> <input type="text" name="url" id="url" class="input_field" />
                <div class="cleaner_h10"></div>
                
                <label for="text">Mensaje:</label> <textarea id="text" name="text" rows="0" cols="0" class="required"></textarea>
                <div class="cleaner_h10"></div>
                
                <input style="font-weight: bold;" type="submit" class="submit_btn" name="submit" id="submit" value=" Enviar " />
                <input style="font-weight: bold;" type="reset" class="submit_btn" name="reset" id="reset" value=" Limpiar " />
            
            </form>
            
        </div>
        
    </div> <!-- end of templatemo_content -->
        
        <?php require_once 'include/sidebar.php'; ?>

	<div class="cleaner"></div>
</div>
<div class="cleaner"></div>
</div>
</div>
        
<?php require_once 'include/footer.php'; ?>

</body>
</html>