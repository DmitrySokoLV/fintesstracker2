mysql -u root -p

create database fitness_tracker;

create user 'test_user'@'localhost' identified by '54047922';

# Нужны ли привелегии? думаю что да.
GRANT ALL PRIVILEGES ON dbase_name.* to 'db_user'@'localhost'
    -> IDENTIFIED BY 'pass' WITH GRANT OPTION;

# применяем привелегии
FLUSH PRIVILEGES;

exit

mysql -u test_user -p

use fitness_tracker;

create table `user` (
`id`          int unsigned NOT NULL AUTO_INCREMENT,
`name`        varchar(255) NOT NULL,
`weight`      double(20) NOT NULL,
`height`      double(20) NOT NULL,
`bmi`         double(20) NULL,
`trainings`   NULL,
PRIMARY KEY     (`id`)
);

create table `training`  (
`id`              int unsigned NOT NULL AUTO_INCREMENT,
`status`          varchar(255) NOT NULL,
`created_date`    timestamp(8) NOT NULL,
`user_id`         NOT NULL,
PRIMARY KEY     (`id`)
);

create table `training_exercises` (
`id`            int unsigned NOT NULL AUTO_INCREMENT,
`training_id`   int NOT NULL,
`exercise_id`   int NOT NULL,
PRIMARY KEY     (`id`)
);

create table `exercise`  (
`id`                    int unsigned NOT NULL AUTO_INCREMENT,
`exerciseType`          varchar(255) NOT NULL,
`numberOfTimes`         int NULL,
`numberOfApproaches`    int NULL,
PRIMARY KEY     (`id`)
);

