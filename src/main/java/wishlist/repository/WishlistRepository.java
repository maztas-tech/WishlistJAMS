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
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "SELECT wishListID,wishListName, isWishListPrivate FROM wishlist";
        try (Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                wishlist = new Wishlist(
                         rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                wishlists.add(wishlist);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wishlists;
    }


    public List<Wish> showWishes(int wishlistID) {
        List<Wish> items = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "SELECT wish.wishID,wish.wishName, wish.wishDescription, wish.wishPrice FROM wishlist JOIN wish ON wishlist.wishListID = wish.wishListID WHERE wishlist.wishListID = ?";
        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, wishlistID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                wish = new Wish(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                items.add(wish);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return items;
    }


}
