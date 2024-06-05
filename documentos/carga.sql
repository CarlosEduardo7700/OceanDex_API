INSERT INTO OD_ESPECIE (ID_ESPECIE, NM_ESPECIE, DESC_ESPECIE, DT_CADASTRO)
VALUES (101, 'Golfinhos', 'Os golfinhos são mamíferos marinhos conhecidos por sua inteligência e comportamento social complexo.', to_date('2024-06-04', 'YYYY-MM-DD'));

INSERT INTO OD_DIETA (ID_DIETA, NM_DIETA, DESC_DIETA)
VALUES (101, 'Peixes e invertebrados marinhos', 'Os peixes frequentemente consumidos incluem sardinhas, anchovas, arenques e atuns, enquanto os invertebrados marinhos podem incluir lulas, polvos, camarões, caranguejos e diversos tipos de moluscos.');



INSERT INTO OD_ESPECIE (ID_ESPECIE, NM_ESPECIE, DESC_ESPECIE, DT_CADASTRO)
VALUES (102, 'Cheloniidae', 'Cheloniidae é uma família de tartarugas marinhas que inclui várias espécies conhecidas. Elas desempenham um papel crucial nos ecossistemas marinhos, especialmente em recifes de coral e leitos de ervas marinhas.', to_date('2024-06-05', 'YYYY-MM-DD'));

INSERT INTO OD_DIETA (ID_DIETA, NM_DIETA, DESC_DIETA)
VALUES (102, 'Herbívora', 'A dieta herbívora é composta principalmente por plantas, incluindo folhas, frutos, flores, sementes e cascas.');




INSERT INTO OD_ANIMAL (ID_ANIMAL, ID_DIETA, ID_ESPECIE, NM_ANIMAL, NM_CIENTIFICO_ANIMAL, DESC_ANIMAL, STATUS_ANIMAL, IMG_ANIMAL, DT_CAD_ANIMAL)
VALUES (101, 101, 101, 'Golfinho-nariz-de-garrafa', 'Tursiops truncatus', 'Caracteriza-se por seu bico curto e robusto, além de uma coloração que varia do cinza escuro nas costas ao branco no ventre.', 'Menos Preocupante', 'caminho/para/a/imagem.png', to_date('2024-06-04', 'YYYY-MM-DD'));

INSERT INTO OD_HABITAT (ID_HABITAT, NM_HABITAT, DESC_HABITAT, CLIMA_HABITAT, VEG_HABITAT, REGIAO_HABITAT, DT_CADASTRO)
VALUES (101, 'Águas temperadas e tropicais', 'Caracterizadas por temperaturas moderadas a quentes durante todo o ano, proporcionando um ambiente favorável para uma ampla diversidade de vida marinha.', 'Temperado e Tropical', 'Marinha, incluindo algas e ervas marinhas', 'Distribuído globalmente em águas temperadas e tropicais', to_date('2024-06-04', 'YYYY-MM-DD'));

INSERT INTO OD_HABITAT_ANIMAL (ID_HABITAT, ID_ANIMAL)
VALUES (101, 101);

INSERT INTO OD_USUARIO (ID_USUARIO, NM_USUARIO, EMAIL_USUARIO, SENHA_USUARIO, IMG_USUARIO, DT_CADASTRO)
VALUES (101, 'Isabella Santos', 'isabella.santos@email.com', 'allebasi@3586', 'caminho/para/a/imagem.png', to_date('2024-06-04', 'YYYY-MM-DD'));

INSERT INTO OD_IDENTIFICACAO_ANIMAL (ID_USUARIO_ANIMAL, ID_USUARIO, ID_ANIMAL)
VALUES (101, 101, 101);



