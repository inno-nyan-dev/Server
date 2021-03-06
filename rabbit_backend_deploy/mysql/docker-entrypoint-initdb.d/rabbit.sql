-- MariaDB dump 10.19  Distrib 10.5.9-MariaDB, for Linux (x86_64)
--
-- Host: 3.17.102.92    Database: rabbit
-- ------------------------------------------------------
-- Server version	5.7.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `product_image_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `product_dang_level` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Dangerousity level',
  `product_description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

INSERT INTO `products` VALUES (1,'Herb','1.jpg','safe','Herbs are the kind of food rabbits are born to digest. Feeding them herbs ensures that the digestion processes are intact and functioning normally. There are many types of herbs that one can buy in the shops, human-edible are okay too. Self-produced herbs are also very good, for example good ones: medicago, pisum, avena, rye, wheat, dandelions, or plain hay.');
INSERT INTO `products` VALUES (2,'Toxic herbs','2.jpg','prohibited','Some herbs are poisonous in their pure form. These include: ranunculus, hymlice, lilies-of-the-valley, hellebore, henbane, celandine. After drying, the toxicity decreases either fully or partly.');
INSERT INTO `products` VALUES (3,'Potato','4.jpg','safe','Potatoes do not contain a lot of vitamins, but they\'re full of starch that\'s easily digested. Moreover, it\'s the most available vegetable. Before feeding the potatoes to the animal, it should be boiled and then mashed. Plain bulbs are fed seldom. Boiled potatoes are recommended.');
INSERT INTO `products` VALUES (4,'Carrot','5.jpg','safe','Carrot contains a lot of vitamins, volatile oils, minerals and fat acids. When fed to rabbits, an increase in appetite is observed. It is fed in fresh form or in sliced.');
INSERT INTO `products` VALUES (5,'Pumpkin','6.jpg','safe','Pumpkins is similar to marrows. It contains a lot of vitamins and carotine. Should be cut onto pieces before feeding.');
INSERT INTO `products` VALUES (6,'Marrow','7.jpg','with_care','Marrow is a nutritious vegetable. It contains a lot of water, which is good for the gastro-intestinal tract. Note, however, that because of this the amount of plain water fed to the animal should be decreased. Marrow is usually fed during summer and fall.');
INSERT INTO `products` VALUES (7,'Cabbage','8.jpg','with_care','Cabbage is eaten by rabbits with much pleasure, but it should be fed in limited amounts. This is because it causes swelling. The animal should be accustomed to this food gradually. Cabbage contains a lot of vitamins, water, fibers and microelements needed for active growth and reproduction.');
INSERT INTO `products` VALUES (8,'Beet','9.jpg','safe','Only sugare of forage beet is edible. It improves the structure of blood. It contains such useful substances as sugar, proteins, fats and microelements. 50 grams on one adult rabbit per day is enough.');
INSERT INTO `products` VALUES (9,'Strawberry','10.jpg','safe','Strawberry contains a lot of vitamins and is extraordinary luscious. Can be fed as an enitre shrub.');
INSERT INTO `products` VALUES (10,'Respberry','11.jpg','safe','Raspberry is low on calories and is rich with vitamins. Decreases temperature, restores appetite. Can be fed as an entire shrub.');
INSERT INTO `products` VALUES (11,'Cranberry','12.jpg','safe','Cranberry boosts the immunity and cures bladder inflammation.');
INSERT INTO `products` VALUES (12,'Blackberry','13.jpg','safe','Blackberry cures inflammation of respiratory ways. Contains tannins and vitamins A, C.');
INSERT INTO `products` VALUES (13,'Blueberry','14.jpg','safe','Blueberry is low on calories, rich of minerals. Causes diarrhea if fed too much. Can be fed as an entire shrub.');
INSERT INTO `products` VALUES (14,'Grape','15.jpg','safe','Grapes contain lots and lots of sugers. Berries are fed without seeds.');
INSERT INTO `products` VALUES (15,'Melon','16.jpg','safe','Melon possesses diuretic effect, removes fever. Berries are fed without seeds.');
INSERT INTO `products` VALUES (16,'Banana','17.jpg','with_care','Bananas contains a lot of fibers, potassium and magenesium, vitamins B needed for healthy and beautiful fur, good appetite, quick growth and mental stability. The banana peels are preffered to be fed, since they contain more fibers. Too much of this fruit intails some risks: digestion disorder, overweigth, and risk of poisonning via chemicals used during banana\'s processing.');

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

INSERT INTO `users` VALUES (6,'bozman@gmail.com','9f735e0df9a1ddc702bf0a1a7b83033f9f7153a00c29de82cedadc9957289b05','6a36494591fbaa1eee1afd54636783f1acb4e48ebd4fdcb1fda4424ffce74415');
INSERT INTO `users` VALUES (7,'bozman2@gmail.com','9f735e0df9a1ddc702bf0a1a7b83033f9f7153a00c29de82cedadc9957289b05','58bb8a14b8ba06ab713322bc6af9b8d6884958ab8c27537f57017b750f96c038');
INSERT INTO `users` VALUES (8,'123@gmail.com','9f735e0df9a1ddc702bf0a1a7b83033f9f7153a00c29de82cedadc9957289b05','7261639f5073b9741d13c6e932472a68d5ddba05e71c03406ebbda513b1ba0aa');
INSERT INTO `users` VALUES (9,'oninbo','9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08','d4140c09f05b0aeb29b58489d75bb43da943efbb5266b41a25878aa949d8db54');
INSERT INTO `users` VALUES (10,'hello','5a0588f74d72cf58db217762c571eb29580755ae7c718dc8683f3830c57f0981','0b135511cf7cfe58095603f374c95394b2be12e17b2bcfc0ff9406496171670b');
SET FOREIGN_KEY_CHECKS = 1;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites` (
                             `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
                             `user_id` int(10) unsigned NOT NULL,
                             `product_id` int(10) unsigned NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `fav_prod_id` (`product_id`),
                             CONSTRAINT `fav_prod_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
