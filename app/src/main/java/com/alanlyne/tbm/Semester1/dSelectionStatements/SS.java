package com.alanlyne.tbm.Semester1.dSelectionStatements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssL.ssL1;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssL.ssL2;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssL.ssL3;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssL.ssL4;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssL.ssL5;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssL.ssL6;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssL.ssL7;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssL.ssL8;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssQuiz.ssQuiz;
import com.alanlyne.tbm.Semester1.dSelectionStatements.ssQuiz.ssRev;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SS extends AppCompatActivity {
    Button quiz, l1, l2, l3, l4, l5, l6, l7, l8, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss);

        x = findViewById(R.id.x);
        x.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent x = new Intent(SS.this, Menu.class);
                startActivity(x);
            }
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz= new Intent(SS.this, ssRev.class);
                 startActivity(quiz);
            }
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 31) { l1.setEnabled(false); }
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(SS.this, ssL1.class);
                startActivity(l1);
            }
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 32) { l2.setEnabled(false); }
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l2 = new Intent(SS.this, ssL2.class);
                startActivity(l2);
            }
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 33) { l3.setEnabled(false); }
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l3 = new Intent(SS.this, ssL3.class);
                startActivity(l3);
            }
        });

        l4 = findViewById(R.id.l4);
        if(Menu.counter < 34) { l4.setEnabled(false); }
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l4 = new Intent(SS.this, ssL4.class);
                startActivity(l4);
            }
        });
        l5 = findViewById(R.id.l5);
        if(Menu.counter < 35) { l5.setEnabled(false); }
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l5 = new Intent(SS.this, ssL5.class);
                startActivity(l5);
            }
        });
        l6 = findViewById(R.id.l6);
        if(Menu.counter < 36) { l6.setEnabled(false); }
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l6 = new Intent(SS.this, ssL6.class);
                startActivity(l6);
            }
        });
        l7 = findViewById(R.id.l7);
        if(Menu.counter < 37) { l7.setEnabled(false); }
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l7 = new Intent(SS.this, ssL7.class);
                startActivity(l7);
            }
        });
        l8 = findViewById(R.id.l8);
        if(Menu.counter < 38) { l8.setEnabled(false); }
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l8 = new Intent(SS.this, ssL8.class);
                startActivity(l8);
            }
        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 39) { quiz.setEnabled(false); }
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz= new Intent(SS.this, ssQuiz.class);
                startActivity(quiz);
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent end = new Intent(SS.this, Menu.class);
        startActivity(end);
    }
}
