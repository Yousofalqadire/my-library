package com.example.myliblary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class WantToReadActivity2 extends AppCompatActivity {
  private RecyclerView wantToReadRec;
  private Util util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_read2);
        wantToReadRec = findViewById(R.id.want_to_read_rec);
        WantToReadAdapter adapter = new WantToReadAdapter(this);
        wantToReadRec.setLayoutManager(new LinearLayoutManager(this));
        util = new Util();
        ArrayList<Book> books = util.getWantToReadBooks();
        adapter.setBooks(books);
        wantToReadRec.setAdapter(adapter);

    }
}