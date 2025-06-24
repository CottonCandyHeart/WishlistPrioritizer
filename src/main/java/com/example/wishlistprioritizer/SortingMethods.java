package com.example.wishlistprioritizer;

import java.util.Collections;
import java.util.List;

public class SortingMethods {
    public static List<WishItem> sortByPriority(List<WishItem> wishItemList){
        Collections.sort(wishItemList, (item1, item2) -> {
            if (item1.getPriority() != item2.getPriority()){
                return Integer.compare(item2.getPriority(), item1.getPriority());
            } else {
                return item1.compareTo(item2);
            }
        });

        return wishItemList;
    }

    public static List<WishItem> sortByCathegory(List<WishItem> wishItemList){
        Collections.sort(wishItemList, (item1, item2) -> {
            if (item1.getCathegory().compareTo(item2.getCathegory()) != 0){
                return item1.getCathegory().compareTo(item2.getCathegory());
            } else {
                return item1.compareTo(item2);
            }
        });

        return wishItemList;
    }

    public static List<WishItem> sortByDate(List<WishItem> wishItemList){
        Collections.sort(wishItemList, (item1, item2) -> {
            if (!item1.getDate().isEqual(item2.getDate())){
                return item1.getDate().isAfter(item2.getDate()) ? 1 : -1;
            } else {
                return item1.compareTo(item2);
            }
        });

        return wishItemList;
    }
}
