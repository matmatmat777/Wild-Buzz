package com.example.apprenti.wildbuzz;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Random;

public class ChallengeAplay extends AppCompatActivity {
    TextView button;
    ImageView imageView;
    StorageReference myrefernce;


    private static final String LOG_TAG = "Barcode Scanner API";
    private static final int PHOTO_REQUEST = 10;
    private TextView scan;
    private Uri imageuri;
    private static final int REQUEST_WRITE_PERMISSION = 20;
    private static final String SAVED_INSTANCE_URI = "uri";
    private static final String SAVED_INSTANCE_RESULT = "result";
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_aplay);
        button = (TextView) findViewById(R.id.btnCamera);
        imageView = (ImageView) findViewById(R.id.imageView);
        scan = (TextView) findViewById(R.id.txtContent);
        myrefernce = FirebaseStorage.getInstance().getReference();
        progressDialog = new ProgressDialog(ChallengeAplay.this);
        if (savedInstanceState!=null){


            imageuri = Uri.parse(savedInstanceState.getString(SAVED_INSTANCE_URI));
            scan.setText(savedInstanceState.getString(SAVED_INSTANCE_RESULT));

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scan.setText("");
                imageView.setImageBitmap(null);
                ActivityCompat.requestPermissions(ChallengeAplay.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_WRITE_PERMISSION);

            }
        });


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case REQUEST_WRITE_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takePicture();
                } else {
                    Toast.makeText(ChallengeAplay.this, "Permission Denied!"+requestCode, Toast.LENGTH_SHORT).show();
                }


        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST && resultCode == RESULT_OK) {
            launchMediaScanIntent();
            try {
                Scanner scanner = new Scanner();
                final Bitmap bitmap = scanner.decodeBitmapUri(ChallengeAplay.this, imageuri);
                progressDialog.setTitle("Uploading..");
                progressDialog.show();
                StorageReference filepath = myrefernce.child("photos").child(imageuri.getLastPathSegment())
                        .child("ecole");
                filepath.putFile(imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imageView.setImageBitmap(bitmap);
                        Toast.makeText(ChallengeAplay.this,"uploaded",Toast.LENGTH_LONG).show();
                        scan.setText("Image just uploaded on Firebase");
                        progressDialog.dismiss();
                    }
                });


            } catch (Exception e) {
                Toast.makeText(this, "Failed to load Image", Toast.LENGTH_SHORT)
                        .show();
                Log.e(LOG_TAG, e.toString());
            }
        }
    }

    public void takePicture() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Random random = new Random();
        int key =random.nextInt(1000);
        File photo = new File(Environment.getExternalStorageDirectory(), "picture"+key+".jpg");
        //  File photo = new File(getCacheDir(), "picture.jpg");
        imageuri = Uri.fromFile(photo);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageuri);
        startActivityForResult(intent, PHOTO_REQUEST);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (imageuri != null) {
            outState.putString(SAVED_INSTANCE_URI, imageuri.toString());
            outState.putString(SAVED_INSTANCE_RESULT, scan.getText().toString());
        }
        super.onSaveInstanceState(outState);
    }

    private void launchMediaScanIntent() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(imageuri);
        this.sendBroadcast(mediaScanIntent);
    }

}
