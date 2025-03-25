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

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `id_carrera` int NOT NULL AUTO_INCREMENT,
  `id_plan_de_estudio` int DEFAULT NULL,
  `inicio_de_dictado` date DEFAULT NULL,
  `nombre_carrera` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_carrera`),
  KEY `FK83orh8ard2xehcvd0r9akyoyv` (`id_plan_de_estudio`),
  CONSTRAINT `FK83orh8ard2xehcvd0r9akyoyv` FOREIGN KEY (`id_plan_de_estudio`) REFERENCES `plan_de_estudio` (`id_plan_de_estudio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,1,'2025-03-01','Profesorado de ingles'),(2,2,'2025-03-06','tecnicatura de enfermeria'),(3,3,'2025-03-03','profesorado de letras'),(4,2,'2025-03-29','probando');
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correlatividades`
--

DROP TABLE IF EXISTS `correlatividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `correlatividades` (
  `id_correlatividad` int NOT NULL AUTO_INCREMENT,
  `id_materia` int NOT NULL,
  `id_materia_correlativa` int NOT NULL,
  PRIMARY KEY (`id_correlatividad`),
  KEY `FKai0fcjttlitojqgf7x8wi31g` (`id_materia`),
  KEY `FK39exp9ndk9pm26ulx8gfdeh36` (`id_materia_correlativa`),
  CONSTRAINT `FK39exp9ndk9pm26ulx8gfdeh36` FOREIGN KEY (`id_materia_correlativa`) REFERENCES `materias` (`id_materia`),
  CONSTRAINT `FKai0fcjttlitojqgf7x8wi31g` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id_materia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correlatividades`
--

LOCK TABLES `correlatividades` WRITE;
/*!40000 ALTER TABLE `correlatividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `correlatividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripciones_carreras`
--

DROP TABLE IF EXISTS `inscripciones_carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripciones_carreras` (
  `id_inscripcion` int NOT NULL AUTO_INCREMENT,
  `fecha_inscripcion` date DEFAULT NULL,
  `id_carrera` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_inscripcion`),
  KEY `FKb72axbd50f8ra10qkuprgjkm` (`id_carrera`),
  KEY `FKce754520297hw50wsy8hpaoju` (`id_usuario`),
  CONSTRAINT `FKb72axbd50f8ra10qkuprgjkm` FOREIGN KEY (`id_carrera`) REFERENCES `carrera` (`id_carrera`),
  CONSTRAINT `FKce754520297hw50wsy8hpaoju` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripciones_carreras`
--

LOCK TABLES `inscripciones_carreras` WRITE;
/*!40000 ALTER TABLE `inscripciones_carreras` DISABLE KEYS */;
INSERT INTO `inscripciones_carreras` VALUES (1,'2025-02-23',1,3),(2,'2025-02-23',1,4),(3,'2025-02-23',1,5),(4,'2025-02-23',1,4),(5,'2025-02-23',1,6),(6,'2025-02-23',1,4),(7,'2025-02-23',1,3),(8,NULL,1,5),(9,'2025-03-06',1,7),(10,'2025-03-21',1,8),(11,'2025-03-06',2,9),(12,NULL,1,8),(13,NULL,1,8),(14,'2025-03-12',3,10),(15,NULL,1,3),(16,NULL,1,6);
/*!40000 ALTER TABLE `inscripciones_carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcionesaexamenes`
--

DROP TABLE IF EXISTS `inscripcionesaexamenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripcionesaexamenes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `anio_de_cursado` int DEFAULT NULL,
  `ciclo` int DEFAULT NULL,
  `condicion` varchar(255) DEFAULT NULL,
  `estado` varchar(20) DEFAULT 'enviada',
  `fecha_de_inscripcion` datetime(6) DEFAULT NULL,
  `llamado` int NOT NULL,
  `id_llamado` bigint NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl00f8uy4478g3fw0alhh8shm3` (`id_llamado`),
  KEY `FKcn2ifpdvcrb303vo3n7w9cyyg` (`id_usuario`),
  CONSTRAINT `FKcn2ifpdvcrb303vo3n7w9cyyg` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKl00f8uy4478g3fw0alhh8shm3` FOREIGN KEY (`id_llamado`) REFERENCES `llamadosamesa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcionesaexamenes`
--

LOCK TABLES `inscripcionesaexamenes` WRITE;
/*!40000 ALTER TABLE `inscripcionesaexamenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripcionesaexamenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `llamadosamesa`
--

DROP TABLE IF EXISTS `llamadosamesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `llamadosamesa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_examen` date NOT NULL,
  `turno` varchar(255) NOT NULL,
  `id_materia` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7hrec6en2qyjw0o9tn2x1b08y` (`id_materia`),
  CONSTRAINT `FK7hrec6en2qyjw0o9tn2x1b08y` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id_materia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `llamadosamesa`
--

LOCK TABLES `llamadosamesa` WRITE;
/*!40000 ALTER TABLE `llamadosamesa` DISABLE KEYS */;
/*!40000 ALTER TABLE `llamadosamesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materias` (
  `id_materia` int NOT NULL AUTO_INCREMENT,
  `ciclo` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero_de_materia` int DEFAULT NULL,
  `id_plan_de_estudio` int NOT NULL,
  PRIMARY KEY (`id_materia`),
  KEY `FKd1iteab3fh7gk1vdjed3d92vm` (`id_plan_de_estudio`),
  CONSTRAINT `FKd1iteab3fh7gk1vdjed3d92vm` FOREIGN KEY (`id_plan_de_estudio`) REFERENCES `plan_de_estudio` (`id_plan_de_estudio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notas` (
  `id_nota` int NOT NULL AUTO_INCREMENT,
  `nota_final` int DEFAULT NULL,
  `id_materia` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_nota`),
  KEY `FKmauhbly5thjaqb0vs4sv0e0al` (`id_materia`),
  KEY `FKsk0omp8hd6wkjkjfg6uljyrqu` (`id_usuario`),
  CONSTRAINT `FKmauhbly5thjaqb0vs4sv0e0al` FOREIGN KEY (`id_materia`) REFERENCES `materias` (`id_materia`),
  CONSTRAINT `FKsk0omp8hd6wkjkjfg6uljyrqu` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo_de_inscripcion`
--

DROP TABLE IF EXISTS `periodo_de_inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo_de_inscripcion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_fin` datetime(6) NOT NULL,
  `fecha_inicio` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo_de_inscripcion`
--

LOCK TABLES `periodo_de_inscripcion` WRITE;
/*!40000 ALTER TABLE `periodo_de_inscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodo_de_inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_de_estudio`
--

DROP TABLE IF EXISTS `plan_de_estudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_de_estudio` (
  `id_plan_de_estudio` int NOT NULL AUTO_INCREMENT,
  `codigo_resolucion` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `duracion_en_anios` int DEFAULT NULL,
  `fecha_entrada_en_vigencia` date DEFAULT NULL,
  `link_recurso` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_plan_de_estudio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_de_estudio`
--

LOCK TABLES `plan_de_estudio` WRITE;
/*!40000 ALTER TABLE `plan_de_estudio` DISABLE KEYS */;
INSERT INTO `plan_de_estudio` VALUES (1,'RES-2025-001','Profesorado de ingles',4,'2025-01-01','https://example.com/plan2024','Plan 2025-2028'),(2,'RES-408','Enfermeria',4,'2025-03-06','ejemplo.com','tecnicatura en enfermeria'),(3,'RES-406','literatura',4,'2025-03-03','ejemplolit.com','profesorado de letras');
/*!40000 ALTER TABLE `plan_de_estudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'alumno'),(2,'administrador');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `apellido_usuario` varchar(255) DEFAULT NULL,
  `clave_acceso` varchar(255) DEFAULT NULL,
  `dni_usuario` varchar(255) DEFAULT NULL,
  `domicilio_usuario` varchar(255) DEFAULT NULL,
  `email_usuario` varchar(255) DEFAULT NULL,
  `estado` varchar(20) DEFAULT 'activo',
  `id_rol` int DEFAULT NULL,
  `nombre_usuario` varchar(255) DEFAULT NULL,
  `telefono_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','$2a$12$vdHkCg7MgQLWy8wItITeAu5JA8LEz5FYhG2YuDAGYPCSRQeZbuUWK','12345678','casa de admin','admin2@mail.com','activo',2,'administrador','+543443567890'),(2,'estudiante','$2a$10$tl.GSMUqt/Akhfj/UZQXUO6VHP14okAsFgBQVoRzteqGRCpYU9rdK','87654321','Calle lluviosa 123','estudiante@mail.com','inactivo',1,'alumno','+543445447890'),(3,'Silva','$2a$10$mafjIcGkxQBBiNoyk7F21em3QlQoHQHHrpb73P50vSDJ9E0pSMviS','12345678','Luis palma s/n sauce de luna','gabita@example.com','inactivo',1,'Maria ','+543438441590'),(4,'Sanchez','$2a$10$Mf323Q4MMwIzjXsvNIBv9O1BTR2AvexPtVQHdRwPMpnXXobcYRid2','87654321','Calle lluviosa 123','gabi@example.com','activo',1,'Gabriela Victoria','+543445447890'),(5,'Petro','$2a$10$SDdqvQ3nJcP2Hk0hRKv4..q7LHDb0eGAw6AG42D9rfhT5QsA.8Csi','87654321','Urdinarrain','juan@mail.com','activo',1,'Juan Matias','+543445447890'),(6,'Villalbas','$2a$10$gbnwZLuULe7nKqVcX8cZbuh4SjBMNno23RWCX1GDCsjq2ydDGj9Aq','87654321','Calle lluviosa 123','ema@mail.com','activo',1,'Facu','+543445447890'),(7,'caraballo','$2a$10$/Lqv6OgqMZzJn1TFoeO39OYmX6VUn5yPqC38/4QJNPoUv6I7MzkGu','70090425','magnasco 409','berenice@example.com','inactivo',1,'berenice','+543445447890'),(8,'caraballo','$2a$10$Kut33B.HAEs9p.ZYNKzQHOXLuYWPPQN2EOoOEW.iF8cH2TX.DCXxy','70090425','magnasco 409','bere@example.com','inactivo',1,'berenice','+543445447890'),(9,'caraballo','$2a$10$G6dLNzwkdeL.lFvSvM7yPeNrl53tPDp7IwvHelMFeRovFPhwh2dCu','70090425','magnasco 409','berenice@example.com','activo',1,'berenice','+543445447890'),(10,'brelis','$2a$10$nsNpFHfmUTxzDkBOOj8KlO4CsmCY2SSpZjOtuq/sytJeIIBOCMDji','70090425','magnasco 409','bere@example.com','activo',1,'martin','+543445447890');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-25 15:05:43
