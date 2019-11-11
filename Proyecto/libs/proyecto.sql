-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-11-2019 a las 01:10:22
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_alumno` (IN `doc` VARCHAR(9), IN `nom` VARCHAR(50), IN `ap1` VARCHAR(50), IN `ap2` VARCHAR(50))  NO SQL
INSERT INTO alumno (alumno.DNI, alumno.NOMBRE, alumno.APELLIDO1, alumno.APELLIDO2) VALUES (doc, nom, ap1, ap2)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `DNI` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `NOMBRE` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `APELLIDO1` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `APELLIDO2` varchar(50) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`DNI`, `NOMBRE`, `APELLIDO1`, `APELLIDO2`) VALUES
('11111111A', 'Jose Carlos', 'Lancho', ''),
('123', 'as', 'as', 'sfasfa'),
('1325', '', '', ''),
('22222222B', 'Rodrigo', 'Alonso', ''),
('33333333C', 'Carlos', 'Martin', ''),
('444444443', 'feed', 'back', ''),
('7531269L', 'Uno', 'dos', 'tres'),
('88888', 'procedure', '', ''),
('asdfs', 'fdsaf', 'dfs', 'fsd'),
('dni', 'nom', 'ap1', ''),
('proc', 'desde', 'java', ''),
('prue', 'puer', 'puer', 'puer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `COD_ASIGNATURA` int(10) NOT NULL,
  `NOM_ASIGNATURA` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ABREVIATURA` varchar(10) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`COD_ASIGNATURA`, `NOM_ASIGNATURA`, `ABREVIATURA`) VALUES
(1, 'Lenguaje de marcas', 'LEMA'),
(2, 'Acceso a datos', 'ADAT'),
(3, 'Diseño de interfaces', 'DEIN'),
(4, 'Base de datos', 'BBDD'),
(5, 'Entornos de desarrollo', 'ENDE'),
(6, 'Procesos', 'PROS'),
(7, 'Ingles', 'INGLES'),
(8, 'asig', 'ABREV'),
(9, 'Sistemas de gestion empresarial', 'SIGE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE `estado` (
  `COD_ESTADO` varchar(2) COLLATE latin1_spanish_ci NOT NULL,
  `DESCRIPCION` varchar(20) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`COD_ESTADO`, `DESCRIPCION`) VALUES
('N', 'Nuevo'),
('R', 'Restaurado'),
('UE', 'Usado Estropeado'),
('UN', 'Usado Nuevo'),
('US', 'Usado Seminuevo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historico`
--

CREATE TABLE `historico` (
  `ALUMNO` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `LIBRO` varchar(13) COLLATE latin1_spanish_ci NOT NULL,
  `FECHAPRESTAMO` date NOT NULL,
  `FECHADEVOLUCION` date NOT NULL,
  `FECHADEVUSU` date NOT NULL,
  `ESTADOINICIAL` varchar(2) COLLATE latin1_spanish_ci NOT NULL,
  `ESTADOFINAL` varchar(2) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `historico`
--

INSERT INTO `historico` (`ALUMNO`, `LIBRO`, `FECHAPRESTAMO`, `FECHADEVOLUCION`, `FECHADEVUSU`, `ESTADOINICIAL`, `ESTADOFINAL`) VALUES
('1236497c', '3233233', '2019-11-10', '2019-11-25', '2019-11-10', 'UN', 'UN'),
('11111111A', '1', '2019-11-10', '2019-11-26', '2019-11-11', 'R', 'R'),
('123', '11111', '2019-11-03', '2019-11-25', '2019-11-11', 'R', 'R'),
('11111111A', '1234567890123', '2019-11-10', '2019-11-26', '2019-11-11', 'N', 'N'),
('123', '13164', '2019-11-11', '2019-11-26', '2019-11-11', 'N', 'N');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `ISBN` varchar(13) COLLATE latin1_spanish_ci NOT NULL,
  `TITULO` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `AUTOR` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `EDITORIAL` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `ASIGNATURA` int(10) NOT NULL,
  `ESTADO` varchar(2) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`ISBN`, `TITULO`, `AUTOR`, `EDITORIAL`, `ASIGNATURA`, `ESTADO`) VALUES
('1', '', '', '', 3, 'R'),
('11111', 'a', 't', 'e', 5, 'R'),
('11111111111', '', 'bbbb', '', 4, 'N'),
('123123', '', '', '', 1, 'N'),
('1231231331', '', 'bbdd', '', 4, 'N'),
('1234567890123', 'Titulo', 'Autor', 'Editorial', 1, 'N'),
('13164', '', '', '', 1, 'N'),
('3233233', 'ttt', 'aaa', 'eee', 2, 'UN'),
('5555', '', '', '', 2, 'R'),
('555555555', '', '', '', 2, 'R'),
('aaaaaa', '', '', '', 1, 'UN'),
('asdf', 'titulo', 'autor', 'editorial', 1, 'N'),
('asfda', '', '', '', 3, 'R'),
('bbbbb', '', '', '', 1, 'R'),
('sadfas', 'asfdds', 'afss', '', 1, 'N');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `ALUMNO` varchar(9) COLLATE latin1_spanish_ci NOT NULL,
  `LIBRO` varchar(13) COLLATE latin1_spanish_ci NOT NULL,
  `FECHAPRESTAMO` date NOT NULL,
  `FECHADEVOLUCION` date NOT NULL,
  `ESTADO` varchar(2) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`ALUMNO`, `LIBRO`, `FECHAPRESTAMO`, `FECHADEVOLUCION`, `ESTADO`) VALUES
('123', '1', '2019-11-11', '2019-11-26', 'R'),
('1325', '1231231331', '2019-11-11', '2019-11-26', 'N'),
('22222222B', '123123', '2019-11-11', '2019-11-26', 'N'),
('22222222B', 'sadfas', '2019-11-10', '2019-11-25', 'N');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`COD_ASIGNATURA`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`COD_ESTADO`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `ASIGNATURA` (`ASIGNATURA`),
  ADD KEY `ESTADO` (`ESTADO`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`ALUMNO`,`LIBRO`,`FECHAPRESTAMO`),
  ADD KEY `LIBRO` (`LIBRO`),
  ADD KEY `ESTADO` (`ESTADO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  MODIFY `COD_ASIGNATURA` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`ASIGNATURA`) REFERENCES `asignatura` (`COD_ASIGNATURA`),
  ADD CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`ESTADO`) REFERENCES `estado` (`COD_ESTADO`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`ALUMNO`) REFERENCES `alumno` (`DNI`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`LIBRO`) REFERENCES `libro` (`ISBN`),
  ADD CONSTRAINT `prestamo_ibfk_3` FOREIGN KEY (`ESTADO`) REFERENCES `estado` (`COD_ESTADO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
