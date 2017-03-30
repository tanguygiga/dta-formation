CREATE TABLE `pizza` (
  `id` int(11) auto_increment NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `pizza` (`id`, `categorie`, `code`, `nom`, `prix`) VALUES
(1, 'VIANDE', 'TOT', 'toto', 45.27);