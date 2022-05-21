package com.example.myliblary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsRecAdapter extends RecyclerView.Adapter<ProductsRecAdapter.ViewHolder>{
    private ArrayList<Product> products;
    Context context;
    public ProductsRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item_rec,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.product_brand.setText(products.get(position).getBrand());

       holder.product_price.setText(""+(int) products.get(position).getPrice());
       holder.product_image.setImageResource(products.get(position).getImage());
       holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context,ProductActivity.class);
               intent.putExtra("id",products.get(position).getId());
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
     private TextView product_brand,product_price;
     private ImageView product_image;
     private Button addToCartBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_brand = (TextView) itemView.findViewById(R.id.product_brand);
            product_price = (TextView) itemView.findViewById(R.id.product_price);
            product_image = (ImageView) itemView.findViewById(R.id.product_image);
            addToCartBtn = (Button) itemView.findViewById(R.id.addToCartBtn);

        }
    }
    public void setProducts(ArrayList<Product> _products){
        this.products = _products;
        notifyDataSetChanged();
    }
}
