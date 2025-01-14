package com.example.assignment4;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class deleteactivity extends AppCompatActivity {

    EditText editId;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteactivity);

        editId = findViewById(R.id.editId);
        dbHelper = new DBHelper(this);

        findViewById(R.id.buttonDelete).setOnClickListener(v -> {
            String idString = editId.getText().toString();

            if (idString.isEmpty()) {
                Toast.makeText(this, "Please enter a valid student ID", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idString);

            if (!dbHelper.checkStudentId(id)) {
                Toast.makeText(this, "Student with this ID does not exist", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHelper.deleteStudent(id);
            Toast.makeText(this, "Student Deleted", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
