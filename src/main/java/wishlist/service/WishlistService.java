package wishlist.service;

import org.springframework.stereotype.Service;
import wishlist.model.Wishlist;
import wishlist.repository.WishlistRepository;

@Service
public class WishlistService {
    private WishlistRepository wishlistRepository;
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }




}
