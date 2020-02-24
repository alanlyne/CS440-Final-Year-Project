package com.alanlyne.tbm.Semester1.k2dArray;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.iArrays.Arrays;
import com.alanlyne.tbm.Semester1.k2dArray.arrayL.array2DL1;
import com.alanlyne.tbm.Semester1.k2dArray.arrayL.array2DL2;
import com.alanlyne.tbm.Semester1.k2dArray.arrayL.array2DL3;
import com.alanlyne.tbm.Semester1.k2dArray.arrayL.array2DL4;
import com.alanlyne.tbm.Semester1.k2dArray.arrayQuiz.array2DQuiz;
import com.alanlyne.tbm.Semester1.k2dArray.arrayQuiz.array2DRev;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Array2D extends AppCompatActivity {
    Button quiz, l1, l2, l3, l4, revision;
    TextView x;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array2_d);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(Array2D.this, Menu.class);
            startActivity(x);
        });

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        revision = findViewById(R.id.revision);
        revision.setOnClickListener(v -> {
            Intent quiz= new Intent(Array2D.this, array2DRev.class);
            startActivity(quiz);
        });

        l1 = findViewById(R.id.l1);
        if(Menu.counter < 101) { l1.setEnabled(false); }
        l1.setOnClickListener(v -> {
            Intent l1 = new Intent(Array2D.this, array2DL1.class);
            startActivity(l1);
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 102) { l2.setEnabled(false); }
        l2.setOnClickListener(v -> {
            Intent l2 = new Intent(Array2D.this, array2DL2.class);
            startActivity(l2);
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 103) { l3.setEnabled(false); }
        l3.setOnClickListener(v -> {
            Intent l3 = new Intent(Array2D.this, array2DL3.class);
            startActivity(l3);
        });

        l4 = findViewById(R.id.l4);
        if(Menu.counter < 104) { l4.setEnabled(false); }
        l4.setOnClickListener(v -> {
            Intent l4 = new Intent(Array2D.this, array2DL4.class);
            startActivity(l4);
        });

        quiz = findViewById(R.id.quiz);
        if(Menu.counter < 105) { quiz.setEnabled(false); }
        quiz.setOnClickListener(v -> {
            Intent quiz= new Intent(Array2D.this, array2DQuiz.class);
            startActivity(quiz);
        });
    }
    @Override
    public void onBackPressed()
    {
        Intent end = new Intent(Array2D.this, Menu.class);
        startActivity(end);
    }
}