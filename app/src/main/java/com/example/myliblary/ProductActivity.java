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
        image = (ImageView) findViewById(R.id.individual_product_image);
        price = (TextView) findViewById(R.id.individual_product_price);
        brand = (TextView) findViewById(R.id.individual_product_brand);
        btn = (Button) findViewById(R.id.individual_product_btn);
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
}