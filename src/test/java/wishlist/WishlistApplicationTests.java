package wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import wishlist.model.Wishlist;
import wishlist.repository.WishlistRepository;

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
    private String db_pwd;;


}
