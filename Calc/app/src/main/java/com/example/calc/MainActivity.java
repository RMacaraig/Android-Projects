package com.example.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button submit;
    EditText one, two;
    TextView result;

    String numberOne;
    String numberTwo;
    ToggleButton tBtn;
    String option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets();
    }

    private void referWidgets() {

        submit = findViewById(R.id.btn_submit);
        submit.setOnClickListener(this);

        one = findViewById(R.id.edt_one);
        two = findViewById(R.id.edt_two);
        result = findViewById(R.id.tv_total);
        tBtn = findViewById(R.id.toggleButton);
        option = tBtn.getText().toString(); //get current selected option
        tBtn.setOnClickListener(this);
        //option = "add";
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_submit:
                this.getValues();
                break;
            case R.id.toggleButton:
                this.getToggle();
                break;
        }
    }

    private void getToggle() {

        if (tBtn.isChecked()) {
            option = "multiply";
        } else {
            option = "add";
        }
    }

    private void getValues() {

        numberOne = one.getText().toString();
        numberTwo = two.getText().toString();

        int total;

        if ("multiply".equals(option)) {
            total = Integer.valueOf(numberOne) * Integer.valueOf(numberTwo);
        } else {
            total = Integer.valueOf(numberOne) + Integer.valueOf(numberTwo);
        }

        result.setText(String.valueOf(total));
        one.setText("");
        two.setText("");

    }
}
