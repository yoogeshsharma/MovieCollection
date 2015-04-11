CREATE DATABASE moviecollection;
USE moviecollection;

CREATE TABLE movie_copy(
	id INT PRIMARY KEY,
	titel VARCHAR(50) NOT NULL,
	formats VARCHAR(20),
	releases INT,
	rating INT,
	length_min INT,
	length_sec INT
);