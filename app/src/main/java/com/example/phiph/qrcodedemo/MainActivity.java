package com.example.phiph.qrcodedemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PERMISSION_REQUEST = 100;
    Button btnScan;
    ImageView imgQRcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        imgQRcode = findViewById(R.id.imgQRcode);
        btnScan.setOnClickListener(this);
        imgQRcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, PERMISSION_REQUEST );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_REQUEST && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MainActivity.this, CameraActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "ban khong cho phep mo camera", Toast.LENGTH_LONG).show();
        }
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
