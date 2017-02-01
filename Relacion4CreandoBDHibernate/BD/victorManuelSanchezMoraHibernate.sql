
-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 01, 2017 at 07:40 AM
-- Server version: 10.0.28-MariaDB
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `u329292900_proye`
--

-- --------------------------------------------------------

--
-- Table structure for table `Director`
--

CREATE TABLE IF NOT EXISTS `Director` (
  `ID_DIRECTOR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  PRIMARY KEY (`ID_DIRECTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Cliente`
--

CREATE TABLE IF NOT EXISTS `Cliente` (
  `ID_CLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DIRECCION` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `FECHA_INSCRIPCION` date NOT NULL,
  `EDAD` date NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Pelicula`
--

CREATE TABLE IF NOT EXISTS `Pelicula` (
  `ID_PELICULA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO` int(11) NOT NULL,
  `FECHA_EDICION` date NOT NULL,
  `DESCRIPCION` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ID_DIRECTOR` int(11) NOT NULL,
  PRIMARY KEY (`ID_PELICULA`),
  FOREIGN KEY (`ID_DIRECTOR`) REFERENCES `Director` (`ID_DIRECTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

-- --------------------------------------------------------

--
-- Table structure for table `Alquila`
--

CREATE TABLE IF NOT EXISTS `Alquila` (
  `ID_ALQUILA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_CLIENTE` int(11) NOT NULL,
  `ID_PELICULA` int(11) NOT NULL,
  `FECHA_ALQUILADA` date NOT NULL,
  PRIMARY KEY (`ID_ALQUILA`),
  FOREIGN KEY (`ID_CLIENTE`) REFERENCES `Cliente`(`ID_CLIENTE`),
  FOREIGN KEY (`ID_PELICULA`) REFERENCES `Pelicula`(`ID_PELICULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

-- --------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
