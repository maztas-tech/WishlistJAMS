package wishlist.service;

import org.springframework.stereotype.Service;
import wishlist.model.Wish;
import wishlist.model.Wishlist;
import wishlist.repository.WishlistRepository;

import java.util.List;

@Service
public class WishlistService {
    private WishlistRepository wishlistRepository;
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> showAllWIshlists(){
        return wishlistRepository.showAllWishlists();
    }
    public List<Wish> showWishes(int wishlistID){
        return wishlistRepository.showWishes(wishlistID);
    }

    public void delete(int wishlistID){
        wishlistRepository.deleteWishlist(wishlistID);
    }
    public Wishlist searchToEdit(int wishlistID) {
        return wishlistRepository.searchToEdit(wishlistID);
    }

    public void editWishlist(Wishlist wishlist) {
        wishlistRepository.editWishlist(wishlist);
    }


    public void createWishlist(Wishlist wishlist){
        wishlistRepository.createWishList(wishlist);
    }

    public void deleteWish(int wishID){
         wishlistRepository.deleteWish(wishID);
    }

    public int getListID(int wishID){
        return wishlistRepository.getListID(wishID);
    }

    public void createWish(Wish wish){
        wishlistRepository.createWish(wish);
    }

}
