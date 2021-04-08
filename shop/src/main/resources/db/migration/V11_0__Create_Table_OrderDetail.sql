CREATE TABLE IF NOT EXISTS `OrderDetail`(
    `ID_order` INTEGER,
    `ID_product` INTEGER,
    `Quantity` INTEGER,
    CONSTRAINT FK_ORDERDETAIL_PRODUCT FOREIGN KEY(`ID_product`) references `Product`(ID),
    CONSTRAINT FK_ORDERDETAIL_ORDER FOREIGN KEY (`ID_order`) references `Orders`(ID)
);