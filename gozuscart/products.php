<?php $current_page = 2; ?>
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
    
    	<h1>Nuestros Productos</h1>
        
        <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Praesent aliquam velit a magna sodales quis elementum ipsum auctor. Quisque sem orci, malesuada eu  blandit et, bibendum facilisis mi. Vestibulum justo tortor, congue ut  cursus vel, fringilla a felis.</p>
        
        <div class="cleaner_h30"></div>
        
        <style>
            div.itemCarrito {
                margin: 5px 15px 5px 15px;
            }
            div.itemCarrito p {
                text-align: center;
            }
            div.itemCarrito input {
                width: 50px;
                text-align: center;
            }
            .item_name {
                font-size: 16px;
                text-align: center;
            }
            div.item-thumb img {
                max-width: 160px;
                max-height: 160px;
                min-width: 160px;
            }
        </style>
        
        <div>
            <table>
                <?php require_once "cliente.php"; ?>
            </table>
        </div>
        
    </div> <!-- end of templatemo_content -->
        
        <?php require_once 'include/sidebar.php'; ?>

	<div class="cleaner"></div>
</div>
</div>
</div>
        
<?php require_once 'include/footer.php'; ?>

</body>
</html>