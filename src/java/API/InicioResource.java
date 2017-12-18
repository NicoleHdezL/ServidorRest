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
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import proyectofinalclienteservidor.Administrador;
import proyectofinalclienteservidor.Cliente;
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
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        String recibe = content;
        Empleado empleado1 = new Empleado("Aldo Mora", "admin", 28, NivelDePermisos.Empleado, "12345", 100000.0);
        Empleado empleado2 = new Empleado("Nicole Hernandez", "admin", 22, NivelDePermisos.Empleado, "23456", 100000.0);
        Empleado empleado3 = new Empleado("Santiago Méndez", "admin", 21, NivelDePermisos.Empleado, "34567", 100000.0);
        
        Cliente cliente1 = new Cliente("Juan", 23, "cliente", NivelDePermisos.Cliente, "102340543", 24, "", Tarifas.Parejas);
        Cliente cliente2 = new Cliente("Marcelo", 18, "cliente", NivelDePermisos.Cliente, "214235432", 24, "", Tarifas.Parejas);
        Cliente cliente3 = new Cliente("Stephanie", 28, "cliente", NivelDePermisos.Cliente, "114324323", 24, "", Tarifas.Parejas);
        Cliente cliente4 = new Cliente("William", 32, "cliente", NivelDePermisos.Cliente, "116540453", 24, "", Tarifas.Parejas);
        Cliente cliente5 = new Cliente("Catalina", 26, "cliente", NivelDePermisos.Cliente, "212430654", 24, "", Tarifas.Parejas); 
        
        Utils.users.add(empleado1);
        Utils.users.add(empleado2);
        Utils.users.add(empleado3);
        
        Utils.users.add(cliente1);
        Utils.users.add(cliente2);
        Utils.users.add(cliente3);
        Utils.users.add(cliente4);
        Utils.users.add(cliente5);
        
    }
}
