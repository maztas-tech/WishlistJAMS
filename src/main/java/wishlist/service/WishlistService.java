package wishlist.service;

import org.springframework.stereotype.Service;
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



}
