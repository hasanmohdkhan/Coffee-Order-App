package com.example.hasanzian.justjava.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hasanzian.justjava.R;
import com.example.hasanzian.justjava.dataModel.CatalogListModel;

import java.util.List;

/**
 * Created by hasanZian on 05-05-2018.
 */

public class Adaptor extends ArrayAdapter<CatalogListModel> {

    public Adaptor(@NonNull Context context, @NonNull List<CatalogListModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.catalog_row_item, parent, false);
        }

        CatalogListModel currentPostion = getItem(position);
        ImageView imageView = listItemView.findViewById(R.id.icon_catalog);
        imageView.setImageResource(currentPostion.getmIcon());
        TextView textView = listItemView.findViewById(R.id.title_catalog);
        textView.setText(currentPostion.getmCategoryName());


        return listItemView;
    }
}