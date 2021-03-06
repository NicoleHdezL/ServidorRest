/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.Utils;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.NivelDePermisos;

/**
 * REST Web Service
 *
 * @author Santiago
 */
@Path("Login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of API.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("id") String id, @QueryParam("password") String password) {
        for (int i = 0; i < Utils.users.size(); i++) {
            if (Utils.users.get(i).getId().equals(id)) {
                if (Utils.users.get(i).getPassword().equals(password)) {
                    if (Utils.users.get(i).getNivel() == NivelDePermisos.Administrador) {
                        return "Administrador";      
                    }else if(Utils.users.get(i).getNivel() == NivelDePermisos.Cliente){
                        return "Cliente";
                    }else if(Utils.users.get(i).getNivel() == NivelDePermisos.Empleado){
                        return "Empleado";
                    }
                }else{
                    return "Contraseña incorrecta.";
                }
            }
        }
        return "El usuario que usted ingresó, no existe.";
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
