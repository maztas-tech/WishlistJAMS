package wishlist;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import wishlist.controller.WishlistController;
import wishlist.model.Wishlist;
import wishlist.repository.WishlistRepository;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("{dev}")
class WishlistApplicationTests {


    @Autowired
    WishlistRepository wishlistRepository;

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String db_user;

    @Value("${spring.datasource.password}")
    private String db_pwd;
    ;

    @Test
    void deleteTest() {
        int startSize = wishlistRepository.showAllWishlists().size();
        wishlistRepository.deleteWishlist(1);
        int expectetSize = startSize - 1;
        int actualSize = wishlistRepository.showAllWishlists().size();
        assertEquals(expectetSize, actualSize);
    }
}
