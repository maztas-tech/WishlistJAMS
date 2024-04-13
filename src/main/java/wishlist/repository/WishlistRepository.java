package wishlist.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import wishlist.model.Wish;
import wishlist.model.Wishlist;
import wishlist.repository.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WishlistRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_user;
    @Value("${spring.datasource.password}")
    private String db_pwd;
    private Wish wish;
    private Wishlist wishlist;
    public List<Wishlist> showAllWishlists() {
        List<Wishlist> wishlists = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd)) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT wishListName, isWishListPrivate FROM wishlist";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                wishlist = new Wishlist(
                        rs.getString(1),
                        rs.getInt(2)
                );
                wishlists.add(wishlist);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wishlists;
    }

    public List<Wish> showWishes(String wishName) {
        List<Wish> items = new ArrayList<>();
        String sql = "SELECT * FROM wishlist JOIN wish ON wishlist.wishListID = wish.wishListID WHERE wishlist.wishListName = ?";
        try(Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, wishName);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                wish = new Wish(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                items.add(wish);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return items;
    }


}
