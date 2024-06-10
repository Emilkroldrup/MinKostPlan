-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Vært: 127.0.0.1:3306
-- Genereringstid: 10. 06 2024 kl. 08:05:32
-- Serverversion: 8.2.0
-- PHP-version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minkostplan`
--

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
CREATE TABLE IF NOT EXISTS `ingredients` (
                                             `ingredient_id` int NOT NULL AUTO_INCREMENT,
                                             `name` varchar(255) NOT NULL,
    `description` text,
    `calories` int DEFAULT NULL,
    `carbohydrate` int DEFAULT NULL,
    `fat` int DEFAULT NULL,
    `protein` int DEFAULT NULL,
    PRIMARY KEY (`ingredient_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Contains different ingredients used in recipes.';

--
-- Data dump for tabellen `ingredients`
--

INSERT INTO `ingredients` (`ingredient_id`, `name`, `description`, `calories`, `carbohydrate`, `fat`, `protein`) VALUES
                                                                                                                     (1, 'Spaghetti', 'Lang, tynd, cylindrisk pasta af italiensk oprindelse', 0, 0, 0, 0),
                                                                                                                     (2, 'Æg', 'Økologiske fritgående æg', 0, 0, 0, 0),
                                                                                                                     (3, 'Bacon', 'Tykkere skiver af røget bacon', 0, 0, 0, 0),
                                                                                                                     (4, 'Zucchini', 'Frisk zucchini', 0, 0, 0, 0),
                                                                                                                     (5, 'Tomat', 'Modne tomater', 0, 0, 0, 0),
                                                                                                                     (6, 'Kartoffel', 'Danske kartofler', 77, 17, 0, 2),
                                                                                                                     (7, 'Løg', 'Friske løg', 40, 9, 0, 1),
                                                                                                                     (8, 'Hvidløg', 'Økologisk hvidløg', 149, 33, 1, 6),
                                                                                                                     (9, 'Gulerod', 'Friske gulerødder', 41, 10, 0, 1);

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `profilepictures`
--

DROP TABLE IF EXISTS `profilepictures`;
CREATE TABLE IF NOT EXISTS `profilepictures` (
                                                 `picture_id` int NOT NULL AUTO_INCREMENT,
                                                 `user_id` int DEFAULT NULL,
                                                 `status` int NOT NULL,
                                                 PRIMARY KEY (`picture_id`),
    KEY `profilepictures_fk` (`user_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores details about uploaded profile pictures.';

--
-- Data dump for tabellen `profilepictures`
--

INSERT INTO `profilepictures` (`picture_id`, `user_id`, `status`) VALUES
                                                                      (1, 1, 1),
                                                                      (2, 2, 0),
                                                                      (3, 3, 1),
                                                                      (4, 4, 1),
                                                                      (5, 5, 0);

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `recipes`
--

DROP TABLE IF EXISTS `recipes`;
CREATE TABLE IF NOT EXISTS `recipes` (
                                         `recipe_id` int NOT NULL AUTO_INCREMENT,
                                         `name` varchar(255) NOT NULL,
    `cook_name` varchar(100) DEFAULT NULL,
    `average_time` int NOT NULL COMMENT 'in minutes',
    `created_at` datetime NOT NULL,
    `instructions` text,
    `meal_type` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`recipe_id`),
    UNIQUE KEY `unique_recipe_name` (`name`)
    ) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores details about various recipes.';

--
-- Data dump for tabellen `recipes`
--

INSERT INTO `recipes` (`recipe_id`, `name`, `cook_name`, `average_time`, `created_at`, `instructions`, `meal_type`) VALUES
                                                                                                                        (1, 'Spaghetti Carbonara', 'Kok Gino', 30, '2024-05-09 09:57:03', NULL, 'aftensmad'),
                                                                                                                        (2, 'Ratatouille', 'Kok Rémy', 45, '2024-05-09 09:57:03', NULL, 'aftensmad'),
                                                                                                                        (127, 'Kylling', 'Mads', 4, '2024-06-04 23:25:49', 'Steg kyllingen i olie.', 'frokost'),
                                                                                                                        (171, 'Pølser', 'Peter', 30, '2024-06-06 13:41:04', 'Put pølser i en gryde', 'morgenmad'),
                                                                                                                        (172, 'Grøntsagssuppe', 'Anna', 60, '2024-06-06 14:32:39', 'Kog alle grøntsagerne sammen.', 'aftensmad'),
                                                                                                                        (173, 'Pandekager', 'Lars', 20, '2024-06-07 07:30:00', 'Bland ingredienserne og steg pandekagerne.', 'morgenmad');

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `recipe_ingredients`
--

DROP TABLE IF EXISTS `recipe_ingredients`;
CREATE TABLE IF NOT EXISTS `recipe_ingredients` (
                                                    `recipe_id` int DEFAULT NULL,
                                                    `ingredient_id` int DEFAULT NULL,
                                                    `quantity` varchar(255) NOT NULL,
    KEY `ingredients_fk` (`ingredient_id`),
    KEY `recipe_fk` (`recipe_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Links recipes to their ingredients and specifies the amount needed.';

--
-- Data dump for tabellen `recipe_ingredients`
--

INSERT INTO `recipe_ingredients` (`recipe_id`, `ingredient_id`, `quantity`) VALUES
                                                                                (1, 1, '200 gram'),
                                                                                (1, 2, '4 enheder'),
                                                                                (1, 3, '100 gram'),
                                                                                (2, 4, '150 gram'),
                                                                                (127, 1, '500 gram'),
                                                                                (127, 8, '3 fed'),
                                                                                (171, 1, '200 gram'),
                                                                                (172, 4, '300 gram'),
                                                                                (172, 5, '200 gram'),
                                                                                (173, 2, '2 enheder'),
                                                                                (173, 9, '1 stk');

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
CREATE TABLE IF NOT EXISTS `subscriptions` (
                                               `subscription_id` int NOT NULL AUTO_INCREMENT,
                                               `user_id` int DEFAULT NULL,
                                               `start_date` datetime DEFAULT NULL,
                                               `end_date` datetime DEFAULT NULL,
                                               `status` enum('aktiv','inaktiv') DEFAULT NULL COMMENT 'Subscription status',
    PRIMARY KEY (`subscription_id`),
    KEY `subscriptions_user_user_id_fk` (`user_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Manages subscription details for users';

--
-- Data dump for tabellen `subscriptions`
--

INSERT INTO `subscriptions` (`subscription_id`, `user_id`, `start_date`, `end_date`, `status`) VALUES
                                                                                                   (1, 1, '2021-01-01 00:00:00', '2022-01-01 00:00:00', 'aktiv'),
                                                                                                   (2, 2, '2021-06-01 00:00:00', '2022-06-01 00:00:00', 'inaktiv'),
                                                                                                   (3, 3, '2021-07-01 00:00:00', '2022-07-01 00:00:00', 'aktiv'),
                                                                                                   (4, 4, '2021-08-01 00:00:00', '2022-08-01 00:00:00', 'inaktiv'),
                                                                                                   (5, 5, '2021-09-01 00:00:00', '2022-09-01 00:00:00', 'aktiv');

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
                                       `user_id` int NOT NULL AUTO_INCREMENT,
                                       `firstname` varchar(30) NOT NULL,
    `lastname` varchar(30) NOT NULL,
    `age` int NOT NULL,
    `height` int NOT NULL,
    `weight` int NOT NULL,
    `gender` varchar(30) NOT NULL,
    `activityLevel` varchar(50) NOT NULL,
    `goal` varchar(30) NOT NULL,
    `email` varchar(50) NOT NULL,
    `phone` int NOT NULL,
    `password_hash` varchar(255) NOT NULL,
    `created_at` datetime NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `email` (`email`)
    ) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores information about the users.';

--
-- Data dump for tabellen `users`
--

INSERT INTO `users` (`user_id`, `firstname`, `lastname`, `age`, `height`, `weight`, `gender`, `activityLevel`, `goal`, `email`, `phone`, `password_hash`, `created_at`) VALUES
                                                                                                                                                                            (1, 'John', 'Doe', 30, 180, 80, 'Mand', '1-2 gange om ugen', 'Byg muskel', 'john.doe@example.com', 2121212, '$2a$12$zm4obx9Li5PBVNq/VOC73e6/8ACR7tPBLrRdqZF8x622EKtilRutW', '2024-05-09 09:56:28'),
                                                                                                                                                                            (2, 'Jane', 'Smith', 22, 165, 55, 'Kvinde', '3-5 gange om ugen', 'Øg vægt', 'jane.smith@example.com', 3333, 'hashed_password2', '2024-05-09 09:56:28'),
                                                                                                                                                                            (3, 'Admin', 'Testen', 23, 173, 72, 'Mand', '1-2 gange om ugen', 'Tabe vægt', 'test@mail.com', 444444, '$2a$12$nqslPLAkzrttWqMWsTsTfOBSJrhz9QKn7joYOKp2Z6f8DaaOsqQpK', '2024-05-28 14:26:32'),
                                                                                                                                                                            (18, 'Mads', 'Flæske', 1, 1, 1, 'Mand', '6-7 gange om ugen', 'Beholde vægt', 'mads@example.com', 5555555, 'hashed_password4', '2024-06-03 10:36:44'),
                                                                                                                                                                            (19, 'Emil', 'Strongman', 1, 1, 1, 'Mand', 'Ingen eller meget lidt aktivitet', 'Beholde vægt', 'emil@example.com', 6666666, 'hashed_password5', '2024-06-03 10:38:36'),
                                                                                                                                                                            (20, 'Bjørn', 'Bjørn', 1, 1, 1, 'Mand', '3-5 gange om ugen', 'Byg muskel', 'bjorn@example.com', 777777, 'hashed_password6', '2024-06-06 00:58:11'),
                                                                                                                                                                            (21, 'Hans', 'Andersen', 29, 175, 70, 'Mand', '1-2 gange om dagen', 'Beholde vægt', 'hans.andersen@example.com', 88877777, 'hashed_password7', '2024-06-07 10:00:00'),
                                                                                                                                                                            (22, 'Sofie', 'Larsen', 25, 165, 60, 'Kvinde', '3-4 gange om ugen', 'Tabe vægt', 'sofie.larsen@example.com', 87767768, 'hashed_password8', '2024-06-07 11:00:00'),
                                                                                                                                                                            (23, 'Lars', 'Hansen', 35, 180, 80, 'Mand', '5-6 gange om ugen', 'Byg muskel', 'lars.hansen@example.com', 876876867, 'hashed_password9', '2024-06-07 12:00:00');

--
-- Begrænsninger for dumpede tabeller
--

--
-- Begrænsninger for tabel `recipe_ingredients`
--
ALTER TABLE `recipe_ingredients`
    ADD CONSTRAINT `ingredients_fk` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`ingredient_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `recipe_fk` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
