-- sql file for the creation of the booking_system database

CREATE TABLE `creditcards` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `holder_name` varchar(45) NOT NULL,
  `validdate_year` int(2) NOT NULL,
  `validdate_month` int(2) NOT NULL,
  `card_number` varchar(16) NOT NULL,
	PRIMARY KEY (`card_id`)
);

INSERT INTO `creditcards` (`card_id`, `holder_name`, `validdate_year`, `validdate_month`, `card_number`) VALUES
(1, 'Gavin V Randles', 11, 20, '6483749573638493');



CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `email` varchar(60) NOT NULL,
  `birthday` varchar(10) NOT NULL,
  `creditcard_id` int(11) DEFAULT NULL,
  `loyalty_points` int(3) DEFAULT '0',
	PRIMARY KEY (`customer_id`),
	FOREIGN KEY (`creditcard_id`) REFERENCES `creditcards` (`card_id`)
);

INSERT INTO `customers` (`customer_id`, `username`, `password`, `firstname`, `lastname`, `phone_number`, `email`, `birthday`, `creditcard_id`, `loyalty_points`) VALUES
(1, 'grand1', 'gav123', 'Gavin', 'Randles', '0852725054', 'gtarandles@gmail.com', '05/13/2018', 1, 1100);



CREATE TABLE `restaurants` (
  `restaurant_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  `tableamount` int(11) NOT NULL,
  PRIMARY KEY (`restaurant_id`)
);

INSERT INTO `restaurants` (`restaurant_id`, `name`, `location`, `tableamount`) VALUES
(2, 'La Cucina', 'Castletroy, Limerick', 10),
(3, 'Milano', 'Limerick', 10);



CREATE TABLE `tables` (
  `table_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_id` int(11) NOT NULL,
  `table_state` tinyint(1) NOT NULL,
  `seat_amount` int(11) NOT NULL,
  PRIMARY KEY (`table_id`),
	FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`)
);

INSERT INTO `tables` (`table_id`, `restaurant_id`, `table_state`, `seat_amount`) VALUES
(2, 2, 0, 4),
(3, 3, 0, 4),
(4, 2, 0, 5),
(5, 3, 0, 6);



CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
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
  `soya_allergy` tinyint(1) DEFAULT '0',
  `discount` double NOT NULL,
  PRIMARY KEY (`reservation_id`),
	FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`),
	FOREIGN KEY (`table_id`) REFERENCES `tables` (`table_id`)
);

INSERT INTO `reservations` (`reservation_id`, `customer_id`, `numofguests`, `bookingdate`, `table_id`, `restaurant_id`, `gluten_allergy`, `dairy_allergy`, `fish_allergy`, `shellfish_allergy`, `peanuts_allergy`, `soya_allergy`, `discount`) VALUES
(27, 1, 4, '2018-12-04 00:00:00', 2, 2, 0, 0, 1, 0, 0, 0, 0),
(28, 1, 4, '2018-12-04 11:00:00', 2, 2, 1, 0, 0, 0, 0, 0, 0),
(29, 1, 3, '2018-12-04 14:00:00', 2, 2, 0, 0, 0, 0, 0, 0, 0),
(30, 1, 3, '2018-12-04 13:00:00', 3, 2, 0, 0, 0, 0, 0, 0, 0),
(31, 1, 4, '2018-12-04 15:00:00', 2, 2, 0, 0, 0, 0, 0, 0, 11),
(32, 1, 4, '2018-12-04 19:00:00', 2, 2, 0, 0, 0, 0, 0, 0, 11);



CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `email` varchar(60) NOT NULL,
  `usertype` tinyint(11) NOT NULL,
  `feedback_mark` int(11) DEFAULT '0',
  `restaurant_id` int(11) NOT NULL,
  PRIMARY KEY (`staff_id`),
	FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`)
);

INSERT INTO `staff` (`staff_id`, `username`, `password`, `firstname`, `surname`, `phone_number`, `email`, `usertype`, `feedback_mark`, `restaurant_id`) VALUES
(1, 'grandles', 'gav123', 'Gavin', 'Randles', '0852725054', 'gtarandles@gmail.com', 2, 0, 2);




CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) NOT NULL,
  `feedback_mark` int(11) DEFAULT NULL,
  `reservation_id` int(11) NOT NULL,
  PRIMARY KEY (`feedback_id`),
	FOREIGN KEY (`staff_id`) REFERENCES `staff` (`staff_id`),
	FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`reservation_id`)
);

INSERT INTO `feedback` (`feedback_id`, `staff_id`, `feedback_mark`, `reservation_id`) VALUES
(1, 1, 5, 31);