CREATE TABLE IF NOT EXISTS `Customer`(
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `FirstName` VARCHAR(50),
    `LastName` VARCHAR(50),
    `Username` VARCHAR(50),
    `Password` VARCHAR(50),
    `EmailAddress` VARCHAR(50)
    );