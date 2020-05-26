/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processsynchronization;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import view.ResultScreen;

/**
 *
 * @author Alexa
 */
public class Attendant {

    // sem sincronia
    public void attendant1(ArrayList<Product> products, ResultScreen resultScreen) {
        float total = 0;

        for (Product product : products) {
            resultScreen.resultListModel.addElement("Atendendo o cliente " + Thread.currentThread().getName() + ": " + product.getName());

            total = total + product.getPrice();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

        DecimalFormat df2 = new DecimalFormat("#.##");
        df2.setRoundingMode(RoundingMode.DOWN);
        resultScreen.resultListModel.addElement("Total da compra do cliente " + Thread.currentThread().getName() + ": R$ " + df2.format(total));
    }

    // com sincronia
    public synchronized void attendant2(ArrayList<Product> products, ResultScreen resultScreen) {
        float total = 0;

        for (Product product : products) {
            resultScreen.resultListModel.addElement("Atendendo o cliente " + Thread.currentThread().getName() + ": " + product.getName());

            total = total + product.getPrice();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

        DecimalFormat df2 = new DecimalFormat("#.##");
        df2.setRoundingMode(RoundingMode.DOWN);
        resultScreen.resultListModel.addElement("Total da compra do cliente " + Thread.currentThread().getName() + ": R$ " + df2.format(total));
        resultScreen.resultListModel.addElement("****************************************************************");
    }
}
