/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._produttoreconsumatorecompleto;

/**
 *Rappresenta un semaforo di Dijkstra
 * @author gian
 * 
 */

public class Semaforo 
{
    
    private int valore;
    
    /**
     * 
     * @param valoreIniziale valore iniziale del semaforo
     */
    public Semaforo(int valoreIniziale)
    {
        valore=valoreIniziale;
    }
    
  
    /**
     * E' il metodo wait del semaforo 
     Viene chiamato  P() dalla
        parola olandese proberen (verificare)
     * @throws InterruptedException : viene sollevata se
     * il processo è interrotto durante un wait()
     */
    public synchronized void P() throws InterruptedException
    {
        while(valore==0)
        {
            wait();
        }
        valore--;
    }
     
     /**
     * E' il metodo signal del semaforo 
     *Viene chiamato  V() dalla
     *   parola olandese verhogen (decrementare)
     * @throws InterruptedException : viene sollevata se
     * il processo è interrotto durante un wait()
     */
    public synchronized void V()
    {
        valore++;
        notify();
                
    }
    
}
