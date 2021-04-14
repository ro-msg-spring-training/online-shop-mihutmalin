CREATE TABLE IF NOT EXISTS `Address` (
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `country` VARCHAR(50),
    `city` VARCHAR(50),
    `county` VARCHAR(50),
    `streetAddress` VARCHAR(50)
    );