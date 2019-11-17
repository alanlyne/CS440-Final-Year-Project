package com.alanlyne.tbm.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.alanlyne.tbm.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Menu extends AppCompatActivity {
    private static final String TAG = "Menu";
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
                menuCounter uCount = dataSnapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getValue(menuCounter.class);
                counter = uCount.counter;

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
    }
}
