package com.example.execomputers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> basketItems;
    private ArrayList<Integer> quantities;
    private int totalPrice;

    public BasketAdapter(Context context, ArrayList<String> basketItems, ArrayList<Integer> quantities, int totalPrice) {
        this.context = context;
        this.basketItems = basketItems;
        this.quantities = quantities;
        this.totalPrice = totalPrice;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.basket_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = basketItems.get(position);
        int quantity = quantities.get(position);

        holder.itemNameTextView.setText(item);
        holder.quantityTextView.setText("Quantity: " + quantity);

        // Display the total price for each item (quantity * price)
        int itemPrice = getItemPrice(item);
        int totalItemPrice = quantity * itemPrice;
        holder.totalPriceTextView.setText("Total Price: £" + totalItemPrice);
    }

    @Override
    public int getItemCount() {
        return basketItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;
        TextView quantityTextView;
        TextView totalPriceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.textViewItemName);
            quantityTextView = itemView.findViewById(R.id.textViewQuantity);
            totalPriceTextView = itemView.findViewById(R.id.textViewTotalPrice);
        }
    }

    private int getItemPrice(String itemName) {
        // Implement this method to return the price for each item
        // You can add more items and their prices as needed
        if ("Pre-built Beast PC".equals(itemName)) {
            return 2000;
        } else if ("Silent Tiger PC".equals(itemName)) {
            return 1200;
        }
        // Default to 0 if the item is not found
        return 0;
    }
}
