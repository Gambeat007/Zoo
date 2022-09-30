CREATE TABLE AREA (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(50) NOT NULL
);

CREATE TABLE ANIMAL (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    kind VARCHAR(20) NOT NULL,
    food INTEGER NOT NULL,
    area_id BIGINT NOT NULL
);

ALTER TABLE ANIMAL ADD CONSTRAINT
animal_area_fk FOREIGN KEY (area_id) REFERENCES area(id)