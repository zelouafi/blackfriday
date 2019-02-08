package com.indev.blackfriday;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<Product> products = new ArrayList<Product>();

    public int pricesProducts(){
        double sum = 0;
        for (Product products:products) {
            sum+= products.getTotalPrice();
        }
        return (int)sum;
    }

    public void addProductToStock(Product product){
        products.add(product);
    }

    public Product getProductByName(String Product){
        for (Product product: products) {
            if (product.getName().equals(product.getName())){
                return product;
            }
        }
        throw new IllegalArgumentException();
    }

}