package com.example.ryle_macaraig_a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


//implements View.OnClickListener
public class MainActivity extends AppCompatActivity {

    Button submit, cancel;
    EditText name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.btn_submit);
        //submit.setOnClickListener(this);

        cancel = findViewById(R.id.btn_cancel);
        //cancel.setOnClickListener(this);

        name = findViewById(R.id.edt_name);
        email = findViewById(R.id.edt_email);
        phone = findViewById(R.id.edt_phone);


        //submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //cancel button
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }






//    @Override
//    public void onClick(View v){
//
//        if (v.getId() == submit.getId()){
//
//        }
//    }

//    @Override
//    public void onClick(View v){
//
//        if (v.getId() == cancel.getId()){
//
//        }
//    }




}
