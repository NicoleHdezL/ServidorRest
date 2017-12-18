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
@Path("Info")
public class InfoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InfoResource
     */
    public InfoResource() {
    }

    /**
     * Retrieves representation of an instance of API.InfoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("dato") String dato, @QueryParam("id") String id) {
        if(dato.equals("CantDeClientes")){
            return new Gson().toJson(Utils.users.size());
        } else if(dato.equals("ExisteUsuario")){
            for (int i = 0; i < Utils.users.size(); i++) {
                if (Utils.users.get(i).getId().equals(id)) {
                   return "El usuario ya existe.";
                }
            }
            return "Agregar";
        } else if(dato.equals("listaUsuarios")){
            List<String> lista = new ArrayList<>();
            if(Utils.users.size() > 3){
                for(int i = 3; i < Utils.users.size(); i++){
                    if(Utils.users.get(i).getNivel() == NivelDePermisos.Cliente){
                        String userID = Utils.users.get(i).getId();
                        lista.add(userID);
                    }
                }
                return new Gson().toJson(lista);
            }else{
                return "NoHay";
            }
        }
        return "Error infoResources, informe al administrador.";
    }

    /**
     * PUT method fr updating or creating an instance of InfoResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
