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

