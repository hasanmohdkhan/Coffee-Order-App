package com.example.hasanzian.justjava.dataModel;

import android.graphics.Bitmap;

/**
 * Created by hasanZian on 05-05-2018.
 */

public class CatalogListModel {
    private int mIcon;
    private String mCategoryName;
    private  String mWiki;
    private Bitmap mBitmap;
    private  String mTotal;

    public CatalogListModel(int mIcon, String mCategoryName , String mWiki) {
        this.mIcon = mIcon;
        this.mCategoryName = mCategoryName;
        this.mWiki = mWiki;
    }

    public CatalogListModel(int mIcon, String mCategoryName) {
        this.mIcon = mIcon;
        this.mCategoryName = mCategoryName;
    }

    public CatalogListModel(Bitmap mBitmap, String mCategoryName, String mWiki,String mTotal) {
        this.mCategoryName = mCategoryName;
        this.mWiki = mWiki;
        this.mBitmap = mBitmap;
        this.mTotal = mTotal;
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

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public String getmTotal() {
        return mTotal;
    }
}
