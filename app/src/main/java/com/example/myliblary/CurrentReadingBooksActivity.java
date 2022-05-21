package com.example.myliblary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class CurrentReadingBooksActivity extends AppCompatActivity {
  private RecyclerView currentRecycle;
  private Util util = new Util();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_current_reading_books);
        currentRecycle = (RecyclerView) findViewById(R.id.current_recycleView);
        ArrayList<Book> books = util.getCurrentlyReadingBooks();
        CurrentRecAdapter adapter = new CurrentRecAdapter(this);
        adapter.setBooks(books);
        currentRecycle.setLayoutManager(new LinearLayoutManager(this));
        currentRecycle.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}