package com.alanlyne.tbm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
        //image.setImageResource(getIntent().getIntExtra("myImageResource",R.drawable.g1));

        if(counter == 1){
            image.setImageResource(R.drawable.g2);
        }

        btn = findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WIP = new Intent(Menu.this, WIP.class);
                startActivity(WIP);
            }
        });
    }
}
