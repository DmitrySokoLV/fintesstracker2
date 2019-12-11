mysql -u root -p

create database fitness_tracker;

create user 'root'@'localhost' identified by '54047922';

# Нужны ли привелегии? думаю что да.
GRANT ALL PRIVILEGES ON 'fitness_tracker' to 'db_user'@'localhost'
    -> IDENTIFIED BY 'pass' WITH GRANT OPTION;

# применяем привелегии
FLUSH PRIVILEGES;

exit

mysql -u test_user -p

use fitness_tracker;

create table `user` (
`id`          int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name`        varchar(255) NOT NULL,
`weight`      double NOT NULL,
`height`      double NOT NULL,
`bmi`         double
);

create table `training`  (
`id`              int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`status`          varchar(255) NOT NULL,
`created_date`    timestamp NOT NULL,
`user_id`         int unsigned NOT NULL
);

create table `training_exercises` (
`id`            int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`training_id`   int unsigned NOT NULL,
`exercise_id`   int unsigned NOT NULL,
FOREIGN KEY training_exercises
);

create table `exercise`  (
`id`                    int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`exerciseType`          varchar(255) NOT NULL,
`numberOfTimes`         int NULL,
`numberOfApproaches`    int NULL
);

