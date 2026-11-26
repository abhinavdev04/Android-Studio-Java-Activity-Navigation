
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
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

            startActivityForResult(i, 2);

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK) {

            if (data != null) {

                String returnedData = data.getStringExtra("returnedData");

                Toast.makeText(
                        this,
                        "From Dashboard: " + returnedData,
                        Toast.LENGTH_LONG
                ).show();

            }
        }
    }
}
