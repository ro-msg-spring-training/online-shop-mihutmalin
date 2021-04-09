CREATE TABLE IF NOT EXISTS "Order"(
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `idLocation` INTEGER,
    `idCustomer` INTEGER,
    `CreateDate` DATETIME,
    `Address` INTEGER,
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY (`idLocation`) references `Location`(ID),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (`idCustomer`) references `Customer`(ID)
    );