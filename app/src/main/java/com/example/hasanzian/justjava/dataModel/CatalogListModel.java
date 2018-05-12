package com.example.hasanzian.justjava.dataModel;

/**
 * Created by hasanZian on 05-05-2018.
 */

public class CatalogListModel {
    private int mIcon;
    private String mCategoryName;
    private  String mWiki;

    public CatalogListModel(int mIcon, String mCategoryName , String mWiki) {
        this.mIcon = mIcon;
        this.mCategoryName = mCategoryName;
        this.mWiki = mWiki;
    }

    public CatalogListModel(int mIcon, String mCategoryName) {
        this.mIcon = mIcon;
        this.mCategoryName = mCategoryName;
    }

    public int getmIcon() {
        return mIcon;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }

    public String getmWiki() {
        return mWiki;
    }
}
