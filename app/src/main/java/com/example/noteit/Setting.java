package com.example.noteit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Setting extends AppCompatActivity {
    Button change_reg_details, more_information, add_account;
    BottomNavigationView bottom_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        change_reg_details = (Button) findViewById(R.id.change_details);
        more_information=(Button)findViewById(R.id.more_info) ;
        add_account = (Button) findViewById(R.id.Add_account);
        change_reg_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeToRegistration();
            }
        });
        more_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeToAccount();
            }
        });

       add_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeToRegistration();
            }
        });

        bottom_nav=(BottomNavigationView)findViewById(R.id.navigationview) ;
//Setting the activity to the selected item
        bottom_nav.setSelectedItemId(R.id.settings);
        bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.settings:
                        return true;

                    case R.id.home:
                        startActivity( new Intent(getApplicationContext(),Home_screen.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.about:
                        startActivity( new Intent(getApplicationContext(), Account.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void takeToRegistration() {
        Intent intent=new Intent(Setting.this,Log_in.class);
        startActivity(intent);
    }
    private void takeToAccount() {
        Intent intent=new Intent(Setting.this,Account.class);
        startActivity(intent);
    }
}

