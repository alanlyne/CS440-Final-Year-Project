package com.alanlyne.tbm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    Button buttonAdd;
    EditText editTextName;
    EditText editPhone;

    DatabaseReference databaseName;

    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        databaseName = FirebaseDatabase.getInstance().getReference("name");

        editTextName = findViewById(R.id.name);
        buttonAdd = findViewById(R.id.submit);
        editPhone = findViewById(R.id.phone);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInfo();
            }
        });

        //Add an image
        final ImageView TestImage = findViewById(R.id.TestImage);
        TestImage.setImageResource(R.drawable.download);

        //Change image on button press
        Button button = findViewById(R.id.imageButton1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TestImage.setImageResource(R.drawable.image);
            }
        });

        //Move to Sign out
        btnLogout = findViewById(R.id.logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, loginActivity.class);
                startActivity(intToMain);
            }
        });



    }

    private void addInfo(){
        String name = editTextName.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){
            String id = databaseName.push().getKey();

            name userName = new name(id, name, phone);

            databaseName.child(id).setValue(userName);

            Toast.makeText(this, "Name added", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Enter name", Toast.LENGTH_LONG).show();
        }
    }
}
