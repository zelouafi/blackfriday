package com.indev.blackfriday;

import org.junit.Assert;
import org.junit.Test;

public class BlackFriday {

    /*
        Total assets is the total of money owned by the company
     */
    @Test
    public void oneProductInStock() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        Assert.assertEquals(20, company.totalAssets());
    }

    @Test
    public void twoProductsInStock() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        company.stock(5, "machine", 100);
        Assert.assertEquals(520, company.totalAssets());
    }

    /*
        By default a sale is composed by 5 products, margin of sales is 20%
     */
    @Test
    public void sellsProduct() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        float salePrice = company.sells("capsule");
        Assert.assertEquals(12, salePrice);
        Assert.assertEquals(22, company.totalAssets());
    }

    @Test
    public void sellsProducts() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        float salePrice = company.sells("capsule");
        Assert.assertEquals(12, salePrice);
        salePrice = company.sells("capsule");
        Assert.assertEquals(12, salePrice);
        Assert.assertEquals(24, company.totalAssets());
    }

    @Test
    public void sellsDifferentProducts() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        company.stock(5, "machine", 100);
        float salePrice = company.sells("capsule");
        Assert.assertEquals(12, salePrice);
        salePrice = company.sells("machine");
        Assert.assertEquals(120, salePrice);
        Assert.assertEquals(622, company.totalAssets());
    }

    @Test(expected = RuntimeException.class)
    public void sellsMoreThanStock() {
        Company company = new Company();
        company.stock(5, "capsule", 2);
        company.stock(5, "machine", 100);
        float salePrice = company.sells("capsule");
        Assert.assertEquals(12, salePrice);
        company.sells("capsule");
    }

    /*
    In Black friday the sells are 2 times higher, but margin only 10%
     */
    @Test
    public void blackFridaySellProduct() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        company.stock(5, "machine", 100);
        float salePrice = company.blackFriday().sells("capsule");
        Assert.assertEquals(22, salePrice);
        Assert.assertEquals(522, company.totalAssets());
    }

    @Test
    public void blackFridaySellProducts() {
        Company company = new Company();
        company.stock(10, "capsule", 2);
        company.stock(10, "machine", 100);
        float salePrice = company.blackFriday().sells("capsule");
        Assert.assertEquals(22, salePrice);
        salePrice = company.blackFriday().sells("machine");
        Assert.assertEquals(12, salePrice);
        Assert.assertEquals(1112, company.totalAssets());
    }
}
