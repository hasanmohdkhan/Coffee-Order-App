package com.example.hasanzian.justjava;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.hasanzian.justjava.dataModel.CatalogListModel;
import com.example.hasanzian.justjava.utils.CartAdaptor;

import java.util.ArrayList;

public class OrderListActivity extends AppCompatActivity {
    public ArrayList<CatalogListModel> OrderItem;
    String  nameOfProduct;
    Bitmap bitmap;
    String summary;
    String total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        Bundle bundleExtras = getIntent().getExtras();
        if(bundleExtras != null) {
            nameOfProduct = bundleExtras.getString("Name");
            bitmap = getIntent().getParcelableExtra("data");
            total = bundleExtras.getString("Total");
            summary = bundleExtras.getString("Summary");

//            TextView textView = findViewById(R.id.text_order);
//            ImageView img = findViewById(R.id.ordered_item_icon);
//            TextView totalTv = findViewById(R.id.text_order_total);
//            TextView summaryTv = findViewById(R.id.text_order_summary);
//            summaryTv.setText(summary);
//            totalTv.setText(total);
//            img.setImageBitmap(bitmap);
//            textView.setText(nameOfProduct);

        }

        OrderItem = new ArrayList<>();
        OrderItem.add(new CatalogListModel(bitmap , nameOfProduct ,summary ,total));
        ListView cartListView =findViewById(R.id.order_cart_list_view);
        CartAdaptor mCartAdaptor =new CartAdaptor(this,OrderItem);
        cartListView.setAdapter(mCartAdaptor);





    }
}
