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

SELECT ElectronicProducts.name,Shoeproduct.name,count(elecproduct_id),count(shoesproduct_id) FROM Shoeproduct
join Orders on shoesproduct_id = Shoeproduct.id
join ElectronicProducts on elecproduct_id = ElectronicProducts.id
WHERE user_id=2
GROUP BY name, name;

SELECT ElectronicProducts.name AS electronic_product_name, Shoeproduct.name AS shoe_product_name, COUNT(elecproduct_id), COUNT(shoesproduct_id)
FROM Shoeproduct
         JOIN Orders ON shoesproduct_id = Shoeproduct.id
         JOIN ElectronicProducts ON elecproduct_id = ElectronicProducts.id
WHERE user_id = 2
GROUP BY ElectronicProducts.name, Shoeproduct.name;


CREATE TABLE Product(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(10),
    price NUMERIC,
    stock INT,
    category VARCHAR(20)
);

CREATE TABLE orders(
    id SERIAL PRIMARY KEY ,
    user_id INT REFERENCES  users(id),
    product_id INT REFERENCES Product(id)
);

SELECT sum(price) FROM Product
join orders o on Product.id = o.product_id
where user_id =2;

SELECT o.id, p.name AS product_name, COUNT(*) AS product_count, SUM(p.price) AS total_price
FROM orders o
         JOIN product p ON o.product_id = p.id
where user_id=2
GROUP BY p.name,o.id;