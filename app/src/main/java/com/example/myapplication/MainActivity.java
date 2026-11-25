
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etName, etLocation;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etName = findViewById(R.id.etName);
        etLocation = findViewById(R.id.etLocation);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {

            Intent i = new Intent(
                    MainActivity.this,
                    DashboardActivity.class
            );

            i.putExtra("email", etEmail.getText().toString());
            i.putExtra("name", etName.getText().toString());
            i.putExtra("location", etLocation.getText().toString());

            startActivity(i);

        });
    }
}
