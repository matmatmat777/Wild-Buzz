package com.example.apprenti.wildbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class List extends AppCompatActivity {
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            //intent bidon vers profile
            public void onClick(View v) {
                Intent goLogin = new Intent(List.this, ChallengeB.class);
                startActivity(goLogin);
            }
        });
    }
}

