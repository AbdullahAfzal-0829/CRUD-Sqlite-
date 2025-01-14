package com.example.assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonCreate, buttonRead, buttonUpdate, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonRead = findViewById(R.id.buttonRead);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        buttonCreate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, createactivity.class);
            startActivity(intent);
        });

        buttonRead.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, readactivity.class);
            startActivity(intent);
        });

        buttonUpdate.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, updateactivity.class);
            startActivity(intent);
        });

        buttonDelete.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, deleteactivity.class);
            startActivity(intent);
        });
    }
}
