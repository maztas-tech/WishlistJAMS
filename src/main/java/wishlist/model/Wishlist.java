package wishlist.model;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private String wishlistName;
    private int wishlistPrivate;
    private List<Wish> wishArrayList;

    public Wishlist(String wishlistName, int wishlistPrivate, List<Wish> wishArrayList) {
        this.wishlistName = wishlistName;
        this.wishlistPrivate = wishlistPrivate;
        this.wishArrayList = wishArrayList;
    }

    public Wishlist(String wishlistName, int wishlistPrivate) {
        this.wishlistName = wishlistName;
        this.wishlistPrivate = wishlistPrivate;
    }




    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public int isWishlistPrivate() {
        return wishlistPrivate;
    }

    public void setWishlistPrivate(int wishlistPrivate) {
        this.wishlistPrivate = wishlistPrivate;
    }

    public List<Wish> getWishArrayList() {
        return wishArrayList;
    }

    public void setWishArrayList(List<Wish> wishArrayList) {
        this.wishArrayList = wishArrayList;
    }
}
