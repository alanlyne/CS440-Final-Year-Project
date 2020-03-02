package com.alanlyne.tbm.Auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Menu.menuCounter;
import com.alanlyne.tbm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    public EditText emailId, password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference databaseName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.edit_login_email);
        password = findViewById(R.id.edit_login_password);
        btnSignUp= findViewById(R.id.signUp);
        tvSignIn = findViewById(R.id.textView);

        //Sign Up Action
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter email");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Sign Up Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignUpActivity.this, welcome.class));
                                addCounter();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }


            }
        });

        //Move to Sign In
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, loginActivity.class);
                startActivity(i);
            }
        });
    }

    private void addCounter(){
        Menu.counter = 0;
        menuCounter counter = new menuCounter(Menu.counter);
        databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
    }
    @Override
    public void onBackPressed()
    {

    }

}

