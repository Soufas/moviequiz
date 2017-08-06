package com.geekbunny.moviequiz;

import android.os.AsyncTask;

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

/**
 * Created by seif on 23/07/2017.
 */

public class Answers extends AsyncTask<String, Void, String> {
    public String answers;
    InputStream is;
    @Override
    public String doInBackground(String... params) {
        String paramId = params[0];
        String answer_colmun = params[1];
        String answer = params[2];
        String question_number = params[3];


        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("id", paramId));
        nameValuePairs.add(new BasicNameValuePair("answer_column", answer_colmun));
        nameValuePairs.add(new BasicNameValuePair("answer", answer));
        nameValuePairs.add(new BasicNameValuePair("question_number", question_number));
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(
                    "http://bunnyandcat.com/quizaddict_insertanswer.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();
            is =entity.getContent();
            answers = IOUtils.toString(is, StandardCharsets.UTF_8 );


        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }

        return answers;

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

    }

}

