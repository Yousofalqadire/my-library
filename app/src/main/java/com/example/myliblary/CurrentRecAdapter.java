package com.example.myliblary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
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

public class CurrentRecAdapter extends RecyclerView.Adapter<CurrentRecAdapter.ViewHolder> {

    Context context;
   ArrayList<Book> books = new ArrayList<>();

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public CurrentRecAdapter(Context context) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder,
                                 @SuppressLint("RecyclerView") final int position) {
          holder.bookName.setText(books.get(position).getName());
        Glide.with(context).asBitmap()
                .load(Uri.parse(books.get(position).getImageUrl())).into(holder.bookImage);
          holder.bookName.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(context,books.get(position).getName(),Toast.LENGTH_LONG);
              }
          });
          holder.book.setOnLongClickListener(new View.OnLongClickListener() {
              @Override
              public boolean onLongClick(View v) {
                  AlertDialog.Builder builder = new AlertDialog.Builder(context);
                  builder.setTitle("Delete Form List");
                  builder.setMessage("do you want to delete this book ?");
                  builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {

                      }
                  });
                  Book book = books.get(position);
                  builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                         books.remove(book);
                         notifyDataSetChanged();
                      }
                  });
                  builder.create().show();
                  return true;
              }
          });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
       private TextView bookName;
       private ImageView bookImage;
       private RelativeLayout book;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.book_name);
            bookImage = itemView.findViewById(R.id.book_image);
            book = itemView.findViewById(R.id.book_item);
        }
    }
}
