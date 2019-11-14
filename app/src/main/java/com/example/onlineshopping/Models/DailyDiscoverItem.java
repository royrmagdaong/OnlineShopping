package com.example.onlineshopping.Models;

public class DailyDiscoverItem {
    private String product_name;
    private String product_img;
    private String price;

    public DailyDiscoverItem(String product_name, String product_img, String price) {
        this.product_name = product_name;
        this.product_img = product_img;
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
