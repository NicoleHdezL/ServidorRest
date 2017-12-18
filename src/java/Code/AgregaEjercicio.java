/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectofinalclienteservidor.Ejercicios;

/**
 *
 * @author Santiago
 */
public class AgregaEjercicio implements Runnable{
    
    Ejercicios ejercicio;
    ListaDeEjercicios lista;
    
    public AgregaEjercicio(Ejercicios pojo, ListaDeEjercicios listaDeEjercicios){
        this.ejercicio = pojo;
        this.lista = listaDeEjercicios;
    }

    @Override
    public void run() {
        try {
            Ejercicios ejercicio = new Ejercicios(this.ejercicio.getIdUser(), this.ejercicio.getPesos(),
                    this.ejercicio.getNumeroDeMaquina(), this.ejercicio.getNombreDeEjercicio(),
                    this.ejercicio.getCategoría(), this.ejercicio.getRepeticiones());
            ArrayList<Ejercicios> tempLista = this.lista.getEjercicios();
            tempLista.add(ejercicio);
            this.lista.setEjercicios(tempLista);
            System.out.println("Se agrega ejercicio.");
        } catch (InterruptedException ex) {
            Logger.getLogger(AgregaEjercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
