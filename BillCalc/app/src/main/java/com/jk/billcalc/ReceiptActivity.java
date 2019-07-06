package com.jk.billcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jk.billcalc.controller.BillController;
import com.jk.billcalc.model.Bill;

public class ReceiptActivity extends AppCompatActivity implements View.OnClickListener {

    //global variables
    Button btnDone;
    TextView tvAccountNum, tvName, tvWeekday,
            tvEvening, tvVideo, tvAmount;

    BillController billController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);


        this.referWidgets();
        billController = new BillController();
        this.fetchBillInfo();

    }



    private void referWidgets() {
        tvAccountNum = findViewById(R.id.tv_account_number_value);
        tvName = findViewById(R.id.tv_name_value);
        tvWeekday = findViewById(R.id.tv_weekday_charges);
        tvEvening = findViewById(R.id.tv_evening_charges);
        tvVideo = findViewById(R.id.tv_video_charges);
        tvAmount = findViewById(R.id.tv_bill_amount);


        //calling button
        btnDone = findViewById(R.id.button);
        btnDone.setOnClickListener(this);
    }

    private void fetchBillInfo() {
        Intent thisIntent = this.getIntent();
        String accountNumber = thisIntent.getStringExtra("EXTRA_ACCOUNT_NUMBER");

        Bill currentBill = billController.fetchBillByAccNumber(accountNumber);
        tvAccountNum.setText(accountNumber);

        if (currentBill != null) {

            String name = currentBill.getName();
            tvName.setText(name);

            Integer weekday = currentBill.getWeekday();
            tvWeekday.setText("$" + weekday.toString());

            Integer evening = currentBill.getEvening();
            tvEvening.setText("$" + evening.toString());

            Integer video = currentBill.getVideo();
            tvVideo.setText("$" + video.toString());

           Float amount = currentBill.getTotal();
           tvAmount.setText("$" + amount.toString());

        }

    }

    //method used when button is clicked
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                this.finishAffinity(); //stop activity from running -hidden and terminated
                break;
        }
    }
}
