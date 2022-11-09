package com.example.noteit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public  Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button) findViewById(R.id.getstartednbtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openRegisterUser();}
        });
    }

    public void openRegisterUser(){
        Intent intent=new Intent(MainActivity.this,Register_User.class);
        startActivity(intent);
    }
}