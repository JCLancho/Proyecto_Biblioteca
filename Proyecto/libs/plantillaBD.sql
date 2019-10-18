-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 18-10-2019 a las 10:10:08
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ALUMNO`
--

CREATE TABLE `ALUMNO` (
  `DNI` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `Nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Apellido1` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Apellido2` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `ALUMNO`
--

INSERT INTO `ALUMNO` (`DNI`, `Nombre`, `Apellido1`, `Apellido2`) VALUES
('11111111A', 'Carlos', 'Lancho', 'Martin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LIBRO`
--

CREATE TABLE `LIBRO` (
  `ISBN` varchar(13) COLLATE latin1_spanish_ci NOT NULL,
  `Título` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Autor` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `Editorial` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Asignatura` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `Estado` enum('Nuevo','Usado nuevo','Usado seminuevo','Usado estropeado','Restaurado') COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PRESTAMO`
--

CREATE TABLE `PRESTAMO` (
  `Alumno` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `Libro` varchar(13) COLLATE latin1_spanish_ci NOT NULL,
  `FechaPrestamo` date NOT NULL,
  `FechaDevolucion` date NOT NULL,
  `Estado` enum('Nuevo','Usado nuevo','Usado seminuevo','Usado estropeado','Restaurado') COLLATE latin1_spanish_ci NOT NULL
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
  ADD PRIMARY KEY (`Alumno`,`Libro`),
  ADD KEY `fk_prestamo_libro` (`Libro`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
