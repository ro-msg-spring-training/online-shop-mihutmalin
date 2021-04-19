CREATE TABLE IF NOT EXISTS "orderr"(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `idLocation` INTEGER,
    `idCustomer` INTEGER,
    `createDate` DATETIME,
    `address` INTEGER,
    CONSTRAINT FK_ORDER_ADDRESS FOREIGN KEY (`address`) REFERENCES `address`(`id`),
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY (`idLocation`) references `location`(`id`),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (`idCustomer`) references `customer`(`id`)
    );