CREATE DATABASE IF NOT EXISTS `course`;
CREATE USER 'bobby'@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON course.* TO 'bobby'@'%';
