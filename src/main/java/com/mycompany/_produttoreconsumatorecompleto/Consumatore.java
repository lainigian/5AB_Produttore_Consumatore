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
         int nextOut=0;
         while(!Thread.interrupted())
         {
             try 
             {
                  //Opportuno mettere lo sleeep prima di s2.P()
                 //altrimenti la visulizzazione dell'outpt risulta
                 //confusa perchè input e output sulla console si 
                 //sovrappongono
                 Thread.sleep(produciSleepCasuale());
                 s2.P();
                 datoLetto=buffer[nextOut];
                 buffer[nextOut]=0; //pongo a 0 il dato appena letto
                 //System.out.println("Dato letto -> "+buffer[0]);
                 mostraBuffer();
                 nextOut++;
                 nextOut=nextOut%buffer.length;
                 s1.V();          
             } 
             catch (InterruptedException ex) 
             {
                 System.out.println("Produttore interrotto");
             }
         }
     }
     
    private synchronized void mostraBuffer()
     {
         System.out.println("");
         for(int i=0;i<buffer.length;i++)
         {
             System.out.print(buffer[i]+"\t");
         }
         System.out.println("\t --> lettura");
     }
     
     
       /**
      * Produce un numero casuale fra 2000 e 3000
      * usato per rendere il ritardo casule
      * @return
      * @throws InterruptedException 
      */
     private int produciSleepCasuale() 
     {
         Random r=new Random();
        
         return r.nextInt(2000,3000);
     }
}
