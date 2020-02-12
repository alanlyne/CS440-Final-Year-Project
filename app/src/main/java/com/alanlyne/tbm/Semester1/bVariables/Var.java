package com.alanlyne.tbm.Semester1.bVariables;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.bVariables.varL.varL1;
import com.alanlyne.tbm.Semester1.bVariables.varL.varL2;
import com.alanlyne.tbm.Semester1.bVariables.varL.varL3;
import com.alanlyne.tbm.Semester1.bVariables.varL.varL4;
import com.alanlyne.tbm.Semester1.bVariables.varQuiz.varQuiz;
import com.alanlyne.tbm.Semester1.bVariables.varQuiz.varRev;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Var extends AppCompatActivity {
    Button quiz, l1, l2, l3, l4, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(Var.this, Menu.class);
            startActivity(x);
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(v -> {
            Intent quiz= new Intent(Var.this, varRev.class);
            startActivity(quiz);
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 11) { l1.setEnabled(false); }
        l1.setOnClickListener(v -> {
            Intent l1 = new Intent(Var.this, varL1.class);
            startActivity(l1);
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 12) { l2.setEnabled(false); }
        l2.setOnClickListener(v -> {
            Intent l2 = new Intent(Var.this, varL2.class);
            startActivity(l2);
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 13) { l3.setEnabled(false); }
        l3.setOnClickListener(v -> {
            Intent l3 = new Intent(Var.this, varL3.class);
            startActivity(l3);
        });

        l4 = findViewById(R.id.l4);
        if(Menu.counter < 14) { l4.setEnabled(false); }
        l4.setOnClickListener(v -> {
            Intent l4 = new Intent(Var.this, varL4.class);
            startActivity(l4);
        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 15) { quiz.setEnabled(false); }
        quiz.setOnClickListener(v -> {
            Intent quiz= new Intent(Var.this, varQuiz.class);
            startActivity(quiz);
        });
    }
}
