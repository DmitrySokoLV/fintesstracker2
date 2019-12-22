--liquibase formatted sql

--changeset dima:1
create table `user` (
`id`          int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name`        varchar(255) NOT NULL,
`weight`      double NOT NULL,
`height`      int NOT NULL,
`bmi`         double NULL
);

--changeset dima:2
create table `training`  (
`id`              int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`status`          varchar(255) NOT NULL,
`created_date`    timestamp NOT NULL,
`user_id`         int unsigned NOT NULL
);

--changeset dima:3
create table `exercise`  (
`id`                    int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`exerciseType`          varchar(255) NULL,
`numberOfTimes`         int NULL,
`numberOfApproaches`    int NULL
);

--changeset dima:4
create table `training_exercises` (
`id`            int unsigned NOT NULL AUTO_INCREMENT PRIMARY KEY,
`training_id`   int unsigned NOT NULL,
`exercise_id`   int unsigned NOT NULL,
CONSTRAINT trainings_exercises_fk FOREIGN KEY (training_id) REFERENCES `training` (`id`),
CONSTRAINT trainings_exercises_fk2 FOREIGN KEY (exercise_id) REFERENCES `exercise` (`id`)
);

--changeset dima:5
INSERT INTO `user` (name, weight, height) VALUES ('dima', 76.5, 176);