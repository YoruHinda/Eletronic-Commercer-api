create database if not exists `commerce`;

use `commerce`;

create table if not exists `product`(
    `id` int NOT NULL AUTO_INCREMENT,
    `product_name` varchar(255),
    `product_description` varchar(255),
    `product_quantity` int,
    `product_price` float,
    `product_image_name` varchar(255),
    PRIMARY KEY (`id`)
);

create table if not exists `users`(
    `id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(255),
    `password` varchar(255),
    `user_role` varchar(255),
    PRIMARY KEY (`id`)
);

insert IGNORE into `product` (`product_name`, `product_description`, `product_price`, `product_quantity`, `product_image_name`)
values
("Teclado", "Teclado gamer", 299.90, 9, "teclado.png"),
("Mause", "Mause gamer", 199.90, 8, "mause.png"),
("Headset", "Headset gamer", 199.90, 2, "headset.png"),
("Celular", "Celular gamer", 1199.90, 1, "celular.png"),
("Monitor", "Monitor gamer", 2699.90, 5, "monitor.jpg"),
("MausePad", "MausePad gamer", 99.90, 3, "mausepad.png"),
("Playstation 5 Pro", "Playstation gamer", 1999.90, 2, "ps5.png");