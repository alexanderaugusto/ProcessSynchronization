/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processsynchronization;

import java.util.ArrayList;
import view.Result;

/**
 *
 * @author Alexa
 */
public class Client implements Runnable {

    private String name;
    private ArrayList<Product> products = new ArrayList<Product>();

    private static SupermarketAttendant attendant = new SupermarketAttendant();

    public int attendantType;
    public Result resultScreen;
    
    public Client(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (attendantType == 1) {
            attendant.attendant1(products, resultScreen);
        }else{
            attendant.attendant2(products, resultScreen);
        }
    }
}
