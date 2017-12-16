/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import GUI.Administrador;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.Utils;
import GUI.LogIn;
import proyectofinalclienteservidor.NivelDePermisos;


/**
 * REST Web Service
 *
 * @author Santiago
 */
@Path("Cliente")
public class ClienteResource {
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClienteResource
     */
    public ClienteResource() {
    }

    /**
     * Retrieves representation of an instance of API.ClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("user") String user, @QueryParam("password") String password) {
        System.out.println(user);
        String respuesta = "";

        for (int i = 0; i < Utils.users.size(); i++) {
            if (Utils.users.get(i).getName().equals(user)) {
                if (Utils.users.get(i).getPassword().equals(password)) {
                    if (Utils.users.get(i).getNivel() == NivelDePermisos.Administrador) {
                        respuesta = "Admin";      
                    }else if(Utils.users.get(i).getNivel() == NivelDePermisos.Cliente){
                        respuesta = "Cliente";
                    }else if(Utils.users.get(i).getNivel() == NivelDePermisos.Empleado){
                        respuesta = "Empleado";
                    }
                }else{
                    respuesta = "incorrecto";
                }
            }else{
                respuesta = "no existe";
            }
            
        }
        return respuesta;
    }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content) {
        
    }
}
