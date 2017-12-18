/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.EliminaCliente;
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
@Path("EliminarCliente")
public class EliminarClienteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EliminarClienteResource
     */
    public EliminarClienteResource() {
    }

    /**
     * Retrieves representation of an instance of API.EliminarClienteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of EliminarClienteResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        ClientePOJO pojo = new Gson().fromJson(content, ClientePOJO.class);
        EliminaCliente hilo = new EliminaCliente(pojo, Utils.personas);
        Utils.servicio.submit(hilo);
    }
}
