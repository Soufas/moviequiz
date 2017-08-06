package com.geekbunny.moviequiz;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by seif on 16/07/2017.
 */

public class Login {
    public String user_id;
    public InputStream is;
public Login(String name,String add) throws ExecutionException, InterruptedException {
        insertToDatabase(name,add);
    }


    private void insertToDatabase(String username, String password) throws ExecutionException, InterruptedException {
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String paramUsername = params[0];
                String paramAddress = params[1];


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("name", paramUsername));
                nameValuePairs.add(new BasicNameValuePair("address", paramAddress));

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://bunnyandcat.com/quizaddict_login.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();
                    is =entity.getContent();
                    user_id = IOUtils.toString(is, StandardCharsets.UTF_8 );


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return user_id;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        //sendPostReqAsyncTask.execute(username, password);
        Config.USER_ID=sendPostReqAsyncTask.execute(username, password).get();
        Log.d("USER_ID",Config.USER_ID);
    }




}
