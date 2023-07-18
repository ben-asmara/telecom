-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: billing
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `Adminpassword` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (1,'GloriaNaomi','Glory1234','gloriafanmou@gmail.com'),(2,'IssaAsmara','Issa1234','issanodem@gmail.com');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camtelbundles`
--

DROP TABLE IF EXISTS `camtelbundles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `camtelbundles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `validity` varchar(50) DEFAULT NULL,
  `BName` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `Bdescription` varchar(255) NOT NULL,
  `ussdCode` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camtelbundles`
--

LOCK TABLES `camtelbundles` WRITE;
/*!40000 ALTER TABLE `camtelbundles` DISABLE KEYS */;
INSERT INTO `camtelbundles` VALUES (1,'30 days','Camtel surf1',149.00,'300Mo','*155*110*1#'),(2,'30 days','Camtel surf2',249.00,'500Mo','*155*120*1#'),(3,'07days','Camtel calls1 ',300.00,'500U','*155*122*3#'),(4,'14days','Camtel calls2',1000.00,'2500U','*155*135*4#'),(5,'14 days','Camtel international',5000.00,'10000U','*155*120*1#');
/*!40000 ALTER TABLE `camtelbundles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mtnbundles`
--

DROP TABLE IF EXISTS `mtnbundles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mtnbundles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `validity` varchar(50) DEFAULT NULL,
  `BName` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `Bdescription` varchar(255) NOT NULL,
  `ussdCode` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mtnbundles`
--

LOCK TABLES `mtnbundles` WRITE;
/*!40000 ALTER TABLE `mtnbundles` DISABLE KEYS */;
INSERT INTO `mtnbundles` VALUES (1,'30 days','MTN wanda net 1',149.00,'150Mo','*123*3*2*0*1#'),(2,'30 days','MTN wanda net 2',249.00,'250Mo','*123*3*2*0*2#'),(3,'30days','MtN wanda net 3',500.00,'500Mo','*123*3*2*0*5#'),(4,'30days','MTN wanda net 4',1000.00,'1Go','*123*3*2*0*6#'),(5,'07 days','MTN wanda Magic',5000.00,'4.5Go','*123*3*1*2#'),(6,'14 days','InternationalCall',2000.00,'5000U','*123*3*4*2#'),(7,'14 days','Forfait roaming',2500.00,'6000U','*123*3*0#'),(8,'14 days','MTN plus',150.00,'700U','*123*2#');
/*!40000 ALTER TABLE `mtnbundles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orangebundles`
--

DROP TABLE IF EXISTS `orangebundles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orangebundles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `validity` varchar(50) DEFAULT NULL,
  `BName` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `Bdescription` varchar(255) NOT NULL,
  `ussdCode` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orangebundles`
--

LOCK TABLES `orangebundles` WRITE;
/*!40000 ALTER TABLE `orangebundles` DISABLE KEYS */;
INSERT INTO `orangebundles` VALUES (1,'30 days','monthly surf1',139.00,'150Mo','#145*1*2*5#'),(2,'30 days','monthly surf2',249.00,'250Mo','#145*2*1*4#'),(3,'30days','monthly surf3',500.00,'500Mo','#145*2*1*3#'),(4,'30days','monthly surf4',1000.00,'1Go','#145*2*1*5#'),(5,'01 day','dayly surf1',50.00,'50Mo','#131*2#'),(6,'01 day','dayly surf2',150.00,'150Mo','#131*3#'),(7,'01 day','dayly surf3',300.00,'300Mo','#131*0#'),(8,'01 day','DayCalls',150.00,'700U','#131*2*1#'),(9,'7 days','My Plan Orange',5000.00,'7000U','#126*5#');
/*!40000 ALTER TABLE `orangebundles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `transaction_date` date DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `receiver_phone` varchar(20) DEFAULT NULL,
  `payer_phone` varchar(20) DEFAULT NULL,
  `amount` decimal(10,2) DEFAULT NULL,
  `bundle_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,'2023-07-07','username','receiverP','payerPh',500.00,'monthly surf3'),(2,'2023-07-07','username','receiverP','payerPh',1000.00,'monthly surf4'),(3,'2023-07-07','username','receiverP','payerPh',249.00,'monthly surf2'),(4,'2023-07-07','username','receiverP','payerPh',50.00,'dayly surf1'),(5,'2023-07-07','username','receiverP','payerPh',249.00,'monthly surf2');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(50) NOT NULL,
  `Lastname` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Phone_number` varchar(9) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Userpassword` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Gloria Naomi','Kouam Fanmou','kouamfanmoug@gmail.com','650018170','Glory','gloria123'),(2,'Ben Asmara','Issa Nodem ttt','issanodem@gmail.com','69384035','Issa','isaa123'),(4,'Brice','Ateba Etongue','briceateba@gmail.com','655589412','Brice','brice123'),(10,'','','','','',''),(11,'Ludovic','Kouame','ghghfgf','65236589','Ludo','123'),(12,'','','','','',''),(13,'','','','','','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-07 18:45:45
