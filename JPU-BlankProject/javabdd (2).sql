-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 03 juin 2019 à 07:21
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

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
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `level`
--

INSERT INTO `level` (`id`, `level`, `map`) VALUES
(1, 'level1', '35\r\n25\r\n###################################\r\n#.                ..           OO #\r\n#      OO      ..                 #\r\n#    *          #     OO  **      #\r\n#      ..       #                 #\r\n#    ..X..      #      ..   ..    #\r\n#               #   ..X...     .  #\r\n#           O   #     ...         #\r\n#############################   . #\r\n#                 #               #\r\n#      *          #       **   .  #\r\n#     *   O   OO  #               #\r\n#     *           #               #\r\n#        ..   ..  #        ..G..  #\r\n#                           ...   #\r\n#            OO ..                #\r\n####    ###########################\r\n#                          # .....#\r\n#    *      OOO    O       # X.D..#\r\n#..G..                     # .....#\r\n#          #                      #\r\n#    *     #    **       OO       #\r\n#    *     #              O       #\r\n#          #                      #\r\n###################################'),
(2, 'level2', '###################################\r\n#. OO   #   **                  #D#\r\n#       #  ..X. **      ..X..     #\r\n#          .G..                   #\r\n#                       O         #\r\n#       #    **     O             #\r\n#    ** #    OOO     OO           #\r\n#   OO  #    O*O          *       #\r\n#            OOO     .G....       #\r\n#       #         ......          #\r\n#  **   #    OO     ..D..X        #\r\n#                 .X.....         #\r\n#  O    #                         #\r\n#    *  #         *               #\r\n###################################\r\n'),
(3, 'level3', '24\r\n15\r\n########################\r\n#....    O    ** ..X.. #\r\n#   ...    OO    ..    #\r\n#               OO     #\r\n#          **       ..X#\r\n###################    #\r\n#                      #\r\n#  ..G.  * O   . O..   #\r\n#         **       OO  #\r\n# ..G...         *     #\r\n##########    ##########\r\n#        ..OO...  *    #\r\n#                 ...  #\r\n#      **  .X.     X.D #\r\n########################'),
(4, 'level4', '21\r\n11\r\n#####################\r\n# .O     O  * *     #\r\n# *                 #\r\n#*  ####     ####   #\r\n#       ...   OO    #\r\n# .G.   .X.   *O    #\r\n# ...  ####         #\r\n#     OOO     ..G...#\r\n#   ..X O     ..**###\r\n#  **.. O ...X..#**D#\r\n#####################'),
(5, 'level5', '13\r\n11\r\n#############\r\n#.          #\r\n#           #\r\n# *   *   * #\r\n# ** * * ** #\r\n# * *   * * #\r\n# *   D   * #\r\n# ********* #\r\n#           #\r\n#           #\r\n#############');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
