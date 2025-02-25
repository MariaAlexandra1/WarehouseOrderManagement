-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: warehouse
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `client` varchar(80) DEFAULT NULL,
  `product` varchar(45) DEFAULT NULL,
  `cantitate` int DEFAULT NULL,
  `pret` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES ('Alexandra','Masa',1,17),('Maria','Masa',1,17),('Alexandra','Masa',3,17),('Ale','Masa',2,17),('Andreea Radu','Memorie RAM Kingston 16GB',5,1750),('Andreea Radu','Router ASUS RT-AX86U',-2,-700),(NULL,NULL,-4,0);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(55) DEFAULT NULL,
  `adresa` varchar(70) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `clientcol1_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Maria','Bistrita','@yahoo.com'),(8,'John','Cluj','alee@gmail.com'),(13,'Ale','Bistrita','alexandrabuzila@gmail.com'),(22,'Alexandra','Bistrita','al@gmail'),(23,'Ion Popescu','Strada Florilor 10, Bucuresti','ion.popescu@example.com'),(24,'Maria Ionescu','Strada Libertatii 5, Cluj-Napoca','maria.ionescu@example.com'),(25,'Alexandru Marinescu','Bulevardul Unirii 20, Constanta','alexandru.marinescu@example.com'),(26,'Elena Vasile','Strada Independentei 3, Timisoara','elena.vasile@example.com'),(27,'George Mihai','Strada Pacii 15, Iasi','george.mihai@example.com'),(28,'Ana Georgescu','Strada Primaverii 22, Brasov','ana.georgescu@example.com'),(29,'Cristian Dumitru','Strada Eminescu 30, Sibiu','cristian.dumitru@example.com'),(30,'Laura Stoica','Strada Sperantei 9, Oradea','laura.stoica@example.com'),(31,'Andrei Radu','Strada Traian 12, Arad','andrei.radu@example.com'),(32,'Gabriela Iliescu','Strada Republicii 7, Ploiesti','gabriela.iliescu@example.com'),(33,'Mihai Popa','Bulevardul Victoriei 25, Craiova','mihai.popa@example.com'),(34,'Andreea Stanescu','Strada Aviatorilor 14, Galati','andreea.stanescu@example.com'),(35,'Razvan Andrei','Aleea Rozelor 8, Bacau','razvan.andrei@example.com'),(36,'Simona Moldovan','Bulevardul Dacia 18, Suceava','simona.moldovan@example.com'),(37,'Catalin Dragomir','Strada Unirii 4, Targu Mures','catalin.dragomir@example.com'),(38,'Ioana Radulescu','Bulevardul Tomis 35, Constanta','ioana.radulescu@example.com'),(39,'Adrian Dumitrascu','Strada Dorobantilor 11, Pitesti','adrian.dumitrascu@example.com'),(40,'Andreea Radu','Bulevardul Decebal 6, Botosani','andreea.radu@example.com'),(41,'Gabriel Stan','Strada Bucuresti 2, Braila','gabriel.stan@example.com'),(42,'Carmen Ionescu','Strada Victoriei 9, Timisoara','carmen.ionescu@example.com'),(43,'Alexandra Vasile','Strada Libertatii 12, Brasov','alexandra.vasile@example.com'),(44,'Cristian Popescu','Bulevardul Unirii 30, Cluj-Napoca','cristian.popescu@example.com'),(45,'Gabriela Ionescu','Strada Crangului 5, Iasi','gabriela.ionescu@example.com'),(46,'Marius Georgescu','Strada Republicii 14, Oradea','marius.georgescu@example.com'),(47,'Ana Maria Dumitru','Strada Mihai Viteazu 22, Sibiu','ana.dumitru@example.com'),(48,'Andrei Mihai','Strada Independentei 7, Timisoara','andrei.mihai@example.com'),(49,'Laura Stanescu','Bulevardul 1 Decembrie 1918 9, Alba Iulia','laura.stanescu@example.com'),(50,'George Popa','Strada Avram Iancu 3, Satu Mare','george.popa@example.com'),(51,'Elena Radu','Strada Vasile Alecsandri 11, Bacau','elena.radu@example.com'),(52,'Ion Dumitrescu','Strada Traian Vuia 20, Arad','ion.dumitrescu@example.com');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_c` int DEFAULT NULL,
  `id_p` int DEFAULT NULL,
  `cantitate_o` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (2,1,8,5),(3,8,1,4),(4,22,1,17),(5,3,1,4),(6,3,1,10),(7,22,1,2),(8,22,1,2),(9,22,1,2),(10,22,1,1),(11,1,1,1),(12,22,1,3),(13,13,1,2),(14,44,27,10),(15,34,11,2),(17,34,8,3),(18,40,10,5);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `denumire` varchar(45) DEFAULT NULL,
  `pret` double DEFAULT NULL,
  `cantitate` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Masa',17,6),(3,'Laptop Dell Inspiron',3200,50),(4,'Monitor Samsung 24\"',700,80),(5,'Mouse Logitech Wireless',100,200),(6,'Tastatura Mechanical Razer',450,120),(7,'SSD Samsung 1TB',800,60),(8,'Imprimanta HP LaserJet',1200,47),(9,'Router TP-Link AC1750',300,100),(10,'Memorie RAM Kingston 16GB',350,145),(11,'Camera Web Logitech HD',250,68),(12,'Smartphone Samsung Galaxy S22',3500,60),(13,'Televizor LG OLED 55\"',5000,30),(14,'Casti Bluetooth Sony',300,100),(15,'Tablet Apple iPad Pro 12.9\"',2000,40),(16,'Auriculari Apple AirPods Pro',800,80),(17,'Consola de jocuri PlayStation 5',4500,20),(18,'Boxe Wireless Bose',1500,50),(19,'Smartwatch Apple Watch Series 7',1200,70),(20,'Aparat foto DSLR Canon EOS',2500,45),(21,'Drone DJI Mavic Air 2',1800,25),(22,'Laptop Lenovo ThinkPad X1 Carbon',4000,35),(23,'Monitor ASUS 27\"',600,90),(24,'Mouse Microsoft Arc Touch',80,150),(25,'Tastatura Corsair K95 RGB Platinum',500,80),(26,'SSD WD Blue 2TB',1000,50),(27,'Imprimanta Epson EcoTank',700,67),(28,'Router ASUS RT-AX86U',350,122),(29,'Memorie RAM Corsair Vengeance LPX 32GB',600,70),(30,'Camera Web Microsoft LifeCam HD-3000',150,200),(31,'HDD WD Red 4TB',600,40);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'warehouse'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-22  1:41:33
