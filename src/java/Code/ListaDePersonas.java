/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;
import proyectofinalclienteservidor.Persona;

/**
 *
 * @author Santiago
 */
public class ListaDePersonas {
    
    private boolean enUso;
    
    public ListaDePersonas(){
    }
    
    public synchronized ArrayList<Persona> getPersonas() throws InterruptedException{
        while(enUso){
            wait();
        }
        this.enUso = true;
        return Utils.users;
    }
    
    public synchronized void setPersonas(ArrayList<Persona> personas) throws InterruptedException{
        while(!enUso){
            wait();
        }
        Utils.users = personas;
        this.enUso = false;
        notify();
    }
}
