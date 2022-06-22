CREATE DATABASE  IF NOT EXISTS `school_wall` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `school_wall`;
-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: school_wall
-- ------------------------------------------------------
-- Server version	8.0.29

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
INSERT INTO `sw_expand` VALUES (2,'webpage',NULL,'https://ding-f.gitee.io/medias/detail/logo.png','','https://ding-f.gitee.io/',1,'铸鼎_','swipe'),(3,'webpage',NULL,'http://www.szquanli.com/uploads/allimg/160326/2-160326092I1395.jpg',NULL,'https://cn.bing.com/',1,'必应','swipe'),(4,'webpage',NULL,'http://0.0.0.0:2121/schoolwall_fs/filedown/createdate=school_wall_imgs/filename=aku_logo.png',NULL,'http://www.aku.edu.cn/',1,'安康学院','swipe'),(5,'webpage',NULL,'chat-o',NULL,'https://ding-f.gitee.io/',1,'消息','select'),(6,'apppage',NULL,'edit','../publish/publish','https://ding-f.gitee.io/',1,'发帖','select'),(7,'webpage',NULL,'bullhorn-o',NULL,'https://ding-f.gitee.io/',1,'通知','select'),(8,'webpage',NULL,'warning-o',NULL,'https://ding-f.gitee.io/',1,'反馈','select');
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
  `user_id` bigint unsigned NOT NULL,
  `content` text NOT NULL,
  `receiver_id` bigint unsigned NOT NULL,
  `reply_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_father_reply`
--

LOCK TABLES `sw_father_reply` WRITE;
/*!40000 ALTER TABLE `sw_father_reply` DISABLE KEYS */;
INSERT INTO `sw_father_reply` VALUES (1,123,1,'你是哪位？？',1,'2022-03-17 20:22:42'),(10,123,3,'瓜多少钱一斤啊',1,'2022-03-16 20:35:12'),(15,122,3,'鸡汤来咯~',0,'2022-03-19 11:34:48'),(16,123,13,'水果真香！',1,'2022-04-26 17:45:46'),(17,123,13,'你好，请文明',1,'2022-04-26 17:55:23'),(18,123,13,'哈哈哈',1,'2022-04-28 00:08:48'),(20,123,13,'完成Bilibili评论列表2022-4-28',1,'2022-04-28 00:32:23'),(21,123,13,'测试5',1,'2022-04-28 00:35:00'),(22,123,13,'测试，返回Bug',1,'2022-04-28 00:50:16'),(23,123,13,'测试刷新',1,'2022-04-28 01:09:55'),(24,123,13,'测试回复刷新',1,'2022-04-28 01:19:25'),(25,123,13,'测试第二遍，回复刷新',1,'2022-04-28 01:21:14'),(26,123,13,'成功',1,'2022-04-28 01:21:25'),(27,321,118,'测试Left Join',1,'2022-05-16 17:17:05'),(28,123,13,'你好安康学院校园墙',1,'2022-05-19 09:35:23'),(29,123,13,'你好校园墙',1,'2022-05-19 09:45:30'),(30,1971,13,'I love you',1,'2022-05-19 09:47:28'),(31,1982,13,'成功测试文件上传并实现异步提交墙贴信息',1,'2022-05-20 19:06:08'),(32,1984,13,'准备实现个人评论列表获取',13,'2022-05-24 15:52:38'),(33,1983,13,'测试个人评论列表获取',13,'2022-05-24 15:53:29'),(34,1983,13,'你好，铸鼎',13,'2022-06-05 15:21:44'),(35,123,13,'生意行啊，哥几个',1,'2022-06-05 15:23:42');
/*!40000 ALTER TABLE `sw_father_reply` ENABLE KEYS */;
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
  `post_id` bigint unsigned NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_like`
--

LOCK TABLES `sw_like` WRITE;
/*!40000 ALTER TABLE `sw_like` DISABLE KEYS */;
INSERT INTO `sw_like` VALUES (1,1,123,'2022-03-15 23:21:50'),(3,3,100,'2022-03-15 23:28:48'),(4,2,123,'2022-05-31 16:01:26'),(6,2,1973,'2022-06-01 16:09:35'),(7,1,1973,'2022-06-01 16:09:54'),(8,3,1973,'2022-06-01 16:10:27'),(9,8,1973,'2022-06-01 16:11:02'),(10,13,1973,'2022-06-01 16:11:43');
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
  `category_thumbnail_image` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `categorie_name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_post_categories`
--

LOCK TABLES `sw_post_categories` WRITE;
/*!40000 ALTER TABLE `sw_post_categories` DISABLE KEYS */;
INSERT INTO `sw_post_categories` VALUES (1,'校园生活','爱校园，爱生活~','http://0.0.0.0:2121/schoolwall_fs/filedown/createdate=school_wall_imgs/filename=schoollife.jpeg'),(2,'表白','你眨一下眼，就翻阅了我心里的春夏秋冬。','http://0.0.0.0:2121/schoolwall_fs/filedown/createdate=school_wall_imgs/filename=love.jpg'),(3,'寻物','没有描述~','http://0.0.0.0:2121/schoolwall_fs/filedown/createdate=school_wall_imgs/filename=look_for.jpg'),(4,'二手交易','没有描述~','http://0.0.0.0:2121/schoolwall_fs/filedown/createdate=school_wall_imgs/filename=used.png'),(5,'建议','没有描述~',''),(6,'捞人','没有描述~','http://0.0.0.0:2121/schoolwall_fs/filedown/createdate=school_wall_imgs/filename=look_for.jpg'),(7,'交友','没有描述~',''),(8,'学习','没有描述~',''),(9,'推广','没有描述~',''),(10,'失物招领','没有描述~',''),(11,'广告','没有描述~',''),(12,'取件','没有描述~',''),(13,'游戏交友','没有描述~',''),(14,'测试','没有描述~',''),(17,'测试1','没有描述~',''),(18,'测试2','没有描述~','');
/*!40000 ALTER TABLE `sw_post_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_post_images`
--

DROP TABLE IF EXISTS `sw_post_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_post_images` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `post_id` bigint unsigned NOT NULL,
  `post_images` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint unsigned NOT NULL,
  `enable` enum('1','0') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_post_images`
--

LOCK TABLES `sw_post_images` WRITE;
/*!40000 ALTER TABLE `sw_post_images` DISABLE KEYS */;
INSERT INTO `sw_post_images` VALUES (1,123,'https:\\/\\/www.watch-life.net\\/images\\/2021\\/02\\/16122555351.png','2022-03-15 17:41:38',1,'1'),(2,123,'https:\\/\\/www.watch-life.net\\/images\\/2021\\/02\\/16122555901-300x276.png','2022-03-15 17:41:38',1,'1'),(3,123,'https:\\/\\/www.watch-life.net\\/images\\/2020\\/11\\/16114791451-300x82.png','2022-03-15 17:42:13',1,'1'),(4,123,'https://ding-f.gitee.io/images/error.jpg','2022-03-15 20:39:07',1,'1'),(5,123,'https://pic1.zhimg.com/v2-5042937383b97db699d3a0c37e60b490_b.jpg','2022-05-05 23:55:37',1,'1'),(12,123,'https://n.sinaimg.cn/sinakd10111/189/w640h349/20200723/b025-iwtqvyk4668955.jpg','2022-05-05 23:59:44',1,'1'),(13,123,'https://pic1.zhimg.com/v2-c7b8c102c77056169fac15eea9235a44_r.jpg','2022-05-05 23:59:44',1,'1'),(14,123,'https://pic1.zhimg.com/v2-c7b8c102c77056169fac15eea9235a44_r.jpg','2022-05-05 23:59:44',1,'1');
/*!40000 ALTER TABLE `sw_post_images` ENABLE KEYS */;
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
  `category_id` int unsigned NOT NULL DEFAULT '1',
  `post_image0` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '../../images/error.jpg',
  `post_image1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_image2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_image3` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_image4` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_image5` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_image6` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_image7` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_image8` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pageviews` int unsigned NOT NULL DEFAULT '0',
  `total_comments` int unsigned NOT NULL DEFAULT '0',
  `like_count` int unsigned NOT NULL DEFAULT '0',
  `enable` enum('1','0') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1',
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifi_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type_status_date` (`type`,`enable`,`date`,`id`),
  KEY `author` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1985 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_posts`
--

LOCK TABLES `sw_posts` WRITE;
/*!40000 ALTER TABLE `sw_posts` DISABLE KEYS */;
INSERT INTO `sw_posts` VALUES (6,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'../../images/error.jpg','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,135,23,56,'1','2022-03-10 19:55:41',NULL),(100,'找到对象了',1,'娶回家','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9999,99,999,'1','2022-03-12 10:37:17',NULL),(101,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,223,16,22,'1','2022-03-12 10:45:05',NULL),(102,'找到对象了',1,'娶回家','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9999,99,999,'1','2022-03-12 10:45:05',NULL),(103,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1111,11,111,'1','2022-03-12 10:45:05',NULL),(104,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,223,16,22,'1','2022-03-12 10:45:18',NULL),(105,'找到对象了',1,'娶回家','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9999,99,999,'1','2022-03-12 10:45:18',NULL),(106,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1111,11,111,'1','2022-03-12 10:45:18',NULL),(107,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,223,16,22,'1','2022-03-12 10:46:00',NULL),(108,'找到对象了',1,'娶回家','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9999,99,999,'1','2022-03-12 10:46:00',NULL),(109,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1111,11,111,'1','2022-03-12 10:46:00',NULL),(110,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,223,16,22,'1','2022-03-12 10:46:00',NULL),(111,'找到对象了',1,'娶回家','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9999,99,999,'1','2022-03-12 10:46:00',NULL),(112,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1111,11,111,'1','2022-03-12 10:46:00',NULL),(114,'找到对象了',1,'娶回家','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9999,99,999,'1','2022-03-12 10:46:18',NULL),(115,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1111,11,111,'1','2022-03-12 10:46:18',NULL),(116,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,223,16,22,'1','2022-03-12 10:46:18',NULL),(117,'找到对象了',1,'娶回家','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9999,99,999,'1','2022-03-12 10:46:18',NULL),(118,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'https://ding-f.gitee.io/images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1111,11,111,'1','2022-03-12 10:46:18',NULL),(119,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,223,16,22,'1','2022-03-12 10:46:18',NULL),(120,'找到对象了',1,'娶回家','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/kids.png',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9999,99,999,'1','2022-03-12 10:46:18',NULL),(121,'伞丢了',1,'在图书馆伞架子上放了一把伞一下午就消失了','post',3,'https://ding-f.gitee.io/images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1111,11,111,'1','2022-03-12 10:46:18',NULL),(122,'伞丢了',3,'在图书馆伞架子上放了一把伞一下午就消失了','post',1,'https://gitee.com/ding-f/school_wall_imgs/raw/master/posts/dog.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,223,16,22,'1','2022-03-12 10:46:18',NULL),(123,'水果摊',1,'卖瓜两块五一斤 <br> - 大西瓜来喽~   -大西瓜~   - ???~','post',4,'https://img2.baidu.com/it/u=3530793501,2812976182&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500','https:\\/\\/www.watch-life.net\\/images\\/2021\\/02\\/16122555351.png','https:\\/\\/www.watch-life.net\\/images\\/2021\\/02\\/16122555901-300x276.png','https:\\/\\/www.watch-life.net\\/images\\/2020\\/11\\/16114791451-300x82.png','https://ding-f.gitee.io/images/error.jpg','https://pic1.zhimg.com/v2-5042937383b97db699d3a0c37e60b490_b.jpg','https://n.sinaimg.cn/sinakd10111/189/w640h349/20200723/b025-iwtqvyk4668955.jpg','https://pic1.zhimg.com/v2-c7b8c102c77056169fac15eea9235a44_r.jpg',NULL,2222,22,222,'1','2022-03-16 16:33:06',NULL),(1967,'测试文件上传',1,'准备实现延时提醒弹窗','post',1,'../../images/error.jpg','f1e4b68e-e927-44e1-9100-b8b25d2d9d6a_vlgB9uF33BQI2eb09dcbeb20772ef9243c6062cf3878.png','6da9c88e-de23-4fcd-8675-ad203b0f9153_8oO58TFYNfdDea1feb1643f4544d6fd76efbaefea67d.png','d51e48ec-ed65-4d61-adfb-cddd0971dedc_lAJaBe3aJ4cMd2b8ddee0a4f7ed9d1535647778b0f8d.png','bf696b7b-4e9f-41f6-9608-96da46ed0a91_KqVJZtTnRPEve287c0f44cd123716ad64d7ba5b78eaa.png','90050afd-a4c4-4695-9396-9ca081274e09_WbhvGg1iiQO7e3bf3e0bcb3696d1c24d55c4754c6b92.png','7c2d3c9a-adb6-482b-9938-0a3216f432d3_f4FVRO0FxJpI67bb6b506fe8f6477009593e0cfc2b17.png',NULL,NULL,0,0,0,'1','2022-05-18 21:45:40',NULL),(1968,'测试文件上传2',1,'第二次测试','post',1,'../../images/error.jpg','5f17ca9e-a205-4183-b32b-80aad8cc61a7_AYEfdWjnLSSS6a00a8da66df30e26bb84e1bdb36e32d.jpg','b8d3e3de-1688-4afa-b30a-29c34d7061e7_QbXUQkjxy67vafb84200ed24748f5b516436b95a7955.jpeg','24a4d065-a0d5-4aa0-9b67-7b046a2460e4_ytEiephXvxxY5c23daaa17a4d24d384da929e8fb53d7.jpeg','df62d22c-7615-4611-a758-67fbdb12f13a_DwT93HUjrwfC49447a470e18164a7c21806ccfbccdd5.png',NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-18 21:55:45',NULL),(1969,'测试文件上传3',1,'准备实现提交延迟弹窗','post',1,'2351f5dc-23d5-42b6-88f7-aa38f6c3b58f_hgXIiPChwOOS6a00a8da66df30e26bb84e1bdb36e32d.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-18 21:59:25',NULL),(1970,'准备实现文章发布异步弹窗',1,'代码是写出来给人看的，附带能在机器上运行。。。。。。。。\n\n## I love you three thousand.','post',1,'0a0354f9-95a2-476b-917f-11002b1f2e0b_iSYmhSga2OYqe6c796aafa8f8699556837e8c7777e28.jpeg','8e8bba1e-936c-4b54-bbb4-a2b043d3c1a6_oKbwcEsqrDk8f0aaca5b6c3a64badb982b4581069a37.jpeg','01a40fee-f634-44db-8887-6c7443009c0b_gavzD8Er378n7a963264a9214fb075567f83f15dd42f.jpeg','5ccbae35-9e6a-40d4-8cc3-6a8905533cd0_bQ9bM4XPMQk7509e3eb54c4ea006b2e3fb3db19a5110.jpeg',NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-18 23:59:42',NULL),(1971,'I love you three thousand.',1,'## I love you three thousand.','post',2,'addac41f-ab28-45dc-9f9e-5a19f6812f97_ImRJlnzBxEI92ce27d8a87ba6ba15e01efe937ddfe9b.jpeg','5cc5feb7-1945-4dba-b07d-b003f3d9f6d7_ceGwpNz2RtMPf3cc2553b2c10185d4683eb4a288a0ae.jpeg','8fa78bf9-801f-4e24-86cd-80146fdab865_KlWTo690v5jV2ce27d8a87ba6ba15e01efe937ddfe9b.jpeg','bcbc8278-a49a-486f-bb0d-63762a45eac1_w56ewBz6n6eHf3cc2553b2c10185d4683eb4a288a0ae.jpeg','b284c411-fc56-4689-a247-04f72b0ac151_xQ34qQnGoiX4be06b6ed0f575f3f4bcbd1df1baf433d.jpeg','54ded005-47da-4b9f-9c91-f5a0aab021d6_Q3AwKE3FcTFZ2ce27d8a87ba6ba15e01efe937ddfe9b.jpeg','15a6c22d-c7ae-4ca9-a204-66382b4968bf_YmuB18tWBZxzf3cc2553b2c10185d4683eb4a288a0ae.jpeg','ee37aff6-1cd7-46d0-81b8-2b0d84f3a9cb_umvTEtZxM4k748da8a72db030b8ab9f7a73543f9dadd.jpeg','78ad4c25-f82c-4480-89cc-046437ccdeed_dx6HFf0913c7f3cc2553b2c10185d4683eb4a288a0ae.jpeg',0,0,0,'1','2022-05-19 00:08:55',NULL),(1972,'你好校园墙小程序',1,'白老师您好','post',1,'0f73124e-7ccd-4501-9c70-fcb0a1470df7_9dTcNWJll2Znf0aaca5b6c3a64badb982b4581069a37.jpeg','fab48843-8728-4016-ba4e-ac7a26494da8_eIl1TnYrfgDA7a963264a9214fb075567f83f15dd42f.jpeg','91e378ec-29e6-48bb-b248-d26ad9b1bb8b_S7LrksIw22hZ509e3eb54c4ea006b2e3fb3db19a5110.jpeg',NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-19 09:48:56',NULL),(1973,'测试分类',1,'## 墙贴分类测试','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-19 15:16:48',NULL),(1974,'测试异步弹窗',1,'## 异步','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 17:48:09',NULL),(1975,'测试异步弹窗',1,'Bug修复','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 18:14:42',NULL),(1976,'测试异步弹框',1,'修复不了 绕过组件库 BUG！！','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 18:27:07',NULL),(1977,'测试异步弹窗',1,'时间测试','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 18:33:39',NULL),(1978,'异步测试',1,'异步测试','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 18:35:31',NULL),(1979,'测试异步弹窗任务',1,'测试修复Bug','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 18:37:05',NULL),(1980,'测试异步弹窗任务',1,'测试修复Bug，附加图片测试','post',14,'70b9177b-3909-4e30-96c4-1d3d8f3c8094_Pszq8tLEoZFh0e9ad37049e28c3c8e248898f2d777a6.jpeg','9ef1ac87-f6ed-4add-8912-f5bf514c1baf_sChXJOW7PulCc4929ea79886dcf9b91cf512feb431ec.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 18:37:54',NULL),(1981,'测试文件上传',1,'测试','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 18:41:08',NULL),(1982,'测试文件上传',1,'9图','post',14,'2fe8b48c-5b86-4fc4-b281-444dc0f1fddc_pXgU9J06RVXAbe06b6ed0f575f3f4bcbd1df1baf433d.jpeg','bc2447a8-b670-4fad-8589-7f98579a22cf_ua6cVQdTdgT12ce27d8a87ba6ba15e01efe937ddfe9b.jpeg','7023036b-357e-4aa5-96d5-d31e91346e69_kX3nysj0cYYR48da8a72db030b8ab9f7a73543f9dadd.jpeg','5a1f5b20-77fb-432c-8e9c-0e363ead54a2_Odj0yAeh3Z3rf3cc2553b2c10185d4683eb4a288a0ae.jpeg','3ee16de2-89b3-4fe7-b087-9fa458796521_HNIw6o85iB48e6c796aafa8f8699556837e8c7777e28.jpeg','79bb2a2c-53a4-4460-bfa4-39e5b968d071_VbK7rTvL3Wlef0aaca5b6c3a64badb982b4581069a37.jpeg','a3ab467e-c4ef-4a86-88e9-bca0dda92a5b_qVLTK7MdhlP07a963264a9214fb075567f83f15dd42f.jpeg','52d474ff-77d8-47f1-9759-1f5209ac76bf_IyHZKSPN8j31602dcdeb50b16b5b617880ec09958a2a.png','9cd76fc0-5476-4b93-961f-44bd923e27fe_8L19tukSkZ8g509e3eb54c4ea006b2e3fb3db19a5110.jpeg',0,0,0,'1','2022-05-20 18:42:48',NULL),(1983,'发布墙贴作者添加',13,'- 作者：付鼎\n- 班级：计算机升本20级\n- 学院：电子与信息工程学院\n- 学校： 安康学院','post',14,'9f66f8e3-9f32-4708-bf27-d58f45bf9de1_rXTkDUtbeeus0e9ad37049e28c3c8e248898f2d777a6.jpeg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 19:08:42',NULL),(1984,'测试发布后跳转',13,'跳转并刷新','post',14,'../../images/error.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,0,'1','2022-05-20 19:28:17',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_son_reply`
--

LOCK TABLES `sw_son_reply` WRITE;
/*!40000 ALTER TABLE `sw_son_reply` DISABLE KEYS */;
INSERT INTO `sw_son_reply` VALUES (1,123,1,2,'我是演员李广奇',1,'2022-03-20 19:30:59'),(2,123,1,1,'来B站作甚么',2,'2022-03-20 19:32:10'),(3,123,1,2,'我来B站卖瓜',1,'2022-03-20 19:33:11'),(4,123,1,1,'来啊',2,'2022-03-20 19:34:16'),(8,123,10,2,'2.5一斤。',3,'2022-03-20 19:37:41'),(9,123,10,3,'瓜保熟吗',2,'2022-03-20 19:38:54'),(10,123,10,2,'你看现在哪有瓜，这都是大鹏的瓜。',3,'2022-03-20 19:39:39'),(11,123,10,13,'生意不错啊，哥几个。',2,'2022-04-28 00:08:09'),(12,123,1,13,'来啊',1,'2022-04-28 00:13:31'),(13,123,16,13,'nice',13,'2022-04-28 00:13:47'),(14,122,19,13,'没人',13,'2022-04-28 00:15:42'),(15,123,1,13,'测试',1,'2022-04-28 00:33:05'),(16,123,1,13,'测试2',13,'2022-04-28 00:33:43'),(17,123,1,13,'测试3',13,'2022-04-28 00:34:01'),(18,123,1,13,'测试4',13,'2022-04-28 00:34:43'),(19,123,1,13,'测试5',13,'2022-04-28 00:35:25'),(20,123,1,13,'测试6',13,'2022-04-28 00:35:41'),(21,123,1,13,'测试7',13,'2022-04-28 00:36:01'),(22,123,10,13,'哈喽华强',3,'2022-04-28 10:41:08'),(23,123,10,13,'你好安康学院校园墙',2,'2022-05-19 09:34:49'),(24,123,28,13,'用起来真不错',13,'2022-05-19 09:36:05'),(25,123,1,13,'你好安康学院校园墙',1,'2022-05-19 09:46:07'),(26,1984,32,13,'开始测试',13,'2022-05-24 15:52:49'),(27,1983,33,13,'测试获取个人评论列表按时间从新到旧排序混合子父评论',13,'2022-05-24 15:54:18');
/*!40000 ALTER TABLE `sw_son_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_user`
--

DROP TABLE IF EXISTS `sw_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_user` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `wx_id` char(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `student_num` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` char(3) COLLATE utf8mb4_unicode_ci DEFAULT '0',
  `avatar_url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nick_name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` tinyint DEFAULT '18',
  `phone` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `open_id` char(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `wx_name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `wx_avatar_url` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `use_mask` enum('1','0') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0',
  `enable` enum('1','0') COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1',
  `register_date` datetime DEFAULT CURRENT_TIMESTAMP,
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
INSERT INTO `sw_user` VALUES (1,'zhuding','f_ding@126.com',NULL,'3f2767d53c3f3ea65e50ec5185867660','0','https://ding-f.gitee.io/medias/detail/logo.png\n','铸鼎_',18,NULL,NULL,'1111','铸鼎_','https://ding-f.gitee.io/medias/detail/logo.png ','0','1','2022-03-16 15:44:17'),(2,'lvyiming','shuiguo@qq.com',NULL,'3f2767d53c3f3ea65e50ec5185867660','0','https:\\/\\/thirdwx.qlogo.cn\\/mmopen\\/vi_32\\/JTQ8vfn8CDFaNQ55EPtfVibEBESvV8UAb9E5JiahibwKLbKG41HJxRib2uhpleutD4EiajNKkibV7bQWb83qvxicQdaibQ\\/132','水果摊摊主',18,NULL,NULL,'2222','水果摊摊主','https:\\/\\/thirdwx.qlogo.cn\\/mmopen\\/vi_32\\/JTQ8vfn8CDFaNQ55EPtfVibEBESvV8UAb9E5JiahibwKLbKG41HJxRib2uhpleutD4EiajNKkibV7bQWb83qvxicQdaibQ\\/132','0','1','2022-03-16 15:44:17'),(3,'huaqiang','huaqiang@126.com',NULL,'93dff61f6518ca54e6c2e5b1e63e7683','0','https://syimg.3dmgame.com/uploadimg/xiaz/2021/0803/1627959355632.gif','华强',18,NULL,NULL,'3333','华强','https://syimg.3dmgame.com/uploadimg/xiaz/2021/0803/1627959355632.gif','0','1','2022-03-16 15:44:17'),(8,'Immortal','fuding@qq.com','2020020040','b1d57e4927313711853ed16a6dea0499','1',NULL,NULL,18,NULL,NULL,'4444','匿',NULL,'0','1','2022-04-19 00:30:09'),(13,'zhuding_1024','f_ding@168.com',NULL,NULL,'9','https://thirdwx.qlogo.cn/mmopen/vi_32/Ne1NOq8ScicXNY7U8qtbU4JXAGNKOuibrrRKDRHxHvPcR5EoD0K2cDIU1Xyk16yUdcKON61RRTRt0SianCegtsYzg/132',NULL,18,NULL,'f_ding@168.com','o7DTV4p5l0ZKoTL5Tu6-sfvmSTss','Immortal?','https://thirdwx.qlogo.cn/mmopen/vi_32/Ne1NOq8ScicXNY7U8qtbU4JXAGNKOuibrrRKDRHxHvPcR5EoD0K2cDIU1Xyk16yUdcKON61RRTRt0SianCegtsYzg/132','0','1','2022-04-22 23:18:59');
/*!40000 ALTER TABLE `sw_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sw_user_subscriptions`
--

DROP TABLE IF EXISTS `sw_user_subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sw_user_subscriptions` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL,
  `user_open_id` char(50) DEFAULT NULL,
  `post_categories_id` int NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sw_user_subscriptions`
--

LOCK TABLES `sw_user_subscriptions` WRITE;
/*!40000 ALTER TABLE `sw_user_subscriptions` DISABLE KEYS */;
INSERT INTO `sw_user_subscriptions` VALUES (5,1,NULL,13,'2022-05-21 17:51:45'),(6,1,NULL,6,'2022-05-21 17:51:45'),(7,1,NULL,2,'2022-05-21 21:44:02'),(23,13,'o7DTV4p5l0ZKoTL5Tu6-sfvmSTss',17,'2022-05-24 10:13:56'),(26,13,'o7DTV4p5l0ZKoTL5Tu6-sfvmSTss',1,'2022-05-27 23:28:55'),(27,13,'o7DTV4p5l0ZKoTL5Tu6-sfvmSTss',3,'2022-06-01 18:22:44'),(29,13,'o7DTV4p5l0ZKoTL5Tu6-sfvmSTss',2,'2022-06-01 18:22:48');
/*!40000 ALTER TABLE `sw_user_subscriptions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-16 17:09:59
