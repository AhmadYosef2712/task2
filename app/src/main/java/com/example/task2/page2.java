package com.example.task2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class  page2 extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_IMAGE_CAPTURE =1 ;
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
            Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent2, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==REQUEST_IMAGE_CAPTURE &&resultCode ==RESULT_OK)
    {
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        imageView.setImageBitmap(imageBitmap);
    }
}
    }
