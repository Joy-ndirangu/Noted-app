package com.example.noteit;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register_User extends AppCompatActivity {

    private TextView have_account;
    private Button reg_btn;
    private EditText username,reg_email, reg_password, reg_password2;

    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();
        reg_email = (EditText) findViewById(R.id.email);
        reg_password = (EditText) findViewById(R.id.password);
        reg_password2 = (EditText) findViewById(R.id.confirmpassword);
        username = (EditText) findViewById(R.id.username);
        reg_btn= (Button) findViewById(R.id.signupbtn);
        have_account = (TextView) findViewById(R.id.haveaccount);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { takeToSignIn();     }
        });



        if (mAuth.getCurrentUser() !=null)
        {
            Intent intent = new Intent(getApplicationContext(), Home_screen.class);
            startActivity(intent);
            finish();
        }
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String email= reg_email.getText().toString();
                String name= username.getText().toString();
                String password= reg_password.getText().toString();
                String confirm_pass= reg_password2.getText().toString();

              /* HashMap<String, String> userMap=new HashMap<>();
                userMap.put("email","email");
                userMap.put("name","name");
                userMap.put("password","password");
                userMap.put("confirm_pass","confirm_pass");

                myRef.push().setValue(userMap);

*/
                if (TextUtils.isEmpty(email))
                {
                    reg_email.setError("Email required!");
                    return;
                }
                if (TextUtils.isEmpty(name))
                {
                    username.setError("Name required!");
                    return;
                }
                if (TextUtils.isEmpty(password))
                {
                    reg_password.setError("Password required!");
                    return;
                }if (TextUtils.isEmpty(confirm_pass))
            {
                reg_password2.setError("Confirm Password!");
                return;
            }

                if (password.length()<7)
                {
                    reg_password.setError("Password requires at least seven characters");
                    return;
                }
                if (!password.equals(confirm_pass))
                {
                    reg_password.setError("Passwords do not match!");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register_User.this, "Successful Registration!",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(Register_User.this,Log_in.class);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Toast.makeText( Register_User.this, "Registration Failed!",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }


    private void takeToSignIn() {
        Intent intent = new Intent(Register_User.this,Log_in.class);
        startActivity(intent);
    }
}