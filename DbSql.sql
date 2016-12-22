CREATE DATABASE  IF NOT EXISTS `samplefaq` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `samplefaq`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: farmersfaq
-- ------------------------------------------------------
-- Server version	5.0.15

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `faq_answers`
--

DROP TABLE IF EXISTS `faq_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faq_answers` (
  `question_id` int(11) NOT NULL auto_increment,
  `question_intent` varchar(100) default NULL,
  `question` varchar(300) default NULL,
  `answer` varchar(1000) default NULL,
  PRIMARY KEY  (`question_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faq_answers`
--

LOCK TABLES `faq_answers` WRITE;
/*!40000 ALTER TABLE `faq_answers` DISABLE KEYS */;
INSERT INTO `faq_answers` VALUES (1,'ForgotLoginIntent','I forgot my username and password. How do I log in?','Trying to log into your My Sample account, but cannot remember your username and password? Do not worry; we can help recover your information, First Go to the My Sample account recovery page, Then Enter your policy number, last name, and date of birth, After that Answer a security question, Now you will get your account information'),(2,'ReportLossIntent','Who should I call to report a loss?','After a car accident, home damage, or any kind of loss, it is important to let your Sample agent know, To get the claims process moving immediately though, call Sample Claim Services at 1-800-435-7764');
/*!40000 ALTER TABLE `faq_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'farmersfaq'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-22 14:44:17
