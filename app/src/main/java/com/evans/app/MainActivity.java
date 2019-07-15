package com.evans.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.evans.app.adapters.BooksAdapter;
import com.evans.app.models.Books;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ArrayList<Books> mBooks = new ArrayList<>();
    BooksAdapter mAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);

        mBooks.add(new Books("Gotham", "Action", "The dark night return", R.drawable.mariasemples));
        mBooks.add(new Books("Metropolis", "Superhero", "The man of steel", R.drawable.privacy));
        mBooks.add(new Books("Central City", "Sc-fi", "Fastest man alive", R.drawable.thevigitarian));
        mBooks.add(new Books("Star City", "Action", "The girl of tomorrow", R.drawable.thewildrobot));

        mBooks.add(new Books("Endgame", "Action", "Often disappointing", R.drawable.account));
        mBooks.add(new Books("Dark Night", "Superhero", "The man of steel", R.drawable.privacy));
        mBooks.add(new Books("Central City", "Sc-fi", "Fastest man alive", R.drawable.thevigitarian));
        mBooks.add(new Books("Star City", "Action", "The girl of tomorrow", R.drawable.thewildrobot));

        mAdapter = new BooksAdapter(mBooks, this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mAdapter);
    }

}
