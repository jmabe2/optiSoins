-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 16 Juin 2016 à 18:33
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `optisoins`
--

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

CREATE TABLE IF NOT EXISTS `chambre` (
  `idChambre` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroChambre` int(11) DEFAULT NULL,
  `TypeChambreIdTypeChambre` int(11) NOT NULL,
  PRIMARY KEY (`idChambre`),
  UNIQUE KEY `idChambre_UNIQUE` (`idChambre`),
  KEY `fk_Chambre_Type_chambre1_idx` (`TypeChambreIdTypeChambre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `equipement`
--

CREATE TABLE IF NOT EXISTS `equipement` (
  `idEquipement` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEquipement`),
  UNIQUE KEY `idEquipement_UNIQUE` (`idEquipement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `equipementchambre`
--

CREATE TABLE IF NOT EXISTS `equipementchambre` (
  `idEquipementChambre` int(11) NOT NULL AUTO_INCREMENT,
  `ChambreIdChambre` int(11) NOT NULL,
  `EquipementIdEquipement` int(11) NOT NULL,
  PRIMARY KEY (`idEquipementChambre`),
  UNIQUE KEY `idEquipementChambre_UNIQUE` (`idEquipementChambre`),
  KEY `fk_Equipement_chambre_Chambre1_idx` (`ChambreIdChambre`),
  KEY `fk_Equipement_chambre_Equipement1_idx` (`EquipementIdEquipement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `intervention`
--

CREATE TABLE IF NOT EXISTS `intervention` (
  `idIntervention` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Sejour_idSejour` int(11) NOT NULL,
  `TypeInterventionIdTypeIntervention` int(11) NOT NULL,
  `UtilisateurIdUtilisateur` int(11) NOT NULL,
  PRIMARY KEY (`idIntervention`),
  UNIQUE KEY `idIntervention_UNIQUE` (`idIntervention`),
  KEY `fk_Intervention_Sejour1_idx` (`Sejour_idSejour`),
  KEY `fk_Intervention_Type_intervention1_idx` (`TypeInterventionIdTypeIntervention`),
  KEY `fk_Intervention_Utilisateur1_idx` (`UtilisateurIdUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE IF NOT EXISTS `medicament` (
  `idMedicament` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `QuantiteDispo` int(11) NOT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idMedicament`),
  UNIQUE KEY `idMedicament_UNIQUE` (`idMedicament`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `medicamentsejour`
--

CREATE TABLE IF NOT EXISTS `medicamentsejour` (
  `idMedicamentSejour` int(11) NOT NULL AUTO_INCREMENT,
  `Posologie` varchar(255) DEFAULT NULL,
  `Indication` varchar(255) DEFAULT NULL,
  `Remarque` varchar(255) DEFAULT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  `SejourIdSejour` int(11) NOT NULL,
  `MedicamentIdMedicament` int(11) NOT NULL,
  PRIMARY KEY (`idMedicamentSejour`),
  UNIQUE KEY `idMedicamentSejour_UNIQUE` (`idMedicamentSejour`),
  KEY `fk_Medicament_sejour_Sejour1_idx` (`SejourIdSejour`),
  KEY `fk_Medicament_sejour_Medicament1_idx` (`MedicamentIdMedicament`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `idPatient` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `DateDeNaissance` date NOT NULL,
  `Adresse` varchar(255) DEFAULT NULL,
  `Sexe` varchar(255) NOT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idPatient`),
  UNIQUE KEY `idPatient_UNIQUE` (`idPatient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `idRole` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idRole`),
  UNIQUE KEY `idRole_UNIQUE` (`idRole`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Structure de la table `sejour`
--

CREATE TABLE IF NOT EXISTS `sejour` (
  `idSejour` int(11) NOT NULL AUTO_INCREMENT,
  `DateEntree` date NOT NULL,
  `DateSortie` date NOT NULL,
  `MotifSejour` varchar(255) NOT NULL,
  `Emplacement` varchar(255) DEFAULT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  `PatientIdPatient` int(11) NOT NULL,
  PRIMARY KEY (`idSejour`),
  UNIQUE KEY `idSejour_UNIQUE` (`idSejour`),
  KEY `fk_Sejour_Patient_idx` (`PatientIdPatient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `sejourchambre`
--

CREATE TABLE IF NOT EXISTS `sejourchambre` (
  `idSejourChambre` int(11) NOT NULL AUTO_INCREMENT,
  `DateEntree` date DEFAULT NULL,
  `DateSortie` date DEFAULT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  `ChambreIdChambre` int(11) NOT NULL,
  `SejourIdSejour` int(11) NOT NULL,
  PRIMARY KEY (`idSejourChambre`),
  KEY `fk_Sejour_chambre_Chambre1_idx` (`ChambreIdChambre`),
  KEY `fk_Sejour_chambre_Sejour1_idx` (`SejourIdSejour`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

CREATE TABLE IF NOT EXISTS `specialite` (
  `idSpecialite` int(11) NOT NULL AUTO_INCREMENT,
  `Specialite` varchar(255) NOT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idSpecialite`),
  UNIQUE KEY `idSpecialite_UNIQUE` (`idSpecialite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `typechambre`
--

CREATE TABLE IF NOT EXISTS `typechambre` (
  `idTypeChambre` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idTypeChambre`),
  UNIQUE KEY `idTypeChambre_UNIQUE` (`idTypeChambre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `typeintervention`
--

CREATE TABLE IF NOT EXISTS `typeintervention` (
  `idTypeIntervention` int(11) NOT NULL AUTO_INCREMENT,
  `Libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`idTypeIntervention`),
  UNIQUE KEY `idTypeIntervention_UNIQUE` (`idTypeIntervention`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Sexe` varchar(255) NOT NULL,
  `DateNaissance` date NOT NULL,
  `Login` varchar(255) NOT NULL,
  `MotDePasse` varchar(255) NOT NULL,
  `Actif` tinyint(1) DEFAULT NULL,
  `RoleIdRole` int(11) NOT NULL,
  `SpecialiteIdSpecialite` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `idUtilisateur_UNIQUE` (`idUtilisateur`),
  KEY `fk_Utilisateur_Role1_idx` (`RoleIdRole`),
  KEY `fk_Utilisateur_Specialite1_idx` (`SpecialiteIdSpecialite`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `chambre`
--
ALTER TABLE `chambre`
  ADD CONSTRAINT `fk_Chambre_Type_chambre1` FOREIGN KEY (`TypeChambreIdTypeChambre`) REFERENCES `typechambre` (`idTypeChambre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `equipementchambre`
--
ALTER TABLE `equipementchambre`
  ADD CONSTRAINT `fk_Equipement_chambre_Chambre1` FOREIGN KEY (`ChambreIdChambre`) REFERENCES `chambre` (`idChambre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Equipement_chambre_Equipement1` FOREIGN KEY (`EquipementIdEquipement`) REFERENCES `equipement` (`idEquipement`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `intervention`
--
ALTER TABLE `intervention`
  ADD CONSTRAINT `fk_Intervention_Sejour1` FOREIGN KEY (`Sejour_idSejour`) REFERENCES `sejour` (`idSejour`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Intervention_Type_intervention1` FOREIGN KEY (`TypeInterventionIdTypeIntervention`) REFERENCES `typeintervention` (`idTypeIntervention`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Intervention_Utilisateur1` FOREIGN KEY (`UtilisateurIdUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `medicamentsejour`
--
ALTER TABLE `medicamentsejour`
  ADD CONSTRAINT `fk_Medicament_sejour_Sejour1` FOREIGN KEY (`SejourIdSejour`) REFERENCES `sejour` (`idSejour`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Medicament_sejour_Medicament1` FOREIGN KEY (`MedicamentIdMedicament`) REFERENCES `medicament` (`idMedicament`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `sejour`
--
ALTER TABLE `sejour`
  ADD CONSTRAINT `fk_Sejour_Patient` FOREIGN KEY (`PatientIdPatient`) REFERENCES `patient` (`idPatient`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `sejourchambre`
--
ALTER TABLE `sejourchambre`
  ADD CONSTRAINT `fk_Sejour_chambre_Chambre1` FOREIGN KEY (`ChambreIdChambre`) REFERENCES `chambre` (`idChambre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Sejour_chambre_Sejour1` FOREIGN KEY (`SejourIdSejour`) REFERENCES `sejour` (`idSejour`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_Utilisateur_Role1` FOREIGN KEY (`RoleIdRole`) REFERENCES `role` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Utilisateur_Specialite1` FOREIGN KEY (`SpecialiteIdSpecialite`) REFERENCES `specialite` (`idSpecialite`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
