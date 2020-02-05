package com.alanlyne.tbm.Semester1.hBoolean.booQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Menu.menuCounter;
import com.alanlyne.tbm.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.alanlyne.tbm.Menu.Menu.counter;

public class booRevResult extends AppCompatActivity {

    TextView t1_total,t2_correct,t3_wrong;
    String total,correct,incorrect;
    Button backToMenu;
    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        t2_correct = findViewById(R.id.correct);
        t3_wrong = findViewById(R.id.incorrect);
        t1_total = findViewById(R.id.attempted);
        backToMenu = findViewById(R.id.backToMenu);
        Intent i = getIntent();
        total = i.getStringExtra("total");
        correct = i.getStringExtra("correct");
        incorrect = i.getStringExtra("incorrect");

        setValues();

        if(Menu.counter == 70) {
            System.out.println("FUCKKKKKKKKKKKKKKKKKKKKK");
            addCounter();
        }

        backToMenu.setOnClickListener(v -> {

            Intent menu = new Intent(booRevResult.this, Boolean.class);
            startActivity(menu);

        });
    }

    private void setValues()
    {
        t1_total.setText(total);
        t2_correct.setText(correct);
        t3_wrong.setText(incorrect);
    }

    private void addCounter() {

        System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
        if (correct.compareTo(total) == 0) {
            counter = 71;
            menuCounter counter = new menuCounter(Menu.counter);
            databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
        }
        else{
            System.out.println("Correct is: " + correct);
            System.out.println("Total is: " + total);
        }
    }

}