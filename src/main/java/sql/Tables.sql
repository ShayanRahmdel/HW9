CREATE DATABASE HW9;

CREATE TABLE Users(
    id SERIAL PRIMARY KEY ,
    firstName VARCHAR(20) not null ,
    lastName VARCHAR(20) not null ,
    userName VARCHAR(20) not null ,
    password VARCHAR(10)not null,
    address VARCHAR(20)

);