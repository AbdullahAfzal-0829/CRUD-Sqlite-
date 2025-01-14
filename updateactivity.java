package com.example.assignment4;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class updateactivity extends AppCompatActivity {

    EditText editId, editName, editAge, editEmail, editCourse;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateactivity);

        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editEmail = findViewById(R.id.editEmail);
        editCourse = findViewById(R.id.editCourse);
        dbHelper = new DBHelper(this);

        findViewById(R.id.buttonUpdate).setOnClickListener(v -> {
            String idString = editId.getText().toString();
            String name = editName.getText().toString();
            String ageString = editAge.getText().toString();
            String email = editEmail.getText().toString();
            String course = editCourse.getText().toString();

            if (idString.isEmpty() || name.isEmpty() || ageString.isEmpty() || email.isEmpty() || course.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isValidEmail(email)) {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                return;
            }

            int id = Integer.parseInt(idString);
            int age = Integer.parseInt(ageString);

            if (!dbHelper.checkStudentId(id)) {
                Toast.makeText(this, "Student with this ID does not exist", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHelper.updateStudent(id, name, age, email, course);
            Toast.makeText(this, "Student Updated", Toast.LENGTH_SHORT).show();
            finish();
        });
    }

    private boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
