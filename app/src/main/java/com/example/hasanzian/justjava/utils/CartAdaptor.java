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
 * Created by hasanZian on 12-05-2018.
 */

public class CartAdaptor extends ArrayAdapter<CatalogListModel>{

    public CartAdaptor(@NonNull Context context, @NonNull List<CatalogListModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cart_list_item, parent, false);
        }

        CatalogListModel currentPostion = getItem(position);
        ImageView imageView = listItemView.findViewById(R.id.ordered_item_icon);
        imageView.setImageBitmap(currentPostion.getmBitmap());
        TextView textView = listItemView.findViewById(R.id.text_order);
        textView.setText(currentPostion.getmCategoryName());

        TextView summaryCurrentItem = listItemView.findViewById(R.id.text_order_summary);
        summaryCurrentItem.setText(currentPostion.getmWiki());

        TextView totalCurrent = listItemView.findViewById(R.id.text_order_total);
        totalCurrent.setText(currentPostion.getmTotal());

        return listItemView;
    }


}
