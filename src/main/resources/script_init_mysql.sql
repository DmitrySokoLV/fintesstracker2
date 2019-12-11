create database fitness_tracker;

CREATE USER 'root_dima'@'localhost' IDENTIFIED BY '54047922';
ALTER USER 'root_dima'@'localhost' PASSWORD EXPIRE NEVER;
CREATE SCHEMA `root_dima` CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON `root_dima`.* TO `root_dima`@'localhost';

use fitness_tracker;

create table `user` (
`id`          int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name`        varchar(255) NOT NULL,
`weight`      double NOT NULL,
`height`      double NOT NULL,
`bmi`         double NULL,
);

create table `training`  (
`id`              int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`status`          varchar(255) NOT NULL,
`created_date`    timestamp NOT NULL,
`user_id`         int unsigned NOT NULL,
);

create table `exercise`  (
`id`                    int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`exerciseType`          varchar(255) NULL,
`numberOfTimes`         int NULL,
`numberOfApproaches`    int NULL,
);

create table `training_exercises` (
`id`            int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`training_id`   int unsigned NOT NULL,
`exercise_id`   int unsigned NOT NULL,
CONSTRAINT trainings_exercises_fk FOREIGN KEY (training_id) REFERENCES "training" ("id")
CONSTRAINT trainings_exercises_fk2 FOREIGN KEY (exercise_id) REFERENCES "exercise" ("id")
);


