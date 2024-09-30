CREATE DATABASE  IF NOT EXISTS `shop_page` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop_page`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: shop_page
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Home & Decor'),(2,'Clothing'),(3,'Accessories'),(4,'Outdoor');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discounts`
--

DROP TABLE IF EXISTS `discounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discounts` (
  `discount_id` bigint NOT NULL AUTO_INCREMENT,
  `end_time` datetime(6) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `value` double DEFAULT NULL,
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discounts`
--

LOCK TABLES `discounts` WRITE;
/*!40000 ALTER TABLE `discounts` DISABLE KEYS */;
INSERT INTO `discounts` VALUES (1,'2024-10-07 12:44:38.000000','2024-09-27 12:44:38.000000',10),(2,'2024-10-04 12:44:38.000000','2024-09-27 12:44:38.000000',20),(3,'2024-10-08 12:44:38.000000','2024-09-27 12:44:38.000000',30),(4,'2024-10-09 12:44:38.000000','2024-09-27 12:44:38.000000',40),(5,'2024-10-05 12:44:38.000000','2024-09-27 12:44:38.000000',10),(6,'2024-10-05 12:44:38.000000','2024-09-27 12:44:38.000000',20),(7,'2024-10-07 12:44:38.000000','2024-09-27 12:44:38.000000',30);
/*!40000 ALTER TABLE `discounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `images` (
  `image_id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `detail_id` bigint DEFAULT NULL,
  PRIMARY KEY (`image_id`),
  KEY `FK9y108q2hp67ck35bontjxcpru` (`detail_id`),
  CONSTRAINT `FK9y108q2hp67ck35bontjxcpru` FOREIGN KEY (`detail_id`) REFERENCES `product_details` (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (87,'http://example.com/image1.jpg',44),(88,'http://example.com/image2.jpg',45),(89,'http://example.com/image3.jpg',46),(90,'http://example.com/image4.jpg',47),(91,'http://example.com/image5.jpg',48),(92,'http://example.com/image6.jpg',49),(93,'http://example.com/image7.jpg',50),(94,'http://example.com/image8.jpg',51),(95,'http://example.com/image9.jpg',52),(96,'http://example.com/image10.jpg',53),(97,'http://example.com/image11.jpg',54),(98,'http://example.com/image12.jpg',55),(99,'http://example.com/image13.jpg',56),(100,'http://example.com/image14.jpg',57),(101,'http://example.com/image15.jpg',58),(102,'http://example.com/image16.jpg',44),(103,'http://example.com/image17.jpg',45),(104,'http://example.com/image18.jpg',46),(105,'http://example.com/image19.jpg',47),(106,'http://example.com/image20.jpg',48),(107,'http://example.com/image21.jpg',49),(108,'http://example.com/image22.jpg',50),(109,'http://example.com/image23.jpg',51),(110,'http://example.com/image24.jpg',52),(111,'http://example.com/image25.jpg',53),(112,'http://example.com/image26.jpg',54),(113,'http://example.com/image27.jpg',55),(114,'http://example.com/image28.jpg',56),(115,'http://example.com/image29.jpg',57),(116,'http://example.com/image30.jpg',58),(117,'http://example.com/image31.jpg',44),(118,'http://example.com/image32.jpg',45),(119,'http://example.com/image33.jpg',46),(120,'http://example.com/image34.jpg',47),(121,'http://example.com/image35.jpg',48),(122,'https://example.com/image36.jpg',59),(123,'https://example.com/image37.jpg',59);
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_details`
--

DROP TABLE IF EXISTS `product_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_details` (
  `detail_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `looked_at` int NOT NULL,
  `reviewed` int NOT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  UNIQUE KEY `UKd8itpicgj364s8ud8ge17m4qe` (`product_id`),
  CONSTRAINT `FKnfvvq3meg4ha3u1bju9k4is3r` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_details`
--

LOCK TABLES `product_details` WRITE;
/*!40000 ALTER TABLE `product_details` DISABLE KEYS */;
INSERT INTO `product_details` VALUES (44,'This T-shirt is made from 100% cotton',150,30,55),(45,'A pair of high-quality denim jeans',200,50,56),(46,'A warm jacket for winter',120,40,57),(47,'Comfortable sneakers for everyday use',250,60,58),(48,'Stylish dress suitable for any occasion',180,45,59),(49,'Casual shorts made from breathable fabric',140,35,60),(50,'A wool sweater to keep you warm',110,20,61),(51,'A-line skirt with a modern design',100,25,62),(52,'A trendy cap perfect for outdoor activities',160,33,63),(53,'Leather belt with a metallic buckle',140,31,64),(54,'A soft scarf to complement your winter look',130,27,65),(55,'Comfy socks made from premium cotton',170,29,66),(56,'A classic blazer for formal wear',200,50,67),(57,'Tank top made from lightweight material',130,26,68),(58,'Durable boots suitable for hiking',210,52,69),(59,'This is a Short Kaki.',0,0,70);
/*!40000 ALTER TABLE `product_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_variants`
--

DROP TABLE IF EXISTS `product_variants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_variants` (
  `variant_id` bigint NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `detail_id` bigint DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`variant_id`),
  KEY `FKslqhqxmb4uqmcmc98sc8kkt0g` (`detail_id`),
  CONSTRAINT `FKslqhqxmb4uqmcmc98sc8kkt0g` FOREIGN KEY (`detail_id`) REFERENCES `product_details` (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_variants`
--

LOCK TABLES `product_variants` WRITE;
/*!40000 ALTER TABLE `product_variants` DISABLE KEYS */;
INSERT INTO `product_variants` VALUES (87,'Green','S','Modern',44,10),(88,'Green','M','Streetwear',44,15),(89,'Purple','L','Colorfull',44,20),(90,'Pink','XL','Patchwork',44,25),(91,'Black','S','Bohemian',45,30),(92,'Green','M','Vintage',45,12),(93,'Purple','L','Modern',46,18),(94,'Pink','XL','Streetwear',46,22),(95,'Black','S','Colorfull',46,19),(96,'Green','M','Patchwork',47,17),(97,'Purple','L','Bohemian',47,23),(98,'Pink','XL','Vintage',48,25),(99,'Black','S','Modern',48,15),(100,'Green','M','Streetwear',49,30),(101,'Purple','L','Colorfull',49,28),(102,'Pink','XL','Patchwork',50,35),(103,'Black','S','Bohemian',50,19),(104,'Green','M','Vintage',51,18),(105,'Purple','L','Modern',51,22),(106,'Pink','XL','Streetwear',52,25),(107,'Black','S','Colorfull',52,15),(108,'Green','M','Patchwork',53,18),(109,'Purple','L','Bohemian',53,20),(110,'Pink','XL','Vintage',54,30),(111,'Black','S','Modern',55,12),(112,'Green','M','Streetwear',56,14),(113,'Purple','L','Colorfull',57,18),(114,'Pink','XL','Patchwork',58,22),(115,'Black','M','Sport',59,5),(116,'Green','M','Sport',59,5);
/*!40000 ALTER TABLE `product_variants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `original_price` double DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `discount_id` bigint DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`),
  KEY `FK5cyj7v7fvm60i2ubciqfo2wxm` (`discount_id`),
  CONSTRAINT `FK5cyj7v7fvm60i2ubciqfo2wxm` FOREIGN KEY (`discount_id`) REFERENCES `discounts` (`discount_id`),
  CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (55,'https://example.com/mainImg1.jpg','T-Shirt',19.99,4.5,1,1),(56,'https://example.com/mainImg2.jpg','Jeans',39.99,4.7,2,7),(57,'https://example.com/mainImg3.jpg','Jacket',59.99,4.8,3,NULL),(58,'https://example.com/mainImg4.jpg','Sneakers',49.99,4.6,4,2),(59,'https://example.com/mainImg5.jpg','Dress',29.99,4.5,2,NULL),(60,'https://example.com/mainImg6.jpg','Shorts',24.99,4.4,1,NULL),(61,'https://example.com/mainImg7.jpg','Sweater',34.99,4.6,3,NULL),(62,'https://example.com/mainImg8.jpg','Skirt',25.99,4.3,3,3),(63,'https://example.com/mainImg9.jpg','Cap',14.99,4.2,1,NULL),(64,'https://example.com/mainImg10.jpg','Belt',15.99,4.1,2,4),(65,'https://example.com/mainImg11.jpg','Scarf',19.99,4.5,1,4),(66,'https://example.com/mainImg12.jpg','Socks',9.99,4,3,NULL),(67,'https://example.com/mainImg13.jpg','Blazer',79.99,4.8,4,5),(68,'https://example.com/mainImg14.jpg','Tank Top',18.99,4.3,1,6),(69,'https://example.com/mainImg15.jpg','Boots',89.99,4.7,4,NULL),(70,'https://example.com/mainImg16.jpg','Short Kaki',99.99,0,1,2);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-30 18:29:58
