-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Vært: 127.0.0.1:3306
-- Genereringstid: 28. 05 2024 kl. 14:33:55
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
                                             PRIMARY KEY (`ingredient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Contains different ingredients used in recipes.';

--
-- Data dump for tabellen `ingredients`
--

INSERT INTO `ingredients` (`ingredient_id`, `name`, `description`) VALUES
                                                                       (1, 'Spaghetti', 'Long, thin, cylindrical pasta of Italian origin'),
                                                                       (2, 'Egg', 'Organic free-range eggs'),
                                                                       (3, 'Bacon', 'Thick slices of smoked bacon'),
                                                                       (4, 'Zucchini', 'Fresh zucchini'),
                                                                       (5, 'Tomato', 'Ripe tomatoes');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores details about uploaded profile pictures.';

--
-- Data dump for tabellen `profilepictures`
--

INSERT INTO `profilepictures` (`picture_id`, `user_id`, `status`) VALUES
                                                                      (1, 1, 1),
                                                                      (2, 2, 0);

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
                                         PRIMARY KEY (`recipe_id`),
                                         UNIQUE KEY `unique_recipe_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores details about various recipes.';

--
-- Data dump for tabellen `recipes`
--

INSERT INTO `recipes` (`recipe_id`, `name`, `cook_name`, `average_time`, `created_at`, `instructions`) VALUES
                                                                                                           (1, 'Spaghetti Carbonara', 'Chef Gino', 30, '2024-05-09 09:57:03', NULL),
                                                                                                           (2, 'Ratatouille', 'Chef Rémy', 45, '2024-05-09 09:57:03', NULL);

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
                                                                                (1, 1, '200 grams'),
                                                                                (1, 2, '4 units'),
                                                                                (1, 3, '100 grams'),
                                                                                (2, 4, '150 grams'),
                                                                                (2, 5, '200 grams');

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
                                               `status` enum('active','inactive') DEFAULT NULL COMMENT 'Subscription status',
                                               PRIMARY KEY (`subscription_id`),
                                               KEY `subscriptions_user_user_id_fk` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Manages subscription details for users';

--
-- Data dump for tabellen `subscriptions`
--

INSERT INTO `subscriptions` (`subscription_id`, `user_id`, `start_date`, `end_date`, `status`) VALUES
                                                                                                   (1, 1, '2021-01-01 00:00:00', '2022-01-01 00:00:00', 'active'),
                                                                                                   (2, 2, '2021-06-01 00:00:00', '2022-06-01 00:00:00', 'inactive');

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
                                       `password_hash` varchar(255) NOT NULL,
                                       `created_at` datetime NOT NULL,
                                       PRIMARY KEY (`user_id`),
                                       UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores information about the users.';

--
-- Data dump for tabellen `users`
--

INSERT INTO `users` (`user_id`, `firstname`, `lastname`, `age`, `height`, `weight`, `gender`, `activityLevel`, `goal`, `email`, `password_hash`, `created_at`) VALUES
                                                                                                                                                                   (1, 'John', 'Doe', 30, 180, 80, 'male', '1-2 gange om ugen', 'build muscle', 'john.doe@example.com', '$2a$12$zm4obx9Li5PBVNq/VOC73e6/8ACR7tPBLrRdqZF8x622EKtilRutW', '2024-05-09 09:56:28'),
                                                                                                                                                                   (2, 'Jane', 'Smith', 22, 165, 55, 'female', '3-5 gange om ugen', 'gain weight', 'jane.smith@example.com', 'hashed_password2', '2024-05-09 09:56:28'),
                                                                                                                                                                   (3, 'test', 'testen', 20, 172, 72, 'male', '1-2 gange om ugen', 'Gain', 'test@mail.com', '$2a$12$nqslPLAkzrttWqMWsTsTfOBSJrhz9QKn7joYOKp2Z6f8DaaOsqQpK', '2024-05-28 14:26:32'),
                                                                                                                                                                   (11, 'Mads', 'Madsen', 2, 2, 2, 'male', '3-5 gange om ugen', 'keep current weight', 'sdfdsf@safsdfsdf.com', '$2a$10$l3DG8u3N04nbyRYxubHYIO25T6Bd6x7UclKSFMRG3uK4SsMroU9Ta', '2024-05-28 16:28:57'),
                                                                                                                                                                   (12, 'Mads', 'Madsen', 3, 3, 3, 'male', '1-2 gange om dagen', 'keep current weight', 'onlinebigchungus@gmail.com', '$2a$10$Syj5u3iGl5f0HvyBwYANZ.2EnOyn5m9Z43lvriRC7uUiEYJO9PLg2', '2024-05-28 16:30:24');

--
-- Begrænsninger for dumpede tabeller
--

--
-- Begrænsninger for tabel `profilepictures`
--
ALTER TABLE `profilepictures`
    ADD CONSTRAINT `profilepictures_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Begrænsninger for tabel `recipe_ingredients`
--
ALTER TABLE `recipe_ingredients`
    ADD CONSTRAINT `ingredients_fk` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`ingredient_id`),
    ADD CONSTRAINT `recipe_fk` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`);

--
-- Begrænsninger for tabel `subscriptions`
--
ALTER TABLE `subscriptions`
    ADD CONSTRAINT `subscriptions_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
