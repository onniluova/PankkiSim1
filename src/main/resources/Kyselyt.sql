DROP DATABASE IF EXISTS simu_database;
CREATE DATABASE simu_database;
USE simu_database;

CREATE TABLE EMPLOYEE (
    id INT NOT NULL AUTO_INCREMENT,
    kokonaisaika VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id)
);

