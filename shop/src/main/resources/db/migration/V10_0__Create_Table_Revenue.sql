CREATE TABLE IF NOT EXISTS `Revenue`(
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `idLocation` INTEGER,
    `Date` DATE,
    `Sum` DECIMAL,
    CONSTRAINT FK_REVENUE_LOCATION FOREIGN KEY (`idLocation`) references `Location`(ID)
    );