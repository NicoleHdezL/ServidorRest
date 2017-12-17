/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.Utils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.Ejercicios;

/**
 * REST Web Service
 *
 * @author Santiago
 */
@Path("Rutina")
public class RutinaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RutinaResource
     */
    public RutinaResource() {
    }

    /**
     * Retrieves representation of an instance of API.RutinaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("id") String id) {
        ArrayList<Ejercicios> ejercicios = new ArrayList<>();
        
        for (int i = 0; i < Utils.ejercicios.size(); i++) {
            if (Utils.ejercicios.get(i).getIdUser().equals(id)) {
                ejercicios.add(Utils.ejercicios.get(i));
            }
        }
        if(ejercicios.isEmpty()){
            return "NoHay";
        } else{
            return new Gson().toJson(ejercicios);
        }
        
    }

    /**
     * PUT method for updating or creating an instance of RutinaResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content) {
    }
}
