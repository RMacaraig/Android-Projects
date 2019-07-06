package com.example.calcspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spnCalc;
    EditText edtOne, edtTwo;
    String userOne, userTwo;
    Button submit;
    TextView tvTotal;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCalc = findViewById(R.id.spn_calc);

        edtOne = findViewById(R.id.edt_one);
        edtTwo = findViewById(R.id.edt_two);

        submit = findViewById(R.id.btn_submit);
        submit.setOnClickListener(this);

        tvTotal = findViewById(R.id.tv_total);

        ArrayAdapter<CharSequence> numberAdapter =
                ArrayAdapter.createFromResource(this, R.array.calculations,
                        android.R.layout.simple_spinner_dropdown_item);
        spnCalc.setAdapter(numberAdapter);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_submit:
                this.getValues();
                break;

        }
    }

    private void getValues() {

        userOne = edtOne.getText().toString();
        userTwo = edtTwo.getText().toString();

        int total;

        if(spnCalc.getSelectedItem().equals(getResources().getString(R.string.addition))){
            total = Integer.valueOf(userOne) + Integer.valueOf(userTwo);
            tvTotal.setText("Addition = " + total);
        }

        if(spnCalc.getSelectedItem().equals(getResources().getString(R.string.subtraction))){
            total = Integer.valueOf(userOne) - Integer.valueOf(userTwo);
            tvTotal.setText("Subtraction = " + total);
        }

        if(spnCalc.getSelectedItem().equals(getResources().getString(R.string.division))){
            total = Integer.valueOf(userOne) / Integer.valueOf(userTwo);
            tvTotal.setText("Division = " + total);
        }

        if(spnCalc.getSelectedItem().equals(getResources().getString(R.string.multiplication))){
            total = Integer.valueOf(userOne) * Integer.valueOf(userTwo);
            tvTotal.setText("Multiplication = " + total);
        }

    }
}
