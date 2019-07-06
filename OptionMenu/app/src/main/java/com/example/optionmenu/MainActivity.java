package com.example.optionmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name;
    Button display, reset;
    TextView output;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referWidgets();
    }

    private void referWidgets() {

        name = findViewById(R.id.edt_name);

        display = findViewById(R.id.btn_display);
        display.setOnClickListener(this);
        reset = findViewById(R.id.btn_reset);
        reset.setOnClickListener(this);

        output = findViewById(R.id.tv_output);
    }

    //read the file and add to action bar
    @Override
    public boolean onCreateOptionsMenu (Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);

        return true;
    }


    //refer menu when action is clicked 
    @Override
    public boolean onOptionsItemSelected (MenuItem item){

        int id = item.getItemId();
        if(id == R.id.item1){
            //Toast.makeText(this, "You clicked Item 1", Toast.LENGTH_LONG).show();

            Intent secondIntent = new Intent(this, SecondActivity.class);
            startActivity(secondIntent);

            return true;
        }

        if(id == R.id.display){
            //Toast.makeText(this, "Reset", Toast.LENGTH_LONG).show();
            username = name.getText().toString();
            String person = username;
            output.setText("Hello " + person);
            return true;
        }

        if(id == R.id.reset){
            //Toast.makeText(this, "Display", Toast.LENGTH_LONG).show();
            name.setText("");
            output.setText("");
            return true;
        }

        if(id == R.id.bye){
            Toast.makeText(this, "Bye-bye", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_display:
                getDisplay();
                break;
            case R.id.btn_reset:
                getReset();
        }

    }

    private void getDisplay() {

        username = name.getText().toString();
        String person = username;
        output.setText("Hello " + person);

    }

    private void getReset() {

        name.setText("");
        output.setText("");

    }
}
