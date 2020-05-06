-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 03:15 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospitalmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `patientID` int(10) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `nic` varchar(10) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`patientID`, `fname`, `lname`, `nic`, `sex`, `address`, `phone`, `email`, `password`) VALUES
(13, 'mahinda', 'rajapalsha', '456466478v', 'M', 'ranala,kaduwela', '0776546455', 'mahinda@gmail.com', 'mahi123'),
(20, 'Kasun', 'suranjith', '914532657v', 'M', 'sumangala mawatha,Wariyapola', '0721222800', 'kasun@gmail.com', 'kasun123'),
(24, 'sujeewa', 'weerasinghe', '914532668v', 'M', 'sumangala mawatha,Wariyapola', '0721222807', 'sujee@gmail.com', 'sujeee'),
(25, 'nilakshi', 'Madushani', '954532657v', 'F', 'school lane.wariyapola', '0774368995', 'niluu@gmail.com', 'nil321');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `pID` int(10) NOT NULL,
  `pName` varchar(30) NOT NULL,
  `pAddress` varchar(30) NOT NULL,
  `pAge` int(5) NOT NULL,
  `pNIC` varchar(20) NOT NULL,
  `pWeakness` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`pID`, `pName`, `pAddress`, `pAge`, `pNIC`, `pWeakness`) VALUES
(30, 'chandana+Dushantha', 'moratuwa', 24, '995161234V', 'sugar'),
(31, 'nilakshi+madushani', 'pore%2C+athurugiriya', 23, '971673876V', 'Headache'),
(34, 'nimal', 'ranjith', 36, '931376543v', 'fever'),
(36, 'ruwan', '456', 56, '36364646v', 'headeche');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`patientID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`pID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `patientID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `pID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
