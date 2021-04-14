CREATE TABLE IF NOT EXISTS `Revenue`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `idLocation` INTEGER,
    `date` DATE,
    `sum` DECIMAL,
    CONSTRAINT FK_REVENUE_LOCATION FOREIGN KEY (`idLocation`) references `Location`(`id`)
    );