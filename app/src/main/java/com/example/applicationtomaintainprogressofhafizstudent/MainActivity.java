package com.example.applicationtomaintainprogressofhafizstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText etName, etAge,etClas,etSabaq,etSabqi,etManzil;

    Button btnSave, btnEdit, btnDelete,btnSearch;

    DbHelper db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etAge= findViewById(R.id.et_age);
        etClas= findViewById(R.id.et_clas);
        etSabaq= findViewById(R.id.et_sabaq);
        etSabqi= findViewById(R.id.et_sabqi);
        etManzil= findViewById(R.id.et_manzil);
        btnSave = findViewById(R.id.btn_save);
        btnEdit = findViewById(R.id.btn_edit);
        btnDelete = findViewById(R.id.btn_delete);
        btnSearch= findViewById(R.id.btn_search);

        db = new DbHelper(this);
        listView = findViewById(R.id.list_view);
        RefreshGrid();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String age = etAge.getText().toString();
                String clas = etClas.getText().toString();
                String sabaq = etSabaq.getText().toString();
                String sabqi= etSabqi.getText().toString();
                String manzil= etManzil.getText().toString();


                if (name.isEmpty()) {
                    //Toast.makeText(MainActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    //return;
                }
                Student student = new Student(name,
                        age,
                        clas,
                        sabaq,
                        sabqi,
                        manzil);
                db.insertStudent(student);
                RefreshGrid();
            }
        });
btnEdit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String clas = etClas.getText().toString();
        String sabaq = etSabaq.getText().toString();
        String sabqi= etSabqi.getText().toString();
        String manzil= etManzil.getText().toString();


        if (name.isEmpty()) {
            //Toast.makeText(MainActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
            //return;
        }
        Student student = new Student(name,
                age,
                clas,
                sabaq,
                sabqi,
                manzil);
        db.updateStudent(student);
        RefreshGrid();
    }
});

btnDelete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String name = etName.getText().toString();
        db.deleteStudent(name);
        RefreshGrid();
    }
});

    }

    public void RefreshGrid() {
        List<Student> students = db.selectAllStudents();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1, students);
        listView.setAdapter(arrayAdapter);
    }
}