-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: tasklist
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `title` varchar(45) NOT NULL,
                            `completed_count` bigint DEFAULT '0',
                            `uncompleted_count` bigint DEFAULT '0',
                            PRIMARY KEY (`id`),
                            KEY `index_title` (`title`) /*!80000 INVISIBLE */
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (167,'Семья',1,2),(168,'Работа',1,1),(169,'Купить',0,1),(170,'Отдых',NULL,2),(171,'Путешествия',1,0),(173,'Обучение',1,2),(179,'Спорт',0,2),(180,'Здоровье',1,2);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `priority`
--

DROP TABLE IF EXISTS `priority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `priority` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `title` varchar(45) NOT NULL,
                            `color` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `index_title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `priority`
--

LOCK TABLES `priority` WRITE;
/*!40000 ALTER TABLE `priority` DISABLE KEYS */;
INSERT INTO `priority` VALUES (56,'Низкий','#44c371'),(57,'Средний','#883bdc'),(58,'Высокий','#f05f5f');
/*!40000 ALTER TABLE `priority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stat`
--

DROP TABLE IF EXISTS `stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `stat` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `completed_total` bigint DEFAULT '0',
                        `uncompleted_total` bigint DEFAULT '0',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stat`
--

LOCK TABLES `stat` WRITE;
/*!40000 ALTER TABLE `stat` DISABLE KEYS */;
INSERT INTO `stat` VALUES (1,5,12);
/*!40000 ALTER TABLE `stat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
SET character_set_client = utf8mb4 ;
CREATE TABLE `task` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                        `completed` int DEFAULT '0',
                        `date` datetime DEFAULT NULL,
                        `priority_id` bigint DEFAULT NULL,
                        `category_id` bigint DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_category_idx` (`category_id`),
                        KEY `fk_priority_idx` (`priority_id`),
                        KEY `index_title` (`title`),
                        KEY `index_completed` (`completed`),
                        KEY `index_date` (`date`),
                        CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT,
                        CONSTRAINT `fk_priority` FOREIGN KEY (`priority_id`) REFERENCES `priority` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=357 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (328,'Позвонить родителям',1,'2020-04-29 15:27:11',58,167),(331,'Посмотреть мультики',0,'2020-04-27 15:27:29',57,167),(333,'Пройти курсы по Java',0,'2020-04-30 09:38:39',56,173),(338,'Сделать зеленый коктейль',0,'2020-04-27 15:27:34',56,180),(339,'Купить буханку хлеба',0,'2020-04-28 07:03:03',57,169),(341,'Позвонить начальнику',0,'2020-05-06 09:38:23',NULL,168),(342,'Померить давление',0,'2020-05-01 09:38:46',NULL,180),(343,'Начать бегать по утрам',0,NULL,56,179),(344,'Отжаться 100 раз',0,NULL,58,179),(349,'Найти развивающие игры для детей',0,'2020-04-29 09:38:51',57,167),(350,'Купить лекарство',1,'2020-04-30 09:38:43',56,180),(351,'Выучить Kotlin',0,'2020-05-06 09:38:37',58,173),(352,'Посмотреть ролики как построить дом',1,NULL,NULL,173),(353,'Посмотреть сериал',0,'2020-04-29 09:38:29',NULL,170),(354,'Съездить на природу',0,'2020-04-15 18:00:00',NULL,170),(355,'Создать список стран для путешествий',1,'2020-04-29 09:38:26',NULL,171),(356,'Доделать отчеты',1,'2020-04-30 09:38:20',NULL,168);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-29 15:42:23
