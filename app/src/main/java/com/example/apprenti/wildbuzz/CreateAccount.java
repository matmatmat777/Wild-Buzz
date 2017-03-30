package com.example.apprenti.wildbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.R.attr.checked;

public class CreateAccount extends AppCompatActivity {
    RadioButton radioButtonLaLoupe;
    RadioButton radioButtonOrlean;
    RadioButton radioButtonLyon;
    RadioButton radioButtonFontainebleau;
    RadioButton radioButtonBordeaux;
    RadioButton radioButtonToulouse;
    RadioGroup group1;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        this.setTitle("Choisis ton école ...");

        radioButtonLaLoupe = (RadioButton)findViewById(R.id.radioButtonLaLoupe);
        radioButtonBordeaux = (RadioButton) findViewById(R.id.radioButtonBordeaux);
        radioButtonFontainebleau = (RadioButton) findViewById(R.id.radioButtonFontainebleau);
        radioButtonLyon = (RadioButton) findViewById(R.id.radioButtonLyon);
        radioButtonOrlean = (RadioButton)findViewById(R.id.radioButtonOrlean);
        radioButtonToulouse = (RadioButton)findViewById(R.id.radioButtonToulouse);


        switch (group1.getId()){
            case R.id.radioButtonLaLoupe:
                if (true)
                    str = "La Loupe";
                break;

        }
        switch (group1.getId()){
            case R.id.radioButtonBordeaux:
                if (true)
                    str = "Bordeaux";
                break;

        }
        switch (group1.getId()){
            case R.id.radioButtonFontainebleau:
                if (true)
                    str = "Fontainebleau";
                break;

        }
        switch (group1.getId()){
            case R.id.radioButtonLyon:
                if (true)
                    str = "Lyon";
                break;

        }
        switch (group1.getId()){
            case R.id.radioButtonOrlean:
                if (true)
                    str = "Orléan";
                break;

        }
        switch (group1.getId()){
            case R.id.radioButtonToulouse:
                if (true)
                    str = "Toulouse";
                break;

        }
        Intent intent = new Intent(this, List.class);
        intent.putExtra("radioChosen", str);
        startActivity(intent);

       /* group1= (RadioGroup) findViewById(R.id.group1);
        RadioButton group1_checked = (RadioButton) group1.getCheckedRadioButtonId();
        String val1 = group1_checked.getText().toString();


        Intent i = new Intent(getApplicationContext(), DeuxiemeEcran.class);
        i.putExtra("val1", val1);
        startActivity(i);*/






    }

}
