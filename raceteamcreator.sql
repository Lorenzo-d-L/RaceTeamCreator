-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 20 feb 2025 om 14:29
-- Serverversie: 10.4.32-MariaDB
-- PHP-versie: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `raceteamcreator`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `coureur`
--

CREATE TABLE `coureur` (
  `coureur_id` int(11) NOT NULL,
  `naam` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `coureur`
--

INSERT INTO `coureur` (`coureur_id`, `naam`) VALUES
(6, 'Lewis Hamilton'),
(7, 'Max Verstappen'),
(8, 'Lando Norris'),
(9, 'Kimi Raikonen'),
(10, 'Valteri Bottas'),
(13, 'Rick de Jong'),
(15, 'Peter Ransom'),
(16, 'Nigell Mansel');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `kleur`
--

CREATE TABLE `kleur` (
  `kleur_id` int(11) NOT NULL,
  `kleur` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `kleur`
--

INSERT INTO `kleur` (`kleur_id`, `kleur`) VALUES
(1, 'Black'),
(19, 'White'),
(20, 'Green'),
(21, 'Red'),
(22, 'Pruple'),
(23, 'Purple'),
(24, 'dark-Green'),
(25, 'dark-Red'),
(26, 'dark-Purple'),
(27, 'dark-Pink'),
(28, 'dark-Yellow'),
(29, 'baby-Blue'),
(30, 'Blue'),
(31, 'Magenta'),
(32, 'Grey'),
(33, 'polar-White');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `leverancier`
--

CREATE TABLE `leverancier` (
  `leverancier_id` int(11) NOT NULL,
  `leverancier_naam` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `leverancier`
--

INSERT INTO `leverancier` (`leverancier_id`, `leverancier_naam`) VALUES
(1, 'Mercedes'),
(2, 'RedBull PowerTrains'),
(3, 'Ferarri'),
(4, 'Renault'),
(5, 'Porsche'),
(6, 'BMW'),
(7, 'Toyota'),
(8, 'Honda'),
(9, 'Ford'),
(10, 'Hyundai');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `login`
--

INSERT INTO `login` (`id`, `email`, `password`) VALUES
(19, 'Admin@.', 'admin');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `teams`
--

CREATE TABLE `teams` (
  `team_id` int(11) NOT NULL,
  `teamnaam` varchar(40) NOT NULL,
  `kleur` varchar(20) NOT NULL,
  `team_land` varchar(20) NOT NULL,
  `team_jaar` date NOT NULL,
  `motor_leverancier` varchar(30) NOT NULL,
  `team_manager` varchar(30) NOT NULL,
  `coureur1` varchar(40) NOT NULL,
  `coureur2` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `teams`
--

INSERT INTO `teams` (`team_id`, `teamnaam`, `kleur`, `team_land`, `team_jaar`, `motor_leverancier`, `team_manager`, `coureur1`, `coureur2`) VALUES
(28, '1', 'dark-Green', 'VOORBEELD', '2025-02-14', 'BMW', 'VOORBEELD', 'Valteri Bottas', 'Nigell Mansel');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `team_coureur`
--

CREATE TABLE `team_coureur` (
  `team_id` int(11) NOT NULL,
  `coureur_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Gegevens worden geëxporteerd voor tabel `team_coureur`
--

INSERT INTO `team_coureur` (`team_id`, `coureur_id`) VALUES
(6, 6),
(6, 6),
(7, 6),
(7, 6),
(8, 7),
(8, 7),
(9, 9),
(9, 8),
(10, 6),
(10, 12),
(11, 7),
(11, 9),
(12, 7),
(12, 9),
(13, 7),
(13, 9),
(14, 8),
(14, 8),
(15, 8),
(15, 8),
(16, 8),
(16, 8),
(17, 8),
(17, 8),
(18, 8),
(18, 8),
(19, 8),
(19, 8),
(20, 8),
(20, 8),
(21, 8),
(21, 8),
(22, 6),
(22, 10),
(28, 10);

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `coureur`
--
ALTER TABLE `coureur`
  ADD PRIMARY KEY (`coureur_id`);

--
-- Indexen voor tabel `kleur`
--
ALTER TABLE `kleur`
  ADD PRIMARY KEY (`kleur_id`);

--
-- Indexen voor tabel `leverancier`
--
ALTER TABLE `leverancier`
  ADD PRIMARY KEY (`leverancier_id`);

--
-- Indexen voor tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`team_id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `coureur`
--
ALTER TABLE `coureur`
  MODIFY `coureur_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT voor een tabel `kleur`
--
ALTER TABLE `kleur`
  MODIFY `kleur_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT voor een tabel `leverancier`
--
ALTER TABLE `leverancier`
  MODIFY `leverancier_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT voor een tabel `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT voor een tabel `teams`
--
ALTER TABLE `teams`
  MODIFY `team_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
