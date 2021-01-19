-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 19 jan. 2021 à 15:33
-- Version du serveur :  5.7.24
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bancaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `solde` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`id`, `nom`, `solde`, `created_at`, `updated_at`) VALUES
('C00001', 'Wyclef Jean', 2000, '2021-01-19 07:52:10', '2021-01-19 12:22:38'),
('C00002', 'Akon', 10, '2021-01-19 07:52:25', '2021-01-19 12:22:38'),
('C00003', 'Hajisy', 45000, '2021-01-19 11:08:18', '2021-01-19 11:08:18');

-- --------------------------------------------------------

--
-- Structure de la table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
CREATE TABLE IF NOT EXISTS `migrations` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(9, '2014_10_12_000000_create_users_table', 1),
(10, '2021_01_01_095631_create_clients_table', 1),
(11, '2021_01_01_095722_create_versements_table', 1),
(12, '2021_01_01_095745_create_retraits_table', 1),
(13, '2021_01_18_060100_create_transferts_table', 2);

-- --------------------------------------------------------

--
-- Structure de la table `retraits`
--

DROP TABLE IF EXISTS `retraits`;
CREATE TABLE IF NOT EXISTS `retraits` (
  `id` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `client_id` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `montant_retrait` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `retraits_client_id_foreign` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `retraits`
--

INSERT INTO `retraits` (`id`, `client_id`, `montant_retrait`, `created_at`, `updated_at`) VALUES
('LB001', 'C00001', 1, '2021-01-19 08:04:12', '2021-01-19 08:04:12'),
('PW003', 'C00002', 10, '2021-01-19 11:26:53', '2021-01-19 11:26:53'),
('MR002', 'C00001', 10, '2021-01-19 10:53:34', '2021-01-19 10:53:34');

-- --------------------------------------------------------

--
-- Structure de la table `transferts`
--

DROP TABLE IF EXISTS `transferts`;
CREATE TABLE IF NOT EXISTS `transferts` (
  `id` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sender_id` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `receiver_id` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `montant_transfert` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `transferts_sender_id_foreign` (`sender_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `transferts`
--

INSERT INTO `transferts` (`id`, `sender_id`, `receiver_id`, `montant_transfert`, `created_at`, `updated_at`) VALUES
('UA001', 'C00002', 'C00001', 2, '2021-01-19 10:48:50', '2021-01-19 10:48:50'),
('WV001', 'C00001', 'C00002', 2, '2021-01-19 10:46:48', '2021-01-19 10:46:48'),
('DR001', 'C00002', 'C00001', 2, '2021-01-19 10:44:03', '2021-01-19 10:44:03'),
('SR001', 'C00001', 'C00002', 2, '2021-01-19 10:43:57', '2021-01-19 10:43:57'),
('BL002', 'C00002', 'C00001', 1, '2021-01-19 10:41:06', '2021-01-19 10:41:06'),
('EH004', 'C00002', 'C00001', 1, '2021-01-19 10:41:04', '2021-01-19 10:41:04'),
('TZ004', 'C00001', 'C00002', 1, '2021-01-19 10:32:49', '2021-01-19 10:32:49'),
('RY004', 'C00001', 'C00002', 1, '2021-01-19 10:25:03', '2021-01-19 10:25:03'),
('HC002', 'C00001', 'C00002', 1, '2021-01-19 10:25:02', '2021-01-19 10:25:02'),
('TZ002', 'C00001', 'C00002', 1, '2021-01-19 10:25:01', '2021-01-19 10:25:01'),
('LB002', 'C00001', 'C00002', 1, '2021-01-19 10:24:41', '2021-01-19 10:24:41'),
('DD001', 'C00002', 'C00001', 1, '2021-01-19 09:06:47', '2021-01-19 09:06:47'),
('HV003', 'C00002', 'C00001', 1, '2021-01-19 09:06:36', '2021-01-19 09:06:36'),
('ND002', 'C00001', 'C00002', 1, '2021-01-19 09:06:19', '2021-01-19 09:06:19'),
('ID001', 'C00001', 'C00002', 1, '2021-01-19 09:04:30', '2021-01-19 09:04:30');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_username_unique` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `created_at`, `updated_at`) VALUES
('ZG001', 'kenddriz', '$2y$10$fWdoQHR1mc/BZOwTzx3KyekoN57TxSJEmzlrI.yCQ9aNB9jPtRhTO', '2021-01-13 15:58:40', '2021-01-13 15:58:40');

-- --------------------------------------------------------

--
-- Structure de la table `versements`
--

DROP TABLE IF EXISTS `versements`;
CREATE TABLE IF NOT EXISTS `versements` (
  `id` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `client_id` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `montant_versement` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `versements_client_id_foreign` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `versements`
--

INSERT INTO `versements` (`id`, `client_id`, `montant_versement`, `created_at`, `updated_at`) VALUES
('YE001', 'C00002', 17, '2021-01-19 10:51:13', '2021-01-19 10:51:13'),
('OQ002', 'C00001', 8, '2021-01-19 10:51:23', '2021-01-19 10:51:23'),
('FU001', 'C00001', 2000, '2021-01-19 10:53:40', '2021-01-19 10:53:40');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
