-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: deduccionesdb
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
-- Table structure for table `tbl_deduccion`
--

DROP TABLE IF EXISTS `tbl_deduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_deduccion` (
  `ded_codigo` int(11) NOT NULL auto_increment,
  `ded_nombre` varchar(45) default NULL,
  `ded_descripcion` varchar(45) default NULL,
  `ded_forma` varchar(45) default NULL,
  `ded_estado` varchar(40) default NULL,
  PRIMARY KEY  (`ded_codigo`),
  UNIQUE KEY `ded_nombre_UNIQUE` (`ded_nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_deduccion`
--

LOCK TABLES `tbl_deduccion` WRITE;
/*!40000 ALTER TABLE `tbl_deduccion` DISABLE KEYS */;
INSERT INTO `tbl_deduccion` VALUES (1,'RAP',NULL,'MON','activo'),(2,'IHSS','','MON','activo'),(3,'Seguro Privado','','POR','activo');
/*!40000 ALTER TABLE `tbl_deduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_deduccion_empleado`
--

DROP TABLE IF EXISTS `tbl_deduccion_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_deduccion_empleado` (
  `identidadEmpleado` varchar(15) NOT NULL,
  `codigoDeduccion` int(11) NOT NULL,
  `valor` decimal(10,2) default NULL,
  KEY `fk_tbl_empleado_has_tbl_deduccion_tbl_deduccion1_idx` (`codigoDeduccion`),
  KEY `fk_tbl_empleado_has_tbl_deduccion_tbl_empleado1_idx` (`identidadEmpleado`),
  CONSTRAINT `fk_tbl_empleado_has_tbl_deduccion_tbl_deduccion1` FOREIGN KEY (`codigoDeduccion`) REFERENCES `tbl_deduccion` (`ded_codigo`) ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_empleado_has_tbl_deduccion_tbl_empleado1` FOREIGN KEY (`identidadEmpleado`) REFERENCES `tbl_empleado` (`emp_identidad`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_deduccion_empleado`
--

LOCK TABLES `tbl_deduccion_empleado` WRITE;
/*!40000 ALTER TABLE `tbl_deduccion_empleado` DISABLE KEYS */;
INSERT INTO `tbl_deduccion_empleado` VALUES ('0101',1,250.00),('0101',2,250.00),('0101',3,0.15);
/*!40000 ALTER TABLE `tbl_deduccion_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_emp_salarios`
--

DROP TABLE IF EXISTS `tbl_emp_salarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp_salarios` (
  `emp_identidad` varchar(15) NOT NULL,
  `emp_salario` decimal(9,2) default NULL,
  PRIMARY KEY  (`emp_identidad`),
  KEY `fk_tbl_emp_salarios_tbl_empleado_idx` (`emp_identidad`),
  CONSTRAINT `fk_tbl_emp_salarios_tbl_empleado` FOREIGN KEY (`emp_identidad`) REFERENCES `tbl_empleado` (`emp_identidad`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_emp_salarios`
--

LOCK TABLES `tbl_emp_salarios` WRITE;
/*!40000 ALTER TABLE `tbl_emp_salarios` DISABLE KEYS */;
INSERT INTO `tbl_emp_salarios` VALUES ('0101',1000.00);
/*!40000 ALTER TABLE `tbl_emp_salarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_empleado`
--

DROP TABLE IF EXISTS `tbl_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_empleado` (
  `emp_identidad` varchar(15) NOT NULL,
  `emp_pnombre` varchar(45) default NULL,
  `emp_snombre` varchar(45) default NULL,
  `emp_papellido` varchar(45) default NULL,
  `emp_sapellido` varchar(45) default NULL,
  `emp_puesto` varchar(45) default NULL,
  `emp_estado` varchar(40) default NULL,
  PRIMARY KEY  (`emp_identidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_empleado`
--

LOCK TABLES `tbl_empleado` WRITE;
/*!40000 ALTER TABLE `tbl_empleado` DISABLE KEYS */;
INSERT INTO `tbl_empleado` VALUES ('0101','ariel','reyes','flores','sd','pro','activo');
/*!40000 ALTER TABLE `tbl_empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-13 23:47:04
