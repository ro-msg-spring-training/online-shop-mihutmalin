CREATE TABLE IF NOT EXISTS `stock`(
    `idProduct` INTEGER NOT NULL,
    `idLocation` INTEGER NOT NULL,
    `quantity` INTEGER,
    PRIMARY KEY (`idProduct`, `idLocation`),
    CONSTRAINT FK_STOCK_PRODUCT FOREIGN KEY (`idProduct`) references `product`(`id`),
    CONSTRAINT FK_STOCK_LOCATION FOREIGN KEY (`idLocation`) references `location`(`id`)
    );