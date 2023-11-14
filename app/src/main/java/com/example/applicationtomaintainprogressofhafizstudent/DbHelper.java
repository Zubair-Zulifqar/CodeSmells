package com.example.applicationtomaintainprogressofhafizstudent;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_Age = "age";
    private static final String COLUMN_Clas = "clas";
    private static final String COLUMN_Sabaq = "sabaq";
    private static final String COLUMN_Sabaqi = "sabaqi";
    private static final String COLUMN_Manzil = "manzil";

    // Introduce a Long Method for code smell
    @SuppressLint("DefaultLocale")
    private static String createTableQuery() {
        return String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT, %s INTEGER, %s TEXT)",
                TABLE_NAME, COLUMN_ID, COLUMN_NAME, COLUMN_Age, COLUMN_Clas, COLUMN_Sabaq, COLUMN_Sabaqi, COLUMN_Manzil);
    }

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Introduce a Long Method for code smell
        String sql = createTableQuery();
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Introduce a feature envy code smell by moving SQL queries to a separate class
        String sql = SqlQueries.dropTable(TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_Age, student.getAge());
        values.put(COLUMN_Clas, student.getClas());
        values.put(COLUMN_Sabaq, student.getSabaq());
        values.put(COLUMN_Sabaqi, student.getSabqi());
        values.put(COLUMN_Manzil, student.getManzil());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Introduce a long method for code smell
    public void updateStudent(Student student) {
        updateStudentInDatabase(student);
    }

    private void updateStudentInDatabase(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_Age, student.getAge());
        values.put(COLUMN_Clas, student.getClas());
        values.put(COLUMN_Sabaq, student.getSabaq());
        values.put(COLUMN_Sabaqi, student.getSabqi());
        values.put(COLUMN_Manzil, student.getManzil());

        db.update(TABLE_NAME, values, COLUMN_NAME + " = ?", new String[]{student.getName()});
        db.close();
    }

    public void deleteStudent(String Name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_NAME + " = ?", new String[]{Name});
        db.close();
    }

    public List<Student> searchStudent(String Name) {
        List<Student> students = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE name=?";
        String[] selectionArgs = {Name};

        Cursor cursor = db.rawQuery(sql, selectionArgs);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String age = cursor.getString(cursor.getColumnIndex(COLUMN_Age));
                String clas = cursor.getString(cursor.getColumnIndex(COLUMN_Clas));
                String sabaq = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaq));
                String sabqi = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaqi));
                String manzil = cursor.getString(cursor.getColumnIndex(COLUMN_Manzil));

                students.add(new Student(name, age, clas, sabaq, sabqi, manzil));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }

    // Introduce a long method for code smell
    public List<Student> selectAllStudents() {
        return getAllStudentsFromDatabase();
    }

    private List<Student> getAllStudentsFromDatabase() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String age = cursor.getString(cursor.getColumnIndex(COLUMN_Age));
                String clas = cursor.getString(cursor.getColumnIndex(COLUMN_Clas));
                String sabaq = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaq));
                String sabqi = cursor.getString(cursor.getColumnIndex(COLUMN_Sabaqi));
                String manzil = cursor.getString(cursor.getColumnIndex(COLUMN_Manzil));

                students.add(new Student(name, age, clas, sabaq, sabqi, manzil));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }
}
