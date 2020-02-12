package com.alanlyne.tbm.Semester1.jNestedLoops;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.jNestedLoops.nloopL.nloopL1;
import com.alanlyne.tbm.Semester1.jNestedLoops.nloopL.nloopL2;
import com.alanlyne.tbm.Semester1.jNestedLoops.nloopL.nloopL3;
import com.alanlyne.tbm.Semester1.jNestedLoops.nloopQuiz.nloopQuiz;
import com.alanlyne.tbm.Semester1.jNestedLoops.nloopQuiz.nloopRev;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class nloop extends AppCompatActivity {

    Button quiz, l1, l2, l3, l4, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nloop);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(nloop.this, Menu.class);
            startActivity(x);
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(v -> {
            Intent quiz= new Intent(nloop.this, nloopRev.class);
            startActivity(quiz);
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 91) { l1.setEnabled(false); }
        l1.setOnClickListener(v -> {
            Intent l1 = new Intent(nloop.this, nloopL1.class);
            startActivity(l1);
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 92) { l2.setEnabled(false); }
        l2.setOnClickListener(v -> {
            Intent l2 = new Intent(nloop.this, nloopL2.class);
            startActivity(l2);
        });

//        l3 = findViewById(R.id.l3);
//        if(Menu.counter < 93) { l3.setEnabled(false); }
//        l3.setOnClickListener(v -> {
//            Intent l3 = new Intent(nloop.this, nloopL3.class);
//            startActivity(l3);
//        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 94) { quiz.setEnabled(false); }
        quiz.setOnClickListener(v -> {
            Intent quiz= new Intent(nloop.this, nloopQuiz.class);
            startActivity(quiz);
        });
    }
}