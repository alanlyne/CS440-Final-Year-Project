package com.alanlyne.tbm.Semester1.eIteration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.alanlyne.tbm.Semester1.eIteration.iterationL.iterationL1;
import com.alanlyne.tbm.Semester1.eIteration.iterationL.iterationL2;
import com.alanlyne.tbm.Semester1.eIteration.iterationL.iterationL3;
import com.alanlyne.tbm.Semester1.eIteration.iterationL.iterationL4;
import com.alanlyne.tbm.Semester1.eIteration.iterationQuiz.iterationQuiz;
import com.alanlyne.tbm.Semester1.eIteration.iterationQuiz.iterationRev;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Iteration extends AppCompatActivity {

    Button quiz, l1, l2, l3, l4, l5, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteration);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(Iteration.this, Menu.class);
            startActivity(x);
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(v -> {
            Intent quiz= new Intent(Iteration.this, iterationRev.class);
            startActivity(quiz);
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 41) { l1.setEnabled(false); }
        l1.setOnClickListener(v -> {
            Intent l1 = new Intent(Iteration.this, iterationL1.class);
            startActivity(l1);
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 42) { l2.setEnabled(false); }
        l2.setOnClickListener(v -> {
            Intent l2 = new Intent(Iteration.this, iterationL2.class);
            startActivity(l2);
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 43) { l3.setEnabled(false); }
        l3.setOnClickListener(v -> {
            Intent l3 = new Intent(Iteration.this, iterationL3.class);
            startActivity(l3);
        });

        l4 = findViewById(R.id.l4);
        if(Menu.counter < 44) { l4.setEnabled(false); }
        l4.setOnClickListener(v -> {
            Intent l4 = new Intent(Iteration.this, iterationL4.class);
            startActivity(l4);
        });

        l5 = findViewById(R.id.l5);
        if(Menu.counter < 45) { l5.setEnabled(false); }
        l5.setOnClickListener(v -> {
            Intent l5 = new Intent(Iteration.this, iterationL4.class);
            startActivity(l5);
        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 46) { quiz.setEnabled(false); }
        quiz.setOnClickListener(v -> {
            Intent quiz= new Intent(Iteration.this, iterationQuiz.class);
            startActivity(quiz);
        });
    }
}

