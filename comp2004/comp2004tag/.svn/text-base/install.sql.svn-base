-- phpMyAdmin SQL Dump
-- version 2.11.11.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 24, 2011 at 04:39 AM
-- Server version: 5.0.77
-- PHP Version: 5.1.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

SET AUTOCOMMIT=0;
START TRANSACTION;

--
-- Database: `db_tag1g09`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `currentstudents`
--
DROP VIEW IF EXISTS `currentstudents`;
CREATE TABLE IF NOT EXISTS `currentstudents` (
`id` int(10) unsigned
,`name` varchar(255)
,`dateOfBirth` date
,`gender` enum('male','female')
,`email` varchar(255)
,`status` enum('current','suspended','left')
);
-- --------------------------------------------------------

--
-- Table structure for table `ds_exams`
--
-- Creation: Mar 23, 2011 at 09:11 PM
--

DROP TABLE IF EXISTS `ds_exams`;
CREATE TABLE IF NOT EXISTS `ds_exams` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `malestudentid` int(10) unsigned NOT NULL,
  `femalestudentid` int(10) unsigned NOT NULL,
  `date` date NOT NULL,
  `mark` tinyint(3) unsigned NOT NULL,
  `level` enum('gold','silver','bronze') character set utf8 collate utf8_unicode_ci NOT NULL,
  `kind` enum('ballroom','latin') character set utf8 collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `malestudentid` (`malestudentid`,`femalestudentid`),
  KEY `femalestudentid` (`femalestudentid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `ds_exams`
--

INSERT INTO `ds_exams` (`id`, `malestudentid`, `femalestudentid`, `date`, `mark`, `level`, `kind`) VALUES
(1, 1, 2, '2011-03-21', 100, 'gold', 'ballroom'),
(2, 1, 2, '2011-02-27', 80, 'gold', 'ballroom'),
(3, 3, 2, '2011-02-27', 40, 'silver', 'ballroom'),
(4, 3, 2, '2011-02-27', 40, 'silver', 'ballroom'),
(5, 3, 2, '2011-02-27', 42, 'silver', 'ballroom'),
(6, 3, 2, '2011-02-27', 42, 'silver', 'ballroom'),
(7, 1, 2, '2011-03-11', 100, 'gold', 'ballroom'),
(8, 1, 2, '2011-03-11', 100, 'bronze', 'ballroom');

-- --------------------------------------------------------

--
-- Table structure for table `ds_payments`
--
-- Creation: Mar 23, 2011 at 08:42 PM
--

DROP TABLE IF EXISTS `ds_payments`;
CREATE TABLE IF NOT EXISTS `ds_payments` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `student` int(10) unsigned NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `type` enum('cash','visa','mastercard') character set utf8 collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `student` (`student`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `ds_payments`
--

INSERT INTO `ds_payments` (`id`, `student`, `amount`, `type`) VALUES
(1, 3, 50.02, 'cash'),
(2, 3, 50.02, 'cash'),
(3, 3, 50.02, 'cash'),
(4, 3, 50.02, 'cash'),
(5, 3, 50.02, 'cash'),
(6, 1, 50.02, 'cash'),
(7, 1, 50.02, 'cash'),
(8, 1, 50.02, 'cash');

-- --------------------------------------------------------

--
-- Table structure for table `ds_students`
--
-- Creation: Mar 23, 2011 at 08:43 PM
--

DROP TABLE IF EXISTS `ds_students`;
CREATE TABLE IF NOT EXISTS `ds_students` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL,
  `dateOfBirth` date NOT NULL,
  `gender` enum('male','female') character set utf8 collate utf8_unicode_ci NOT NULL,
  `email` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL,
  `status` enum('current','suspended','left') character set utf8 collate utf8_unicode_ci NOT NULL default 'current',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `ds_students`
--

INSERT INTO `ds_students` (`id`, `name`, `dateOfBirth`, `gender`, `email`, `status`) VALUES
(1, 'Thomas Grainger', '1991-02-27', 'male', 'tagrain@gmail.com', 'left'),
(2, 'Amblina Wright', '1991-10-25', 'female', 'el.numbre@gmail.com', 'left'),
(3, 'Maximillion Power', '2012-12-12', 'male', 'boring@gmail.com', 'current'),
(4, 'Dan Palmer', '1991-03-12', 'male', 'danplmr@gmail.com', 'current'),
(5, 'asd', '1991-03-12', 'male', 'test@gmail.com', 'current'),
(6, 'OR 1 = 1;--', '1991-02-27', 'male', 'barrychuckle@gmail.com', 'current'),
(7, 'Mathew Power', '1900-01-12', 'male', 'mth.power@gmail.com', 'current');

-- --------------------------------------------------------

--
-- Stand-in structure for view `leftstudents`
--
DROP VIEW IF EXISTS `leftstudents`;
CREATE TABLE IF NOT EXISTS `leftstudents` (
`id` int(10) unsigned
,`name` varchar(255)
,`dateOfBirth` date
,`gender` enum('male','female')
,`email` varchar(255)
,`status` enum('current','suspended','left')
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `suspendedstudents`
--
DROP VIEW IF EXISTS `suspendedstudents`;
CREATE TABLE IF NOT EXISTS `suspendedstudents` (
`id` int(10) unsigned
,`name` varchar(255)
,`dateOfBirth` date
,`gender` enum('male','female')
,`email` varchar(255)
,`status` enum('current','suspended','left')
);
-- --------------------------------------------------------

--
-- Structure for view `currentstudents`
--
DROP TABLE IF EXISTS `currentstudents`;

CREATE ALGORITHM=UNDEFINED DEFINER=`tag1g09`@`localhost` SQL SECURITY DEFINER VIEW `db_tag1g09`.`currentstudents` AS select `db_tag1g09`.`ds_students`.`id` AS `id`,`db_tag1g09`.`ds_students`.`name` AS `name`,`db_tag1g09`.`ds_students`.`dateOfBirth` AS `dateOfBirth`,`db_tag1g09`.`ds_students`.`gender` AS `gender`,`db_tag1g09`.`ds_students`.`email` AS `email`,`db_tag1g09`.`ds_students`.`status` AS `status` from `db_tag1g09`.`ds_students` where (`db_tag1g09`.`ds_students`.`status` = _utf8'current');

-- --------------------------------------------------------

--
-- Structure for view `leftstudents`
--
DROP TABLE IF EXISTS `leftstudents`;

CREATE ALGORITHM=UNDEFINED DEFINER=`tag1g09`@`localhost` SQL SECURITY DEFINER VIEW `db_tag1g09`.`leftstudents` AS select `db_tag1g09`.`ds_students`.`id` AS `id`,`db_tag1g09`.`ds_students`.`name` AS `name`,`db_tag1g09`.`ds_students`.`dateOfBirth` AS `dateOfBirth`,`db_tag1g09`.`ds_students`.`gender` AS `gender`,`db_tag1g09`.`ds_students`.`email` AS `email`,`db_tag1g09`.`ds_students`.`status` AS `status` from `db_tag1g09`.`ds_students` where (`db_tag1g09`.`ds_students`.`status` = _utf8'left');

-- --------------------------------------------------------

--
-- Structure for view `suspendedstudents`
--
DROP TABLE IF EXISTS `suspendedstudents`;

CREATE ALGORITHM=UNDEFINED DEFINER=`tag1g09`@`localhost` SQL SECURITY DEFINER VIEW `db_tag1g09`.`suspendedstudents` AS select `db_tag1g09`.`ds_students`.`id` AS `id`,`db_tag1g09`.`ds_students`.`name` AS `name`,`db_tag1g09`.`ds_students`.`dateOfBirth` AS `dateOfBirth`,`db_tag1g09`.`ds_students`.`gender` AS `gender`,`db_tag1g09`.`ds_students`.`email` AS `email`,`db_tag1g09`.`ds_students`.`status` AS `status` from `db_tag1g09`.`ds_students` where (`db_tag1g09`.`ds_students`.`status` = _utf8'suspended');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ds_exams`
--
ALTER TABLE `ds_exams`
  ADD CONSTRAINT `ds_exams_ibfk_1` FOREIGN KEY (`malestudentid`) REFERENCES `ds_students` (`id`),
  ADD CONSTRAINT `ds_exams_ibfk_2` FOREIGN KEY (`femalestudentid`) REFERENCES `ds_students` (`id`);

--
-- Constraints for table `ds_payments`
--
ALTER TABLE `ds_payments`
  ADD CONSTRAINT `ds_payments_ibfk_1` FOREIGN KEY (`student`) REFERENCES `ds_students` (`id`) ON DELETE CASCADE;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `addExam`$$
CREATE DEFINER=`tag1g09`@`localhost` PROCEDURE `addExam`(IN p_studenta int(10), IN p_studentb int(10), IN p_date date, IN p_mark tinyint(3), IN p_level enum('gold', 'silver', 'bronze'), IN p_kind enum('ballroom', 'latin'))
BEGIN
DECLARE studentagender enum('male','female');
DECLARE studentbgender enum('male','female');
DECLARE success BOOL;

SET studentagender = (SELECT gender FROM ds_students WHERE id = p_studenta);
SET studentbgender = (SELECT gender FROM ds_students WHERE id = p_studentb);
SET success = 1;

IF ((studentagender = 'female') AND (studentbgender = 'male')) THEN
	INSERT INTO ds_exams
	(
			`malestudentid`,
			`femalestudentid`,
			`date`,
			`mark`,
			`level`,
			`kind`
	)
	VALUES 
	(
		p_studentb,
		p_studenta,
		p_date,
		p_mark,
		p_level,
		p_kind
	);
	ELSEIF ((studentagender = 'male') AND (studentbgender = 'female')) THEN 
	INSERT INTO ds_exams
	(
			`malestudentid`,
			`femalestudentid`,
			`date`,
			`mark`,
			`level`,
			`kind`
	)
	VALUES 
	(
		p_studenta,
		p_studentb,
		p_date,
		p_mark,
		p_level,
		p_kind
	);
	ELSE SET success = 0;
END IF;
SELECT success;
END$$

DELIMITER ;

COMMIT;
