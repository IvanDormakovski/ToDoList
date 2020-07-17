# set global time_zone = '-3:00';
create table tasks
(
    id          INT primary key AUTO_INCREMENT,
    Task        VARCHAR(255) NOT NULL,
    Description VARCHAR(255) DEFAULT NULL,
    isDone      BOOLEAN      NOT NULL DEFAULT FALSE,
    addDate     DATETIME     NOT NULL
);