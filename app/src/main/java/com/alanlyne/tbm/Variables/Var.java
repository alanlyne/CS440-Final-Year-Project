package com.alanlyne.tbm.Variables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Menu.menuCounter;
import com.alanlyne.tbm.R;

import com.alanlyne.tbm.Variables.varL.varL1;
import com.alanlyne.tbm.Variables.varL.varL2;
import com.alanlyne.tbm.Variables.varL.varL3;
import com.alanlyne.tbm.Variables.varL.varL4;
import com.alanlyne.tbm.Variables.varQuiz.varQuiz;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Var extends AppCompatActivity {
    Button reset, quiz, l1, l2, l3, l4;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var);

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        l1 = findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l1 = new Intent(Var.this, varL1.class);
                startActivity(l1);
            }
        });

        l2 = findViewById(R.id.l2);
        if(Menu.counter < 11) { l2.setEnabled(false); }
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l2 = new Intent(Var.this, varL2.class);
                startActivity(l2);
            }
        });

        l3 = findViewById(R.id.l3);
        if(Menu.counter < 12) { l3.setEnabled(false); }
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l3 = new Intent(Var.this, varL3.class);
                startActivity(l3);
            }
        });

        l4 = findViewById(R.id.l4);
        if(Menu.counter < 13) { l4.setEnabled(false); }
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l4 = new Intent(Var.this, varL4.class);
                startActivity(l4);
            }
        });

        quiz = findViewById(R.id.varQuiz);
        if(Menu.counter < 14) { quiz.setEnabled(false); }
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quiz= new Intent(Var.this, varQuiz.class);
                startActivity(quiz);
            }
        });



        reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menu.counter = 1;
                Intent menu = new Intent(Var.this,Menu.class);
                startActivity(menu);

                addCounter();
            }
        });
    }

    private void addCounter(){
        Menu.counter = 10;
        menuCounter counter = new menuCounter(Menu.counter);
        databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
    }
}
