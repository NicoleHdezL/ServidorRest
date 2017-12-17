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
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.ClientePOJO;

/**
 * REST Web Service
 *
 * @author Santiago
 */
@Path("NormalUser")
public class NormalUserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NormalUserResource
     */
    public NormalUserResource() {
    }

    /**
     * Retrieves representation of an instance of API.NormalUserResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("id") String id) {
        //TODO return proper representation object
        for (int i = 0; i < Utils.users.size(); i++) {
            if (Utils.users.get(i).getId().equals(id)) {
                ClientePOJO pojo = new ClientePOJO(Utils.users.get(i).getName(),
                                                   Utils.users.get(i).getAge(),
                                                   Utils.users.get(i).getId(),
                                                   5, 12.5, null);
                return new Gson().toJson(pojo);
            }
        }
        return null;
    }

    /**
     * PUT method for updating or creating an instance of NormalUserResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content) {
    }
}
