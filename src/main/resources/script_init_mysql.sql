CREATE USER 'root_dmitry'@'localhost' IDENTIFIED BY '54047922';
ALTER USER 'root_dmitry'@'localhost' PASSWORD EXPIRE NEVER;
CREATE SCHEMA `fitness_tracker` CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON `fitness_tracker`.* TO 'root_dmitry'@'localhost';