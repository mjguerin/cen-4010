DROP TABLE IF EXISTS `rate_comment`;
DROP TABLE IF EXISTS `books`;
DROP TABLE IF EXISTS `users`;

/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

CREATE TABLE `books` (
  `isbn` VARCHAR(255) COLLATE utf8mb3_bin NOT NULL,
  `book_name` VARCHAR(255) COLLATE utf8mb3_bin NOT NULL,
  `book_description` VARCHAR(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `price` DECIMAL(38,2) DEFAULT NULL,
  `author` VARCHAR(255) COLLATE utf8mb3_bin NOT NULL,
  `genre` VARCHAR(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `publisher` VARCHAR(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `year_published` INT DEFAULT NULL,
  `copies_sold` INT UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

CREATE TABLE `rate_comment` (
  `ra_co_id` INT AUTO_INCREMENT PRIMARY KEY,
  `user_id` INT NOT NULL,
  `isbn` VARCHAR(255) NOT NULL,
  `rating` DECIMAL(2, 1) CHECK (rating BETWEEN 0 AND 5) DEFAULT NULL,
  `comment` TEXT DEFAULT NULL,
  `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`),
  FOREIGN KEY (`isbn`) REFERENCES `books`(`isbn`),
  UNIQUE KEY (`user_id`, `isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- Placeholder to get userId
CREATE TABLE `users` (
    `user_id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(50) NOT NULL UNIQUE,
    `userpassword` VARCHAR(255) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `address` VARCHAR(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

/*!40101 SET character_set_client = @saved_cs_client */;
