CREATE SCHEMA if not exists wishlist_db;
use wishlist_db;


CREATE TABLE if not exists wishList(
    wishListID INT auto_increment,
    wishListName VARCHAR(50) NOT NULL,
    isWishListPrivate BOOLEAN NOT NULL,
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


-- Inserting data into the wishlist table
INSERT INTO wishlist (wishListName, isWishListPrivate)
VALUES
    ('Birthday Wishlist', 0),
    ('Secret Santa Wishlist', 1),
    ('Dream Vacation Wishlist', 0),
    ('Special Occasion Wishlist', 1);



INSERT INTO wish (wishName, wishDescription, wishPrice, wishListID)
VALUES
    ('New Laptop', 'High-performance laptop for gaming and work', 1500, 1),
    ('Vacation to Hawaii', 'Two-week vacation package to Hawaii', 5000, 1),
    ('Gourmet Dinner', 'Fine dining experience at a Michelin-starred restaurant', 300, 2),
    ('Gucci bag', 'Newest bag from the Gucci line', 3000, 2),
    ('iPhone 13', 'Latest smartphone model with advanced features', 1200, 3),
    ('Iphone 16', 'Good', 1900, 3),
    ('Samsung S24', 'Newest samsung model', 6100, 1);