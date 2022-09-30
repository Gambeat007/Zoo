INSERT INTO AREA (id, name)
VALUES
(1, 'Herbivores: small animals'),
(2, 'Herbivores: big animals'),
(3, 'Carnivores: small animals'),
(4, 'Carnivores: big animals');

INSERT INTO ANIMAL (id, name, kind, food, area_id)
VALUES
(1, 'Lionel', 'LION', 11, 4),
(2, 'Dumbino', 'ELEPHANT', 20, 2),
(3, 'Rabitto', 'RABBIT', 4, 1),
(4, 'Emanuel', 'ELEPHANT', 20, 2),
(5, 'Carotto', 'RABBIT', 4, 1),
(6, 'Emanuel', 'RABBIT', 4, 1);