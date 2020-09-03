CREATE DATABASE  IF NOT EXISTS `examen3parcial` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `examen3parcial`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: examen3parcial
-- ------------------------------------------------------
-- Server version	5.0.18-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `productoId` int(11) NOT NULL,
  `productoNombre` varchar(45) default NULL,
  `precioCosto` double(9,2) default NULL,
  `precioVenta` double(9,2) default NULL,
  PRIMARY KEY  (`productoId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Coca cola',40.00,50.00),(2,'Pepsi',50.00,55.00);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaccion`
--

DROP TABLE IF EXISTS `transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaccion` (
  `transacId` varchar(30) NOT NULL,
  `TipoTransaccion` varchar(45) default NULL,
  `FechaTransaccion` datetime default NULL,
  `Subtotal` double(9,2) default NULL,
  `Total` double(9,2) default NULL,
  `Usuario` varchar(45) default NULL,
  `CantidadComprada` int(11) default NULL,
  `productoId` int(11) NOT NULL,
  PRIMARY KEY  (`transacId`,`productoId`),
  KEY `fk_transaccion_producto_idx` (`productoId`),
  CONSTRAINT `fk_transaccion_producto` FOREIGN KEY (`productoId`) REFERENCES `producto` (`productoId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaccion`
--

LOCK TABLES `transaccion` WRITE;
/*!40000 ALTER TABLE `transaccion` DISABLE KEYS */;
INSERT INTO `transaccion` VALUES ('TRA-1','VEN','2020-04-24 04:01:00',0.00,200.00,'hg',5,1),('TRA-2','VEN','2020-04-24 04:06:19',0.00,2600.00,'ghjghj',65,1),('TRA-3','VEN','2020-04-24 04:08:08',0.00,150.00,'sdfgsdf',3,2),('TRA-4','VEN','2020-04-24 04:08:19',0.00,1760.00,'34edd',44,1),('TRA-5','COM','2020-04-24 04:08:29',0.00,1650.00,'sdsdfsdf',33,2),('TRA-6','COM','2020-04-24 04:08:43',0.00,2200.00,'sdff',44,2),('TRA-7','VEN','2020-04-24 05:04:37',0.00,3300.00,'admin',66,1);
/*!40000 ALTER TABLE `transaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'examen3parcial'
--
/*!50003 DROP PROCEDURE IF EXISTS `AddTransaccion` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `AddTransaccion`(
	transacId varchar(30) ,
TipoTransaccion varchar(45) ,
Subtotal double(9,2) ,
Total double(9,2) ,
Usuario varchar(45) ,
CantidadComprada int(11) ,
productoId int(11)
)
BEGIN
	insert into transaccion(transacId ,
TipoTransaccion ,
FechaTransaccion,
Subtotal ,
Total,
Usuario ,
CantidadComprada ,
productoId) 
	values(transacId ,
TipoTransaccion ,
now(),
Subtotal ,
Total,
Usuario ,
CantidadComprada ,
productoId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetLastTrans` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetLastTrans`()
BEGIN
SELECT transacId FROM transaccion ORDER BY transacId DESC LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetProductById` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetProductById`(
	id int
)
BEGIN
SELECT * 
FROM examen3parcial.producto where productoId = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetTotalCompraPorId` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetTotalCompraPorId`(
	id int
)
BEGIN

 select sum(total) as total from (
	(
		 select t.Total 
 FROM examen3parcial.transaccion t
join examen3parcial.producto p on t.productoId = p.productoId
where p.productoId = id and t.TipoTransaccion = 'COM'
group by t.transacId
    
    ) as total
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetTotalVentaPorId` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetTotalVentaPorId`(
	id int
)
BEGIN
select sum(total) as total from (
	(
		 select t.Total 
 FROM examen3parcial.transaccion t
join examen3parcial.producto p on t.productoId = p.productoId
where p.productoId = id and t.TipoTransaccion = 'VEN'
group by t.transacId
    
    ) as total
);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetTransByProduct` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetTransByProduct`(
	id int
)
BEGIN
SELECT p.productoNombre,
	t.cantidadComprada,
	t.TipoTransaccion,
	t.Usuario,
t.Total
 FROM examen3parcial.transaccion t
join examen3parcial.producto p on t.productoId = p.productoId
where p.productoId = id
group by t.transacId;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-24  8:47:27
