-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Vært: 127.0.0.1:3306
-- Genereringstid: 09. 06 2024 kl. 13:37:06
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
                                                                                                                     (7, 'Løg', 'Friske løg', 40, 9, 0, 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores details about various recipes.';

--
-- Data dump for tabellen `recipes`
--

INSERT INTO `recipes` (`recipe_id`, `name`, `cook_name`, `average_time`, `created_at`, `instructions`, `meal_type`) VALUES
                                                                                                                        (1, 'Ratatouille ', 'fgdf', 30, '2024-05-09 09:57:03', 'dfg', 'aftensmad'),
                                                                                                                        (127, 'Kylling', 'Mads', 4, '2024-06-04 23:25:49', 'Steg kyllingen i olie.', 'morgenmad'),
                                                                                                                        (171, 'Pølser', 'Peter', 30, '2024-06-06 13:41:04', 'Put pølser i en gryde', 'middagsmad'),
                                                                                                                        (172, 'Grøntsagssuppe', 'Annaa', 60, '2024-06-06 14:32:39', 'Kog alle grøntsagerne sammen.', 'aftensmad'),
                                                                                                                        (249, 'Spaghetti Carbonaraaa', 'sdf', 3, '2024-06-09 14:31:56', 'sdf', 'morgenmad');

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
                                                                                (127, 1, '500 gram'),
                                                                                (171, 1, '200 gram'),
                                                                                (172, 4, '300 gram'),
                                                                                (172, 5, '200 gram'),
                                                                                (249, 1, '15ml'),
                                                                                (249, 2, '200gram');

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
                                       `activityLevel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                       `goal` varchar(30) NOT NULL,
                                       `email` varchar(50) NOT NULL,
                                       `phone` int NOT NULL,
                                       `password_hash` varchar(255) NOT NULL,
                                       `created_at` datetime NOT NULL,
                                       PRIMARY KEY (`user_id`),
                                       UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores information about the users.';

--
-- Data dump for tabellen `users`
--

INSERT INTO `users` (`user_id`, `firstname`, `lastname`, `age`, `height`, `weight`, `gender`, `activityLevel`, `goal`, `email`, `phone`, `password_hash`, `created_at`) VALUES
                                                                                                                                                                            (1, 'John', 'Doe', 30, 180, 80, 'mand', '1-2 gange om ugen', 'Byg muskel', 'john.doe@example.com', 52342432, '$2a$12$zm4obx9Li5PBVNq/VOC73e6/8ACR7tPBLrRdqZF8x622EKtilRutW', '2024-05-09 09:56:28'),
                                                                                                                                                                            (2, 'Jane', 'Smith', 22, 165, 55, 'kvinde', '3-5 gange om ugen', 'Øg vægt', 'jane.smith@example.com', 63454354, 'hashed_password2', '2024-05-09 09:56:28'),
                                                                                                                                                                            (3, 'Mads', 'Madsen', 23, 173, 72, 'Male', '3-5 gange om ugen', 'Beholde vægt', 'test@mail.com', 45252334, '$2a$12$nqslPLAkzrttWqMWsTsTfOBSJrhz9QKn7joYOKp2Z6f8DaaOsqQpK', '2024-05-28 14:26:32'),
                                                                                                                                                                            (144, 'Mads', 'Madsen', 23, 2, 60, 'Mand', '3-5 times a week', 'Tabe vægt', 'masdassenarbejdsmail@gmail.com', 51957478, '$2a$10$oYyS6ncHYdgpyyu/ZX.H6OruiyB0h6FhYy488VqmHC.jKEL2g0u4C', '2024-06-08 22:08:17'),
                                                                                                                                                                            (146, 'Mads', 'Madsen', 23, 2, 60, 'Mand', '3-5 times a week', 'Tabe vægt', 'massdassenarbejdsmail@gmail.com', 51957478, '$2a$10$MjOjmagr7VXRWoH/Hc4ga.YK33ac8/wMe71ovIsdM4t56DvpmRBQW', '2024-06-08 22:10:13'),
                                                                                                                                                                            (147, 'Mads', 'Madsen', 23, 2, 60, 'Mand', '3-5 times a week', 'Tabe vægt', 'massdassdfssenarbejdsmail@gmail.com', 51957478, '$2a$10$iCc2z.Le9Rs0mZcpUYyV8OrkxrUVdO9ETzlpkstEwcpCNZGE5GbTO', '2024-06-08 22:13:59'),
                                                                                                                                                                            (152, 'Mads', 'Madsen', 234, 234, 234, 'Mand', '3-5 times a week', 'Tabe vægt', 'tesst@mail.com', 51957478, '$2a$10$6lh6b9IQnrpjDrux65JzkOpv0V7rHkkXF4Q5XP2BVgzyikYQ5fgS.', '2024-06-08 22:18:36'),
                                                                                                                                                                            (161, 'Mads', 'Madsen', 302, 196, 60, 'Mand', '3-5 times a week', 'Tabe vægt', 'onlinebigchungus@gmail.com', 51957478, '$2a$10$V0ZqxC/Y3Q8vxN4nWAeO9u86wV4ifw02KEk9DMvPnwgc5kXtlIELe', '2024-06-08 22:31:23');

--
-- Begrænsninger for dumpede tabeller
--

--
-- Begrænsninger for tabel `recipe_ingredients`
--
ALTER TABLE `recipe_ingredients`
    ADD CONSTRAINT `fk_recipe_id` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`) ON DELETE CASCADE,
    ADD CONSTRAINT `ingredients_fk` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`ingredient_id`) ON DELETE CASCADE,
    ADD CONSTRAINT `recipe_fk` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
