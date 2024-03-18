DROP DATABASE IF EXISTS simu_database;
CREATE DATABASE simu_database;
USE simu_database;

CREATE TABLE tulokset (
    id INT NOT NULL AUTO_INCREMENT,
    kokonaisaika DECIMAL(10.2) NOT NULL,
    asiakkaiden_maara INT(10) NOT NULL,
    asiakkaiden_keskimaarainen_ika DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (id)
);

alter table tulokset add palvelupisteen_palveluaika decimal(10,2);

alter table tulokset add suoritusteho decimal(10.2);
ALTER TABLE tulokset ADD saapuneet_asiakkaat INT(6);
ALTER TABLE tulokset ADD palvellut_asiakkaat INT(6);
ALTER TABLE tulokset ADD palveluajan_keskiarvo decimal(10.2);

