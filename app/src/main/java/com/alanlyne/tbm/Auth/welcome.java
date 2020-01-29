package com.alanlyne.tbm.Auth;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.alanlyne.tbm.Menu.Menu;
import com.alanlyne.tbm.R;

public class welcome extends AppCompatActivity {
    TextView t0, t1, t2;
    Button b1;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t0 = findViewById(R.id.t0);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        b1 = findViewById(R.id.b1);
        setContentView(R.layout.activity_welcome);

        View view = findViewById(R.id.ScrollView01);
        view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view,MotionEvent event) {
                counter++;
                System.out.println(counter);
                if (counter > 0) {
                    TextView tv = findViewById(R.id.t1);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 2) {
                    TextView tv = findViewById(R.id.t2);
                    tv.setVisibility(View.VISIBLE);
                }
                if (counter > 4) {
                    Button b1 = findViewById(R.id.b1);
                    b1.setVisibility(View.VISIBLE);
                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent Menu = new Intent(welcome.this, Menu.class);
                            startActivity(Menu);
                        }
                    });
                }
                return true;
            }
        });
    }
}