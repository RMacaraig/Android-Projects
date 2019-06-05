package com.example.ryle_macaraig_a1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by 991435278: Ryle Cheyene Macaraig
 * on 2019-05-28.
 */

//implements View.OnClickListener is used to call submit and cancel buttons
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //class global variables initialized
    Button btnSubmit, btnCancel;
    EditText edtName, edtEmail, edtPhone;
    RadioGroup rdoApp;
    RadioButton rdoSelected; //radio buttons-only 1 radio button is selected
    Spinner spnNewsletter;
    CheckBox chkGuitar, chkFootball, chkSinging, chkChess, chkHorseRiding, chkReading;

    String recommendation = "";
    String hobbies = "";
    String newsletterFreq = "";
    String nameUser = "";
    String emailUser = "";
    String number = "";

    Double yesScore = 0.0;
    Double noScore = 0.0;
    Double maybeScore = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //refer to UI views
        this.referWidgets();
    }

    //method used to call UI views
    private void referWidgets() {

        //EditTexts
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone);

        //RadioGroup
        rdoApp = findViewById(R.id.rdo_app);

        //Checkboxes
        chkGuitar = findViewById(R.id.chk_guitar);
        chkFootball = findViewById(R.id.chk_football);
        chkSinging = findViewById(R.id.chk_singing);
        chkChess = findViewById(R.id.chk_chess);
        chkHorseRiding = findViewById(R.id.chk_horse_riding);
        chkReading = findViewById(R.id.chk_reading);

        //Spinner
        spnNewsletter = findViewById(R.id.spn_newsletter);

        //calling string array from spinner
        //creating object of array adapter class for the character sequence type
        //createFromResource is used to create object and specify context of current activity
        ArrayAdapter<CharSequence> dayAdapter =
                ArrayAdapter.createFromResource(this, R.array.newsletter_array,
                        android.R.layout.simple_spinner_dropdown_item);

        //calling spinner array
        spnNewsletter.setAdapter(dayAdapter);

        //submit button on click
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        //cancel button on click
        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);

    }

    //onClick method used when submit and cancel buttons are clicked
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel: //cancel button
                this.finishAffinity(); //method used to terminate app
                break;

            case R.id.btn_submit: //submit button
                this.getValues(); //method used to get values
                this.openNextActivity(); //create method to open next activity
                this.errorCheck(); //method used for error checking
                break;
        }

    }

    //get values method used when submit button is clicked
    private void getValues() {

        //retrieve name, email, and phone of user
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();

        //getting a radio button that is selected
        rdoSelected = findViewById(rdoApp.getCheckedRadioButtonId());
        String app = rdoSelected.getText().toString();

        this.calculateYes();
        this.calculateNo();
        this.calculateMaybe();

        //check box functionality when clicked
        //users can have multiple check boxes clicked
        String selectedHobbies = "";

        if (chkGuitar.isChecked()) {
            selectedHobbies += "\nGuitar";
        }
        if (chkFootball.isChecked()) {
            selectedHobbies += "\nFootball";
        }
        if (chkSinging.isChecked()) {
            selectedHobbies += "\nSinging";
        }
        if (chkChess.isChecked()) {
            selectedHobbies += "\nChess";
        }
        if (chkHorseRiding.isChecked()) {
            selectedHobbies += "\nHorse Riding";
        }
        if (chkReading.isChecked()) {
            selectedHobbies += "\nReading";
        }

        //get spinner output
        String newsletter = spnNewsletter.getSelectedItem().toString();

        //creating an output string to summarize users' information
//        output = "Please verify your details." + "\nRecommendation : " + " " + app +
//                "\nSelected hobbies : \n" + selectedHobbies + "\nNewsletter frequency : " + newsletter
//                + "\nName : " + name + "\nEmail : " + email + " \nPhone : " + phone + "\nThanks for the feedback.";
//

        recommendation = app;
        hobbies = selectedHobbies;
        newsletterFreq = newsletter;
        nameUser = name;
        emailUser = email;
        number = phone;

        //toast message for user to see their output
//        Toast.makeText(getApplicationContext(),
//                recommendation,
//                hobbies,
//                newsletterFreq,
//                nameUser,
//                emailUser,
//                number,
//                Toast.LENGTH_LONG).show();

    }

    private void calculateYes() {

        switch (rdoSelected.getId()){
            case R.id.spn_newsletter:
                yesScore += 10.0;
                break;
        }

    }

    private void calculateNo() {


    }

    private void calculateMaybe() {


    }


    private void openNextActivity() {

        Intent confirmationIntent = new Intent (this, ConfirmationActivity.class);

        confirmationIntent.putExtra("EXTRA_RECOMMENDATION", recommendation);
        confirmationIntent.putExtra("EXTRA_HOBBIES", hobbies);
        confirmationIntent.putExtra("EXTRA_NEWSLETTER", newsletterFreq);
        confirmationIntent.putExtra("EXTRA_NAME", nameUser);
        confirmationIntent.putExtra("EXTRA_EMAIL", emailUser);
        confirmationIntent.putExtra("EXTRA_NUMBER", number);

        confirmationIntent.putExtra("EXTRA_YES_SCORE", yesScore);
        confirmationIntent.putExtra("EXTRA_NO_SCORE", noScore);
        confirmationIntent.putExtra("EXTRA_MAYBE_SCORE", maybeScore);

        startActivity(confirmationIntent);
    }





    //error check if users does not input name, email, or phone number
    //(added this method for fun)
    private boolean errorCheck() {

        //editText name when input is empty
        if (edtName.length() == 0) {
            edtName.setError("Name is required");
        }

        //editText email when input is empty
        if (edtEmail.length() == 0) {
            edtEmail.setError("Email is required");
        }

        //editText phone when input is empty
        if (edtPhone.length() == 0) {
            edtPhone.setError("Phone number is required");
        }
        return true;
    }

}
