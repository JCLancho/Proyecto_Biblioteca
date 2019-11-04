-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 04-11-2019 a las 09:15:31
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `PROYECTO`
--
CREATE DATABASE IF NOT EXISTS `PROYECTO` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `PROYECTO`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ALUMNO`
--

DROP TABLE IF EXISTS `ALUMNO`;
CREATE TABLE `ALUMNO` (
  `DNI` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `NOMBRE` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `APELLIDO1` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `APELLIDO2` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `ALUMNO`
--

INSERT INTO `ALUMNO` (`DNI`, `NOMBRE`, `APELLIDO1`, `APELLIDO2`) VALUES
('11111111A', 'JoseCarlos', 'Lancho', 'Martin'),
('22222222B', 'Rodrigo', 'Alonso', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LIBRO`
--

DROP TABLE IF EXISTS `LIBRO`;
CREATE TABLE `LIBRO` (
  `ISBN` varchar(13) COLLATE latin1_spanish_ci NOT NULL,
  `TITULO` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `AUTOR` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `EDITORIAL` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ASIGNATURA` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ESTADO` varchar(1) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PRESTAMO`
--

DROP TABLE IF EXISTS `PRESTAMO`;
CREATE TABLE `PRESTAMO` (
  `ALUMNO` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `LIBRO` varchar(13) COLLATE latin1_spanish_ci NOT NULL,
  `FECHAPRESTAMO` date NOT NULL,
  `FECHADEVOLUCION` date NOT NULL,
  `ESTADO` varchar(1) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ALUMNO`
--
ALTER TABLE `ALUMNO`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `LIBRO`
--
ALTER TABLE `LIBRO`
  ADD PRIMARY KEY (`ISBN`);

--
-- Indices de la tabla `PRESTAMO`
--
ALTER TABLE `PRESTAMO`
  ADD PRIMARY KEY (`ALUMNO`,`LIBRO`),
  ADD KEY `fk_prestamo_libro` (`LIBRO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
