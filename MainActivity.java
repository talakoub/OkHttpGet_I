package com.example.okhttpclientgetparti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button btn;

    public requestHandler requestHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn     = (Button) findViewById(R.id.btnId);
        requestHandler  =   new requestHandler("http://10.0.2.3");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestHandler.GET_REQUEST(MainActivity.this);
            }
        });
    }
}