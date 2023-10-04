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
    user_id INT REFERENCES users(id),
    elecproduct_id INT REFERENCES electronicproducts(id),
    shoesproduct_id INT REFERENCES shoeproduct(id)
);

CREATE TABLE Shoeproduct(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(10),
    prize NUMERIC,
    stock INT
);

SELECT sum(prize) from electronicproducts
join Orders on elecproduct_id=ElectronicProducts.id
where user_id = 2  UNION ALL (SELECT sum(prize) from  shoeproduct
 join orders on shoesproduct_id = Shoeproduct.id
where user_id =2);

SELECT SUM(total_price) AS total_sum
FROM (
         SELECT SUM(prize) AS total_price
         FROM electronicproducts
         WHERE id IN (SELECT elecproduct_id FROM Orders)

         UNION ALL

         SELECT SUM(prize) AS total_price
         FROM shoeproduct
         WHERE id IN (SELECT shoesproduct_id FROM Orders)
     ) AS subquery;