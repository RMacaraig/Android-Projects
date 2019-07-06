package com.jk.billcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jk.billcalc.controller.BillController;
import com.jk.billcalc.model.Bill;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //global variables
    Button btnBill;
    EditText edtAccountNum, edtName, edtWeekday,
            edtEvening, edtVideo;

    String number, name, accountNumber, total;

    Integer weekday = 0;
    Integer evening = 0;
    Integer video = 0;




    Bill newBill;
    BillController billController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to UI views
        this.referWidgets();

        billController = new BillController();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        this.onBackPressed();
    }




    //method used to call UI views
    private void referWidgets() {
        edtAccountNum = findViewById(R.id.edt_account_number);
        edtName = findViewById(R.id.edt_name);
        edtWeekday = findViewById(R.id.edt_weekday);
        edtEvening = findViewById(R.id.edt_evening);
        edtVideo = findViewById(R.id.edt_video);

        btnBill = findViewById(R.id.button);
        btnBill.setOnClickListener(this);

    }

    public void onBackPressed() {
        edtName.setText("");
        edtAccountNum.setText("");
        weekday = 0;
        evening = 0;
        video = 0;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (this.validateData()) {
                    this.getValues();

                    //get info
                    newBill = new Bill(accountNumber, name, weekday, evening, video, total);
                    billController.insertBill(newBill);

                    //calling confirmation activity
                    Intent receiptIntent = new Intent(this, ReceiptActivity.class);
                    receiptIntent.putExtra("EXTRA_ACCOUNT_NUMBER", accountNumber);
                    startActivity(receiptIntent);
                }
                break;
        }

    }

    private void getValues() {

        number = edtAccountNum.getText().toString();
        name = edtName.getText().toString();

        this.calculateWeekday();
        this.calculateEvening();
        this.calculateVideo();


    }

    private void calculateVideo() {
        switch (edtVideo.getId()) {
            case R.id.edt_video:
                video += 40;
                break;

        }

    }

    private void calculateEvening() {
        switch (edtEvening.getId()) {
            case R.id.edt_evening:
                evening += 25;
                break;

        }

    }

    private void calculateWeekday() {
        switch (edtWeekday.getId()) {
            case R.id.edt_weekday:
                weekday += 35;
                break;

        }
    }




    private boolean validateData() {
        boolean allValidations = true;

        if (edtAccountNum.getText().toString().isEmpty()) {
            edtAccountNum.setError("Account number is required");
            allValidations = false;
        } else if (!Utils.isValidAccountNumber(edtAccountNum.getText().toString())) {
            edtAccountNum.setError("Please provide valid account number");
            allValidations = false;
        }

        if (edtName.getText().toString().isEmpty()) {
            edtName.setError("Name is required");
            allValidations = false;
        } else if (!Utils.isValidName(edtName.getText().toString())) {
            edtName.setError("Please provide valid name");
            allValidations = false;
        }

        if (edtWeekday.getText().toString().isEmpty()) {
            edtWeekday.setError("Weekday is required");
            allValidations = false;
        } else if (!Utils.isValidWeekday(edtWeekday.getText().toString())) {
            edtWeekday.setError("Please provide valid weekday");
            allValidations = false;
        }

        if (edtEvening.getText().toString().isEmpty()) {
            edtEvening.setError("Evening is required");
            allValidations = false;
        } else if (!Utils.isValidEvening(edtEvening.getText().toString())) {
            edtEvening.setError("Please provide valid evening");
            allValidations = false;
        }

        if (edtVideo.getText().toString().isEmpty()) {
            edtVideo.setError("Video is required");
            allValidations = false;
        } else if (!Utils.isValidVideo(edtVideo.getText().toString())) {
            edtVideo.setError("Please provide valid video");
            allValidations = false;
        }

        return allValidations;


    }

}
