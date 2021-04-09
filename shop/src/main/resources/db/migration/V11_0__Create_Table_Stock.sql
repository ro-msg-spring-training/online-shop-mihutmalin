CREATE TABLE IF NOT EXISTS `Stock`(
    `idProduct` INTEGER NOT NULL,
    `idLocation` INTEGER NOT NULL,
    `Quantity` INTEGER,
    PRIMARY KEY (`idProduct`, `idLocation`),
    CONSTRAINT FK_STOCK_PRODUCT FOREIGN KEY (`idProduct`) references `Product`(ID),
    CONSTRAINT FK_STOCK_LOCATION FOREIGN KEY (`idLocation`) references `Location`(ID)
    );