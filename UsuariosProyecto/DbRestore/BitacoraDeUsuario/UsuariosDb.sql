CREATE DATABASE  IF NOT EXISTS `usuariosdb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `usuariosdb`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: usuariosdb
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `acceso` (
  `UsuarioCodigo` varchar(45) NOT NULL,
  `ModuloCodigo` varchar(45) NOT NULL,
  `AccesoEstado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UsuarioCodigo`,`ModuloCodigo`),
  KEY `fk_Usuarios_has_Modulo_Modulo1_idx` (`ModuloCodigo`),
  KEY `fk_Usuarios_has_Modulo_Usuarios_idx` (`UsuarioCodigo`),
  CONSTRAINT `fk_Usuarios_has_Modulo_Modulo1` FOREIGN KEY (`ModuloCodigo`) REFERENCES `modulo` (`ModuloCodigo`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_Usuarios_has_Modulo_Usuarios` FOREIGN KEY (`UsuarioCodigo`) REFERENCES `usuarios` (`UsuarioCodigo`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT INTO `acceso` VALUES ('root','01Mod','Activo');
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacora`
--

DROP TABLE IF EXISTS `bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bitacora` (
  `BitacoraCodigo` int(11) NOT NULL AUTO_INCREMENT,
  `UsuarioCodigo` varchar(45) NOT NULL,
  `BitacoraFecha` datetime DEFAULT NULL,
  `BitacoraIP` varchar(45) DEFAULT NULL,
  `BitacoraNombreMaquina` varchar(45) DEFAULT NULL,
  `BitacoraMAC` varchar(45) DEFAULT NULL,
  `BitacoraDescripcion` text,
  PRIMARY KEY (`BitacoraCodigo`,`UsuarioCodigo`),
  KEY `fk_Bitacora_Usuarios1_idx` (`UsuarioCodigo`),
  CONSTRAINT `fk_Bitacora_Usuarios1` FOREIGN KEY (`UsuarioCodigo`) REFERENCES `usuarios` (`UsuarioCodigo`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora`
--

LOCK TABLES `bitacora` WRITE;
/*!40000 ALTER TABLE `bitacora` DISABLE KEYS */;
/*!40000 ALTER TABLE `bitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `modulo` (
  `ModuloCodigo` varchar(45) NOT NULL,
  `ModuloNombre` varchar(45) DEFAULT NULL,
  `ModuloDescripcion` text,
  PRIMARY KEY (`ModuloCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES ('01Mod','Contabilidad','Ofrece servicios de contabilidad de la empresa');
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `UsuarioCodigo` varchar(45) NOT NULL,
  `UsuarioClave` varchar(45) DEFAULT NULL,
  `UsuarioEstado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UsuarioCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('root','1234','Activo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-03 14:42:51
