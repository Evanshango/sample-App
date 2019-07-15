package com.evans.app.models;

public class Books {

    private String mTitle, mCategory, mDescription;
    private int mThumbnail;

    public Books() {
    }

    public Books(String title, String category, String description, int thumbnail) {
        mTitle = title;
        mCategory = category;
        mDescription = description;
        mThumbnail = thumbnail;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        mThumbnail = thumbnail;
    }
}
