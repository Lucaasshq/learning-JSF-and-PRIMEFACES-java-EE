insert into ramo_atividade (id, descricao) values
(1, 'Distribuição de alimentos'),
(2, 'Telecomunicações'),
(3, 'Vestuário'),
(4, 'Lavanderia'),
(5, 'Gráfica'),
(6, 'Mecânica'),
(7, 'Turismo'),
(8, 'Saúde'),
(9, 'Educação'),
(10, 'Lazer');

-- Inserindo dados na tabela empresa com o valor correto do Enum
insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id) values 
(1, '70.311.193/0001-87', 'Pendente_nome_1', 'Razão Social 1', 'MEI', '2022-01-01', 1),
(2, '52.822.994/0001-25', 'Pendente_nome_2', 'Razão Social 2', 'EIRELI', '2021-05-15', 2),
(3, '41.952.519/0001-57', 'Pendente_nome_3', 'Razão Social 3', 'LTDA', '2020-07-20', 3),
(4, '16.134.777/0001-89', 'Pendente_nome_4', 'Razão Social 4', 'SA', '2019-03-10', 4);
