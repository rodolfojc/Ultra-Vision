-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2019 at 01:25 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ultravision`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `mem_numb` int(11) NOT NULL,
  `mem_type` varchar(50) NOT NULL DEFAULT '0',
  `cust_name` varchar(50) NOT NULL DEFAULT '0',
  `cust_surname` varchar(50) NOT NULL DEFAULT '0',
  `birthday` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `card_type` varchar(50) NOT NULL DEFAULT '0',
  `card_num` varchar(50) NOT NULL DEFAULT '0',
  `card_holder` varchar(50) NOT NULL DEFAULT '0',
  `exp_day` varchar(50) NOT NULL DEFAULT '0',
  `card_cvv` varchar(50) NOT NULL DEFAULT '0',
  `points` int(11) DEFAULT '0',
  `titles_rented` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`mem_numb`, `mem_type`, `cust_name`, `cust_surname`, `birthday`, `email`, `card_type`, `card_num`, `card_holder`, `exp_day`, `card_cvv`, `points`, `titles_rented`) VALUES
(2001, 'Premiun', 'Rodolfo', 'Carvajal', '04/06/1987', 'rodolfo@rodolfo.com', 'Mastercard', '1111222233334444', 'RODOLFO CARVAJAL', '01/25', '123', 40, 0),
(2002, 'MusicLovers', 'Juan', 'Velasquez', '20/01/1989', 'juan@juan.com', 'Mastercard', '4444555566667777', 'JUAN C VELAZQUEZ', '03/24', '696', 10, 0),
(2003, 'VideoLovers', 'Cesar', 'Padron', '05/03/1988', 'cesar@cesar.com', 'Mastercard', '8888999966665555', 'CESAR PARQUE', '12/21', '323', 0, 0),
(2004, 'TvLovers', 'Fernanda', 'Zapata', '14/04/1987', 'fernanda@fernanda.com', 'Visa', '1111333355557777', 'FERNANDA M ZAPATA', '06/25', '543', 10, 0),
(2005, 'VideoLovers', 'Josue', 'Uzcategui', '23/08/1988', 'josue@jusue.com', 'Mastercard', '8888999900005555', 'MR JOSUE UZCATEGUI', '04/25', '356', 0, 0),
(2006, 'TvLovers', 'Enderson', 'Molina', '25/09/1999', 'enderson@enderson.com', 'Visa', '1111444433336666', 'MR ENDERSON T MOLINA', '12/25', '351', 0, 0),
(2007, 'MusicLovers', 'Alisson', 'Steve', '06/06/1952', 'alisson@alisson.com', 'Visa', '1111888877773333', 'MR ALISON STEVE', '08/21', '649', 0, 0),
(2008, 'Premiun', 'Lucy', 'Lagunas', '20/09/1987', 'lucy@lucy.com', 'Mastercard', '7777444400008888', 'LUCY M LAGUNAS', '12/24', '743', 40, 0),
(2009, 'VideoLovers', 'Giada', 'Loquina', '26/01/1989', 'giada@giada.com', 'Visa', '5555999933339999', 'GIADA E LOQUINA', '03/24', '638', 0, 0),
(2010, 'TvLovers', 'Edwin', 'Cantana', '04/12/1985', 'edwin@edwin.com', 'Mastercard', '1111999966663333', 'MR EDWIN CANTANA', '07/23', '325', 0, 0),
(2011, 'Premiun', 'Daniel', 'Medina', '18/05/2019', 'daniel@daniel.com', 'Mastercard', '5199333377775555', 'DANIEL MEDINA', '05/21', '367', 0, 0),
(2012, 'VideoLovers', 'Kevin', 'Villamir', '11/09/1985', 'villamir@villamir.com', 'Mastercard', '5199777744446666', 'MR KEVIN VILLAMIR', '05/22', '854', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `rented`
--

CREATE TABLE `rented` (
  `ref` int(11) NOT NULL,
  `mem_numb` int(11) NOT NULL DEFAULT '0',
  `title_id` int(11) NOT NULL DEFAULT '0',
  `title_format` varchar(50) NOT NULL DEFAULT '0',
  `date` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `paid_eur` int(11) DEFAULT '2'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rented`
--

INSERT INTO `rented` (`ref`, `mem_numb`, `title_id`, `title_format`, `date`, `status`, `paid_eur`) VALUES
(1, 2002, 3, 'cd', '2019-05-09', 'Returned', 0),
(2, 2002, 1, 'cd', '2019-05-09', 'Returned', 0),
(3, 2002, 1, 'cd', '2019-05-09', 'Returned', 0),
(4, 2002, 1, 'cd', '2019-05-09', 'Returned', 0),
(5, 2002, 1, 'cd', '2019-05-09', 'Returned', 0),
(6, 2002, 1, 'cd', '2019-05-09', 'Returned', 0),
(7, 2002, 1, 'cd', '2019-05-09', 'Returned', 0),
(8, 2002, 1, 'cd', '2019-05-09', 'Returned', 2),
(9, 2002, 1, 'cd', '2019-05-09', 'Returned', 2),
(10, 2002, 1, 'cd', '2019-05-09', 'Returned', 2),
(11, 2002, 2, 'cd', '2019-05-09', 'Returned', 2),
(12, 2001, 1, 'cd', '2019-05-09', 'Returned', 2),
(13, 2001, 1, 'cd', '2019-05-09', 'Returned', 2),
(14, 2001, 1, 'cd', '2019-05-09', 'Returned', 2),
(15, 2001, 2, 'cd', '2019-05-09', 'Returned', 2),
(16, 2001, 1, 'cd', '2019-05-09', 'Returned', 2),
(17, 2001, 1, 'cd', '2019-05-09', 'Returned', 2),
(18, 2001, 5, 'blue_ray', '2019-05-09', 'Returned', 2),
(19, 2002, 1, 'cd', '2019-05-09', 'Returned', 2),
(20, 2002, 20, 'blue_ray', '2019-05-09', 'Returned', 2),
(21, 2003, 1, 'cd', '2019-05-09', 'Returned', 2),
(22, 2008, 8, 'blue_ray', '2019-05-09', 'Returned', 2),
(23, 2008, 6, 'dvd', '2019-05-09', 'Returned', 2),
(24, 2008, 4, 'cd', '2019-05-09', 'Returned', 2),
(25, 2008, 6, 'blue_ray', '2019-05-09', 'Returned', 2),
(26, 2001, 1, 'blue_ray', '2019-05-10', 'Returned', 2),
(27, 2001, 3, 'cd', '2019-05-10', 'Returned', 2),
(28, 2001, 15, 'dvd', '2019-05-10', 'Returned', 2),
(29, 2001, 10, 'dvd', '2019-05-10', 'Returned', 2);

-- --------------------------------------------------------

--
-- Table structure for table `titles`
--

CREATE TABLE `titles` (
  `id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `title_name` varchar(50) NOT NULL,
  `year_rel` varchar(50) NOT NULL,
  `album` varchar(50) DEFAULT 'N/A',
  `genre` varchar(50) DEFAULT 'N/A',
  `band` varchar(50) DEFAULT 'N/A',
  `director` varchar(50) DEFAULT 'N/A',
  `runn_time` varchar(50) DEFAULT 'N/A',
  `lang` varchar(50) DEFAULT 'N/A',
  `country` varchar(50) DEFAULT 'N/A',
  `cd` varchar(50) DEFAULT 'N/A',
  `dvd` varchar(50) DEFAULT 'N/A',
  `blue_ray` varchar(50) DEFAULT 'N/A'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `titles`
--

INSERT INTO `titles` (`id`, `type`, `title_name`, `year_rel`, `album`, `genre`, `band`, `director`, `runn_time`, `lang`, `country`, `cd`, `dvd`, `blue_ray`) VALUES
(1, 'AudioMusic', 'Give Life Back To Music', '2013', 'Randen Lives Morning', 'Electronica', 'Daft Punk', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'N/A', 'Yes'),
(2, 'AudioMusic', 'Mountain Music', '1982', 'Alabama', 'Country', 'Alabama', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'N/A', 'N/A'),
(3, 'AudioMusic', 'Play That Funky Music ', '1987', 'Wild Cherry', 'Funk', 'Wild Cherry', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'N/A', 'N/A'),
(4, 'AudioMusic', 'Don’t Stop The Music', '2007', 'Good girl gone bad', 'Dance Pop ', 'Rihanna', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'N/A', 'N/A'),
(5, 'AudioMusic', 'This Is Country Music', '2010', 'My Country', 'Country', 'Brad Paisley', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'N/A', 'Yes'),
(6, 'ConcertVideo', 'Leeny Kravitz ', '1999', 'Lollapooza', 'Regge', 'Leeny Kravitz ', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'Yes'),
(7, 'ConcertVideo', 'Red Hot Cilli Peppers Live', '2018', 'Lollapooza', 'Rock', 'Red Hot Cilli Peppers', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'No'),
(8, 'ConcertVideo', 'Rihanna - Live at Rock in Rio Janeriro', '2016', 'Rio Janeiro - Brazil', 'Rock', 'Rihanna', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', 'No', 'Yes'),
(9, 'ConcertVideo', 'Metallica - WorldWired North America', '2017', 'North America Tour', 'Rock', 'Metallica', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'Yes'),
(10, 'ConcertVideo', 'Soda Sterio - MTV Unplugged ', '1996', 'MTV Unplugged', 'Latin Rock', 'Soda Stereo', 'N/A', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'No'),
(11, 'Movie', 'Harry Potter and the Chamber of Secrets', '2002 ', 'N/A', 'Fantasy', 'N/A', 'Chris Columbus', '161 min', 'English', 'United Kingdom, United States', 'N/A', 'No', 'Yes'),
(12, 'Movie', 'The Boy in the Striped Pyjamas', '2008', 'N/A', 'Historical drama', 'N/A', 'Mark Herman', '94 min', 'English', 'United Kingdom, United States', 'N/A', 'Yes', 'No'),
(13, 'Movie', 'Black Panther', '2018', 'N/A', 'Superhero', 'N/A', 'Ryan Coogler', '134 min', 'English', 'United States', 'N/A', 'Yes', 'Yes'),
(14, 'Movie', 'A Star Is Born', '2018', 'N/A', 'Musical Romantic ', 'N/A', 'Bradley Cooper', '135 min', 'English', 'United States', 'N/A', 'No', 'Yes'),
(15, 'Movie', 'Prayers for Bobby', '2009', 'N/A', 'Docudrama', 'N/A', 'Russell Mulcahy', '89 min', 'English', 'United States', 'N/A', 'Yes', 'No'),
(16, 'Movie', 'The Lord of the Rings: The Fellowship of the Ring', '2001', 'N/A', 'Epic fantasy adventure', 'N/A', 'Peter Jackson', '178 min', 'English', 'New Zealand, United States', 'N/A', 'Yes', 'No'),
(17, 'BoxSet', 'Black Mirror - Session 1', '2011', 'N/A', 'Science fiction', 'N/A', 'Charlie Brooker', '41 - 89 min', 'English', 'United Kingdom', 'N/A', 'Yes', 'Yes'),
(18, 'BoxSet', 'The Sinner - Session 1', '2017', 'N/A', 'Crime drama', 'N/A', 'Ronit Kirchman', '40 - 46 min', 'English', 'United States', 'N/A', 'Yes', 'No'),
(19, 'BoxSet', 'Grey\'s Anatomy', '2005', 'N/A', 'Medical drama', 'N/A', 'Ann Kindberg, Austin Guzman', '43 min', 'English', 'United States', 'N/A', 'Yes', 'No'),
(20, 'BoxSet', 'Breaking Bad - Session 1', '2008', 'N/A', 'Crime drama', 'N/A', 'Dave Porter', '43 - 58 min', 'English, Spanish', 'United States', 'N/A', 'Yes', 'Yes'),
(21, 'AudioMusic', 'Caramelos De Cianuro', '2001', 'Reissue', 'Electronic Rock, Pop', 'Caramelos De Cianuro', 'N/A', 'N/A', 'N/A', 'N/A', 'Yes', 'N/A', 'N/A'),
(22, 'BoxSet', 'Game of Thrones I', '2010', 'N/A', 'Fantasy Serial Drama', 'N/A', 'David Benioff', '50–82 minutes', 'English', 'United States', 'N/A', 'Yes', 'No');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`mem_numb`);

--
-- Indexes for table `rented`
--
ALTER TABLE `rented`
  ADD PRIMARY KEY (`ref`),
  ADD KEY `mem_numb` (`mem_numb`),
  ADD KEY `title_id` (`title_id`);

--
-- Indexes for table `titles`
--
ALTER TABLE `titles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `mem_numb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2013;

--
-- AUTO_INCREMENT for table `rented`
--
ALTER TABLE `rented`
  MODIFY `ref` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `titles`
--
ALTER TABLE `titles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rented`
--
ALTER TABLE `rented`
  ADD CONSTRAINT `mem_numb` FOREIGN KEY (`mem_numb`) REFERENCES `customers` (`mem_numb`),
  ADD CONSTRAINT `title_id` FOREIGN KEY (`title_id`) REFERENCES `titles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
