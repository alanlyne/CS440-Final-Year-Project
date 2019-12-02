package com.alanlyne.tbm.WIP.wipL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Menu.menuCounter;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.WIP.WIP;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class wipL1 extends AppCompatActivity{

    Button btn, c1;
    TextView t1;
    int counter = 0;
    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wip_l1);

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
                Intent menu = new Intent(wipL1.this,WIP.class);
                startActivity(menu);
                if(Menu.counter == 0) {
                    addCounter();
                }
            }
        });
    }

    private void addCounter(){
        Menu.counter = 1;
        menuCounter counter = new menuCounter(Menu.counter);
        databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
    }
}

