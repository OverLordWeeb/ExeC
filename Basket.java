package com.example.execomputers;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Basket extends AppCompatActivity {

    private ArrayList<String> basketItems;
    private ArrayList<Integer> quantities;
    private int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        // gets tge basket items/amount and price
        basketItems = getIntent().getStringArrayListExtra("basketItems");
        quantities = getIntent().getIntegerArrayListExtra("quantities");
        totalPrice = getIntent().getIntExtra("totalPrice", 0);

        // display the items in basket
        displayBasket();
    }

    private void displayBasket() {
        // Find the RecyclerView in the layout
        RecyclerView recyclerView = findViewById(R.id.recyclerViewBasket);

        BasketAdapter adapter = new BasketAdapter(this, basketItems, quantities, totalPrice);

        // sets a adapter
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
