package com.example.applicationtomaintainprogressofhafizstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class SearchStudent extends AppCompatActivity {
    EditText etName;
    List<Student> listofstudents;
    Button btnSearch;

    DbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);



            etName = findViewById(R.id.et_name);


            btnSearch = findViewById(R.id.btn_search);


            db = new DbHelper(this);



            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = etName.getText().toString();
                    listofstudents=db.searchStudent(name);

                }
            });

        }



    }
    