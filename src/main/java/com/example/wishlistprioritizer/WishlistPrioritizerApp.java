package com.example.wishlistprioritizer;

public class WishlistPrioritizerApp {
    public static void main(String[] args) {
        WishItem wi1 = new WishItem("Computer", 5000.6, 8, "RTV/AGD");
        WishItem wi2 = new WishItem("Dress", 150.0, 3, "Clothing");
        WishItem wi3 = new WishItem("Socks", 30.0, 6, "Clothing");
        WishItem wi4 = new WishItem("Perfume", 150.5, 4, "Health & Beauty");
        WishItem wi5 = new WishItem("Notebook", 1.5, 3, "Paper Products");

        Wishlist wishlist = new Wishlist();
        wishlist.addWishItem(wi1);
        wishlist.addWishItem(wi2);
        wishlist.addWishItem(wi3);
        wishlist.addWishItem(wi4);
        wishlist.addWishItem(wi5);

        wishlist.showList();

    }
}
