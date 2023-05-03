    INSERT INTO cliente
    (nome)
VALUES
    ('David Lucca'),
    ('Gustavo Henrique'),
    ('Henrique Yuzo'),
    ('Matheus Rosa'),
    ('Matheus Felix'),
    ('Maciel Victor');

INSERT INTO pedido
    (descricao, valor, cliente_id, finalizado)
VALUES
    ('Café', 7.0 , 1,  true),
    ('Água', 5.0 , 2,  false),
    ('Pão', 9.0 , 3,  false),
    ('Refrigerante', 6.0 , 4,  false),
    ('Pão de queijo', 9.0 , 5,  true),
    ('Leite', 12.0 , 6,  true);
