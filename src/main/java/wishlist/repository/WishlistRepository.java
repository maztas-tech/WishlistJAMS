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
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public void deleteWishlist(int wishlistID) {
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sqlChild = "DELETE FROM wish WHERE wishListID = ?";
        String sqlParent = "DELETE FROM wishList WHERE wishListId = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(sqlChild);
            ps.setInt(1, wishlistID);
            ps.executeUpdate();


            ps = connection.prepareStatement(sqlParent);
            ps.setInt(1, wishlistID);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Wishlist searchToEdit(int wishlistID) {
        Wishlist wishlist1 = null;
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "SELECT wishListID, wishListName, isWishListPrivate FROM wishlist WHERE wishlist.wishListID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, wishlistID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                wishlist1 = new Wishlist(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wishlist1;
    }

    public void editWishlist(Wishlist wishlist2) {
        String h2SQL = """
                UPDATE wishList SET wishListName = ?, 
                isWishListPrivate = ? 
                WHERE wishListID = ? AND EXISTS (SELECT 1 FROM wish 
                WHERE wish.wishListID = wishList.wishListID AND wish.wishListID = wishList.wishListID);
                                
                """;
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        try (PreparedStatement preparedStatement = connection.prepareStatement(h2SQL)){

            preparedStatement.setString(1, wishlist2.getWishlistName());
            preparedStatement.setInt(2, wishlist2.isWishlistPrivate());
            preparedStatement.setInt(3, wishlist2.getWishlistID());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public Wishlist createWishList(Wishlist wishlist) {
        Connection connection = ConnectionManager.getConnection(db_url, db_user, db_pwd);
        String sql = "INSERT INTO wishlist (wishlistName) VALUES(?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, wishlist.getWishlistName());
            ps.executeUpdate();
            /*
            while (rs.next()){
                wishlist = new Wishlist(
                        rs.getString(1)
                );
            }

             */
            return wishlist;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
