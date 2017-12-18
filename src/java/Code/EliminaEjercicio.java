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
public class EliminaEjercicio implements Runnable{
    
    Ejercicios ejercicio;
    ListaDeEjercicios lista;
    
    public EliminaEjercicio(Ejercicios pojo, ListaDeEjercicios listaDeEjercicios){
        this.ejercicio = pojo;
        this.lista = listaDeEjercicios;
    }

    @Override
    public void run() {
        try {
            ArrayList<Ejercicios> tempLista = this.lista.getEjercicios();
            for(int i = 0; i < tempLista.size(); i++){
                if(tempLista.get(i).getIdUser().equals(this.ejercicio.getIdUser())){
                    if(tempLista.get(i).getNombreDeEjercicio().equals(this.ejercicio.getNombreDeEjercicio())){
                        tempLista.remove(i);
                    }
                }
            }
            this.lista.setEjercicios(tempLista);
            System.out.println("Se elimina ejercicio.");
        } catch (InterruptedException ex) {
            Logger.getLogger(EliminaEjercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
