package com.example.android.paloaltotour;

import android.content.Context;

import java.util.ArrayList;

// It saves information about the item list.
public class itemUnitCollection {

    public int[] placesImages = {
            R.drawable.stanford_image,
            R.drawable.paloalto_downtown_image,
            R.drawable.children_library_image,
            R.drawable.juniormuseum_image,
            R.drawable.cantor_image,
            R.drawable.stanford_shopping_center,
            R.drawable.paloalto_thetre_image
    };

    public int[] transportationImages = {
            R.drawable.caltrain,
            R.drawable.samtrans,
            R.drawable.marguerite,
            R.drawable.uber
    };

    public int[] foodsImages = {
            R.drawable.thecounter,
            R.drawable.paloaltopizza,
            R.drawable.bucca,
            R.drawable.parisbarguette,
            R.drawable.sogongdong,
            R.drawable.jinsho,
            R.drawable.joani,
            R.drawable.truefood,
            R.drawable.cfk,
            R.drawable.fishmarket
    };

    public int[] lodginsImages = {
            R.drawable.creekside,
            R.drawable.thewestin,
            R.drawable.sheraton,
            R.drawable.terraceinn,
            R.drawable.homewood,
            R.drawable.airbnb
    };

    public static itemUnitCollection instance = null;
    public Context context;

    ArrayList<listItemUnit> itemList = new ArrayList<listItemUnit>();

    public static itemUnitCollection getInstance() {
        if (instance == null) {
            instance = new itemUnitCollection();
        }
        return (instance);
    }

    public void addItem(listItemUnit item) {
        itemList.add(item);
    }

    public listItemUnit getItemUnit(String _itemName) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemName().compareTo(_itemName) == 0) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public int getItemIndex(String _itemName) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemName().compareTo(_itemName) == 0) {
                return i;
            }
        }
        return 0;
    }

    public int getCategoryIndex(String _itemName) {
        String re_category_name = "";
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemName().compareTo(_itemName) == 0) {
                re_category_name = itemList.get(i).getCategoryName();
                break;
            }
        }
        if (re_category_name.compareTo("Places") == 0) {
            return 0;
        } else if (re_category_name.compareTo("Transportations") == 0) {
            return 1;
        } else if (re_category_name.compareTo("Foods") == 0) {
            return 2;
        } else {
            return 3;
        }
    }

    public int getBackgroundColorWithName(String itemName) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemName().compareTo(itemName) == 0) {
                if (itemList.get(i).getCategoryName().compareTo("Places") == 0) {
                    return R.color.category_main_places;
                } else if (itemList.get(i).getCategoryName().compareTo("Transportations") == 0) {
                    return R.color.category_main_trasportations;
                } else if (itemList.get(i).getCategoryName().compareTo("Foods") == 0) {
                    return R.color.category_main_foods;
                } else {
                    return R.color.category_main_lodgings;
                }
            }
        }
        return R.color.category_main_places;
    }

    public int getItemImage(String cName, int cIndex) {
        if (cName.compareTo("Places") == 0) {
            return placesImages[cIndex];
        } else if (cName.compareTo("Transportations") == 0) {
            return transportationImages[cIndex];
        } else if (cName.compareTo("Foods") == 0) {
            return foodsImages[cIndex];
        } else {
            return lodginsImages[cIndex];
        }

    }

}

