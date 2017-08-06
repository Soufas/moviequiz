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

public class Getquestion{
    JSONParser jParser;
    public String theString;
    private DBHelper mydb ;
    public int id_room;
    public int user_place;
    public String mQuestions[] = new String[5];
    public String mChoices[][]=new String[5][4];
    public String mCorrect[]=new String[5];

    public Getquestion(Context context) throws ExecutionException, InterruptedException, JSONException {
        mydb = new DBHelper(context);
        getquestionstring();
    }


    public void getquestionstring() throws ExecutionException, InterruptedException, JSONException {

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        theString=sendPostReqAsyncTask.execute(Config.USER_ID).get();
        parsequestions(theString);
        int count= mydb.numberOfRows();
        Log.d("COUNT", String.valueOf(count));

    }

    public void parsequestions(String questions_json) throws JSONException {
        JSONObject questionsObject = new JSONObject(questions_json);
        id_room = questionsObject.getInt("id_room");
        Log.d("id_room", String.valueOf(id_room));
        user_place = questionsObject.getInt("user_place");
        Log.d("user_place", String.valueOf(user_place));
        JSONArray questionsArray = questionsObject.getJSONArray("question");
        for (int i = 0; i < questionsArray.length(); i++) {
            JSONObject c = questionsArray.getJSONObject(i);
            String id = c.getString("id");
            Log.d("id_question", id);
            String question = c.getString("question");
            mQuestions[i]=question;
            Log.d("question", mQuestions[i]);
            String choice1 = c.getString("choice1");
            mChoices[i][0]=choice1;
            Log.d("choice1", mChoices[i][0]);
            String choice2 = c.getString("choice2");
            mChoices[i][1]=choice2;
            Log.d("choice2", mChoices[i][1]);
            String choice3 = c.getString("choice3");
            mChoices[i][2]=choice3;
            Log.d("choice3", mChoices[i][2]);
            String choice4 = c.getString("choice4");
            mChoices[i][3]=choice4;
            Log.d("choice4", mChoices[i][3]);
            String correct = c.getString("correct");
            mCorrect[i]=correct;
            Log.d("correct", mCorrect[i]);
            mydb.insertQuestion(question,choice1,choice2,choice3,choice4,correct);
        }
    }


}
