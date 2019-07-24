package com.example.database1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEdt, emailEdt;
    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdt = findViewById(R.id.edt_name);
        emailEdt = findViewById(R.id.edt_email);
        db = new DBAdapter(this);

    }

    public void addRecord(View view) {
        //get record info
        String name = nameEdt.getText().toString();
        String email = emailEdt.getText().toString();

        //open db
        if (name.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
        } else {
            db.open();

            //call insert method
            db.insertContact(name, email);

            //close db
            db.close();
            nameEdt.setText("");
            emailEdt.setText("");
            Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        }



    }

    public void goTo2Activity(View view) {

        Intent i = new Intent (this, SecondActivity.class);
        startActivity(i);

    }
}
