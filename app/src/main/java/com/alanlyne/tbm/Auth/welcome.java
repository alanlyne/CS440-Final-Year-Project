package com.alanlyne.tbm.Auth;

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
import com.alanlyne.tbm.Variables.varL.varL1;
import com.google.firebase.auth.FirebaseAuth;

public class welcome extends AppCompatActivity {
    TextView t1;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
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
    }
    private void addCounter(){
        counter++;
    }
}
