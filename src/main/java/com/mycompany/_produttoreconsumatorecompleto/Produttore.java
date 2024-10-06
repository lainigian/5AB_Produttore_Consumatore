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
         int nextIn=0;
         while(!Thread.interrupted())
         {
             try 
             {  
                 //Opportuno mettere lo sleeep prima di s1.P()
                 //altrimenti la visulizzazione dell'outpt risulta
                 //confusa perchè input e output sulla console si 
                 //sovrappongono
                 Thread.sleep(produciSleepCasuale());
                 datoProdotto=produciNumeroCasule();
                 s1.P();
                 buffer[nextIn]=datoProdotto;
                 //System.out.println("Dato prodotto -> "+buffer[0]);
                 mostraBuffer();
                 nextIn++;
                 nextIn=nextIn%buffer.length;
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
     private int produciNumeroCasule() 
     {
         Random r=new Random();
        
         return r.nextInt(1,100);
     }
     
        /**
      * Produce un numero casuale fra 1000 e 2000
      * usato per rendere il ritardo casule
      * @return
      * @throws InterruptedException 
      */
     private int produciSleepCasuale() 
     {
         Random r=new Random();
        
         return r.nextInt(1000,2000);
     }
     
     private synchronized void mostraBuffer()
     {
         System.out.println("");
         for(int i=0;i<buffer.length;i++)
         {
             System.out.print(buffer[i]+"\t");
         }
         System.out.println("\t --> scrittura");
     }
}
