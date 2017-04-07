package fr.wcs.wildbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChallengeC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengec);


        final Button buttonToWildPicasso = (Button) findViewById(R.id.buttonParticipationWildPicasso);
        buttonToWildPicasso.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent goLogin = new Intent(ChallengeC.this, DrawingMainActivity.class);
                startActivity(goLogin);
            }
        });
    }
}