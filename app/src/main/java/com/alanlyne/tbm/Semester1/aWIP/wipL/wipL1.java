package com.alanlyne.tbm.Semester1.aWIP.wipL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.Menu.menuCounter;
import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.aWIP.WIP;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class wipL1 extends AppCompatActivity{

    TextView t0, t1, t2, t3, t4, t5, t6, x;
    Button b1;
    int counter = 0;
    DatabaseReference databaseName;
    private long mLastClickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wip_l1);
        databaseName = FirebaseDatabase.getInstance().getReference("counter");

        t0 = findViewById(R.id.t0);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        b1 = findViewById(R.id.b1);
        ImageView i1 = findViewById(R.id.i1);
        setContentView(R.layout.activity_wip_l1);

        x = findViewById(R.id.x);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(wipL1.this, WIP.class);
                startActivity(x);
            }
        });



        View view = findViewById(R.id.constraint_layout1);
        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view,MotionEvent event) {

                if (SystemClock.elapsedRealtime() - mLastClickTime < 500) {
                    System.out.println("Fun");
                }
                else{
                mLastClickTime = SystemClock.elapsedRealtime();

                counter++;

                System.out.println(counter);

                if (counter > 0) {
                    TextView tv = findViewById(R.id.t1);
                    tv.setVisibility(View.VISIBLE);
                    ImageView i1 = findViewById(R.id.i1);
                    i1.setVisibility(View.VISIBLE);

                    i1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(i1.getVisibility() == View.VISIBLE){
                                Toast.makeText(wipL1.this, "Hold the screen to return", Toast.LENGTH_SHORT).show();
                                Intent img = new Intent(wipL1.this, lc.class);
                                startActivity(img);
                            }
                        }
                    });
                }

                if (counter > 1) {
                    TextView tv = findViewById(R.id.t2);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 2) {
                    TextView tv = findViewById(R.id.t3);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 3) {
                    TextView tv = findViewById(R.id.t4);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 4) {
                    TextView tv = findViewById(R.id.t5);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 5) {
                    TextView tv = findViewById(R.id.t6);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 6) {
                    Button b1 = findViewById(R.id.b1);
                    b1.setVisibility(View.VISIBLE);
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent Menu = new Intent(wipL1.this, WIP.class);
                            startActivity(Menu);
                            addCounter();
                        }
                    });
                }}
                return true;
            }
        });
    }
    private void addCounter(){
        if(Menu.counter == 0) {
            Menu.counter = 1;
            menuCounter counter = new menuCounter(Menu.counter);
            databaseName.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(counter);
        }
    }
    @Override
    public void onBackPressed()
    {
        Intent end = new Intent(wipL1.this, WIP.class);
        startActivity(end);
    }
}

