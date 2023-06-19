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




    Button btnSave, btnEdit, btnDelete,btnSearch;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSave = findViewById(R.id.btn_save);
        btnEdit = findViewById(R.id.btn_edit);
        btnDelete = findViewById(R.id.btn_delete);
        btnSearch= findViewById(R.id.btn_search);




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


Intent intent=new Intent(MainActivity.this,AddStudent.class);
startActivity(intent);

            }
        });
btnEdit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,EditStudent.class);
        startActivity(intent);
    }
});

btnDelete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,DeleteStudent.class);
        startActivity(intent);
    }
});
btnSearch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,SearchStudent.class);
        startActivity(intent);
    }
});
    }


}