CREATE TABLE IF NOT EXISTS `Product`(
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(50),
    `Description` VARCHAR(100),
    `Price` DECIMAL,
    `Weight` DOUBLE,
    `idCategory` INTEGER,
    `idSupplier` INTEGER,
    `ImageUrl` VARCHAR(50),
    CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (`idCategory`) references `ProductCategory`(ID),
    CONSTRAINT FK_PRODUCT_SUPPLIER FOREIGN KEY (`idSupplier`) references `Supplier`(ID)
    );