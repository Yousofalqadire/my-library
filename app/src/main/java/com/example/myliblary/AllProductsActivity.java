package com.example.myliblary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllProductsActivity extends AppCompatActivity {
  private RecyclerView product_recycle_res;
  private  ProductUtil util = new ProductUtil();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);
        product_recycle_res = (RecyclerView) findViewById(R.id.product_recycle_res);
        ProductsRecAdapter adapter = new ProductsRecAdapter(this);
        product_recycle_res.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Product> products = util.getAllProducts();
        adapter.setProducts(products);
        product_recycle_res.setAdapter(adapter);
    }
}