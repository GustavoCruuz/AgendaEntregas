CREATE TABLE public.entrega (
    id bigint NOT NULL,
    nome_cliente character varying(80) NOT NULL,
    numero_cliente bigint NOT NULL,
    endereco character varying(255) NOT NULL,
    data_entrega timestamp(6) without time zone NOT NULL,
    items character varying(255) NOT NULL
);
