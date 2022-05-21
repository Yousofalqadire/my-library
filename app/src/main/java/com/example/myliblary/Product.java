package com.example.myliblary;

public class Product {
    private int Id;
    private double Price;
    private int Image;
    private String Category;
    private String Brand;

    public Product(int id, double price, int image, String category, String brand) {
        Id = id;
        Price = price;
        Image = image;
        Category = category;
        Brand = brand;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }
}
