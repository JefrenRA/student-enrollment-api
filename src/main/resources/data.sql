INSERT INTO COURSE (course_code, course_description) VALUES ('CEIT-03-BSCpE', 'Bachelor of Science in Computer Engineering');

INSERT INTO COURSE (course_code, course_description) VALUES ('CEIT-26-BSCE', 'Bachelor of Science in Civil Engineering');

INSERT INTO SUBJECT(subject_id, subject_code, subject_description) VALUES (0, 'CPE401', 'Embedded Systems');

INSERT INTO SUBJECT(subject_id, subject_code, subject_description) VALUES (1, 'CPE301', 'Logic Circuits and Design');

INSERT INTO SUBJECT(subject_id, subject_code, subject_description) VALUES (2, 'CPE205', 'Assembly Language Programming');

INSERT INTO STUDENT(student_id, address, dob, firstname, gender, surname, course_code) VALUES (2019200393, 'Cainta Rizal', 'November 30,1999',  'Anna Merien', 'Female', 'Eugenio', 'CEIT-03-BSCpE');

INSERT INTO STUDENT(student_id, address,dob, firstname, gender, surname, course_code)VALUES (2019200387, 'Pasig City', 'August 18, 2000',  'Paul Brian', 'Male ', 'Escote', 'CEIT-03-BSCpE');

INSERT INTO STUDENT(student_id, address, dob, firstname, gender, surname, course_code)VALUES (2019201832, 'Pasig City', 'December 13, 2000', 'Ma. Isabelita', 'Female', 'Castillo', 'CEIT-03-BSCpE');

INSERT INTO STUDENT(student_id, address, dob, firstname, gender, surname, course_code)VALUES (2019200386, 'Pasig City', 'June 12, 2001',  'Elmie Jane', 'Female', 'Villasencio', 'CEIT-26-BSCE');

INSERT INTO STUDENT_SUBJECT(student_id, subject_id) VALUES (2019200393, 0);

INSERT INTO STUDENT_SUBJECT(student_id, subject_id) VALUES (2019200387, 2);

INSERT INTO ACCOUNT (id, username, password, role) VALUES (1, 'user1', 'pass1', 'USER');
INSERT INTO ACCOUNT (id, username, password, role) VALUES (2, 'admin1', 'pass1', 'ADMIN');