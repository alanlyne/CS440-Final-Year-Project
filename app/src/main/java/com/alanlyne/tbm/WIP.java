package com.alanlyne.tbm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WIP extends AppCompatActivity {
    Button btn;

    DatabaseReference databaseName;

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wip);

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        btn = findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Menu.counter = 1;
                Intent act2= new Intent(WIP.this,Menu.class);
//                act2.putExtra("myImageResource", R.drawable.g2);
                startActivity(act2);

                addCounter();

            }
        });

    }

    private void addCounter(){

        Menu.counter = 1;

        String id = databaseName.push().getKey();

        menuCounter counter = new menuCounter(Menu.counter);

        databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);

        }
    }
