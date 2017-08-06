package com.geekbunny.moviequiz;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity2 extends AppCompatActivity {

    Button answer1,answer2,answer3,answer4;
    public Getquestion getquestion;
    public Answers answers;
    private DBHelper mydb ;
    TextView score,question;
    ImageView u1,u2,u3,u4,u5,o1,o2,o3,o4,o5,u,o;
    String mAnswer;
    int mScore=0;
    int i;
    String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);
        //score =(TextView) findViewById(R.id.score);
        question =(TextView) findViewById(R.id.question);

        u1=(ImageView) findViewById(R.id.u1);
        u2=(ImageView) findViewById(R.id.u2);
        u3=(ImageView) findViewById(R.id.u3);
        u4=(ImageView) findViewById(R.id.u4);
        u5=(ImageView) findViewById(R.id.u5);
        o1=(ImageView) findViewById(R.id.o1);
        o2=(ImageView) findViewById(R.id.o2);
        o3=(ImageView) findViewById(R.id.o3);
        o4=(ImageView) findViewById(R.id.o4);
        o5=(ImageView) findViewById(R.id.o5);
        answers=new Answers();
        try {
            getquestion = new Getquestion(this.getApplicationContext());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
       // score.setText("Score : " + mScore);
        if(getquestion.user_place==1)
        user="user1";
        else user="user2";

        try {
            update_question(i++);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Answers().execute(String.valueOf(getquestion.id_room),user+"_answer"+String.valueOf(i),answer1.getText().toString());
                Log.d("COLUMN",user+"_answer"+String.valueOf(i));
                if(i==1){ u=u1;o=o1;}
                if(i==2){ u=u2;o=o2;}
                if(i==3){ u=u3;o=o3;}
                if(i==4){ u=u4;o=o4;}
                if(i==5){ u=u5;o=o5;}
                if(answer1.getText().equals(mAnswer)){
                   // mScore++;
                    u.setImageResource(R.drawable.ok_small);
                   // score.setText("Score : "+ mScore);
                    try {
                        update_question(i++);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    u.setImageResource(R.drawable.fail_small);
                    try {
                        update_question(i++);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Answers().execute(String.valueOf(getquestion.id_room),user+"_answer"+String.valueOf(i),answer2.getText().toString());
                if(i==1){ u=u1;o=o1;}
                if(i==2){ u=u2;o=o2;}
                if(i==3){ u=u3;o=o3;}
                if(i==4){ u=u4;o=o4;}
                if(i==5){ u=u5;o=o5;}
                if(answer2.getText().equals(mAnswer)){
                   // mScore++;
                    u.setImageResource(R.drawable.ok_small);
                   // score.setText("Score : "+ mScore);
                    try {
                        update_question(i++);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    u.setImageResource(R.drawable.fail_small);
                    try {
                        update_question(i++);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Answers().execute(String.valueOf(getquestion.id_room),user+"_answer"+String.valueOf(i),answer3.getText().toString());
                if(i==1){ u=u1;o=o1;}
                if(i==2){ u=u2;o=o2;}
                if(i==3){ u=u3;o=o3;}
                if(i==4){ u=u4;o=o4;}
                if(i==5){ u=u5;o=o5;}
                if(answer3.getText().equals(mAnswer)){
                  //  mScore++;
                    u.setImageResource(R.drawable.ok_small);
                   // score.setText("Score : "+ mScore);
                    try {
                        update_question(i++);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    u.setImageResource(R.drawable.fail_small);
                    try {
                        update_question(i++);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Answers().execute(String.valueOf(getquestion.id_room),user+"_answer"+String.valueOf(i),answer4.getText().toString());
                if(i==1){ u=u1;o=o1;}
                if(i==2){ u=u2;o=o2;}
                if(i==3){ u=u3;o=o3;}
                if(i==4){ u=u4;o=o4;}
                if(i==5){ u=u5;o=o5;}
                if(answer4.getText().equals(mAnswer)){
                   // mScore++;
                    u.setImageResource(R.drawable.ok_small);
                    //score.setText("Score : "+ mScore);
                    try {
                        update_question(i++);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    u.setImageResource(R.drawable.fail_small);
                    try {
                        update_question(i++);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    public void update_question(int a) throws ExecutionException, InterruptedException, JSONException {
        //question.setText(mQuestion.getQuestiononline(a,this.getApplicationContext()));
        question.setText(getquestion.mQuestions[a]);
        answer1.setText(getquestion.mChoices[a][0]);
        answer2.setText(getquestion.mChoices[a][1]);
        answer3.setText(getquestion.mChoices[a][2]);
        answer4.setText(getquestion.mChoices[a][3]);
        mAnswer = getquestion.mCorrect[a];
    }

    public void gameover(){
        AlertDialog.Builder alertbuilder =new AlertDialog.Builder(MainActivity2.this);
        alertbuilder.setMessage("GameOver");
        AlertDialog alert = alertbuilder.create();
        alert.show();
    }
    public String getQuestiononline(int a, Context context) throws ExecutionException, InterruptedException, JSONException {
        //getquestion = new Getquestion(a,context);
        mydb = new DBHelper(context);
        Cursor rs = mydb.getData(a);
        rs.moveToFirst();
        String question = rs.getString(rs.getColumnIndex(DBHelper.QUESTIONS_COLUMN_QUESTION));
        return question;
    }
}
