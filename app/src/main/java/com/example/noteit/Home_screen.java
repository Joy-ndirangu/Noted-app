package com.example.noteit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class Home_screen extends AppCompatActivity {
    public FloatingActionButton add_btn;
    public Button notebtn;
    BottomNavigationView bottom_nav;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        add_btn=(FloatingActionButton) findViewById(R.id.Addbtn);
        notebtn=(Button) findViewById(R.id.addnotebtn);
        bottom_nav=(BottomNavigationView)findViewById(R.id.navigationview) ;
//Setting the activity to the selected item
        bottom_nav.setSelectedItemId(R.id.home);
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                    return true;

                    case R.id.aboutbtn:
                        startActivity( new Intent(getApplicationContext(),Account.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.settings:
                        startActivity( new Intent(getApplicationContext(), Setting.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { takeToNotes();}
        });
        notebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ takeToNotes();}
        } );
    }
    public void takeToNotes(){
        Intent intent=new Intent(Home_screen.this,Notes_screen.class);
        startActivity(intent);
    }
}