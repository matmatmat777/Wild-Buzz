package fr.wcs.wildbuzz;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class List extends AppCompatActivity implements View.OnClickListener {


    ImageButton buttonChallengeA;
    ImageButton buttonChallengeB;
    ImageButton buttonChallengeC;
    BottomNavigationView buttomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        buttomBar = (BottomNavigationView)findViewById(R.id.bottomNavigation);
        buttonChallengeA=(ImageButton)findViewById(R.id.buttonChallengeA);
        buttonChallengeB=(ImageButton)findViewById(R.id.buttonChallengeB);
        buttonChallengeC=(ImageButton)findViewById(R.id.buttonChallengeC);
        buttonChallengeA.setOnClickListener(this);
        buttonChallengeB.setOnClickListener(this);
        buttonChallengeC.setOnClickListener(this);
    }


    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonChallengeA:
                Intent buttonA = new Intent(List.this, ChallengeA.class);
                List.this.startActivity(buttonA);
                break;

            case R.id.buttonChallengeB:
                Intent buttonB = new Intent(List.this, ChallengeB.class);
                List.this.startActivity(buttonB);
                break;

            case R.id.buttonChallengeC:
                Intent buttonC = new Intent(List.this, ChallengeC.class);
                List.this.startActivity(buttonC);
                break;

            default:
                break;
        }
    }
    }

