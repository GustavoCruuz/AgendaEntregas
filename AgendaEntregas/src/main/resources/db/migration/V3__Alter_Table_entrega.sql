ALTER TABLE public.entrega
    OWNER TO postgres;

ALTER TABLE public.entrega
    ADD COLUMN finalizada BOOLEAN NOT NULL DEFAULT FALSE;
