package com.indev.blackfriday;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private float sellPrice = 0;
    private Stock stock = new Stock();


    public float sells(String name) {
        Product product = stock.getProductByName(name);
        product.sellsProducts(5);
        float benefits = BenefitsCalculator.calcul(product);
        sellPrice += benefits;
        return benefits;
    }

    public void stock(int quantite, String capsule, int price) {
        Product product = new Product(quantite, capsule, price);
        stock.addProductToStock(product);
    }

    public Company to(int i) {
        return this;
    }

    public float computeBenefit() {
        return 0;
    }

    public int totalAssets() {
        return (int) (stock.pricesProducts() + sellPrice);
    }


    public Company blackFriday() {
        return this;
    }
}
