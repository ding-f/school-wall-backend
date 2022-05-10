CREATE DATABASE  IF NOT EXISTS `school_wall` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `school_wall`;
-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: school_wall
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `sw_expand`
--

DROP TABLE IF EXISTS `sw_expand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_expand` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `type` char(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'webpage',
  `appid` char(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'https://ding-f.gitee.io/images/error.jpg',
  `path` varchar(160) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT 'https://ding-f.gitee.io/',
  `enable` int NOT NULL DEFAULT '1',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `select_swipe` char(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'swipe',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_expand`
--

LOCK TABLES `sw_expand` WRITE;
/*!40000 ALTER TABLE `sw_expand` DISABLE KEYS */;
INSERT INTO `sw_expand` VALUES (2,'webpage',NULL,'https://ding-f.gitee.io/medias/detail/logo.png','','https://ding-f.gitee.io/',1,'铸鼎_','swipe'),(3,'webpage',NULL,'http://www.szquanli.com/uploads/allimg/160326/2-160326092I1395.jpg',NULL,'https://cn.bing.com/',1,'必应','swipe'),(4,'webpage',NULL,'https://gitee.com/ding-f/school_wall_imgs/raw/master/aku_logo.png',NULL,'http://www.aku.edu.cn/',1,'安康学院','swipe'),(5,'webpage',NULL,'chat-o',NULL,'https://ding-f.gitee.io/',1,'消息','select'),(6,'apppage',NULL,'edit','../publish/publish','https://ding-f.gitee.io/',1,'发帖','select'),(7,'webpage',NULL,'bullhorn-o',NULL,'https://ding-f.gitee.io/',1,'通知','select'),(8,'webpage',NULL,'warning-o',NULL,'https://ding-f.gitee.io/',1,'反馈','select');
/*!40000 ALTER TABLE `sw_expand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_father_reply`
--

DROP TABLE IF EXISTS `sw_father_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_father_reply` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `post_id` bigint unsigned NOT NULL,
  `user_id` int unsigned NOT NULL,
  `content` text NOT NULL,
  `receiver_id` bigint unsigned NOT NULL,
  `reply_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_father_reply`
--

LOCK TABLES `sw_father_reply` WRITE;
/*!40000 ALTER TABLE `sw_father_reply` DISABLE KEYS */;
INSERT INTO `sw_father_reply` VALUES (1,123,1,'你是哪位？？',1,'2022-03-17 20:22:42'),(10,123,3,'瓜多少钱一斤啊',1,'2022-03-16 20:35:12'),(15,122,3,'鸡汤来咯~',0,'2022-03-19 11:34:48'),(16,123,13,'水果真香！',1,'2022-04-26 17:45:46'),(17,123,13,'你好，请文明',1,'2022-04-26 17:55:23'),(18,123,13,'哈哈哈',1,'2022-04-28 00:08:48'),(19,122,13,'有人吗',3,'2022-04-28 00:14:44'),(20,123,13,'完成Bilibili评论列表2022-4-28',1,'2022-04-28 00:32:23'),(21,123,13,'测试5',1,'2022-04-28 00:35:00'),(22,123,13,'测试，返回Bug',1,'2022-04-28 00:50:16'),(23,123,13,'测试刷新',1,'2022-04-28 01:09:55'),(24,123,13,'测试回复刷新',1,'2022-04-28 01:19:25'),(25,123,13,'测试第二遍，回复刷新',1,'2022-04-28 01:21:14'),(26,123,13,'成功',1,'2022-04-28 01:21:25');
/*!40000 ALTER TABLE `sw_father_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_images`
--

DROP TABLE IF EXISTS `sw_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_images` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `post_id` bigint unsigned NOT NULL,
  `post_images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint unsigned NOT NULL,
  `enable` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_images`
--

LOCK TABLES `sw_images` WRITE;
/*!40000 ALTER TABLE `sw_images` DISABLE KEYS */;
INSERT INTO `sw_images` VALUES (1,1959,'https:\\/\\/www.watch-life.net\\/images\\/2021\\/02\\/16122555351.png','2022-03-15 17:41:38',1,1),(2,1959,'https:\\/\\/www.watch-life.net\\/images\\/2021\\/02\\/16122555901-300x276.png','2022-03-15 17:41:38',1,1),(3,1959,'https:\\/\\/www.watch-life.net\\/images\\/2020\\/11\\/16114791451-300x82.png','2022-03-15 17:42:13',1,1),(4,100,'https://ding-f.gitee.io/images/error.jpg','2022-03-15 20:39:07',1,1);
/*!40000 ALTER TABLE `sw_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_like`
--

DROP TABLE IF EXISTS `sw_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_like` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL,
  `post_id` bigint NOT NULL,
  `enable` int DEFAULT '1',
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_like`
--

LOCK TABLES `sw_like` WRITE;
/*!40000 ALTER TABLE `sw_like` DISABLE KEYS */;
INSERT INTO `sw_like` VALUES (1,1,123,1,'2022-03-15 23:21:50'),(2,2,123,1,'2022-03-15 23:28:34'),(3,3,100,1,'2022-03-15 23:28:48');
/*!40000 ALTER TABLE `sw_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_post_categories`
--

DROP TABLE IF EXISTS `sw_post_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_post_categories` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '没有描述~',
  `category_thumbnail_image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `categorie_name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_post_categories`
--

LOCK TABLES `sw_post_categories` WRITE;
/*!40000 ALTER TABLE `sw_post_categories` DISABLE KEYS */;
INSERT INTO `sw_post_categories` VALUES (1,'校园生活','爱校园，爱生活~','https://gitee.com/ding-f/school_wall_imgs/raw/master/category/schoollife.jpeg'),(2,'表白','你眨一下眼，就翻阅了我心里的春夏秋冬。','https://gitee.com/ding-f/school_wall_imgs/raw/master/category/love.jpg'),(3,'寻物','没有描述~','https://gitee.com/ding-f/school_wall_imgs/raw/master/category/losejpeg.jpeg'),(4,'二手交易','没有描述~','https://gitee.com/ding-f/school_wall_imgs/raw/master/category/used.png'),(5,'建议','没有描述~',''),(6,'捞人','没有描述~','https://gitee.com/ding-f/school_wall_imgs/raw/master/category/look_for.jpg'),(7,'交友','没有描述~',''),(8,'学习','没有描述~',''),(9,'推广','没有描述~',''),(10,'失物招领','没有描述~',''),(11,'广告','没有描述~',''),(12,'取件','没有描述~',''),(13,'游戏交友','没有描述~',''),(14,'测试','没有描述~',''),(17,'测试1','没有描述~',''),(18,'测试2','没有描述~','');
/*!40000 ALTER TABLE `sw_post_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_posts`
--

DROP TABLE IF EXISTS `sw_posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_posts` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint NOT NULL DEFAULT '1',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'post',
  `post_medium_image` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '../../images/error.jpg',
  `total_comments` int unsigned NOT NULL DEFAULT '0',
  `like_count` int unsigned NOT NULL DEFAULT '0',
  `pageviews` int unsigned NOT NULL DEFAULT '0',
  `category_id` int unsigned NOT NULL DEFAULT '1',
  `enable` int NOT NULL DEFAULT '1',
  `modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `type_status_date` (`type`,`enable`,`date`,`id`),
  KEY `author` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1962 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_posts`
--

LOCK TABLES `sw_posts` WRITE;
/*!40000 ALTER TABLE `sw_posts` DISABLE KEYS */;
INSERT INTO `sw_posts` VALUES (6,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','../../images/error.jpg',23,56,135,3,1,'2022-03-10 20:01:25','2022-03-10 19:55:41'),(100,'找到对象了',1,'娶回家','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',99,999,9999,1,1,'2022-03-12 10:37:17','2022-03-12 10:37:17'),(101,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',16,22,223,3,1,'2022-03-12 10:45:05','2022-03-12 10:45:05'),(102,'找到对象了',1,'娶回家','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',99,999,9999,1,1,'2022-03-12 10:45:05','2022-03-12 10:45:05'),(103,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','../../images/error.jpg',11,111,1111,3,1,'2022-03-12 10:45:05','2022-03-12 10:45:05'),(104,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',16,22,223,3,1,'2022-03-12 10:45:18','2022-03-12 10:45:18'),(105,'找到对象了',1,'娶回家','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',99,999,9999,1,1,'2022-03-12 10:45:18','2022-03-12 10:45:18'),(106,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','../../images/error.jpg',11,111,1111,3,1,'2022-03-12 10:45:18','2022-03-12 10:45:18'),(107,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',16,22,223,3,1,'2022-03-12 10:46:00','2022-03-12 10:46:00'),(108,'找到对象了',1,'娶回家','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',99,999,9999,1,1,'2022-03-12 10:46:00','2022-03-12 10:46:00'),(109,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','../../images/error.jpg',11,111,1111,3,1,'2022-03-12 10:46:00','2022-03-12 10:46:00'),(110,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',16,22,223,3,1,'2022-03-12 10:46:00','2022-03-12 10:46:00'),(111,'找到对象了',1,'娶回家','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',99,999,9999,1,1,'2022-03-12 10:46:00','2022-03-12 10:46:00'),(112,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','../../images/error.jpg',11,111,1111,3,1,'2022-03-12 10:46:00','2022-03-12 10:46:00'),(114,'找到对象了',1,'娶回家','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',99,999,9999,1,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(115,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','../../images/error.jpg',11,111,1111,3,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(116,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',16,22,223,3,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(117,'找到对象了',1,'娶回家','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',99,999,9999,1,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(118,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://ding-f.gitee.io/images/error.jpg',11,111,1111,3,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(119,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',16,22,223,3,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(120,'找到对象了',1,'娶回家','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',99,999,9999,1,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(121,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://ding-f.gitee.io/images/error.jpg',11,111,1111,3,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(122,'伞丢了',3,'在图书馆伞架子上放了一把伞一下午就消失了','post','https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',16,22,223,1,1,'2022-03-12 10:46:18','2022-03-12 10:46:18'),(123,'水果摊',1,'卖瓜两块五一斤 <br> - 大西瓜来喽~   -大西瓜~   - ???~','post','https://img2.baidu.com/it/u=3530793501,2812976182&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500',22,222,2222,4,1,'2022-03-16 16:33:06','2022-03-16 16:33:06');
/*!40000 ALTER TABLE `sw_posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_son_reply`
--

DROP TABLE IF EXISTS `sw_son_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_son_reply` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `post_id` bigint unsigned NOT NULL,
  `father_reply_id` bigint unsigned NOT NULL,
  `user_id` bigint unsigned NOT NULL,
  `content` text NOT NULL,
  `receiver_id` bigint unsigned NOT NULL,
  `son_reply_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_son_reply`
--

LOCK TABLES `sw_son_reply` WRITE;
/*!40000 ALTER TABLE `sw_son_reply` DISABLE KEYS */;
INSERT INTO `sw_son_reply` VALUES (1,123,1,2,'我是你**。',1,'2022-03-20 19:30:59'),(2,123,1,1,'出来单挑啊？',2,'2022-03-20 19:32:10'),(3,123,1,2,'单挑啊',1,'2022-03-20 19:33:11'),(4,123,1,1,'来啊',2,'2022-03-20 19:34:16'),(8,123,10,2,'2.5一斤。',3,'2022-03-20 19:37:41'),(9,123,10,3,'皮瓜金子做的还是瓜粒子金子做的？   看，吸铁石，另外你说的瓜要是生的你自己吞进去？！',2,'2022-03-20 19:38:54'),(10,123,10,2,'你是故意找茬儿是不是？？',3,'2022-03-20 19:39:39'),(11,123,10,13,'你直接告诉他，你说几斤就几斤',2,'2022-04-28 00:08:09'),(12,123,1,13,'来啊',1,'2022-04-28 00:13:31'),(13,123,16,13,'nice',13,'2022-04-28 00:13:47'),(14,122,19,13,'没人',13,'2022-04-28 00:15:42'),(15,123,1,13,'测试',1,'2022-04-28 00:33:05'),(16,123,1,13,'测试2',13,'2022-04-28 00:33:43'),(17,123,1,13,'测试3',13,'2022-04-28 00:34:01'),(18,123,1,13,'测试4',13,'2022-04-28 00:34:43'),(19,123,1,13,'测试5',13,'2022-04-28 00:35:25'),(20,123,1,13,'测试6',13,'2022-04-28 00:35:41'),(21,123,1,13,'测试7',13,'2022-04-28 00:36:01'),(22,123,10,13,'哈喽华强',3,'2022-04-28 10:41:08');
/*!40000 ALTER TABLE `sw_son_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_user`
--

DROP TABLE IF EXISTS `sw_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `student_num` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `use_mask` enum('1','0') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0',
  `avatar_url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nick_name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` tinyint DEFAULT '18',
  `phone` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `open_id` char(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `wx_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `wx_avatar_url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `enable` enum('1','0') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1',
  `register_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `role` char(3) COLLATE utf8mb4_unicode_ci DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `open_id_UNIQUE` (`open_id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  UNIQUE KEY `student_num_UNIQUE` (`student_num`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `call_UNIQUE` (`phone`),
  UNIQUE KEY `nick_name_UNIQUE` (`nick_name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_user`
--

LOCK TABLES `sw_user` WRITE;
/*!40000 ALTER TABLE `sw_user` DISABLE KEYS */;
INSERT INTO `sw_user` VALUES (1,'f_ding@126.com',NULL,'3f2767d53c3f3ea65e50ec5185867660','0','https://ding-f.gitee.io/medias/detail/logo.png\n','铸鼎_',18,NULL,NULL,'1111','铸鼎_','https://ding-f.gitee.io/medias/detail/logo.png ','1','2022-03-16 15:44:17','0'),(2,'shuiguo@qq.com',NULL,'3f2767d53c3f3ea65e50ec5185867660','0','https:\\/\\/thirdwx.qlogo.cn\\/mmopen\\/vi_32\\/JTQ8vfn8CDFaNQ55EPtfVibEBESvV8UAb9E5JiahibwKLbKG41HJxRib2uhpleutD4EiajNKkibV7bQWb83qvxicQdaibQ\\/132','水果摊摊主',18,NULL,NULL,'2222','水果摊摊主','https:\\/\\/thirdwx.qlogo.cn\\/mmopen\\/vi_32\\/JTQ8vfn8CDFaNQ55EPtfVibEBESvV8UAb9E5JiahibwKLbKG41HJxRib2uhpleutD4EiajNKkibV7bQWb83qvxicQdaibQ\\/132','1','2022-03-16 15:44:17','0'),(3,'huaqiang@126.com',NULL,'93dff61f6518ca54e6c2e5b1e63e7683','0','https://syimg.3dmgame.com/uploadimg/xiaz/2021/0803/1627959355632.gif','华强',18,NULL,NULL,'3333','华强','https://syimg.3dmgame.com/uploadimg/xiaz/2021/0803/1627959355632.gif','1','2022-03-16 15:44:17','0'),(8,'fuding@qq.com','2020020040','b1d57e4927313711853ed16a6dea0499','0',NULL,NULL,18,NULL,NULL,'4444','匿',NULL,'1','2022-04-19 00:30:09','1'),(13,'f_ding@168.com',NULL,NULL,'0','https://thirdwx.qlogo.cn/mmopen/vi_32/Ne1NOq8ScicXNY7U8qtbU4JXAGNKOuibrrRKDRHxHvPcR5EoD0K2cDIU1Xyk16yUdcKON61RRTRt0SianCegtsYzg/132',NULL,18,NULL,'f_ding@168.com','o7DTV4p5l0ZKoTL5Tu6-sfvmSTss','Immortal?','https://thirdwx.qlogo.cn/mmopen/vi_32/Ne1NOq8ScicXNY7U8qtbU4JXAGNKOuibrrRKDRHxHvPcR5EoD0K2cDIU1Xyk16yUdcKON61RRTRt0SianCegtsYzg/132','1','2022-04-22 23:18:59','0');
/*!40000 ALTER TABLE `sw_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-29 21:14:14
