DROP DATABASE IF EXISTS benchmarksql CASCADE;

CREATE DATABASE benchmarksql;

CREATE TABLE benchmarksql.materias(
	m_sigla		varchar(10) NOT null,
	m_nombre	varchar(25) NOT null,
	m_creditos	integer NOT null
) engine=innodb;

CREATE TABLE benchmarksql.grupos(
	g_m_id		varchar(10) NOT NULL,
	g_id		integer NOT NULL,
	g_numero	integer NOT NULL,
) engine=innodb;

CREATE TABLE benchmarksql.estudiantes(
	e_id		integer NOT NULL,
	e_nombre	varchar(25) NOT NULL,
	e_apellidos	varchar(25) NOT NULL,
	e_correo	varchar(50),
	e_semestre	integer NOT NULL
) engine=innodb;

CREATE TABLE benchmarksql.salones(
	s_id		integer NOT NULL,
	s_edificio	varchar(1) NOT NULL,
	s_numero	integer
) engine=innodb;

CREATE TABLE benchmarksql.salongrupo(
	sg_s_id		integer NOT NULL,
	sg_g_id		integer NOT NULL
) engine=innodb;

CREATE TABLE benchmarksql.grupoestudiante(
	ge_e_id		integer NOT NULL,
	ge_g_id		integer NOT NULL
) engine=innodb;