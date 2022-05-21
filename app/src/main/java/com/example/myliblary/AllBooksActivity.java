package com.example.myliblary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private static final String TAG = "AllBooksActivity";
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        Log.d(TAG, "onCreate: started");
        recyclerView = (RecyclerView) findViewById(R.id.books_recycle_view);

        BooksRecAdapter adapter = new BooksRecAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Book> books = new ArrayList<>();
       Util util = new Util();
       books = util.getAllBooks();

        adapter.setBooks(books);
        recyclerView.setAdapter(adapter);



    }
}