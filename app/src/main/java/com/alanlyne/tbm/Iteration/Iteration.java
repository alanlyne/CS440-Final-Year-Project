package com.alanlyne.tbm.Iteration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alanlyne.tbm.Iteration.iterationL.iterationL1;
import com.alanlyne.tbm.Iteration.iterationL.iterationL2;
import com.alanlyne.tbm.Iteration.iterationL.iterationL3;
import com.alanlyne.tbm.Iteration.iterationL.iterationL4;
import com.alanlyne.tbm.Iteration.iterationQuiz.iterationQuiz;
import com.alanlyne.tbm.Iteration.iterationQuiz.iterationRev;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Operators.op;
import com.alanlyne.tbm.Operators.opL.opL1;
import com.alanlyne.tbm.Operators.opL.opL2;
import com.alanlyne.tbm.Operators.opL.opL3;
import com.alanlyne.tbm.Operators.opL.opL4;
import com.alanlyne.tbm.Operators.opL.opL5;
import com.alanlyne.tbm.Operators.opL.opL6;
import com.alanlyne.tbm.Operators.opL.opL7;
import com.alanlyne.tbm.Operators.opQuiz.opQuiz;
import com.alanlyne.tbm.Operators.opQuiz.opRevision;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.SelectionStatements.SS;
import com.alanlyne.tbm.SelectionStatements.ssL.ssL1;
import com.alanlyne.tbm.SelectionStatements.ssL.ssL2;
import com.alanlyne.tbm.SelectionStatements.ssL.ssL3;
import com.alanlyne.tbm.SelectionStatements.ssL.ssL4;
import com.alanlyne.tbm.SelectionStatements.ssQuiz.ssQuiz;
import com.alanlyne.tbm.SelectionStatements.ssQuiz.ssRev;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Iteration extends AppCompatActivity {

    Button quiz, l1, l2, l3, l4, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ss);

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

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 45) { quiz.setEnabled(false); }
        quiz.setOnClickListener(v -> {
            Intent quiz= new Intent(Iteration.this, iterationQuiz.class);
            startActivity(quiz);
        });
    }
}

