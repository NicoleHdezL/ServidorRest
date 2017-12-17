/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.Utils;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.Empleado;
import proyectofinalclienteservidor.EmpleadoPOJO;
import proyectofinalclienteservidor.NivelDePermisos;

/**
 * REST Web Service
 *
 * @author Santiago
 */
@Path("Empleado")
public class EmpleadoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmpleadoResource
     */
    public EmpleadoResource() {
    }

    /**
     * Retrieves representation of an instance of API.EmpleadoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("id") String id) {
        for (int i = 0; i < Utils.users.size(); i++) {
            if (Utils.users.get(i).getId().equals(id)) {
               return "El usuario ya existe.";
            }
        }
        return "Agregar";
    }

    /**
     * PUT method for updating or creating an instance of EmpleadoResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        EmpleadoPOJO pojo = new Gson().fromJson(content, EmpleadoPOJO.class);
        
        Empleado cliente = new Empleado(pojo.getName(), "universal", pojo.getEdad(), NivelDePermisos.Empleado,
                                        pojo.getId(), pojo.getSalario());
        
        Utils.users.add(cliente);
    }
}
