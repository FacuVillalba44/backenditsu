-- MySQL dump 10.13  Distrib 8.0.37, for Linux (x86_64)
--
-- Host: localhost    Database: itsudb
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'alumno'),(2,'administrador');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `plan_de_estudio`
--

LOCK TABLES `plan_de_estudio` WRITE;
/*!40000 ALTER TABLE `plan_de_estudio` DISABLE KEYS */;
INSERT INTO `plan_de_estudio` VALUES (1,'RES-2025-001','Profesorado de ingles',4,'2025-01-01','https://example.com/plan2024','Plan 2025-2028'),(2,'RES-408','Enfermeria',4,'2025-03-06','ejemplo.com','tecnicatura en enfermeria'),(3,'RES-406','literatura',4,'2025-03-03','ejemplolit.com','profesorado de letras');
/*!40000 ALTER TABLE `plan_de_estudio` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','$2a$12$vdHkCg7MgQLWy8wItITeAu5JA8LEz5FYhG2YuDAGYPCSRQeZbuUWK','12345678','casa de admin','admin2@mail.com','activo',2,'administrador','+543443567890'),(2,'estudiante','$2a$10$tl.GSMUqt/Akhfj/UZQXUO6VHP14okAsFgBQVoRzteqGRCpYU9rdK','87654321','Calle lluviosa 123','estudiante@mail.com','inactivo',1,'alumno','+543445447890'),(3,'Silva','$2a$10$mafjIcGkxQBBiNoyk7F21em3QlQoHQHHrpb73P50vSDJ9E0pSMviS','12345678','Luis palma s/n sauce de luna','gabita@example.com','inactivo',1,'Maria ','+543438441590'),(4,'Sanchez','$2a$10$Mf323Q4MMwIzjXsvNIBv9O1BTR2AvexPtVQHdRwPMpnXXobcYRid2','87654321','Calle lluviosa 123','gabi@example.com','activo',1,'Gabriela Victoria','+543445447890'),(5,'Petro','$2a$10$SDdqvQ3nJcP2Hk0hRKv4..q7LHDb0eGAw6AG42D9rfhT5QsA.8Csi','87654321','Urdinarrain','juan@mail.com','activo',1,'Juan Matias','+543445447890'),(6,'Villalbas','$2a$10$gbnwZLuULe7nKqVcX8cZbuh4SjBMNno23RWCX1GDCsjq2ydDGj9Aq','87654321','Calle lluviosa 123','ema@mail.com','activo',1,'Facu','+543445447890'),(7,'caraballo','$2a$10$/Lqv6OgqMZzJn1TFoeO39OYmX6VUn5yPqC38/4QJNPoUv6I7MzkGu','70090425','magnasco 409','berenice@example.com','inactivo',1,'berenice','+543445447890'),(8,'caraballo','$2a$10$Kut33B.HAEs9p.ZYNKzQHOXLuYWPPQN2EOoOEW.iF8cH2TX.DCXxy','70090425','magnasco 409','bere@example.com','inactivo',1,'berenice','+543445447890'),(9,'caraballo','$2a$10$G6dLNzwkdeL.lFvSvM7yPeNrl53tPDp7IwvHelMFeRovFPhwh2dCu','70090425','magnasco 409','berenice@example.com','activo',1,'berenice','+543445447890'),(10,'brelis','$2a$10$nsNpFHfmUTxzDkBOOj8KlO4CsmCY2SSpZjOtuq/sytJeIIBOCMDji','70090425','magnasco 409','bere@example.com','activo',1,'martin','+543445447890');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,1,'2025-03-01','Profesorado de ingles'),(2,2,'2025-03-06','tecnicatura de enfermeria'),(3,3,'2025-03-03','profesorado de letras'),(4,2,'2025-03-29','probando');
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `correlatividades`
--

LOCK TABLES `correlatividades` WRITE;
/*!40000 ALTER TABLE `correlatividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `correlatividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `inscripciones_carreras`
--

LOCK TABLES `inscripciones_carreras` WRITE;
/*!40000 ALTER TABLE `inscripciones_carreras` DISABLE KEYS */;
INSERT INTO `inscripciones_carreras` VALUES (1,'2025-02-23',1,3),(2,'2025-02-23',1,4),(3,'2025-02-23',1,5),(4,'2025-02-23',1,4),(5,'2025-02-23',1,6),(6,'2025-02-23',1,4),(7,'2025-02-23',1,3),(8,NULL,1,5),(9,'2025-03-06',1,7),(10,'2025-03-21',1,8),(11,'2025-03-06',2,9),(12,NULL,1,8),(13,NULL,1,8),(14,'2025-03-12',3,10),(15,NULL,1,3),(16,NULL,1,6);
/*!40000 ALTER TABLE `inscripciones_carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `inscripcionesaexamenes`
--

LOCK TABLES `inscripcionesaexamenes` WRITE;
/*!40000 ALTER TABLE `inscripcionesaexamenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcionesaexamenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `llamadosamesa`
--

LOCK TABLES `llamadosamesa` WRITE;
/*!40000 ALTER TABLE `llamadosamesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `llamadosamesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `periodo_de_inscripcion`
--

LOCK TABLES `periodo_de_inscripcion` WRITE;
/*!40000 ALTER TABLE `periodo_de_inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodo_de_inscripcion` ENABLE KEYS */;
UNLOCK TABLES;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-25 14:39:59
