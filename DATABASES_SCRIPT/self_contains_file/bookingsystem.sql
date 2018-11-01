-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: booking_system
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `administrator_table`
--

DROP TABLE IF EXISTS `administrator_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrator_table` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(45) NOT NULL,
  `usertype` int(11) NOT NULL,
  `administratorcol` varchar(45) NOT NULL,
  `admin_password` varchar(45) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator_table`
--

LOCK TABLES `administrator_table` WRITE;
/*!40000 ALTER TABLE `administrator_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrator_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creditcard_table`
--

DROP TABLE IF EXISTS `creditcard_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creditcard_table` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_holder_name` varchar(45) NOT NULL,
  `card_validdate_year` bigint(19) NOT NULL,
  `card_validdate_month` bigint(19) NOT NULL,
  `card_number` bigint(19) NOT NULL,
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creditcard_table`
--

LOCK TABLES `creditcard_table` WRITE;
/*!40000 ALTER TABLE `creditcard_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `creditcard_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_table`
--

DROP TABLE IF EXISTS `customer_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_table` (
  `customer_id` int(11) unsigned zerofill NOT NULL,
  `customer_name` varchar(45) NOT NULL,
  `customer_phone_number` bigint(20) DEFAULT NULL,
  `customer_password` varchar(45) NOT NULL,
  `customer_birth` varchar(45) DEFAULT NULL,
  `creditcard_id` int(11) DEFAULT NULL,
  `customer_gender` int(11) DEFAULT NULL,
  `customer_email` varchar(45) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `creditcard_id_idx` (`creditcard_id`),
  CONSTRAINT `creditcard_id` FOREIGN KEY (`creditcard_id`) REFERENCES `creditcard_table` (`card_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_table`
--

LOCK TABLES `customer_table` WRITE;
/*!40000 ALTER TABLE `customer_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback_table`
--

DROP TABLE IF EXISTS `feedback_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback_table` (
  `feedback_id` int(11) NOT NULL,
  `waiter_id` int(11) NOT NULL,
  `fronthouse_id` int(11) NOT NULL,
  `feedback_mark_waiter` int(11) DEFAULT NULL,
  `feedback_mark_fronthouse` int(11) DEFAULT NULL,
  `reservation_id` int(11) NOT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `waiter_id_idx` (`waiter_id`),
  KEY `fronthouse_id_idx` (`fronthouse_id`),
  KEY `restaurant_id_idx` (`reservation_id`),
  CONSTRAINT `fronthouse_id` FOREIGN KEY (`fronthouse_id`) REFERENCES `fronthouse_table` (`fronthouse_id`),
  CONSTRAINT `restaurant_id` FOREIGN KEY (`reservation_id`) REFERENCES `restaurant_table` (`restaurant_id`),
  CONSTRAINT `waiter_id` FOREIGN KEY (`waiter_id`) REFERENCES `waiter_table` (`waiter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_table`
--

LOCK TABLES `feedback_table` WRITE;
/*!40000 ALTER TABLE `feedback_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fronthouse_table`
--

DROP TABLE IF EXISTS `fronthouse_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fronthouse_table` (
  `fronthouse_id` int(11) NOT NULL AUTO_INCREMENT,
  `fronthouse_name` varchar(45) NOT NULL,
  `fronthouse_password` varchar(45) NOT NULL,
  `usertype` int(11) NOT NULL,
  `feedback_mark` int(11) DEFAULT NULL,
  `restaurant_id` int(11) NOT NULL,
  PRIMARY KEY (`fronthouse_id`),
  KEY `restaurant_id_idx` (`restaurant_id`),
  CONSTRAINT `restaurant_foreign` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant_table` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fronthouse_table`
--

LOCK TABLES `fronthouse_table` WRITE;
/*!40000 ALTER TABLE `fronthouse_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `fronthouse_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_table`
--

DROP TABLE IF EXISTS `reservation_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_table` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `reservation_numofcover` int(11) NOT NULL,
  `reservation_bookingdate` datetime NOT NULL DEFAULT '2000-01-01 00:00:00',
  `table_id` int(11) NOT NULL,
  `restaurant_id` int(11) NOT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `customer_id_idx` (`customer_id`),
  KEY `restaurant_foreign_idx` (`restaurant_id`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer_table` (`creditcard_id`),
  CONSTRAINT `restaurantforeignK` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant_table` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_table`
--

LOCK TABLES `reservation_table` WRITE;
/*!40000 ALTER TABLE `reservation_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_table`
--

DROP TABLE IF EXISTS `restaurant_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_table` (
  `restaurant_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_location` varchar(45) NOT NULL,
  `restaurant_tableamount` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  PRIMARY KEY (`restaurant_id`),
  KEY `admin_id_idx` (`admin_id`),
  CONSTRAINT `admin_id` FOREIGN KEY (`admin_id`) REFERENCES `administrator_table` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_table`
--

LOCK TABLES `restaurant_table` WRITE;
/*!40000 ALTER TABLE `restaurant_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_table`
--

DROP TABLE IF EXISTS `table_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_table` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) NOT NULL,
  `table_states` int(11) NOT NULL,
  `seat_amount` int(11) NOT NULL,
  PRIMARY KEY (`table_id`),
  KEY `restaurant_id_table_idx` (`restaurant_id`),
  CONSTRAINT `restaurant_id_table` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant_table` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_table`
--

LOCK TABLES `table_table` WRITE;
/*!40000 ALTER TABLE `table_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `table_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waiter_table`
--

DROP TABLE IF EXISTS `waiter_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `waiter_table` (
  `waiter_id` int(11) NOT NULL AUTO_INCREMENT,
  `waiter_name` varchar(45) NOT NULL,
  `waiter_password` varchar(45) NOT NULL,
  `usertype` int(11) NOT NULL,
  `feedback_mark` int(11) DEFAULT NULL,
  `restaurant_id` int(11) NOT NULL,
  PRIMARY KEY (`waiter_id`),
  KEY `restaurant_id_waiter_idx` (`restaurant_id`),
  CONSTRAINT `restaurant_id_waiter` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant_table` (`restaurant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waiter_table`
--

LOCK TABLES `waiter_table` WRITE;
/*!40000 ALTER TABLE `waiter_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `waiter_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-27 22:47:54
