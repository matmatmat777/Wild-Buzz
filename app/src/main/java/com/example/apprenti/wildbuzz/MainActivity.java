package com.example.apprenti.wildbuzz;
        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity  {

    private FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();





        final Button buttonCompte = (Button) findViewById(R.id.buttonCompte);
        buttonCompte.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent goLogin = new Intent(MainActivity.this, Profile.class);
                startActivity(goLogin);
            }
        });


    }
}

