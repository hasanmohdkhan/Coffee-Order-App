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

        timeLineList.add(new CatalogListModel(getString(R.string.timeline_date_one), getString(R.string.timeline_status_one)));
        timeLineList.add(new CatalogListModel(getString(R.string.timeline_date_two), getString(R.string.timeline_status_two)));
        timeLineList.add(new CatalogListModel(getString(R.string.timeline_date_three), getString(R.string.timeline_status_three)));
        timeLineList.add(new CatalogListModel(getString(R.string.timeline_date_four), getString(R.string.timeline_status_four)));
        ListView timeLineListView = findViewById(R.id.time_line_list);
        TimeLineAdaptor timeLineAdaptor = new TimeLineAdaptor(this, timeLineList);
        timeLineListView.setAdapter(timeLineAdaptor);


    }


}
