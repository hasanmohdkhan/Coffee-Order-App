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

public class CoffeeTypesCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        final ArrayList<CatalogListModel> list = new ArrayList<>();
        list.add(new CatalogListModel(R.drawable.espresso,getString(R.string.espresso_string) , getString(R.string.esspresso_wiki)));
        list.add(new CatalogListModel(R.drawable.doppio,getString(R.string.doppio_string),getString(R.string.caffa_doppia_wiki)));
        list.add(new CatalogListModel(R.drawable.deca_cafe,getString(R.string.decaffeinato_string),getString(R.string.decaffeinato_wiki)));
        list.add(new CatalogListModel(R.drawable.ristretto,getString(R.string.ristretto_string) ,getString(R.string.caffe_ristretto_wiki)));
        list.add(new CatalogListModel(R.drawable.affelatte,getString(R.string.caffellatte_string),getString(R.string.latte_maccjiato_wiki)));
        list.add(new CatalogListModel(R.drawable.atte_macchiato,getString(R.string.latte_macchiato_string),getString(R.string.latte_macchiato_wiki)));
        list.add(new CatalogListModel(R.drawable.ginseng,getString(R.string.ginseng_string),getString(R.string.caffe_al_ginseng_wiki)));
        list.add(new CatalogListModel(R.drawable.mocaccino,getString(R.string.mocaccino_string),getString(R.string.macaccino_wiki)));
        list.add(new CatalogListModel(R.drawable.cappuccino,getString(R.string.cappuccino_string),getString(R.string.cappuccino_wiki)));
        list.add(new CatalogListModel(R.drawable.shakerato,getString(R.string.caffé_shakerato_string),getString(R.string.caffe_shakerato_wiki)));
        GridView gridView = findViewById(R.id.grid_view);
        gridView.setBackgroundColor(getResources().getColor(R.color.coffeeColor));
        final Adaptor mAdaptor = new Adaptor(this,list);
        gridView.setNumColumns(2);
        gridView.setAdapter(mAdaptor);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Bundle bundle = new Bundle();
                String name = String.valueOf(mAdaptor.getItem(position).getmCategoryName());
                String wiki = String.valueOf(mAdaptor.getItem(position).getmWiki());
                int iconId = mAdaptor.getItem(position).getmIcon();
                bundle.putString("Name" , name);
                bundle.putInt("Icon",iconId);
                bundle.putString("Wiki",wiki);
                Intent intent = new Intent(getApplicationContext(), CoffeeDetails.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}
