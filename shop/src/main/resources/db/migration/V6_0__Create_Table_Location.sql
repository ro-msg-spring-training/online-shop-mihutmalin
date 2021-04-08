CREATE TABLE IF NOT EXISTS `Location`(
    `ID` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Name` VARCHAR(30),
    `Country` VARCHAR(30),
    `City` VARCHAR(30),
    `County` VARCHAR(30),
    `StreetAddress` VARCHAR(30)
    );