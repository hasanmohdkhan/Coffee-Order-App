package com.example.hasanzian.justjava;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(quantity * 5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }
    }

    public void increment(View view) {
        if (quantity >= 1) {
            quantity += 1;
            display(quantity);
        }
    }

    public void decrement(View view) {

        if (quantity > 1) {
            quantity -= 1;
            display(quantity);
        }

    }
}