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
	PRIMARY KEY (exercise_id) 
);

CREATE TABLE body_part_exercise (
        body_part_exercise_id BIGSERIAL NOT NULL,
        body_part_fk BIGINT NOT NULL,
        exercise_fk BIGINT NOT NULL,
	PRIMARY KEY (body_part_exercise_id) 
);

ALTER TABLE body_part_exercise ADD CONSTRAINT body_part_exercise_body_part FOREIGN KEY (body_part_fk) REFERENCES body_part(body_part_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE body_part_exercise ADD CONSTRAINT body_part_exercise_exercise FOREIGN KEY (exercise_fk) REFERENCES exercise(exercise_id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Triceps', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Chest', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Shoulder', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Biceps', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Abs', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Back', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Forearm', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Thigh', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Glutes', '');
INSERT INTO public.body_part(body_part_name, body_part_photo) VALUES ('Calf', '');