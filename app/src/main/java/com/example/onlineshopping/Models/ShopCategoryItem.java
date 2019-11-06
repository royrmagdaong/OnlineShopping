package com.example.onlineshopping.Models;

public class ShopCategoryItem {
    private String categoryName;

    public ShopCategoryItem(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
