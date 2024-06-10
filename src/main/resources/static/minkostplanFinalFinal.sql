CREATE DATABASE  IF NOT EXISTS `minkostplan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `minkostplan`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: minkostplan
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredients` (
  `ingredient_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` text,
  `calories` int DEFAULT NULL,
  `carbohydrate` int DEFAULT NULL,
  `fat` int DEFAULT NULL,
  `protein` int DEFAULT NULL,
  PRIMARY KEY (`ingredient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Contains different ingredients used in recipes.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (1,'Spaghetti','Lang, tynd, cylindrisk pasta af italiensk oprindelse',0,0,0,0),(2,'Æg','Økologiske fritgående æg',0,0,0,0),(3,'Bacon','Tykkere skiver af røget bacon',0,0,0,0),(4,'Zucchini','Frisk zucchini',0,0,0,0),(5,'Tomat','Modne tomater',0,0,0,0),(6,'Kartoffel','Danske kartofler',77,17,0,2),(7,'Løg','Friske løg',40,9,0,1),(8,'Hvidløg','Økologisk hvidløg',149,33,1,6),(9,'Gulerod','Friske gulerødder',41,10,0,1),(10,'Peberfrugt','Rød peberfrugt',31,6,0,1);
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profilepictures`
--

DROP TABLE IF EXISTS `profilepictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profilepictures` (
  `picture_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`picture_id`),
  KEY `profilepictures_fk` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Stores details about uploaded profile pictures.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profilepictures`
--

LOCK TABLES `profilepictures` WRITE;
/*!40000 ALTER TABLE `profilepictures` DISABLE KEYS */;
INSERT INTO `profilepictures` VALUES (1,1,1),(2,2,0),(3,3,1),(4,4,1),(5,5,0);
/*!40000 ALTER TABLE `profilepictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe_ingredients`
--

DROP TABLE IF EXISTS `recipe_ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe_ingredients` (
  `recipe_id` int DEFAULT NULL,
  `ingredient_id` int DEFAULT NULL,
  `quantity` varchar(255) NOT NULL,
  KEY `ingredients_fk` (`ingredient_id`),
  KEY `recipe_fk` (`recipe_id`),
  CONSTRAINT `ingredients_fk` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`ingredient_id`),
  CONSTRAINT `recipe_fk` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Links recipes to their ingredients and specifies the amount needed.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe_ingredients`
--

LOCK TABLES `recipe_ingredients` WRITE;
/*!40000 ALTER TABLE `recipe_ingredients` DISABLE KEYS */;
INSERT INTO `recipe_ingredients` VALUES (1,1,'200 gram'),(1,2,'4 enheder'),(1,3,'100 gram'),(2,4,'150 gram'),(127,1,'500 gram'),(127,8,'3 fed'),(171,1,'200 gram'),(172,4,'300 gram'),(172,5,'200 gram'),(173,2,'2 enheder'),(173,9,'1 stk'),(174,5,'100 gram'),(174,10,'1 stk');
/*!40000 ALTER TABLE `recipe_ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'Spaghetti Carbonara','Kok Gino',30,'2024-05-09 09:57:03',NULL,'aftensmad'),(2,'Ratatouille','Kok Rémy',45,'2024-05-09 09:57:03',NULL,'aftensmad'),(127,'Kylling','Mads',4,'2024-06-04 23:25:49','Steg kyllingen i olie.','frokost'),(171,'Pølser','Peter',30,'2024-06-06 13:41:04','Put pølser i en gryde','morgenmad'),(172,'Grøntsagssuppe','Anna',60,'2024-06-06 14:32:39','Kog alle grøntsagerne sammen.','aftensmad'),(173,'Pandekager','Lars',20,'2024-06-07 07:30:00','Bland ingredienserne og steg pandekagerne.','morgenmad'),(174,'Salat','Eva',15,'2024-06-07 12:00:00','Skær grøntsagerne og bland dem.','morgenmad');
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `subscription_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `status` enum('aktiv','inaktiv') DEFAULT NULL COMMENT 'Subscription status',
  PRIMARY KEY (`subscription_id`),
  KEY `subscriptions_user_user_id_fk` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Manages subscription details for users';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (1,1,'2021-01-01 00:00:00','2022-01-01 00:00:00','aktiv'),(2,2,'2021-06-01 00:00:00','2022-06-01 00:00:00','inaktiv'),(3,3,'2021-07-01 00:00:00','2022-07-01 00:00:00','aktiv'),(4,4,'2021-08-01 00:00:00','2022-08-01 00:00:00','inaktiv'),(5,5,'2021-09-01 00:00:00','2022-09-01 00:00:00','aktiv');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'John','Doe',30,180,80,'Mand','1-2 gange om ugen','Byg muskel','john.doe@example.com',2121212,'$2a$12$zm4obx9Li5PBVNq/VOC73e6/8ACR7tPBLrRdqZF8x622EKtilRutW','2024-05-09 09:56:28'),(2,'Jane','Smith',22,165,55,'Kvinde','3-5 gange om ugen','Øg vægt','jane.smith@example.com',3333,'hashed_password2','2024-05-09 09:56:28'),(3,'Admin','Testen',23,173,72,'Mand','1-2 gange om ugen','Tabe vægt','test@mail.com',444444,'$2a$12$nqslPLAkzrttWqMWsTsTfOBSJrhz9QKn7joYOKp2Z6f8DaaOsqQpK','2024-05-28 14:26:32'),(18,'Mads','Flæske',1,1,1,'Mand','6-7 gange om ugen','Beholde vægt','mads@example.com',5555555,'hashed_password4','2024-06-03 10:36:44'),(19,'Emil','Strongman',1,1,1,'Mand','Ingen eller meget lidt aktivitet','Beholde vægt','emil@example.com',6666666,'hashed_password5','2024-06-03 10:38:36'),(20,'Bjørn','Bjørn',1,1,1,'Mand','3-5 gange om ugen','Byg muskel','bjorn@example.com',777777,'hashed_password6','2024-06-06 00:58:11'),(21,'Hans','Andersen',29,175,70,'Mand','1-2 gange om dagen','Beholde vægt','hans.andersen@example.com',88877777,'hashed_password7','2024-06-07 10:00:00'),(22,'Sofie','Larsen',25,165,60,'Kvinde','3-4 gange om ugen','Tabe vægt','sofie.larsen@example.com',87767768,'hashed_password8','2024-06-07 11:00:00'),(23,'Lars','Hansen',35,180,80,'Mand','5-6 gange om ugen','Byg muskel','lars.hansen@example.com',876876867,'hashed_password9','2024-06-07 12:00:00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'minkostplan'
--

--
-- Dumping routines for database 'minkostplan'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-10  9:53:57
