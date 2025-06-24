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
                sortByPriority();
                break;
            case "price":
                Collections.sort(wishItemList);
                break;
            case "cathegory":
                sortByCathegory();
                break;
            case "date":
                sortByDate();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void sortByPriority(){
        Collections.sort(wishItemList, (item1, item2) -> {
            if (item1.getPriority() != item2.getPriority()){
                return Integer.compare(item2.getPriority(), item1.getPriority());
            } else {
                return item1.compareTo(item2);
            }
        });
    }

    public void sortByCathegory(){
        Collections.sort(wishItemList, (item1, item2) -> {
            if (item1.getCathegory().compareTo(item2.getCathegory()) == 0){
                return item1.getCathegory().compareTo(item2.getCathegory());
            } else {
                return item1.compareTo(item2);
            }
        });
    }

    public void sortByDate(){
        Collections.sort(wishItemList, (item1, item2) -> {
            if (!item1.getDate().isEqual(item2.getDate())){
                return item1.getDate().isAfter(item2.getDate()) ? 1 : item1.getDate().isEqual(item2.getDate()) ? 0 : -1;
            } else {
                return item1.compareTo(item2);
            }
        });
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
