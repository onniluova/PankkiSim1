DROP DATABASE IF EXISTS simu_database;
CREATE DATABASE simu_database;
USE simu_database;

CREATE TABLE Tulokset (
    id INT NOT NULL AUTO_INCREMENT,
    kokonaisaika DECIMAL(10.2) NOT NULL,
    asiakkaiden_maara INT(10) NOT NULL,
    asiakkaiden_keskimaarainen_ika DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id)
);

