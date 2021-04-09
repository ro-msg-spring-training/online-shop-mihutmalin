CREATE TABLE IF NOT EXISTS "Order"(
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ShippedFrom` INTEGER,
    `Customer` INTEGER,
    `CreateDate` DATETIME,
    `Country` varchar(50),
    `City` varchar(50),
    `County` varchar(50),
    `StreetAddress` varchar(50),
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY (`ShippedFrom`) references `Location`(ID),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (`Customer`) references `Customer`(ID)
    );