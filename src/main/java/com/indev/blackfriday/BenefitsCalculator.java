package com.indev.blackfriday;

public class BenefitsCalculator {


    public static float calcul(Product product, int sellsQuantite , double benefits){
        double price = product.getPriceOneProduct()*sellsQuantite;
        return (float)(price+=(price*benefits));
    }
}
