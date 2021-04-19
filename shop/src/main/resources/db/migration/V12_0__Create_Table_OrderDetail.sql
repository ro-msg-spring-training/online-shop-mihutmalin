CREATE TABLE IF NOT EXISTS `orderDetail`(
    `idOrder` INTEGER NOT NULL,
    `idProduct` INTEGER NOT NULL,
    `quantity` INTEGER,
    PRIMARY KEY (`idOrder`, `idProduct`),
    CONSTRAINT FK_ORDERDETAIL_PRODUCT FOREIGN KEY(`idProduct`) references `product`(`id`),
    CONSTRAINT FK_ORDERDETAIL_ORDER FOREIGN KEY (`idOrder`) references `orderr`(`id`)
);