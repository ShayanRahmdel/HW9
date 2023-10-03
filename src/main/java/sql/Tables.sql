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
    prize NUMERIC  ,
    stock INT
);





CREATE TABLE Orders(
    id SERIAL PRIMARY KEY ,
    stock INT,
    user_id INT REFERENCES users(id),
    elecproduct_id INT REFERENCES electronicproducts(id)

);