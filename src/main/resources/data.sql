DROP TABLE IF EXISTS RETRODAYS;

CREATE TABLE RETRODAYS (
  id INT AUTO_INCREMENT NOT NULL,
  day_date VARCHAR(250) NOT NULL,
  is_best_day VARCHAR(250) NOT NULL,
  note VARCHAR(250) DEFAULT NULL,
  primary key (id,day_date)
);

INSERT INTO RETRODAYS (id, day_date, is_best_day, note) VALUES
  (1, '11/11/2019', 'true','today is my best day');