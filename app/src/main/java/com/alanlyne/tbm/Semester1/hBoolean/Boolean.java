package com.alanlyne.tbm.Semester1.hBoolean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.hBoolean.booL.booL1;
import com.alanlyne.tbm.Semester1.hBoolean.booL.booL2;
import com.alanlyne.tbm.Semester1.hBoolean.booL.booL3;
import com.alanlyne.tbm.Semester1.hBoolean.booQuiz.booQuiz;
import com.alanlyne.tbm.Semester1.hBoolean.booQuiz.booRev;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Boolean extends AppCompatActivity {
    Button quiz, l1, l2, l3, l4, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolean);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(Boolean.this, Menu.class);
            startActivity(x);
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(v -> {
            Intent quiz= new Intent(Boolean.this, booRev.class);
            startActivity(quiz);
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 71) { l1.setEnabled(false); }
        l1.setOnClickListener(v -> {
            Intent l1 = new Intent(Boolean.this, booL1.class);
            startActivity(l1);
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 72) { l2.setEnabled(false); }
        l2.setOnClickListener(v -> {
            Intent l2 = new Intent(Boolean.this, booL2.class);
            startActivity(l2);
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 73) { l3.setEnabled(false); }
        l3.setOnClickListener(v -> {
            Intent l3 = new Intent(Boolean.this, booL3.class);
            startActivity(l3);
        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 74) { quiz.setEnabled(false); }
        quiz.setOnClickListener(v -> {
            Intent quiz= new Intent(Boolean.this, booQuiz.class);
            startActivity(quiz);
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent end = new Intent(Boolean.this, Menu.class);
        startActivity(end);
    }
}