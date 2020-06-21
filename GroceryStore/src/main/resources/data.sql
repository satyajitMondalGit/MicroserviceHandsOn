DROP TABLE IF EXISTS Product;
 
CREATE TABLE Product (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    discount DOUBLE NOT NULL
);


INSERT INTO Product (name, category, price, discount) VALUES ('apple', 'mobile', 80000, 20 );
INSERT INTO Product (name, category, price, discount) VALUES ('samsung', 'mobile', 25000 , 25 );
INSERT INTO Product (name, category, price, discount) VALUES ('shirt', 'cloth', 2000 , 30 );
INSERT INTO Product (name, category, price, discount) VALUES ('jeans', 'cloth', 3000 , 40 );
  