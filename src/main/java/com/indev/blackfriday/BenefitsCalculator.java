package com.indev.blackfriday;

public class BenefitsCalculator {

    private final static double benefits = 0.2;
    private final static int sellsQuantite = 5;

    public static float calcul(Product product){
        double price = product.getPriceOneProduct()*sellsQuantite;
        return (float)(price+=price*benefits);
    }
}
