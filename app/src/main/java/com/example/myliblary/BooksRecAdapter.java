package com.example.myliblary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecAdapter extends RecyclerView.Adapter<BooksRecAdapter.ViewHolder>{
   private ArrayList<Book> books = new ArrayList<>();
   private Context context;

    public BooksRecAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_book_res_view,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.bookName.setText(books.get(position).getName());
        Uri uri = Uri.parse(books.get(position).getImageUrl());
        Glide.with(this.context).asBitmap().
         load(uri)
         .into(holder.bookImage);
        holder.bookImage.setImageURI(uri);
        holder.bookName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,books.get(position).getName(),Toast.LENGTH_LONG).show();
            }
        });
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookActivity.class);
                intent.putExtra("bookId",books.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    private static final String TAG = "BooksRecAdapter";
    public class ViewHolder extends RecyclerView.ViewHolder{
       private ImageView bookImage;
       private TextView bookName;
       private RelativeLayout book;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.book_name);
            bookImage = itemView.findViewById(R.id.book_image);
            book = itemView.findViewById(R.id.book_item);
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }


}
