package com.example.noteit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Account extends AppCompatActivity {
    BottomNavigationView bottom_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    bottom_nav=(BottomNavigationView)findViewById(R.id.navigationview) ;
//Setting the activity to the selected item
        bottom_nav.setSelectedItemId(R.id.aboutbtn);
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.aboutbtn:
                    return true;

                case R.id.home:
                    startActivity( new Intent(getApplicationContext(),Home_screen.class));
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
    }
}