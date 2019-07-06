package com.example.bmi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    //field variable
     EditText edtHeight;
    EditText edtWeight;
   TextView txtDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to inflated Views
        edtHeight = findViewById(R.id.edt_height);
        edtWeight = findViewById(R.id.edt_weight);
        txtDisplay = findViewById(R.id.txt_display);
    }

        public void button(View view) {

        String heightString = edtHeight.getText().toString();
        String weightString = edtWeight.getText().toString();

        double height = 0;
        double weight = 0;

           if (heightString.trim().length() == 0) {

               //if height is empty show dialog message
               AlertDialog.Builder builder = new AlertDialog.Builder(this);
               builder.setTitle("Enter Valid Information")
                       .setMessage("Enter a valid number for height")
                       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {


                           }
                       });

               //if weight is empty show dialog message
               AlertDialog alertDialog = builder.create();
               alertDialog.show();
        }


            if (weightString.trim().length() == 0) {

                //if height is empty show dialog message
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Enter Valid Information")
                        .setMessage("Enter a valid number for weight")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });


                //if weight is empty show dialog message
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

            try {
                height = Double.parseDouble(heightString);
                weight = Double.parseDouble(weightString);
            } catch (NumberFormatException ex) {
                Toast.makeText(MainActivity.this,
                        "Height and Weight must be numbers",
                        Toast.LENGTH_LONG).show();
                return;
            }
            BMI bmi = new BMI(height, weight);
            txtDisplay.setText(bmi.toString());

        }

//            String heightString = edtHeight.getText().toString();
//            String weightString = edtWeight.getText().toString();
//
//            double height = 0;
//            double weight = 0;
//
//            if (heightString.trim().length() == 0) {
//                String errorMessage = getResources().getString(R.string.error_missing_height);
//                edtHeight.setError(errorMessage);
//                return;
//            }
//
//            try {
//                height = Double.parseDouble(heightString);
//                weight = Double.parseDouble(weightString);
//            } catch (NumberFormatException ex) {
//                Toast.makeText(MainActivity.this,
//                        "Height and Weight must be numbers",
//                        Toast.LENGTH_LONG).show();
//                return;
//            }
//            BMI bmi = new BMI(height, weight);
//            txtDisplay.setText(bmi.toString());


    }

