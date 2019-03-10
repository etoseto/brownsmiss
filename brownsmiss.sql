/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.22-log : Database - brownsmiss
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`brownsmiss` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `brownsmiss`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) DEFAULT NULL,
  `password` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`) values (1,'admin','1234'),(2,'jack','4321'),(8,'rosi','123456');

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `businessName` varchar(50) NOT NULL COMMENT '商品名称',
  `img` varchar(100) DEFAULT NULL COMMENT '商品图片',
  `businessDetails` text COMMENT '商品描述',
  `url` varchar(200) DEFAULT NULL COMMENT '商品地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `business` */

insert  into `business`(`id`,`businessName`,`img`,`businessDetails`,`url`) values (1,'JAYJUN捷俊水光樱花三部曲面膜套装20片','images/commodity_1.jpg','JAYJUN捷俊水光樱花三部曲面膜套装20片11','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.43.6ccc182bd9ZvIn&id=538855631452&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19'),(2,'JAYJUN捷俊密集焕亮面膜三部曲10片','images/commodity_2.jpg','JAYJUN捷俊密集焕亮面膜三部曲10片','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.47.6ccc182bd9ZvIn&id=537118267969&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19&skuId=3207895064628'),(3,'JAYJUN捷俊黑色水光面膜三部曲10片','images/commodity_3.jpg','JAYJUN捷俊黑色水光面膜三部曲10片','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.51.6ccc182bd9ZvIn&id=537269004196&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19&skuId=3210191820238'),(4,'JAYJUN捷俊植物干细胞紧致面膜10片 ','images/commodity_4.jpg','JAYJUN捷俊植物干细胞紧致面膜10片 ','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.55.6ccc182bd9ZvIn&id=537270700466&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19&skuId=3206679103916'),(5,'JAYJUN捷俊玫瑰精华面膜10片','images/commodity_5.jpg','JAYJUN捷俊玫瑰精华面膜10片','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.59.6ccc182bd9ZvIn&id=537270400523&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19&skuId=3207690665793'),(6,'JAYJUN捷俊多重维他修护面膜10片','images/commodity_6.jpg','JAYJUN捷俊多重维他修护面膜10片','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.66.6ccc182bd9ZvIn&id=538491273823&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19&skuId=3216531530442'),(7,'JAYJUN捷俊水光洗面奶150ml','images/commodity_7.jpg','JAYJUN捷俊水光洗面奶150ml','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.71.6ccc182bd9ZvIn&id=537262443832&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19&skuId=3208338266785'),(8,'JAYJUN捷俊密集焕亮水乳套盒','images/commodity_8.jpg','JAYJUN捷俊密集焕亮水乳套盒','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.83.6ccc182bd9ZvIn&id=567894892825&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19'),(9,'JAYJUN捷俊玫瑰柔肤水乳套装','images/commodity_9.jpg','JAYJUN捷俊玫瑰柔肤水乳套装','https://detail.tmall.hk/hk/item.htm?spm=a1z10.3-b-s.w4011-15763629580.87.6ccc182bd9ZvIn&id=544555652271&rn=25c69cc49c7ba714d5df3ddbe347a544&abbucket=19');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newsName` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `newsDetails` text,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`id`,`newsName`,`author`,`newsDetails`,`time`) values (1,'布诗集团全体客服技能培训公告','admin','布诗集团全体客服技能培训公告124','2018-12-01 08:00:00'),(2,'布诗集团2018双11运动会圆满举行','admin','布诗集团2018双11运动会圆满举行','2018-10-10 15:15:28'),(3,'JAYJUN杰俊新品睡眠面膜上市','admin','JAYJUN杰俊新品睡眠面膜上市','2018-09-01 15:17:10'),(7,'123','admin','asdf','2018-06-15 08:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
