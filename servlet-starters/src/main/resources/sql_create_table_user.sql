create table users
(
    id SERIAL PRIMARY KEY ,
    name varchar(124) not null ,
    birthday date not null ,
    email varchar(124) not null unique ,
    image varchar(124) not null ,
    password varchar(32) not null ,
    role varchar(32) not null ,
    gender varchar(16) not null
);

drop table users;