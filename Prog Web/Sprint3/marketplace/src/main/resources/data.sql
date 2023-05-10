INSERT INTO Comprador
    (nome, email, senha)
VALUES
    ('João Silva', 'joao@example.com', 'senha123'),
    ('Maria Santos', 'maria@example.com', 'senha456'),
    ('Pedro Almeida', 'pedro@example.com', 'senha789'),
    ('Ana Oliveira', 'ana@example.com', 'senha321'),
    ('Luiza Ferreira', 'luiza@example.com', 'senha987');

INSERT INTO Produto
    (nome, descricao, preco, quantidade)
VALUES
    ('Celular XYZ', 'Smartphone com câmera de alta resolução', 999.99, 10),
    ('Notebook ABC', 'Notebook leve e potente para trabalho', 1499.99, 5),
    ('TV LED', 'Televisão de alta definição com tela LED', 699.99, 8),
    ('Fone de Ouvido', 'Fone sem fio com cancelamento de ruído', 199.99, 20),
    ('Câmera DSLR', 'Câmera profissional com lentes intercambiáveis', 1999.99, 3);

INSERT INTO avaliacao_comprador_produto
    (comprador_id, produto_id, nota, comentario)
VALUES
    (1, 1, 4, 'Ótimo produto, estou muito satisfeito!'),
    (2, 2, 5, 'O notebook superou minhas expectativas, recomendo!'),
    (3, 3, 3, 'A TV tem boa qualidade de imagem, mas o som poderia ser melhor.'),
    (4, 4, 4, 'O fone de ouvido possui ótima qualidade sonora.'),
    (5, 5, 2, 'A câmera é excelente, mas o preço é alto.');
