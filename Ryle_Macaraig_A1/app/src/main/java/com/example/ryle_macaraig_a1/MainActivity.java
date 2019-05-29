package com.example.ryle_macaraig_a1;

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

//implements View.OnClickListener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //variables to call all objects
    Button btnSubmit, btnCancel;
    EditText edtName, edtEmail, edtPhone;
    RadioGroup rdoApp;
    RadioButton rdoSelected;
    Spinner spnNewsletter;
    CheckBox chkGuitar, chkFootball, chkSinging, chkChess, chkHorseRiding, chkReading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referWidgets();
    }

    private void referWidgets() {

        //Edit Texts
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

        ArrayAdapter<CharSequence> dayAdapter =
                ArrayAdapter.createFromResource(this, R.array.newsletter_array,
                        android.R.layout.simple_spinner_dropdown_item);

        spnNewsletter.setAdapter(dayAdapter);

        //Submit button
        btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        //Cancel button
        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                this.finishAffinity();
                break;

            case R.id.btn_submit:

                this.getValues();
                this.errorCheck();
                break;
        }

    }

    private void getValues() {

        //getting input from edit texts
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String phone = edtPhone.getText().toString();

        //getting of radio button that is selected
        rdoSelected = findViewById(rdoApp.getCheckedRadioButtonId());
        String stuff = rdoSelected.getText().toString();


        //check box functionality
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

        String newsletter = spnNewsletter.getSelectedItem().toString();

        String output = "Please verify your details." + "\nRecommendation : " + " " + stuff + "\nSelected hobbies : \n" + selectedHobbies + "\nNewsletter frequency : " + newsletter + "\nName : " + name + "\nEmail : " + email + " \nPhone : " + phone + "\nThanks for the feedback.";

        Toast.makeText(getApplicationContext(), output, Toast.LENGTH_LONG).show();

    }

    //error check if users does not input name, email, or phone number
    private boolean errorCheck() {
        if (edtName.length() == 0) {
            edtName.setError("Name is required");
        }
        if (edtEmail.length() == 0) {
            edtEmail.setError("Email is required");
        }
        if (edtPhone.length() == 0) {
            edtPhone.setError("Phone number is required");
        }
        return true;
    }

}
