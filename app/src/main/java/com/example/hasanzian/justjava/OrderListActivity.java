package com.example.hasanzian.justjava;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras != null) {
            String  nameOfProduct = bundleExtras.getString("Name");
            Bitmap bitmap = getIntent().getParcelableExtra("data");
            String total = bundleExtras.getString("Total");
            String summary = bundleExtras.getString("Summary");

            TextView textView = findViewById(R.id.text_order);
            ImageView img = findViewById(R.id.ordered_item_icon);
            TextView totalTv = findViewById(R.id.text_order_total);
            TextView summaryTv = findViewById(R.id.text_order_summary);
            summaryTv.setText(summary);
            totalTv.setText(total);
            img.setImageBitmap(bitmap);
            textView.setText(nameOfProduct);

        }
    }
}
