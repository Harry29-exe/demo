CREATE TABLE product (
                         product_id int primary key,
                         product_name varchar(50),
                         description varchar(400),
                         price float,
                         image_url varchar(150)
);


INSERT INTO product(product_id, product_name, description, price, image_url) VALUES
(98154, 'apple', 'An apple is an edible fruit produced by an apple tree (Malus domestica). Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years in Asia and Europe and were brought to North America by European colonists.', 2.5,
 '/apple.jpg');

INSERT INTO product(product_id, product_name, description, price, image_url) VALUES
(74521, 'pear', 'Pears are fruits produced and consumed around the world, growing on a tree and harvested in late Summer into October. The pear tree and shrub are a species of genus Pyrus /ˈpaɪrəs/, in the family Rosaceae, bearing the pomaceous fruit of the same name. Several species of pears are valued for their edible fruit and juices, while others are cultivated as trees.', 3.43,
 '/pear.jpg');

INSERT INTO product(product_id, product_name, description, price, image_url) VALUES
(4577, 'strawberry', 'The garden strawberry (or simply strawberry; Fragaria × ananassa)[1] is a widely grown hybrid species of the genus Fragaria, collectively known as the strawberries, which are cultivated worldwide for their fruit. The fruit is widely appreciated for its characteristic aroma, bright red color, juicy texture, and sweetness.', 0.25,
 '/strawberry.jpg');

INSERT INTO product(product_id, product_name, description, price, image_url) VALUES
(10475, 'watermelon', 'Watermelon (Citrullus lanatus) is a flowering plant species of the Cucurbitaceae family . A scrambling and trailing vine-like plant, it was originally domesticated in Africa. It is a highly cultivated fruit worldwide, with more than 1,000 varieties.', 9.75,
 '/watermelon.jpg');

SELECT * FROM product
