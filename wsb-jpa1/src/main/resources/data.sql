insert into address (id, city, ADDRESS_LINE1 , ADDRESS_LINE2, POSTAL_CODE)
            values (1, 'Warszawa', 'Marszalkowska', '1', '00-001'),
                   (2, 'Wroclaw', 'ABC', '2', '00-002'),
                   (3, 'Poznan', 'DEF', '3', '00-003'),
                   (4, 'Gdansk', 'GHI', '4', '00-004'),
                   (5, 'Krakow', 'JKL', '5', '00-005'),
                   (6, 'Gdynia', 'MNO', '6', '00-006'),
                   (7, 'Sopot', 'PRS', '7', '00-007'),
                   (8, 'Bialystok', 'TUW', '8', '00-008'),
                   (9, 'Rzeszow', 'XYZ', '9', '00-009');


insert into patient (id, DATE_OF_BIRTH, EMAIL, FIRST_NAME, LAST_NAME, PATIENT_NUMBER, TELEPHONE_NUMBER, ADDRESS_ID, IS_ADULT)
            values (1, '1990-01-01', 'elo.cotam@wp.pl', 'Jan', 'Kowalski1', '123456789', '123456789', 1, false),
                   (2, '1990-01-02', 'elo.cotam@wp.pl', 'Jan', 'Kowalski2', '223456789', '123456789', 2, true),
                   (3, '1990-01-02', 'elo.cotam@wp.pl', 'Jan', 'Kowalski3', '323456789', '123456789', 3, false),
                   (4, '1990-01-02', 'elo.cotam@wp.pl', 'Jan', 'Kowalski4', '423456789', '123456789', 4, false);

insert into doctor(id, DOCTOR_NUMBER, EMAIL, FIRST_NAME, LAST_NAME, SPECIALIZATION, TELEPHONE_NUMBER, ADDRESS_ID)
            values (1, '123456789', 'elo.cotam@wp.pl', 'Krzysztof', 'Nowak1', 'SURGEON', '123456789', 5),
                   (2, '123456789', 'elo.cotam@wp.pl', 'Marian', 'Nowak2', 'GP', '123456789', 6),
                   (3, '123456789', 'elo.cotam@wp.pl', 'Mariusz', 'Nowak3', 'DERMATOLOGIST', '123456789', 7),
                   (4, '123456789', 'elo.cotam@wp.pl', 'Tomasz', 'Nowak4', 'OCULIST', '123456789', 8),
                   (6, '123456789', 'elo.cotam@wp.pl', 'Karol', 'Nowak5', 'OCULIST', '123456789', 9);

insert into visit (id, DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID)
            values (1, 'Some visit1', '2020-01-01 12:00:00', 1, 1),
                   (2, 'Some visit2', '2021-01-02 12:00:00', 2, 1),
                   (3, 'Some visit3', '2022-01-03 12:00:00', 1, 2),
                   (4, 'Some visit4', '2023-01-04 12:00:00', 4, 4);


insert into medical_treatment (id, description, type, visit_id)
values (1, 'Some treatment1', 'USG', 1),
       (2, 'Some treatment2', 'EKG', 1),
       (3, 'Some treatment3', 'RTG', 2),
       (4, 'Some treatment4', 'USG', 2),
       (5, 'Some treatment5', 'EKG', 3),
       (6, 'Some treatment6', 'RTG', 3),
       (7, 'Some treatment7', 'USG', 4),
       (8, 'Some treatment8', 'EKG', 4),
       (9, 'Some treatment9', 'RTG', 4);

