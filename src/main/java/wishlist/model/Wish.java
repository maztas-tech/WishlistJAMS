package wishlist.model;

public class Wish {
    private int wishID;
    private String wishName;
    private String wishDescription;
    private double wishPrice;
    private int wishlistID;

    public Wish(String wishName, String wishDescription, double wishPrice) {
        this.wishName = wishName;
        this.wishDescription = wishDescription;
        this.wishPrice = wishPrice;
    }
    public Wish(int wishID, String wishName, String wishDescription, double wishPrice) {
        this.wishID = wishID;
        this.wishName = wishName;
        this.wishDescription = wishDescription;
        this.wishPrice = wishPrice;
    }

    public Wish(int wishID,String wishName, String wishDescription, double wishPrice, int wishlistID) {
        this.wishID = wishID;
        this.wishName = wishName;
        this.wishDescription = wishDescription;
        this.wishPrice = wishPrice;
        this.wishlistID = wishlistID;
    }

    public Wish(){

    }

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }


    public int getWishID(){
        return wishID;
    }

    public void setWishID(int wishID){
        this.wishID = wishID;
    }
    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }

    public String getWishDescription() {
        return wishDescription;
    }

    public void setWishDescription(String wishDescription) {
        this.wishDescription = wishDescription;
    }

    public double getWishPrice() {
        return wishPrice;
    }

    public void setWishPrice(double wishPrice) {
        this.wishPrice = wishPrice;
    }

}
