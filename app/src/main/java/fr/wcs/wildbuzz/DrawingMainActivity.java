package fr.wcs.wildbuzz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DrawingMainActivity extends AppCompatActivity {

    private DrawingView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_main);
        drawView = (DrawingView)findViewById(R.id.drawing);



    }

    private void setupDrawing(){
//get drawing area setup for interaction
    }


}
