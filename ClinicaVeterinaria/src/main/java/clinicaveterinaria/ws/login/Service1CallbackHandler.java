
/**
 * Service1CallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package clinicaveterinaria.ws.login;

    /**
     *  Service1CallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class Service1CallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public Service1CallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public Service1CallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for helloWorld method
            * override this method for handling normal response from helloWorld operation
            */
           public void receiveResulthelloWorld(
                    clinicaveterinaria.ws.login.Service1Stub.HelloWorldResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from helloWorld operation
           */
            public void receiveErrorhelloWorld(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validarUsuario method
            * override this method for handling normal response from validarUsuario operation
            */
           public void receiveResultvalidarUsuario(
                    clinicaveterinaria.ws.login.Service1Stub.ValidarUsuarioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validarUsuario operation
           */
            public void receiveErrorvalidarUsuario(java.lang.Exception e) {
            }
                


    }
    