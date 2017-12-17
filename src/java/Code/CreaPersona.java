/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofinalclienteservidor.Cliente;
import proyectofinalclienteservidor.ClientePOJO;
import proyectofinalclienteservidor.Empleado;
import proyectofinalclienteservidor.EmpleadoPOJO;
import proyectofinalclienteservidor.NivelDePermisos;
import proyectofinalclienteservidor.Persona;
import proyectofinalclienteservidor.Tarifas;

/**
 *
 * @author Santiago
 */
public class CreaPersona implements Runnable{
    
    private String tipoPersona;
    private EmpleadoPOJO empleado = null;
    private ClientePOJO cliente = null;
    private ListaDePersonas personas;

    public CreaPersona(EmpleadoPOJO pojo, ListaDePersonas personas) {
        this.tipoPersona = "Empleado";
        this.empleado = pojo;
        this.personas = personas;
    }
    
    public CreaPersona(ClientePOJO pojo, ListaDePersonas personas) {
        this.tipoPersona = "Cliente";
        this.cliente = pojo;
        this.personas = personas;
    }

    @Override
    public void run() {
        if(this.tipoPersona.equals("Empleado")){
            try {
                Empleado empleado = new Empleado(this.empleado.getName(), "universal", this.empleado.getEdad(), NivelDePermisos.Empleado,
                        this.empleado.getId(), this.empleado.getSalario());
                ArrayList<Persona> tempPersona = this.personas.getPersonas();
                tempPersona.add(empleado);
                this.personas.setPersonas(tempPersona);
                System.out.println("Se agrega empleado");
                System.out.println("Cantidad de users: " + Utils.users.size());
            } catch (InterruptedException ex) {
                Logger.getLogger(CreaPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(this.tipoPersona.equals("Cliente")){
            try {
                Cliente cliente = new Cliente(this.cliente.getName(), this.cliente.getAge(), "universal", NivelDePermisos.Cliente,
                        this.cliente.getId(), this.cliente.getMesesEnGym(), "", Tarifas.Parejas);
                ArrayList<Persona> tempPersona = this.personas.getPersonas();
                tempPersona.add(cliente);
                this.personas.setPersonas(tempPersona);
                System.out.println("Se agrega empleado");
                System.out.println("Cantidad de users: " + Utils.users.size());
            } catch (InterruptedException ex) {
                Logger.getLogger(CreaPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
