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

