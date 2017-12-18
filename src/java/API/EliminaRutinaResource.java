/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.EliminaEjercicio;
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
import proyectofinalclienteservidor.Ejercicios;

/**
 * REST Web Service
 *
 * @author Santiago
 */
@Path("EliminaRutina")
public class EliminaRutinaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EliminaRutinaResource
     */
    public EliminaRutinaResource() {
    }

    /**
     * Retrieves representation of an instance of API.EliminaRutinaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return null;
    }

    /**
     * PUT method for updating or creating an instance of EliminaRutinaResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        Ejercicios pojo = new Gson().fromJson(content, Ejercicios.class);
        EliminaEjercicio hilo = new EliminaEjercicio(pojo, Utils.listaDeEjercicios);
        Utils.servicio.submit(hilo);
    }
}
