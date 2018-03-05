/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Functions.Recursive;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Handler {           
            
    private static int maximeNumbers = 4;            
    private static int numberOfIntents;
    
    private FileOutputStream fileStream;    
    private File FILENAME = new File("C:\\Users\\alumno\\Documents\\NetBeansProjects\\Hanoi\\src\\Storage\\game.txt");
    private DataOutputStream data;   
    
    private Recursive recursive;
        
    public Handler() {
        numberOfIntents = 0;
        recursive = new Recursive();
    }
    
    public void startGame(int piezes) {
        
        createStoreFile(FILENAME);      
        
        try {
            Hanoi(piezes, 1, 2, 3);
        } catch(Exception ex) {
            System.out.println("Ha excedido los recursos de la computadora");
        }        
    }
    
    public void updateIntents() {
        numberOfIntents = numberOfIntents + 1;
    }        
    
    /*public static void purchase(String action ,int disc, int origin, int intermediate, int destiny) {
        createStorePurchase(action,disc,origin,intermediate,destiny);
    }*/
    
    public void createStorePurchase(File file, String action ,int disc, int origin, int intermediate, int destiny) {        
        try {                     
                        
            if(!file.exists()){  
                file.createNewFile();
            }
            
            BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILENAME,true), "utf-8"));
            
            writter.write(action + " " + String.valueOf(disc) + " de Torre(" + String.valueOf(origin) + ") a Torre(" + String.valueOf(destiny) + "),\r\n");
          
            writter.close();
            
            System.out.println("Se ha realizado con exito su compra");            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }      
    }
    
    private void createStoreFile(File file) {
        
        System.out.println("Creando el documento con los datos");
        
        try {          
            if(!file.exists()){
                file.createNewFile();
            }          
        } catch (Exception ex) {            
            System.out.println(ex.getMessage());
        } 
    }
    
    public void Hanoi(int disco, int origen,  int intermedio, int destino){
        if(disco==1) {            
            System.out.println("Mover disco " + disco + " de Torre("+ origen + ") a Torre(" + destino+")");
            createStorePurchase(FILENAME, "Mover disco ", disco, origen, intermedio, destino);
        } else {           
           
            Hanoi(disco-1, origen, destino, intermedio);
           System.out.println("Mover disco "+disco+ " de Torre("+ origen + ") a Torre(" + destino+")");
           
           createStorePurchase(FILENAME, "Mover disco ", disco, origen, intermedio, destino);
           
           Hanoi(disco-1, intermedio, origen, destino);
         }
    } 
    
    public List<String[]> showHistory() throws IOException{
    
        String cadena;
        FileReader f = new FileReader(FILENAME);
        BufferedReader b = new BufferedReader(f);
        String[] parts = new String[3];
        List<String[]> respuesta = new ArrayList<>();
        
        
        while((cadena = b.readLine())!=null) {
            
            System.out.println(cadena);
            parts = cadena.split(",");
            
            respuesta.add(parts);
        }
        b.close();
        //System.out.println("SIZE: "+respuesta.size());
        
        return respuesta;
        
    }
    
}
