package com.example.hasanzian.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.hasanzian.justjava.dataModel.CatalogListModel;
import com.example.hasanzian.justjava.utils.TimeLineAdaptor;

import java.util.ArrayList;

public class TimeLineViewActivity extends AppCompatActivity {
    private ArrayList<CatalogListModel> timeLineList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line_view);

        timeLineList.add(new CatalogListModel("20 min ago", "Order Placed"));
        timeLineList.add(new CatalogListModel("18 min ago", "Order is preparing"));
        timeLineList.add(new CatalogListModel("2 min ago", "Order is ready to pickup"));
        timeLineList.add(new CatalogListModel("20 sec ago", "Please collect your order from  pickup window no: 9"));
        ListView timeLineListView = findViewById(R.id.time_line_list);
        TimeLineAdaptor timeLineAdaptor = new TimeLineAdaptor(this, timeLineList);
        timeLineListView.setAdapter(timeLineAdaptor);


    }


}
