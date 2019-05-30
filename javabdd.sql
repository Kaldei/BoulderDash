-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 30 mai 2019 à 11:45
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `javabdd`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `maplevel`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `maplevel` (IN `levelID` INT)  BEGIN

SELECT map FROM level WHERE id = levelID ;

END$$

DROP PROCEDURE IF EXISTS `maplevel1`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `maplevel1` ()  BEGIN

SELECT map FROM level WHERE `level`="level1";

END$$

DROP PROCEDURE IF EXISTS `maplevel2`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `maplevel2` ()  BEGIN

SELECT map FROM level WHERE `level`="level2" ;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `level`
--

DROP TABLE IF EXISTS `level`;
CREATE TABLE IF NOT EXISTS `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(54) NOT NULL,
  `map` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `level`
--

INSERT INTO `level` (`id`, `level`, `map`) VALUES
(1, 'level1', '15\r\n10\r\n#         H   #\r\n#     ..      #\r\n#     X.      #\r\n#             #\r\n#             #\r\n#        O    #\r\n#   *         #\r\n#         D   #\r\n#             #\r\n#             #'),
(2, 'level2', '15\r\n10\r\n#             #\r\n#             #\r\n# X    X      #\r\n#          X  #\r\n#             #\r\n#       X     #\r\n#             #\r\n#             #\r\n#             #\r\n#             #');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
