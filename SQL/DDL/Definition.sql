CREATE SCHEMA if not exists wishlist_db;
use wishlist_db;


CREATE TABLE wishList(
                         wishListID INT auto_increment,
                         wishListName VARCHAR(50) NOT NULL,
                         isWishListPrivate BOOLEAN,
                         primary key(wishListID)
);

CREATE TABLE if not exists wish(
                                   wishID INT auto_increment,
                                   wishName VARCHAR(50) NOT NULL,
    wishDescription VARCHAR(100),
    wishPrice INT NOT NULL,
    wishListID INT NOT NULL,
    primary key(wishID),
    FOREIGN KEY(wishListID) REFERENCES wishList(wishListID)
    );