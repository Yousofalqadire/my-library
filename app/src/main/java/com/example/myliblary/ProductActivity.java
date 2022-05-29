package com.example.myliblary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
 private ImageView image;
 private TextView price,brand;
 private Button btn;
    ArrayList<Product> products ;
    ArrayList<Product> shoppingCart;
    ProductUtil util = new ProductUtil();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_product);
        initWidgets();
        products = util.getAllProducts();
        shoppingCart = util.getShoppingCart();
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        for(Product product:products){
            if(product.getId() == id){
                image.setImageResource(product.getImage());
                price.setText(""+product.getPrice());
                brand.setText(product.getBrand());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      util.addToShoppingCart(product);
                        Toast.makeText(ProductActivity.this,"done...",Toast.LENGTH_LONG).show();
                    }
                });
            }
        }


    }
    private void initWidgets(){
        image =  findViewById(R.id.individual_product_image);
        price =  findViewById(R.id.individual_product_price);
        brand =  findViewById(R.id.individual_product_brand);
        btn =  findViewById(R.id.individual_product_btn);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class MainProductActivity2 extends AppCompatActivity {
      private Button allProductsBtn,shoppingCartBtn;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_product2);
            initWidgets();
            setOnClick();
        }
        private void initWidgets(){
            allProductsBtn = (Button) findViewById(R.id.all_products_btn);
            shoppingCartBtn = (Button) findViewById(R.id.shop_cart_btn);
        }
        private void setOnClick(){
            allProductsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainProductActivity2.this,AllProductsActivity.class);
                    startActivity(intent);
                }
            });
            shoppingCartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainProductActivity2.this,"shopping cart pressed",Toast.LENGTH_LONG)
                            .show();
                }
            });
        }
    }
}