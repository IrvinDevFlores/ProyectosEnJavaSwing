CREATE DATABASE  IF NOT EXISTS `hambus_database` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hambus_database`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: hambus_database
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
-- Table structure for table `__efmigrationshistory`
--

DROP TABLE IF EXISTS `__efmigrationshistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `__efmigrationshistory` (
  `MigrationId` varchar(95) NOT NULL,
  `ProductVersion` varchar(32) NOT NULL,
  PRIMARY KEY  (`MigrationId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `__efmigrationshistory`
--

LOCK TABLES `__efmigrationshistory` WRITE;
/*!40000 ALTER TABLE `__efmigrationshistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `__efmigrationshistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `activeproducts`
--

DROP TABLE IF EXISTS `activeproducts`;
/*!50001 DROP VIEW IF EXISTS `activeproducts`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `activeproducts` AS SELECT 
 1 AS `MenuItemId`,
 1 AS `ItemName`,
 1 AS `ItemDescripcion`,
 1 AS `ItemPrice`,
 1 AS `MenuCategoryId`,
 1 AS `Estado`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `detalletransaccion`
--

DROP TABLE IF EXISTS `detalletransaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalletransaccion` (
  `TransId` varchar(40) NOT NULL,
  `MenuItemId` int(11) NOT NULL,
  `DetalleTransPosicion` int(11) NOT NULL,
  `Cantidad` double(9,2) default NULL,
  `PrecioUnidad` double(9,2) default NULL,
  `Descuento` double(9,2) default NULL,
  `PrecioTotal` double(9,2) default NULL,
  PRIMARY KEY  (`TransId`,`DetalleTransPosicion`),
  KEY `fk_DetalleTransaccion_Transaccion1_idx` (`TransId`),
  KEY `fk_DetalleTransaccion_menuproducts1_idx` (`MenuItemId`),
  CONSTRAINT `fk_DetalleTransaccion_Transaccion1` FOREIGN KEY (`TransId`) REFERENCES `transaccion` (`TransId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleTransaccion_menuproducts1` FOREIGN KEY (`MenuItemId`) REFERENCES `menuproducts` (`MenuItemId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalletransaccion`
--

LOCK TABLES `detalletransaccion` WRITE;
/*!40000 ALTER TABLE `detalletransaccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalletransaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `EmployeeId` varchar(20) NOT NULL,
  `FirstName` varchar(20) default NULL,
  `MiddleName` varchar(20) default NULL,
  `LastName1` varchar(20) default NULL,
  `LastName2` varchar(20) default NULL,
  `EmployeeSex` varchar(20) default NULL,
  `EmployeePhone` varchar(20) default NULL,
  `EmployeeDayOfBirth` datetime default NULL,
  `Puesto` varchar(20) default NULL,
  `Estado` varchar(20) default NULL,
  `UserId` int(11) default NULL,
  PRIMARY KEY  (`EmployeeId`),
  KEY `IX_Employees_UserId` (`UserId`),
  CONSTRAINT `FK_Employees_Users_UserId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('0101-1997-02703','Irvin','Ariel','Reyez','Flores','Hombre','+5046664','2020-04-18 00:00:00','Admin','activo',NULL),('0252-5465-64656','Pedro','Pica','Ramirez','hernandez','Hombre','34345345345345','2020-04-18 00:00:00','Cajero','activo',NULL),('1102-1998-00183','Juan','Pablo','Perez','Juarez','Hombre','+504874455544','1990-04-08 00:00:00','Admin','activo',NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `inactiveproducts`
--

DROP TABLE IF EXISTS `inactiveproducts`;
/*!50001 DROP VIEW IF EXISTS `inactiveproducts`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inactiveproducts` AS SELECT 
 1 AS `MenuItemId`,
 1 AS `ItemName`,
 1 AS `ItemDescripcion`,
 1 AS `ItemPrice`,
 1 AS `MenuCategoryId`,
 1 AS `Estado`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `inactivesproductsview`
--

DROP TABLE IF EXISTS `inactivesproductsview`;
/*!50001 DROP VIEW IF EXISTS `inactivesproductsview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `inactivesproductsview` AS SELECT 
 1 AS `MenuCategoryId`,
 1 AS `MenuCategoryName`,
 1 AS `MenuVersion`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `inventorysupplies`
--

DROP TABLE IF EXISTS `inventorysupplies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventorysupplies` (
  `SupplyId` varchar(20) NOT NULL,
  `SupplyBarcode` varchar(20) default NULL,
  `SupplyName` varchar(20) default NULL,
  `SupplyPrice` decimal(6,2) NOT NULL,
  `SupplyStock` decimal(6,2) NOT NULL,
  `SupplyCategoryId` varchar(20) NOT NULL,
  PRIMARY KEY  (`SupplyId`),
  KEY `IX_InventorySupplies_SupplyCategoryId` (`SupplyCategoryId`),
  CONSTRAINT `FK_InventorySupplies_InventorySupplyCategories_SupplyCategoryId` FOREIGN KEY (`SupplyCategoryId`) REFERENCES `inventorysupplycategories` (`SupplyCategoryId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventorysupplies`
--

LOCK TABLES `inventorysupplies` WRITE;
/*!40000 ALTER TABLE `inventorysupplies` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventorysupplies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventorysupplycategories`
--

DROP TABLE IF EXISTS `inventorysupplycategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventorysupplycategories` (
  `SupplyCategoryId` varchar(20) NOT NULL,
  `SupplyCategoryName` varchar(20) default NULL,
  PRIMARY KEY  (`SupplyCategoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventorysupplycategories`
--

LOCK TABLES `inventorysupplycategories` WRITE;
/*!40000 ALTER TABLE `inventorysupplycategories` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventorysupplycategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menucategories`
--

DROP TABLE IF EXISTS `menucategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menucategories` (
  `MenuCategoryId` varchar(20) NOT NULL,
  `MenuCategoryName` varchar(20) default NULL,
  `RestaurantMenuId` int(11) NOT NULL,
  `Estado` varchar(45) default NULL,
  PRIMARY KEY  (`MenuCategoryId`),
  KEY `IX_MenuCategories_RestaurantMenuId` (`RestaurantMenuId`),
  CONSTRAINT `FK_MenuCategories_RestaurantMenus_RestaurantMenuId` FOREIGN KEY (`RestaurantMenuId`) REFERENCES `restaurantmenus` (`RestaurantMenuId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menucategories`
--

LOCK TABLES `menucategories` WRITE;
/*!40000 ALTER TABLE `menucategories` DISABLE KEYS */;
INSERT INTO `menucategories` VALUES ('APE','Aperitivos',1,'activo'),('ASA','Asados',1,'activo'),('BEB','Bebida',1,'activo'),('BURG','Burgers',1,'activo'),('lhkfg','sdfsf',1,'activo'),('OFE','Ofertas',1,'activo'),('POST','Postres',1,'activo'),('SOP','Sopas',1,'activo'),('VIN','Vinos',1,'activo');
/*!40000 ALTER TABLE `menucategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuitemsupplies`
--

DROP TABLE IF EXISTS `menuitemsupplies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menuitemsupplies` (
  `MenuItemId` int(11) NOT NULL,
  `SupplyId` varchar(20) NOT NULL,
  PRIMARY KEY  (`MenuItemId`,`SupplyId`),
  KEY `IX_MenuItemSupplies_SupplyId` (`SupplyId`),
  CONSTRAINT `FK_MenuItemSupplies_InventorySupplies_SupplyId` FOREIGN KEY (`SupplyId`) REFERENCES `inventorysupplies` (`SupplyId`) ON DELETE CASCADE,
  CONSTRAINT `FK_MenuItemSupplies_MenuProducts_MenuItemId` FOREIGN KEY (`MenuItemId`) REFERENCES `menuproducts` (`MenuItemId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuitemsupplies`
--

LOCK TABLES `menuitemsupplies` WRITE;
/*!40000 ALTER TABLE `menuitemsupplies` DISABLE KEYS */;
/*!40000 ALTER TABLE `menuitemsupplies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuproducts`
--

DROP TABLE IF EXISTS `menuproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menuproducts` (
  `MenuItemId` int(11) NOT NULL auto_increment,
  `ItemName` varchar(40) default NULL,
  `ItemDescripcion` varchar(60) default NULL,
  `ItemPrice` double(6,2) NOT NULL,
  `MenuCategoryId` varchar(20) NOT NULL,
  `Estado` varchar(45) default NULL,
  PRIMARY KEY  (`MenuItemId`),
  KEY `IX_MenuProducts_MenuCategoryId` (`MenuCategoryId`),
  CONSTRAINT `FK_MenuProducts_MenuCategories_MenuCategoryId` FOREIGN KEY (`MenuCategoryId`) REFERENCES `menucategories` (`MenuCategoryId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuproducts`
--

LOCK TABLES `menuproducts` WRITE;
/*!40000 ALTER TABLE `menuproducts` DISABLE KEYS */;
INSERT INTO `menuproducts` VALUES (1,'Pilungosa','Mucho queso',200.00,'BURG','activo'),(2,'Hulk','Queso y chile',400.00,'BURG','activo'),(3,'Salvavida','Cerveza',17.00,'BEB','activo'),(4,'Merlot','De españa 5 años de añejo',100.00,'VIN','activo'),(5,'Tinto','Vino tinto',200.00,'VIN','activo'),(6,'asdf','asdf',600.00,'ASA','activo');
/*!40000 ALTER TABLE `menuproducts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissions` (
  `PermissionId` int(11) NOT NULL auto_increment,
  `PermissionName` varchar(20) default NULL,
  `Description` varchar(20) default NULL,
  `PermissionCreatedDate` datetime default NULL,
  PRIMARY KEY  (`PermissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `productcategoriesview`
--

DROP TABLE IF EXISTS `productcategoriesview`;
/*!50001 DROP VIEW IF EXISTS `productcategoriesview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `productcategoriesview` AS SELECT 
 1 AS `MenuCategoryId`,
 1 AS `MenuCategoryName`,
 1 AS `MenuVersion`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `providers`
--

DROP TABLE IF EXISTS `providers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `providers` (
  `ProviderId` int(11) NOT NULL auto_increment,
  `ProviderName` varchar(20) NOT NULL,
  `Street` varchar(40) default NULL,
  `City` varchar(40) default NULL,
  `Departament` varchar(40) default NULL,
  `Country` varchar(40) default NULL,
  `ZipCode` varchar(40) default NULL,
  PRIMARY KEY  (`ProviderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `providers`
--

LOCK TABLES `providers` WRITE;
/*!40000 ALTER TABLE `providers` DISABLE KEYS */;
/*!40000 ALTER TABLE `providers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantmenus`
--

DROP TABLE IF EXISTS `restaurantmenus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurantmenus` (
  `RestaurantMenuId` int(11) NOT NULL auto_increment,
  `MenuVersion` varchar(40) NOT NULL,
  PRIMARY KEY  (`RestaurantMenuId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantmenus`
--

LOCK TABLES `restaurantmenus` WRITE;
/*!40000 ALTER TABLE `restaurantmenus` DISABLE KEYS */;
INSERT INTO `restaurantmenus` VALUES (1,'v1');
/*!40000 ALTER TABLE `restaurantmenus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolepermissions`
--

DROP TABLE IF EXISTS `rolepermissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolepermissions` (
  `RoleId` int(11) NOT NULL,
  `PermissionId` int(11) NOT NULL,
  PRIMARY KEY  (`RoleId`,`PermissionId`),
  KEY `IX_RolePermissions_PermissionId` (`PermissionId`),
  CONSTRAINT `FK_RolePermissions_Permissions_PermissionId` FOREIGN KEY (`PermissionId`) REFERENCES `permissions` (`PermissionId`) ON DELETE CASCADE,
  CONSTRAINT `FK_RolePermissions_Roles_RoleId` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`RoleId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolepermissions`
--

LOCK TABLES `rolepermissions` WRITE;
/*!40000 ALTER TABLE `rolepermissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `rolepermissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `RoleId` int(11) NOT NULL auto_increment,
  `RoleName` varchar(20) default NULL,
  PRIMARY KEY  (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Inicio'),(2,'Personal'),(3,'Ordenes'),(4,'Menu'),(5,'Reportes');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaccion`
--

DROP TABLE IF EXISTS `transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaccion` (
  `TransId` varchar(40) NOT NULL,
  `TransFecha` datetime default NULL,
  `TransSubtotal` double(9,2) default NULL,
  `TransDescuento` double(9,2) default NULL,
  `TransInpuesto` double(9,2) default NULL,
  `TransTotal` double(9,2) default NULL,
  `TransEstado` varchar(45) default NULL,
  `FormaDePagoId` int(11) default NULL,
  `UserId` int(11) NOT NULL,
  PRIMARY KEY  (`TransId`),
  KEY `fk_Transaccion_users1_idx` (`UserId`),
  CONSTRAINT `fk_Transaccion_users1` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaccion`
--

LOCK TABLES `transaccion` WRITE;
/*!40000 ALTER TABLE `transaccion` DISABLE KEYS */;
INSERT INTO `transaccion` VALUES ('TRA-1',NULL,200.00,0.00,0.15,250.00,'activo',NULL,1);
/*!40000 ALTER TABLE `transaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroles` (
  `UserId` int(11) NOT NULL,
  `RoleId` int(11) NOT NULL,
  PRIMARY KEY  (`UserId`,`RoleId`),
  KEY `IX_UserRoles_RoleId` (`RoleId`),
  CONSTRAINT `FK_UserRoles_Roles_RoleId` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`RoleId`) ON DELETE CASCADE,
  CONSTRAINT `FK_UserRoles_Users_UserId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (1,1),(2,1),(1,2),(2,2),(1,3),(1,4),(2,4),(1,5);
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserId` int(11) NOT NULL auto_increment,
  `UserName` varchar(20) default NULL,
  `Password` varchar(45) default NULL,
  `EmployeeId` varchar(20) NOT NULL,
  `Estado` varchar(45) default NULL,
  `FechaDeCrecion` datetime default NULL,
  PRIMARY KEY  (`UserId`),
  UNIQUE KEY `EmployeeId_UNIQUE` (`EmployeeId`),
  UNIQUE KEY `IX_Users_UserName_EmployeeId` (`UserName`,`EmployeeId`),
  KEY `IX_Users_EmployeeId` (`EmployeeId`),
  CONSTRAINT `FK_Users_Employees_EmployeeId` FOREIGN KEY (`EmployeeId`) REFERENCES `employees` (`EmployeeId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'root','123','0101-1997-02703','activo',NULL),(2,'remy','123','0252-5465-64656','activo',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hambus_database'
--
/*!50003 DROP PROCEDURE IF EXISTS `CreateUser` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `CreateUser`(
	userName varchar(20),
    Password varchar(45),
    EmployeeId varchar(20)
)
BEGIN
	insert into users(UserName, Password, EmployeeId)
		values(userName, Password, EmployeeId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetLastTransId` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetLastTransId`()
BEGIN
SELECT TransId FROM transaccion ORDER BY TransId DESC LIMIT 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetMenuItemById` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetMenuItemById`(
	id varchar(20)
)
BEGIN
SELECT * FROM hambus_database.menuproducts
where MenuCategoryId = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetMenuItemByName` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetMenuItemByName`(
	id varchar(20)
)
BEGIN
SELECT * FROM hambus_database.menuproducts
where MenuCategoryId = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetMenuItemName` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetMenuItemName`(
	thisName varchar(40)
)
BEGIN
SELECT * FROM hambus_database.menuproducts
where ItemName = thisName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetProductCategoryById` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetProductCategoryById`(
	id varchar(20)
)
BEGIN
select 
    
    cat.MenuCategoryId,
    cat.MenuCategoryName,
    menu.MenuVersion
    
    from menucategories cat
    join restaurantmenus menu on cat.RestaurantMenuId = menu.RestaurantMenuId
    where cat.MenuCategoryId = id;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetProductCategoryByName` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetProductCategoryByName`(
	id varchar(20)
)
BEGIN
select 
    
    cat.MenuCategoryId,
    cat.MenuCategoryName,
    menu.MenuVersion
    
    from menucategories cat
    join restaurantmenus menu on cat.RestaurantMenuId = menu.RestaurantMenuId
    where cat.MenuCategoryName = id;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetRolesByUserId` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetRolesByUserId`(
	userId int
)
BEGIN
select
r.RoleId,
r.RoleName,
u.UserId
from roles r 

join userroles ur on r.RoleId = ur.RoleId
join users  u on ur.UserId = u.UserId
where u.UserId = userId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetUserByCedula` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetUserByCedula`(userId varchar(15))
BEGIN
select
r.RoleId,
r.RoleName,
u.UserId
from roles r 

join userroles ur on r.RoleId = ur.RoleId
join users  u on ur.UserId = u.UserId
where u.EmployeeId = userId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetUserById` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetUserById`(
	id varchar(20)
)
BEGIN
select
concat(emp.FirstName
			,' ',
			emp.MiddleName
			,' ',
			emp.LastName1
            ,' ',
			emp.LastName2) as Name,
u.UserId,
u.UserName,
u.Password,
u.EmployeeId,
emp.Puesto
from users u
join employees emp on u.EmployeeId = emp.EmployeeId
where emp.EmployeeId = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetUsers` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetUsers`()
BEGIN
select
concat(emp.FirstName
			,' ',
			emp.MiddleName
			,' ',
			emp.LastName1
            ,' ',
			emp.LastName2) as Name,
u.UserName,
u.Password,
u.EmployeeId
from users u
join employees emp on u.EmployeeId = emp.EmployeeId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetUsersByMode` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetUsersByMode`(
	modo varchar(20)
)
BEGIN
select
concat(emp.FirstName
			,' ',
			emp.MiddleName
			,' ',
			emp.LastName1
            ,' ',
			emp.LastName2) as Name,
u.UserName,
u.Password,
u.EmployeeId
from users u
join employees emp on u.EmployeeId = emp.EmployeeId

where u.Estado = modo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetUsersNames` */;
--
-- WARNING: old server version. The following dump may be incomplete.
--
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
CREATE PROCEDURE `GetUsersNames`()
BEGIN
select
emp.EmployeeId,
concat(emp.FirstName
			,' ',
			emp.MiddleName
			,' ',
			emp.LastName1
            ,' ',
			emp.LastName2) as Name
from  employees emp;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;

--
-- Final view structure for view `activeproducts`
--

/*!50001 DROP VIEW IF EXISTS `activeproducts`*/;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `activeproducts` AS select `menuproducts`.`MenuItemId` AS `MenuItemId`,`menuproducts`.`ItemName` AS `ItemName`,`menuproducts`.`ItemDescripcion` AS `ItemDescripcion`,`menuproducts`.`ItemPrice` AS `ItemPrice`,`menuproducts`.`MenuCategoryId` AS `MenuCategoryId`,`menuproducts`.`Estado` AS `Estado` from `menuproducts` where (`menuproducts`.`Estado` = _latin1'activo') */;

--
-- Final view structure for view `inactiveproducts`
--

/*!50001 DROP VIEW IF EXISTS `inactiveproducts`*/;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `inactiveproducts` AS select `menuproducts`.`MenuItemId` AS `MenuItemId`,`menuproducts`.`ItemName` AS `ItemName`,`menuproducts`.`ItemDescripcion` AS `ItemDescripcion`,`menuproducts`.`ItemPrice` AS `ItemPrice`,`menuproducts`.`MenuCategoryId` AS `MenuCategoryId`,`menuproducts`.`Estado` AS `Estado` from `menuproducts` where (`menuproducts`.`Estado` = _latin1'inactivo') */;

--
-- Final view structure for view `inactivesproductsview`
--

/*!50001 DROP VIEW IF EXISTS `inactivesproductsview`*/;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `inactivesproductsview` AS select `cat`.`MenuCategoryId` AS `MenuCategoryId`,`cat`.`MenuCategoryName` AS `MenuCategoryName`,`menu`.`MenuVersion` AS `MenuVersion` from (`menucategories` `cat` join `restaurantmenus` `menu` on((`cat`.`RestaurantMenuId` = `menu`.`RestaurantMenuId`))) where (`cat`.`Estado` = _latin1'inactivo') */;

--
-- Final view structure for view `productcategoriesview`
--

/*!50001 DROP VIEW IF EXISTS `productcategoriesview`*/;
/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `productcategoriesview` AS select `cat`.`MenuCategoryId` AS `MenuCategoryId`,`cat`.`MenuCategoryName` AS `MenuCategoryName`,`menu`.`MenuVersion` AS `MenuVersion` from (`menucategories` `cat` join `restaurantmenus` `menu` on((`cat`.`RestaurantMenuId` = `menu`.`RestaurantMenuId`))) where (`cat`.`Estado` = _latin1'activo') */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-18 22:18:42
