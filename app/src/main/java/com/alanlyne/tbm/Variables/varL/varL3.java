package com.alanlyne.tbm.Variables.varL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Menu.menuCounter;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Variables.Var;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class varL3 extends AppCompatActivity {
    Button btn, c1;
    TextView t1;
    int counter = 0;
    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_var_l3);

        databaseName = FirebaseDatabase.getInstance().getReference("counter");



        btn = findViewById(R.id.finishL1);
        c1 = findViewById(R.id.c1);
        t1 = findViewById(R.id.t1);




        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = 1;
                System.out.println(counter);

                if(counter == 1){
                    TextView tv = findViewById(R.id.t1);
                    tv.setVisibility(View.VISIBLE);
                }
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menu.counter = 1;
                Intent menu = new Intent(varL3.this, Var.class);
                startActivity(menu);
                if(Menu.counter == 12) {
                    addCounter();
                }
            }
        });
    }

    private void addCounter(){
        Menu.counter = 13;
        menuCounter counter = new menuCounter(Menu.counter);
        databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
    }
}
