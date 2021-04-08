CREATE TABLE IF NOT EXISTS `Product`(
    `ID` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(30),
    `Description` VARCHAR(50),
    `Price` DECIMAL,
    `Weight` DOUBLE,
    `ID_category` INTEGER,
    `ID_supplier` INTEGER,
    `ImageUrl` VARCHAR(50),
    CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (`ID_category`) references `ProductCategory`(ID),
    CONSTRAINT FK_PRODUCT_SUPPLIER FOREIGN KEY (`ID_supplier`) references `Supplier`(ID)
    );