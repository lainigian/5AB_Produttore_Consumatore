/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._produttoreconsumatorecompleto;

import java.util.Random;

/**
 *
 * @author gian
 */
public class Consumatore implements  Runnable
{
    private int[] buffer;
    private Semaforo s1;
    private Semaforo s2;
    
    public Consumatore(int[] buffer, Semaforo s1, Semaforo s2)
    {
        this.buffer=buffer;
        this.s1=s1;
        this.s2=s2;
    }
    
    
     public void run()
     {
         int datoLetto;
         while(!Thread.interrupted())
         {
             try 
             {
                 
                 s2.P();
                 Thread.sleep(1000);
                 datoLetto=buffer[0];
                 System.out.println("Dato letto -> "+buffer[0]);
                 s1.V();          
             } 
             catch (InterruptedException ex) 
             {
                 System.out.println("Produttore interrotto");
             }
           
             
         }
     }
     
     
}
