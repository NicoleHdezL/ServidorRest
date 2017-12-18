/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofinalclienteservidor.ClientePOJO;
import proyectofinalclienteservidor.Persona;

/**
 *
 * @author Santiago
 */
public class EliminaCliente implements Runnable{
    
    private ClientePOJO cliente;
    private ListaDePersonas personas;
    
    public EliminaCliente(ClientePOJO cliente, ListaDePersonas personas){
        this.cliente = cliente;
        this.personas = personas;
        
    }

    @Override
    public void run() {
        try {
            ArrayList<Persona> tempLista = this.personas.getPersonas();
            for(int i = 0; i < tempLista.size(); i++){
                if(tempLista.get(i).getId().equals(this.cliente.getId())){
                    tempLista.remove(i);
                }
            }
            this.personas.setPersonas(tempLista);
            System.out.println("Se elimina persona.");
        } catch (InterruptedException ex) {
            Logger.getLogger(EliminaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
