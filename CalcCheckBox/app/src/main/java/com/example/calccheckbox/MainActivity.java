package com.example.calccheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CheckBox chkMultiply, chkAdd;
    EditText edtOne, edtTwo;
    String userOne, userTwo;
    Button submit;
    TextView tvTotal;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkMultiply = findViewById(R.id.chk_multiply);
        chkAdd = findViewById(R.id.chk_add);

        edtOne = findViewById(R.id.edt_one);
        edtTwo = findViewById(R.id.edt_two);

        submit = findViewById(R.id.btn_submit);
        submit.setOnClickListener(this);

        tvTotal = findViewById(R.id.tv_total);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_submit:
                this.getValues();
                break;
            case R.id.chk_add:
                this.add();
                break;
            case R.id.chk_multiply:
                this.multiply();
                break;
        }
    }

    private void multiply() {
        if (chkMultiply.isChecked()) {
            total = Integer.valueOf(userOne) * Integer.valueOf(userTwo);
        }
    }

    private void add() {
        if (chkAdd.isChecked()) {
            total = Integer.valueOf(userOne) + Integer.valueOf(userTwo);
        }
    }

    private void getValues() {

        userOne = edtOne.getText().toString();
        userTwo = edtTwo.getText().toString();

        int total;

        if (chkMultiply.isChecked()) {
            total = Integer.valueOf(userOne) * Integer.valueOf(userTwo);
            tvTotal.setText("Multiplication = " + total);
        } else {
            total = Integer.valueOf(userOne) + Integer.valueOf(userTwo);
            tvTotal.setText("Addition = " + total);
        }

        //tvTotal.setText(String.valueOf(total));

        edtOne.setText("");
        edtTwo.setText("");

    }


}

