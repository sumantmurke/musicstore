Do change your password in the database connnection file.





database schema





use musicLibrary;





create table user_details(


id bigint(20) not null primary key auto_increment,


first_name varchar(45) not null,


last_name varchar(45) not null,


email varchar(45) not null,


pwd  varchar(45) not null,


type varchar(5) default null 


);








create table tracks(


trackId varchar(20),


albumId varchar(20),


artistId varchar(20),


genreIds varchar(160),


price float default 1.99


);








insert into tracks (trackId, albumId, artistId, genreIds) values ('1', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('2', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('3', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('4', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('5', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('6', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('7', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('8', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('9', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('10', '1', '1', '1,56,23');


insert into tracks (trackId, albumId, artistId, genreIds) values ('11', '1', '1', '1,56,23');





create table albums(


albumId varchar(20),


artistId varchar(20),


genreIds varchar(160),


price float default 2.99


);





insert into albums (albumId, artistId, genreIds) values ('1', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('2', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('3', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('4', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('5', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('6', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('7', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('8', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('9', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('10', '1', '1,56,23');


insert into albums (albumId, artistId, genreIds) values ('11', '1', '1,56,23');

create table itemsLiked(


id bigint(20)  not null  primary key auto_increment,,


userid varchar(20),


itemid varchar(20),


rating  varchar(20),


type varchar(10),


isProcessed boolean default false,


time_stamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP


);


CREATE TABLE `musicLibrary`.`cart_purchase` (
  `userid` BIGINT(20) NOT NULL,
  `itemId` VARCHAR(20) NOT NULL,
  `itemType` VARCHAR(20) NOT NULL,
  `price` VARCHAR(20) NOT NULL,
  `isPurchased` INT NOT NULL DEFAULT 0,
  INDEX `fk_cart_purchase_userID_idx` (`userid` ASC),
  CONSTRAINT `fk_cart_purchase_userID`
    FOREIGN KEY (`userid`)
    REFERENCES `musicLibrary`.`user_details` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `musicLibrary`.`transaction` (
  `idtransaction` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(20) NOT NULL,
  `ccNumber` VARCHAR(16) NOT NULL,
  `total` DECIMAL(4,2) NOT NULL,
  `timestamp` TIMESTAMP NULL,
  PRIMARY KEY (`idtransaction`));
  
  
 
 
insert into genre values (1);


insert into genre values (2);


insert into genre values (3);


insert into genre values (4);


insert into genre values (5);


insert into genre values (6);


insert into genre values (7);


insert into genre values (8);


insert into genre values (9);


insert into genre values (10);


insert into genre values (11);


insert into genre values (12);


insert into genre values (13);


insert into genre values (14);


insert into genre values (15);





insert into artists values (1);


insert into artists values (2);


insert into artists values (3);


insert into artists values (4);


insert into artists values (5);


insert into artists values (6);


insert into artists values (7);


insert into artists values (8);


insert into artists values (9);


insert into artists values (10);


insert into artists values (11);


insert into artists values (12);


insert into artists values (13);


insert into artists values (14);


insert into artists values (15);
  
CREATE TABLE `musicLibrary`.`artists` (
  `artistId` VARCHAR(20) NOT NULL);
  
CREATE TABLE `musicLibrary`.`genre` (
  `genreId` VARCHAR(20) NOT NULL);
  
  
