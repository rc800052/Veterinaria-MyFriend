<?php $current_page = 0; ?>
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
    
    	<h1>Carrito de Compras</h1>
        
        <div class="cleaner_h30"></div>
        
        <style>
		.simpleCart_items table{
			border:1px solid #ccc;
		}
		.simpleCart_items th{
			color:#333;
			text-align:left;
			padding:10px 10px;
			border-bottom:1px solid #ccc;
			background: #ededed;
			background: -moz-linear-gradient(top,  #f7f7f7 0%, #ededed 100%);
			background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#f7f7f7), color-stop(100%,#ededed));
			background: -webkit-linear-gradient(top,  #f7f7f7 0%,#ededed 100%);
			background: -o-linear-gradient(top,  #f7f7f7 0%,#ededed 100%);
			background: -ms-linear-gradient(top,  #f7f7f7 0%,#ededed 100%);
			background: linear-gradient(top,  #f7f7f7 0%,#ededed 100%);
			filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f7f7f7', endColorstr='#ededed',GradientType=0 );
		}
		.simpleCart_items td{
			padding:10px 10px;
			vertical-align:middle;
			border-bottom:1px solid #ccc;
			
		}
		.item-image,
		.item-image img{width:72px;}
		.item-name{width:50%;}
		.item-quantity,
		.item-quantity input{
			width:30px;
			text-align:center;
		}
		.item-price,
		.item-subtotal{width:50px;}
                .hudbtn{
                        -webkit-border-radius:3px;
                        -moz-border-radius:3px;
                        border-radius:3px;
                        font:bold 13px/26px "FreightSans", sans-serif;
                        color:#d9d9d9;
                        text-shadow:1px 1px 1px rgba(0,0,0,.5);
                        padding:0 12px;
                        height:24px;
                        border:1px solid #000;
                        -webkit-box-shadow:inset 0 1px 0 #6d6d6e;
                        -moz-box-shadow:inset 0 1px 0 #6d6d6e;
                        box-shadow:inset 0 1px 0 #6d6d6e;

                        background: #3a3a3b; /* Old browsers */
                        background: -moz-linear-gradient(top,  #3a3a3b 0%, #343434 100%); /* FF3.6+ */
                        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#3a3a3b), color-stop(100%,#343434)); /* Chrome,Safari4+ */
                        background: -webkit-linear-gradient(top,  #3a3a3b 0%,#343434 100%); /* Chrome10+,Safari5.1+ */
                        background: -o-linear-gradient(top,  #3a3a3b 0%,#343434 100%); /* Opera 11.10+ */
                        background: -ms-linear-gradient(top,  #3a3a3b 0%,#343434 100%); /* IE10+ */
                        background: linear-gradient(top,  #3a3a3b 0%,#343434 100%); /* W3C */
                        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3a3a3b', endColorstr='#343434',GradientType=0 ); /* IE6-9 */

                }
                .hudbtn:hover{
                        background: #2f2f30; /* Old browsers */
                        background: -moz-linear-gradient(top,  #2f2f30 0%, #282828 100%); /* FF3.6+ */
                        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#2f2f30), color-stop(100%,#282828)); /* Chrome,Safari4+ */
                        background: -webkit-linear-gradient(top,  #2f2f30 0%,#282828 100%); /* Chrome10+,Safari5.1+ */
                        background: -o-linear-gradient(top,  #2f2f30 0%,#282828 100%); /* Opera 11.10+ */
                        background: -ms-linear-gradient(top,  #2f2f30 0%,#282828 100%); /* IE10+ */
                        background: linear-gradient(top,  #2f2f30 0%,#282828 100%); /* W3C */
                        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#2f2f30', endColorstr='#282828',GradientType=0 ); /* IE6-9 */
                }
                .hudbtn:active{
                        -webkit-box-shadow:none;
                        -moz-box-shadow:none;
                        box-shadow:none;
                        background: #282828; /* Old browsers */
                        background: -moz-linear-gradient(top,  #282828 0%, #2f2f30 100%); /* FF3.6+ */
                        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#282828), color-stop(100%,#2f2f30)); /* Chrome,Safari4+ */
                        background: -webkit-linear-gradient(top,  #282828 0%,#2f2f30 100%); /* Chrome10+,Safari5.1+ */
                        background: -o-linear-gradient(top,  #282828 0%,#2f2f30 100%); /* Opera 11.10+ */
                        background: -ms-linear-gradient(top,  #282828 0%,#2f2f30 100%); /* IE10+ */
                        background: linear-gradient(top,  #282828 0%,#2f2f30 100%); /* W3C */
                        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#282828', endColorstr='#2f2f30',GradientType=0 ); /* IE6-9 */
                }
                .hudbtn.primary{
                        border-color:#3D7530;
                        background: #97c865; /* Old browsers */
                        background: -moz-linear-gradient(top,  #97c865 0%, #44933d 100%); /* FF3.6+ */
                        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#97c865), color-stop(100%,#44933d)); /* Chrome,Safari4+ */
                        background: -webkit-linear-gradient(top,  #97c865 0%,#44933d 100%); /* Chrome10+,Safari5.1+ */
                        background: -o-linear-gradient(top,  #97c865 0%,#44933d 100%); /* Opera 11.10+ */
                        background: -ms-linear-gradient(top,  #97c865 0%,#44933d 100%); /* IE10+ */
                        background: linear-gradient(top,  #97c865 0%,#44933d 100%); /* W3C */
                        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#97c865', endColorstr='#44933d',GradientType=0 ); /* IE6-9 */
                        -webkit-box-shadow:inset 0 1px 0 #D8E994;
                        -moz-box-shadow:inset 0 1px 0 #D8E994;
                        box-shadow:inset 0 1px 0 #D8E994;
                        color:#fff;
                }
                .hudbtn.primary:hover{
                        background: #91bf61; /* Old browsers */
                        background: -moz-linear-gradient(top,  #91bf61 0%, #3f8738 100%); /* FF3.6+ */
                        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#91bf61), color-stop(100%,#3f8738)); /* Chrome,Safari4+ */
                        background: -webkit-linear-gradient(top,  #91bf61 0%,#3f8738 100%); /* Chrome10+,Safari5.1+ */
                        background: -o-linear-gradient(top,  #91bf61 0%,#3f8738 100%); /* Opera 11.10+ */
                        background: -ms-linear-gradient(top,  #91bf61 0%,#3f8738 100%); /* IE10+ */
                        background: linear-gradient(top,  #91bf61 0%,#3f8738 100%); /* W3C */
                        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#91bf61', endColorstr='#3f8738',GradientType=0 ); /* IE6-9 */
                }
                .hudbtn.primary:active{
                        background: #3f8738; /* Old browsers */
                        background: -moz-linear-gradient(top,  #3f8738 0%, #91bf61 100%); /* FF3.6+ */
                        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#3f8738), color-stop(100%,#91bf61)); /* Chrome,Safari4+ */
                        background: -webkit-linear-gradient(top,  #3f8738 0%,#91bf61 100%); /* Chrome10+,Safari5.1+ */
                        background: -o-linear-gradient(top,  #3f8738 0%,#91bf61 100%); /* Opera 11.10+ */
                        background: -ms-linear-gradient(top,  #3f8738 0%,#91bf61 100%); /* IE10+ */
                        background: linear-gradient(top,  #3f8738 0%,#91bf61 100%); /* W3C */
                        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3f8738', endColorstr='#91bf61',GradientType=0 ); /* IE6-9 */
                        -webkit-box-shadow:none;
                        -moz-box-shadow:none;
                        box-shadow:none;
                }
                div.tblTotales table {
			border-bottom:1px solid #ccc;
                        text-align: right;
                }
                div.tblTotales td {
                        padding:10px 10px;
			vertical-align:middle;
                        text-align: right;
			border-bottom:1px solid #ccc;
                }
	</style>
        
        <div class="simpleCart_items"></div>
        
        <div class="tblTotales">
            <table>
                <tr>
                    <td>Subtotal: </td>
                    <td><span class="simpleCart_total"></span></td>
                </tr>
                <tr>
                    <td>IGV (18%): </td>
                    <td><span class="simpleCart_tax"></span> </td>
                </tr>
                <tr>
                    <td>Total: </td>
                    <td><span class="simpleCart_grandTotal"></span></td>
                </tr>
            </table>
        </div>
        
        <div style="text-align: center;">
            <br />
            <a href="products.php" class="hudbtn primary">Seguir Comprando</a>
            <a href="javascript:;" class="simpleCart_checkout hudbtn primary">Realizar Compra</a>
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