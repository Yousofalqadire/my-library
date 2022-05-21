package com.example.myliblary;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class WantToReadAdapter extends RecyclerView.Adapter<WantToReadAdapter.ViewHolder>{

    private ArrayList<Book> books = new ArrayList<>();
    Context context;

    public WantToReadAdapter(Context context) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bookName.setText(books.get(position).getName());
        Glide.with(this.context)
                .asBitmap()
                .load(Uri.parse(books.get(position).getImageUrl()))
                .into(holder.bookImage);
        holder.book.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Book book = books.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("delete from books");
                builder.setMessage("are you shore you want to delete this book");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
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

    public  class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bookName;
        private ImageView bookImage;
        private RelativeLayout book;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = (TextView) itemView.findViewById(R.id.book_name);
            bookImage = (ImageView) itemView.findViewById(R.id.book_image);
            book = (RelativeLayout) itemView.findViewById(R.id.book_item);
        }
    }
    public void setBooks(ArrayList<Book> books){
       this.books = books;
       notifyDataSetChanged();
    }
}
