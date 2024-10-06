/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._produttoreconsumatorecompleto;

/**
 *
 * @author gian
 * 
 * 
 */
public class App 
{

    public static void main(String[] args) 
    {
        int[] buffer=new int[1];
        Semaforo s1=new Semaforo(1);
        Semaforo s2=new Semaforo(0);
        
        Produttore p=new Produttore(buffer, s1, s2);
        Consumatore c=new Consumatore(buffer, s1, s2);
        
        Thread produttore=new Thread(p);
        Thread consumatore=new Thread(c);
        
        produttore.start();
        consumatore.start();
        
    }
}
