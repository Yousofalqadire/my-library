package com.example.myliblary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainProductActivity2 extends AppCompatActivity {
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