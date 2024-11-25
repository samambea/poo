CREATE DATABASE `projetom1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

CREATE TABLE `books` (
  `bookId` int(11) ,
  `authors` varchar(255) NOT NULL,
  `bookName` varchar(100) NOT NULL,
  `genre` varchar(45) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `yearPublished` varchar(10) NOT NULL,
  `edition` varchar(45) NOT NULL,
  `qtdInStock` int(11) NOT NULL,
  `rating` float NOT NULL,
  `price` varchar(45) NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
