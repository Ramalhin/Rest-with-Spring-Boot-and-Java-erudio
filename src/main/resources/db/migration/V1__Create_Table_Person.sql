
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `adress` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
);


