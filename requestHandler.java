package com.example.okhttpclientgetparti;

import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class requestHandler
{
    public String url;

    public OkHttpClient client;

    public requestHandler(String url)
    {
        this.url        = url;
        this.client     = new OkHttpClient();
    }

    public void GET_REQUEST(MainActivity mainActivity)
    {
        Request request     = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                ResponseBody body   = response.body();

                if(!response.isSuccessful())
                {
                    Log.i("OKHTTP: ", "Can not Send your request!");
                }
                else
                {
                    try
                    {
                        JSONObject json     = new JSONObject(body.string());

                        String fname        = json.get("firstname").toString();
                        String lname        = json.get("lastname").toString();

                        mainActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView name   = (TextView) mainActivity.findViewById(R.id.textId);

                                name.setText(fname + " " + lname);
                            }
                        });
                    }
                    catch (JSONException j)
                    {
                        j.printStackTrace();
                    }
                }

            }
        });
    }
}
