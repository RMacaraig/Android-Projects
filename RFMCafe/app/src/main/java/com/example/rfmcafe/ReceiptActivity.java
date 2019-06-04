package com.example.rfmcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiptActivity extends AppCompatActivity implements View.OnClickListener {

    //global variables
    Button btnDone, btnAnotherOrder;
    TextView tvOrderDetails, tvOrderAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        this.referWidgets();
        this.fetchExtras(); //get info from previous screen
    }


    private void referWidgets() {

        //text views
        tvOrderDetails = findViewById(R.id.tv_order);
        tvOrderAmount = findViewById(R.id.tv_amount);

        //calling buttons
        btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(this);
        btnAnotherOrder = findViewById(R.id.btn_another_order);
        btnAnotherOrder.setOnClickListener(this);
    }

    private void fetchExtras() {

        //calling current intent class
        Intent currentIntent = this.getIntent();
        //receiving data from previous activity
        String output = currentIntent.getStringExtra("EXTRA_OUTPUT"); //retrieve the string
        tvOrderDetails.setText(output);

        Double amount = currentIntent.getDoubleExtra("EXTRA_AMOUNT", 0.0);
        tvOrderAmount.setText("$" + amount.toString());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_done:
                this.finishAffinity(); //stop activity from running -hidden and terminated
                break;
            case R.id.btn_another_order:
                this.finish(); //terminate activity
                break;

        }
    }


}
