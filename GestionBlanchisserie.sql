-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : dim. 07 jan. 2024 à 15:55
-- Version du serveur : 5.7.39
-- Version de PHP : 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `GestionBlanchisserie`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(25) NOT NULL,
  `nomAdmin` varchar(25) NOT NULL,
  `motdepasseAdmin` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`idAdmin`, `nomAdmin`, `motdepasseAdmin`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `idArticle` int(25) NOT NULL,
  `libelleArticle` varchar(25) NOT NULL,
  `prixLaver` int(25) NOT NULL,
  `prixRepasser` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`idArticle`, `libelleArticle`, `prixLaver`, `prixRepasser`) VALUES
(1, 'chemise', 500, 500),
(2, 'pantalon', 200, 200),
(3, 'pantalon', 500, 500),
(4, 'chemise', 300, 200);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` varchar(25) NOT NULL,
  `nomClient` varchar(25) NOT NULL,
  `prenomClient` varchar(50) NOT NULL,
  `adresseClient` varchar(100) NOT NULL,
  `telClient` varchar(14) NOT NULL,
  `emailClient` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `nomClient`, `prenomClient`, `adresseClient`, `telClient`, `emailClient`) VALUES
('dsshjj4049', 'dss', 'hjjhjh', 'fdfdffdfff', '0740504049', 'koffi8@gmail.com'),
('gfghjh676', 'gfgdg', 'hjhjjhj', 'hfdhfjddjf', '462345676', 'hfdhd@gmail.com'),
('ghghgh78', 'ghggjgjg', 'hghghghjgjg', 'dgfgfdfdgfdfg', '12345678', 'DGFFGFGFG'),
('gnapri1691', 'gnamien', 'prince', 'COCODY MERMOZ', '0788391691', 'nguessanprince8@gmail.com'),
('gnapri8391691', 'gnamien', 'prince', 'testtest', '2250788391691', 'nguessanprince8@gmail.com'),
('hhghg', 'fhh', 'hjhj', 'hjhjhj', '42545452', ''),
('hhhhhf1691', 'hhhh', 'hhf', 'hjhjhjhjhh', '0788391691', 'ffdhfdhfjdh'),
('kolleo655', 'kolley', 'leon', 'fdhgjgdfgjjdgjh', '055565655', 'gyugyg@gmail.com'),
('N\'gGna8391691', 'N\'guessan', 'Gnamien prince', 'Cocody Mermoz', '2250788391691', 'nguessanprince8@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `idCommande` varchar(255) NOT NULL,
  `dateCommande` date NOT NULL,
  `statutCommande` int(1) NOT NULL,
  `descriptionCommande` varchar(50) NOT NULL,
  `client` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`idCommande`, `dateCommande`, `statutCommande`, `descriptionCommande`, `client`) VALUES
('2024-01-01gnapri169114:50:11.130', '2024-01-01', 3, 'ttt', 'gnapri1691'),
('2024-01-02gfghjh67601:45:33.916481', '2024-01-02', 3, 'fffff', 'gfghjh676'),
('2024-01-02gnapri169100:12:28.068538', '2024-01-02', 3, 'tantanatna', 'gnapri1691'),
('2024-01-02kolleo65500:38:22.390873', '2024-01-02', 3, 'lorem	lorem	', 'kolleo655'),
('2024-01-02kolleo65500:42:34.599325', '2024-01-02', 0, 'ddd', 'kolleo655'),
('2024-01-02kolleo65500:45:49.105208', '2024-01-02', 0, 'hh', 'kolleo655'),
('2024-01-02kolleo65500:47:35.703848', '2024-01-02', 0, 'ff', 'kolleo655'),
('2024-01-02kolleo65500:50:36.009801', '2024-01-02', 0, 'ggdghghgghg		', 'kolleo655'),
('2024-01-02kolleo65500:52:01.874715', '2024-01-02', 0, 'test	', 'kolleo655'),
('2024-01-02kolleo65500:53:41.262663', '2024-01-02', 0, 'bon fais comme si fais comme ça', 'kolleo655'),
('2024-01-02kolleo65500:54:50.954432', '2024-01-02', 1, 'ff', 'kolleo655'),
('2024-01-05N\'gGna839169111:08:22.881186', '2024-01-05', 3, 'lorem', 'N\'gGna8391691');

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `idEmploye` varchar(25) NOT NULL,
  `nomEmploye` varchar(25) NOT NULL,
  `prenomEmploye` varchar(50) NOT NULL,
  `adresseEmploye` varchar(100) NOT NULL,
  `telEmploye` varchar(14) NOT NULL,
  `dateEmbEmploye` date NOT NULL,
  `salaireEmploye` int(10) NOT NULL,
  `motDePasseEmploye` varchar(255) NOT NULL,
  `fonctionEmploye` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`idEmploye`, `nomEmploye`, `prenomEmploye`, `adresseEmploye`, `telEmploye`, `dateEmbEmploye`, `salaireEmploye`, `motDePasseEmploye`, `fonctionEmploye`) VALUES
('kolleo57', 'kolley', 'leon', 'yop', '07489657', '2024-01-12', 100000, 'kolleo57', 'laveur'),
('ttthhh6566', 'tttttttt', 'hhhhhhhh', 'GGGHGHG', '3563536566', '2024-01-11', 3636363, 'ttthhh6566', 'Ghhghgh');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `idFacture` int(25) NOT NULL,
  `montantTotal` int(25) NOT NULL,
  `dateEmission` date NOT NULL,
  `statutFacture` int(1) NOT NULL,
  `commande` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `idMessage` int(25) NOT NULL,
  `contenuMessage` text NOT NULL,
  `statutMessage` tinyint(1) NOT NULL,
  `client` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `idPaiement` int(25) NOT NULL,
  `montantPayer` int(25) NOT NULL,
  `datePaiement` date NOT NULL,
  `typePaiement` varchar(10) NOT NULL,
  `facture` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `tacheEmploye`
--

CREATE TABLE `tacheEmploye` (
  `idTacheEmploye` int(25) NOT NULL,
  `descriptionTache` varchar(100) NOT NULL,
  `statutTache` int(1) NOT NULL,
  `employe` varchar(25) NOT NULL,
  `commande` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `tacheEmploye`
--

INSERT INTO `tacheEmploye` (`idTacheEmploye`, `descriptionTache`, `statutTache`, `employe`, `commande`) VALUES
(1, 'test', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(2, 'test', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(3, 'test test', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(4, 'test test', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(5, 'rrr', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(6, 'rrr', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(7, 'tes test', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(8, 'tes test', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(9, 'dd', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(10, 'dd', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(11, 'eeeee', 1, 'kolleo57', '2024-01-01gnapri169114:50:11.130'),
(12, 'hhh', 1, 'ttthhh6566', '2024-01-02gfghjh67601:45:33.916481'),
(13, 'ggggg', 1, 'kolleo57', '2024-01-02gnapri169100:12:28.068538'),
(14, '', 1, 'kolleo57', '2024-01-02kolleo65500:38:22.390873'),
(15, 'lorem', 1, 'kolleo57', '2024-01-05N\'gGna839169111:08:22.881186'),
(16, 'ddd', 1, 'kolleo57', '2024-01-02kolleo65500:54:50.954432');

-- --------------------------------------------------------

--
-- Structure de la table `vetement`
--

CREATE TABLE `vetement` (
  `idVetement` int(25) NOT NULL,
  `couleurVetement` varchar(25) NOT NULL,
  `marqueVetement` varchar(25) NOT NULL,
  `qualiteVetement` varchar(1) NOT NULL,
  `serviceVetement` varchar(25) NOT NULL,
  `article` int(25) NOT NULL,
  `commande` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vetement`
--

INSERT INTO `vetement` (`idVetement`, `couleurVetement`, `marqueVetement`, `qualiteVetement`, `serviceVetement`, `article`, `commande`) VALUES
(2, 'test', 'test', '1', '500', 1, '2024-01-02kolleo65500:52:01.874715'),
(3, 'rouge', 'puma', '1', '1000', 1, '2024-01-02kolleo65500:53:41.262663'),
(4, 'verte', 'nike', '5', '400', 1, '2024-01-02kolleo65500:53:41.262663'),
(5, 'noir', 'nike', '1', '500', 1, '2024-01-02kolleo65500:53:41.262663'),
(6, 'jaune', 'Test', '5', '200', 2, '2024-01-02kolleo65500:54:50.954432'),
(7, 'g', 'test', '2', '500', 1, '2024-01-02gfghjh67601:45:33.916481'),
(8, 'NOIRE', 'NIKE', '1', '500', 2, '2024-01-05N\'gGna839169111:08:22.881186'),
(9, 'NOIRE', 'PUMA', '5', '400', 2, '2024-01-05N\'gGna839169111:08:22.881186');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`idArticle`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`idCommande`),
  ADD KEY `ik100` (`client`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`idEmploye`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`idFacture`),
  ADD KEY `ik6` (`commande`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`idMessage`),
  ADD KEY `ik4` (`client`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`idPaiement`),
  ADD KEY `ik8` (`facture`);

--
-- Index pour la table `tacheEmploye`
--
ALTER TABLE `tacheEmploye`
  ADD PRIMARY KEY (`idTacheEmploye`),
  ADD KEY `ik9` (`employe`),
  ADD KEY `ik10` (`commande`);

--
-- Index pour la table `vetement`
--
ALTER TABLE `vetement`
  ADD PRIMARY KEY (`idVetement`),
  ADD KEY `ik5` (`article`),
  ADD KEY `ik6` (`commande`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `idArticle` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `idFacture` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `idMessage` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `idPaiement` int(25) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `tacheEmploye`
--
ALTER TABLE `tacheEmploye`
  MODIFY `idTacheEmploye` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `vetement`
--
ALTER TABLE `vetement`
  MODIFY `idVetement` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `ik100` FOREIGN KEY (`client`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `ik4` FOREIGN KEY (`client`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD CONSTRAINT `ik8` FOREIGN KEY (`facture`) REFERENCES `facture` (`idFacture`);

--
-- Contraintes pour la table `tacheEmploye`
--
ALTER TABLE `tacheEmploye`
  ADD CONSTRAINT `ik9` FOREIGN KEY (`employe`) REFERENCES `employe` (`idEmploye`);

--
-- Contraintes pour la table `vetement`
--
ALTER TABLE `vetement`
  ADD CONSTRAINT `ik5` FOREIGN KEY (`article`) REFERENCES `article` (`idArticle`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
