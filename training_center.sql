-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 19, 2016 at 12:15 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `training_center`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_courses`
--

CREATE TABLE IF NOT EXISTS `tbl_courses` (
`id` int(11) NOT NULL,
  `course_name` varchar(100) NOT NULL,
  `course_description` text NOT NULL,
  `fees` decimal(12,2) NOT NULL,
  `duration` int(11) NOT NULL,
  `duration_type` enum('Days','Week','Month','Year') NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` timestamp NULL DEFAULT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_courses`
--

INSERT INTO `tbl_courses` (`id`, `course_name`, `course_description`, `fees`, `duration`, `duration_type`, `added_date`, `modified_date`, `status`) VALUES
(1, 'Php', 'this is php', '12000.00', 8, 'Week', '2015-12-04 06:37:25', '2015-12-06 18:15:00', 1),
(2, 'python', 'this is python', '10000.00', 13, 'Days', '2015-12-04 06:57:52', '2015-12-05 18:15:00', 1),
(3, 'Advanced Java', 'Advance Java course.', '20000.00', 8, 'Week', '2015-12-05 03:07:44', NULL, 1),
(4, 'as', 'sa', '123124.00', 19, 'Days', '2015-12-06 13:50:08', '2016-01-18 18:15:00', 0),
(5, 'sd', 'sa', '123.00', 1, 'Week', '2015-12-06 16:14:20', '2016-01-18 18:15:00', 0),
(6, 'Core JAVA & Web Fundamentals', 'Core Javaasljdfajksdhfaskdgfask', '12000.00', 6, 'Week', '2015-12-06 16:50:23', NULL, 0),
(7, 'sfs', 'ssdvsd', '12241225.00', 17, 'Week', '2015-12-07 03:59:15', NULL, 0),
(8, 'php', 'this is php course', '12345.00', 1, 'Month', '2016-01-19 03:30:41', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_enquiries`
--

CREATE TABLE IF NOT EXISTS `tbl_enquiries` (
`id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact_no` varchar(20) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `message` text NOT NULL,
  `enquiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_read` tinyint(1) NOT NULL DEFAULT '0',
  `parent_id` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_enquiries`
--

INSERT INTO `tbl_enquiries` (`id`, `first_name`, `last_name`, `email`, `contact_no`, `course_id`, `message`, `enquiry_date`, `is_read`, `parent_id`) VALUES
(1, 'test', 'asdf', 'dixanta@gmail.com', '123213', 1, 'asdfasdfsafasdfasdf', '2015-12-04 07:41:20', 0, 0),
(2, 'test', 'asdf', 'dixanta@gmail.com', '123213', 1, 'asdfasdfsafasdfasdf', '2015-12-04 07:45:10', 0, 0),
(3, 'sd', 'dasd', 'sd@gmail.com', 'sdsad', 3, 'sdasdasdasd', '2016-01-19 03:29:41', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE IF NOT EXISTS `tbl_users` (
`id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` timestamp NULL DEFAULT NULL,
  `role` enum('Admin','User') NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_courses`
--
ALTER TABLE `tbl_courses`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_enquiries`
--
ALTER TABLE `tbl_enquiries`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_courses`
--
ALTER TABLE `tbl_courses`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `tbl_enquiries`
--
ALTER TABLE `tbl_enquiries`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
