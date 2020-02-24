package com.alanlyne.tbm.Semester1.cOperators;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Semester1.cOperators.opL.opL1;
import com.alanlyne.tbm.Semester1.cOperators.opL.opL2;
import com.alanlyne.tbm.Semester1.cOperators.opL.opL3;
import com.alanlyne.tbm.Semester1.cOperators.opL.opL4;
import com.alanlyne.tbm.Semester1.cOperators.opL.opL5;
import com.alanlyne.tbm.Semester1.cOperators.opL.opL6;
import com.alanlyne.tbm.Semester1.cOperators.opL.opL7;
import com.alanlyne.tbm.Semester1.cOperators.opQuiz.opQuiz;
import com.alanlyne.tbm.Semester1.cOperators.opQuiz.opRevision;
import com.alanlyne.tbm.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class op extends AppCompatActivity {

    Button quiz, l1, l2, l3, l4, l5, l6, l7, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);

        x = findViewById(R.id.x);
        x.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent x = new Intent(op.this, Menu.class);
                startActivity(x);
            }
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz= new Intent(op.this, opRevision.class);
                startActivity(quiz);
            }
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 21) { l1.setEnabled(false); }
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(op.this, opL1.class);
                startActivity(l1);
            }
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 22) { l2.setEnabled(false); }
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l2 = new Intent(op.this, opL2.class);
                startActivity(l2);
            }
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 23) { l3.setEnabled(false); }
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l3 = new Intent(op.this, opL3.class);
                startActivity(l3);
            }
        });

        l4 = findViewById(R.id.l4);
        if(Menu.counter < 24) { l4.setEnabled(false); }
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l4 = new Intent(op.this, opL4.class);
                startActivity(l4);
            }
        });

        l5 = findViewById(R.id.l5);
        if(Menu.counter < 25) { l5.setEnabled(false); }
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l5 = new Intent(op.this, opL5.class);
                startActivity(l5);
            }
        });

        l6 = findViewById(R.id.l6);
        if(Menu.counter < 26) { l6.setEnabled(false); }
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l6 = new Intent(op.this, opL6.class);
                startActivity(l6);
            }
        });

        l7 = findViewById(R.id.l7);
        if(Menu.counter < 27) { l7.setEnabled(false); }
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l7 = new Intent(op.this, opL7.class);
                startActivity(l7);
            }
        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 28) { quiz.setEnabled(false); }
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz= new Intent(op.this, opQuiz.class);
                startActivity(quiz);
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent end = new Intent(op.this, Menu.class);
        startActivity(end);
    }
}