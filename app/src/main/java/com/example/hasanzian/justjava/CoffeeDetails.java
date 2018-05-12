package com.example.hasanzian.justjava;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CoffeeDetails extends AppCompatActivity implements View.OnClickListener {

    TextView fullCreamMilk, skimmedMilk, soyMilk;
    TextView noSyrup, vanillaSyrup, chocolateSyrup, priceText, productWiki, addToCart, productName, sizeSmall, sizMedium, sizeLarge;
    int priceOfOneCup = 5, quantity = 1, iconId;
    Button plusBtn, minusBtn;
    ImageView productIcon;
    String nameOfProduct, wiki, selectedOptionsforCoffee = "", selectedOptionForMilk = "", selectOptionforSyrup = "";
    String orderSummary;
    private LinearLayout smallPriceCard, mediumPriceCard, largePriceCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_details);

        Bundle bundleExtras = getIntent().getExtras();
        if (bundleExtras != null) {
            nameOfProduct = bundleExtras.getString("Name");
            iconId = bundleExtras.getInt("Icon");
            wiki = bundleExtras.getString("Wiki");

            productName = findViewById(R.id.product_name);
            productIcon = findViewById(R.id.product_image);
            productWiki = findViewById(R.id.product_wiki);


            productIcon.setImageResource(iconId);
            productName.setText(nameOfProduct);
            productWiki.setText(wiki);
        }
        sizeSmall = findViewById(R.id.siz_small);
        sizMedium = findViewById(R.id.size_medium);
        sizeLarge = findViewById(R.id.size_large);


        addToCart = findViewById(R.id.add_item_to_cart);
        smallPriceCard = findViewById(R.id.small_price_card);
        mediumPriceCard = findViewById(R.id.medium_price_card);
        largePriceCard = findViewById(R.id.large_price_card);

        fullCreamMilk = findViewById(R.id.full_cream_card_switch);
        skimmedMilk = findViewById(R.id.skimmed_cream_card_switch);
        soyMilk = findViewById(R.id.soy_card_switch);

        noSyrup = findViewById(R.id.no_syrup_switch_card);
        vanillaSyrup = findViewById(R.id.vanilla_switch_card);
        chocolateSyrup = findViewById(R.id.chocolate_switch_card);

        priceText = findViewById(R.id.price_total);
        plusBtn = findViewById(R.id.button_increment);
        minusBtn = findViewById(R.id.button_decrement);


        fullCreamMilk.setOnClickListener(this);
        skimmedMilk.setOnClickListener(this);
        soyMilk.setOnClickListener(this);

        smallPriceCard.setOnClickListener(this);
        mediumPriceCard.setOnClickListener(this);
        largePriceCard.setOnClickListener(this);

        noSyrup.setOnClickListener(this);
        vanillaSyrup.setOnClickListener(this);
        chocolateSyrup.setOnClickListener(this);

        plusBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);


        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start new activity
                Bundle bundle = new Bundle();

                String name = productName.getText().toString();
                String totalOrderPrice = priceText.getText().toString();
                if (selectOptionforSyrup.isEmpty() && selectedOptionForMilk.isEmpty() && selectedOptionsforCoffee.isEmpty()) {
                    orderSummary = "";
                } else {
                    orderSummary = selectedOptionsforCoffee + "," + selectedOptionForMilk + "," + selectOptionforSyrup;
                }
                bundle.putString("Name", name);
                bundle.putString("Summary", orderSummary);
                productIcon.buildDrawingCache();
                Bitmap bitmap = productIcon.getDrawingCache();


                bundle.putString("Total", totalOrderPrice);
                Intent intent = new Intent(getApplicationContext(), OrderListActivity.class);
                intent.putExtras(bundle);
                intent.putExtra("data", bitmap);
                startActivity(intent);

                // bundle detials
                //send to nxt
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == smallPriceCard) {
            smallPriceCard.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
            mediumPriceCard.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            largePriceCard.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            selectedOptionsforCoffee = "";
            selectedOptionsforCoffee = sizeSmall.getText().toString();
            priceOfOneCup = 5;
            updatePrice(priceOfOneCup, quantity);
        }
        if (view == mediumPriceCard) {
            smallPriceCard.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            mediumPriceCard.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
            largePriceCard.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            selectedOptionsforCoffee = "";
            selectedOptionsforCoffee = sizMedium.getText().toString();
            priceOfOneCup = 10;
            updatePrice(priceOfOneCup, quantity);
        }
        if (view == largePriceCard) {
            smallPriceCard.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            mediumPriceCard.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            largePriceCard.setBackgroundColor(getResources().getColor(R.color.coffeeColor));

            selectedOptionsforCoffee = "";
            selectedOptionsforCoffee = sizeLarge.getText().toString();

            priceOfOneCup = 15;
            updatePrice(priceOfOneCup, quantity);
        }
        if (view == fullCreamMilk) {
            fullCreamMilk.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
            skimmedMilk.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            soyMilk.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            selectedOptionForMilk = "";
            selectedOptionForMilk = fullCreamMilk.getText().toString();
        }
        if (view == skimmedMilk) {
            fullCreamMilk.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            skimmedMilk.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
            soyMilk.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            selectedOptionForMilk = "";
            selectedOptionForMilk = skimmedMilk.getText().toString();

        }
        if (view == soyMilk) {
            fullCreamMilk.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            skimmedMilk.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            soyMilk.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
            selectedOptionForMilk = "";
            selectedOptionForMilk = soyMilk.getText().toString();
        }

        if (view == noSyrup) {
            noSyrup.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
            vanillaSyrup.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            chocolateSyrup.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            selectOptionforSyrup = "";
            selectOptionforSyrup = noSyrup.getText().toString();
        }
        if (view == vanillaSyrup) {
            noSyrup.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            vanillaSyrup.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
            chocolateSyrup.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            selectOptionforSyrup = "";
            selectOptionforSyrup = vanillaSyrup.getText().toString();
        }
        if (view == chocolateSyrup) {
            noSyrup.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            vanillaSyrup.setBackgroundColor(getResources().getColor(R.color.whiteColor));
            chocolateSyrup.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
            selectOptionforSyrup = "";
            selectOptionforSyrup = chocolateSyrup.getText().toString();
        }

        if (view == plusBtn) {
            if (quantity >= 1) {
                quantity += 1;
                displayQuantity(quantity);
                updatePrice(priceOfOneCup, quantity);
            }
        }
        if (view == minusBtn) {
            if (quantity > 1) {
                quantity -= 1;
                displayQuantity(quantity);
                updatePrice(priceOfOneCup, quantity);
            }
        }

    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void updatePrice(int priceOfOneCup, int quantity) {
        priceOfOneCup = calculatePrice(priceOfOneCup, quantity);
        priceText.setText("\u20B9 " + String.valueOf(priceOfOneCup));

    }

    private int calculatePrice(int priceOfOneCup, int quantity) {
        int total;
        total = priceOfOneCup * quantity;
        return total;
    }
}
