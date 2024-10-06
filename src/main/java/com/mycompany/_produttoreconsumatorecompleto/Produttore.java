/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._produttoreconsumatorecompleto;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gian
 */
public class Produttore implements Runnable
{
    private int[] buffer;
    private Semaforo s1;
    private Semaforo s2;
    
    public Produttore(int[] buffer, Semaforo s1, Semaforo s2)
    {
        this.buffer=buffer;
        this.s1=s1;
        this.s2=s2;
    }
    
    
     public void run()
     {
         int datoProdotto;
         while(!Thread.interrupted())
         {
             try 
             {  
                 s1.P();
                 Thread.sleep(1000);
                 datoProdotto=produciNumeroCasule();
                 buffer[0]=datoProdotto;
                 System.out.println("Dato prodotto -> "+buffer[0]);
                 s2.V();          
             } 
             catch (InterruptedException ex) 
             {
                 System.out.println("Produttore interrotto");
             }
           
             
         }
     }
     
     /**
      * Produce un numero casuale fra 1 e 100
      * @return
      * @throws InterruptedException 
      */
     private int produciNumeroCasule() throws InterruptedException
     {
         Random r=new Random();
        
         return r.nextInt(1,100);
     }
}
