CREATE TABLE IF NOT EXISTS `Customer`(
    `ID` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `FirstName` VARCHAR(30),
    `LastName` VARCHAR(30),
    `Username` VARCHAR(30),
    `Password` VARCHAR(30),
    `EmailAddress` VARCHAR(30)
    );