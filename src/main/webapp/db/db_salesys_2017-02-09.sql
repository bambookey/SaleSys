# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.7.11)
# Database: db_salesys
# Generation Time: 2017-02-09 03:46:21 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tb_good
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_good`;

CREATE TABLE `tb_good` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主自',
  `Title` varchar(100) DEFAULT NULL COMMENT '标题',
  `Summary` varchar(150) DEFAULT NULL COMMENT '摘要',
  `Text` varchar(1500) DEFAULT NULL COMMENT '正文',
  `ImgPath` varchar(200) DEFAULT NULL COMMENT '图片路径',
  `Prize` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `IsDeleted` tinyint(1) DEFAULT NULL COMMENT '删除标记',
  `UpdateDatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_good` WRITE;
/*!40000 ALTER TABLE `tb_good` DISABLE KEYS */;

INSERT INTO `tb_good` (`Id`, `Title`, `Summary`, `Text`, `ImgPath`, `Prize`, `IsDeleted`, `UpdateDatetime`)
VALUES
	(1,'地精高爆炸药','地精高爆炸药','地精高爆炸药','../upload/QQ20170131-231050@2x.png',0.50,0,'2017-02-09 11:41:50'),
	(3,'剥皮小刀','剥皮小刀','剥皮小刀','../upload/QQ20170131-231050@2x.png',33.00,0,'2017-02-09 11:41:50'),
	(5,'南海小桶','南海小桶','南海小桶','../upload/QQ20170129-150101@2x.png',11.00,0,'2017-02-09 11:41:50'),
	(10,'银鳞胸甲','银鳞胸甲','银鳞胸甲','../upload/QQ20170129-150101@2x.png',2.00,0,'2017-02-09 11:41:50'),
	(12,'幸运兔脚','幸运兔脚','幸运兔脚','',6.00,0,'2017-02-09 11:41:50');

/*!40000 ALTER TABLE `tb_good` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_shoppingRecord
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_shoppingRecord`;

CREATE TABLE `tb_shoppingRecord` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主自',
  `UserId` int(11) DEFAULT NULL COMMENT '用户Id',
  `GoodId` int(11) DEFAULT NULL COMMENT '商品Id',
  `GoodAmount` int(11) DEFAULT NULL COMMENT '商品量',
  `TotalMoney` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `InsertDatetime` datetime DEFAULT NULL COMMENT '交易日期',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_shoppingRecord` WRITE;
/*!40000 ALTER TABLE `tb_shoppingRecord` DISABLE KEYS */;

INSERT INTO `tb_shoppingRecord` (`Id`, `UserId`, `GoodId`, `GoodAmount`, `TotalMoney`, `InsertDatetime`)
VALUES
	(9,1,5,4,44.00,'2017-02-09 11:43:12'),
	(10,1,12,2,12.00,'2017-02-09 11:43:12');

/*!40000 ALTER TABLE `tb_shoppingRecord` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_trolley
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_trolley`;

CREATE TABLE `tb_trolley` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `GoodId` int(11) DEFAULT NULL,
  `Status` int(11) DEFAULT NULL COMMENT '购物车状态：0-新增；1-已结算；2-已取消；',
  `InsertDatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_trolley` WRITE;
/*!40000 ALTER TABLE `tb_trolley` DISABLE KEYS */;

INSERT INTO `tb_trolley` (`Id`, `UserId`, `GoodId`, `Status`, `InsertDatetime`)
VALUES
	(20,1,12,0,'2017-02-09 11:42:56'),
	(21,1,5,0,'2017-02-09 11:42:59'),
	(22,1,12,0,'2017-02-09 11:44:24');

/*!40000 ALTER TABLE `tb_trolley` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主自',
  `UserName` varchar(20) DEFAULT NULL COMMENT '用户名',
  `Password` varchar(100) DEFAULT NULL COMMENT '密码',
  `NickName` varchar(20) DEFAULT NULL,
  `Balance` decimal(10,2) DEFAULT NULL COMMENT '用户余额',
  `UserType` int(11) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;

INSERT INTO `tb_user` (`Id`, `UserName`, `Password`, `NickName`, `Balance`, `UserType`)
VALUES
	(1,'buyer','2120f72b4b5af10ddb9356903a6a5acb','buyer',100.00,1),
	(2,'seller','125a5f8f76f01a923347f61c30d46d33','seller',0.00,0);

/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
