/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processsynchronization;

import java.util.ArrayList;

/**
 *
 * @author Alexa
 */
public class SupermarketAttendant {

    public void attendant1(ArrayList<Product> products) {
        float total = 0;
        
        for (Product product : products) {
            System.out.print("Atendendo o cliente " + Thread.currentThread().getName() + ": ");
            System.out.println(product.getName());

            total = total + product.getPrice();
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
        System.out.println("Total da compra: " + total);
        System.out.println("");
    }

    public synchronized void attendant2(ArrayList<Product> products) {
        float total = 0;
        
        for (Product product : products) {
            System.out.print("Atendendo o cliente " + Thread.currentThread().getName() + ": ");
            System.out.println(product.getName());

            total = total + product.getPrice();
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
        System.out.println("Total da compra: " + total);
        System.out.println("");
    }
}
