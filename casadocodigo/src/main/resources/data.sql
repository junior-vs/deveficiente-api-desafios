
INSERT INTO public.autor(
	autorid, autor_email, autor_nome, descricao, ts_alteracao)
	VALUES (1, 'CeciliaMeireles@emai.com', 'Cecilia Meireles', 'autora: Cecília Meireles', current_timestamp);
	
INSERT INTO public.autor(
	autorid, autor_email, autor_nome, descricao, ts_alteracao)
	VALUES (2, 'MachadoAssis@emai.com', 'Machado de Assis', 'Autor Machado de Assis', current_timestamp);

	INSERT INTO public.autor(
	autorid, autor_email, autor_nome, descricao, ts_alteracao)
	VALUES (3, 'albertosouza@emai.com', 'Alberto Souzas', 'Alberto sSouzas', current_timestamp);

	
INSERT INTO public.categoria(
	categoraid, instante_alteracao, nome)
	VALUES (1, current_timestamp, 'Romance');
	
INSERT INTO public.categoria(
	categoraid, instante_alteracao, nome)
	VALUES (2, current_timestamp, 'Ficção Cientifica');
	
INSERT INTO public.livro(
	livroid, dt_publicacao, isbn, nu_pagina, preco, resumo, sumario, titulo, autorid, categoraid)
	VALUES (1, TO_DATE('01-01-1872','dd-MM-yyyy'), 'isbn1', 390, 39.00, 'apenas um resumo', 'capitulo1', 'Ressurreição ', 1, 1);

INSERT INTO public.livro(
	livroid, dt_publicacao, isbn, nu_pagina, preco, resumo, sumario, titulo, autorid, categoraid)
	VALUES (3, TO_DATE('01-01-2020','dd-MM-yyyy'), 'isbn2', 490, 29.00, 'apenas um resumo', 'capitulo1', 'Dev ', 1, 2);