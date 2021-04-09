CREATE TABLE IF NOT EXISTS `Stock`(
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Product` INTEGER,
    `Location` INTEGER,
    `Quantity` INTEGER,
    CONSTRAINT FK_STOCK_PRODUCT FOREIGN KEY (`Product`) references `Product`(ID),
    CONSTRAINT FK_STOCK_LOCATION FOREIGN KEY (`Location`) references `Location`(ID)
    );