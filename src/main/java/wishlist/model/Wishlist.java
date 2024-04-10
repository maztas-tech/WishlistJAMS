package wishlist.model;

import java.util.List;

public class Wishlist {
    private String wishlistName;
    private boolean wishlistPrivate;
    private List<Wish> wishArrayList;

    public Wishlist(String wishlistName, boolean wishlistPrivate, List<Wish> wishArrayList) {
        this.wishlistName = wishlistName;
        this.wishlistPrivate = wishlistPrivate;
        this.wishArrayList = wishArrayList;
    }


    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public boolean isWishlistPrivate() {
        return wishlistPrivate;
    }

    public void setWishlistPrivate(boolean wishlistPrivate) {
        this.wishlistPrivate = wishlistPrivate;
    }

    public List<Wish> getWishArrayList() {
        return wishArrayList;
    }

    public void setWishArrayList(List<Wish> wishArrayList) {
        this.wishArrayList = wishArrayList;
    }
}
