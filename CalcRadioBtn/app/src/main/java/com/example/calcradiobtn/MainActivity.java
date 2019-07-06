package com.example.calcradiobtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RadioGroup rdoMath;
    RadioButton rdoSelected;
    RadioButton rdoAdd, rdoSubtract, rdoMultiply, rdoDivide;


    Button btnSubmit;

    EditText edtOne, edtTwo;
    String userOne, userTwo;
    TextView tvTotal;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referWidgets();
    }

    private void referWidgets() {

        //radio group
        rdoMath = findViewById(R.id.rdo_math);

        //radio button
        rdoAdd = findViewById(R.id.rdo_add);
        rdoSubtract = findViewById(R.id.rdo_subtract);
        rdoMultiply = findViewById(R.id.rdo_multiply);
        rdoDivide = findViewById(R.id.rdo_divide);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        edtOne = findViewById(R.id.edt_one);
        edtTwo = findViewById(R.id.edt_two);
        tvTotal = findViewById(R.id.tv_total);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_submit:
                getValues();
                break;
        }
    }

    private void getValues() {

        userOne = edtOne.getText().toString();
        userTwo = edtTwo.getText().toString();
        rdoSelected = findViewById(rdoMath.getCheckedRadioButtonId());

        int total;

        if (rdoAdd.isChecked()) {
            total = Integer.valueOf(userOne) + Integer.valueOf(userTwo);
            tvTotal.setText("Addition = " + total);
        } else if (rdoSubtract.isChecked()) {
            total = Integer.valueOf(userOne) - Integer.valueOf(userTwo);
            tvTotal.setText("Subtraction = " + total);
        } else if (rdoMultiply.isChecked()){
            total = Integer.valueOf(userOne) * Integer.valueOf(userTwo);
            tvTotal.setText("Multiplication = " + total);
        } else if (rdoDivide.isChecked()){
            total = Integer.valueOf(userOne) / Integer.valueOf(userTwo);
            tvTotal.setText("Division = " + total);
        }
        //tvTotal.setText(String.valueOf(total));
        edtOne.setText("");
        edtTwo.setText("");
    }




}
