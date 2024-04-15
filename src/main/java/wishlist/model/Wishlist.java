package wishlist.model;

import java.util.List;

public class Wishlist {
    private int wishlistID;
    private String wishlistName;
    private int wishlistPrivate;
    private List<Wish> wishArrayList;

    public Wishlist(String wishlistName, int wishlistPrivate, List<Wish> wishArrayList) {
        this.wishlistName = wishlistName;
        this.wishlistPrivate = wishlistPrivate;
        this.wishArrayList = wishArrayList;
    }

    public Wishlist(int wishlistNo, String wishlistName, int wishlistPrivate) {
        this.wishlistID = wishlistNo;
        this.wishlistName = wishlistName;
        this.wishlistPrivate = wishlistPrivate;
    }


    public int getWishlistID() {
        return wishlistID;
    }
    public void setWishlistID(int wishlistID){
        this.wishlistID = wishlistID;
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
