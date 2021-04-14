CREATE TABLE IF NOT EXISTS "Order"(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `idLocation` INTEGER,
    `idCustomer` INTEGER,
    `createDate` DATETIME,
    `address` INTEGER,
    CONSTRAINT FK_ORDER_ADDRESS FOREIGN KEY (`address`) REFERENCES `Address`(`id`),
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY (`idLocation`) references `Location`(`id`),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (`idCustomer`) references `Customer`(`id`)
    );