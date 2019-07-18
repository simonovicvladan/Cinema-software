/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.39-MariaDB : Database - cinema
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cinema` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cinema`;

/*Table structure for table `cinemahall` */

DROP TABLE IF EXISTS `cinemahall`;

CREATE TABLE `cinemahall` (
  `CinemaHallID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `NumberOfSeats` int(4) unsigned DEFAULT NULL,
  PRIMARY KEY (`CinemaHallID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `cinemahall` */

insert  into `cinemahall`(`CinemaHallID`,`Name`,`Type`,`NumberOfSeats`) values 
(1,'Rita Hayworth','DIGITAL_3D',58),
(2,'James Dean','HD',79),
(3,'Marilyn Monroe','DIGITAL_2D',112),
(4,'Lauren Bacall','MXH4D_3D',48),
(5,'Humphrey Bogart','VR',62),
(6,'Marlon Brando','HD',68);

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `MemberID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `FullName` varchar(255) DEFAULT NULL,
  `Contact` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MemberID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `member` */

insert  into `member`(`MemberID`,`FullName`,`Contact`,`Email`) values 
(1,'Aleksa Stefanovic','0652341235','aleksa@gmail.com'),
(4,'Vladimir Kocic','0675293521','vlad@gmail.com'),
(7,'Milica Bogdanovic','059252310','mika@gmail.com'),
(8,'Dusan Ristic','085024215','dule@gmail.com'),
(11,'Petar Ciric','098534442','petar@gmail.com'),
(12,'Nikola Petrovic','09543321','nikola@gmail.com'),
(13,'Vladimir Jovanovic','08654344039','vladjov@gmail.com'),
(14,'Jovana Peric','07654594832','jovper@gmail.com'),
(15,'Mihajlo Knezevic','095433932','miha@gmail.com');

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `MovieID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) DEFAULT NULL,
  `Genre` varchar(255) DEFAULT NULL,
  `ReleasedYear` int(4) unsigned DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Director` varchar(255) DEFAULT NULL,
  `Duration` int(4) unsigned DEFAULT NULL,
  PRIMARY KEY (`MovieID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `movie` */

insert  into `movie`(`MovieID`,`Title`,`Genre`,`ReleasedYear`,`Description`,`Director`,`Duration`) values 
(1,'The Godfather','CRIME',1972,'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.','Francis Ford Coppola',175),
(2,'The Dark Knight','ACTION',2008,'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham. \nThe Dark Knight must accept one of the greatest psychological and physical tests of his ability to fight injustice.','Christopher Nolan',152),
(4,'The Lord of the Rings: The Fellowship of the Ring','ADVENTURE',2001,'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.','Peter Jackson',178),
(5,'The Lord of the Rings: The Two Towers','ADVENTURE',2002,'While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron\'s new ally, Saruman, and his hordes of Isengard.','Peter Jackson',179),
(6,'The Silence of the Lambs','CRIME',1991,'A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.','Jonathan Demme',118),
(7,'The Dark Knight Rises','ACTION',2012,'ight years after the Joker\'s reign of anarchy, Batman, with the help of the enigmatic Catwoman, is forced from his exile to save Gotham City, now on the edge of total annihilation, from the brutal guerrilla terrorist Bane.','Christopher Nolan',164),
(9,'Shutter Island','MYSTERY',2010,'In 1954, a U.S. Marshal investigates the disappearance of a murderer, who escaped from a hospital for the criminally insane.','Martin Scorsese',138),
(11,'The Pianist','BIOGRAPHY',2002,'A Polish Jewish musician struggles to survive the destruction of the Warsaw ghetto of World War II.','Roman Polanski',150),
(12,'The Green Mile','CRIME',1999,'The lives of guards on Death Row are affected by one of their charges: a black man accused of child murder and rape, yet who has a mysterious gift.','Frank Darabont',189),
(13,'Inception','ACTION',2010,'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.','Christopher Nolan',148);

/*Table structure for table `projection` */

DROP TABLE IF EXISTS `projection`;

CREATE TABLE `projection` (
  `ProjectionID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ProjectionDateTime` datetime DEFAULT NULL,
  `UserID` bigint(10) unsigned NOT NULL,
  `MovieID` bigint(10) unsigned NOT NULL,
  `CinemaHallID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`ProjectionID`),
  KEY `projection_fk_1` (`UserID`),
  KEY `projection_fk_2` (`MovieID`),
  KEY `projection_fk_3` (`CinemaHallID`),
  CONSTRAINT `projection_fk_1` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`),
  CONSTRAINT `projection_fk_2` FOREIGN KEY (`MovieID`) REFERENCES `movie` (`MovieID`),
  CONSTRAINT `projection_fk_3` FOREIGN KEY (`CinemaHallID`) REFERENCES `cinemahall` (`CinemaHallID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `projection` */

insert  into `projection`(`ProjectionID`,`ProjectionDateTime`,`UserID`,`MovieID`,`CinemaHallID`) values 
(2,'2019-06-25 21:00:00',3,11,5),
(3,'2019-06-25 20:30:00',3,12,3),
(4,'2019-06-26 19:45:00',3,12,4),
(5,'2019-06-26 21:00:00',3,6,2),
(6,'2019-06-26 21:00:00',3,9,4),
(7,'2019-06-26 21:00:00',1,6,4),
(8,'2019-06-26 19:30:00',1,7,5),
(9,'2019-06-26 20:30:00',3,7,5),
(10,'2019-06-27 20:00:00',1,1,4),
(11,'2019-06-27 20:00:00',1,4,1),
(12,'2019-06-27 23:55:00',1,5,1),
(13,'2019-06-27 20:40:00',2,11,2),
(14,'2019-06-27 20:40:00',2,11,3),
(15,'2019-06-27 21:00:00',2,12,5),
(16,'2019-06-27 20:30:00',1,6,3),
(17,'2019-06-28 21:00:00',1,9,5),
(18,'2019-06-28 20:45:00',1,2,1),
(19,'2019-06-28 20:30:00',1,13,1),
(20,'2019-06-29 20:00:00',1,5,2),
(21,'2019-06-29 19:55:00',1,7,4),
(22,'2019-06-30 19:55:00',1,7,4);

/*Table structure for table `reservation` */

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
  `ReservationID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `ReservationDateTime` datetime DEFAULT NULL,
  `NumberOfTickets` int(4) unsigned DEFAULT NULL,
  `MemberID` bigint(10) unsigned NOT NULL,
  `ProjectionID` bigint(10) unsigned NOT NULL,
  `UserID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`ReservationID`),
  KEY `reservation_ibfk_1` (`MemberID`),
  KEY `reservation_ibfk_2` (`ProjectionID`),
  KEY `reservation_ibfk_3` (`UserID`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`MemberID`) REFERENCES `member` (`MemberID`),
  CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`ProjectionID`) REFERENCES `projection` (`ProjectionID`),
  CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `reservation` */

insert  into `reservation`(`ReservationID`,`ReservationDateTime`,`NumberOfTickets`,`MemberID`,`ProjectionID`,`UserID`) values 
(1,'2019-06-25 18:34:00',4,4,15,1),
(2,'2019-06-25 18:34:00',2,4,13,1),
(3,'2019-06-25 18:34:00',2,7,8,1),
(4,'2019-06-25 18:34:00',2,7,5,1),
(5,'2019-06-26 15:00:00',3,11,21,1),
(6,'2019-06-26 15:00:00',5,15,21,1),
(7,'2019-06-26 15:02:00',2,14,21,1),
(8,'2019-06-26 15:02:00',4,7,20,1),
(9,'2019-06-26 15:02:00',4,4,20,1),
(10,'2019-06-26 15:03:00',3,13,21,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UserID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `FullName` varchar(255) DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`UserID`,`FullName`,`Username`,`Password`,`Email`) values 
(1,'Vladan Simonovic','vladan','vladan123','vladan@gmail.com'),
(2,'Milenko Simonovic','misko','misko123','misko@gmail.com'),
(3,'Andjela Simonovic','andja','andja123','andja@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
