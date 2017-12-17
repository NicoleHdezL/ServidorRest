/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.CreaPersona;
import Code.Utils;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.ClientePOJO;

/**
 * REST Web Service
 *
 * @author Santiago
 */
@Path("ModCliente")
public class ModClienteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ModClienteResource
     */
    public ModClienteResource() {
    }

    /**
     * Retrieves representation of an instance of API.ModClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ModClienteResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        ClientePOJO pojo = new Gson().fromJson(content, ClientePOJO.class);
        for (int i = 0; i < Utils.users.size(); i++) {
            if (Utils.users.get(i).getId().equals(pojo.getId())) {
               Utils.users.remove(i);
            }
        }
        CreaPersona hilo = new CreaPersona(pojo, Utils.personas);
        Utils.servicio.submit(hilo);
    }
}
