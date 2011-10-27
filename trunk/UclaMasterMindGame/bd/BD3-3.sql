--
-- PostgreSQL database dump
--

-- Started on 2011-10-27 17:57:29 VET

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 451 (class 2612 OID 17468)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 140 (class 1259 OID 17469)
-- Dependencies: 6
-- Name: dificultad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dificultad (
    id character varying NOT NULL,
    tamano_combinacion integer NOT NULL,
    numero_intentos integer NOT NULL,
    numero_colores integer NOT NULL,
    nombre text NOT NULL,
    estatus "char"
);


ALTER TABLE public.dificultad OWNER TO postgres;

--
-- TOC entry 141 (class 1259 OID 17475)
-- Dependencies: 6
-- Name: intento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE intento (
    intento character varying NOT NULL,
    partida character varying NOT NULL,
    numero integer NOT NULL
);


ALTER TABLE public.intento OWNER TO postgres;

--
-- TOC entry 142 (class 1259 OID 17481)
-- Dependencies: 6
-- Name: jugador; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE jugador (
    id character varying NOT NULL,
    nombre character varying NOT NULL
);


ALTER TABLE public.jugador OWNER TO postgres;

--
-- TOC entry 143 (class 1259 OID 17487)
-- Dependencies: 6
-- Name: partida; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE partida (
    jugador character varying NOT NULL,
    dificultad character varying NOT NULL,
    tiempo integer NOT NULL,
    combinacion_colores character varying NOT NULL,
    id character varying NOT NULL,
    numero_intentos integer NOT NULL,
    fecha date NOT NULL
);


ALTER TABLE public.partida OWNER TO postgres;

--
-- TOC entry 1793 (class 0 OID 17469)
-- Dependencies: 140
-- Data for Name: dificultad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dificultad (id, tamano_combinacion, numero_intentos, numero_colores, nombre, estatus) FROM stdin;
2	4	13	5	Intermedio	a
3	4	14	6	Avanzado	a
1	4	12	4	Basico	a
\.


--
-- TOC entry 1794 (class 0 OID 17475)
-- Dependencies: 141
-- Data for Name: intento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY intento (intento, partida, numero) FROM stdin;
-15692993-15357675-5243146-3772675	P1	0
\.


--
-- TOC entry 1795 (class 0 OID 17481)
-- Dependencies: 142
-- Data for Name: jugador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY jugador (id, nombre) FROM stdin;
ElamT	Elam
adr	mi
adri	adriana
fer	fernando
tt	fernando
Adri	Adriana
fenix	luis
\.


--
-- TOC entry 1796 (class 0 OID 17487)
-- Dependencies: 143
-- Data for Name: partida; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY partida (jugador, dificultad, tiempo, combinacion_colores, id, numero_intentos, fecha) FROM stdin;
fenix	1	57	-15692993-15357675-5243146-3772675	P1	1	2011-10-27
\.


--
-- TOC entry 1783 (class 2606 OID 17494)
-- Dependencies: 140 140
-- Name: dificultad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dificultad
    ADD CONSTRAINT dificultad_pkey PRIMARY KEY (id);


--
-- TOC entry 1785 (class 2606 OID 17518)
-- Dependencies: 141 141 141
-- Name: intento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY intento
    ADD CONSTRAINT intento_pkey PRIMARY KEY (partida, numero);


--
-- TOC entry 1787 (class 2606 OID 17498)
-- Dependencies: 142 142
-- Name: jugador_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY jugador
    ADD CONSTRAINT jugador_pkey PRIMARY KEY (id);


--
-- TOC entry 1789 (class 2606 OID 17500)
-- Dependencies: 143 143
-- Name: partida_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY partida
    ADD CONSTRAINT partida_pkey PRIMARY KEY (id);


--
-- TOC entry 1790 (class 2606 OID 17519)
-- Dependencies: 141 143 1788
-- Name: intento_partida_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY intento
    ADD CONSTRAINT intento_partida_fkey FOREIGN KEY (partida) REFERENCES partida(id);


--
-- TOC entry 1791 (class 2606 OID 17506)
-- Dependencies: 143 1782 140
-- Name: partida_dificultad_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY partida
    ADD CONSTRAINT partida_dificultad_fkey FOREIGN KEY (dificultad) REFERENCES dificultad(id);


--
-- TOC entry 1792 (class 2606 OID 17511)
-- Dependencies: 1786 142 143
-- Name: partida_jugador_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY partida
    ADD CONSTRAINT partida_jugador_fkey FOREIGN KEY (jugador) REFERENCES jugador(id);


--
-- TOC entry 1801 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2011-10-27 17:57:29 VET

--
-- PostgreSQL database dump complete
--

