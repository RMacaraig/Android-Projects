package com.example.ryle_macaraig_a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
public class MainActivity extends AppCompatActivity {

    //variables to call all objects
    Button btnSubmit, btnCancel;
    EditText edtName, edtEmail, edtPhone;
    RadioGroup rdoApp;
    RadioButton rdoYes, rdoNo, rdoMaybe;
    //spinner??????
    CheckBox chkGuitar, chkFootball, chkSinging, chkChess, chkHorseRiding, chkReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Submit button
        btnSubmit = findViewById(R.id.btn_submit);

        //Cancel button
        btnCancel = findViewById(R.id.btn_cancel);

        //Edit Texts
        edtName = findViewById(R.id.edt_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone);

        //RadioGroup
        rdoApp = findViewById(R.id.rdo_app);

        //Radio Buttons
        rdoYes = findViewById(R.id.rdo_yes);
        rdoNo = findViewById(R.id.rdo_no);
        rdoMaybe = findViewById(R.id.rdo_maybe);

        //Checkboxes
        chkGuitar = findViewById(R.id.chk_guitar);
        chkFootball = findViewById(R.id.chk_football);
        chkSinging = findViewById(R.id.chk_singing);
        chkChess = findViewById(R.id.chk_chess);
        chkHorseRiding = findViewById(R.id.chk_horse_riding);
        chkReading = findViewById(R.id.chk_reading);

        //submit button clicked functionality
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //error check method
                errorCheck();

                //calling radio buttons when clicked
                rdoYes = findViewById(rdoApp.getCheckedRadioButtonId());
                rdoNo = findViewById(rdoApp.getCheckedRadioButtonId());
                rdoMaybe = findViewById(rdoApp.getCheckedRadioButtonId());

                //getting input from edit texts
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();

                //toast message to output users inputs
                Toast.makeText(MainActivity.this, "Please verify your details." + "\nRecommendations: " + "....." + "\nName : " + name + "\nEmail : " + email + " \nPhone : " + phone + "\nThanks for the feedback.", Toast.LENGTH_LONG).show();


                //check box functionality
//                String selectedHobbies = "";
//
//                if (chkGuitar.isChecked()) {
//                    selectedHobbies += chkGuitar.getText().toString() + "\n";
//                }
//                else{
//                    selectedHobbies += chkGuitar.getText().toString() + "\n";
//                }
//
//                if (chkFootball.isChecked()) {
//                    selectedHobbies += chkFootball.getText().toString() + "\n";
//                }
//                else{
//                    selectedHobbies += chkFootball.getText().toString() + "\n";
//                }
//
//                if (chkSinging.isChecked()) {
//                    selectedHobbies += chkSinging.getText().toString() + "\n";
//                }
//                else{
//                    selectedHobbies += chkSinging.getText().toString() + "\n";
//                }
//
//                if (chkChess.isChecked()) {
//                    selectedHobbies += chkChess.getText().toString() + "\n";
//                }
//                else{
//                    selectedHobbies += chkChess.getText().toString() + "\n";
//                }
//
//                if (chkHorseRiding.isChecked()) {
//                    selectedHobbies += chkHorseRiding.getText().toString() + "\n";
//                }
//                else{
//                    selectedHobbies += chkHorseRiding.getText().toString() + "\n";
//                }
//
//                if (chkReading.isChecked()) {
//                    selectedHobbies += chkReading.getText().toString() + "\n";
//                }
//                else{
//                    selectedHobbies += chkReading.getText().toString() + "\n";
//                }

                // display it as Toast to the user

                //Toast.makeText(MainActivity.this, "Please verify your details" + "\n Recommendation: " + yes + no +  maybe +"\n CheckBox Choices: \n "+ selectedHobbies , Toast.LENGTH_LONG).show();


            }


        });

        //cancel button clicked functionality
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //clear all edit texts
                edtName.getText().clear();
                edtEmail.getText().clear();
                edtPhone.getText().clear();

            }
        });

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
