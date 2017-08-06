package com.geekbunny.moviequiz;

/**
 * Created by seif on 21/07/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "quizz_db.db";
    public static final String QUESTIONS_TABLE_NAME = "questions";
    public static final String QUESTIONS_COLUMN_ID = "id";
    public static final String QUESTIONS_COLUMN_QUESTION = "question_text";
    public static final String QUESTIONS_COLUMN_CHOICE1 = "choice1";
    public static final String QUESTIONS_COLUMN_CHOICE2 = "choice2";
    public static final String QUESTIONS_COLUMN_CHOICE3 = "choice3";
    public static final String QUESTIONS_COLUMN_CHOICE4 = "choice4";
    public static final String QUESTIONS_COLUMN_CORRECT = "correct";
    public static final String QUESTIONS_COLUMN_ANSWER = "answer";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table questions " +
                        "(id integer primary key, question_text,choice1,choice2,choice3,choice4,correct,answer)"
        );
        db.execSQL(
                "create table room " +
                        "(id integer primary key, user_current ,enemy)"
        );
        db.execSQL(
                "create table user_info " +
                        "(id integer primary key, user_name)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS questions");
        onCreate(db);
    }

    public boolean insertQuestion (String question_text, String choice1, String choice2, String choice3,String choice4,String correct) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("question_text", question_text);
        contentValues.put("choice1", choice1);
        contentValues.put("choice2", choice2);
        contentValues.put("choice3", choice3);
        contentValues.put("choice4", choice4);
        contentValues.put("correct", correct);
        db.insert("questions", null, contentValues);
        db.close();
        return true;
    }


    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from questions where id="+id+"", null );
        db.close();
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, QUESTIONS_TABLE_NAME);
        db.close();
        return numRows;
    }

    public boolean updateQuestion (Integer id,String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("answer", answer);

        db.update("questions", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        db.close();
        return true;
    }

    public Integer deleteQuestion (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("question",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllQuestions() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from questions", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(QUESTIONS_COLUMN_QUESTION)));
            res.moveToNext();
        }
        db.close();
        return array_list;
    }

}
