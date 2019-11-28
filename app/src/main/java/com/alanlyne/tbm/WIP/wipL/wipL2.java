package com.alanlyne.tbm.WIP.wipL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Menu.menuCounter;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.WIP.WIP;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class wipL2 extends AppCompatActivity {

    Button btn;

    DatabaseReference databaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wip_l2);

        databaseName = FirebaseDatabase.getInstance().getReference("counter");


        btn = findViewById(R.id.finishL2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(wipL2.this, WIP.class);
                startActivity(menu);
                if(Menu.counter == 1) {
                    addCounter();
                }
            }
        });
    }

    private void addCounter(){
        Menu.counter = 2;
        menuCounter counter = new menuCounter(Menu.counter);
        databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
    }
}
