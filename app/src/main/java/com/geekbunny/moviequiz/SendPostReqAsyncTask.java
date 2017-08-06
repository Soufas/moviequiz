package com.geekbunny.moviequiz;

import android.os.AsyncTask;
import android.util.Log;

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
 * Created by seif on 16/07/2017.
 */

public class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
    public String question;
    InputStream is;
    @Override
    public String doInBackground(String... params) {
        String paramId = params[0];
        String userID = params[0];


        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("id", paramId));
        nameValuePairs.add(new BasicNameValuePair("userID", userID));

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(
                    "http://bunnyandcat.com/quizaddict_createroom.php");
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();
            is =entity.getContent();
            question = IOUtils.toString(is, StandardCharsets.UTF_8 );


        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }

        return question;

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

    }

}
