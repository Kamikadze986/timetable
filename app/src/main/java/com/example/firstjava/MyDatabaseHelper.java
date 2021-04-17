package com.example.firstjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    Context context;
    static final String DATABASE_NAME = "MyRasp";
    static final int DATABASE_VERSION = 1;

    static final String TABLE_NAME = "main";
    static final String COLUM_ID = "Count";
    static final String COLUM_DAY = "day";
    static final String COLUM_LESSON_NAME = "lesson_name";
    //static final String COLUM_LESSON_ID="lesson_id";
    static final String COLUM_NUMBER_LESSON = "number_lesson";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUM_DAY + " TEXT, " +
                COLUM_LESSON_NAME + " TEXT, " +
                COLUM_NUMBER_LESSON + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    void addLesson(String day, String lesson_name, String number_lesson) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUM_DAY, day);
        cv.put(COLUM_LESSON_NAME, lesson_name);
        cv.put(COLUM_NUMBER_LESSON, number_lesson);
        db.insert(TABLE_NAME, null, cv);
    }

    public ArrayList<ArrayList<DataBD>> getData() {
        ArrayList<DataBD> data_list = new ArrayList<DataBD>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        int dayColIndex = c.getColumnIndex(COLUM_DAY);
        int nameColIndex = c.getColumnIndex(COLUM_LESSON_NAME);
        int numberColIndex = c.getColumnIndex(COLUM_NUMBER_LESSON);
        if (c.moveToFirst()) {
            do {
                DataBD data = new DataBD(c.getString(dayColIndex).toLowerCase(), c.getString(nameColIndex).toLowerCase(), c.getInt(numberColIndex));
                data_list.add(data);
            } while (c.moveToNext());
        }
        Collections.sort(data_list, new Comparator<DataBD>() {
            @Override
            public int compare(DataBD o1, DataBD o2) {
                return o1.number_lesson.compareTo(o2.number_lesson);
            }
        });
        ArrayList<ArrayList<DataBD>> dataOfDay =new ArrayList<>();
        for (int i = 0; i <5 ; i++){
            ArrayList<DataBD> dt=new ArrayList<>();
            dataOfDay.add(dt);
        }
        for (int i = 0; i <data_list.size() ; i++) {
            dataOfDay.get(data_list.get(i).number_day).add(data_list.get(i));
        }
        return dataOfDay;
    }

}
