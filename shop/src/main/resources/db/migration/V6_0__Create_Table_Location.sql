CREATE TABLE IF NOT EXISTS `Location`(
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(50),
    `Country` VARCHAR(50),
    `City` VARCHAR(50),
    `County` VARCHAR(50),
    `StreetAddress` VARCHAR(50)
    );