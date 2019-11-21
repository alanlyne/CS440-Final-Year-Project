package com.alanlyne.tbm.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alanlyne.tbm.Auth.loginActivity;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.temp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity {
    Button btn;
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

                if (counter == 1) {image.setImageResource(R.drawable.g2);}

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WIP = new Intent(Menu.this, com.alanlyne.tbm.WIP.WIP.class);
                startActivity(WIP);
            }
        });


        //Move to Sign out
        btn = findViewById(R.id.btnSignOut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Menu.this, com.alanlyne.tbm.Auth.loginActivity.class);
                startActivity(intToMain);
            }
        });
    }
}
