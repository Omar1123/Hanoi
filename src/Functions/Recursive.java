/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Handlers.Handler;

/**
 *
 * @author alumno
 */
public class Recursive {
    
    /*private Handler handler;
    
    public Recursive() {
        handler = new Handler();
    }*/
    
    /**
     *@param disco
     *@param origen
     *@param intermedio
     *@param destino
     */    
    public void Hanoi(int disco, int origen,  int intermedio, int destino){
        if(disco==1) {            
            System.out.println("Mover disco " + disco + " de "+ origen + " a " + destino);
            //handler.createStorePurchase("Mover disco ", disco, origen, intermedio, destino);
        } else {           
           
            Hanoi(disco-1, origen, destino, intermedio);
           System.out.println("Mover disco "+disco+ " de "+ origen + " a " + destino);
           
           //handler.createStorePurchase("Mover disco ", disco, origen, intermedio, destino);
           
           Hanoi(disco-1, intermedio, origen, destino);
         }
    } 
    
}
