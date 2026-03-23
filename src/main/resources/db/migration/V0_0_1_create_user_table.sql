CREATE TABLE `travel_database`.`users`
(
    `id`         INT NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(100) NULL,
    `first_name` VARCHAR(100) NULL,
    `last_name`  VARCHAR(100) NULL,
    `birth_date` DATE NULL,
    `email`      VARCHAR(100) NULL,
    `password`   VARCHAR(100) NULL,
    `created_at` TIMESTAMP NULL,
    PRIMARY KEY (`id`)
);