package com.example.hasanzian.justjava;

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
        int   price =  calculatePrice(quantity , 10);
        String priceMessage = createOrderSummary(quantity ,price);
        displayMessage(priceMessage);
     }

    private String createOrderSummary(int quantity, int price) {
        return "Name: Hasan Khan \n" +"Quantity: "+quantity +"\n" + "Total: \u20B9 "+price+"\n"+ "Thank You !" ;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        if (quantity >= 1) {
            quantity += 1;
            displayQuantity(quantity);
        }
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity -= 1;
            displayQuantity(quantity);
        }

    }

    /**
     * Calculates the price of the order.
     *  @param quantity is the number of cups of coffee ordered
     * @param pricePerCup
     * @return price
     */
    private int calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
        return price;
    }

}