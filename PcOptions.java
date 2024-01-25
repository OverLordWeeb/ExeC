package com.example.execomputers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PcOptions extends AppCompatActivity {

    private ArrayList<String> basketItems = new ArrayList<>();
    private ArrayList<Integer> quantities = new ArrayList<>();
    private int totalPrice = 0;

    // Define item prices
    // Can add more easily
    private static final int PREBUILT_BEAST_PRICE = 2000;
    private static final int SILENT_TIGER_PRICE = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc_options);

        // Button to go to basket
        Button viewBasketButton = findViewById(R.id.button_view_basket);
        viewBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent basketIntent = new Intent(PcOptions.this, Basket.class);
                basketIntent.putStringArrayListExtra("basketItems", basketItems);
                basketIntent.putIntegerArrayListExtra("quantities", quantities);
                basketIntent.putExtra("totalPrice", totalPrice);
                startActivity(basketIntent);
            }
        });

        // Button to go to peripherals
        Button buttonPeripherals = findViewById(R.id.button_peripherals);
        buttonPeripherals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent peripheralsIntent = new Intent(PcOptions.this, peripherals.class);
                peripheralsIntent.putStringArrayListExtra("basketItems", basketItems);
                peripheralsIntent.putIntegerArrayListExtra("quantities", quantities);
                peripheralsIntent.putExtra("totalPrice", totalPrice);
                startActivity(peripheralsIntent);
            }
        });
    }


    public void addToCart(View view) {
        Button clickedButton = (Button) view;
        String itemName = clickedButton.getText().toString();
        int itemPrice = getItemPrice(itemName);

        // Check if the item is already in the basket
        if (basketItems.contains(itemName)) {
            // If yes, increment the quantity, update the total price, and display a message
            int index = basketItems.indexOf(itemName);
            int quantity = quantities.get(index);
            quantities.set(index, quantity + 1);
            totalPrice += itemPrice;
        } else {

            basketItems.add(itemName);
            quantities.add(1);
            totalPrice += itemPrice;
        }

        // Display a message saying item has been added
        showMessage("Added to Shopping: " + itemName);

        updateTotalPriceInUI();
    }

    private int getItemPrice(String itemName) {
        if ("Pre-built Beast PC".equals(itemName)) {
            return PREBUILT_BEAST_PRICE;
        } else if ("Silent Tiger PC".equals(itemName)) {
            return SILENT_TIGER_PRICE;
        }
        // can add more items and their prices if needed
        return 0; // Default to 0 if no items added
    }

    private void showMessage(String message) {

    }

    private void updateTotalPriceInUI() {
    }
}
