package com.example.othello;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class Login {
    private FirebaseAuth mAuth;
    private static final String TAG = "Login";
    private int login_ssuccess;
    private MainActivity mainActivity;

    public Login(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        mAuth = FirebaseAuth.getInstance();
        login_ssuccess = -1;
    }

    public int Login_in(String email, String password){
        Log.d(TAG, "Login_in: "+email+password);

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this.mainActivity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                            login_ssuccess = 1;
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            //Toast.makeText(mainActivity, "Authentication failed.",
                              //      Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                            login_ssuccess = 0;
                        }

                        // ...
                    }
                });
        return login_ssuccess;
    }

    public void init(){
        FirebaseAuth.getInstance().signOut();
    }
}
