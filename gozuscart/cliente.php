<?php

require_once "cliente/RESTClient.php";

$rest = new RESTclient();

$url = "http://localhost:8080/gosus-rest/rs/producto-service/productos";
$rest->createRequest("$url","GET");

$rest->sendRequest();
$output = $rest->getResponse();
$lineas = round(count($output)/3,0);
?>
<?php for ($i=0; $i<$lineas; $i++) { ?>
                <tr>
                    <td>
                        <?php $j = 3*$i;
                        if( $output[$j] != null ) { ?>
                        <div class="simpleCart_shelfItem itemCarrito">
                            <h2 class="item_name"><?php echo $output[$j]["producto"]; ?></h2>
                            <div class="item-thumb "><img title="<?php echo $output[$j]["idProducto"]; ?>" src="images/cart/<?php echo $output[$j]["idProducto"]; ?>.jpg" /></div>
                            <p><input type="text" value="1" class="item_Quantity" /><br/>
                            <span class="item_price">S/<?php echo $output[$j]["precio"]; ?>.00</span><br/>
                            <a class="item_add" href="javascript:;"> Agregar al Carrito </a></p>
                        </div> 
                        <?php } ?>
                    </td>
                    <td>
                       <?php $j = 3*$i+1;
                        if( $output[$j] != null ) { ?>
                        <div class="simpleCart_shelfItem itemCarrito">
                            <h2 class="item_name"><?php echo $output[$j]["producto"]; ?></h2>
                            <div class="item-thumb "><img title="<?php echo $output[$j]["idProducto"]; ?>" src="images/cart/<?php echo $output[$j]["idProducto"]; ?>.jpg" /></div>
                            <p><input type="text" value="1" class="item_Quantity" /><br/>
                            <span class="item_price">S/<?php echo $output[$j]["precio"]; ?>.00</span><br/>
                            <a class="item_add" href="javascript:;"> Agregar al Carrito </a></p>
                        </div> 
                        <?php } ?>
                    </td>
                    <td>
                       <?php $j = 3*$i+2;
                        if( $output[$j] != null ) { ?>
                        <div class="simpleCart_shelfItem itemCarrito">
                            <h2 class="item_name"><?php echo $output[$j]["producto"]; ?></h2>
                            <div class="item-thumb "><img title="<?php echo $output[$j]["idProducto"]; ?>" src="images/cart/<?php echo $output[$j]["idProducto"]; ?>.jpg" /></div>
                            <p><input type="text" value="1" class="item_Quantity" /><br/>
                            <span class="item_price">S/<?php echo $output[$j]["precio"]; ?>.00</span><br/>
                            <a class="item_add" href="javascript:;"> Agregar al Carrito </a></p>
                        </div> 
                        <?php } ?>
                    </td>
                </tr>
<?php } ?>