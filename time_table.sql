-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Ápr 26. 00:43
-- Kiszolgáló verziója: 10.4.22-MariaDB
-- PHP verzió: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `time_table`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `class`
--

CREATE TABLE `class` (
  `CLASS_ID` int(3) NOT NULL,
  `cname` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `class`
--

INSERT INTO `class` (`CLASS_ID`, `cname`) VALUES
(1, '9'),
(2, '10'),
(3, '11'),
(5, '13'),
(6, '14'),
(9, '12');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `classroom`
--

CREATE TABLE `classroom` (
  `DOORNUMBER_ID` int(3) NOT NULL,
  `door` varchar(10) NOT NULL,
  `space` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `classroom`
--

INSERT INTO `classroom` (`DOORNUMBER_ID`, `door`, `space`) VALUES
(3, '103', 12),
(4, '104', 20),
(5, '105', 30),
(6, '106', 30),
(17, '222', 10),
(20, '441', 10);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `student`
--

CREATE TABLE `student` (
  `OMA_STUDENT` bigint(12) NOT NULL,
  `name` varchar(50) NOT NULL,
  `CLASS_ID` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `student`
--

INSERT INTO `student` (`OMA_STUDENT`, `name`, `CLASS_ID`) VALUES
(65142536123, 'András Béla', 5),
(71236548832, 'Endre Lovas', 9),
(71745184654, 'Dóra Borsos', 5),
(72843281438, 'Gréta Gulyás', 1),
(73187328417, 'Levente Diósi', 3),
(73463232163, 'Szeder Bokor', 3),
(73491265832, 'Ervin Sün', 5),
(73492743982, 'Emma Szűcs', 1),
(73561284356, 'Bence Hadas', 9),
(74529465712, 'Iván Szirtes', 6),
(74532973481, 'Lukács Nagy', 1),
(74533821437, 'György Gyurma', 9),
(74546397542, 'Ábel Álmos', 6),
(74592264825, 'Ádám Palik', 5),
(74592347582, 'Lilla Péntek ', 6),
(74620981723, 'Gábor Jónás', 3),
(75346621023, 'Péter Nagy', 2),
(75346621100, 'Péter Kiss', 2),
(75346621111, 'János Kiss', 2),
(75346621123, 'Péter Kiss', 2),
(75346622123, 'Anna Tóth', 1),
(75346631123, 'Flóra Pataki', 2),
(75346632123, 'László Nagy', 2),
(75346641123, 'Rita Tóth', 3),
(75346642123, 'Kristóf Antal', 3),
(75392548325, 'Sándor Sipos', 6),
(75428465912, 'Péter Csizmadia', 5),
(75492247612, 'Pál Kalap', 1),
(75893658218, 'Gábor Sass', 5),
(75957745931, 'Máté Földes', 9),
(76392711264, 'Julianna Kondás', 6),
(76492548264, 'Bíborka Dalmos', 6),
(76548247619, 'Kitti Kövér', 6),
(76591437654, 'Éva Ádámszky', 9),
(76594365392, 'Lajos Ferenczi', 6),
(76924628524, 'Ottó Hajdú', 1),
(77211625802, 'Csaba Békés', 3),
(77239162831, 'Noémi Németh', 1),
(77865349354, 'Napsugár Felhős', 6),
(78192744281, 'Viola Erdős', 3),
(78392748325, 'Panna Gomb', 9),
(78465923451, 'Titusz Boldog', 6),
(78492332642, 'Virág Cserép', 1),
(79274265432, 'Katalin Virág', 9),
(79347128436, 'Ubul Pillás', 5),
(79456388532, 'Csilla Felhős', 5),
(80046621123, 'Petra Balogh', 2),
(721382935221, 'Károly Reszkető', 9),
(745629462884, 'Béla Csigás', 9);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `subject`
--

CREATE TABLE `subject` (
  `SUBJECT_ID` int(3) NOT NULL,
  `sname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `subject`
--

INSERT INTO `subject` (`SUBJECT_ID`, `sname`) VALUES
(1, 'DATABASE'),
(2, 'IKT'),
(3, 'FPET'),
(4, 'JAVA'),
(5, 'MINYA'),
(6, 'PAAF'),
(7, 'BP'),
(8, 'SZAa'),
(21, 'Matek');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `teacher`
--

CREATE TABLE `teacher` (
  `OMA_TEACHER` bigint(12) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Phone` varchar(12) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Admin` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `teacher`
--

INSERT INTO `teacher` (`OMA_TEACHER`, `Name`, `Phone`, `Password`, `Admin`) VALUES
(71123567012, 'Gábor Huri', '20345123523', 'asdfgh', 1),
(71123567112, 'András Bakti', '06203420711', 'jelszó', 0),
(71123567212, 'Ákos Szabó', '0620312312', 'adsfas', 0),
(71123567312, 'Tamás Inántsy-Pap', '+36206789123', 'jelszó', 0),
(71123567412, 'Edit Vaszil', '+36207891234', 'jelszó', 0),
(71123567512, 'Zoltán Csapó', '+36208912345', 'jelszó', 0);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `teachersubject`
--

CREATE TABLE `teachersubject` (
  `SUBJECT_TEACHER_ID` int(11) NOT NULL,
  `SUBJECT_ID` int(3) NOT NULL,
  `OMA_TEACHER` bigint(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `teachersubject`
--

INSERT INTO `teachersubject` (`SUBJECT_TEACHER_ID`, `SUBJECT_ID`, `OMA_TEACHER`) VALUES
(1, 1, 71123567012),
(2, 2, 71123567112),
(4, 2, 71123567312),
(13, 3, 71123567012),
(3, 3, 71123567212),
(12, 4, 71123567012),
(8, 4, 71123567212),
(6, 5, 71123567512),
(14, 5, 71123567512),
(10, 7, 71123567212),
(5, 8, 71123567412),
(15, 8, 71123567412);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `timetable`
--

CREATE TABLE `timetable` (
  `TIMETABLE_ID` int(3) NOT NULL,
  `SUBJECT_TEACHER_ID` int(3) NOT NULL,
  `CLASS_ID` int(3) NOT NULL,
  `DOORNUMBER_ID` int(3) NOT NULL,
  `day` varchar(10) NOT NULL,
  `lesson` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `timetable`
--

INSERT INTO `timetable` (`TIMETABLE_ID`, `SUBJECT_TEACHER_ID`, `CLASS_ID`, `DOORNUMBER_ID`, `day`, `lesson`) VALUES
(1, 1, 5, 5, 'Monday', 1),
(2, 2, 6, 6, 'Monday', 1),
(3, 3, 5, 5, 'Monday', 2),
(4, 2, 5, 5, 'Monday', 3),
(5, 1, 5, 5, 'Tuesday', 1),
(6, 2, 6, 6, 'Tuesday', 1),
(9, 1, 5, 5, 'Wednesday', 1),
(10, 2, 6, 6, 'Wednesday', 1),
(11, 3, 5, 5, 'Wednesday', 2),
(12, 2, 5, 5, 'Wednesday', 3),
(13, 13, 2, 3, 'Monday', 2),
(14, 13, 2, 3, 'Monday', 3),
(15, 12, 6, 17, 'Monday', 4),
(16, 12, 6, 17, 'Monday', 5),
(17, 1, 1, 4, 'Monday', 6),
(18, 1, 5, 5, 'Tuesday', 2),
(19, 12, 3, 17, 'Tuesday', 3),
(20, 12, 3, 17, 'Tuesday', 4),
(21, 13, 9, 3, 'Wednesday', 2),
(22, 13, 9, 3, 'Wednesday', 3),
(23, 13, 9, 3, 'Wednesday', 4),
(24, 1, 2, 6, 'Thursday', 1),
(25, 1, 2, 6, 'Thursday', 2),
(26, 12, 1, 4, 'Thursday', 3),
(27, 12, 1, 4, 'Thursday', 4),
(28, 12, 3, 6, 'Friday', 1),
(29, 12, 3, 6, 'Friday', 2),
(32, 6, 5, 20, 'Monday', 4),
(33, 3, 5, 5, 'Monday', 5),
(34, 6, 5, 3, 'Monday', 6),
(35, 8, 5, 5, 'Tuesday', 3),
(36, 10, 5, 6, 'Tuesday', 4),
(37, 5, 5, 3, 'Tuesday', 5),
(38, 2, 5, 20, 'Tuesday', 6),
(39, 15, 5, 4, 'Tuesday', 7),
(40, 6, 5, 6, 'Wednesday', 4),
(41, 6, 5, 6, 'Wednesday', 5),
(42, 8, 5, 20, 'Wednesday', 6),
(43, 8, 5, 17, 'Thursday', 1),
(44, 8, 5, 17, 'Thursday', 2),
(45, 8, 5, 17, 'Thursday', 3),
(46, 2, 5, 3, 'Thursday', 4),
(47, 10, 5, 4, 'Thursday', 5),
(48, 4, 5, 5, 'Thursday', 6),
(49, 2, 5, 5, 'Friday', 1),
(50, 2, 5, 5, 'Friday', 2),
(51, 5, 5, 20, 'Friday', 3),
(52, 10, 5, 3, 'Friday', 4),
(53, 2, 5, 3, 'Wednesday', 7),
(54, 2, 5, 3, 'Wednesday', 8),
(55, 10, 5, 6, 'Friday', 5);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`CLASS_ID`);

--
-- A tábla indexei `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`DOORNUMBER_ID`);

--
-- A tábla indexei `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`OMA_STUDENT`),
  ADD KEY `CLASS_ID` (`CLASS_ID`);

--
-- A tábla indexei `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`SUBJECT_ID`);

--
-- A tábla indexei `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`OMA_TEACHER`);

--
-- A tábla indexei `teachersubject`
--
ALTER TABLE `teachersubject`
  ADD PRIMARY KEY (`SUBJECT_TEACHER_ID`),
  ADD KEY `SUBJECT_ID` (`SUBJECT_ID`,`OMA_TEACHER`),
  ADD KEY `OMA_TEACHER` (`OMA_TEACHER`);

--
-- A tábla indexei `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`TIMETABLE_ID`),
  ADD KEY `SUBJECT_TEACHER_ID` (`SUBJECT_TEACHER_ID`,`CLASS_ID`,`DOORNUMBER_ID`),
  ADD KEY `DOORNUMBER_ID` (`DOORNUMBER_ID`),
  ADD KEY `CLASS_ID` (`CLASS_ID`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `class`
--
ALTER TABLE `class`
  MODIFY `CLASS_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT a táblához `classroom`
--
ALTER TABLE `classroom`
  MODIFY `DOORNUMBER_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT a táblához `subject`
--
ALTER TABLE `subject`
  MODIFY `SUBJECT_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT a táblához `teachersubject`
--
ALTER TABLE `teachersubject`
  MODIFY `SUBJECT_TEACHER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT a táblához `timetable`
--
ALTER TABLE `timetable`
  MODIFY `TIMETABLE_ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`CLASS_ID`) REFERENCES `class` (`CLASS_ID`) ON UPDATE CASCADE;

--
-- Megkötések a táblához `teachersubject`
--
ALTER TABLE `teachersubject`
  ADD CONSTRAINT `teachersubject_ibfk_1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `subject` (`SUBJECT_ID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `teachersubject_ibfk_2` FOREIGN KEY (`OMA_TEACHER`) REFERENCES `teacher` (`OMA_TEACHER`) ON UPDATE CASCADE;

--
-- Megkötések a táblához `timetable`
--
ALTER TABLE `timetable`
  ADD CONSTRAINT `timetable_ibfk_1` FOREIGN KEY (`DOORNUMBER_ID`) REFERENCES `classroom` (`DOORNUMBER_ID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `timetable_ibfk_2` FOREIGN KEY (`CLASS_ID`) REFERENCES `class` (`CLASS_ID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `timetable_ibfk_3` FOREIGN KEY (`SUBJECT_TEACHER_ID`) REFERENCES `teachersubject` (`SUBJECT_TEACHER_ID`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
