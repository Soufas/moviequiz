package com.geekbunny.moviequiz;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.concurrent.ExecutionException;

/**
 * Created by seif on 15/07/2017.
 */

public class GetQuestionsAnswers{
    public String theString;
    public int id_room;
    public String mChoice1[]=new String[5];
    public String mChoice2[]=new String[5];

    public GetQuestionsAnswers(String results) throws ExecutionException, InterruptedException, JSONException {
        Log.d("conf_question1",Config.mQuestions[0]);
        Log.d("conf_question2",Config.mQuestions[1]);
        Log.d("conf_question3",Config.mQuestions[2]);
        Log.d("conf_question4",Config.mQuestions[3]);
        Log.d("conf_question4",Config.mQuestions[4]);
        parsequestions(results);
    }




    public void parsequestions(String questions_json) throws JSONException {
        JSONObject questionsObject = new JSONObject(questions_json);
        id_room = questionsObject.getInt("id_room");
        Log.d("id_room", String.valueOf(id_room));
        JSONArray questionsArray = questionsObject.getJSONArray("question_answer");
        for (int i = 0; i < questionsArray.length(); i++) {
            JSONObject c = questionsArray.getJSONObject(i);
            String id = c.getString("id");
            Log.d("id_question", id);

            String user1_answer1 = c.getString("user1_answer1");
            mChoice1[0]=user1_answer1;

            String user1_answer2 = c.getString("user1_answer2");
            mChoice1[1]=user1_answer2;

            String user1_answer3 = c.getString("user1_answer3");
            mChoice1[2]=user1_answer3;

            String user1_answer4 = c.getString("user1_answer4");
            mChoice1[3]=user1_answer4;

            String user1_answer5 = c.getString("user1_answer5");
            mChoice1[4]=user1_answer5;

            String user2_answer1 = c.getString("user2_answer1");
            mChoice2[0]=user2_answer1;

            String user2_answer2 = c.getString("user2_answer2");
            mChoice2[1]=user2_answer2;

            String user2_answer3 = c.getString("user2_answer3");
            mChoice2[2]=user2_answer3;

            String user2_answer4 = c.getString("user2_answer4");
            mChoice2[3]=user2_answer4;

            String user2_answer5 = c.getString("user2_answer5");
            mChoice2[4]=user2_answer5;


        }
    }


}