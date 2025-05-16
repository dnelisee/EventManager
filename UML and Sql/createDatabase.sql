START TRANSACTION;

CREATE DATABASE IF NOT EXISTS `EventManagement`; 
use `EventManagement`; 

CREATE TABLE IF NOT EXISTS `Conference`(
    `id` INT PRIMARY KEY,
    `name` VARCHAR(25) NOT NULL, 
    `date` 
    `location` VARCHAR(50) NOT NULL,
    `maxCapacity` INT, 
    `theme` VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS `Concert`(
    `id` INT PRIMARY KEY,
    `name` VARCHAR(25) NOT NULL, 
    `date` 
    `location` VARCHAR(50) NOT NULL,
    `maxCapacity` INT, 
    `artist` VARCHAR(25) NOT NULL, 
    `musicalGenre` VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS `Organizer`(
    `id` INT PRIMARY KEY,
    `name` VARCHAR(25) NOT NULL, 
    `phoneNumber` VARCHAR()
    `location` VARCHAR(50) NOT NULL,
    `maxCapacity` INT, 
    `artist` VARCHAR(25) NOT NULL, 
    `musicalGenre` VARCHAR(25)
);

COMMIT;