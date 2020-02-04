package com.alanlyne.tbm.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alanlyne.tbm.Iteration.Iteration;
import com.alanlyne.tbm.Operators.op;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.SelectionStatements.SS;
import com.alanlyne.tbm.Strings.Strings;
import com.alanlyne.tbm.Variables.Var;
import com.alanlyne.tbm.WIP.WIP;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity {
    Button wip, var, op, ss, a5, a6, a7, a8, a9, a10, a11, a12, signOut;
    public ImageView image;
    public static int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //Add an image
        image = findViewById(R.id.imageView2);
        image.setImageResource(R.drawable.c0);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("counter");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                menuCounter uCount = dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getValue(com.alanlyne.tbm.Menu.menuCounter.class);
                counter = uCount.counter;

                System.out.println("Counter value is " + counter);

                if (counter >= 10 && counter < 20) {

                    image.setImageResource(R.drawable.c1);
                }


                wip = findViewById(R.id.wip);
                wip.setOnClickListener(v -> {
                    Intent WIP = new Intent(Menu.this, WIP.class);
                    startActivity(WIP);
                });

                var = findViewById(R.id.a2);
                if (counter < 10) {
                    var.setEnabled(false);
                }
                var.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Var.class);
                    startActivity(Var);
                });

                op = findViewById(R.id.a3);
                if (counter < 20) {
                    op.setEnabled(false);
                }
                op.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, op.class);
                    startActivity(Var);
                });

                ss = findViewById(R.id.a4);
                if (counter < 30) {
                    ss.setEnabled(false);
                }
                ss.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, SS.class);
                    startActivity(Var);
                });

                a5 = findViewById(R.id.a5);
                if (counter < 40) {
                    a5.setEnabled(false);
                }
                a5.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Iteration.class);
                    startActivity(Var);
                });

                a6 = findViewById(R.id.a6);
                if (counter < 50) {
                    a6.setEnabled(false);
                }
                a6.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Strings.class);
                    startActivity(Var);
                });

                a7 = findViewById(R.id.a7);
                if (counter < 60) {
                    a7.setEnabled(false);
                }
                a7.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Strings.class);
                    startActivity(Var);
                });

                a8 = findViewById(R.id.a8);
                if (counter < 70) {
                    a8.setEnabled(false);
                }
                a8.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Strings.class);
                    startActivity(Var);
                });

                a9 = findViewById(R.id.a9);
                if (counter < 70) {
                    a9.setEnabled(false);
                }
                a9.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Strings.class);
                    startActivity(Var);
                });

                a10 = findViewById(R.id.a10);
                if (counter < 80) {
                    a10.setEnabled(false);
                }
                a10.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Strings.class);
                    startActivity(Var);
                });

                a11 = findViewById(R.id.a11);
                if (counter < 90) {
                    a11.setEnabled(false);
                }
                a11.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Strings.class);
                    startActivity(Var);
                });

                a12 = findViewById(R.id.a12);
                if (counter < 110) {
                    a12.setEnabled(false);
                }
                a12.setOnClickListener(v -> {
                    Intent Var = new Intent(Menu.this, Strings.class);
                    startActivity(Var);
                });

                //Move to Sign out
                signOut = findViewById(R.id.btnSignOut);
                signOut.setOnClickListener(v -> {
                    FirebaseAuth.getInstance().signOut();
                    Intent intToMain = new Intent(Menu.this, com.alanlyne.tbm.Auth.loginActivity.class);
                    startActivity(intToMain);
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
