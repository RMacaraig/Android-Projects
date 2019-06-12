package com.example.rfmcafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //class global variables
    Button btnCancel, btnSubmit;

    RadioGroup rdoCoffee;

    //only one radio button is selected
    RadioButton rdoSelected;

    //check boxes can have multiple selections
    CheckBox chkDom, chkEspresso, chkSleeve, chkWhipped;

    Spinner spnCream, spnSugar;

    EditText edtName;

    String output = "";

    Double amount = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to UI views
        this.referWidgets();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.resetWidgets();
    }


    private void referWidgets() {

        edtName = findViewById(R.id.edt_name);

        rdoCoffee = findViewById(R.id.rdo_coffee);

        chkDom = findViewById(R.id.chk_dom);
        chkEspresso = findViewById(R.id.chk_espresso);
        chkSleeve = findViewById(R.id.chk_sleeve);
        chkWhipped = findViewById(R.id.chk_whipped);

        //spinner
        spnCream = findViewById(R.id.spn_cream);
        spnSugar = findViewById(R.id.spn_sugar);

        //string array from spinner
        //creating object of array adapter class for the char sequence type
        //to create object use createfromresource
        //specify context of current activity
        ArrayAdapter<CharSequence> numberAdapter =
                ArrayAdapter.createFromResource(this, R.array.number_array,
                        android.R.layout.simple_spinner_dropdown_item); //how to display values available in spinner


        spnCream.setAdapter(numberAdapter);
        spnSugar.setAdapter(numberAdapter);


        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);

        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);


    }


    @Override
    //object of view that is being clicked
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                Log.d("MainActivity", "Cancel Clicked");
                this.finishAffinity(); //stop activity from running -hidden and terminated
                break;
            case R.id.btn_submit:
                Log.d("MainActivity", "Submit Clicked");
                this.getValues(); //create methods to get values
                this.openNextActivity(); //open next activity
                break;
        }

    }


    //get values method
    private void getValues() {

        //retrieve name of user
        String name = edtName.getText().toString();

        //getting of radio button that is selected
        rdoSelected = findViewById(rdoCoffee.getCheckedRadioButtonId());
        String coffee = rdoSelected.getText().toString();

        this.calculateAmount();


        String addOn = "";

        if (chkWhipped.isChecked()) {
            addOn += " Whipped Cream \n "; //has multiple checkboxes that can be selected
            amount += 0.50;

        }
        if (chkEspresso.isChecked()) {
            addOn += " Espresso Shot \n ";
            amount += 0.70;

        }
        if (chkSleeve.isChecked()) {
            addOn += " Sleeve \n ";

        }
        if (chkDom.isChecked()) {
            addOn += " Dom Lid \n";

        }

        String cream = spnCream.getSelectedItem().toString() + " cream ";
        String sugar = spnSugar.getSelectedItem().toString() + " sugar ";


        output = " Hey " + name + " \n Thank you for your order of \n " + coffee + " " + cream + sugar +
                " with " + addOn;

        Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();

    }

    private void calculateAmount() {

        switch (rdoSelected.getId()) {
            case R.id.rdo_dark:
                amount += 1.70;
                break;
            case R.id.rdo_original:
                amount += 1.50;
                break;
            case R.id.rdo_french:
                amount += 2.50;
                break;
            case R.id.rdo_iced:
                amount += 3.00;
                break;

            // case R.string.app_name:
            //  amount += 3.00;
            //  break;



        }
    }

    private void openNextActivity() {
        //type of resources used to create activities with different resources
        //create object of intent
        //choose which class you want to open activity
        Intent receiptIntent = new Intent(this, ReceiptActivity.class);
        //getting the resource in second activity
        //sending data from activity
        receiptIntent.putExtra("EXTRA_OUTPUT", output);
        receiptIntent.putExtra("EXTRA_AMOUNT", amount);

        //ready to start activity
        startActivity(receiptIntent);

    }

    private void resetWidgets() {
        //buttons will not be selected anymore
        rdoSelected.setChecked(false);
        chkWhipped.setChecked(false);
        chkDom.setChecked(false);
        chkSleeve.setChecked(false);
        chkEspresso.setChecked(false);
        spnSugar.setSelection(0);
        spnCream.setSelection(0);
        edtName.setText("");
        amount = 0.0;
    }


}
