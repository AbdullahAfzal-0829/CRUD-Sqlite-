package com.example.assignment4;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class readactivity extends AppCompatActivity {

    TextView textViewStudentList;
    Button buttonLoadStudents;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readactivity);

        textViewStudentList = findViewById(R.id.textViewStudentList);
        buttonLoadStudents = findViewById(R.id.buttonLoadStudents);
        dbHelper = new DBHelper(this);

        buttonLoadStudents.setOnClickListener(v -> {
            Cursor cursor = dbHelper.getAllStudents();
            StringBuilder students = new StringBuilder();
            if (cursor.getCount() == 0) {
                students.append("No students available.");
            } else {
                while (cursor.moveToNext()) {
                    @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID));
                    @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_NAME));
                    @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_AGE));
                    @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_EMAIL));
                    @SuppressLint("Range") String course = cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_COURSE));
                    students.append("ID: ").append(id).append("\n")
                            .append("Name: ").append(name).append("\n")
                            .append("Age: ").append(age).append("\n")
                            .append("Email: ").append(email).append("\n")
                            .append("Course: ").append(course).append("\n\n");
                }
            }
            textViewStudentList.setText(students.toString());
            cursor.close();
        });
    }
}
