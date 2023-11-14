package com.example.applicationtomaintainprogressofhafizstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//--
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Introduce a Meaningless Variable Name for code smell
    Button btnSave, btnEdit, btnDelete, btnSearch, btnShowAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Introduce a Magic Number for code smell
        int magicNumber = 42;

        // Introduce a Feature Envy code smell
        handleButtonClicks();

        // Introduce a Long Method for code smell
        performComplexOperation();

        // Introduce a Primitive Obsession code smell
        String studentIdString = "123";
        int studentId = Integer.parseInt(studentIdString);

        // Introduce a Switch Statement code smell
        String operationType = "delete";
        switch (operationType) {
            case "save":
                handleSave();
                break;
            case "edit":
                handleEdit();
                break;
            case "delete":
                handleDelete();
                break;
            default:
                handleDefault();
        }
    }

    private void handleButtonClicks() {
        btnSave = findViewById(R.id.btn_save);
        btnEdit = findViewById(R.id.btn_edit);
        btnDelete = findViewById(R.id.btn_delete);
        btnSearch = findViewById(R.id.btn_search);
        btnShowAll = findViewById(R.id.btn_showall);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Introduce a Shotgun Surgery code smell
                handleButtonSaveClick();
            }
        });

        // Introduce a Comments for code smell
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle edit button click
                Intent intent = new Intent(MainActivity.this, EditStudent.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Introduce a Data Clumps code smell
                String studentName = "John Doe";
                int studentAge = 20;
                deleteStudent(studentName, studentAge);
            }
        });

        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Introduce a Message Chains code smell
                Intent intent = new Intent(MainActivity.this, ShowAll.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Introduce a Duplicated Code code smell
                searchStudent("John Doe");
            }
        });
    }

    private void performComplexOperation() {
        // Complex operation
        // ...
        // Introduce a Temporary Field for code smell
        int temporaryField = 100;
        // ...
        // More complex operation
    }

    private void handleButtonSaveClick() {
        // Handle save button click
        Intent intent = new Intent(MainActivity.this, AddStudent.class);
        startActivity(intent);
    }

    private void handleSave() {
        // Handle save operation
    }

    private void handleEdit() {
        // Handle edit operation
    }

    private void handleDelete() {
        // Handle delete operation
    }

    private void handleDefault() {
        // Handle default operation
    }

    private void deleteStudent(String name, int age) {
        // Delete student operation
    }

    private void searchStudent(String name) {
        // Search student operation
    }
}
