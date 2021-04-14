CREATE TABLE IF NOT EXISTS `Customer`(
    `id` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `firstName` VARCHAR(50),
    `lastName` VARCHAR(50),
    `username` VARCHAR(50),
    `password` VARCHAR(50),
    `emailAddress` VARCHAR(50)
    );