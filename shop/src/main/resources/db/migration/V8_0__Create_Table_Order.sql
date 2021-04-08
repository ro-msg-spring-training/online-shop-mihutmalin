CREATE TABLE IF NOT EXISTS "Orders"(
    `ID` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ID_location` INTEGER,
    `ID_customer` INTEGER,
    `CreateDate` TIMESTAMP,
    `Country` varchar(30),
    `City` varchar(30),
    `County` varchar(30),
    `StreetAddress` varchar(30),
    CONSTRAINT FK_ORDER_LOCATION FOREIGN KEY (`ID_location`) references `Location`(ID),
    CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (`ID_customer`) references `Customer`(ID)
    );