package com.example.hasanzian.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.hasanzian.justjava.dataModel.CatalogListModel;
import com.example.hasanzian.justjava.utils.Adaptor;

import java.util.ArrayList;

public class CatalogueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        ArrayList<CatalogListModel> list = new ArrayList<>();
        list.add(new CatalogListModel(R.drawable.cup_with_cream, "Coffee"));
        list.add(new CatalogListModel(R.drawable.cup_with_smoke, "Cold Coffee"));
        list.add(new CatalogListModel(R.drawable.glass_hot_smoke, "Shake"));
        list.add(new CatalogListModel(R.drawable.glass_sake, "Latte"));
        GridView gridView = findViewById(R.id.grid_view);
        Adaptor mAdaptor = new Adaptor(this, list);
        gridView.setAdapter(mAdaptor);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CoffeeTypesCategory.class);
                startActivity(intent);
            }
        });

    }
}
