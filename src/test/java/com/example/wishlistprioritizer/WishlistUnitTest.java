package com.example.wishlistprioritizer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WishlistUnitTest {
    Wishlist wishlist;

    public WishlistUnitTest() {
        this.wishlist = new Wishlist();
    }

    @BeforeEach
    void setUp(){
        WishItem wi1 = new WishItem("Computer", 5000.6, 8, "RTV/AGD");
        WishItem wi2 = new WishItem("Dress", 150.0, 3, "Clothing");
        WishItem wi3 = new WishItem("Socks", 30.0, 6, "Clothing");
        WishItem wi4 = new WishItem("Perfume", 150.5, 4, "Health & Beauty");
        WishItem wi5 = new WishItem("Notebook", 1.5, 3, "Paper Products");

        LocalDate date1 = LocalDate.of(2025, 6, 20);
        LocalDate date2 = LocalDate.of(2025, 6, 20);
        LocalDate date3 = LocalDate.of(2025, 6, 18);

        wi2.setDate(date1);
        wi3.setDate(date3);
        wi5.setDate(date2);

        wishlist.addWishItem(wi1);
        wishlist.addWishItem(wi2);
        wishlist.addWishItem(wi3);
        wishlist.addWishItem(wi4);
        wishlist.addWishItem(wi5);
    }

    @Test
    void shouldAddToListOrderedByPriorityAndCost(){
        List<WishItem> wishItemList = this.wishlist.getWishItemList();

        assertEquals("Computer", wishItemList.getFirst().getName());
        assertEquals("Socks", wishItemList.get(1).getName());
        assertEquals("Perfume", wishItemList.get(2).getName());
        assertEquals("Notebook", wishItemList.get(3).getName());
        assertEquals("Dress", wishItemList.get(4).getName());
    }

    @Test
    public void shouldAddToListOrderedByPrice(){

    }
}
