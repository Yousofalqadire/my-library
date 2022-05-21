package com.example.myliblary;

import java.util.ArrayList;

public class ProductUtil {
    public static ArrayList<Product> products;
    public static ArrayList<Product> shoppingCart;
    private int id;
    public ProductUtil(){
        if(products == null){
            products = new ArrayList<>();
            initProducts();
        }
        if(null == shoppingCart){
            shoppingCart = new ArrayList<>();
        }
        if(null == products){
            products = new ArrayList<>();
        }
    }
    public  static ArrayList<Product> getAllProducts(){
        return products;
    }
    public  static ArrayList<Product> getShoppingCart(){
        return shoppingCart;
    }
    public  static  boolean addToShoppingCart(Product product){
        return shoppingCart.add(product);
    }
    private void initProducts(){
        double price = 0.0;
        String category = "";
        String brand = "";
        int img = 0;
        id++;
        price = 25.00;
        category = "coats";
        img = R.drawable.coat1;
        brand = "contra";
        Product product1 = new Product(id,price,img,category,brand);
        products.add(product1);
        id++;
        price = 25.00;
        category = "coats";
        img = R.drawable.coat2;
        brand = "wolwes";
        Product product2 = new Product(id,price,img,category,brand);
        products.add(product2);
        id++;

        price = 25.00;
        category = "slim fit jeans";
        img = R.drawable.contrahome;
        brand = "tello";
        Product product3 = new Product(id,price,img,category,brand);

        products.add(product3);



    }
}
