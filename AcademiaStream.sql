create database AcademiaStream;
use AcademiaStream;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `AcademiaStream`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignment`
--

CREATE TABLE `assignment` (
  `assignment_no` int(2) NOT NULL,
  `st_id` varchar(10) NOT NULL,
  `course_title` varchar(20) NOT NULL,
  `marks` float NOT NULL,
  `Total_marks` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `assignment`
  CHANGE COLUMN `assignment_no` `id` INT(2) NOT NULL,
  CHANGE COLUMN `st_id` `std_id` VARCHAR(10) NOT NULL,
  CHANGE COLUMN `course_title` `course_id` VARCHAR(10) NOT NULL;
--
-- Dumping data for table `assignment`
--

INSERT INTO `assignment` (`assignment_no`, `st_id`, `course_title`, `marks`, `Total_marks`) VALUES
(1, '15', 'CS101', 12, 50),
(2, '10', 'CS101', 70, 100),
(3, '13', 'CS101', 80, 100),
(4, '15', 'CS101', 60, 100);

-- --------------------------------------------------------

--
-- Table structure for table `attendence`
--

CREATE TABLE `attendence` (
  `st_id` varchar(20) NOT NULL,
  `cs_id` varchar(20) NOT NULL,
  `lecture_no` int(20) NOT NULL,
  `date` varchar(20) DEFAULT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `presence` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendence`
--

INSERT INTO `attendence` (`st_id`, `cs_id`, `lecture_no`, `date`, `duration`, `presence`) VALUES
('15', 'CS101', 6, '10/11/2019', '1:30', 'P'),
('15', 'CS101', 12, 'null', '1:30', 'A'),
('15', 'CS101', 90, '12/11/2019', '1:30', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cName` varchar(255) DEFAULT NULL,
  `code` varchar(5) DEFAULT NULL,
  `cHrs` int(4) DEFAULT NULL,
  `aTeacher` varchar(11) DEFAULT NULL,
  `preReq` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `semester` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`cName`, `code`, `cHrs`, `aTeacher`, `preReq`, `type`, `semester`) VALUES
('ITC', 'CS101', 3, 'Ahsan', '0', 'CORE', 1),
('Probably & Statistics', 'MT201', 4, 'Ahsan', 'None', 'CORE', 5),
('Calculus-I', 'MT101', 3, 'Kashif', 'None', 'CORE', 1),
('Algorithm', 'CS108', 3, 'Usman', 'CS101', 'CORE', 5),
('Web Programming', 'CS901', 3, 'Usman', 'CS108', 'ELECTIVE', 6),
('Data Structires', 'CS309', 3, 'Ahsan', 'CS108', 'CORE', 5);

-- --------------------------------------------------------

--
-- Table structure for table `fee`
--

CREATE TABLE `fee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fee`
--

INSERT INTO `fee` (`amount`, `date`) VALUES
(7400, '2019-12-10');

-- --------------------------------------------------------

--
-- Table structure for table `feedetails`
--

CREATE TABLE `feedetails` (
  `id` int(11) NOT NULL,
  `chalanno` int(11) DEFAULT NULL,
  `sID` int(11) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `cHrs` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final`
--

CREATE TABLE `final` (
  `final_no` int(2) NOT NULL,
  `st_id` varchar(10) NOT NULL,
  `course_title` varchar(20) NOT NULL,
  `marks` float NOT NULL,
  `Total_marks` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `final`
  CHANGE COLUMN `final_no` `id` INT(2) NOT NULL,
  CHANGE COLUMN `st_id` `std_id` VARCHAR(10) NOT NULL,
  CHANGE COLUMN `course_title` `course_id` VARCHAR(10) NOT NULL;
  select * from sessional;
--
-- Dumping data for table `final`
--

INSERT INTO `final` (`final_no`, `st_id`, `course_title`, `marks`, `Total_marks`) VALUES
(1, '15', 'cs101', 40, 50);

-- --------------------------------------------------------
select * from courses
--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `project_no` int(2) NOT NULL,
  `st_id` varchar(10) NOT NULL,
  `course_title` varchar(20) NOT NULL,
  `marks` varchar(20) NOT NULL,
  `Total_marks` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `project`
  CHANGE COLUMN `project_no` `id` INT(2) NOT NULL,
  CHANGE COLUMN `st_id` `std_id` VARCHAR(10) NOT NULL,
  CHANGE COLUMN `course_title` `course_id` VARCHAR(10) NOT NULL;
-- --------------------------------------------------------

--
-- Table structure for table `quiz`
--

CREATE TABLE `quiz` (
  `Qno` int(2) NOT NULL,
  `st_id` varchar(10) NOT NULL,
  `course_title` varchar(20) NOT NULL,
  `marks` float NOT NULL,
  `Total_marks` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `quiz`
  CHANGE COLUMN `Qno` `id` INT(2) NOT NULL,
  CHANGE COLUMN `st_id` `std_id` VARCHAR(10) NOT NULL,
  CHANGE COLUMN `course_title` `course_id` VARCHAR(20) NOT NULL;
--
-- Dumping data for table `quiz`
--

-- INSERT INTO `quiz` (`Qno`, `st_id`, `course_title`, `marks`, `Total_marks`) VALUES
-- (1, '10', 'CS101', 6, 10),
-- (1, '13', 'CS101', 9, 10),
-- (1, '15', '8', 198, 200),
-- (1, '15', '8', 8, 10),
-- (2, '15', '8', 9, 10);
-- drop table quiz;
-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cID` int(4) DEFAULT NULL,
  `sID` int(4) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`cID`, `sID`) VALUES
(8, 15),
(8, 13),
(9, 13),
(1, 15),
(10, 13),
(6, 13);

-- --------------------------------------------------------

--
-- Table structure for table `sessional`
--

CREATE TABLE `sessional` (
  `sessional_no` int(2) NOT NULL,
  `st_id` varchar(10) NOT NULL,
  `course_title` varchar(20) NOT NULL,
  `marks` float NOT NULL,
  `Total_marks` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
ALTER TABLE `sessional`
  CHANGE COLUMN `sessional_no` `id` INT(2) NOT NULL,
  CHANGE COLUMN `st_id` `std_id` VARCHAR(10) NOT NULL,
  CHANGE COLUMN `course_title` `course_id` VARCHAR(10) NOT NULL;
--
--
-- Dumping data for table `sessional`
--

INSERT INTO `sessional` (`sessional_no`, `st_id`, `course_title`, `marks`, `Total_marks`) VALUES
(1, '15', '8', 41, 50),
(2, '13', '8', 70, 100);

-- --------------------------------------------------------

--
-- Table structure for table `trans`
--

CREATE TABLE `trans` (
  `st_id` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `cs_id` varchar(30) NOT NULL,
  `crs_name` varchar(40) NOT NULL,
  `crd_hr` int(3) NOT NULL,
  `type` varchar(10) NOT NULL,
  `sm_id` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trans`
--

INSERT INTO `trans` (`st_id`, `name`, `cs_id`, `crs_name`, `crd_hr`, `type`, `sm_id`) VALUES
('15', 'Ahsan', 'CS101', 'ITC', 3, 'CORE', '1'),
('15', 'Ahsan', 'MT101', 'Calculas-1', 3, 'CORE', '1'),
('15', 'Ahsan', 'CL101', 'ITC-Lab', 1, 'CORE', '1'),
('15', 'Ahsan', 'SS111', 'Islamyat', 3, 'CORE', '1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FName` varchar(50) DEFAULT NULL,
  `LName` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Dumping data for table `users`
--
INSERT INTO `users` (`FName`, `LName`, `username`, `password`, `type`, `address`, `dob`, `gender`) VALUES
('Qasim', 'Ali', 'qasim', '123', 'STUDENT', NULL, NULL, NULL),
('Amna', 'Hassan', 'Amna', 'asdf', 'ADMIN', NULL, NULL, NULL),
('Muhammad', 'Bilal', 'bilal', 'asd', 'STUDENT', NULL, NULL, NULL),
('Ahsan', 'Khan', 'ahsan', 'asd', 'FACULTY', NULL, NULL, NULL);


--
-- Indexes for table `assignment`
--
ALTER TABLE `assignment`
  ADD PRIMARY KEY (`assignment_no`,`st_id`,`course_title`);

--
-- Indexes for table `attendence`
--
ALTER TABLE `attendence`
  ADD PRIMARY KEY (`st_id`,`cs_id`,`lecture_no`);

--
-- Indexes for table `fee`
--
ALTER TABLE `fee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedetails`
--
ALTER TABLE `feedetails`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `final`
--
ALTER TABLE `final`
  ADD PRIMARY KEY (`final_no`,`st_id`,`course_title`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`project_no`,`st_id`,`course_title`);

--
-- Indexes for table `quiz`
--
ALTER TABLE `quiz`
  ADD PRIMARY KEY (`Qno`,`st_id`,`course_title`);

--
-- Indexes for table `sessional`
--
ALTER TABLE `sessional`
  ADD PRIMARY KEY (`sessional_no`,`st_id`,`course_title`);

--
-- AUTO_INCREMENT for table `fee`
--
ALTER TABLE `fee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `feedetails`
--
ALTER TABLE `feedetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `registration`
--
ALTER TABLE `registration`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
