-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Vært: 127.0.0.1:3306
-- Genereringstid: 23. 05 2024 kl. 21:20:45
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
                                                                       (5, 'Tomato', 'Ripe tomatoes'),
                                                                       (8, 'egon', 'olsen'),
                                                                       (9, 'wf', 'sdf'),
                                                                       (10, 'adsa', 'asdas'),
                                                                       (11, 'ads', 'asdad'),
                                                                       (12, 'asd', 'asd'),
                                                                       (13, 'ads', 'sfsd'),
                                                                       (14, 'adsaa', 'asda'),
                                                                       (15, 'asdasdadsadaasdsadasda', 'adasasdasasas'),
                                                                       (16, 'ads', 'sfsd'),
                                                                       (17, 'sfsdasdasdadsadada', 'dasdasdasdadsaddasdsaas'),
                                                                       (18, 'sadasdasdasdas', 'adadadaasd');

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
                                                                                                           (2, 'Ratatouille', 'Chef Rémy', 45, '2024-05-09 09:57:03', NULL),
                                                                                                           (21, 'peterss', 'kat', 3, '2024-05-23 23:10:36', 'hej egons'),
                                                                                                           (24, 'petersssssss', 'katssssss', 3, '2024-05-23 23:11:00', 'hej egons');

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
                                                                                (2, 5, '200 grams'),
                                                                                (21, 8, '200gram'),
                                                                                (24, 9, '23'),
                                                                                (21, 10, 'asdad'),
                                                                                (21, 11, 'ada'),
                                                                                (21, 12, '2'),
                                                                                (21, 14, 'asd'),
                                                                                (21, 15, 'sdasasdasd'),
                                                                                (21, 17, 'asdasdas'),
                                                                                (21, 18, 'adsadadasdadasdasd');

-- --------------------------------------------------------

--
-- Struktur-dump for tabellen `profilepictures`
--

DROP TABLE IF EXISTS `profilepictures`;
CREATE TABLE IF NOT EXISTS `profilepictures` (
                                       `picture_id` int NOT NULL AUTO_INCREMENT,
                                       `user_id` int DEFAULT NULL,
                                       `status` int NOT NULL
                                       PRIMARY KEY (`step_id`),
    KEY `profilepictures_fk` (`user_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores details about uploaded profilepictures.';

--
-- Data dump for tabellen `profilepictures`
--

INSERT INTO `profilepictures` (`picture_id`, `user_id`, `status`) VALUES
                                                                               (1, 1, 1),
                                                                               (2, 2, 0)

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
    `goal` varchar(30) NOT NULL,
    `email` varchar(50) NOT NULL,
    `password_hash` varchar(255) NOT NULL,
    `created_at` datetime NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `email` (`email`)
    ) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores information about the users.';

--
-- Data dump for tabellen `users`
--

INSERT INTO `users` (`user_id`, `firstname`, `lastname`, `age`, `height`, `weight`, `gender`, `goal`, `email`, `password_hash`, `created_at`) VALUES
                                                                                                                                                  (1, 'John', 'Doe', 30, 180, 80, 'male', 'build muscle', 'john.doe@example.com', '$2a$12$zm4obx9Li5PBVNq/VOC73e6/8ACR7tPBLrRdqZF8x622EKtilRutW', '2024-05-09 09:56:28'),
                                                                                                                                                  (2, 'Jane', 'Smith', 22, 165, 55, 'female', 'gain weight', 'jane.smith@example.com', 'hashed_password2', '2024-05-09 09:56:28'),
                                                                                                                                                  (3, 'test', 'test', 21, 150, 50, 'male', 'gain weight', 'test@mail.com', '$2a$12$Dh8ZI7nUARf8tkZ4iAIVz.Omnw2AJwijigUBGpGhm33AdCg7X8cjW', '2024-05-20 22:20:10'),
                                                                                                                                                  (7, 'Emil', 'test', 21, 21, 21, 'male', 'keep current weight', 'Emilkroldrup@outlook.com', '$2a$10$fMRw6VfxuA0q3JR8kAG15OrNIU28ayp749DogPu1kAYKA0oN31WyC', '2024-05-21 10:55:59');

--
-- Begrænsninger for dumpede tabeller
--

--
-- Begrænsninger for tabel `recipe_ingredients`
--
ALTER TABLE `recipe_ingredients`
    ADD CONSTRAINT `ingredients_fk` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`ingredient_id`),
  ADD CONSTRAINT `recipe_fk` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`);

--
-- Begrænsninger for tabel `steps`
--
ALTER TABLE `profilepictures`
    ADD CONSTRAINT `profilepictures_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Begrænsninger for tabel `subscriptions`
--
ALTER TABLE `subscriptions`
    ADD CONSTRAINT `subscriptions_user_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
