package com.geekbunny.moviequiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;


public class MainActivity extends ActionBarActivity {

    private EditText editTextName;
    private EditText editTextAdd;
    public Login login ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAdd = (EditText) findViewById(R.id.editTextAddress);


    }

    public void insert(View view) throws ExecutionException, InterruptedException {
        String name = editTextName.getText().toString();
        String add = editTextAdd.getText().toString();

        login =new Login(name,add);
        Intent quiz=new Intent(this,MainActivity2.class);
        startActivity(quiz);
    }

}