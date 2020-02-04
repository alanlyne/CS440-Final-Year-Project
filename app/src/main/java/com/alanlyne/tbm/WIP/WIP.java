package com.alanlyne.tbm.WIP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Menu.menuCounter;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.WIP.wipL.wipL1;
import com.alanlyne.tbm.WIP.wipL.wipL2;
import com.alanlyne.tbm.WIP.wipL.wipL3;
import com.alanlyne.tbm.WIP.wipQuiz.wipQuiz;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WIP extends AppCompatActivity {
    Button reset, quiz, l1, l2, l3;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wip);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(WIP.this, Menu.class);
            startActivity(x);
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        l1 = findViewById(R.id.l1);
        l1.setOnClickListener(v -> {
            Intent l1 = new Intent(WIP.this, wipL1.class);
            startActivity(l1);
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 1) { l2.setEnabled(false); }
        l2.setOnClickListener(v -> {
            Intent l2 = new Intent(WIP.this, wipL2.class);
            startActivity(l2);
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 2) { l3.setEnabled(false); }
        l3.setOnClickListener(v -> {
            Intent l3 = new Intent(WIP.this, wipL3.class);
            startActivity(l3);
        });

        quiz = findViewById(R.id.wipQuiz);
        if(Menu.counter < 3) { quiz.setEnabled(false); }
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz= new Intent(WIP.this, wipQuiz.class);
                startActivity(quiz);
            }
        });



        reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menu.counter = 1;
                Intent menu = new Intent(WIP.this,Menu.class);
                startActivity(menu);

                resetCounter();
            }
        });
    }

    private void resetCounter(){
        Menu.counter = 0;
        menuCounter counter = new menuCounter(Menu.counter);
        databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
        }
    }
