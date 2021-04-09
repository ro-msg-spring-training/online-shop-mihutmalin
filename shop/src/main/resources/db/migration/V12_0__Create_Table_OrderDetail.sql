CREATE TABLE IF NOT EXISTS `OrderDetail`(
    `idOrder` INTEGER NOT NULL,
    `idProduct` INTEGER NOT NULL,
    `Quantity` INTEGER,
    PRIMARY KEY (`idOrder`, `idProduct`),
    CONSTRAINT FK_ORDERDETAIL_PRODUCT FOREIGN KEY(`idProduct`) references `Product`(ID),
    CONSTRAINT FK_ORDERDETAIL_ORDER FOREIGN KEY (`idOrder`) references `Order`(ID)
);