package com.example.applicationtomaintainprogressofhafizstudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class SearchStudent extends AppCompatActivity {
    List<Student> StudentsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
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
                    listofstudents = db.searchStudent(name);
                    recyclerView = findViewById(R.id.recylerViewStudent);


                    recyclerView.setHasFixedSize(true);

                    //LinearLayoutManager GridLayoutManager
                    layoutManager = new LinearLayoutManager(SearchStudent.this);
//        layoutManager = new LinearLayoutManager(MainActivity.this,
//                LinearLayoutManager.HORIZONTAL,
//                false);
                    recyclerView.setLayoutManager(layoutManager);

                    adapter = new myRecyclerViewAdapter(listofstudents);
                    recyclerView.setAdapter(adapter);
                    //adapter.notifyDataSetChanged();


                }
                });
    }
}


