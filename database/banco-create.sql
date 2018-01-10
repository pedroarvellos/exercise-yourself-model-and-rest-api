CREATE TABLE body_part (
	body_part_id BIGSERIAL NOT NULL,
	body_part_name VARCHAR (100) NOT NULL,
	body_part_photo BYTEA,
	PRIMARY KEY (body_part_id)
);

CREATE TABLE exercise (
        exercise_id BIGSERIAL NOT NULL,
        exercise_name VARCHAR (100) NOT NULL,
        exercise_description TEXT,
        exercise_photo BYTEA,
        exercise_instructions TEXT,
        exercise_body_part_fk BIGINT,
	PRIMARY KEY (exercise_id) 
);

ALTER TABLE exercise ADD CONSTRAINT exercise_body_part FOREIGN KEY (exercise_body_part_fk) REFERENCES body_part(body_part_id) ON UPDATE CASCADE ON DELETE SET NULL;