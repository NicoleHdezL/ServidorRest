/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Code.ListaDeEjercicios;
import Code.ListaDePersonas;
import Code.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.Administrador;
import proyectofinalclienteservidor.Cliente;
import proyectofinalclienteservidor.Ejercicios;
import proyectofinalclienteservidor.Empleado;
import proyectofinalclienteservidor.NivelDePermisos;
import proyectofinalclienteservidor.Tarifas;

/**
 * REST Web Service
 *
 * @author Santiago
 */
@Path("Inicio")
public class InicioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InicioResource
     */
    public InicioResource() {
    }

    /**
     * Retrieves representation of an instance of API.InicioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        System.out.println("Invocado de inicio");
        if(Utils.yaInicio == false){
            Administrador admin = new Administrador("Administrador", "admin", 0, NivelDePermisos.Administrador, "1");
            Empleado empleado = new Empleado("Empleado", "empleado", 0, NivelDePermisos.Empleado, "2", 100000.0);
            Cliente cliente = new Cliente("Cliente", 0, "cliente", NivelDePermisos.Cliente, "3", 24, "", Tarifas.Parejas);
            Utils.users.add(admin);
            Utils.users.add(empleado);
            Utils.users.add(cliente);
            
            Ejercicios ejer1 = new Ejercicios("3", 34.5, 6, "Ejercicio 1", "Primera", "2x3");
            Ejercicios ejer2 = new Ejercicios("3", 34.5, 6, "Ejercicio 2", "Sgunda", "2x3");
            
            Utils.ejercicios.add(ejer1);
            Utils.ejercicios.add(ejer2);
            
            Utils.servicio = Executors.newCachedThreadPool();
            Utils.personas = new ListaDePersonas();
            Utils.listaDeEjercicios = new ListaDeEjercicios();
            
            Utils.yaInicio = true;
        }
        return "Ok";
    }

    /**
     * PUT method for updating or creating an instance of InicioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
