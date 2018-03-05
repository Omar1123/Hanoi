/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Handlers.Handler;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Menu {
    
    private Handler handler;
    private int numberOfPiezes;
    
    public Menu() {
        handler = new Handler();
        numberOfPiezes = 0;
    }
    
    public void showMenu() {        
        
        Scanner scannerPlay = new Scanner(System.in);
        int respuesta;
        respuesta = 0;
        try {
         
            System.out.println("MENU");
            System.out.println("1............ JUGAR"); 
            System.out.println("2............ HISTORIAL"); 
            respuesta = scannerPlay.nextInt();
           
            if(respuesta==1){
                play();
            }else{
                history();
            }
            
            
        } catch(Exception ex) {
            System.out.println("Opcion incorrecta");
            showMenu();
        }                
    }
    
    public void play(){
        Scanner scannerPlay = new Scanner(System.in);
        
        try {
         
            System.out.println("HANOI");
            System.out.println("Ingrese el numero de discos con las que empezara");        

            numberOfPiezes = scannerPlay.nextInt();

            handler.startGame(numberOfPiezes);
            
        } catch(Exception ex) {
            System.out.println("Solo se pueden ingresar numeros");
            showMenu();
        }
    }
    
    public void history() throws IOException{
        handler.showHistory();
    }
    
}
