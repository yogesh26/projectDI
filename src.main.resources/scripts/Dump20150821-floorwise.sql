-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: floorwise
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assetimages`
--

DROP TABLE IF EXISTS `assetimages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetimages` (
  `idassetImages` int(11) NOT NULL AUTO_INCREMENT,
  `assetImages` blob,
  PRIMARY KEY (`idassetImages`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetimages`
--

LOCK TABLES `assetimages` WRITE;
/*!40000 ALTER TABLE `assetimages` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetimages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assetmapping`
--

DROP TABLE IF EXISTS `assetmapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assetmapping` (
  `idassetmapping` int(11) NOT NULL AUTO_INCREMENT,
  `dateadded` datetime NOT NULL,
  `barcode` varchar(45) NOT NULL,
  `coordx` varchar(45) NOT NULL,
  `coordy` varchar(45) NOT NULL,
  `assettitle` varchar(45) NOT NULL,
  `idProject` int(11) NOT NULL,
  `idAssets` int(11) NOT NULL,
  PRIMARY KEY (`idassetmapping`),
  KEY `fk_AssetMapping_Project1_idx` (`idProject`),
  KEY `fk_AssetMapping_Assets1_idx` (`idAssets`),
  CONSTRAINT `fk_AssetMapping_Assets1` FOREIGN KEY (`idAssets`) REFERENCES `assets` (`idAssets`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AssetMapping_Project1` FOREIGN KEY (`idProject`) REFERENCES `project` (`idproject`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assetmapping`
--

LOCK TABLES `assetmapping` WRITE;
/*!40000 ALTER TABLE `assetmapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `assetmapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assets`
--

DROP TABLE IF EXISTS `assets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assets` (
  `idAssets` int(11) NOT NULL AUTO_INCREMENT,
  `assetTitle` varchar(45) NOT NULL,
  `assetDescription` varchar(100) DEFAULT NULL,
  `physicalProperties` varchar(255) DEFAULT NULL,
  `idassetImages` int(11) DEFAULT NULL,
  `idassettypes` int(11) NOT NULL,
  PRIMARY KEY (`idAssets`),
  KEY `fk_Assets_assetImages1_idx` (`idassetImages`),
  KEY `fk_Assets_AssetTypes1_idx` (`idassettypes`),
  CONSTRAINT `fk_Assets_AssetTypes1` FOREIGN KEY (`idassettypes`) REFERENCES `assettypes` (`idassettypes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Assets_assetImages1` FOREIGN KEY (`idassetImages`) REFERENCES `assetimages` (`idassetImages`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assets`
--

LOCK TABLES `assets` WRITE;
/*!40000 ALTER TABLE `assets` DISABLE KEYS */;
/*!40000 ALTER TABLE `assets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assettypes`
--

DROP TABLE IF EXISTS `assettypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assettypes` (
  `idassettypes` int(11) NOT NULL AUTO_INCREMENT,
  `assetTypes` enum('mechanical','structural','electrical','electronic') NOT NULL,
  PRIMARY KEY (`idassettypes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assettypes`
--

LOCK TABLES `assettypes` WRITE;
/*!40000 ALTER TABLE `assettypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `assettypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `idproject` int(11) NOT NULL AUTO_INCREMENT,
  `projecttitle` varchar(45) NOT NULL,
  `projectdescription` varchar(45) DEFAULT NULL,
  `dateAdded` datetime DEFAULT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idproject`),
  KEY `fk_Project_User1_idx` (`idUser`),
  CONSTRAINT `fk_Project_User1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) DEFAULT NULL,
  `UserPassword` varchar(45) NOT NULL,
  `UserRoles_idUserRoles` int(11) NOT NULL,
  `UserDetails_idUserDetails` int(11) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`),
  KEY `fk_User_UserRoles1_idx` (`UserRoles_idUserRoles`),
  KEY `fk_User_UserDetails1_idx` (`UserDetails_idUserDetails`),
  CONSTRAINT `fk_User_UserDetails1` FOREIGN KEY (`UserDetails_idUserDetails`) REFERENCES `userdetails` (`idUserDetails`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_UserRoles1` FOREIGN KEY (`UserRoles_idUserRoles`) REFERENCES `userroles` (`idUserRoles`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetails`
--

DROP TABLE IF EXISTS `userdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userdetails` (
  `idUserDetails` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) DEFAULT NULL,
  `UserName` varchar(45) DEFAULT NULL,
  `UserSurname` varchar(45) DEFAULT NULL,
  `Gender` enum('M','F','U') DEFAULT NULL,
  `Dob` date DEFAULT NULL,
  `Doj` date DEFAULT NULL,
  `Verified` tinyint(1) DEFAULT NULL,
  `Activated` tinyint(1) DEFAULT NULL,
  `iduserimages` int(11) NOT NULL,
  PRIMARY KEY (`idUserDetails`),
  KEY `fk_UserDetails_userimages1_idx` (`iduserimages`),
  CONSTRAINT `fk_UserDetails_userimages1` FOREIGN KEY (`iduserimages`) REFERENCES `userimages` (`iduserimage`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetails`
--

LOCK TABLES `userdetails` WRITE;
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userimages`
--

DROP TABLE IF EXISTS `userimages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userimages` (
  `iduserimage` int(11) NOT NULL AUTO_INCREMENT,
  `userimage` blob,
  `type` enum('jpeg','jpg','bmp','tiff') DEFAULT NULL,
  `sizeWidth` int(11) DEFAULT NULL,
  `sizeHeight` int(11) DEFAULT NULL,
  `imagename` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iduserimage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userimages`
--

LOCK TABLES `userimages` WRITE;
/*!40000 ALTER TABLE `userimages` DISABLE KEYS */;
/*!40000 ALTER TABLE `userimages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroles` (
  `idUserRoles` int(11) NOT NULL AUTO_INCREMENT,
  `UserType` enum('ADMIN','DEVELOPER','USER') NOT NULL,
  PRIMARY KEY (`idUserRoles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-21 14:04:08
