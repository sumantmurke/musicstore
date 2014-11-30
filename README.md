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


