-- DROP DATABASE adsEventos;
CREATE DATABASE adsEventos;

CREATE TABLE `adsEventos`.`state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `initials` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `iid` (id)
);

CREATE TABLE `adsEventos`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id_state` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_state`) REFERENCES `adsEventos`.`state`(`id`),
  INDEX `iid` (id)
 );

CREATE TABLE `adsEventos`.`place` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  `neighborhood` VARCHAR(45) NULL,
  `id_city` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_city`) REFERENCES `adsEventos`.`city`(`id`),
  INDEX `iid` (id)
 );

CREATE TABLE `adsEventos`.`event` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`description` varchar(45) NOT NULL,
	`moment` datetime NOT NULL,
	`id_place` int NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_id_place` FOREIGN KEY (`id_place`) REFERENCES `adsEventos`.`place` (`id`)   ON UPDATE NO ACTION ON DELETE NO ACTION,
	INDEX `iid` (id)
);

CREATE TABLE `adsEventos`.`participant` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`email` varchar(100) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `iid` (id)
);
  
CREATE TABLE `adsEventos`.`event_participants` (
	`id` int NOT NULL,
	`id_event` int NOT NULL,
	`id_participant` int NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_id_event` FOREIGN KEY (`id_event`) REFERENCES `adsEventos`.`event` (`id`)   ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `fk_id_participant` FOREIGN KEY (`id_participant`) REFERENCES `adsEventos`.`participant` (`id`)   ON UPDATE NO ACTION ON DELETE NO ACTION,
	INDEX `iid` (id)
);

INSERT INTO `adsEventos`.`state` (`id`, `name`, `initials`) VALUES (1, 'Minas Gerais', 'MG');
INSERT INTO `adsEventos`.`state` (`id`, `name`, `initials`) VALUES (2, 'São Paulo', 'SP');
INSERT INTO `adsEventos`.`state` (`id`, `name`, `initials`) VALUES (3, 'Goiás', 'GO');
INSERT INTO `adsEventos`.`state` (`id`, `name`, `initials`) VALUES (4, 'Rio de Janeiro', 'RJ');

INSERT INTO `adsEventos`.`city` (`id`, `name`, `id_state`) VALUES (NULL, 'Uberlândia', '1');
INSERT INTO `adsEventos`.`city` (`id`, `name`, `id_state`) VALUES (NULL, 'Araguari', '1');
INSERT INTO `adsEventos`.`city` (`name`, `id_state`) VALUES ('São Paulo', '2');
INSERT INTO `adsEventos`.`city` (`name`, `id_state`) VALUES ('Goiânia', '3');
INSERT INTO `adsEventos`.`city` (`name`, `id_state`) VALUES ('Rio de Janeiro', '4');


-- DROP DATABASE adsEventos;
CREATE DATABASE adsEventos;

CREATE TABLE `adsEventos`.`state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `initials` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `iid` (id)
);

CREATE TABLE `adsEventos`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id_state` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_state`) REFERENCES `adsEventos`.`state`(`id`),
  INDEX `iid` (id)
 );

CREATE TABLE `adsEventos`.`place` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  `neighborhood` VARCHAR(45) NULL,
  `id_city` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_city`) REFERENCES `adsEventos`.`city`(`id`),
  INDEX `iid` (id)
 );

CREATE TABLE `adsEventos`.`event` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`description` varchar(45) NOT NULL,
	`moment` datetime NOT NULL,
	`id_place` int NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_id_place` FOREIGN KEY (`id_place`) REFERENCES `adsEventos`.`place` (`id`)   ON UPDATE NO ACTION ON DELETE NO ACTION,
	INDEX `iid` (id)
);

CREATE TABLE `adsEventos`.`participant` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`email` varchar(100) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `iid` (id)
);
  
CREATE TABLE `adsEventos`.`event_participants` (
	`id` int NOT NULL,
	`id_event` int NOT NULL,
	`id_participant` int NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_id_event` FOREIGN KEY (`id_event`) REFERENCES `adsEventos`.`event` (`id`)   ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT `fk_id_participant` FOREIGN KEY (`id_participant`) REFERENCES `adsEventos`.`participant` (`id`)   ON UPDATE NO ACTION ON DELETE NO ACTION,
	INDEX `iid` (id)
);