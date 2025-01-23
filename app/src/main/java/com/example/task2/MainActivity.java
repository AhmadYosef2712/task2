package com.example.task2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;
    private EditText n, s, p, a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        n=findViewById(R.id.name);
        s=findViewById(R.id.surName);
        p=findViewById(R.id.phone);
        a=findViewById(R.id.address);

        btn1 = findViewById(R.id.confirm);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(n.getText().toString().isEmpty() || s.getText().toString().isEmpty() || p.getText().toString().isEmpty()|| a.getText().toString().isEmpty()){
            Toast.makeText(this, "fill all fields", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "done", Toast.LENGTH_LONG).show();
            String sur = s.getText().toString();
            String phone = p.getText().toString();
            String address = a.getText().toString();
            String name = n.getText().toString();
            Intent intent = new Intent(MainActivity.this, page2.class);
            intent.putExtra("sur", sur);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);
            intent.putExtra("name", name);
            startActivity(intent);
            finish();
        }
      }
    }
