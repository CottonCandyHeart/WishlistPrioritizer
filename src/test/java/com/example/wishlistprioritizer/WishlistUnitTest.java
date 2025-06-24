package com.example.wishlistprioritizer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WishlistUnitTest {
    Wishlist wishlist;
    List<WishItem> wishItemList;

    public WishlistUnitTest() {

        LocalDate date1 = LocalDate.of(2025, 6, 20);
        LocalDate date2 = LocalDate.of(2025, 6, 20);
        LocalDate date3 = LocalDate.of(2025, 6, 18);

        this.wishItemList = new ArrayList<>();

        wishItemList.add(new WishItem("Dress", 150.0, 3, "Clothing"));
        wishItemList.add(new WishItem("Computer", 5000.6, 8, "RTV/AGD"));
        wishItemList.add(new WishItem("Socks", 30.0, 6, "Clothing"));
        wishItemList.add(new WishItem("Perfume", 150.5, 4, "Health & Beauty"));
        wishItemList.add(new WishItem("Notebook", 1.5, 3, "Paper Products"));

        wishItemList.get(1).setDate(date1);
        wishItemList.get(2).setDate(date3);
        wishItemList.get(4).setDate(date2);

    }

    @Test
    void shouldAddToListOrderedByPriorityAndCost(){
        this.wishlist = new Wishlist();
        for (WishItem wi : this.wishItemList){
            this.wishlist.addWishItem(wi);
        }

        List<WishItem> wishItemList = this.wishlist.getWishItemList();

        assertEquals("Computer", wishItemList.getFirst().getName());
        assertEquals("Socks", wishItemList.get(1).getName());
        assertEquals("Perfume", wishItemList.get(2).getName());
        assertEquals("Notebook", wishItemList.get(3).getName());
        assertEquals("Dress", wishItemList.get(4).getName());
    }

    @Test
    void shouldAddToListOrderedByPrice(){
        this.wishlist = new Wishlist();
        for (WishItem wi : this.wishItemList){
            this.wishlist.addWishItem(wi, "price");
        }

        List<WishItem> wishItemList = this.wishlist.getWishItemList();

        assertEquals("Notebook", wishItemList.getFirst().getName());
        assertEquals("Socks", wishItemList.get(1).getName());
        assertEquals("Dress", wishItemList.get(2).getName());
        assertEquals("Perfume", wishItemList.get(3).getName());
        assertEquals("Computer", wishItemList.get(4).getName());
    }

    @Test
    void shouldAddToListOrderedByCategory(){
        this.wishlist = new Wishlist();
        for (WishItem wi : this.wishItemList){
            this.wishlist.addWishItem(wi, "category");
        }

        List<WishItem> wishItemList = this.wishlist.getWishItemList();

        assertEquals("Socks", wishItemList.getFirst().getName());
        assertEquals("Dress", wishItemList.get(1).getName());
        assertEquals("Perfume", wishItemList.get(2).getName());
        assertEquals("Notebook", wishItemList.get(3).getName());
        assertEquals("Computer", wishItemList.get(4).getName());
    }

    @Test
    void shouldAddToListOrderedByDate(){
        this.wishlist = new Wishlist();
        for (WishItem wi : this.wishItemList){
            this.wishlist.addWishItem(wi, "date");
        }

        List<WishItem> wishItemList = this.wishlist.getWishItemList();

        assertEquals("Socks", wishItemList.getFirst().getName());
        assertEquals("Notebook", wishItemList.get(1).getName());
        assertEquals("Computer", wishItemList.get(2).getName());
        assertEquals("Dress", wishItemList.get(3).getName());
        assertEquals("Perfume", wishItemList.get(4).getName());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenArgumentIsInvalid(){
        this.wishlist = new Wishlist();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, ()->{
            this.wishlist.addWishItem(this.wishItemList.getFirst(), "invalidArgument");
        });
        assertEquals("Invalid sorting method: invalidArgument", thrown.getMessage());
    }

    @Test
    void shouldPrintList(){
        this.wishlist = new Wishlist();
        this.wishlist.addWishItem(this.wishItemList.get(1));
        this.wishlist.addWishItem(this.wishItemList.get(2));

        String expected =
                "Computer\n" +
                        "RTV/AGD\n" +
                        "5000.6 PLN\n" +
                        "Priority: 8\n" +
                        "2025-06-20\n" +
                        "----------------------------\n" +
                        "Socks\n" +
                        "Clothing\n" +
                        "30.0 PLN\n" +
                        "Priority: 6\n" +
                        "2025-06-18\n" +
                        "----------------------------\n";

        assertEquals(expected, this.wishlist.toString());
    }
}
