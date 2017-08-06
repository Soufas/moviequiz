package com.geekbunny.moviequiz;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by seif on 14/07/2017.
 */

public class questions {
    public Getquestion getquestion;
    private DBHelper mydb ;
    public String mQuestions[] ={
            "What is the real bunny name?",
            "What is the real cat name?",
            "What is the real bunny father name?",
            "What is the real cat father name?"
    };
    public String mAnswers[][] ={
            {"sinda","ilhem","sana","dalel"},
            {"Marwen","Seif","Mongi","Houssem"},
            {"Monji","Jomni","Mongiet","Abdoulellah"},
            {"Mohamed","Abdoulellah","Soufas","Monji"},
    };
    public String mCorrectAnswers[]={"sinda","Seif","Monji","Monji"};

    public String getQuestion(int a){
        String Question = mQuestions[a];
        return Question;
    }
    public String getChoice1(int a){
        String choice = mAnswers[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice= mAnswers[a][1];
        return choice;
    }
    public String getChoice3(int a){
        String choice = mAnswers[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice = mAnswers[a][3];
        return choice;
    }
    public String getCorrect(int a){
        String Correct = mCorrectAnswers[a];
        return Correct;
    }
}
