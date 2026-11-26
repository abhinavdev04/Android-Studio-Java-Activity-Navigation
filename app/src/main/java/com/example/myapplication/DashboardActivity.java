package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView receiverTxt;
    Button btnNavBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        receiverTxt = findViewById(R.id.receiverTxt);
        btnNavBack = findViewById(R.id.btnNavBack);

        Intent i = getIntent();

        String email = i.getStringExtra("email");
        String name = i.getStringExtra("name");
        String location = i.getStringExtra("location");

        receiverTxt.setText(
                "Email: " + email +
                        "\nName: " + name +
                        "\nLocation: " + location
        );

        btnNavBack.setOnClickListener(v -> {

            Intent resultIntent = new Intent();

            resultIntent.putExtra(
                    "message",
                    "Data received back from Dashboard!"
            );

            setResult(RESULT_OK, resultIntent);

            finish();

        });
    }
}
