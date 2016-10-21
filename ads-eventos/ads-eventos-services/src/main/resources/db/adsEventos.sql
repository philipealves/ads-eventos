-- DROP DATABASE adsEventos;
CREATE DATABASE adsEventos;

CREATE TABLE `adsEventos`.`state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `initials` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `adsEventos`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id_state` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_state`) REFERENCES `adsEventos`.`state`(`id`));

CREATE TABLE `adsEventos`.`place` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  `neighborhood` VARCHAR(45) NULL,
  `id_city` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_city`) REFERENCES `adsEventos`.`city`(`id`));

INSERT INTO `adsEventos`.`state` (`id`, `name`, `initials`) VALUES (1, 'Minas Gerais', 'MG');
INSERT INTO `adsEventos`.`state` (`id`, `name`, `initials`) VALUES (2, 'São Paulo', 'SP');
INSERT INTO `adsEventos`.`state` (`id`, `name`, `initials`) VALUES (3, 'Goiás', 'GO');
INSERT INTO `adsEventos`.`state` (`id`, `name`, `initials`) VALUES (4, 'Rio de Janeiro', 'RJ');

INSERT INTO `adsEventos`.`city` (`id`, `name`, `id_state`) VALUES (NULL, 'Uberlândia', '1');
INSERT INTO `adsEventos`.`city` (`id`, `name`, `id_state`) VALUES (NULL, 'Araguari', '1');
INSERT INTO `adsEventos`.`city` (`name`, `id_state`) VALUES ('São Paulo', '2');
INSERT INTO `adsEventos`.`city` (`name`, `id_state`) VALUES ('Goiânia', '3');
INSERT INTO `adsEventos`.`city` (`name`, `id_state`) VALUES ('Rio de Janeiro', '4');


