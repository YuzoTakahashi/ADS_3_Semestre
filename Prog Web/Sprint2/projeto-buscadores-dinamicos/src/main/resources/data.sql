INSERT INTO diretor
(nome)
VALUES
('Steven Spielberg'),
('Christopher Nolan'),
('Quentin Tarantino'),
('Alfred Hitchcock'),
('Martin Scorsese');
INSERT INTO filme
(nome, diretor_id, data_lancamento, custo_producao, indicacao_oscar)
VALUES
('Jurassic Park', 1, '1993-06-11', 63000000, true),
('The Dark Knight', 2, '2008-07-18', 185000000, true),
('Pulp Fiction', 3, '1994-10-14', 8000000, true),
('Psycho', 4, '1960-09-08', 806947, true),
('The Departed', 5, '2006-10-06', 90000000, true),
('Jaws', 1, '1975-06-20', 12000000, true),
('Inception', 2, '2010-07-16', 160000000, true),
('Django Unchained', 3, '2012-12-25', 100000000, true),
('Vertigo', 4, '1958-05-28', 2470000, true),
('Goodfellas', 5, '1990-09-19', 25000000, true);