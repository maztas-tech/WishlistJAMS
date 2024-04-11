DROP DATABASE IF exists wishlist_db;

CREATE SCHEMA if not exists wishlist_db;
use wishlist_db;

CREATE TABLE if not exists wish(
    wishID INT auto_increment,
    wishName VARCHAR(50) NOT NULL,
    wishDescription VARCHAR(100),
    wishPrice INT NOT NULL,
    primary key(wishID)
);

CREATE TABLE if not exists wishlist(
    wishlistID INT auto_increment,
    isPrivate BOOLEAN,
    wishlistName VARCHAR(50) NOT NULL,
    wishlistDescription VARCHAR(100),
    wishID INT,
    primary key(wishlistID),
    foreign key(wishID) references wish(wishID)
);

INSERT INTO wish (wishName, wishDescription, wishPrice) VALUES
('New Laptop', 'High-performance laptop for gaming and work', 1500),
('Vacation to Hawaii', 'Two-week vacation package to Hawaii', 5000),
('Gourmet Dinner', 'Fine dining experience at a Michelin-starred restaurant', 300),
('iPhone 13', 'Latest smartphone model with advanced features', 1200);

-- Inserting data into the wishlist table
INSERT INTO wishlist (isPrivate, wishlistName, wishlistDescription, wishID) VALUES
(FALSE, 'Birthday Wishlist', 'Items I would like to receive for my birthday', 1),
(TRUE, 'Secret Santa Wishlist', 'Gift ideas for the Secret Santa exchange', 4),
(FALSE, 'Dream Vacation Wishlist', 'Places I dream of visiting someday', 2),
(TRUE, 'Special Occasion Wishlist', 'Wishlist for special occasions and celebrations', 3);
