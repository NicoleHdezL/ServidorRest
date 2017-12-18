/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import proyectofinalclienteservidor.Ejercicios;
import proyectofinalclienteservidor.Persona;

/**
 *
 * @author ADNDC\jcortes
 */
public class Utils {
    
    public static ArrayList <Persona> users = new ArrayList<>();
    public static boolean yaInicio = false;
    public static ArrayList<Ejercicios> ejercicios = new ArrayList<>();
    public static ListaDePersonas personas;
    public static ListaDeEjercicios listaDeEjercicios;
    public static ExecutorService servicio;
}
