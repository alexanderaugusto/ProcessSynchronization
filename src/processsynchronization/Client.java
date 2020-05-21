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
public class Client implements Runnable {
    private String name;
    private ArrayList<Product> products = new ArrayList<Product>();
    
    private static SupermarketAttendant attendant = new SupermarketAttendant();
    
    public Client(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addProduct(Product product){
        this.products.add(product);
    }

    @Override
    public void run() {
        attendant.attendant1(products);
    }
}
