package com.alanlyne.tbm.Semester1.gInput;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.gInput.inputL.inputL1;
import com.alanlyne.tbm.Semester1.gInput.inputL.inputL2;
import com.alanlyne.tbm.Semester1.gInput.inputL.inputL3;
import com.alanlyne.tbm.Semester1.gInput.inputL.inputL4;
import com.alanlyne.tbm.Semester1.gInput.inputQuiz.inputQuiz;
import com.alanlyne.tbm.Semester1.gInput.inputQuiz.inputRev;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Input extends AppCompatActivity {
    Button quiz, l1, l2, l3, l4, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(Input.this, Menu.class);
            startActivity(x);
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(v -> {
            Intent quiz= new Intent(Input.this, inputRev.class);
            startActivity(quiz);
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 61) { l1.setEnabled(false); }
        l1.setOnClickListener(v -> {
            Intent l1 = new Intent(Input.this, inputL1.class);
            startActivity(l1);
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 62) { l2.setEnabled(false); }
        l2.setOnClickListener(v -> {
            Intent l2 = new Intent(Input.this, inputL2.class);
            startActivity(l2);
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 63) { l3.setEnabled(false); }
        l3.setOnClickListener(v -> {
            Intent l3 = new Intent(Input.this, inputL3.class);
            startActivity(l3);
        });

        l4 = findViewById(R.id.l4);
        if(Menu.counter < 64) { l4.setEnabled(false); }
        l4.setOnClickListener(v -> {
            Intent l4 = new Intent(Input.this, inputL4.class);
            startActivity(l4);
        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 65) { quiz.setEnabled(false); }
        quiz.setOnClickListener(v -> {
            Intent quiz= new Intent(Input.this, inputQuiz.class);
            startActivity(quiz);
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent end = new Intent(Input.this, Menu.class);
        startActivity(end);
    }
}