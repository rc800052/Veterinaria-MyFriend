<?php

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
?>
<div id="templatemo_header_wrapper">

	<div id="templatemo_header">
    
    	<div id="site_title">
            <h1><a href="index.php" target="_self">
                    <img src="images/veterinariaGozus.jpg" height="42" alt="Veterianria Gozus" />
                <span>Lo mejor para tu mascota</span>
            </a></h1>
        </div>
        
        <div id="search_box">
            <form action="#" method="get">
                <input type="text" value="" name="q" size="10" id="searchfield" title="searchfield" onfocus="clearText(this)" onblur="clearText(this)" />
                <input type="submit" name="Search" value="Buscar" alt="Buscar" id="searchbutton" title="Buscar" />
            </form>
        </div>
        
        <div class="cleaner"></div>
	</div><!-- end of header -->
    
    	<div id="templatemo_menu">
            <ul>
                <li><a href="index.php"<?php if($current_page == 1) echo ' class="current"'; ?>>Inicio</a></li>
                <li><a href="products.php"<?php if($current_page == 2) echo ' class="current"'; ?>>Productos</a></li>
                <li><a href="blog.php"<?php if($current_page == 3) echo ' class="current"'; ?>>Blog</a></li>
                <li><a href="gallery.php"<?php if($current_page == 4) echo ' class="current"'; ?>>Galería</a></li>
                <li><a href="contact.php"<?php if($current_page == 5) echo ' class="current"'; ?>>Contacto</a></li>
            </ul>    	
    	</div><!-- end of templatemo_menu -->

        <div id="templatemo_banner">
            
                <div id="one" class="contentslider">
                    <div class="cs_wrapper">
                        <div class="cs_slider">
                        
                            <div class="cs_article">
                            	
                                <div class="left">
                                    <h2>Suspendisse sed odio ut mi auctor blandit</h2>
                                    <p>Aliquam erat volutpat. Maecenas eget nisl id nisi consequat ultrices et  eu nunc. Praesent ac leo vel dolor rutrum egestas. Aliquam suscipit  vulputate arcu, quis congue ipsum laoreet sed.</p>
                                    
                                    <div class="button"><a href="#">Read more</a></div>
                               	</div>
                                <div class="right">
                               <a href="#"><img src="images/slider/templatemo_slide02.jpg" alt="Template 1" /></a>
								</div>
                                                                
                            </div><!-- End cs_article -->
                            
                            <div class="cs_article">
                                <div class="left">
                                    <h2>Suspendisse sed odio ut mi auctor blandit</h2>
                                    <p>Integer sed nisi sapien, ut gravida mauris. Nam et tellus libero. Cras purus libero, dapibus nec rutrum in, dapibus nec risus. Ut interdum mi sit amet magna feugiat auctor. </p>
                                    
                                    <div class="button"><a href="#">Read more</a></div>
                               	</div>
                                <div class="right">
                                <a href="#"><img src="images/slider/templatemo_slide01.jpg" alt="Template 2" /></a>
                                </div>
                            </div><!-- End cs_article -->
                            
                            <div class="cs_article">
                                <div class="left">
                                    <h2>Suspendisse sed odio ut mi auctor blandit</h2>
                                    <p>Integer sed nisi sapien, ut gravida mauris. Nam et tellus libero. Cras purus libero, dapibus nec rutrum in, dapibus nec risus. Ut interdum mi sit amet magna feugiat auctor. </p>
                                    
                                    <div class="button"><a href="#">Read more</a></div>
                               	</div>
                                <div class="right">
                                <a href="#"><img src="images/slider/templatemo_slide03.jpg" alt="Template 3" /></a>
                                </div>
                            </div><!-- End cs_article -->
                            
                            <div class="cs_article">
                                <div class="left">
                                    <h2>Suspendisse sed odio ut mi auctor blandit</h2>
                                    <p>Integer sed nisi sapien, ut gravida mauris. Nam et tellus libero. Cras purus libero, dapibus nec rutrum in, dapibus nec risus. Ut interdum mi sit amet magna feugiat auctor. </p>
                                    
                                    <div class="button"><a href="#">Read more</a></div>
                               	</div>
                                <div class="right">
                                <a href="#"><img src="images/slider/templatemo_slide04.jpg" alt="Template 4" /></a>
                                </div>
                            </div><!-- End cs_article -->
                      
                        </div><!-- End cs_slider -->
                    </div><!-- End cs_wrapper -->
                </div><!-- End contentslider -->
                
                <!-- Aqui iba el JS del slider -->
                
                <div class="cleaner"></div>
   
        </div>

</div> <!-- end of header_wrapper -->

<script src="js/jquery.1.6.1.min.js"></script>
<script src="js/simpleCart.js"></script>
<script src="js/cartConfig.js"></script>

<div style="text-align: center;">
    Carrito de compras: <span class="simpleCart_quantity"></span> item(s) - <span class="simpleCart_total"></span>
    <a href="cart.php">Ver</a> | 
    <a href="javascript:;" class="simpleCart_checkout">Checkout</a>
</div>