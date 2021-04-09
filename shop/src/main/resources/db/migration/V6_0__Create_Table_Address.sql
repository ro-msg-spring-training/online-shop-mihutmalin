CREATE TABLE IF NOT EXISTS `Address` (
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Country` VARCHAR(50),
    `City` VARCHAR(50),
    `County` VARCHAR(50),
    `StreetAddress` VARCHAR(50)
    );