package com.example.task2;
import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.net.Uri;
import android.widget.Toast;

public class  page2 extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_IMAGE_CAPTURE =100 ;
    private Button b, c;
    private ImageView imageView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.page2);
        b = findViewById(R.id.back);
        c = findViewById(R.id.pic);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        imageView = findViewById(R.id.imageView);
        TextView d = findViewById(R.id.details);
        String name = getIntent().getStringExtra("name");
        String sur = getIntent().getStringExtra("sur");
        String phone = getIntent().getStringExtra("phone");
        String address = getIntent().getStringExtra("address");
        d.setText(name + "\n" + sur + "\n" + phone + "\n" + address + "\n");

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        if (view.getId() == R.id.pic) {
            if (ContextCompat.checkSelfPermission(page2.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(page2.this, new String[]{Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
            } else {
                openCamera();
            }
        }
}

private void openCamera() {
    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
}


    @Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    if (requestCode == REQUEST_IMAGE_CAPTURE) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        } else {
            Toast.makeText(this, "Camera permission is required to change the picture.", Toast.LENGTH_SHORT).show();
        }
    }
}

@Override
protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
        assert data != null;
        imageView.setImageBitmap((android.graphics.Bitmap) data.getExtras().get("data"));
    }
}
}
