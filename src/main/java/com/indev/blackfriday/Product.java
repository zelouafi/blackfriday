package com.indev.blackfriday;

public class Product {


    private float price;
    private String name;
    private int quantite;


    public Product(int quantite, String name, float price) {
        this.price = price;
        this.name = name;
        this.quantite = quantite;
    }

    public float getTotalPrice() {
        return price * quantite;
    }

    public float getPriceOneProduct(){
        return price;
    }

    public String getName(){
        return name;
    }

    public void sellsProducts(int number){
        if (quantite >= number)
            quantite-=number;
        else throw new RuntimeException();
    }
}
