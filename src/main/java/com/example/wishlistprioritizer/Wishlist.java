package com.example.wishlistprioritizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.time.LocalDate;

public class Wishlist {
    private List<WishItem> wishItemList = new ArrayList<>();

    public void addWishItem(WishItem wishItem){ addWishItem(wishItem, "priority");}

    public void addWishItem(WishItem wishItem, String sortingMethod){
        wishItemList.add(wishItem);

        switch (sortingMethod){
            case "priority":
                SortingMethods.sortByPriority(wishItemList);
                break;
            case "price":
                Collections.sort(wishItemList);
                break;
            case "category":
                SortingMethods.sortByCathegory(wishItemList);
                break;
            case "date":
                SortingMethods.sortByDate(wishItemList);
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting method: " + sortingMethod);
        }
    }

    @Override
    public String toString (){
        String string = "";
        for (WishItem wi : wishItemList){
            string += wi.toString() + "\n----------------------------\n";
        }

        return string;
    }

    public void showList(){
        System.out.println(this);
    }

    public List<WishItem> getWishItemList(){return this.wishItemList;}

}
