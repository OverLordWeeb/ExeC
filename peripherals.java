package com.example.execomputers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class peripherals extends AppCompatActivity {

    private final ArrayList<String> basketItems = new ArrayList<>(); // Declare and initialize basketItems
    private final ArrayList<Integer> quantities = new ArrayList<>(); // Declare and initialize quantities

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peripherals);

        button1 = findViewById(R.id.button_1id);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(peripherals.this, PcOptions.class);
                // Pass the basket items and quantities to PcOptions
                intent.putStringArrayListExtra("basketItems", basketItems);
                intent.putIntegerArrayListExtra("quantities", quantities);
                startActivity(intent);
            }
        });
    }
}