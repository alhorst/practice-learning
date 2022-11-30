BEGIN TRANSACTION;

DROP TABLE IF EXISTS member, interest_group, event, event_member, member_group;

CREATE TABLE member (
    member_id serial NOT NULL,
    last_name varchar(100) NOT NULL,
    first_name varchar(100) NOT NULL,
    email_address varchar(100) NOT NULL,
    phone_number varchar(15),
    birth_date date NOT NULL,
    reminder_emails boolean NOT NULL,
    CONSTRAINT PK_member PRIMARY KEY (member_id)
);

CREATE TABLE interest_group (
    group_id serial NOT NULL,
    group_name varchar (200) UNIQUE NOT NULL,
    CONSTRAINT PK_group PRIMARY KEY (group_id)
);

CREATE TABLE event (
    event_id serial NOT NULL,
    event_group int NOT NULL,
    event_name varchar(200) NOT NULL,
    event_description text NOT NULL,
    start_date date NOT NULL,
    start_time time NOT NULL,
    duration int CONSTRAINT duration_time CHECK(duration >= 30),
    CONSTRAINT PK_event PRIMARY KEY (event_id),
    CONSTRAINT FK_event_group FOREIGN KEY (event_group) REFERENCES interest_group (group_id)
);

CREATE TABLE member_group (
    member_id int NOT NULL,
    group_id int NOT NULL,
    CONSTRAINT PK_member_group PRIMARY KEY (member_id, group_id),
    CONSTRAINT FK_member_group_member FOREIGN KEY (member_id) REFERENCES member (member_id),
    CONSTRAINT FK_member_group_group FOREIGN KEY (group_id) REFERENCES interest_group (group_id)
);

CREATE TABLE event_member (
    member_id int NOT NULL,
    event_id int NOT NULL,
    CONSTRAINT PK_event_member PRIMARY KEY (member_id, event_id),
    CONSTRAINT FK_event_member_member FOREIGN KEY (member_id) REFERENCES member (member_id),
    CONSTRAINT FK_event_member_event FOREIGN KEY (event_id) REFERENCES event (event_id)
);

INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (1, 'Nancy', 'Drew', 'mysterysolver@gmail.com', '339-412-7567', '1926-12-15', TRUE);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (2, 'Carmen', 'Sandiego', 'whereami@gmail.com', NULL, '1985-05-20', FALSE);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (3, 'Betel', 'Geuse', 'thirdtimesacharm@gmail.com', NULL, '1988-03-20', FALSE);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (4, 'Jack', 'Sparrow', 'captainjack@gmail.com', NULL, '1752-06-11', FALSE);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (5, 'Icabod', 'Craine', 'headmastercraine@gmail.com', '646-212-3842', '1820-10-31', TRUE);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (6, 'Waldo', 'Handford', 'findmeifyoucan@gmail.com', NULL, '1987-07-22', FALSE);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (7, 'Donna', 'Noble', 'chiswickgrl@gmail.com', '44-020-321-9843', '1977-04-21', TRUE);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (8, 'Rose', 'Tyler', 'badwolf@gmail.com', NULL, '1985-12-01', FALSE);
INSERT INTO member (member_id, first_name, last_name, email_address, phone_number, birth_date, reminder_emails) VALUES (9, 'The', 'Doctor', 'doctor@tardis.io', NULL, '1963-11-23', TRUE);

INSERT INTO interest_group (group_id, group_name) VALUES (111, 'Mystery Solvers Unite'); 
INSERT INTO interest_group (group_id, group_name) VALUES (112, 'Tim Burton Fan Club');
INSERT INTO interest_group (group_id, group_name) VALUES (999, 'Doctor WHO?');

INSERT INTO event (event_id, event_group, event_name, event_description, start_date, start_time, duration) VALUES (10, 112, 'The Best of Tim Burton!', 'Come watch the best movies of famed director Tim Burton, with surprise special guests!', '2022-12-05', '21:30', 320);
INSERT INTO event (event_id, event_group, event_name, event_description, start_date, start_time, duration) VALUES (12, 111, 'Where In the World Is Carmen Sandiego?', 'Watch in REAL TIME as your favorite sleuth tries to figure out where Carmen Sandiego went!', '2023-01-04', '11:00', 65);
INSERT INTO event (event_id, event_group, event_name, event_description, start_date, start_time, duration) VALUES (13, 999, 'The TARDIS: A Deep-Dive', 'A big ball of timey wimey wibbly wobbly stuff.', '2023-05-06', '9:15', 240);
INSERT INTO event (event_id, event_group, event_name, event_description, start_date, start_time, duration) VALUES (14, 112, 'Who Is the Headless Horseman? And Other Stories.', 'Discussion on supernatural happenings in New York. We have pumpkin muffins.', '2023-10-31', '24:00', 120);

INSERT INTO member_group (member_id, group_id) VALUES (1, 111);
INSERT INTO member_group (member_id, group_id) VALUES (2, 111);
INSERT INTO member_group (member_id, group_id) VALUES (6, 111);
INSERT INTO member_group (member_id, group_id) VALUES (3, 112);
INSERT INTO member_group (member_id, group_id) VALUES (5, 112);
INSERT INTO member_group (member_id, group_id) VALUES (4, 112);
INSERT INTO member_group (member_id, group_id) VALUES (7, 999);
INSERT INTO member_group (member_id, group_id) VALUES (8, 999);
INSERT INTO member_group (member_id, group_id) VALUES (9, 999);

INSERT INTO event_member (member_id, event_id) VALUES (3, 10);
INSERT INTO event_member (member_id, event_id) VALUES (4, 10);
INSERT INTO event_member (member_id, event_id) VALUES (9, 13);
INSERT INTO event_member (member_id, event_id) VALUES (8, 13);
INSERT INTO event_member (member_id, event_id) VALUES (7, 13);
INSERT INTO event_member (member_id, event_id) VALUES (5, 14);
INSERT INTO event_member (member_id, event_id) VALUES (1, 12);
INSERT INTO event_member (member_id, event_id) VALUES (6, 12);
COMMIT;








