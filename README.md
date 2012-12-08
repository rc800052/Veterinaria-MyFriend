Veterinaria-Gozus
==================

UPC DSD Proyecto Veterinaria Gozus. El presente proyecto nos brinda una solución integral para registrar las citas de los pacientes desde el cloud.  Los doctores consultan en tiempo real las citas pendientes por atender. Asimismo, la veterinaria Gozus expone sus servicios de productos para el cosnumo de los carrito de compras de las veterinarias locales.


Equipo : MyFriend
------------------

Integrantes:

 
Renzo Huertas - u201216398 http://


Ricardo Campos - u800052 http://

Elianni Córdova - u920863 http://

Renzo Puertocarrero - u http://

Omar Carpio - u http://

Oscar Chafloke - u http://


Profesor:

José Díaz Díaz


Arquitectura
------------

Para su desarrollo se uso :

Java

PHP

MySQL

SQL

.NET



Usa servicios web SOAP, REST y Mensajería.


User Story
-----------


Iniciar sesión:

Permite registrarse como usuario del sistema.


Registro de Clientes:

Registrar nuevos clientes, previa verificación de duplicidad.

Registro de Productos:

Registrar productos, previa verificación de duplicidad.

Citas:
Registro y visualización de las citas pendientes de atención. 

Mensajería: 
El doctor confirma la cita y se envía al cliente.


Gozus in the cloud
------------------

1. Carrito de compras: http://gozuscart.ap01.aws.af.cm/

2. Web Service SOAP de autenticación: http://authgozus.apphb.com/Service1.asmx

3. Web Service RESTful de productos: http://gozus-rest.portoren.cloudbees.net/

4. Base de datos "clinicaveterinaria": ec2-23-21-211-172.compute-1.amazonaws.com | user: gozus | pwd: 123456789
4. Modulo empresarial Gozus


Actualización de las especificaciones del proyecto