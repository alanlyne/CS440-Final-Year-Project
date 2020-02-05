package com.alanlyne.tbm.Semester1.fStrings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.fStrings.stringsL.stringsL1;
import com.alanlyne.tbm.Semester1.fStrings.stringsL.stringsL2;
import com.alanlyne.tbm.Semester1.fStrings.stringsL.stringsL3;
import com.alanlyne.tbm.Semester1.fStrings.stringsL.stringsL4;
import com.alanlyne.tbm.Semester1.fStrings.stringsQuiz.stringsQuiz;
import com.alanlyne.tbm.Semester1.fStrings.stringsQuiz.stringsRev;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Strings extends AppCompatActivity {
    Button quiz, l1, l2, l3, l4, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strings);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(Strings.this, Menu.class);
            startActivity(x);
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(v -> {
            Intent quiz= new Intent(Strings.this, stringsRev.class);
            startActivity(quiz);
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 51) { l1.setEnabled(false); }
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(Strings.this, stringsL1.class);
                startActivity(l1);
            }
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 52) { l2.setEnabled(false); }
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l2 = new Intent(Strings.this, stringsL2.class);
                startActivity(l2);
            }
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 53) { l3.setEnabled(false); }
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l3 = new Intent(Strings.this, stringsL3.class);
                startActivity(l3);
            }
        });

        l4 = findViewById(R.id.l4);
        if(Menu.counter < 54) { l4.setEnabled(false); }
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l4 = new Intent(Strings.this, stringsL4.class);
                startActivity(l4);
            }
        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 55) { quiz.setEnabled(false); }
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz= new Intent(Strings.this, stringsQuiz.class);
                startActivity(quiz);
            }
        });
    }
}
