package com.example.myliblary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private static final String TAG = "BookActivity";
   private TextView name,author,description;
   private ImageView image;
   private  Book book;
   private Button currentBtn,wantBtn;
   private Util util = new Util();
   private  Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        animation = AnimationUtils.loadAnimation(this,R.anim.sample_animation);
        initWidgets();
         util = new Util();
        Toast toast = new Toast(BookActivity.this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId",0);
        ArrayList<Book> books = util.getAllBooks();

        for(Book b:books){
            if(b.getId() == id){
                book = b;
                name.setText(b.getName());
                name.startAnimation(animation);
                author.setText(b.getAuthor());
                author.startAnimation(animation);
                Glide.with(this).asBitmap()
                        .load(Uri.parse(b.getImageUrl()))
                        .into(image);
                description.setText(b.getDescription());
                description.startAnimation(animation);

            }
        }
      wantBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              AddToWantToReadBooks();
          }
      });
        currentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCurrentlyBooks();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private void initWidgets(){
     name =  findViewById(R.id.name);
     author = findViewById(R.id.author);
     image =  findViewById(R.id.img);
     description =  findViewById(R.id.description);
     currentBtn =  findViewById(R.id.addToCurrents);
     wantBtn =  findViewById(R.id.addToWanted);
    }
    private  void addToCurrentlyBooks(){
        boolean exist = false;
        ArrayList<Book> currentlyBooks = util.getCurrentlyReadingBooks();
        for(Book b : currentlyBooks){
            if(b.getId() == book.getId()){
                exist = true;

            }

        }
        if(exist){
            AlertDialog.Builder builder = new AlertDialog.Builder(BookActivity.this);
            builder.setMessage(book.getName() + " has been added to currently books");
            builder.create().show();
        }else{
            util.addToCurrentsBooks(book);
            Toast.makeText(this, "done",Toast.LENGTH_LONG).show();
        }
    }
    private void AddToWantToReadBooks(){
        boolean isInCurrent = false;
        boolean isInWant = false;
        ArrayList<Book> books = util.getCurrentlyReadingBooks();
         if(books.contains(book)){
             isInCurrent = true;
         }
        if(isInCurrent){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                    .setMessage("this book is in currents books");
            dialog.create().show();

        }else{
            ArrayList<Book> wantList = util.getWantToReadBooks();
            for(Book book : wantList){
                if(book.getId() == book.getId()){
                    isInWant = true;
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("this books already added to wanted list");
                    builder.create().show();
                }
            }
            util.addToWantedBooks(book);
            Toast.makeText(BookActivity.this,"done...",Toast.LENGTH_LONG).show();

        }

    }
}