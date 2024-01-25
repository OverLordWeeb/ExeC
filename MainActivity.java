package com.example.execomputers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList; // Import ArrayList

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> basketItems = new ArrayList<>(); // Declare and initialize basketItems
    private ArrayList<Integer> quantities = new ArrayList<>(); // Declare and initialize quantities

    Button button1;
    Button buttonInformation;
//buttons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button_1id);
        buttonInformation = findViewById(R.id.button_information);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PcOptions.class);
                // Pass the basket items and quantities to PcOptions
                intent.putStringArrayListExtra("basketItems", basketItems);
                intent.putIntegerArrayListExtra("quantities", quantities);
                startActivity(intent);
            }
        });

        buttonInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(MainActivity.this, Information_page.class);
                startActivity(infoIntent);
            }
        });
    }
}
