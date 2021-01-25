-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2020 at 01:49 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `adoption`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientmessage`
--

CREATE TABLE `clientmessage` (
  `id_msg` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clientmessage`
--

INSERT INTO `clientmessage` (`id_msg`, `firstName`, `lastName`, `email`, `phone`, `message`) VALUES
(1, 'Puspakirana', 'Stavira', 'kirana.stavira@gmail.com', '0812345678910', 'Hello, I\'m interested in your campaign :)'),
(2, 'Seraphina', 'Olivia', 'sera@gmail.com', '1123214', 'Hello! I\'m so excited to see Seven in his profile page. I hope you can give me a schedule to get know Seven before we decide.'),
(4, 'Alicia', 'Keys', 'alicia@gmail.com', '11234546', 'hi I\'m Alicia. I\'d like to hear your advice.'),
(5, 'Mrs.', 'Moana', 'moana@gmail.com', '11111', 'Hello! I\'d like to see pogo next week1!!'),
(6, 'John', 'Doe', 'john@gmail.com', '12384719857', 'Hi I\'m John, I would like to set a meet up to know pogo better. Thanks'),
(7, 'Jane', 'Doe', 'jane@gmail.com', '111239i21094', 'Hello! I want to get to know better with Seven before I decide to adopt him. Let\'s set up a meeting.');

-- --------------------------------------------------------

--
-- Table structure for table `registationform`
--

CREATE TABLE `registationform` (
  `id_regist` int(11) NOT NULL,
  `firstName` varchar(30) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(255) NOT NULL,
  `country` varchar(30) NOT NULL,
  `idNum` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `underdogs` varchar(30) NOT NULL,
  `stuff` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registationform`
--

INSERT INTO `registationform` (`id_regist`, `firstName`, `lastName`, `email`, `phone`, `address`, `country`, `idNum`, `gender`, `underdogs`, `stuff`) VALUES
(3, 'Puspakirana', 'Stavira', 'kirana.stavira@gmail.com', '0812345678910', 'Residen Pamuji', 'Indonesia', '01234567890', 'Female', 'Seven', 'Basic-Stuff, Vaccine'),
(4, 'Puspakirana', 'Stavira', 'kirana.stavira@gmail.com', '0812345678910', 'Residen Pamuji', 'Indonesia', '01234567890', 'Female', 'Pogo', 'Basic-Stuff, Vaccine'),
(5, 'Seraphina', 'Olivia', 'sera@gmail.com', '1123214', 'jl. durian 10', 'Indonesia', '000010000', 'Female', 'Pogo', 'Vaccine'),
(6, 'Puspakirana', 'Stavira', 'kirana.stavira@gmail.com', '0812345678910', 'Residen Pamuji', 'Indonesia', '01234567890', 'Female', 'Seven', 'Basic-Stuff, Vaccine');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientmessage`
--
ALTER TABLE `clientmessage`
  ADD PRIMARY KEY (`id_msg`);

--
-- Indexes for table `registationform`
--
ALTER TABLE `registationform`
  ADD PRIMARY KEY (`id_regist`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientmessage`
--
ALTER TABLE `clientmessage`
  MODIFY `id_msg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `registationform`
--
ALTER TABLE `registationform`
  MODIFY `id_regist` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
