package com.example.hasanzian.justjava;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hasanzian.justjava.dataModel.CatalogListModel;
import com.example.hasanzian.justjava.utils.CartAdaptor;

import java.util.ArrayList;

public class OrderListActivity extends AppCompatActivity {
    public static ArrayList<CatalogListModel> OrderItem = new ArrayList<>();
    String  nameOfProduct;
    Bitmap bitmap;
    String summary;
    String total;
    ListView cartListView;
    CartAdaptor mCartAdaptor;
    static int  sum = 0;
    Number number = null;


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

        }
        TextView confirmOrder = findViewById(R.id.order_item_confirm);

        sum += Integer.parseInt(total.replaceAll("\u20B9","").trim());
        OrderItem.add(new CatalogListModel(bitmap , nameOfProduct ,summary ,total));
        cartListView = findViewById(R.id.order_cart_list_view);
        mCartAdaptor  = new CartAdaptor(this,OrderItem);
        cartListView.setAdapter(mCartAdaptor);
        mCartAdaptor.notifyDataSetChanged();

        confirmOrder.setText("Order"+"(\u20B9 "+sum+")");

        Log.d("list" , ""+OrderItem.size());

       confirmOrder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext() , TimeLineViewActivity.class);
               startActivity(intent);
               finish();

           }
       });

    }
}
