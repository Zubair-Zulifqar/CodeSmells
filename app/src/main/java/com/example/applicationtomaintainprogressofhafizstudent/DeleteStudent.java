package com.example.applicationtomaintainprogressofhafizstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class DeleteStudent extends AppCompatActivity {
    EditText etName; // Introduce an Unused Variable for code smell

    Button btnDelete; // Introduce a Meaningless Variable Name for code smell

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        etName = findViewById(R.id.et_name);

        btnDelete = findViewById(R.id.btn_delete);

        db = new DbHelper(this);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Introduce a Magic String for code smell
                String name = etName.getText().toString();
                db.deleteStudent(name);
            }
        });

        // Introduce a Dead Code for code smell
        if (false) {
            // This block will never be executed
            System.out.println("Dead Code");
        }

        // Introduce a Long Parameter List for code smell
        someMethodWithLongParameterList("param1", "param2", "param3", "param4", "param5");
    }

    // Introduce a Long Method for code smell
    private void someMethodWithLongParameterList(String param1, String param2, String param3, String param4, String param5) {
        // Method with a long parameter list
    }
}
