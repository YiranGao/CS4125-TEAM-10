-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2018 at 01:38 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `booking_system2`
--

-- --------------------------------------------------------

--
-- Table structure for table `creditcards`
--

CREATE TABLE `creditcards` (
  `card_id` int(11) NOT NULL,
  `holder_name` varchar(45) NOT NULL,
  `validdate_year` int(2) NOT NULL,
  `validdate_month` int(2) NOT NULL,
  `card_number` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `creditcards`
--

INSERT INTO `creditcards` (`card_id`, `holder_name`, `validdate_year`, `validdate_month`, `card_number`) VALUES
(1, 'Gavin V Randles', 11, 20, '6483749573638493');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `email` varchar(60) NOT NULL,
  `birthday` varchar(10) NOT NULL,
  `creditcard_id` int(11) DEFAULT NULL,
  `loyalty_points` int(3) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `username`, `password`, `firstname`, `lastname`, `phone_number`, `email`, `birthday`, `creditcard_id`, `loyalty_points`) VALUES
(1, 'grand1', 'gav123', 'Gavin', 'Randles', '0852725054', 'gtarandles@gmail.com', '05/13/2018', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `feedback_mark` int(11) DEFAULT NULL,
  `reservation_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`feedback_id`, `staff_id`, `feedback_mark`, `reservation_id`) VALUES
(1, 1, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservations`
--

CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `numofguests` int(11) NOT NULL,
  `bookingdate` datetime NOT NULL DEFAULT '2000-01-01 00:00:00',
  `table_id` int(11) DEFAULT NULL,
  `restaurant_id` int(11) NOT NULL,
  `gluten_allergy` tinyint(1) DEFAULT '0',
  `dairy_allergy` tinyint(1) DEFAULT '0',
  `fish_allergy` tinyint(1) DEFAULT '0',
  `shellfish_allergy` tinyint(1) DEFAULT '0',
  `peanuts_allergy` tinyint(1) DEFAULT '0',
  `soya_allergy` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservations`
--

INSERT INTO `reservations` (`reservation_id`, `customer_id`, `numofguests`, `bookingdate`, `table_id`, `restaurant_id`, `gluten_allergy`, `dairy_allergy`, `fish_allergy`, `shellfish_allergy`, `peanuts_allergy`, `soya_allergy`) VALUES
(1, 1, 4, '2000-01-01 00:00:00', 1, 1, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `restaurant_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `tableamount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`restaurant_id`, `name`, `location`, `tableamount`) VALUES
(1, 'Team10 Limerick City', 'Limerick City, Limerick', 15);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `email` varchar(60) NOT NULL,
  `usertype` tinyint(11) NOT NULL,
  `feedback_mark` int(11) DEFAULT '0',
  `restaurant_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staff_id`, `username`, `password`, `firstname`, `surname`, `phone_number`, `email`, `usertype`, `feedback_mark`, `restaurant_id`) VALUES
(1, 'grandles', 'gav123', 'Gavin', 'Randles', '0852725054', 'gtarandles@gmail.com', 2, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tables`
--

CREATE TABLE `tables` (
  `table_id` int(11) NOT NULL,
  `restaurant_id` int(11) NOT NULL,
  `table_state` tinyint(1) NOT NULL,
  `seat_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tables`
--

INSERT INTO `tables` (`table_id`, `restaurant_id`, `table_state`, `seat_amount`) VALUES
(1, 1, 0, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `creditcards`
--
ALTER TABLE `creditcards`
  ADD PRIMARY KEY (`card_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`),
  ADD KEY `creditcard_id` (`creditcard_id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`),
  ADD KEY `staff_id` (`staff_id`),
  ADD KEY `reservation_id` (`reservation_id`);

--
-- Indexes for table `reservations`
--
ALTER TABLE `reservations`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `restaurant_id` (`restaurant_id`),
  ADD KEY `table_id` (`table_id`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`restaurant_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`),
  ADD KEY `restaurant_id` (`restaurant_id`);

--
-- Indexes for table `tables`
--
ALTER TABLE `tables`
  ADD PRIMARY KEY (`table_id`),
  ADD KEY `restaurant_id` (`restaurant_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `creditcards`
--
ALTER TABLE `creditcards`
  MODIFY `card_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reservations`
--
ALTER TABLE `reservations`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `restaurant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tables`
--
ALTER TABLE `tables`
  MODIFY `table_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`creditcard_id`) REFERENCES `creditcards` (`card_id`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`),
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`reservation_id`);

--
-- Constraints for table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  ADD CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`),
  ADD CONSTRAINT `reservations_ibfk_3` FOREIGN KEY (`table_id`) REFERENCES `tables` (`table_id`);

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`);

--
-- Constraints for table `tables`
--
ALTER TABLE `tables`
  ADD CONSTRAINT `tables_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
