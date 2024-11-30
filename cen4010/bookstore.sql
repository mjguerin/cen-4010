-- MySQL dump 10.13  Distrib 8.0.38, for macos14 (x86_64)
--
-- Host: localhost    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `isbn` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `book_name` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `book_description` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `price` decimal(38,2) DEFAULT NULL,
  `author` varchar(255) COLLATE utf8mb3_bin NOT NULL,
  `genre` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `publisher` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `year_published` int DEFAULT NULL,
  `copies_sold` int unsigned DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `users`;

-- Placeholder for user profile table
CREATE TABLE `users` (
    `user_id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `userpassword` VARCHAR(255) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `address` VARCHAR(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

DROP TABLE IF EXISTS `rate_comment`;

CREATE TABLE `rate_comment` (
    `ra_co_id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT NOT NULL,
    `isbn` VARCHAR(255) NOT NULL,
    `rating` DECIMAL(2, 1) CHECK (rating BETWEEN 0 AND 5) DEFAULT NULL,
    `comment` TEXT DEFAULT NULL,
    `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`) ON DELETE CASCADE,
    FOREIGN KEY (`isbn`) REFERENCES `books`(`isbn`) ON DELETE CASCADE,
    UNIQUE KEY (`user_id`, `isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES ('9780060935467','To the Lighthouse','A modernist novel exploring the Ramsay family\'s visits to Scotland',11.99,'Virginia Woolf','Fiction','Harcourt',1927,5000000),('9780061120084','To Kill a Mockingbird','A novel about racial injustice in a small Southern town',14.99,'Harper Lee','Fiction','HarperCollins',1960,40000000),('9780062315007','The Alchemist','A philosophical novel about a young shepherd\'s journey',16.99,'Paulo Coelho','Fiction','HarperOne',1988,65000000),('9780140283334','1984','A dystopian novel set in a totalitarian society',12.99,'George Orwell','Science Fiction','Penguin Books',1949,30000000),('9780307474278','The Girl with the Dragon Tattoo','A crime novel featuring journalist Mikael Blomkvist',9.99,'Stieg Larsson','Crime','Vintage Crime/Black Lizard',2005,80000000),('9780385504200','The Da Vinci Code','A thriller involving a conspiracy within the Catholic Church',19.99,'Dan Brown','Thriller','Doubleday',2003,80000000),('9780545010221','Harry Potter and the Sorcerer\'s Stone','The first book in the Harry Potter series',24.99,'J.K. Rowling','Fantasy','Scholastic',1997,120000000),('9780553418026','The Martian','A science fiction novel about an astronaut stranded on Mars',14.99,'Andy Weir','Science Fiction','Broadway Books',2011,15000000),('9780618260300','The Hobbit','A fantasy novel about the adventures of Bilbo Baggins',15.99,'J.R.R. Tolkien','Fantasy','Houghton Mifflin',1937,100000000),('9780743273565','The Great Gatsby','A novel about the American Dream in the Roaring Twenties',13.99,'F. Scott Fitzgerald','Fiction','Scribner',1925,25000000);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29 17:03:58
