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
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.Cliente;
import proyectofinalclienteservidor.ClientePOJO;
import proyectofinalclienteservidor.NivelDePermisos;
import static proyectofinalclienteservidor.NivelDePermisos.Cliente;
import proyectofinalclienteservidor.Tarifas;


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
    public String getJson(@QueryParam("id") String id) {
        ClientePOJO cliente = null;
        for (int i = 0; i < Utils.users.size(); i++) {
            if (Utils.users.get(i).getId().equals(id)) {
                String name = Utils.users.get(i).getName();
                String identificacion = Utils.users.get(i).getId();
                int age = Utils.users.get(i).getAge();
                cliente = new ClientePOJO(name, age, identificacion, 0, 0, null);
                break;
            }
        }
        return new Gson().toJson(cliente);
    }

    /**
     * PUT method for updating or creating an instance of ClienteResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content) {
        ClientePOJO pojo = new Gson().fromJson(content, ClientePOJO.class);
        CreaPersona hilo = new CreaPersona(pojo, Utils.personas);
        Utils.servicio.submit(hilo);
    }
}
