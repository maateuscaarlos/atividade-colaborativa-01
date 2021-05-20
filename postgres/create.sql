CREATE TABLE integrante
(
  id integer NOT NULL,
  datadenascimento date,
  nome character varying(255),
  cpf character varying(255),
  CONSTRAINT integrante_pkey PRIMARY KEY (id)
);
CREATE TABLE banda
(
  id integer NOT NULL,
  localdeorigem character varying(255),
  nomefantasia character varying(255),
  CONSTRAINT banda_pkey PRIMARY KEY (id)
);
CREATE TABLE gerente
(
  id integer NOT NULL,
  email character varying(255),
  nome character varying(255),
  cpf character varying(255),
  banda_id integer,
  CONSTRAINT gerente_pkey PRIMARY KEY (id),
  CONSTRAINT fk_gerente_banda_id FOREIGN KEY (banda_id)
      REFERENCES public.banda (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE banda_integrante
(
  banda_id integer NOT NULL,
  integrantes_id integer NOT NULL,
  CONSTRAINT banda_integrante_pkey PRIMARY KEY (banda_id, integrantes_id),
  CONSTRAINT fk_banda_integrante_banda_id FOREIGN KEY (banda_id)
      REFERENCES public.banda (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_banda_integrante_integrantes_id FOREIGN KEY (integrantes_id)
      REFERENCES public.integrante (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE sequence
(
  seq_name character varying(50) NOT NULL,
  seq_count numeric(38,0),
  CONSTRAINT sequence_pkey PRIMARY KEY (seq_name)
);