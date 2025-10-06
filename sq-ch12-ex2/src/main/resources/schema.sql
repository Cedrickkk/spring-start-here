CREATE TABLE IF NOT EXISTS purchase
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    product varchar(50) NOT NULL,
    price   double      NOT NULL
);

INSERT INTO purchase (product, price)
VALUES ('Laptop', 999.99);
INSERT INTO purchase (product, price)
VALUES ('Mechanical Keyboard', 125.50);
INSERT INTO purchase (product, price)
VALUES ('Wireless Mouse', 45.99);
INSERT INTO purchase (product, price)
VALUES ('4K Monitor', 450.00);
INSERT INTO purchase (product, price)
VALUES ('USB-C Hub', 35.75);
INSERT INTO purchase (product, price)
VALUES ('Gaming Headset', 89.95);
INSERT INTO purchase (product, price)
VALUES ('SSD Drive 1TB', 60.00);
INSERT INTO purchase (product, price)
VALUES ('External Hard Drive', 75.25);
INSERT INTO purchase (product, price)
VALUES ('Webcam', 55.50);
INSERT INTO purchase (product, price)
VALUES ('Mouse Pad', 15.00);