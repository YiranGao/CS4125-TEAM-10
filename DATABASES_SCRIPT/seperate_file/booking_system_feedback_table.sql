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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-27 22:47:26
