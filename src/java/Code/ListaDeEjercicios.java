/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;
import proyectofinalclienteservidor.Ejercicios;

/**
 *
 * @author Santiago
 */
public class ListaDeEjercicios {
    
    private boolean enUso;
    
    public ListaDeEjercicios(){
    }
    
    public synchronized ArrayList<Ejercicios> getEjercicios() throws InterruptedException{
        while(enUso){
            wait();
        }
        this.enUso = true;
        return Utils.ejercicios;
    }
    
    public synchronized void setEjercicios(ArrayList<Ejercicios> ejercicios) throws InterruptedException{
        while(!enUso){
            wait();
        }
        Utils.ejercicios = ejercicios;
        this.enUso = false;
        notify();
    }
    
}
