-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.33 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table itas_payment.account
CREATE TABLE IF NOT EXISTS `account` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `account_no` varchar(255) DEFAULT NULL,
  `total_balance` double NOT NULL,
  `customer_cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `FKhmv70e9d96my35xuui02961ie` (`customer_cid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table itas_payment.account: 3 rows
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`aid`, `account_no`, `total_balance`, `customer_cid`) VALUES
	(1, 'YB1238458273', 20236.033, 1),
	(2, 'YB545332756', 0, 2),
	(3, 'YB-954856931', 447856, 3);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- Dumping structure for table itas_payment.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `pan_no` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  `b_ank_no` varchar(255) DEFAULT NULL,
  `bank_no` varchar(255) DEFAULT NULL,
  `transactions_tid` int(11) DEFAULT NULL,
  `bankn` varchar(255) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `amount_sent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FKovf7bbdqth0qtgy7a489m0oii` (`transactions_tid`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table itas_payment.customer: 1 rows
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`cid`, `address`, `email`, `first_name`, `last_name`, `mobile`, `pan_no`, `password`, `mobile_no`, `b_ank_no`, `bank_no`, `transactions_tid`, `bankn`, `amount`, `amount_sent`) VALUES
	(3, 'Nairobi', 'ken.vilgax@gmail.com', 'kenbrian', 'muchiri', '70000000', NULL, '123456', NULL, NULL, '1234556711', NULL, NULL, '4055333', '5666');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table itas_payment.loan_account
CREATE TABLE IF NOT EXISTS `loan_account` (
  `loan_account_id` int(11) NOT NULL AUTO_INCREMENT,
  `interest_rate` double NOT NULL,
  `loan_account_number` varchar(255) DEFAULT NULL,
  `loan_balance` double NOT NULL,
  `loan_duration` int(11) NOT NULL,
  `loanemi` double NOT NULL,
  `loanemiremaining` int(11) NOT NULL,
  `customer_cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`loan_account_id`),
  KEY `FKnc1ubyse8amtmvh92dw69wh1o` (`customer_cid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table itas_payment.loan_account: 0 rows
/*!40000 ALTER TABLE `loan_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan_account` ENABLE KEYS */;

-- Dumping structure for table itas_payment.loan_transactions
CREATE TABLE IF NOT EXISTS `loan_transactions` (
  `ltid` int(11) NOT NULL AUTO_INCREMENT,
  `closing_balance` double NOT NULL,
  `emi` double NOT NULL,
  `trans_date` varchar(255) DEFAULT NULL,
  `transaction_type` varchar(255) DEFAULT NULL,
  `loan_account_id` int(11) NOT NULL,
  PRIMARY KEY (`ltid`),
  KEY `FKf8335n0t9931850tgfggkqgpe` (`loan_account_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table itas_payment.loan_transactions: 0 rows
/*!40000 ALTER TABLE `loan_transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan_transactions` ENABLE KEYS */;

-- Dumping structure for table itas_payment.personal_loan
CREATE TABLE IF NOT EXISTS `personal_loan` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `interest_rate` double NOT NULL,
  `loan_amount` double NOT NULL,
  `loan_duration` int(11) NOT NULL,
  `loanemi` double NOT NULL,
  `salary` double NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table itas_payment.personal_loan: 0 rows
/*!40000 ALTER TABLE `personal_loan` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_loan` ENABLE KEYS */;

-- Dumping structure for table itas_payment.transactions
CREATE TABLE IF NOT EXISTS `transactions` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `ammount` double NOT NULL,
  `closing_balance` double NOT NULL,
  `trans_date` varchar(255) DEFAULT NULL,
  `transaction_type` varchar(255) DEFAULT NULL,
  `aid` int(11) NOT NULL,
  PRIMARY KEY (`tid`),
  KEY `FKobc3up8ettldmf8kmn4rqph7f` (`aid`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Dumping data for table itas_payment.transactions: 7 rows
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` (`tid`, `ammount`, `closing_balance`, `trans_date`, `transaction_type`, `aid`) VALUES
	(1, 0.033, 0, '02/06/22 15:37:16', 'DEPOSITE', 1),
	(2, 10000, 0, '03/06/22 06:49:06', 'DEPOSITE', 1),
	(3, 10236, 0, '03/06/22 06:49:06', 'DEPOSITE', 1),
	(4, 0, 0, '03/06/22 08:46:00', 'WITHDRAW', 3),
	(5, 324567, 0, '03/06/22 08:46:00', 'DEPOSITE', 3),
	(6, 123333, 0, '03/06/22 09:26:24', 'DEPOSITE', 3),
	(7, 44, 0, '03/06/22 09:26:24', 'WITHDRAW', 3);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
