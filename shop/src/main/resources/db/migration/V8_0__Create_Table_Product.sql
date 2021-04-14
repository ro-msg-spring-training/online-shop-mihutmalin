CREATE TABLE IF NOT EXISTS `Product`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    `description` VARCHAR(100),
    `price` DECIMAL,
    `weight` DOUBLE,
    `idCategory` INTEGER,
    `idSupplier` INTEGER,
    `imageUrl` VARCHAR(50),
    CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (`idCategory`) references `ProductCategory`(`id`),
    CONSTRAINT FK_PRODUCT_SUPPLIER FOREIGN KEY (`idSupplier`) references `Supplier`(`id`)
    );