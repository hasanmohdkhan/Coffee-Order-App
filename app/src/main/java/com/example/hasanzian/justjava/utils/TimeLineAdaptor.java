package com.example.hasanzian.justjava.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hasanzian.justjava.R;
import com.example.hasanzian.justjava.dataModel.CatalogListModel;

import java.util.List;

/**
 * Created by hasanZian on 12-05-2018.
 */

public class TimeLineAdaptor  extends ArrayAdapter<CatalogListModel>{

    public TimeLineAdaptor(@NonNull Context context, @NonNull List<CatalogListModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.time_line_item, parent, false);
        }

        CatalogListModel currentPostion = getItem(position);

        TextView timeLineText = listItemView.findViewById(R.id.time_line_text);
        timeLineText.setText(currentPostion.getmTimeLineCardText());
        TextView timelineDate = listItemView.findViewById(R.id.text_timeline_date);
        timelineDate.setText(currentPostion.getmTimeLineDate());

         return listItemView;
    }


}
