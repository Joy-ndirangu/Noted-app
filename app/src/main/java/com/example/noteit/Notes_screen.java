package com.example.noteit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Notes_screen extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    public EditText note_title, note_desc;
    public Button save_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_screen);
        note_title=(EditText) findViewById(R.id.notetitle);
        note_desc=(EditText) findViewById(R.id.description);
        save_btn=(Button) findViewById(R.id.savebtn);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendToDb();
            }
        });

    }
    public  void sendToDb(){
        String title=note_title.getText().toString();
        String description=note_desc.getText().toString();
        myRef.setValue(title);
        myRef.setValue(description);
        Toast.makeText(Notes_screen.this, "Successful Registration!",
                Toast.LENGTH_SHORT).show();
    }
}