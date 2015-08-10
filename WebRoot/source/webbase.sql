/*
SQLyog v10.2 
MySQL - 5.1.47-community : Database - webbase
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`webbase` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `webbase`;

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `email` varchar(100) DEFAULT NULL COMMENT '用户email',
  `username` varchar(45) DEFAULT NULL,
  `vipStatus` int(11) DEFAULT '1' COMMENT 'VIP会员状态(1 默认 非VIP 2 VIP 3 待续费VIP)',
  `authStep` int(11) DEFAULT '1' COMMENT '认证步骤(默认是1  个人详细信息 2  工作认证 3上传 资料)',
  `enable` int(11) DEFAULT '1' COMMENT '是否禁用 1、启用 2、禁用 3.黑名单 默认1',
  `password` varchar(100) DEFAULT NULL COMMENT '用户密码',
  `dealpwd` varchar(100) DEFAULT NULL COMMENT '交易密码(初始密码为用户密码)',
  `mobilePhone` varchar(20) DEFAULT NULL COMMENT '用户移动电话',
  `refferee` varchar(20) DEFAULT NULL COMMENT '推荐人',
  `rating` int(11) DEFAULT '0' COMMENT '网站积分',
  `creditrating` int(11) DEFAULT '0' COMMENT '信用积分',
  `lastIP` varchar(50) DEFAULT NULL COMMENT '最后登录IP',
  `lastDate` datetime DEFAULT NULL COMMENT '最后登录时间',
  `vipCreateTime` datetime DEFAULT NULL COMMENT 'VIP创建时间',
  `creditLimit` bigint(11) DEFAULT '3000' COMMENT '信用额度',
  `headImg` varchar(200) DEFAULT NULL COMMENT '头像',
  `createTime` datetime DEFAULT NULL COMMENT '帐号创建时间',
  `content` text COMMENT '用户vip申请会员时候填写的备注',
  `usableSum` decimal(18,2) DEFAULT '0.00' COMMENT '可用金额',
  `freezeSum` decimal(18,2) DEFAULT '0.00' COMMENT '冻结金额',
  `dueinSum` decimal(18,2) DEFAULT '0.00' COMMENT '待收金额',
  `dueoutSum` decimal(18,2) DEFAULT '0.00' COMMENT '待还金额',
  `kefuId` bigint(20) DEFAULT NULL COMMENT '客服Id',
  `adminId` bigint(11) DEFAULT NULL COMMENT '后台审核员id',
  `groupId` bigint(20) DEFAULT NULL COMMENT '组ID',
  `usableCreditLimit` bigint(20) DEFAULT '3000' COMMENT '可用信用额度',
  `creditlimtor` bigint(11) DEFAULT NULL COMMENT '额度审核审核员id',
  `vipFee` decimal(18,2) DEFAULT '0.00' COMMENT 'vip会费',
  `feeStatus` int(11) unsigned DEFAULT '1' COMMENT '费用扣除状态( 1 待扣 2 已扣)',
  `loginCount` bigint(20) DEFAULT '0' COMMENT '登录次数',
  `lockTime` datetime DEFAULT NULL COMMENT '锁定时间',
  `cashStatus` int(11) DEFAULT '1' COMMENT '提现状态(默认1 启动 2 禁止)',
  `xmax` decimal(18,2) DEFAULT '0.00' COMMENT '最大待收本金',
  `x` decimal(18,2) DEFAULT '0.00' COMMENT '系数',
  `xmin` decimal(18,2) DEFAULT '0.00' COMMENT '最小值',
  `isFirstVip` int(11) DEFAULT '1' COMMENT '是否首次成为VIP(默认 1 是 2 否)',
  `sign` varchar(50) DEFAULT NULL,
  `sign2` varchar(50) DEFAULT NULL,
  `loginErrorCount` int(10) DEFAULT '0' COMMENT '错误登录次数，默认0',
  `isLoginLimit` int(10) DEFAULT '1' COMMENT '1.不限制登录 2.限制登录',
  `isApplyPro` int(10) DEFAULT '1',
  `pIpsAcctNo` varchar(30) DEFAULT NULL COMMENT 'IPS托管平台账号',
  `pIpsBillNo` varchar(30) DEFAULT NULL COMMENT '自动投标签约签署授权号',
  `pIpsAuthNo` varchar(30) DEFAULT NULL COMMENT '自动还款签约授权号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_user_id` (`id`) USING BTREE,
  UNIQUE KEY `index_user_username` (`username`) USING BTREE,
  UNIQUE KEY `index_user_email` (`email`) USING BTREE,
  UNIQUE KEY `index_user_mobilePhone` (`mobilePhone`) USING BTREE,
  KEY `index_user_adminid` (`adminId`) USING BTREE,
  KEY `index_user_vipstatus` (`vipStatus`) USING BTREE,
  KEY `index_user_usablesum` (`usableSum`) USING BTREE,
  KEY `index_user_kefuId` (`kefuId`) USING BTREE,
  KEY `index_user_groupid` (`groupId`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

LOCK TABLES `t_user` WRITE;

insert  into `t_user`(`id`,`email`,`username`,`vipStatus`,`authStep`,`enable`,`password`,`dealpwd`,`mobilePhone`,`refferee`,`rating`,`creditrating`,`lastIP`,`lastDate`,`vipCreateTime`,`creditLimit`,`headImg`,`createTime`,`content`,`usableSum`,`freezeSum`,`dueinSum`,`dueoutSum`,`kefuId`,`adminId`,`groupId`,`usableCreditLimit`,`creditlimtor`,`vipFee`,`feeStatus`,`loginCount`,`lockTime`,`cashStatus`,`xmax`,`x`,`xmin`,`isFirstVip`,`sign`,`sign2`,`loginErrorCount`,`isLoginLimit`,`isApplyPro`,`pIpsAcctNo`,`pIpsBillNo`,`pIpsAuthNo`) values (1,'hx201@yopmail.com','zheng',2,5,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',7,53,'127.0.0.1','2014-09-02 14:58:55','2014-12-20 10:43:10',100000,NULL,'2014-08-29 19:53:47',NULL,'999183.65','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'10.00',2,8,NULL,1,'0.00','0.00','0.00',2,'6d373b2ed3dd1c0db34afb12ae5e8892','a0cf73b967184c1613ce51dd422f3759',0,1,2,'4021000030150649',NULL,'20140829000119'),(2,'hx202@yopmail.com','hx202',2,5,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',3,95,'127.0.0.1','2014-09-01 14:34:44','2014-12-20 10:43:10',100000,NULL,'2014-08-29 20:03:02',NULL,'999923.33','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'10.00',2,3,NULL,1,'0.00','0.00','0.00',2,'afa787936fbbb0032d7a5d7f4b1f418f','f20ec1a963837d9ab9d0db4643f2cb7f',0,1,2,'4021000030150850',NULL,'20140829000120'),(3,'hx203@yopmail.com','hx203',2,5,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',1,85,'127.0.0.1','2014-08-29 20:08:00','2014-12-20 10:43:10',100000,NULL,'2014-08-29 20:07:50',NULL,'1000000.00','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'10.00',2,1,NULL,1,'0.00','0.00','0.00',2,'7c75783f22efd49c90e5613b1a93ab8f','e950b888581e619a0d90ea373f340338',0,1,2,'4021000030151025',NULL,'20140829000121'),(4,'hx204@yopmail.com','hx204',2,5,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',2,84,'127.0.0.1','2014-09-05 16:20:59','2014-12-20 10:43:10',100000,NULL,'2014-08-29 20:12:22',NULL,'1000000.00','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'10.00',2,2,NULL,1,'0.00','0.00','0.00',2,'818b448c42457d148633f2b55c26cb04','692e0aa7b1bc877fbae4253e42c90cf0',0,1,2,'4021000030151237',NULL,NULL),(5,'hx205@yopmail.com','hx205',2,2,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',82,0,'127.0.0.1','2014-09-04 15:52:45','2014-08-29 20:25:13',100000,NULL,'2014-08-29 20:16:36',NULL,'1000086.15','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'10.00',2,8,NULL,1,'0.00','0.00','0.00',2,'9a0dcfbe639f2d88080aaadc83b7a5b2','f9a321d888e617ce0a4a6011d2783e70',0,1,2,'4021000030151449',NULL,NULL),(6,'hx206@yopmail.com','hx206',2,2,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',106,0,'127.0.0.1','2014-09-01 14:36:18','2014-08-29 20:24:57',100000,NULL,'2014-08-29 20:19:03',NULL,'1000006.64','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'10.00',2,6,NULL,1,'0.00','0.00','0.00',2,'e8d81e02ecb1c6df80b6749509ed2398','f24b9d3c6f83e0439c4b7a030082f52b',0,1,2,'4021000030151650',NULL,NULL),(7,'hx207@yopmail.com','hx207',2,2,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',115,0,'127.0.0.1','2014-09-01 10:59:53','2014-12-20 10:43:10',100000,NULL,'2014-08-29 20:21:24',NULL,'1000140.97','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'10.00',2,6,NULL,1,'0.00','0.00','0.00',2,'b800225d8efaac2c9e862d8e79874471','9de0b73d0e2b7cc7017037d1a7c31b36',0,1,2,'4021000030151853',NULL,NULL),(8,'hx208@yopmail.com','hx208',1,2,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',69,0,'127.0.0.1','2014-09-01 10:49:37',NULL,100000,NULL,'2014-08-29 20:21:41',NULL,'1000083.30','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,4,NULL,1,'0.00','0.00','0.00',1,'bd009de8fe2b49adacac3a53e66319ee','9ab05ff47709e89cc7c3543974eab084',0,1,2,'4021000030152037',NULL,NULL),(9,'hx209@yopmail.com','hx209',1,2,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',1,0,'127.0.0.1','2014-08-29 20:27:23',NULL,100000,NULL,'2014-08-29 20:22:01',NULL,'1000000.00','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,1,NULL,1,'0.00','0.00','0.00',1,'3c9dccf96817be4db33a6946f4e8e8fc','57df71b75c8fa64a6206476108834066',0,1,2,'4021000030152249',NULL,NULL),(10,'hx210@yopmail.com','hx210',1,2,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',1,0,'127.0.0.1','2014-08-29 20:29:43',NULL,100000,NULL,'2014-08-29 20:22:33',NULL,'1000000.00','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,1,NULL,1,'0.00','0.00','0.00',1,'b96f4820986e5829c5270ce6d737b0f8','359635b20891928fa8743c53d952e321',0,1,2,'4021000030152450',NULL,NULL),(11,'hx1@126.com','hxz1',2,5,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1','13422222222','',40,51,'0:0:0:0:0:0:0:1','2015-01-09 13:37:03','2014-12-20 10:43:10',100000,NULL,'2014-08-30 08:31:18',NULL,'189991.27','100.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',2,57,NULL,1,'0.00','0.00','0.00',2,'95649679e572dfc8b1ed0bd539ac684b','9a341a6050175c4d9d7091ff38161e92',0,1,2,'4021000030152865','20140830001205',NULL),(12,'hx2@126.com','hxz2',2,5,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',339,101,'127.0.0.1','2014-11-20 10:34:45','2014-12-20 10:43:10',100000,NULL,'2014-08-30 09:01:50',NULL,'14609.92','-383.33','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',2,44,NULL,1,'0.00','0.00','0.00',2,'7b2ec580393174bbc2f20b509ee8d5cc','2ba98b056bdf1c8f339480410f8fd73e',0,1,2,'4021000030153049','20140830001207','20140916000221'),(13,'hx3@126.com','hxz3',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',535,0,'127.0.0.1','2014-10-10 08:42:33','2014-12-20 10:43:10',100000,NULL,'2014-08-30 10:32:41',NULL,'90840.47','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',2,25,NULL,1,'0.00','0.00','0.00',2,'f89106209a7a97c2076dd807c260b546','d541de938aaaf83414ac0d351d3ee912',0,1,2,'4021000030153250','20140901001209',NULL),(14,'liuxuebo@eims.com.cn','小七',2,5,1,'807837175350744e8d061928899cd56a','bc21f267a1fb6ab7185f811e8a452d37',NULL,'',5,96,'0:0:0:0:0:0:0:1','2014-09-05 16:20:34','2014-09-01 14:12:23',100000,NULL,'2014-09-01 13:54:45',NULL,'0.00','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,9,NULL,1,'0.00','0.00','0.00',1,'050790ede9f679add73c99c8953cdec3','f477a7ff877a48af053a42d12491c41a',1,1,2,'4021000030157289',NULL,NULL),(15,'hx4@126.com','hxz4',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',15,50,'127.0.0.1','2014-11-20 18:19:22','2014-09-01 17:58:18',100000,NULL,'2014-09-01 17:33:04',NULL,'15562.32','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,23,NULL,1,'0.00','0.00','0.00',1,'0fed1a98bd08dab87a2d50d7d434365f','5f657fcbd7644be2e1a3f2b62c0c85b9',0,1,2,'4021000030162668',NULL,NULL),(16,'hx5@126.com','hxz5',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',476,56,'127.0.0.1','2014-11-20 17:44:30','2014-09-03 14:32:58',100000,NULL,'2014-09-03 14:28:52',NULL,'104673.74','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,73,NULL,1,'0.00','0.00','0.00',1,'bd4f2ac44770bea26b052c343d8efb2f','3e322eed0c0c1756c83c24b337dc1f72',0,1,2,'4021000030182254','20140903001229','20140905000147'),(17,'hx6@126.com','hxz6',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',2812,50,'127.0.0.1','2014-10-16 09:37:16','2014-09-03 15:05:32',100000,NULL,'2014-09-03 14:52:54',NULL,'85073.72','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,52,NULL,1,'0.00','0.00','0.00',1,'cb6e77076b8b20b6414d8cef195c098c','b938ef66e68501b07fdb3b70005c2435',0,1,2,'4021000030183262','20140912001311',NULL),(18,'hx7@126.com','hxz7',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',607,62,'127.0.0.1','2014-11-10 09:47:45','2014-09-05 10:36:43',100000,NULL,'2014-09-05 10:34:25',NULL,'67537.00','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,27,NULL,1,'0.00','0.00','0.00',1,'b0dbd16923e26f07e2d127b6e83a2575','1a0fb7b6e09bd9ea61c125b7ae477eb9',0,1,2,'4021000030201221','20140912001313',NULL),(19,'hx8@126.com','hxz8',1,2,1,'bc21f267a1fb6ab7185f811e8a452d37','bc21f267a1fb6ab7185f811e8a452d37',NULL,'',6,0,'127.0.0.1','2014-11-20 17:09:25',NULL,100000,NULL,'2014-09-11 10:04:50',NULL,'0.00','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,6,NULL,1,'0.00','0.00','0.00',1,'f11bdab3eee771c9aa54f4f7e7fc52c2','3eb8efe559da84545bd1f1fbdfb8dbe5',0,1,1,NULL,NULL,NULL),(20,NULL,'ce1',2,1,1,'bc21f267a1fb6ab7185f811e8a452d37','bc21f267a1fb6ab7185f811e8a452d37','13527289594','',1,0,'127.0.0.1','2014-09-13 09:30:14','2014-09-13 09:29:56',100000,'','2014-09-13 09:29:56',NULL,'0.00','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,1,NULL,1,'0.00','0.00','0.00',1,'f899491817c3c8158036520994384476','18452fa6ab5ec48ff8e21bac0ea55762',0,1,1,NULL,NULL,NULL),(21,NULL,'ce2',2,1,1,'bc21f267a1fb6ab7185f811e8a452d37','bc21f267a1fb6ab7185f811e8a452d37','13521234561','',1,0,'127.0.0.1','2014-09-13 09:50:48','2014-09-13 09:50:32',100000,'','2014-09-13 09:50:32',NULL,'0.00','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,1,NULL,1,'0.00','0.00','0.00',1,'5fde5c093361a9ee82a7661750baec9c','35b74492d906d08497f9115e32a7399e',0,1,1,NULL,NULL,NULL),(22,'test1@126.com','test1',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',1,0,'127.0.0.1','2014-10-09 20:32:22','2014-10-09 20:35:12',100000,NULL,'2014-10-09 20:32:09',NULL,'0.00','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,1,NULL,1,'0.00','0.00','0.00',1,'0cc6073cef12334e36a8b19c28c98805','445f99aa7a85876db03f1a852c366848',0,1,2,'4021000030478854',NULL,NULL),(23,'hxz01@126.com','hxz01',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',4,50,'127.0.0.1','2014-10-30 21:07:25','2014-10-28 11:19:28',100000,NULL,'2014-10-28 11:17:50',NULL,'100008.46','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,4,NULL,1,'0.00','0.00','0.00',1,'ce4a4a946b396b0f2de400997aa8046e','ee5f9f51f1e0e01c703e467389fe41b6',0,1,2,'4021000030686653',NULL,'20141028000444'),(24,'hxdbcs@126.com','hxdbcs',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',2,0,'127.0.0.1','2014-11-05 08:30:48','2014-11-05 08:32:38',100000,NULL,'2014-11-04 09:10:22',NULL,'1000000.00','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,2,NULL,1,'0.00','0.00','0.00',1,'0cbf14e0af2751de2ce5e6f9bb2976e7','7b1b39102bfa72b3fd2808e451ad234b',0,1,2,'4021000030790414',NULL,NULL),(25,'hxz10@126.com','hxz10',2,4,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',2,50,'127.0.0.1','2014-11-20 16:58:34','2014-11-05 08:39:08',100000,NULL,'2014-11-05 08:37:42',NULL,'11980.00','0.00','0.00','0.00',1,NULL,NULL,100000,NULL,'0.00',1,2,NULL,1,'0.00','0.00','0.00',1,'137371abad72f352c137297b3d5c5eb4','170b8dc55baa413662cd721d59a73b63',0,1,2,'4021000030790622',NULL,NULL),(26,'hxz11@126.com','hxz11',1,2,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',103,0,'127.0.0.1','2014-11-20 17:06:51',NULL,100000,NULL,'2014-11-19 08:43:47',NULL,'8000.00','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,3,NULL,1,'0.00','0.00','0.00',1,'f256153e20c89c1c5ca36de6d934cacf','0f8524ea7fed9ccaab6afeeb3b1ed18a',0,1,2,'4021000030974872',NULL,NULL),(27,'hxz12@126.com','hxz12',1,1,1,'bc21f267a1fb6ab7185f811e8a452d37','bc21f267a1fb6ab7185f811e8a452d37',NULL,'',3,0,'127.0.0.1','2014-11-20 17:08:13',NULL,100000,NULL,'2014-11-19 08:51:35',NULL,'0.00','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,3,NULL,1,'0.00','0.00','0.00',1,'4f74e84a993d1d6f353545646b135141','4d1d8877ea6320291ad7db472b5d8bef',0,1,1,NULL,NULL,NULL),(28,'hxz13@126.com','hxz13',1,2,1,'bc21f267a1fb6ab7185f811e8a452d37','88a22603f0c491643a3d8f94b8c1d6d1',NULL,'',3,0,'127.0.0.1','2014-11-19 11:11:49',NULL,100000,NULL,'2014-11-19 10:58:44',NULL,'5000.00','0.00','0.00','0.00',NULL,NULL,NULL,100000,NULL,'0.00',1,3,NULL,1,'0.00','0.00','0.00',1,'b1cdc78f9011a61b702f099cde4baa81','bb815f51021736dca4589501c88fd3a8',0,1,2,'4021000030982039',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `test_c3p0` */

DROP TABLE IF EXISTS `test_c3p0`;

CREATE TABLE `test_c3p0` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test_c3p0` */

LOCK TABLES `test_c3p0` WRITE;

UNLOCK TABLES;

/* Procedure structure for procedure `pr_examine` */

/*!50003 DROP PROCEDURE IF EXISTS  `pr_examine` */;

DELIMITER $$

/*!50003 CREATE DEFINER=``@`` PROCEDURE `pr_examine`(IN `in_id` bigint)
BEGIN

	DECLARE pid int default 0; 
	
	 DECLARE pusername varchar(255) default ''; 

	DECLARE pemail varchar(255) default ''; 
	
    select id,username,email into @id,@username,@email from t_user where id = in_id;
		
		set pid = ifnull(@id,0);

		set pusername = @username;

		set pemail = ifnull(@email,'');

		select pid,pusername,pemail;


END */$$
DELIMITER ;

/* Procedure structure for procedure `pr_page` */

/*!50003 DROP PROCEDURE IF EXISTS  `pr_page` */;

DELIMITER $$

/*!50003 CREATE DEFINER=``@`` PROCEDURE `pr_page`(in p_table_name varchar(1024),in p_fields varchar(1024),in p_page_size bigint , in p_page_now bigint, in P_order_string varchar(128),in p_where_string varchar(3000),out p_out_rows bigint)
BEGIN

		 /*定义变量*/

	    DECLARE m_begin_row INT DEFAULT 0;

	    DECLARE m_limit_string CHAR(64);

		  DECLARE m_sqlwhere VARCHAR(3000);

			DECLARE m_fields VARCHAR(3000);

	      

	    /*构造语句*/     

	    SET m_begin_row = (p_page_now - 1) * p_page_size;

	    SET m_limit_string = CONCAT(' LIMIT ', m_begin_row, ', ', p_page_size);

			SET m_sqlwhere=replace(replace(p_where_string,'|',''''),'$w$','where');  

			SET m_fields=replace(replace(p_fields,'|',''''),'$w$','where');  

	    SET @COUNT_STRING = CONCAT('SELECT COUNT(*) INTO @ROWS_TOTAL FROM ', p_table_name, ' where 1=1 ', m_sqlwhere);

	    SET @MAIN_STRING = CONCAT('SELECT ', m_fields, ' FROM ', p_table_name,' where 1=1 ' , m_sqlwhere ,' ', P_order_string , m_limit_string);

			PREPARE count_stmt FROM @COUNT_STRING;

	    EXECUTE count_stmt;

	    DEALLOCATE PREPARE count_stmt;

	    SET p_out_rows = @ROWS_TOTAL;

			

	    PREPARE main_stmt FROM @MAIN_STRING;

	    EXECUTE main_stmt;

	    DEALLOCATE PREPARE main_stmt;  

	  #call pr_pager("v_news","InfoId",10,1, "order by InfoId desc"," ParentParentPartId=4",@result);

	END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
