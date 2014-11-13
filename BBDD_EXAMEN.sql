-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.0.45-community-nt - MySQL Community Edition (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para concesionario
DROP DATABASE IF EXISTS `concesionario`;
CREATE DATABASE IF NOT EXISTS `concesionario` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `concesionario`;


-- Volcando estructura para tabla concesionario.vehiculo
DROP TABLE IF EXISTS `vehiculo`;
CREATE TABLE IF NOT EXISTS `vehiculo` (
  `id` int(2) NOT NULL auto_increment,
  `matricula` varchar(10) NOT NULL,
  `marca` varchar(15) NOT NULL,
  `modelo` varchar(4) NOT NULL,
  `color` varchar(20) NOT NULL,
  `caballos` int(5) NOT NULL,
  `cambio` tinyint(4) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `matricula` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla concesionario.vehiculo: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` (`id`, `matricula`, `marca`, `modelo`, `color`, `caballos`, `cambio`) VALUES
	(1, 'GG', 'G', '', 'G', 6, 0),
	(2, 'A1111', 'SEAT', '2001', 'VERDE', 100, 0),
	(6, 'C3333', 'AUDI', '2003', 'ROJO', 150, 0),
	(7, 'D4444', 'KIA', '2004', 'BLANCO', 75, 0),
	(8, 'E5555', 'RENAULT', '2005', 'GRIS', 100, 0),
	(9, 'F6666', 'AUDI', '2006', 'GRIS', 80, 0),
	(10, 'B2222', 'TOYOTA', '2002', 'AZUL', 250, 0);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
