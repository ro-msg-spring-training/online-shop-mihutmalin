CREATE TABLE IF NOT EXISTS `Stock`(
    `ID_product` INTEGER,
    `ID_location` INTEGER,
    `Quantity` INTEGER,
    CONSTRAINT FK_STOCK_PRODUCT FOREIGN KEY (`ID_product`) references `Product`(ID),
    CONSTRAINT FK_STOCK_LOCATION FOREIGN KEY (`ID_location`) references `Location`(ID)
    );