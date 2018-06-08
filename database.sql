-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.3.7-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para dnaanalyzer
CREATE DATABASE IF NOT EXISTS `dnaanalyzer` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dnaanalyzer`;

-- Volcando estructura para tabla dnaanalyzer.analyzeddna
CREATE TABLE IF NOT EXISTS `analyzeddna` (
  `dna` varchar(255) NOT NULL,
  PRIMARY KEY (`dna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para procedimiento dnaanalyzer.incrementstats
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `incrementstats`(
	IN `pname` VARCHAR(50)
)
BEGIN
	DECLARE QUANTITY TINYINT DEFAULT 0;
	
	SELECT count(*) into QUANTITY FROM stats WHERE name=pname;
	
	IF QUANTITY=0 THEN
		INSERT INTO stats (name,value) VALUES (pname,1);
	ELSE
		UPDATE stats SET value=value+1 WHERE name=pname;
	END IF;
END//
DELIMITER ;

-- Volcando estructura para función dnaanalyzer.insertdna
DELIMITER //
CREATE DEFINER=`root`@`localhost` FUNCTION `insertdna`(
	`pdna` VARCHAR(255)


) RETURNS bit(1)
BEGIN
	DECLARE QUANTITY TINYINT DEFAULT 0;
	
	SELECT count(*) into QUANTITY FROM analyzeddna WHERE dna=pdna;
	
	IF QUANTITY=0 THEN
		INSERT INTO analyzeddna (dna) VALUES (pdna);
		return 1;
	ELSE
		return 0;
	END IF;
	
END//
DELIMITER ;

-- Volcando estructura para tabla dnaanalyzer.stats
CREATE TABLE IF NOT EXISTS `stats` (
  `name` varchar(50) DEFAULT NULL,
  `value` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;


-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.3.7-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando datos para la tabla dnaanalyzer.stats: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `stats` DISABLE KEYS */;
INSERT INTO `stats` (`name`, `value`) VALUES
	('count_mutant_dna', 0),
	('count_human_dna', 0);
/*!40000 ALTER TABLE `stats` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
