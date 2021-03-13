package com.example.othello;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    EditText username;
    EditText password;
    Button signin;
    Login login;
    MainActivity mainActivity;
    int pre_login = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);

        login = new Login(mainActivity);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = username.getText().toString();
                String userPassword = password.getText().toString();

                if(userEmail.isEmpty())
                    return;
                else if (userPassword.isEmpty())
                    return;

                Log.d("login",userEmail + userPassword);


                if(login.Login_in(userEmail, userPassword) == 1){
                    pre_login = 1;
                    Intent intent = new Intent(getApplicationContext(), lobi.class);
                    intent.putExtra("email", userEmail);
                    startActivityForResult(intent, 101);
                }

            }
        });
    }
}