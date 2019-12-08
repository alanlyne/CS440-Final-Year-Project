package com.alanlyne.tbm.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Variables.Var;
import com.alanlyne.tbm.WIP.WIP;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity {
    Button wip, var, a3, a4, a5, a6, signOut;
    public ImageView image;
    public static int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //Add an image
        image = findViewById(R.id.imageView2);
        image.setImageResource(R.drawable.g1);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("counter");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                menuCounter uCount = dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getValue(com.alanlyne.tbm.Menu.menuCounter.class);
                counter = uCount.counter;

                System.out.println("Counter value is " + counter);

                if (counter >= 10 && counter < 20) {
                    image.setImageResource(R.drawable.g2);
                }


                wip = findViewById(R.id.wip);
                wip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent WIP = new Intent(Menu.this, WIP.class);
                        startActivity(WIP);
                    }
                });

                var = findViewById(R.id.a2);
                if (counter < 10) {
                    var.setEnabled(false);
                }
                var.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Var = new Intent(Menu.this, Var.class);
                        startActivity(Var);
                    }
                });

                a3 = findViewById(R.id.a3);
                if (counter < 20) {
                    a3.setEnabled(false);
                }
                a3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Var = new Intent(Menu.this, Var.class);
                        startActivity(Var);
                    }
                });

                a4 = findViewById(R.id.a4);
                if (counter < 30) {
                    a4.setEnabled(false);
                }
                a4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Var = new Intent(Menu.this, Var.class);
                        startActivity(Var);
                    }
                });

                a5 = findViewById(R.id.a5);
                if (counter < 40) {
                    a5.setEnabled(false);
                }
                a5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Var = new Intent(Menu.this, Var.class);
                        startActivity(Var);
                    }
                });

                a6 = findViewById(R.id.a6);
                if (counter < 50) {
                    a6.setEnabled(false);
                }
                a6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Var = new Intent(Menu.this, Var.class);
                        startActivity(Var);
                    }
                });

                //Move to Sign out
                signOut = findViewById(R.id.btnSignOut);
                signOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseAuth.getInstance().signOut();
                        Intent intToMain = new Intent(Menu.this, com.alanlyne.tbm.Auth.loginActivity.class);
                        startActivity(intToMain);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
