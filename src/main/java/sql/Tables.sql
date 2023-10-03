CREATE DATABASE HW9;

CREATE TABLE Users(
    id SERIAL PRIMARY KEY ,
    firstName VARCHAR(20) not null ,
    lastName VARCHAR(20) not null ,
    userName VARCHAR(20) not null ,
    password VARCHAR(10)not null,
    postalCode VARCHAR(20)not null

);

CREATE TABLE ElectronicProducts(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(10),
    prize NUMERIC,
    stock INT
);


CREATE TYPE products AS ENUM ('CAMERA', 'TV');