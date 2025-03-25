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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `periodo_de_inscripcion`
--

DROP TABLE IF EXISTS `periodo_de_inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo_de_inscripcion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha_fin` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-06 15:04:03
