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
    EditText etName;

    Button  btnDelete;

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
                        String name = etName.getText().toString();
                        db.deleteStudent(name);

                    }
                });

            }



        }
