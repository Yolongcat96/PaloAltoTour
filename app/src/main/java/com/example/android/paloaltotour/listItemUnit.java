package com.example.android.paloaltotour;

import android.widget.ImageView;

public class listItemUnit {

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private String categoryName;
    private int itemIndex;
    private String itemName;
    private String itemAddress;
    private String itemSiteAddress;
    private String itemCallNumber;
    private String itemDetails;

    private boolean isFavorite;
    private ImageView thumbnailIV;
    private ImageView mainIV;

    public void listItemUnit(String _categoryName, int _itemIndex, String _itemName, String _itemAddress, String _itemSiteAddress, String _itemCallNumber, Boolean mIsFavorite, String _itemDetails, ImageView _thumnailIV, ImageView _mainIV, int imageResourceId) {
        this.categoryName = _categoryName;
        this.itemIndex = _itemIndex;
        this.itemName = _itemName;
        this.itemAddress = _itemAddress;
        this.itemSiteAddress = _itemSiteAddress;
        this.itemCallNumber = _itemCallNumber;
        this.itemDetails = _itemDetails;
        this.thumbnailIV = _thumnailIV;
        this.isFavorite = mIsFavorite;
        this.mainIV = _mainIV;
        this.mImageResourceId = imageResourceId;
    }

    // all functions to get private variables
    public String getCategoryName() {
        return categoryName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public String getItemAddress() {
        return itemAddress;
    }

    public String getItemSiteAddress() {
        return itemSiteAddress;
    }

    public String getItemCallNumber() {
        return itemCallNumber;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean _isFavorite) {
        isFavorite = _isFavorite;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int id) {
        this.mImageResourceId = id;
    }

}
